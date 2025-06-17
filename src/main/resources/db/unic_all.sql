SET session_replication_role = replica;

DROP TABLE IF EXISTS user_test_answers CASCADE;
DROP TABLE IF EXISTS user_section_status CASCADE;
DROP TABLE IF EXISTS user_progress CASCADE;
DROP TABLE IF EXISTS test_questions CASCADE;
DROP TABLE IF EXISTS practice_tasks CASCADE;
DROP TABLE IF EXISTS lecture_contents CASCADE;
DROP TABLE IF EXISTS lesson_sections CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS users CASCADE;

DROP SEQUENCE IF EXISTS test_questions_id_seq CASCADE;
DROP SEQUENCE IF EXISTS practice_tasks_id_seq CASCADE;
DROP SEQUENCE IF EXISTS lesson_sections_id_seq CASCADE;
DROP SEQUENCE IF EXISTS lessons_id_seq CASCADE;
DROP SEQUENCE IF EXISTS courses_id_seq CASCADE;
DROP SEQUENCE IF EXISTS users_id_seq CASCADE;

SET session_replication_role = DEFAULT;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP
);

CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    difficulty_level SMALLINT NOT NULL CHECK (difficulty_level BETWEEN 1 AND 5),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE lessons (
    id SERIAL PRIMARY KEY,
    course_id INTEGER NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    title VARCHAR(100) NOT NULL,
    order_index SMALLINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE lesson_sections (
    id SERIAL PRIMARY KEY,
    lesson_id INTEGER NOT NULL REFERENCES lessons(id) ON DELETE CASCADE,
    section_type VARCHAR(8) NOT NULL CHECK (section_type IN ('lecture', 'practice', 'test')),
    order_index SMALLINT NOT NULL
);

CREATE TABLE lecture_contents (
    section_id INTEGER PRIMARY KEY REFERENCES lesson_sections(id) ON DELETE CASCADE,
    content JSONB NOT NULL
);

CREATE TABLE practice_tasks (
    id SERIAL PRIMARY KEY,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    question TEXT NOT NULL,
    solution TEXT NOT NULL,
    order_index SMALLINT NOT NULL
);

CREATE TABLE test_questions (
    id SERIAL PRIMARY KEY,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    question TEXT NOT NULL,
    options JSONB NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    order_index SMALLINT NOT NULL
);

CREATE TABLE user_progress (
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    course_id INTEGER NOT NULL REFERENCES courses(id) ON DELETE CASCADE,
    completion_percentage SMALLINT NOT NULL DEFAULT 0 CHECK (completion_percentage BETWEEN 0 AND 100),
    correctness_percentage SMALLINT NOT NULL DEFAULT 0 CHECK (correctness_percentage BETWEEN 0 AND 100),
    last_accessed TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, course_id)
);

CREATE TABLE user_section_status (
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    is_completed BOOLEAN NOT NULL DEFAULT false,
    completed_at TIMESTAMP,
    PRIMARY KEY (user_id, section_id)
);

CREATE TABLE user_test_answers (
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    question_id INTEGER NOT NULL REFERENCES test_questions(id) ON DELETE CASCADE,
    answer CHAR(1) NOT NULL,
    is_correct BOOLEAN NOT NULL,
    answered_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, question_id)
);

CREATE INDEX idx_lessons_course ON lessons(course_id);
CREATE INDEX idx_sections_lesson ON lesson_sections(lesson_id);
CREATE INDEX idx_progress_user ON user_progress(user_id);
CREATE INDEX idx_progress_course ON user_progress(course_id);
CREATE INDEX idx_practice_section ON practice_tasks(section_id);
CREATE INDEX idx_questions_section ON test_questions(section_id);
CREATE INDEX idx_user_sections ON user_section_status(user_id);
CREATE INDEX idx_test_answers_user ON user_test_answers(user_id);

CREATE OR REPLACE FUNCTION update_course_timestamp()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_course_modified
BEFORE UPDATE ON courses
FOR EACH ROW
EXECUTE FUNCTION update_course_timestamp();

COMMENT ON TABLE users IS 'Пользователи системы';
COMMENT ON TABLE courses IS 'Обучающие курсы';
COMMENT ON TABLE lessons IS 'Уроки в составе курсов';
COMMENT ON TABLE lesson_sections IS 'Секции уроков (лекция/практика/тест)';
COMMENT ON TABLE lecture_contents IS 'Контент лекционных разделов';
COMMENT ON TABLE practice_tasks IS 'Практические задания';
COMMENT ON TABLE test_questions IS 'Тестовые вопросы';
COMMENT ON TABLE user_progress IS 'Прогресс пользователей по курсам';
COMMENT ON TABLE user_section_status IS 'Статус прохождения секций';
COMMENT ON TABLE user_test_answers IS 'Ответы пользователей на тестовые вопросы';
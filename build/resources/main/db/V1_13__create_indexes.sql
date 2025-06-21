CREATE INDEX idx_lessons_course ON lessons(course_id);
CREATE INDEX idx_sections_lesson ON lesson_sections(lesson_id);
CREATE INDEX idx_progress_user ON user_progress(user_id);
CREATE INDEX idx_progress_course ON user_progress(course_id);
CREATE INDEX idx_practice_section ON practice_tasks(section_id);
CREATE INDEX idx_questions_section ON test_questions(section_id);
CREATE INDEX idx_user_sections ON user_section_status(user_id);
CREATE INDEX idx_test_answers_user ON user_test_answers(user_id);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_courses_genre ON courses(genre);
CREATE INDEX idx_lessons_order ON lessons(order_index);
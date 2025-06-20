CREATE TABLE test_questions (
    id SERIAL PRIMARY KEY,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    question TEXT NOT NULL,
    options JSONB NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    order_index SMALLINT NOT NULL
);
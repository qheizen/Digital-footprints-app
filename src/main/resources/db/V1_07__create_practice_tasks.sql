CREATE TABLE practice_tasks (
    id SERIAL PRIMARY KEY,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    question TEXT NOT NULL,
    solution TEXT NOT NULL,
    order_index SMALLINT NOT NULL
);
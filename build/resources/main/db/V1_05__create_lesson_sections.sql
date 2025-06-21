CREATE TABLE lesson_sections (
    id SERIAL PRIMARY KEY,
    lesson_id INTEGER NOT NULL REFERENCES lessons(id) ON DELETE CASCADE,
    section_type VARCHAR(8) NOT NULL CHECK (section_type IN ('lecture', 'practice', 'test')),
    order_index SMALLINT NOT NULL
);
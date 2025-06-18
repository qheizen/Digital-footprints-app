CREATE TABLE lecture_contents (
    section_id INTEGER PRIMARY KEY REFERENCES lesson_sections(id) ON DELETE CASCADE,
    content JSONB NOT NULL
);
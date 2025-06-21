CREATE TABLE user_section_status (
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    section_id INTEGER NOT NULL REFERENCES lesson_sections(id) ON DELETE CASCADE,
    is_completed BOOLEAN NOT NULL DEFAULT false,
    completed_at TIMESTAMP,
    PRIMARY KEY (user_id, section_id)
);
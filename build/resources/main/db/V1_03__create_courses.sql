CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    key_word VARCHAR(50) NOT NULL,
    difficulty_level SMALLINT NOT NULL CHECK (difficulty_level BETWEEN 1 AND 64),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);
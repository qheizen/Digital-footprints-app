CREATE TABLE skill_matrix (
    matrix_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID NOT NULL REFERENCES "user"(user_id),
    skill_domain VARCHAR(100) NOT NULL,
    skill_level INT CHECK (skill_level BETWEEN 1 AND 10),
    last_updated TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(user_id, skill_domain)
);
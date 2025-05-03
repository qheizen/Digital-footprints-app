CREATE TABLE practical_content (
    practical_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    max_attempts INT DEFAULT 3,
    success_threshold FLOAT DEFAULT 0.7,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE task (
    task_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    practical_id UUID NOT NULL REFERENCES practical_content(practical_id) ON DELETE CASCADE,
    description TEXT NOT NULL,
    instructions TEXT NOT NULL,
    solution_code TEXT,
    expected_output TEXT,
    task_order INT NOT NULL,
    UNIQUE(practical_id, task_order)
);
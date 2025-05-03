CREATE TABLE test_content (
    test_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    passing_score INT NOT NULL,
    time_limit FLOAT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE question (
    question_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    test_id UUID REFERENCES test_content(test_id) ON DELETE CASCADE,
    question_text TEXT NOT NULL,
    type QuestionType NOT NULL,
    max_score INT NOT NULL,
    correct_answers JSONB,
    question_order INT NOT NULL,
    UNIQUE(test_id, question_order)
);

CREATE TABLE question_option (
    option_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    question_id UUID REFERENCES question(question_id) ON DELETE CASCADE,
    option_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    option_order INT NOT NULL,
    UNIQUE(question_id, option_order)
);
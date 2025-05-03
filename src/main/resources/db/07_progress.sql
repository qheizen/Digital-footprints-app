CREATE TABLE lesson_progress (
    progress_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    lesson_id UUID NOT NULL REFERENCES lesson(lesson_id),
    user_id UUID NOT NULL REFERENCES "user"(user_id),
    is_lecture_completed BOOLEAN DEFAULT FALSE,
    is_practical_completed BOOLEAN DEFAULT FALSE,
    practical_score INT,
    is_test_completed BOOLEAN DEFAULT FALSE,
    test_score INT,
    last_updated TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(lesson_id, user_id)
);

CREATE TABLE course_progress (
    course_progress_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    course_id UUID NOT NULL REFERENCES course(course_id),
    user_id UUID NOT NULL REFERENCES "user"(user_id),
    completion_status CompletionStatus DEFAULT 'NOT_STARTED',
    final_score FLOAT,
    last_updated TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(course_id, user_id)
);
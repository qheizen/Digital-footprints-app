CREATE TABLE lesson (
    lesson_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    course_id UUID NOT NULL REFERENCES course(course_id),
    lesson_order INT NOT NULL,
    lecture_id UUID REFERENCES lecture_content(lecture_id),
    practical_id UUID REFERENCES practical_content(practical_id),
    test_id UUID REFERENCES test_content(test_id),
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(course_id, lesson_order)
);

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
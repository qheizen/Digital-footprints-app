CREATE TABLE lesson (
    lesson_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    course_id UUID NOT NULL REFERENCES course(course_id),
    lesson_order INT NOT NULL,
    lecture_id UUID REFERENCES lecture_content(lecture_id),
    practical_id UUID REFERENCES practical_content(practical_id),
    test_id UUID REFERENCES test_content(test_id),
    print_grid_content INT DEFAULT 0,
    jetsconle UUID,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(course_id, lesson_order)
);
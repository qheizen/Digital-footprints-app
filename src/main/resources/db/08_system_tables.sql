CREATE TABLE content_validation (
    validation_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    content_type ContentType NOT NULL,
    content_id UUID NOT NULL,
    is_valid BOOLEAN DEFAULT FALSE,
    validation_errors JSONB,
    validated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    validator VARCHAR(255) NOT NULL
);

CREATE TABLE course_factory_log (
    log_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    operation_type VARCHAR(50) CHECK (operation_type IN ('CREATE_FROM_XML', 'UPDATE')),
    course_id UUID REFERENCES course(course_id),
    xml_content TEXT NOT NULL,
    status VARCHAR(50) NOT NULL,
    error_message TEXT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
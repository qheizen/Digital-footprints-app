CREATE TABLE lecture_content (
    lecture_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cache JSONB,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE text_block (
    text_block_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    lecture_id UUID NOT NULL REFERENCES lecture_content(lecture_id) ON DELETE CASCADE,
    content TEXT NOT NULL,
    format_type VARCHAR(50) DEFAULT 'PLAIN',
    block_order INT NOT NULL,
    UNIQUE(lecture_id, block_order)
);

CREATE TABLE video (
    video_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    lecture_id UUID NOT NULL REFERENCES lecture_content(lecture_id) ON DELETE CASCADE,
    url VARCHAR(512) NOT NULL,
    duration INT,
    caption TEXT,
    video_order INT NOT NULL,
    UNIQUE(lecture_id, video_order)
);

CREATE TABLE image (
    image_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    lecture_id UUID NOT NULL REFERENCES lecture_content(lecture_id) ON DELETE CASCADE,
    url VARCHAR(512) NOT NULL,
    alt_text VARCHAR(255),
    image_order INT NOT NULL,
    UNIQUE(lecture_id, image_order)
);

CREATE TABLE code_snippet (
    snippet_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    lecture_id UUID NOT NULL REFERENCES lecture_content(lecture_id) ON DELETE CASCADE,
    code TEXT NOT NULL,
    language VARCHAR(50) NOT NULL,
    explanation TEXT,
    snippet_order INT NOT NULL,
    UNIQUE(lecture_id, snippet_order)
);
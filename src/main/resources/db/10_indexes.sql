CREATE INDEX idx_lesson_course ON lesson(course_id);
CREATE INDEX idx_lesson_order ON lesson(lesson_order);
CREATE INDEX idx_progress_user ON lesson_progress(user_id);
CREATE INDEX idx_progress_lesson ON lesson_progress(lesson_id);
CREATE INDEX idx_question_test ON question(test_id);
CREATE INDEX idx_factory_log_course ON course_factory_log(course_id);
COMMENT ON TABLE users IS 'Зарегистрированные пользователи системы';
COMMENT ON TABLE courses IS 'Обучающие курсы с метаданными';
COMMENT ON TABLE lessons IS 'Уроки, входящие в состав курсов';
COMMENT ON TABLE lesson_sections IS 'Секции уроков (лекция/практика/тест)';
COMMENT ON TABLE lecture_contents IS 'Содержимое лекционных разделов';
COMMENT ON TABLE practice_tasks IS 'Практические задания для отработки навыков';
COMMENT ON TABLE test_questions IS 'Тестовые вопросы для проверки знаний';
COMMENT ON TABLE user_progress IS 'Прогресс пользователей по прохождению курсов';
COMMENT ON TABLE user_section_status IS 'Статус прохождения секций пользователями';
COMMENT ON TABLE user_test_answers IS 'Ответы пользователей на тестовые вопросы';

COMMENT ON COLUMN users.password IS 'Хранится только хеш пароля';
COMMENT ON COLUMN courses.difficulty_level IS 'Уровень сложности от 1 (новичок) до 5 (эксперт)';
COMMENT ON COLUMN lesson_sections.order_index IS 'Порядковый номер секции в уроке';
COMMENT ON COLUMN lecture_contents.content IS 'Данные в формате JSON: текст и изображения';
COMMENT ON COLUMN test_questions.options IS 'Варианты ответов в формате JSON';
COMMENT ON COLUMN user_progress.completion_percentage IS 'Процент пройденного материала';
COMMENT ON COLUMN user_progress.correctness_percentage IS 'Процент правильных ответов';
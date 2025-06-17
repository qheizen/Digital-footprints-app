SET session_replication_role = replica;

DROP TABLE IF EXISTS user_test_answers CASCADE;
DROP TABLE IF EXISTS user_section_status CASCADE;
DROP TABLE IF EXISTS user_progress CASCADE;
DROP TABLE IF EXISTS test_questions CASCADE;
DROP TABLE IF EXISTS practice_tasks CASCADE;
DROP TABLE IF EXISTS lecture_contents CASCADE;
DROP TABLE IF EXISTS lesson_sections CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS users CASCADE;

DROP SEQUENCE IF EXISTS users_id_seq CASCADE;
DROP SEQUENCE IF EXISTS courses_id_seq CASCADE;
DROP SEQUENCE IF EXISTS lessons_id_seq CASCADE;
DROP SEQUENCE IF EXISTS lesson_sections_id_seq CASCADE;
DROP SEQUENCE IF EXISTS practice_tasks_id_seq CASCADE;
DROP SEQUENCE IF EXISTS test_questions_id_seq CASCADE;

DROP FUNCTION IF EXISTS update_course_timestamp() CASCADE;

SET session_replication_role = DEFAULT;
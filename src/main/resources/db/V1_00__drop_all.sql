set session_replication_role = replica;

drop table if exists user_roles cascade;
drop table if exists users cascade;
drop table if exists user_status cascade;
drop table if exists keywords cascade;
drop table if exists courses cascade;
drop table if exists user_course_status cascade;
drop table if exists lessons cascade;
drop table if exists lesson_sections cascade;
drop table if exists user_section_status cascade;
drop table if exists lecture_content cascade;
drop table if exists practice_content cascade;
drop table if exists test_options cascade;
drop table if exists test_content cascade;
drop table if exists user_session_logs cascade;

set session_replication_role = default;
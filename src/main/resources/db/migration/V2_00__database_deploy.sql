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

create table user_roles (
	r_id serial primary key,
	r_name varchar(32) unique not null,
	r_permissions bit(4) not null
);

create table users (
	u_id bigserial primary key,
	u_nickname varchar(32) not null,
	u_password varchar(128) not null,
	u_email varchar(64) not null unique,
	u_role serial not null references user_roles(r_id),
	u_created_at timestamp not null default CURRENT_TIMESTAMP,
	u_last_login timestamp not null default CURRENT_TIMESTAMP
);

create table user_session_logs (
	l_id bigserial primary key,
	l_user_id bigserial not null references users(u_id),
	l_session_log text,
	l_created_at timestamp not null default CURRENT_TIMESTAMP
);

create table user_status (
	us_id bigserial primary key,
	us_user_id bigserial not null references users(u_id) on delete cascade,
	us_current_skill numeric(4) not null default 0,
	us_lesson_strike smallint not null default 0,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table keywords (
	k_id bigserial primary key,
	k_word varchar(32) not null unique
);

create table courses (
	c_id bigserial primary key,
	c_title varchar(64) not null unique,
	c_description text not null default 'no description available',
	c_keyword bigserial references keywords(k_id),
	c_difficulty_level numeric(4) not null default 0 check (c_difficulty_level between 1 and 32),
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table user_course_status (
	ucs_id bigserial primary key,
	ucs_user_id bigserial not null references users(u_id),
	ucs_course_id bigserial not null references courses(c_id),
	ucs_completion_percentage integer not null default 0 check (ucs_completion_percentage between 0 and 100),
	ucs_correctness_percentage integer not null default 0 check (ucs_correctness_percentage between 0 and 100),
	constraint unique_user_course unique (ucs_user_id, ucs_course_id)
);

create table lessons (
	l_id bigserial primary key,
	l_course_id bigserial not null references courses(c_id) on delete cascade,
	l_title varchar(128) not null default 'no title here',
	l_description text not null default 'no description available',
	l_order_index integer,
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table lesson_sections (
	ls_id bigserial primary key,
	ls_lesson_id bigserial not null references lessons(l_id) on delete cascade on update cascade,
	ls_section_type varchar(25) not null check (ls_section_type in ('practice', 'lecture', 'test', 'something')),
	ls_order_index integer
);

create table user_section_status (
	uss_id bigserial primary key,
	uss_user_id bigserial not null references users(u_id) on delete cascade,
	uss_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	uss_is_completed boolean not null default false,
	uss_completed_at timestamp,
	constraint unique_user_section unique(uss_user_id, uss_section_id)
);

create table lecture_content (
	lc_section_id bigserial primary key references lesson_sections(ls_id) on delete cascade,
	lc_lecture_content text
);

create table practice_content (
	p_id bigserial primary key,
	p_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	p_task_description text not null default 'no description available',
	p_answer_description text not null default 'no description available',
	p_order_index integer
);

create table test_options (
	qo_id bigserial primary key,
	qo_answer varchar(64) not null
);

create table test_content (
	q_id bigserial primary key,
	q_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	q_question_description text not null default 'no description available',
	q_correct_answer bigserial references test_options(qo_id) on delete cascade
);

create index idx_lessons_course on lessons(l_course_id);
create index idx_section_lesson on lesson_sections(ls_lesson_id);
create index idx_status_user on user_status(us_user_id);
create index idx_user_role on users(u_role);
create index idx_status_course on user_course_status(ucs_course_id);
create index idx_practice_section on practice_content(p_section_id);
create index idx_test_section on test_content(q_section_id);
create index idx_user_sections on user_section_status(uss_user_id);
CREATE INDEX idx_lessons_order ON lessons(l_course_id, l_order_index);
CREATE INDEX idx_sections_order ON lesson_sections(ls_lesson_id, ls_order_index);

create or replace function update_timestamp()
returns trigger as $$
begin
	new.updated_at = CURRENT_TIMESTAMP;
	return new;
end;
$$ language plpgsql;

create trigger lesson_timestamp_update
before update on lessons 
for each row execute function update_timestamp();

create trigger courses_timestamp_update
before update on courses
for each row execute function update_timestamp();

create trigger statuses_timestamp_update
before update on user_status
for each row execute function update_timestamp();

comment on table user_roles is 'Роли для обеспечения доступа';
comment on table users is 'Пользователи системы';
comment on table user_status is 'Профиль и статистика пользователя';
comment on table keywords is 'Ключевые слова для курсов';
comment on table courses is 'Обучающие курсы';
comment on table user_course_status is 'Прогресс изучения курсов';
comment on table lessons is 'Уроки в составе курсов';
comment on table lesson_sections is 'Секции уроков (лекция/практика/тест)';
comment on table user_section_status is 'Статус изучаемых секций';
comment on table lecture_content is 'Контент лекционных разделов';
comment on table practice_content is 'Контент практических разделов';
comment on table test_options is 'Ответы на тесты';
comment on table test_content is 'Контент тестовых разделов';

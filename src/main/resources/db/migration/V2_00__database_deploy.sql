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
	id serial primary key,
	name varchar(32) unique not null,
	permissions bit(4) not null,
	created_at timestamp not null default CURRENT_TIMESTAMP
);

create table users (
	id bigserial primary key,
	username varchar(32) not null,
	password varchar(128) not null,
	email varchar(64) not null unique,
	role_id serial not null references user_roles(id),
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP,
	last_login timestamp not null default CURRENT_TIMESTAMP,
	version INTEGER NOT NULL DEFAULT 0
);

create table user_session_logs (
	id bigserial primary key,
	user_id bigserial not null references users(id),
	session_log text not null,
	created_at timestamp not null default CURRENT_TIMESTAMP
);

create table user_status (
	id bigserial primary key,
	user_id bigserial not null references users(id) on delete cascade,
	current_skill numeric(4) not null default 0,
	lesson_strike smallint not null default 0,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table keywords (
	id bigserial primary key,
	keyword varchar(32) not null unique,
	created_at timestamp not null default CURRENT_TIMESTAMP
);

create table courses (
	id bigserial primary key,
	keyword_id bigserial references keywords(id),
	title varchar(64) not null unique,
	description text not null default 'no description available',
	difficulty_level numeric(4) not null default 0 check (difficulty_level between 1 and 32),
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP,
	version INTEGER NOT NULL DEFAULT 0
);

create table user_course_status (
	id bigserial primary key,
	user_id bigserial not null references users(id),
	course_id bigserial not null references courses(id),
	completion_percentage integer not null default 0 check (completion_percentage between 0 and 100),
	correctness_percentage integer not null default 0 check (correctness_percentage between 0 and 100),
	version INTEGER NOT NULL DEFAULT 0,

	constraint unique_user_course unique (user_id, course_id)
);

create table lessons (
	id bigserial primary key,
	course_id bigserial not null references courses(id) on delete cascade,
	title varchar(128) not null default 'no title here',
	description text not null default 'no description available',
	order_index integer,
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table lesson_sections (
	id bigserial primary key,
	lesson_id bigserial not null references lessons(id) on delete cascade on update cascade,
	section_type varchar(25) not null check (section_type in ('practice', 'lecture', 'test', 'something')),
	order_index integer
);

create table user_section_status (
	id bigserial primary key,
	user_id bigserial not null references users(id) on delete cascade,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	is_completed boolean not null default false,
	completed_at timestamp,

	constraint unique_user_section unique(user_id, section_id)
);

create table lecture_content (
	section_id bigserial primary key references lesson_sections(id) on delete cascade,
	lecture_content text
);

create table practice_content (
	id bigserial primary key,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	task_description text not null default 'no description available',
	answer_description text not null default 'no description available',
	order_index integer
);


create table test_options (
	id bigserial primary key,
	answer varchar(64) not null
);

create table test_content (
	id bigserial primary key,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	question_description text not null default 'no description available',
	correct_answer_id bigserial references test_options(id) on delete cascade
);

create index idx_lessons_course on lessons(course_id);
create index idx_section_lesson on lesson_sections(lesson_id);
create index idx_status_user on user_status(user_id);
create index idx_user_role on users(role_id);
create index idx_status_course on user_course_status(course_id);
create index idx_practice_section on practice_content(section_id);
create index idx_test_section on test_content(section_id);
create index idx_user_sections on user_section_status(user_id);
CREATE INDEX idx_lessons_order ON lessons(course_id, order_index);
CREATE INDEX idx_sections_order ON lesson_sections(lesson_id, order_index);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_username ON users(username);

create or replace function update_timestamp()
returns trigger as $$
begin
	new.updated_at = CURRENT_TIMESTAMP;
	return new;
end;
$$ language plpgsql;

create trigger user_timestamp_update
before update on users
for each row execute function update_timestamp();

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

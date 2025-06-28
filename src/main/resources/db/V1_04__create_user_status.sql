create table user_status (
	us_id bigserial primary key,
	us_user_id bigserial not null references users(u_id) on delete cascade,
	us_current_skill numeric(4) not null default 0,
	us_lesson_strike smallint not null default 0,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);
create table user_status (
	id bigserial primary key,
	user_id bigserial not null references users(id) on delete cascade,
	current_skill numeric(4) not null default 0,
	lesson_strike smallint not null default 0,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);
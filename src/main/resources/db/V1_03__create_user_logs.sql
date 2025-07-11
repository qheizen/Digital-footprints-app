create table user_session_logs (
	id bigserial primary key,
	user_id bigserial not null references users(id),
	session_log text not null,
	created_at timestamp not null default CURRENT_TIMESTAMP
);
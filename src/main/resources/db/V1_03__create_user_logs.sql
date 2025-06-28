create table user_session_logs (
	l_id bigserial primary key,
	l_user_id bigserial not null references users(u_id),
	l_session_log text,
	l_created_at timestamp not null default CURRENT_TIMESTAMP
);
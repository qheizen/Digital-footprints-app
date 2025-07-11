create table keywords (
	id bigserial primary key,
	keyword varchar(32) not null unique,
	created_at timestamp not null default CURRENT_TIMESTAMP
);

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
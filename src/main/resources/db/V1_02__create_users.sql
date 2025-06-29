create table users (
	u_id bigserial primary key,
	u_nickname varchar(32) not null,
	u_password varchar(128) not null,
	u_email varchar(64) not null unique,
	u_role serial not null references user_roles(r_id),
	u_created_at timestamp not null default CURRENT_TIMESTAMP,
	u_last_login timestamp not null default CURRENT_TIMESTAMP
);
create table user_roles (
	id serial primary key,
	name varchar(32) unique not null,
	permissions bit(4) not null,
	created_at timestamp not null default CURRENT_TIMESTAMP
);
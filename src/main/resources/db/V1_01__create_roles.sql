create table user_roles (
	r_id serial primary key,
	r_name varchar(32) unique not null,
	r_permissions bit(4) not null
);
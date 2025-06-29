create table courses (
	c_id bigserial primary key,
	c_title varchar(64) not null unique,
	c_description text not null default 'no description available',
	c_keyword bigserial references keywords(k_id),
	c_difficulty_level numeric(4) not null default 0 check (c_difficulty_level between 1 and 32),
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);
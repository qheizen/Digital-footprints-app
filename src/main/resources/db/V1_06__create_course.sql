create table courses (
	id bigserial primary key,
	keyword_id bigserial references keywords(id),
	title varchar(64) not null unique,
	description text not null default 'no description available',
	difficulty_level numeric(4) not null default 0 check (difficulty_level between 1 and 32),
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP,
	version INTEGER NOT NULL DEFAULT 0
);
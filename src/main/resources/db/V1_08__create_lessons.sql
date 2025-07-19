create table lessons (
	id bigserial primary key,
	course_id bigserial not null references courses(id) on delete cascade,
	title varchar(128) not null default 'no title here',
	description text not null default 'no description available',
	order_index integer,
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);
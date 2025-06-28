create table lessons (
	l_id bigserial primary key,
	l_course_id bigserial not null references courses(c_id) on delete cascade,
	l_title varchar(128) not null default 'no title here',
	l_description text not null default 'no description available',
	l_order_index integer,
	created_at timestamp not null default CURRENT_TIMESTAMP,
	updated_at timestamp not null default CURRENT_TIMESTAMP
);
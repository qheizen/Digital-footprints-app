create table user_course_status (
	id bigserial primary key,
	user_id bigserial not null references users(id),
	course_id bigserial not null references courses(id),
	completion_percentage integer not null default 0 check (completion_percentage between 0 and 100),
	correctness_percentage integer not null default 0 check (correctness_percentage between 0 and 100),
	version INTEGER NOT NULL DEFAULT 0,
	
	constraint unique_user_course unique (user_id, course_id)
);

create table user_course_status (
	ucs_id bigserial primary key,
	ucs_user_id bigserial not null references users(u_id),
	ucs_course_id bigserial not null references courses(c_id),
	ucs_completion_percentage integer not null default 0 check (ucs_completion_percentage between 0 and 100),
	ucs_correctness_percentage integer not null default 0 check (ucs_correctness_percentage between 0 and 100),
	с_version INTEGER NOT NULL DEFAULT 0,

	constraint unique_user_course unique (ucs_user_id, ucs_course_id)
);

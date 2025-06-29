create table user_section_status (
	uss_id bigserial primary key,
	uss_user_id bigserial not null references users(u_id) on delete cascade,
	uss_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	uss_is_completed boolean not null default false,
	uss_completed_at timestamp,
	constraint unique_user_section unique(uss_user_id, uss_section_id)
);
create table user_section_status (
	id bigserial primary key,
	user_id bigserial not null references users(id) on delete cascade,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	is_completed boolean not null default false,
	completed_at timestamp,

	constraint unique_user_section unique(user_id, section_id)
);
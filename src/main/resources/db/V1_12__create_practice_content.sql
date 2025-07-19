create table practice_content (
	id bigserial primary key,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	task_description text not null default 'no description available',
	answer_description text not null default 'no description available',
	order_index integer
);
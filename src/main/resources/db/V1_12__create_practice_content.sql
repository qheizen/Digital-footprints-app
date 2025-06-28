create table practice_content (
	p_id bigserial primary key,
	p_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	p_task_description text not null default 'no description available',
	p_answer_description text not null default 'no description available',
	p_order_index integer
);

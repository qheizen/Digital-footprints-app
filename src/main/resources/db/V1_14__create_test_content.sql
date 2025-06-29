create table test_content (
	q_id bigserial primary key,
	q_section_id bigserial not null references lesson_sections(ls_id) on delete cascade,
	q_question_description text not null default 'no description available',
	q_correct_answer bigserial references test_options(qo_id) on delete cascade
);
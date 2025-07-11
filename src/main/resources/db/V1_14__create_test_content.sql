create table test_content (
	id bigserial primary key,
	section_id bigserial not null references lesson_sections(id) on delete cascade,
	question_description text not null default 'no description available',
	correct_answer_id bigserial references test_options(id) on delete cascade
);
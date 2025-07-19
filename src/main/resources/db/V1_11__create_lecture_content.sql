create table lecture_content (
	section_id bigserial primary key references lesson_sections(id) on delete cascade,
	lecture_content text
);

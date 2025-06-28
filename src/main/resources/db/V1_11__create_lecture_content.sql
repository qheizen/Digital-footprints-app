create table lecture_content (
	lc_section_id bigserial primary key references lesson_sections(ls_id) on delete cascade,
	lc_lecture_content text
);
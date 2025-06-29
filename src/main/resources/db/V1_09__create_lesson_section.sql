create table lesson_sections (
	ls_id bigserial primary key,
	ls_lesson_id bigserial not null references lessons(l_id) on delete cascade on update cascade,
	ls_section_type varchar(25) not null check (ls_section_type in ('practice', 'lecture', 'test', 'something')),
	ls_order_index integer
);
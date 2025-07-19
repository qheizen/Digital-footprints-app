create table lesson_sections (
	id bigserial primary key,
	lesson_id bigserial not null references lessons(id) on delete cascade on update cascade,
	section_type varchar(25) not null check (section_type in ('practice', 'lecture', 'test', 'something')),
	order_index integer
);
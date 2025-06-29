create table keywords (
	k_id bigserial primary key,
	k_word varchar(32) not null unique
);
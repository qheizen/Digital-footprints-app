create or replace function update_timestamp()
returns trigger as $$
begin
	new.updated_at = CURRENT_TIMESTAMP;
	return new;
end;
$$ language plpgsql;

create trigger user_timestamp_update
before update on users
for each row execute function update_timestamp();

create trigger lesson_timestamp_update
before update on lessons
for each row execute function update_timestamp();

create trigger courses_timestamp_update
before update on courses
for each row execute function update_timestamp();

create trigger statuses_timestamp_update
before update on user_status
for each row execute function update_timestamp();
insert into user_roles(name, permissions) values
('ADMIN', B'1111'), ('METHODIST', B'1110'), ('STUDENT', B'0100');

insert into users(username, email, password, role_id) values
('admin', 'admin@gmail.com', md5('admin'), (SELECT id FROM user_roles WHERE name='ADMIN'))
insert into user_roles(r_name, r_permissions) values
('ADMIN', B'1111'), ('METHODIST', B'1110'), ('USER', B'0100');

insert into users(u_nickname, u_email, u_password, u_role) values
('admin', 'admin@gmail.com', md5('admin'), (SELECT r_id FROM user_roles WHERE r_name='ADMIN'))
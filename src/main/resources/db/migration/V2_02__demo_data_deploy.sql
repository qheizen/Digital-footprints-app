insert into users(u_nickname, u_email, u_password, u_role) values
('student_1', 'student1@gmail.com', md5('password'), 3),
('student_2', 'student2@gmail.com', md5('password'), 3),
('methodist_1', 'methodist1@gmail.com', md5('password'), 2),
('methodist_2', 'methodist2@gmail.com', md5('password'), 2);

insert  into keywords (k_word) values ('python'), ('java'), ('c++'), ('something');

INSERT INTO courses (c_title, c_description, c_keyword, c_difficulty_level) VALUES
('Python Basics', 'Introduction to Python programming', 1, 5),
('Java Basics', 'Fundamentals of vectors and matrices', 2, 12),
('C++ Basics', 'User interface design principles', 3, 8),
('Something Basics', 'Advanced English grammar rules', 4, 15);

INSERT INTO user_status (us_user_id, us_current_skill, us_lesson_strike) VALUES
(1, 25, 3),
(2, 8, 5),
(3, 12, 2),
(4, 31, 7);

INSERT INTO lessons (l_course_id, l_title, l_description, l_order_index) VALUES
(1, 'Variables', 'Working with variables in Python', 1),
(1, 'Loops', 'For and while loops', 2),
(2, 'Vectors', 'Vector operations', 1),
(3, 'Color Theory', 'Understanding color palettes', 1);

INSERT INTO lesson_sections (ls_lesson_id, ls_section_type, ls_order_index) VALUES
(1, 'lecture', 1),
(1, 'practice', 2),
(1, 'test', 3),
(2, 'lecture', 1),
(3, 'lecture', 1),
(4, 'something', 1);

INSERT INTO lecture_content (lc_section_id, lc_lecture_content) VALUES
(1, 'Variables are containers for storing data values...'),
(4, 'Loops allow you to execute code repeatedly...'),
(5, 'Vector is a quantity with direction and magnitude...');

INSERT INTO practice_content (p_section_id, p_task_description, p_answer_description, p_order_index) VALUES
(2, 'Create a variable named x and assign value 5', 'x = 5', 1),
(2, 'Create a list with three items', 'my_list = [1, 2, 3]', 2);

INSERT INTO test_options (qo_answer) VALUES
('int'),
('str'),
('list'),
('dict'),
('tuple'),
('for'),
('while'),
('loop');

INSERT INTO test_content (q_section_id, q_question_description, q_correct_answer) VALUES
(3, 'Which type is used for text in Python?', 2),
(3, 'Which loop iterates over a sequence?', 6);

INSERT INTO user_course_status (ucs_user_id, ucs_course_id, ucs_completion_percentage, ucs_correctness_percentage) VALUES
(2, 1, 45, 78),
(3, 1, 20, 65),
(2, 2, 10, 50),
(4, 3, 100, 95);

INSERT INTO user_section_status (uss_user_id, uss_section_id, uss_is_completed, uss_completed_at) VALUES
(2, 1, true, '2023-01-15 10:30:00'),
(2, 2, true, '2023-01-16 11:45:00'),
(3, 1, true, '2023-02-01 14:20:00'),
(4, 5, true, '2023-03-10 09:15:00');

INSERT INTO user_session_logs (l_user_id, l_session_log) VALUES
(1, 'Logged in from 192.168.1.1'),
(2, 'Completed section 1'),
(2, 'Started practice section'),
(3, 'Viewed lecture on variables'),
(4, 'Created new course module');
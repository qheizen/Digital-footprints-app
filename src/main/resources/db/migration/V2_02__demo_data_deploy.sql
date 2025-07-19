INSERT INTO users (username, email, password, role_id) VALUES
('student_1', 'student1@gmail.com', md5('password'), (SELECT id FROM user_roles WHERE name = 'STUDENT')),
('student_2', 'student2@gmail.com', md5('password'), (SELECT id FROM user_roles WHERE name = 'STUDENT')),
('methodist_1', 'methodist1@gmail.com', md5('password'), (SELECT id FROM user_roles WHERE name = 'METHODIST')),
('methodist_2', 'methodist2@gmail.com', md5('password'), (SELECT id FROM user_roles WHERE name = 'METHODIST'));

INSERT INTO keywords (keyword) VALUES
('python'), ('java'), ('c++'), ('something');

INSERT INTO courses (title, description, keyword_id, difficulty_level) VALUES
('Python Basics', 'Introduction to Python programming', (SELECT id FROM keywords WHERE keyword = 'python'), 5),
('Java Basics', 'Fundamentals of vectors and matrices', (SELECT id FROM keywords WHERE keyword = 'java'), 12),
('C++ Basics', 'User interface design principles', (SELECT id FROM keywords WHERE keyword = 'c++'), 8),
('Something Basics', 'Advanced English grammar rules', (SELECT id FROM keywords WHERE keyword = 'something'), 15);

INSERT INTO user_status (user_id, current_skill, lesson_strike) VALUES
((SELECT id FROM users WHERE username = 'student_1'), 25, 3),
((SELECT id FROM users WHERE username = 'student_2'), 8, 5),
((SELECT id FROM users WHERE username = 'methodist_1'), 12, 2),
((SELECT id FROM users WHERE username = 'methodist_2'), 31, 7);

INSERT INTO lessons (course_id, title, description, order_index) VALUES
((SELECT id FROM courses WHERE title = 'Python Basics'), 'Variables', 'Working with variables in Python', 1),
((SELECT id FROM courses WHERE title = 'Python Basics'), 'Loops', 'For and while loops', 2),
((SELECT id FROM courses WHERE title = 'Java Basics'), 'Vectors', 'Vector operations', 1),
((SELECT id FROM courses WHERE title = 'C++ Basics'), 'Color Theory', 'Understanding color palettes', 1);

INSERT INTO lesson_sections (lesson_id, section_type, order_index) VALUES
((SELECT id FROM lessons WHERE title = 'Variables'), 'lecture', 1),
((SELECT id FROM lessons WHERE title = 'Variables'), 'practice', 2),
((SELECT id FROM lessons WHERE title = 'Variables'), 'test', 3),
((SELECT id FROM lessons WHERE title = 'Loops'), 'lecture', 1),
((SELECT id FROM lessons WHERE title = 'Vectors'), 'lecture', 1),
((SELECT id FROM lessons WHERE title = 'Color Theory'), 'something', 1);

INSERT INTO lecture_content (section_id, lecture_content) VALUES
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 1), 'Variables are containers for storing data values...'),
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Loops') AND order_index = 1), 'Loops allow you to execute code repeatedly...'),
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Vectors') AND order_index = 1), 'Vector is a quantity with direction and magnitude...');

INSERT INTO practice_content (section_id, task_description, answer_description, order_index) VALUES
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 2), 'Create a variable named x and assign value 5', 'x = 5', 1),
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 2), 'Create a list with three items', 'my_list = [1, 2, 3]', 2);

INSERT INTO test_options (answer) VALUES
('int'), ('str'), ('list'), ('dict'), ('tuple'), ('for'), ('while'), ('loop');

INSERT INTO test_content (section_id, question_description, correct_answer_id) VALUES
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 3), 'Which type is used for text in Python?', (SELECT id FROM test_options WHERE answer = 'str')),
((SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 3), 'Which loop iterates over a sequence?', (SELECT id FROM test_options WHERE answer = 'for'));

INSERT INTO user_course_status (user_id, course_id, completion_percentage, correctness_percentage) VALUES
((SELECT id FROM users WHERE username = 'student_2'), (SELECT id FROM courses WHERE title = 'Python Basics'), 45, 78),
((SELECT id FROM users WHERE username = 'methodist_1'), (SELECT id FROM courses WHERE title = 'Python Basics'), 20, 65),
((SELECT id FROM users WHERE username = 'student_2'), (SELECT id FROM courses WHERE title = 'Java Basics'), 10, 50),
((SELECT id FROM users WHERE username = 'methodist_2'), (SELECT id FROM courses WHERE title = 'C++ Basics'), 100, 95);

INSERT INTO user_section_status (user_id, section_id, is_completed, completed_at) VALUES
((SELECT id FROM users WHERE username = 'student_2'), (SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 1), true, '2023-01-15 10:30:00'),
((SELECT id FROM users WHERE username = 'student_2'), (SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 2), true, '2023-01-16 11:45:00'),
((SELECT id FROM users WHERE username = 'methodist_1'), (SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Variables') AND order_index = 1), true, '2023-02-01 14:20:00'),
((SELECT id FROM users WHERE username = 'methodist_2'), (SELECT id FROM lesson_sections WHERE lesson_id = (SELECT id FROM lessons WHERE title = 'Vectors') AND order_index = 1), true, '2023-03-10 09:15:00');

INSERT INTO user_session_logs (user_id, session_log) VALUES
((SELECT id FROM users WHERE username = 'student_1'), 'Logged in from 192.168.1.1'),
((SELECT id FROM users WHERE username = 'student_2'), 'Completed section 1'),
((SELECT id FROM users WHERE username = 'student_2'), 'Started practice section'),
((SELECT id FROM users WHERE username = 'methodist_1'), 'Viewed lecture on variables'),
((SELECT id FROM users WHERE username = 'methodist_2'), 'Created new course module');
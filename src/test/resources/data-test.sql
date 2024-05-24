-- Dummy data for AppUser table
--user test / password test
INSERT IGNORE INTO APP_USER (id, username, password) VALUES (1, 'test', '$2a$10$RASFsCmkw.EYUgSqWASauutEtU4rHP2l2FKhjS9F4UwzbhcQbqEtq');



INSERT IGNORE INTO HABIT (USER_ID, id, name, description) VALUES (1, 1, 'Daily Coding Practice', 'Spend at least 30 minutes every day coding, whether its solving algorithmic problems, working on personal projects, or contributing to open-source repositories. Consistency is key to improving your programming skills and staying up-to-date with the latest technologies.');
INSERT IGNORE INTO HABIT (USER_ID, id, name, description) VALUES (1, 2, 'Regular Database Optimization', 'Dedicate a specific time each week to review and optimize database queries, indexes, and schema design. By regularly fine-tuning your database performance, you can ensure efficient data storage and retrieval, leading to better application responsiveness and user experience.');
INSERT IGNORE INTO HABIT (USER_ID, id, name, description) VALUES (1, 3, 'Continuous Learning through Online Courses', 'Enroll in online courses or tutorials related to web development topics such as HTML, CSS, JavaScript frameworks, and modern web development practices. Allocate a few hours each week to watch lectures, complete exercises, and apply newly acquired knowledge to your projects. This habit will help you stay current with industry trends and expand your skill set.');

INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 1, current_timestamp, 'Completed coding challenge on LeetCode');

INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 2, current_timestamp,  'Completed coding challenge on LeetCode');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 3, current_timestamp,  'Worked on personal project');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (2, 1, current_timestamp,  'Optimized database queries');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (2, 2, current_timestamp,  'Reviewed database schema design');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (3, 1, current_timestamp,  'Completed online course on JavaScript frameworks');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (3, 2, current_timestamp,  'Practiced CSS Flexbox layout');

-- Additional dummy data for AppUser table
--user test2 / password test2
INSERT IGNORE INTO APP_USER (id, username, password) VALUES (2, 'test2', '$2a$10$RASFsCmkw.EYUgSqWASauutEtU4rHP2l2FKhjS9F4UwzbhcQbqEtq');

-- Additional dummy data for Habit table
INSERT IGNORE INTO HABIT (USER_ID, id, name, description) VALUES (2, 4, 'Daily Reading', 'Spend at least 30 minutes every day reading technical articles or books. This habit will help you stay current with industry trends and expand your knowledge.');
INSERT IGNORE INTO HABIT (USER_ID, id, name, description) VALUES (2, 5, 'Regular Code Review', 'Dedicate a specific time each week to review and optimize your code. By regularly fine-tuning your code, you can ensure efficient and clean code, leading to better application performance.');

-- Additional dummy data for Log table
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (4, 1, current_timestamp, 'Read an article on Java best practices');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (4, 2, current_timestamp, 'Read a chapter from Clean Code');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (5, 1, current_timestamp, 'Reviewed and optimized code for personal project');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (5, 2, current_timestamp, 'Participated in code review session at work');
INSERT IGNORE INTO HABIT (id, name, description) VALUES (1, 'Daily Coding Practice', 'Spend at least 30 minutes every day coding, whether its solving algorithmic problems, working on personal projects, or contributing to open-source repositories. Consistency is key to improving your programming skills and staying up-to-date with the latest technologies.');
INSERT IGNORE INTO HABIT (id, name, description) VALUES (2, 'Regular Database Optimization', 'Dedicate a specific time each week to review and optimize database queries, indexes, and schema design. By regularly fine-tuning your database performance, you can ensure efficient data storage and retrieval, leading to better application responsiveness and user experience.');
INSERT IGNORE INTO HABIT (id, name, description) VALUES (3, 'Continuous Learning through Online Courses', 'Enroll in online courses or tutorials related to web development topics such as HTML, CSS, JavaScript frameworks, and modern web development practices. Allocate a few hours each week to watch lectures, complete exercises, and apply newly acquired knowledge to your projects. This habit will help you stay current with industry trends and expand your skill set.');

INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 1, current_timestamp, 'Completed coding challenge on LeetCode');

INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 2, current_timestamp,  'Completed coding challenge on LeetCode');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (1, 3, current_timestamp,  'Worked on personal project');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (2, 1, current_timestamp,  'Optimized database queries');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (2, 2, current_timestamp,  'Reviewed database schema design');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (3, 1, current_timestamp,  'Completed online course on JavaScript frameworks');
INSERT IGNORE INTO LOG (HABIT_ID, ID, ENTRY_TIME, TITLE) VALUES (3, 2, current_timestamp,  'Practiced CSS Flexbox layout');


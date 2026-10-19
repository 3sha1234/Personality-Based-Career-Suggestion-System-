-- ==============================================
-- Personality Career System - Database Setup
-- ==============================================

CREATE DATABASE IF NOT EXISTS career_db;
USE career_db;

-- ==============================================
-- SEED: Questions & Answers
-- ==============================================

-- Question 1
INSERT INTO questions (question_text, order_index, active) VALUES
('When working on a project, you prefer to:', 1, true);

SET @q1 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q1, 'Analyze data and create structured reports', 'ANALYTICAL', 3, 1),
(@q1, 'Design visuals and brainstorm creative ideas', 'CREATIVE', 3, 2),
(@q1, 'Collaborate and communicate with the team', 'SOCIAL', 3, 3),
(@q1, 'Lead the team and set strategic direction', 'LEADERSHIP', 3, 4),
(@q1, 'Build, fix, or implement tangible solutions', 'PRACTICAL', 3, 5);

-- Question 2
INSERT INTO questions (question_text, order_index, active) VALUES
('In your free time, you most enjoy:', 2, true);

SET @q2 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q2, 'Solving puzzles or coding challenges', 'ANALYTICAL', 3, 1),
(@q2, 'Drawing, writing, or making music', 'CREATIVE', 3, 2),
(@q2, 'Volunteering or helping friends', 'SOCIAL', 3, 3),
(@q2, 'Organizing events or leading clubs', 'LEADERSHIP', 3, 4),
(@q2, 'Fixing things or doing DIY projects', 'PRACTICAL', 3, 5);

-- Question 3
INSERT INTO questions (question_text, order_index, active) VALUES
('Your friends would describe you as:', 3, true);

SET @q3 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q3, 'Logical and detail-oriented', 'ANALYTICAL', 3, 1),
(@q3, 'Imaginative and expressive', 'CREATIVE', 3, 2),
(@q3, 'Empathetic and supportive', 'SOCIAL', 3, 3),
(@q3, 'Confident and decisive', 'LEADERSHIP', 3, 4),
(@q3, 'Resourceful and hands-on', 'PRACTICAL', 3, 5);

-- Question 4
INSERT INTO questions (question_text, order_index, active) VALUES
('When you face a difficult problem, you first:', 4, true);

SET @q4 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q4, 'Research and gather all available data', 'ANALYTICAL', 3, 1),
(@q4, 'Think of innovative or unconventional solutions', 'CREATIVE', 3, 2),
(@q4, 'Ask others for opinions and support', 'SOCIAL', 3, 3),
(@q4, 'Take charge and delegate tasks', 'LEADERSHIP', 3, 4),
(@q4, 'Jump in and try different approaches', 'PRACTICAL', 3, 5);

-- Question 5
INSERT INTO questions (question_text, order_index, active) VALUES
('You feel most accomplished when you:', 5, true);

SET @q5 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q5, 'Discover patterns or insights from complex data', 'ANALYTICAL', 3, 1),
(@q5, 'Create something unique and beautiful', 'CREATIVE', 3, 2),
(@q5, 'Help someone overcome a challenge', 'SOCIAL', 3, 3),
(@q5, 'Guide a team to achieve a big goal', 'LEADERSHIP', 3, 4),
(@q5, 'Complete a hands-on technical task', 'PRACTICAL', 3, 5);

-- Question 6
INSERT INTO questions (question_text, order_index, active) VALUES
('Your ideal work environment is:', 6, true);

SET @q6 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q6, 'A quiet office with lots of data to analyze', 'ANALYTICAL', 3, 1),
(@q6, 'A creative studio with artistic freedom', 'CREATIVE', 3, 2),
(@q6, 'A people-focused workplace with constant interaction', 'SOCIAL', 3, 3),
(@q6, 'A boardroom or startup where decisions are made', 'LEADERSHIP', 3, 4),
(@q6, 'A workshop or field where you work with your hands', 'PRACTICAL', 3, 5);

-- Question 7
INSERT INTO questions (question_text, order_index, active) VALUES
('Which school subject did you enjoy most?', 7, true);

SET @q7 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q7, 'Mathematics or Science', 'ANALYTICAL', 3, 1),
(@q7, 'Art, Music, or Literature', 'CREATIVE', 3, 2),
(@q7, 'Social Studies or Psychology', 'SOCIAL', 3, 3),
(@q7, 'Business Studies or Economics', 'LEADERSHIP', 3, 4),
(@q7, 'Technology, Engineering, or Physical Education', 'PRACTICAL', 3, 5);

-- Question 8
INSERT INTO questions (question_text, order_index, active) VALUES
('If you won a competition, it would most likely be in:', 8, true);

SET @q8 = LAST_INSERT_ID();

INSERT INTO answers (question_id, answer_text, category, points, order_index) VALUES
(@q8, 'A science fair or math olympiad', 'ANALYTICAL', 3, 1),
(@q8, 'An art exhibition or writing contest', 'CREATIVE', 3, 2),
(@q8, 'A community service award', 'SOCIAL', 3, 3),
(@q8, 'A business plan competition', 'LEADERSHIP', 3, 4),
(@q8, 'A robotics or construction challenge', 'PRACTICAL', 3, 5);

-- ==============================================
-- SEED: Careers
-- ==============================================

-- ANALYTICAL Careers
INSERT INTO careers (title, description, personality_type, skills_required, average_salary, job_outlook, education_required, day_in_life, active) VALUES
('Data Scientist', 'Use statistical analysis and machine learning to extract insights from data and drive business decisions.', 'ANALYTICAL',
 'Python,Machine Learning,Statistics,SQL,Data Visualization,Critical Thinking',
 '$95,000 - $150,000/year', 'Excellent (35% growth expected)',
 'Bachelor\'s or Master\'s in Computer Science, Statistics, or related field',
 'Analyzing datasets, building prediction models, presenting findings to stakeholders, writing reports.', true),

('Software Engineer', 'Design, develop, and maintain software systems and applications.', 'ANALYTICAL',
 'Java,Python,Algorithms,Data Structures,Git,Problem Solving,System Design',
 '$85,000 - $140,000/year', 'Excellent (25% growth expected)',
 'Bachelor\'s in Computer Science or equivalent experience',
 'Writing and reviewing code, debugging issues, attending meetings, architecting new features.', true),

('Financial Analyst', 'Analyze financial data to help companies make investment decisions and plan future strategy.', 'ANALYTICAL',
 'Financial Modeling,Excel,Bloomberg,Accounting,Risk Analysis,Forecasting',
 '$65,000 - $110,000/year', 'Good (9% growth expected)',
 'Bachelor\'s in Finance, Accounting, or Economics',
 'Reviewing financial reports, building models, meeting clients, preparing investment recommendations.', true);

-- CREATIVE Careers
INSERT INTO careers (title, description, personality_type, skills_required, average_salary, job_outlook, education_required, day_in_life, active) VALUES
('UX/UI Designer', 'Design intuitive, visually appealing digital experiences for websites and applications.', 'CREATIVE',
 'Figma,Adobe XD,User Research,Prototyping,CSS,Visual Design,Wireframing',
 '$70,000 - $120,000/year', 'Very Good (13% growth expected)',
 'Bachelor\'s in Design, HCI, or self-taught with portfolio',
 'Sketching wireframes, conducting user tests, collaborating with developers, iterating on designs.', true),

('Animator', 'Create motion graphics, 2D/3D animations for films, games, TV, and digital media.', 'CREATIVE',
 'Adobe After Effects,Blender,Maya,Storyboarding,Drawing,Timing,Color Theory',
 '$55,000 - $95,000/year', 'Good (5% growth expected)',
 'Bachelor\'s in Animation, Fine Arts, or related field',
 'Rigging characters, animating scenes, reviewing feedback, collaborating with the creative team.', true),

('Content Creator / Copywriter', 'Craft compelling written or multimedia content for brands, websites, and campaigns.', 'CREATIVE',
 'Creative Writing,SEO,Social Media,Video Editing,Storytelling,Research,Analytics',
 '$45,000 - $85,000/year', 'Good (12% growth expected)',
 'Bachelor\'s in Communications, Journalism, or English',
 'Writing articles, filming content, editing videos, engaging with audience, analyzing performance.', true);

-- SOCIAL Careers
INSERT INTO careers (title, description, personality_type, skills_required, average_salary, job_outlook, education_required, day_in_life, active) VALUES
('Teacher / Educator', 'Educate and inspire students across all ages and subjects in schools or online.', 'SOCIAL',
 'Communication,Lesson Planning,Patience,Curriculum Design,Assessment,Classroom Management',
 '$40,000 - $75,000/year', 'Steady (8% growth expected)',
 'Bachelor\'s in Education or subject area plus teaching certification',
 'Preparing lesson plans, teaching classes, grading, meeting with parents, attending staff meetings.', true),

('Human Resources (HR) Manager', 'Manage employee relations, recruitment, training, and workplace culture.', 'SOCIAL',
 'Recruitment,Conflict Resolution,Employment Law,Communication,HRIS Systems,Empathy',
 '$60,000 - $100,000/year', 'Good (7% growth expected)',
 'Bachelor\'s in HR Management, Business, or Psychology',
 'Interviewing candidates, resolving employee issues, running training sessions, reviewing policies.', true),

('Social Worker', 'Support individuals and families dealing with social, emotional, and economic challenges.', 'SOCIAL',
 'Empathy,Case Management,Crisis Intervention,Communication,Problem Solving,Documentation',
 '$40,000 - $65,000/year', 'Very Good (11% growth expected)',
 'Bachelor\'s or Master\'s in Social Work (BSW/MSW)',
 'Meeting with clients, assessing needs, connecting people to resources, writing case notes.', true);

-- LEADERSHIP Careers
INSERT INTO careers (title, description, personality_type, skills_required, average_salary, job_outlook, education_required, day_in_life, active) VALUES
('Product Manager', 'Drive product vision, strategy, and execution, working across engineering and design.', 'LEADERSHIP',
 'Product Strategy,Agile,Roadmapping,Stakeholder Management,Data Analysis,Communication',
 '$90,000 - $150,000/year', 'Excellent (19% growth expected)',
 'Bachelor\'s in CS or Business; MBA preferred',
 'Running sprint meetings, defining features, reviewing metrics, aligning teams, presenting to leadership.', true),

('Entrepreneur / Startup Founder', 'Build and scale a business from idea to execution, managing all aspects of the venture.', 'LEADERSHIP',
 'Business Strategy,Fundraising,Team Building,Sales,Resilience,Problem Solving,Networking',
 'Variable ($0 - Unlimited)', 'High risk / High reward',
 'No formal requirement, but business education helps',
 'Pitching to investors, hiring team members, solving unexpected problems, building customer relationships.', true),

('Operations Manager', 'Oversee daily business operations to ensure efficiency, quality, and profitability.', 'LEADERSHIP',
 'Process Improvement,Budgeting,Team Leadership,Supply Chain,KPI Management,Communication',
 '$70,000 - $120,000/year', 'Good (6% growth expected)',
 'Bachelor\'s in Business Administration or Management',
 'Reviewing operational metrics, coaching staff, improving processes, coordinating with departments.', true);

-- PRACTICAL Careers
INSERT INTO careers (title, description, personality_type, skills_required, average_salary, job_outlook, education_required, day_in_life, active) VALUES
('Civil / Mechanical Engineer', 'Design and oversee the construction of infrastructure or mechanical systems.', 'PRACTICAL',
 'AutoCAD,Structural Analysis,Project Management,Physics,Problem Solving,Technical Drawing',
 '$70,000 - $115,000/year', 'Good (7% growth expected)',
 'Bachelor\'s in Civil or Mechanical Engineering',
 'Reviewing blueprints, visiting construction sites, running simulations, meeting with contractors.', true),

('Electrician / Electrical Technician', 'Install, maintain, and repair electrical systems in residential and commercial settings.', 'PRACTICAL',
 'Wiring,Safety Standards,Troubleshooting,Reading Blueprints,Electrical Codes,Math',
 '$50,000 - $90,000/year', 'Very Good (11% growth expected)',
 'Vocational training or apprenticeship program',
 'Installing wiring, diagnosing electrical faults, reading schematics, adhering to safety codes.', true),

('IT Support Specialist', 'Troubleshoot and resolve technical issues for hardware, software, and networks.', 'PRACTICAL',
 'Network Troubleshooting,Windows/Linux,Hardware Repair,Ticketing Systems,Communication,Security Basics',
 '$45,000 - $80,000/year', 'Good (9% growth expected)',
 'Associate\'s degree or CompTIA A+/Network+ certification',
 'Responding to help desk tickets, setting up computers, diagnosing network issues, documenting fixes.', true);

-- ==============================================
-- Admin user (password: Admin@123)
-- BCrypt hash of 'Admin@123'
-- ==============================================
INSERT INTO users (username, email, password, full_name, role, created_at) VALUES
('admin', 'admin@careerapp.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lL.K', 'System Admin', 'ADMIN', NOW());

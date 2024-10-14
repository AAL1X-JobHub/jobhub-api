INSERT INTO users (id, role, email, password, date_create, active_account)
VALUES
    (1, 'ADMIN', 'aiden.pierce@ctos.com', 'vigilante001', '2024-02-15', TRUE),
    (2, 'USER', 'clara.lille@deadsec.org', 'decrypt321', '2024-02-16', TRUE),
    (3, 'USER', 'damien.brinks@fixer.net', 'brinker789', '2024-02-17', TRUE),
    (4, 'COMPANY', 'jordie.chin@blackmarket.com', 'chinman456', '2024-02-18', TRUE),
    (5, 'USER', 'tbone.grady@ctos.com', 'tbonebuilder321', '2024-02-19', FALSE),
    (6, 'USER', 'marcus.holloway@deadsec.com', 'hacktheworld002', '2024-02-20', TRUE),
    (7, 'COMPANY', 'josh.saunders@dedsec.com', 'logicbomb789', '2024-02-21', TRUE),
    (8, 'COMPANY', 'sitara.dhawan@dedsec.com', 'grafqueen456', '2024-02-22', TRUE),
    (9, 'COMPANY', 'raymond.kenney@tbone.com', 'wrenchmaster101', '2024-02-23', FALSE);


INSERT INTO applicants (id, first_name, last_name, degree, description, country, college, email, phone, curriculum_path, experience, education, user_id)
VALUES
    (1, 'Aiden', 'Pierce', 'Computer Science', 'Expert hacker and vigilante', 'USA', 'Chicago Tech', 'aiden.pierce@ctos.com', '555-0123', '/curriculums/aiden_pierce.pdf', '5 years in hacking and network security.', 'B.Sc. in Computer Science, Chicago Tech', 1),
    (2, 'Clara', 'Lille', 'Information Security', 'Skilled hacker and DedSec member', 'Canada', 'Montreal Institute of Technology', 'clara.lille@dedsec.org', '555-0456', '/curriculums/clara_lille.pdf', '4 years of experience in cybersecurity and encryption.', 'B.Sc. in Information Security, Montreal Institute of Technology', 2),
    (3, 'Damien', 'Brinks', 'Network Engineering', 'Experienced fixer and hacker', 'USA', 'Chicago University', 'damien.brinks@fixer.net', '555-0789', '/curriculums/damien_brinks.pdf', '6 years in network engineering and corporate espionage.', 'M.Sc. in Network Engineering, Chicago University', 3),
    (4, 'Jordie', 'Chin', 'Logistics', 'Professional fixer and black-market operator', 'USA', 'Chicago Business School', 'jordie.chin@blackmarket.com', '555-0112', '/curriculums/jordie_chin.pdf', '7 years in logistics and underground operations.', 'B.A. in Business Logistics, Chicago Business School', 4),
    (5, 'Raymond', 'Kenney', 'Electrical Engineering', 'Legendary hacker and DedSec member', 'USA', 'MIT', 'raymond.kenney@tbone.com', '555-0345', '/curriculums/ray_kenney.pdf', '10 years in hacking, electronics, and systems architecture.', 'M.Sc. in Electrical Engineering, MIT', 5),
    (6, 'Marcus', 'Holloway', 'Computer Engineering', 'Expert hacker and DedSec leader', 'USA', 'Oakland University', 'marcus.holloway@dedsec.com', '555-0678', '/curriculums/marcus_holloway.pdf', '4 years in software development and hacking.', 'B.Sc. in Computer Engineering, Oakland University', 6),
    (7, 'Josh', 'Saunders', 'Software Engineering', 'Skilled hacker and DedSec strategist', 'USA', 'San Francisco Tech', 'josh.saunders@dedsec.com', '555-0234', '/curriculums/josh_saunders.pdf', '3 years in software design and network security.', 'B.Sc. in Software Engineering, San Francisco Tech', 7),
    (8, 'Sitara', 'Dhawan', 'Graphic Design', 'Creative director and activist', 'India', 'Delhi School of Arts', 'sitara.dhawan@dedsec.com', '555-0890', '/curriculums/sitara_dhawan.pdf', '5 years in creative design and digital activism.', 'B.F.A. in Graphic Design, Delhi School of Arts', 8),
    (9, 'Horatio', 'Carlin', 'Data Science', 'Data analyst and hacker', 'USA', 'Stanford University', 'horatio.carlin@ctos.com', '555-0567', '/curriculums/horatio_carlin.pdf', '4 years in data analysis and network security.', 'M.Sc. in Data Science, Stanford University', 9);

INSERT INTO companies (id, company_name, website, description, country, email, phone, user_id)
VALUES
    (1, 'Blume Corporation', 'www.blume.ctos.com', 'Multinational technology conglomerate responsible for the cTOS system.', 'USA', 'info@blume.ctos.com', '555-1234', 1),
    (2, 'Nvite', 'www.nvite.org', 'Social media platform and part of Blume Corporation\s vast digital empire.', 'USA', 'contact@nvite.org', '555-5678', 2),
    (3, 'Galilei', 'www.galileispace.com', 'Pioneers in space technology and satellite communications.', 'USA', 'info@galileispace.com', '555-9101', 3),
    (4, 'Tidis Corporation', 'www.tidis-tech.com', 'Advanced robotics and defense technologies provider.', 'USA', 'support@tidis-tech.com', '555-1123', 4),
    (5, 'Dot Connexion', 'www.dotconnexion.art', 'Prestigious art gallery that showcases digital and contemporary works.', 'France', 'gallery@dotconnexion.art', '555-4567', 5),
    (6, 'HackerSpace', 'www.hackerspace.com', 'A collective of hackers working for a better world.', 'USA', 'contact@hackerspace.com', '555-7890', 6),
    (7, 'Oakland Technology', 'www.oaklandtech.com', 'Leading tech startup based in Oakland, focusing on innovative software solutions.', 'USA', 'info@oaklandtech.com', '555-2345', 7),
    (8, 'Home Domain', 'www.homedomain.net', 'Smart home devices and IoT solutions for modern living.', 'USA', 'support@homedomain.net', '555-6789', 8),
    (9, 'CyberDriver', 'www.cyberdriver.com', 'Creators of the world\s first AI-driven supercar.', 'USA', 'sales@cyberdriver.com', '555-3456', 9);


INSERT INTO jobs (id, company_id, title, description, location, job_type, posted_date, expiration_date, salary_range)
VALUES
    (1, 1, 'Infiltrator', 'Join the elite team of hackers and infiltrate high-security systems, utilizing advanced hacking techniques inspired by Aiden Pearce.', 'Chicago', 'Full-time', '2024-09-01', '2024-10-01', 70000.00),
    (2, 2, 'Network Specialist', 'Help build and maintain secure networks for our operations, using skills akin to those of the DedSec team.', 'San Francisco', 'Part-time', '2024-09-10', '2024-10-10', 50000.00),
    (3, 3, 'Cyber Security Analyst', 'Analyze and secure our systems against intrusions, drawing on the expertise of seasoned hackers like Clara Lille.', 'New York', 'Contract', '2024-08-15', '2024-09-30', 80000.00),
    (4, 4, 'Software Developer', 'Develop cutting-edge software solutions that empower users, inspired by the innovations of the Bloom Corporation.', 'London', 'Full-time', '2024-09-05', '2024-11-05', 90000.00),
    (5, 5, 'Data Analyst', 'Work with large datasets to uncover insights, similar to the work done by the team behind ctOS.', 'Paris', 'Full-time', '2024-09-12', '2024-10-20', 60000.00),
    (6, 6, 'Game Tester', 'Test our latest gaming products and provide feedback to help us create the best experience, echoing the creative work of the team at Blume.', 'Chicago', 'Internship', '2024-09-15', '2024-10-15', 30000.00),
    (7, 7, 'Digital Marketing Specialist', 'Promote our tech solutions through innovative marketing strategies, like those seen in DedSec campaigns.', 'Seattle', 'Full-time', '2024-09-20', '2024-11-01', 55000.00),
    (8, 8, 'IoT Solutions Architect', 'Design and implement IoT solutions for smart homes and cities, inspired by the technology behind Home Domain.', 'Los Angeles', 'Contract', '2024-09-18', '2024-10-25', 95000.00),
    (9, 9, 'Artificial Intelligence Engineer', 'Develop AI systems that improve user experience, channeling the ingenuity of the CyberDriver team.', 'Toronto', 'Full-time', '2024-09-25', '2024-12-01', 85000.00);


INSERT INTO groups (id, name, description, create_date, members_count, is_private)
VALUES
    (1, 'DedSec', 'A hacker collective dedicated to exposing corruption and fighting against oppressive organizations.', '2024-09-01', 150, false),
    (2, 'Blume Corporation Employees', 'A group of employees working for the Blume Corporation, focusing on the development of ctOS.', '2024-08-15', 300, true),
    (3, 'The Vigilante Network', 'A network of vigilantes fighting crime and injustice across the city, inspired by Aiden Pearce.', '2024-09-10', 80, false),
    (4, 'Nvite Developers', 'Developers and tech enthusiasts collaborating on projects related to the Nvite platform.', '2024-07-20', 50, true),
    (5, 'HackerSpace Collective', 'A community of hackers and makers sharing knowledge and resources for tech innovation.', '2024-09-05', 200, false),
    (6, 'The Cleaners', 'A secretive group working to eliminate digital threats and ensure cyber security for citizens.', '2024-09-12', 40, true),
    (7, 'CyberDriver Enthusiasts', 'A fan group dedicated to the CyberDriver AI and its advancements in automotive technology.', '2024-08-30', 120, false),
    (8, 'Oakland Innovators', 'A startup group focused on developing innovative software solutions for urban challenges.', '2024-09-15', 70, false),
    (9, 'Tech Art Collective', 'Artists and technologists collaborating to explore the intersection of digital art and technology.', '2024-09-18', 30, true);


INSERT INTO members (id, user_id, group_id, join_date, is_admin)
VALUES
    (1, 1, 1, '2024-09-02', true),   -- User "Aiden Pearce" en DedSec como admin
    (2, 2, 2, '2024-09-03', false),  -- User "Clara Lille" en DedSec
    (3, 3, 3, '2024-08-16', false),  -- User "Raymond Kenney" en Blume Corporation Employees
    (4, 4, 4, '2024-09-11', true),   -- User "Marcus Holloway" en The Vigilante Network como admin
    (5, 5, 5, '2024-07-21', false),  -- User "Wrench" en Nvite Developers
    (6, 6, 6, '2024-09-06', false),  -- User "Jacks" en HackerSpace Collective
    (7, 7, 7, '2024-09-13', true),   -- User "T-Bone" en The Cleaners como admin
    (8, 8, 8, '2024-09-01', false),  -- User "Hacker 1" en CyberDriver Enthusiasts
    (9, 9, 9, '2024-09-16', false);  -- User "Hacker 2" en Oakland Innovators

INSERT INTO comments (id, members_id, content, posted_date, likes_count)
VALUES
    (1, 1, 'La vigilancia masiva no es la respuesta. ¡Destruyamos el cTOS!', '2024-09-25', 25),  -- Comentario de "Aiden Pearce"
    (2, 2, 'La tecnología debe ser utilizada para empoderar a la gente, no para controlarla.', '2024-09-26', 30),  -- Comentario de "Clara Lille"
    (3, 3, 'Necesitamos encontrar formas más creativas de hackear sistemas.', '2024-09-24', 18),  -- Comentario de "Raymond Kenney"
    (4, 4, 'La tecnología puede ser nuestra arma más poderosa si la usamos correctamente.', '2024-09-23', 40),  -- Comentario de "Marcus Holloway"
    (5, 5, 'Siempre es bueno compartir ideas con otros hackers.', '2024-09-21', 15),  -- Comentario de "Wrench"
    (6, 6, 'El futuro de la humanidad depende de nuestra capacidad para adaptarnos.', '2024-09-22', 20),  -- Comentario de "Jacks"
    (7, 7, 'No olvidemos por qué comenzamos a hackear en primer lugar.', '2024-09-20', 35),  -- Comentario de "T-Bone"
    (8, 8, 'Hay que mantenernos un paso adelante de las corporaciones.', '2024-09-19', 22),  -- Comentario de "Hacker 1"
    (9, 9, 'La creatividad es la clave para cualquier hackeo exitoso.', '2024-09-18', 28);  -- Comentario de "Hacker 2"

INSERT INTO applications (id, date_created, job_id, applicant_id)
VALUES
    (1, '2024-09-01', 1, 1),  -- Aiden Pearce aplicó a un trabajo en Blume Corporation
    (2, '2024-09-02', 2, 2),  -- Clara Lille aplicó a un trabajo en Nvite
    (3, '2024-09-03', 3, 3),  -- Raymond Kenney aplicó a un trabajo en Galilei
    (4, '2024-09-04', 4, 4),  -- Marcus Holloway aplicó a un trabajo en Tidis Corporation
    (5, '2024-09-05', 5, 5),  -- Wrench aplicó a un trabajo en Dot Connexion
    (6, '2024-09-06', 6, 6),  -- Jacks aplicó a un trabajo en HackerSpace
    (7, '2024-09-07', 7, 7),  -- T-Bone aplicó a un trabajo en Oakland Technology
    (8, '2024-09-08', 8, 8),  -- Hacker 1 aplicó a un trabajo en Home Domain
    (9, '2024-09-09', 9, 9);  -- Hacker 2 aplicó a un trabajo en CyberDriver


INSERT INTO job_phases (id, name, job_id)
VALUES
    (1, 'Aplicación', 1),      -- Fase de aplicación para el trabajo en Blume Corporation
    (2, 'Entrevista', 1),      -- Fase de entrevista para el trabajo en Blume Corporation
    (3, 'Evaluación', 1),      -- Fase de evaluación para el trabajo en Blume Corporation
    (4, 'Aplicación', 2),      -- Fase de aplicación para el trabajo en Nvite
    (5, 'Entrevista', 2),      -- Fase de entrevista para el trabajo en Nvite
    (6, 'Evaluación', 2),      -- Fase de evaluación para el trabajo en Nvite
    (7, 'Aplicación', 3),      -- Fase de aplicación para el trabajo en Galilei
    (8, 'Entrevista', 3),      -- Fase de entrevista para el trabajo en Galilei
    (9, 'Evaluación', 3),      -- Fase de evaluación para el trabajo en Galilei
    (10, 'Aplicación', 4),     -- Fase de aplicación para el trabajo en Tidis Corporation
    (11, 'Entrevista', 4),     -- Fase de entrevista para el trabajo en Tidis Corporation
    (12, 'Evaluación', 4);     -- Fase de evaluación para el trabajo en Tidis Corporation


INSERT INTO application_follow_ups (id, application_date, last_update, job_phase_id, application_id)
VALUES
    (1, '2024-09-01', '2024-09-02', 1, 1),  -- Seguimiento de aplicación para la fase de aplicación en el trabajo 1
    (2, '2024-09-03', '2024-09-04', 2, 1),  -- Seguimiento de aplicación para la fase de entrevista en el trabajo 1
    (3, '2024-09-05', '2024-09-06', 3, 1),  -- Seguimiento de aplicación para la fase de evaluación en el trabajo 1
    (4, '2024-09-01', '2024-09-02', 4, 2),  -- Seguimiento de aplicación para la fase de aplicación en el trabajo 2
    (5, '2024-09-03', '2024-09-04', 5, 2),  -- Seguimiento de aplicación para la fase de entrevista en el trabajo 2
    (6, '2024-09-05', '2024-09-06', 6, 2),  -- Seguimiento de aplicación para la fase de evaluación en el trabajo 2
    (7, '2024-09-01', '2024-09-02', 7, 3),  -- Seguimiento de aplicación para la fase de aplicación en el trabajo 3
    (8, '2024-09-03', '2024-09-04', 8, 3),  -- Seguimiento de aplicación para la fase de entrevista en el trabajo 3
    (9, '2024-09-05', '2024-09-06', 9, 3),  -- Seguimiento de aplicación para la fase de evaluación en el trabajo 3
    (10, '2024-09-01', '2024-09-02', 10, 4), -- Seguimiento de aplicación para la fase de aplicación en el trabajo 4
    (11, '2024-09-03', '2024-09-04', 11, 4), -- Seguimiento de aplicación para la fase de entrevista en el trabajo 4
    (12, '2024-09-05', '2024-09-06', 12, 4); -- Seguimiento de aplicación para la fase de evaluación en el trabajo 4


INSERT INTO application_qualifications (id, level, application_follow_up_id)
VALUES
    (1, 1, 1),  -- Calificación nivel 1 para el seguimiento de la aplicación 1
    (2, 2, 1),  -- Calificación nivel 2 para el seguimiento de la aplicación 1
    (3, 3, 2),  -- Calificación nivel 3 para el seguimiento de la aplicación 2
    (4, 1, 2),  -- Calificación nivel 1 para el seguimiento de la aplicación 2
    (5, 2, 3),  -- Calificación nivel 2 para el seguimiento de la aplicación 3
    (6, 3, 3),  -- Calificación nivel 3 para el seguimiento de la aplicación 3
    (7, 1, 4),  -- Calificación nivel 1 para el seguimiento de la aplicación 4
    (8, 2, 4),  -- Calificación nivel 2 para el seguimiento de la aplicación 4
    (9, 3, 5),  -- Calificación nivel 3 para el seguimiento de la aplicación 5
    (10, 1, 5); -- Calificación nivel 1 para el seguimiento de la aplicación 5
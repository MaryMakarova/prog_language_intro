CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

CREATE TABLE Animals (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    species VARCHAR(255) NOT NULL
);

CREATE TABLE Dogs (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Cats (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Hamsters (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Horses (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Donkeys (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Camels (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    animal_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id)
);

CREATE TABLE Skills (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    skill VARCHAR(255) NOT NULL
);

CREATE TABLE AnimalSkills (
    animal_id INT UNSIGNED,
    skill_id INT UNSIGNED,
    FOREIGN KEY (animal_id) REFERENCES Animals(id),
    FOREIGN KEY (skill_id) REFERENCES Skills(id)
);

INSERT INTO Animals (species) VALUES
('Dog'), ('Cat'), ('Hamster'), ('Horse'), ('Donkey'), ('Camel');

INSERT INTO Dogs (name, birth_date, animal_id) VALUES
('Мухтар', '2019-02-10', 1),
('Балка', '2018-06-15', 1),
('Барбос', '2020-01-05', 1);

INSERT INTO Cats (name, birth_date, animal_id) VALUES
('Матроскин', '2017-04-25', 2),
('Барсик', '2016-07-10', 2),
('Мурзик', '2020-03-17', 2);

INSERT INTO Hamsters (name, birth_date, animal_id) VALUES
('Пушистик', '2021-01-03', 3),
('Шарик', '2022-02-14', 3),
('Крошка', '2020-11-20', 3);

INSERT INTO Horses (name, birth_date, animal_id) VALUES
('Буцефал', '2015-08-20', 4),
('Пегас', '2016-06-10', 4),
('Цезарь', '2017-03-15', 4);

INSERT INTO Donkeys (name, birth_date, animal_id) VALUES
('Иа-Иа', '2019-08-12', 5),
('Пиноккио', '2020-05-05', 5),
('Сивка-Бурка', '2021-02-20', 5);

INSERT INTO Camels (name, birth_date, animal_id) VALUES
('Буратино', '2019-08-12', 6),
('Али-Баба', '2020-05-05', 6),
('Каспер', '2021-02-20', 6);

INSERT INTO Skills (skill) VALUES
('Fetch'), ('Guard'), ('Hunt'), ('Play'), ('Bark'), ('Meow'), ('Run on wheel'), ('Burrow'), ('Climb'), ('Gallop'), ('Carry load'), ('Pull cart');

INSERT INTO AnimalSkills (animal_id, skill_id) VALUES
(1, 1), (1, 2), (1, 3), -- Мухтар
(2, 4), (2, 5), (2, 6), -- Балка
(3, 7), (3, 8), (3, 9), -- Барбос
(4, 10), (4, 11), (4, 12), -- Матроскин
(5, 1), (5, 3), (5, 5), -- Барсик
(6, 2), (6, 4), (6, 6), -- Мурзик
(7, 7), (7, 9), (7, 11), --  Пушистик
(8, 8), (8, 10), (8, 12), -- Шарик
(9, 1), (9, 2), (9, 3), -- Крошка
(10, 4), (10, 5), (10, 6), -- Буцефал
(11, 7), (11, 8), (11, 9), -- Пегас
(12, 10), (12, 11), (12, 12), -- Цезарь
(13, 1), (13, 2), (13, 3), -- Иа-Иа
(14, 4), (14, 5), (14, 6), -- Пиноккио
(15, 7), (15, 8), (15, 9), -- Сивка-Бурка
(16, 10), (16, 11), (16, 12), -- Буратино
(17, 1), (17, 2), (17, 3), -- Али-Баба
(18, 4), (18, 5), (18, 6); -- Каспер

DROP TABLE Camels;

CREATE TABLE HorsesAndDonkeys AS
SELECT * FROM Horses
UNION ALL
SELECT * FROM Donkeys;

DROP TABLE Horses;
DROP TABLE Donkeys;

CREATE TABLE YoungAnimals AS
SELECT 
    a.name, 
    a.species, 
    TIMESTAMPDIFF(MONTH, a.birth_date, CURDATE()) AS age_months
FROM Animals a
JOIN (
    SELECT animal_id FROM Dogs
    UNION ALL
    SELECT animal_id FROM Cats
    UNION ALL
    SELECT animal_id FROM Hamsters
    UNION ALL
    SELECT animal_id FROM HorsesAndDonkeys
) AS animal_ids ON a.id = animal_ids.animal_id
WHERE a.birth_date BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND CURDATE();

CREATE TABLE AllAnimals AS
SELECT 
    a.name, 
    a.species, 
    a.birth_date, 
    s.skill,
    'Dogs' AS source_table 
FROM Dogs a
JOIN AnimalSkills ASK ON a.animal_id = ASK.animal_id
JOIN Skills s ON ASK.skill_id = s.id
UNION
SELECT 
    a.name, 
    a.species, 
    a.birth_date, 
    s.skill,
    'Cats' AS source_table 
FROM Cats a
JOIN AnimalSkills ASK ON a.animal_id = ASK.animal_id
JOIN Skills s ON ASK.skill_id = s.id
UNION
SELECT 
    a.name, 
    a.species, 
    a.birth_date, 
    s.skill,
    'Hamsters' AS source_table 
FROM Hamsters a
JOIN AnimalSkills ASK ON a.animal_id = ASK.animal_id
JOIN Skills s ON ASK.skill_id = s.id
UNION
SELECT 
    a.name, 
    a.species, 
    a.birth_date, 
    s.skill,
    'HorsesAndDonkeys' AS source_table 
FROM HorsesAndDonkeys a
JOIN AnimalSkills ASK ON a.animal_id = ASK.animal_id
JOIN Skills s ON ASK.skill_id = s.id;
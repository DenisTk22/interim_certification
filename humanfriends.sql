CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

-- Создать таблицы с иерархией из диаграммы в БД

 CREATE TABLE cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(10),
    commands TEXT,
    date_of_birth DATE
);

-- Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT INTO cat (animal_name,commands, date_of_birth) VALUES 
	('Masya', 'purr', '2013-10-01'),
	('Barsik', 'eat', '2020-07-10');

INSERT INTO dog (animal_name,commands, date_of_birth) VALUES 
	('Jack', 'give a paw', '2000-06-01'),
	('ralf', 'site', '2019-12-10');
    
INSERT INTO hamster (animal_name,commands, date_of_birth) VALUES 
	('Hapun', 'gnaw', '2022-09-01'),
	('Gruzun', 'sniff', '2021-09-10');
    
INSERT INTO horse (animal_name,commands, date_of_birth) VALUES 
	('Maeck', 'gallop', '2017-05-01'),
	('Rucheek', 'quietly', '2015-06-10');
    
INSERT INTO camel (animal_name,commands, date_of_birth) VALUES 
	('Galiaf', 'spit', '2010-03-01'),
	('Gans', 'chew', '2010-02-10');
    
INSERT INTO donkey (animal_name,commands, date_of_birth) VALUES 
	('Ia', 'think', '2015-06-01'),
	('Iosif', 'bray', '2022-02-10');
    
-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
DROP TABLE camel;

SELECT animal_name, commands, date_of_birth FROM horse
UNION
SELECT animal_name, commands, date_of_birth FROM donkey;

-- Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE YoungAnimals AS
      SELECT animal_name, date_of_birth, 
      TIMESTAMPDIFF(MONTH, date_of_birth, curdate()) as age 
      from (SELECT animal_name, commands, date_of_birth FROM horse
UNION
SELECT animal_name, commands, date_of_birth FROM donkey
UNION
SELECT animal_name, commands, date_of_birth FROM cat
UNION
SELECT animal_name, commands, date_of_birth FROM dog
UNION
SELECT animal_name, commands, date_of_birth FROM hamster) as animal 
      WHERE date_add(date_of_birth, INTERVAL 1 YEAR) < curdate() 
            AND date_add(date_of_birth, INTERVAL 3 YEAR) > curdate();

SELECT * FROM YoungAnimals;

-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

SELECT id, animal_name, commands, date_of_birth FROM horse
UNION ALL
SELECT id, animal_name, commands, date_of_birth FROM donkey
UNION ALL
SELECT id, animal_name, commands, date_of_birth FROM cat
UNION ALL
SELECT id, animal_name, commands, date_of_birth FROM dog
UNION ALL
SELECT id, animal_name, commands, date_of_birth FROM hamster;












    
    
    
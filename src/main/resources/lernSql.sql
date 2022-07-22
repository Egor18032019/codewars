SELECT town_to,
       TIMEDIFF(time_in, time_out) AS flight_time
FROM Trip
WHERE town_from = 'Paris'

SELECT DISTINCT name
FROM Trip,
     Company
WHERE Trip.company = Company.id
  AND Trip.town_from = 'Vladivostok'

SELECT *
FROM Trip
WHERE Trip.time_out
          BETWEEN '1900-01-01 10:00:00'
          AND '1900-01-01 14:00:00'

SELECT name
FROM Passenger
WHERE LENGTH(name) =
      (SELECT MAX(LENGTH(name))
       FROM Passenger)

SELECT trip,
       COUNT(trip) AS count
FROM Pass_in_trip
GROUP BY trip

SELECT name
FROM Passenger
GROUP BY name
HAVING COUNT(name) >= 2

SELECT good_name
FROM Goods
         JOIN Payments
              ON Payments.good = Goods.good_id
GROUP by good_name
HAVING COUNT(*) > 1

SELECT count(*) AS count
FROM Student_in_class
         INNER JOIN Class
                    ON Student_in_class.class = Class.id
WHERE Class.name = '10 B'

SELECT *
from Student_in_class
         LEFT JOIN Class
                   ON Student_in_class.class = Class.id
WHERE Class.name = '10 B'

SELECT DISTINCT name AS subjects
FROM Teacher
         INNER JOIN Schedule
                    ON Schedule.teacher = Teacher.id
         INNER JOIN Subject
                    ON Schedule.subject = Subject.id
WHERE Teacher.last_name = 'Romashkin'
  AND Teacher.first_name LIKE 'P%'
  AND Teacher.middle_name LIKE 'P%'

SELECT trip,
       COUNT(*) AS count
FROM Pass_in_trip
         JOIN Trip
              ON Pass_in_trip.trip = Trip.id
GROUP BY trip
ORDER BY COUNT(*) DESC

SELECT FLOOR(
               AVG(
                       TIMESTAMPDIFF(YEAR,
                                     birthday,
                                     NOW())
                   )
           ) AS age
FROM FamilyMembers

SELECT *
FROM Payments
WHERE family_member = (
    SELECT member_id
    from FamilyMembers
    WHERE member_name = 'Headley Quincey'
)
ORDER BY unit_price DESC;

-- Пример использования конструкции WITH
WITH Aeroflot_trips AS
         (SELECT TRIP.*
          FROM Company
                   INNER JOIN Trip ON Trip.company = Company.id
          WHERE name = "Aeroflot")

SELECT plane, COUNT(plane) AS amount
FROM Aeroflot_trips
GROUP BY plane;

WITH Aeroflot_trips AS
         (SELECT TRIP.*
          FROM Company
                   INNER JOIN Trip ON Trip.company = Company.id
          WHERE name = "Aeroflot"),
     Don_avia_trips AS
         (SELECT TRIP.*
          FROM Company
                   INNER JOIN Trip ON Trip.company = Company.id
          WHERE name = "Don_avia")

SELECT *
FROM Don_avia_trips
UNION
SELECT *
FROM Aeroflot_trips;

SELECT DISTINCT name, COUNT(trip) as count
FROM passenger
         JOIN Pass_in_trip
              on Pass_in_trip.passenger = passenger.id
GROUP by name
ORDER BY count DESC, name ASC

SELECT member_name,
       status,
       SUM(unit_price * amount) AS costs
FROM FamilyMembers,
     Payments
WHERE member_id = family_member
  AND YEAR(date) = '2005'
GROUP BY member_id

SELECT status
From FamilyMembers
WHERE member_id = (
    SELECT DISTINCT member_id
    From FamilyMembers
             JOIN Payments
                  On Payments.family_member = FamilyMembers.member_id
             Join Goods
                  ON Goods.good_id = Payments.good
    WHERE good_name = 'potato'
)

SELECT good_name, unit_price
FROM Goods,
     Payments
Where Payments.good = Goods.good_id
  and type = (
    SELECT DISTINCT type
    FROm Goods
             JOIN GoodTypes
                  on GoodTypes.good_type_id = Goods.type
    WHERE good_type_name = 'delicacies'
)
ORDER by unit_price DESC
LIMIT 1

SELECT good_name
FROM Goods
WHERE good_id NOT IN
      (SELECT DISTINCT good
       FROM Payments
       WHERE YEAR(date) = 2005)

SELECT good_type_name
FROM GoodTypes AS NotG
WHERE NOT EXISTS
    (SELECT DISTINCT good_type_name
     FROM Payments,
          Goods,
          GoodTypes
     WHERE good_id = good
       AND good_type_id = type
       AND YEAR(date) = 2005
       AND good_type_name = NotG.good_type_name)

SELECT good_type_name
FROM GoodTypes AS NotG
WHERE NOT EXISTS(
        SELECT DISTINCT good_type_name
        From GoodTypes
                 Join Goods
                      on Goods.type = GoodTypes.good_type_id
                 JOIN Payments
                      on Payments.good = Goods.good_id
        WHERE YEAR(date) = 2005
          AND good_type_name = NotG.good_type_name
    )

SELECT DISTINCT good_type_name, SUM(unit_price * amount) as costs
From GoodTypes
         Join Goods
              on Goods.type = GoodTypes.good_type_id
         JOIN Payments
              on Payments.good = Goods.good_id
WHERE YEAR(date) = 2005
GROUP by good_type_name

SELECT DISTINCT name
From Passenger
         JOIN   Pass_in_trip
                on Pass_in_trip.passenger =Passenger.id
         JOIN Trip
              on Trip.id = Pass_in_trip.trip
Where town_to like 'Moscow'
  and plane = 'TU-134'
--     Вывести средний возраст людей (в годах), хранящихся в базе данных. Результат округлите до целого в меньшую сторону.
SELECT FLOOR(AVG(TIMESTAMPDIFF(YEAR,
                               birthday,
                               NOW()))) AS age
FROM FamilyMembers



SELECT TIMEDIFF(
               (SELECT end_pair
                FROM Timepair
                WHERE id=4),
               (SELECT start_pair
                FROM Timepair
                WHERE id=2)) AS time

SELECT MAX(TIMESTAMPDIFF(YEAR
    ,birthday,
                         NOW())) as max_year
FROM Student
         Join Student_in_class
              on Student_in_class.student =Student.id
         JOIN Class
              on Class.id = Student_in_class.class
Where name like '10 %'


SELECT classroom
FROM Schedule
GROUP by classroom
HAVING COUNT(*) =
--        далее считаем максимальное значение повторенией classroom и уже по этому значению фильтруем
       (
                    SELECT MAX(co)
                      From (
                           SELECT COUNT(*) as co
                           From Schedule
                           GROUP BY classroom
                         ) as cos
)

SELECT (
           SELECT COUNT(*)
           FROM Student_in_class
                    JOIN Class ON class = Class.id
           WHERE Class.name = '10 A'
       ) / (
           SELECT COUNT(*)
           FROM Student_in_class
       ) * 100 AS percent
SELECT FLOOR((
                 SELECT COUNT(*)
                 FROM Student
                 WHERE Year(birthday) = 2000
             ) / (
                 SELECT COUNT(*)
                 FROM Student
             ) * 100) AS percent

    INSERT INTO Goods (
SELECT COUNT(*) + 1,
       'Cheese',
       (
           SELECT good_type_id
           FROM GoodTypes
           WHERE good_type_name = 'food'
           limit 1
       )
FROM Goods
    )

INSERT INTO Goods(good_id ,good_name ,type )
VALUES (
           (SELECT COUNT(*) +1
            From (Select * From Goods) as sometable),
            'Cheese',
           (SELECT DISTINCT good_type_id
            From GoodTypes
            WHERE good_type_name ='food'
           )
       )
INSERT INTO GoodTypes (
    SELECT COUNT(*) + 1,
           'auto'
    FROM GoodTypes
)
UPDATE FamilyMembers
SET member_name = 'Andie Anthony'
WHERE member_name = 'Andie Quincey'

DELETE FROM FamilyMembers
WHERE member_name LIKE '%Quincey'

DELETE FROM Company
WHERE id IN (
    SELECT company
    FROM (
             SELECT company,
                    COUNT(*) AS count
             FROM Trip
             GROUP BY company
             HAVING count = (
                 SELECT COUNT(*) AS c
                 FROM Trip
                 GROUP BY company
                 LIMIT 1
             )
         ) AS ids
)

UPDATE Timepair
SET
    start_pair = ADDTIME(start_pair, '00:30:00'),
    end_pair = ADDTIME(end_pair, '00:30:00')

INSERT INTO Reviews(id ,reservation_id ,rating )
VALUES (
        (SELECT COUNT(*) +1
            From (Select * From Reviews) as sometable),
        ( SELECT id
          FROM Reservations as rtable
          WHERE user_id =(
              SELECT id
              FROM Users
              WHERE name = "George Clooney"
          )
            AND room_id =(
              SELECT id
              FROM Rooms as rooms
              WHERE address = "11218, Friel Place, New York"
          ) ),
        5);

INSERT INTO Reviews
SELECT COUNT(*) + 1,
       (
           SELECT id
           FROM Reservations
           WHERE user_id =(
               SELECT id
               FROM Users
               WHERE name = "George Clooney"
           )
             AND room_id =(
               SELECT id
               FROM Rooms
               WHERE address = "11218, Friel Place, New York"
           )
       ),
       5
FROM Reviews

SELECT teacher
FROM (
         SELECT DISTINCT teacher,
                         class
         FROM schedule
                  JOIN teacher ON teacher.id = teacher
         WHERE class IN (
             SELECT id
             FROM Сlass
             WHERE name LIKE '11%'
         )
     ) AS t1
GROUP BY teacher
-- и из этой выборки выбираем всех которые повторяются = равное кол-ву классов с "11"
-- то есть HAVING COUNT(*) = 2
HAVING COUNT(*) = (
    SELECT COUNT(id)
    FROM class
    WHERE name LIKE '11%'
)
/*
 Выведите идентификаторы преподавателей,
 которые хотя бы один раз за всё время
 преподавали в каждом из одиннадцатых классов.
 */
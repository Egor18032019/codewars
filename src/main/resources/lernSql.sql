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
# Write your MySQL query statement below
-- Write your MySQL query statement below
SELECT e.name AS Employee
FROM Employee e, Employee a
WHERE e.managerId = a.id
  AND e.salary > a.salary;
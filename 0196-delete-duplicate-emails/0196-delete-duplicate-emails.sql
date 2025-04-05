# Write your MySQL query statement below
delete p from Person p
join person p2
ON p.Email=p2.Email and p.Id>p2.id;
# Write your MySQL query statement below
select p.product_id, coalesce(latest.new_price,10) AS price
from (select distinct product_id from products) p
left join products latest
on p.product_id=latest.product_id
and latest.change_date=(
    select MAX(change_date)
    from products
    where product_id=p.product_id and change_date<='2019-08-16'
);
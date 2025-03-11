select v.customer_id, Count(*) AS count_no_trans
from visits v
Left Join transactions t ON v.visit_id=t.visit_id
where t.transaction_id is null
group by v.customer_id;

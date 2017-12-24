USE Practice;

-- Query 1
-- Show information about customers who have items in the 'In Process' status,
-- sorted by the number of such items.
SELECT customers.city, customers.phone, customers.customerName, A.c
FROM customers NATURAL JOIN
( SELECT count(*) AS c, customerNumber, status
  FROM orders WHERE status = 'In Process'
  GROUP BY customerNumber) AS A
ORDER BY A.c DESC;

-- Query 2
-- Show customers and their total number of orders, sorted by total
SELECT customers.customerName, A.total
FROM customers NATURAL JOIN
( SELECT customerNumber, COUNT(*) AS total
  FROM orders GROUP BY customerNumber) AS A
ORDER BY A.total DESC;

-- Query 3
-- Aggregate by total orders of each city, sorted by total orders number
SELECT SUM(A.total) AS t, customers.city
FROM customers NATURAL JOIN
( SELECT customerNumber, COUNT(*) AS total
  FROM orders GROUP BY customerNumber) AS A
GROUP BY city ORDER BY t DESC;

-- Query 4
-- Percent of completed orders
SELECT ROUND(100 * shipped / total, 0) AS precent
FROM
  (SELECT COUNT(*) shipped
   FROM orders
   WHERE status = 'Shipped') AS S,
  (SELECT COUNT(*) total
   FROM orders) AS T;
   
-- Query 5
-- Show list of cities that have more than 10 items shipped.
SELECT
  customers.city,
  SUM(T.c) AS total
FROM customers
  NATURAL JOIN
  (SELECT
     status,
     customerNumber,
     COUNT(*) c
   FROM orders
   WHERE status = 'Shipped'
   GROUP BY customerNumber) AS T
GROUP BY customers.city
HAVING total > 10
ORDER BY total DESC;

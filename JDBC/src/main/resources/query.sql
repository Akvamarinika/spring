SELECT products.name AS product, sales.quantity, products.retail_price, sales.implementation_date,
       concat(clients.surname, ' ', substring(clients.name for 1), '. ', substring(clients.middle_name for 1), '.') AS clients,
       concat(employees.surname, ' ', substring(employees.first_name from 0 for 2), '. ', substring(employees.middle_name from 0 for 2), '. ') AS employees
    FROM sales
    INNER JOIN products ON sales.product_id = products.id
    INNER JOIN clients ON sales.client_id = clients.id
    INNER JOIN employees ON sales.employee_id = employees.id
    WHERE to_char(sales.implementation_date, 'YYYY-MM') = '2020-05'
    GROUP BY employees, products.name;

SELECT  SUM(sales.quantity * products.retail_price) AS sales_may,
        concat(employees.surname, ' ', substring(employees.first_name for 1), '. ', substring(employees.middle_name for 1), '. ') AS employees
        FROM sales
        INNER JOIN products ON sales.product_id = products.id
        INNER JOIN employees ON sales.employee_id = employees.id
        WHERE to_char(sales.implementation_date, 'YYYY-MM') = '2020-05'
        GROUP BY employees
        HAVING SUM(sales.quantity * products.retail_price) > 5000
        ORDER BY sales_may DESC;

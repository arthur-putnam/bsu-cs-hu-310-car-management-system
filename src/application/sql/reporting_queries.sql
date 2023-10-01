/* Put your final project reporting queries here */
USE car_management_system;

-- Which cars did the dealership make a profit on?
SELECT 
	cars.*,
    purchase_amount - sale_amount as profit
FROM cars
JOIN car_purchases ON cars.car_id = car_purchases.car_id
JOIN car_sales ON cars.car_id = car_sales.car_id
WHERE purchase_amount - sale_amount > 0;



-- Did the dealership make a profit overall?
SELECT 
	SUM(purchase_amount - sale_amount) as total_profit,
	IF(SUM(purchase_amount - sale_amount) > 0, 'Yes', 'No') as made_profit
FROM cars
JOIN car_purchases ON cars.car_id = car_purchases.car_id
JOIN car_sales ON cars.car_id = car_sales.car_id;


-- What cars are for sale 
SELECT 
	cars.*
FROM cars
WHERE NOT EXISTS (
	SELECT 1
    FROM car_sales WHERE car_sales.car_id = cars.car_id 
);
-- Another Solution
SELECT 
	cars.*
FROM cars
WHERE car_id NOT IN (
	SELECT car_id
    FROM car_sales
);


-- Sales This Month
SELECT 
	cars.*,
	car_sales.*
FROM cars
JOIN car_sales ON cars.car_id = car_sales.car_id
WHERE MONTH(sales_date) = MONTH(CURRENT_DATE);
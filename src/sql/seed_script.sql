/*
  Run this SQL file to delete existing data and populate your database with
  sample data.

  NOTE: This will DELETE ALL data in your project tables.
*/
USE car_management_system;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cars;
TRUNCATE TABLE car_purchases;
TRUNCATE TABLE car_sales;
TRUNCATE TABLE customers;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO cars (make, model, category, year, `condition`, kelly_bluebook_price) VALUES 
('Isuzu', 'Trooper', 'SUV','1995','used', 8138),
('BMW', 'Z4', 'Convertible','2014','used', 35796),
('Lincoln', 'MKZ', 'Sedan','2009','used', 5868),
('Nissan', 'Versa', 'Sedan, Hatchback','2014','used', 58849),
('Maybach', '57', 'Sedan','2005','new', 31318),
('Audi', 'S8', 'Sedan','2016','new', 44216),
('Pontiac', 'Trans Sport', 'Van/Minivan','1992','new', 83719),
('GMC', 'Envoy', 'SUV','2002','new', 83240),
('Nissan', '350Z', 'Coupe, Convertible','2005','used', 45130),
('Chevrolet', 'Express 3500 Cargo', 'Van/Minivan','2019','used', 4938);

INSERT INTO car_purchases (car_id, purchase_amount, purchase_date) VALUES 
('1', '74551', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('2', '78565', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('3', '22238', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('4', '80942', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('5', '70713', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('6', '92757', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('7', '41893', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('8', '38124', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('9', '34754', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY ),
('10', '62915', CURRENT_DATE - INTERVAL FLOOR(RAND() * 180 + 180) DAY );

INSERT INTO customers (first_name, last_name, phone_number, email) VALUES 
('Danielle', 'Johnson', '332-181-9600x133','Danielle.Johnson.3268@guzman.net'),
('Robert', 'Cole', '026-542-3511x615','Robert.Cole.4888@munoz-roman.info'),
('Amanda', 'Dudley', '(184)959-3103x4131','Amanda.Dudley.8283@ramirez-reid.com'),
('Francisco', 'Kelly', '+1-419-283-2764x83503','Francisco.Kelly.7311@trujillo.com'),
('Carl', 'Gentry', '001-537-672-4238','Carl.Gentry.4969@baker.biz');

INSERT INTO car_sales (car_id, customer_id, sale_amount, sales_date) VALUES 
('1', '3', 80908, CURRENT_DATE - INTERVAL FLOOR(RAND() * 180) DAY ),
('2', '3', 71043, CURRENT_DATE - INTERVAL FLOOR(RAND() * 180) DAY ),
('3', '3', 26947, CURRENT_DATE),
('4', '2', 71932, CURRENT_DATE - INTERVAL FLOOR(RAND() * 3) DAY ),
('5', '1', 32413, CURRENT_DATE - INTERVAL FLOOR(RAND() * 10) DAY );


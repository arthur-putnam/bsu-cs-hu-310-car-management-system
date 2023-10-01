/*
  Put all table create statements in this file as well as any UDFs or stored
  procedures.

  NOTE: This file must be able to run repetitively without any errors
  
*/

CREATE DATABASE IF NOT EXISTS car_management_system;
USE car_management_system;


CREATE TABLE IF NOT EXISTS cars(
	car_id INT AUTO_INCREMENT,
	make VARCHAR(80) NOT NULL,
	model VARCHAR(80) NOT NULL,
    category VARCHAR(80) NOT NULL,
	year CHAR(4) NOT NULL,
	condition VARCHAR(80)  NOT NULL,
	kelly_bluebook_price DOUBLE NOT NULL,
	PRIMARY KEY(car_id)
);

CREATE TABLE IF NOT EXISTS customers(
	customer_id INT AUTO_INCREMENT,
	first_name VARCHAR(80) NOT NULL,
	last_name VARCHAR(80) NOT NULL,
	phone_number VARCHAR(80) NOT NULL UNIQUE,
	email VARCHAR(80) NOT NULL UNIQUE,
	primary key (customer_id)
);

CREATE TABLE IF NOT EXISTS car_purchases(
	purchase_id INT auto_increment,
	car_id int NOT NULL,
	purchase_amount DOUBLE NOT NULL,
	purchase_date datetime DEFAULT CURRENT_TIMESTAMP  NOT NULL,
	primary key (purchase_id)
);


CREATE TABLE IF NOT EXISTS car_sales(
	sale_id INT auto_increment,
	car_id int NOT NULL UNIQUE,
	customer_id int NOT NULL,
	sale_amount DOUBLE NOT NULL,
	sales_date datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	FOREIGN KEY (car_id) REFERENCES cars(car_id),
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
	primary key (sale_id)
);










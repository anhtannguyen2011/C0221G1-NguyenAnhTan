CREATE DATABASE casestudy_furama_web;
USE casestudy_furama_web;
CREATE TABLE customer_type(
	customer_type_id int PRIMARY KEY,
    customer_type_name VARCHAR(50)
);

INSERT INTO customer_type
VALUES (1,"Diamond"),
		 (2,"Platinium"),
		 (3,"Gold"),
		 (4,"Silver"),
		 (5,"Member");

CREATE TABLE customer(
	customer_id int PRIMARY KEY AUTO_INCREMENT,
    customer_type_id int,
    customer_name varchar(50),
    customer_birthday date,
    customer_gender varchar(30),
    customer_id_card varchar(45),
    customer_phone varchar(45),
    customer_email varchar(45),
    customer_address varchar(45),
    foreign key (customer_type_id) references customer_type(customer_type_id)
    on DELETE CASCADE
);

INSERT INTO customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
VALUES (1,"Van Hung","1990-12-03","Male","201210210","0905040506","anhtannguyen@gmail.com","Da Nang"),
		(2,"Lam Tac","1989-12-03","Famale","201210210","0905040506","lam@gmail.com","Quang Ngai"),
		(3,"Hoang Linh","1992-12-03","Famale","201210210","0905040506","linh@gmail.com","Hue"),
		(4,"Van An","2001-12-03","Male","201210210","0905040506","ann@gmail.com","Sai Gon");


CREATE TABLE service_type(
	service_type_id int PRIMARY key,
    service_type_name varchar(50)
);

INSERT INTO service_type
VALUES (1,"Villa"),(2,"House"),(3,"Room");


CREATE TABLE rent_type(
	rent_type_id int PRIMARY KEY,
    rent_type_name VARCHAR(45),
    rent_type_cost double
);

INSERT INTO rent_type
VALUES (1,"DAY",50000),(2,"WEEK","1200000"),(3,"MONTH",30000000),(4,"YEAH",600000000);

CREATE TABLE service(
	service_id int primary KEY AUTO_INCREMENT,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    rent_type_id int,
    service_type_id int,
    strandard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floor int,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(rent_type_id),
    FOREIGN KEY (service_type_id) REFERENCES service_type(service_type_id)
    on DELETE CASCADE    
);

insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,strandard_room,description_other_convenience,pool_area,number_of_floor)
VALUES ("VIP",200,500000,20,1,2,"Mat Me","Tra Dao",300,2);
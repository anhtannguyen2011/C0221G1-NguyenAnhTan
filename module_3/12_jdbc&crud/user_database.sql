CREATE DATABASE `demo`;
USE `demo`;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) 
values('Minh','minh@codegym.vn','Viet Nam');

insert into users(name, email, country) 
values('Kante','kante@che.uk','Kenia');

SELECT * FROM users
WHERE country = "Viet Nam";

SELECT * FROM users
ORDER BY `name` ASC;


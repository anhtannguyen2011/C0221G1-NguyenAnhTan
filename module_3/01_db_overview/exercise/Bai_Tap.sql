CREATE SCHEMA student_management;
CREATE TABLE student_management.class(
	id int,
    name varchar(50)
);
CREATE TABLE student_management.teacher(
	id int,
    name varchar(50),
	age int,
    country varchar(50)
);
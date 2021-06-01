CREATE TABLE customers(
	id_cus int PRIMARY KEY,
    cus_name varchar(50)
) ;

CREATE TABLE customers_type(
	id_cus int,
    type_name varchar(50),
    foreign key (id_cus) references customers(id_cus)
);

insert into customers
value (1,"Tan") , (2,"Hung");

insert into customers_type
value (1,"Giam Sat") , (2,"Quan Kho");


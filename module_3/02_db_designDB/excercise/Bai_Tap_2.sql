create database bai_tap2;
use bai_tap2;

create table customers(
	cID int primary key,
    cName varchar(30),
    cAge int 
);

create table `order`(
	oID int primary key,
    oDate date,
    oTotalPrice float,
    cID int,
    foreign key (cID) references customers(cID)
);


create table product(
	pID int primary key,
    pName varchar(45),
    pPrice float
);

create table order_details(
	oID int,
    pID int,
    odQTY int primary key,
	foreign key (oID) references `order`(oID),
    foreign key (pID) references product(pID)
    
);
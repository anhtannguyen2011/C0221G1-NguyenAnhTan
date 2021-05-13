use bai_tap2;

insert into customers
values(1,"Minh Quan",10),(2,"Ngoc Oanh",20),(3,"Hong Ha",50);

insert into `order`
values(1,"2006-3-21",null,1),(2,"2006-3-20",null,2),(3,"2006-3-16",null,1);

insert into product
values(1,"May Giat",3),
	(2,"Tu Lanh",5),
	(3,"Dieu Hoa",7),
	(4,"Quat",1),
    (5,"Bep Dien",2);
    
 alter table order_details
 drop primary key;
 
 insert into order_details
 values (1,1,3),
		 (1,3,7),
		 (1,4,2),
		 (2,1,1),
		 (3,1,8),
		 (2,5,4),
		 (2,3,3);
         
         
 select o.oID,	o.oDate	,o.oTotalPrice
 from `order` as o ;
 
 select customers.cName , product.pName
 from order_details join `order` on order_details.oID = `order`.oID 
 join product on order_details.pID = product.pID
 join customers on `order`.cID = customers.cID;


--  select customers.cName,count(customers.cID)
--  from order_details join `order` on order_details.oID = `order`.oID 
--  join product on order_details.pID = product.pID
--  join customers on `order`.cID = customers.cID
--  
--  having count(customers.cID) <1;
 
 select customers.cName 
 from customers 
 where customers.cID NOT IN (select cID from `order`);




select `order`.oID,`order`.oDate,product.pName,(order_details.odQTY*product.pPrice) as tong_tien
from order_details join `order` on order_details.oID = `order`.oID 
join product on order_details.pID = product.pID
join customers on `order`.cID = customers.cID
order by tong_tien;
 

create database exercise_view_procedure;
use exercise_view_procedure;

create table product_exercise(
	id int,
	product_Code varchar(45),
	product_Name varchar(45),
	product_Price float,
	product_Amount float,
	product_Description varchar(45),
	product_Status varchar(45)
);


insert into product_exercise
values (1,"code001","kem",2000,20000,"usa","con"),
(2,"code002","banh",2000,20000,"usa","con"),
(3,"code003","xe",2000,20000,"usa","con"),
(4,"code004","bap",2000,20000,"usa","con");



-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index

explain select * from product_exercise where product_Code = "code001";

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
alter table product_exercise
add index idx_product_Code(product_Code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
alter table product_exercise
add index idx_full(product_Name,product_Price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from product_exercise where product_Name = "kem" or product_Price = 2000;


-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view


-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.

create view view_products as
select product_Code,product_Name,product_Price,product_Status
from product_exercise;

-- Tiến hành  sửa đổi cấu trúc view 

alter view view_products as
select * from product_exercise
where product_Price >= 2000;

-- cách 2 : or replace tạo view mới nếu chưa tồn tại hoặc ghi đè lên view cũ ; 
create or replace view view_products as
select * from product_exercise
where product_Price >= 2001;


-- kiểm tra lại view
select * from view_products;

-- sửa đổi dữ liệu trong view
SET SQL_SAFE_UPDATES = 0;

update view_products
set product_Price = 3000
where id = 2;

-- kiểm tra lại view--
select * from view_products;

-- xóa view 
drop view view_products;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id

Drop procedure proc_products;
-- tạo procedure
DELIMITER //
create procedure proc_products()
begin
	select * from product_exercise;
 end //
 DELIMITER ;
 
 -- gọi lại procedure
 
 call proc_products();
 
 -- tạo insert_proc với thông tin sau
 -- id int,
--  product_Code varchar(45),
-- 	product_Name varchar(45),
-- 	product_Price float,
-- 	product_Amount float,
-- 	product_Description varchar(45),
-- 	product_Status varchar(45)
 
 DELIMITER //
 create procedure insert_procedure(
	IN id int , 
    proc_code varchar(45),
    proc_name varchar(45),
    proc_price float,
    proc_amount float,
    proc_des varchar (45),
    proc_status varchar (45)
 )
 begin
	insert into product_exercise
    values(id,proc_code,proc_name,proc_price,proc_amount,proc_des,proc_status) ;
end //
DELIMITER ;    

-- call test insert_procedure

call insert_procedure(5,"code005","quat",3000,30000,"thailand","con");

-- gọi lại procedure để kiểm tra
call proc_products();


-- tạo update_procedure theo giá tiền 
DELIMITER //
create procedure update_procedure( 
IN id_proc int,
proc_price float)

begin 
	update product_exercise
    set product_Price = proc_price
    where id = id_proc;
end //

DELIMITER ;
-- call update_procedure để test 
SET SQL_SAFE_UPDATES = 0;
call update_procedure(4,5000);

-- test kết quả update
call proc_products();





-- tạo delete_procedure
DELIMITER //
 create procedure delete_procedure(IN id_proc int)
 begin 
	delete from product_exercise
    where id = id_proc ;
    end //
DELIMITER ;
-- gọi lại  delete_procedure để test

call delete_procedure(5);

-- kiểm tra lại kết quả

call proc_products();



    

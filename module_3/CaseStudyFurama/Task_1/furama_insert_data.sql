use casestudy_furama;
insert into vi_tri
values(1,"Giam Doc"),
		(2,"Le Tan"),
		(3,"BellMan"),
		(4,"Phuc Vu"),
        (5,"Buong Phong"),
        (6,"Bao Ve");
        
insert into trinh_do
values(1,"Dai Hoc"),
		(2,"Cao Dang"),
        (3,"Trung Cap"),
        (4,"Cao Hoc");
        
 insert into bo_phan
 values(1,"Quan Ly"),
 (2,"Thu Mua"),
 (3,"Seller"),
 (4,"Marketing");
 
 insert into nhan_vien
 values(1,"Anh Tan",3,4,1,"1990-12-12",201201201,9000000,0912121212,"tan@gmail.com","Da Nang"),
		(2,"Minh Tam",5,2,2,"1996-1-12",201207208,7000000,0912121212,"tan@gmail.com","Ha Noi"),
		(3,"Hong Anh",1,2,3,"1986-10-19",201206204,6000000,0912121212,"tan@gmail.com","Sai Gon"),
		(4,"Thien Tam",2,3,1,"1986-10-19",201206204,6000000,0912121212,"tan@gmail.com","Sai Gon"),
		(5,"Hoang Vu",4,3,2,"1986-10-19",201206204,6000000,0912121212,"tan@gmail.com","Sai Gon"),
		(6,"Phat Dat",1,4,3,"1986-10-19",201206204,6000000,0912121212,"tan@gmail.com","Sai Gon");
 
 insert into dich_vu_di_kem
 values(1,"Massage",50000,2,"con"),
 (2,"Food",50000,2,"con"),
 (3,"Pool",80000,3,"con"),
 (4,"Karaoke",50000,10,"het"),
  (5,"RentCar",50000,20,"con");
  
  insert into loai_khach values
	(1, 'Diamond'),
	(2, 'Platinium'),
	(3, 'Gold'),
	(4, 'Silver'),
	(5, 'Member');
    
    insert into khach_hang values
	(1, 'Hung', '1997-11-20', 205201201, 0123456789, 'hung@gmail.com', 'Da Nang', 2),
	(2, 'Minh', '2005-04-09', 203203022, 0909090909, 'minh@gmail.com', 'Quang Tri', 1),
	(3, 'Tam', '1993-12-13', 201201201, 0905044567, 'tam@gmail.com', 'Thua Thien Hue', 3),
	(4, 'Khanh', '1999-2-18', 201201201, 0905044567, 'khanh@gmail.com', 'Quang Ngai', 4),
	(5, 'Long', '1985-12-11', 201201201, 0905044567, 'long@gmail.com', 'Sai Gon', 5);
    
    insert into kieu_thue values
	(1, 'Nam', 100000000),
	(2, 'Thang', 10000000),
	(3, 'Ngay', 1000000),
	(4, 'Gio', 100000);
    
    insert into loai_dich_vu values
	(1, 'Vip'),
	(2, 'Medium'),
	(3, 'President');
    
    insert into dich_vu values
    (1, 'Villa', 500, 5, 4, 20000000, 'Con', 2, 1),
    (2, 'House', 100, 3, 8, 8000000, 'Con', 1, 2),
    (3, 'Room', 50, 1, 4, 1000000, 'Con', 3, 3);
    
    insert into hop_dong values
	(1, '2018-12-04', '2020-12-25', 30000000, 60000000, 1, 2, 2),
	(2, '2019-12-14', '2021-01-05', 20000000, 40000000, 2, 1, 3),
	(3, '2021-01-30', '2015-01-01', 3000000, 6000000, 3, 5, 1),
    (4, '2019-03-21', '2015-01-01', 3000000, 6000000, 4, 4, 2),
    (5, '2020-6-30', '2015-01-01', 3000000, 6000000, 5, 3, 3)
;
    
 insert into hop_dong_chi_tiet values
	(1, 2, 3, 2),
	(2, 3, 5, 3),
	(3, 1, 1, 2);
 
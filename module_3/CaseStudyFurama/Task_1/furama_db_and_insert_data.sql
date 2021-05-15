create database casestudy_furama;
use casestudy_furama;
create table vi_tri(
	id_vi_tri int primary key,
    ten_vi_tri varchar(50)
);

create table trinh_do(
	id_trinh_do int primary key,
    trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int primary key,
ten_bo_phan varchar(45)
);

create table nhan_vien(
id_nhan_vien int primary key,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
cmnd int,
luong float,
so_dien_thoai int,
email varchar(50),
dia_chi varchar(50),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(50),
gia float,
don_vi float,
trang_thai_kha_dung varchar(50)
);
create table loai_khach(
id_loai_khach int primary key,
ten_loai_khach varchar(45)
);
create table khach_hang(
id_khach_hang int primary key,
ho_ten varchar(45),
ngay_sinh date,
cmnd int,
so_dien_thoai int,
email varchar(45),
dia_chi varchar (45),
id_loai_khach int,
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue(
id_kieu_thue integer primary key,
ten_kieu_thue varchar(50),
gia int
);

create table loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(50)
);

create table dich_vu(
id_dich_vu int primary key,
ten_dich_vu varchar(50),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue float,
trang_thai varchar(50),
id_kieu_thue int,
id_loai_dich_vu int,
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
id_hop_dong int primary key,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc float,
tong_tien float,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
foreign key (id_hop_dong) references hop_dong(id_hop_dong)
);


-- insert data database
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
 
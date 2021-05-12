use furama;
insert into BoPhan
values  (1,"Le Tan"),
		(2,"Phuc Vu"),
		(3,"Bao Ve"),
        (4,"Giam Doc");
 insert into DichVuDiKem
 values (1,"Thue Xe",10000,1000,"Con"),(2,"Cinema",100000,1000,"Het"),(3,"TamHoBoi",1000000,1000,"Con");
 
 insert into ViTri
 values (1,"Mat Tien"),(2,"Trung Tam"),(3,"Lau Hai");
 insert into TrinhDo
 values (1,"Cao Dang"),(2,"Dai Hoc"),(3,"Trung Cap");
 
insert into NhanVien
values (1,"Nguyen Van A",1,1,1,"1990-12-12",201201201,500000,0935454545,"anhtannguyen@gmail.com","Da Nang"),
		(2,"Nguyen Van B",2,2,2,"1990-12-13",201201200,500000,0935454548,"anhtannguyen1@gmail.com","Quang Ngai"),
		(3,"Nguyen Van C",2,2,2,"1990-12-14",201201208,500000,0935454547,"anhtannguyen2@gmail.com","Quang Tri");
 
 insert into LoaiKhach
 values (1,"Diamond"),(2,"Standard"),(3,"VIP");
 
 insert into KhachHang
 values (1,1,"Hoang Phi Hong","1989-12-23",20220202,0909090909,"phihong@gmail.com","Da Nang"),
		(2,2,"Tung Chua","1985-02-24",20220202,0909090808,"tungchua@gmail.com","Quang Nam"),
		(3,3,"Anh Tan","1982-1-23",20220202,0606060606,"anhtan@gmail.com","Quang Tri");
        
 insert into KieuThue
 values(1,"Thang",10000),(2,"Ngay",1000),(3,"Nam",1000000);
 
 insert into LoaiDichVu
 values(1,"Loai1"),(2,"Loai2"),(3,"Loai3");
 insert into DichVu
 values(1,"Massage",200,10,11,50000,1,1,"Ranh"),
		(2,"Xem Film",200,10,11,50000,2,2,"Ban"),
		(3,"Pool",200,10,11,50000,3,3,"Ranh");
 insert into HopDong
 values(1,1,1,1,"2020-12-12","2021-11-11",100000,10000000),
		(2,2,2,2,"2019-12-12","2020-11-11",100000,10000000),
		(3,3,3,3,"2018-12-12","2019-11-11",100000,10000000); 
insert into HopDongChiTiet
values (1,1,1,11),(2,2,2,12),(3,3,3,13);


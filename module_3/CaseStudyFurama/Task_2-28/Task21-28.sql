use casestudy_furama;


-- 	21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của 
--      tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 
--      1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”

create view v_nhan_vien as
select nv.id_nhan_vien , nv.ho_ten,  nv.dia_chi,  nv.ngay_sinh , hd.ngay_lam_hop_dong
from nhan_vien nv 
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where nv.dia_chi = "Hải Châu" and hd.ngay_lam_hop_dong = "2021-12-12"				
 group by nv.id_nhan_vien;
 
 
 -- kiểm tra lại view
 
 select * from v_nhan_vien;
 
 -- 22.	Thông qua khung nhìn V_NHANVIEN 
 -- thực hiện cập nhật địa chỉ thành “Liên 
--  Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
 
 update nhan_vien
 set dia_chi = "Liên Chiểu"
 where id_nhan_vien in (select id from(select id_nhan_vien as id from v_nhan_vien) sub_1);
 
 -- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với
	--      Id Khách hàng được truyền vào như là 1 tham số của Sp_1
DELIMITER //
create procedure procedure_sp_1 (p_id_khach_hang int)
begin 
	delete from khach_hang 
	where id_khach_hang = p_id_khach_hang;
end; //
 DELIMITER ;   
 
--  24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện
--  kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc 
--  không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
DELIMITER //
create procedure procedure_sp_2 (p_id_hop_dong int , p_ngay_lam_hop_dong date , p_ngay_ket_thuc date , p_tien_dat_coc float
									,p_tong_tien float , p_id_nhan_vien int , p_id_khach_hang int , p_id_dich_vu int)
begin
	-- kiểm tra nếu ko trùng khóa chính mà trùng khóa phụ 
    
	if not exists (select * from hop_dong hd where hd.id_hop_dong = p_id_hop_dong)									
     and exists (select * from nhan_vien nv where nv.id_nhan_vien = p_id_nhan_vien) 
     and exists (select * from khach_hang kh where kh.id_khach_hang = p_id_khach_hang)
     and exists (select * from dich_vu dv where dv.id_dich_vu = p_id_dich_vu)
	then
	
    insert into hop_dong
    values (p_id_hop_dong,p_ngay_lam_hop_dong,p_ngay_ket_thuc,p_tien_dat_coc,p_tong_tien,p_id_nhan_vien,p_id_khach_hang,p_id_dich_vu);
    -- cách in ra bảng
	-- select concat("Hợp Đồng : " , p_id_hop_dong ,  " Insert Thành Công" ) as thong_bao;
    
    -- cách ghi vào file 
    select concat("Hợp Đồng : " , p_id_hop_dong ,  " Insert Thành Công" ) as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';
	else 
   SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Thất bại';
    end if;
  end  ; //
DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
call procedure_sp_2 (16,"1990-12-12","1991-12-12",500000,50000000,1,1,1);
;


-- 25 .Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị 
-- tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
 create table `show`(
		tong_so int
    );

drop table `show_message`;

drop trigger tr_1;

DELIMITER //
create trigger tr_1 after delete on hop_dong
for each row
begin 
	declare count_dl int ;
    set count_dl = (select count(*) from hop_dong);
	insert into `show`
    values(count_dl);
end; //
DELIMITER ;
SET FOREIGN_KEY_CHECKS=0;  

delete from hop_dong
where id_hop_dong = 1 ;
select * from `show`;


-- 26.Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian 
--  cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
DELIMITER //
create trigger tr_2 before update on hop_dong
for each row
begin 
	if(datediff(hop_dong.ngay_ket_thuc,hop_dong.ngay_lam_hop_dong) < 2)
	then 
    SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
    else
    select concat("Thành Công Update : ", hop_dong.new.id_hop_dong) as log into outfile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/update.txt';
    end if;
end; //
DELIMITER ;

drop trigger tr_2;
-- 27 


DELIMITER //
 create function fc_count()
 returns int
 deterministic
 begin 
	declare count_dich_vu int;
    set count_dich_vu = (select count(id) from(select sum(dv.chi_phi_thue) as id from dich_vu dv 
											join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
												group by dv.id_dich_vu 
                                                having sum(dv.chi_phi_thue) > 2000000)x);
	return count_dich_vu;
    end;//
 
 DELIMITER ;
 
 select fc_count();
 
--  b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính 
--  từ lúc bắt đầu làm hợp đồng đến lúc
--  kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời 
--  gian dựa vào từng lần làm hợp đồng thuê dịch vụ, 
--  không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.

DELIMITER //
create function fc_2(p_id_khach_hang int)
returns int
deterministic
begin
	declare max_date int;
    set max_date  =  (select max(tg_dai_nhat) from (select datediff(hd.ngay_ket_thuc,hd.ngay_lam_hop_dong) as tg_dai_nhat
														from hop_dong hd where hd.id_khach_hang = p_id_khach_hang)
																	sub_qr1);
	return max_date;
end; //

DELIMITER ;

--  28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ 
-- đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những 
-- HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.
alter view v_dich_vu_lien_quan as
select dv.id_dich_vu,kh.id_khach_hang,nv.id_nhan_vien,hd.id_hop_dong from 
dich_vu dv join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang 
join nhan_vien nv on nv.id_nhan_vien = hd.id_nhan_vien
where dv.ten_dich_vu = "Room" 
and (year(hd.ngay_lam_hop_dong) between 2015 and 2019);


select * from v_dich_vu_lien_quan;

DELIMITER //
	create procedure sp_3()
    begin 
		delete from dich_vu
        where dich_vu.id_loai_dich_vu in (select id_dich_vu from v_dich_vu_lien_quan);
        delete from hop_dong
        where id_hop_dong in (select id_hop_dong from v_dich_vu_lien_quan );
    end; //                                                            
DELIMITER ;



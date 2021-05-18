use casestudy_furama;


-- 	21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của 
--      tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 
--      1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”

create view v_nhan_vien as
select nv.id_nhan_vien , nv.ho_ten,  nv.dia_chi,  nv.ngay_sinh , hd.ngay_lam_hop_dong
from nhan_vien nv 
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
where nv.dia_chi = "Hải Châu" and 
				(year(hd.ngay_lam_hop_dong) = 2019
                and month(hd.ngay_lam_hop_dong) = 12
                and day(hd.ngay_lam_hop_dong) = 12)
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
    declare thong_bao varchar(50);
	if not exists (select * from hop_dong hd where hd.id_hop_dong = p_id_hop_dong)									
     and exists (select * from nhan_vien nv where nv.id_nhan_vien = p_id_nhan_vien) 
     and exists (select * from khach_hang kh where kh.id_khach_hang = p_id_khach_hang)
     and exists (select * from dich_vu dv where dv.id_dich_vu = p_id_dich_vu)
	then
    insert into hop_dong
    values (p_id_hop_dong,p_ngay_lam_hop_dong,p_ngay_ket_thuc,p_tien_dat_coc,p_tong_tien,p_id_nhan_vien,p_id_khach_hang,p_id_dich_vu);
    set thong_bao = "bạn đã thành công" ;
	else 
    set thong_bao = "bạn đã nhập sai";
    end if;
  end  ; //
DELIMITER ;

-- 26.Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian 
--  cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
DELIMITER //
create trigger tr_2 before insert on hop_dong
for each row
begin 
	declare thong_bao varchar(50);
	if((day(hop_dong.ngay_ket_thuc) - day(hop.dong.ngay_lam_hop_dong)) < 2)
	then 
    set thong_bao = "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
    end if;
end; //
DELIMITER ;
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
 
 

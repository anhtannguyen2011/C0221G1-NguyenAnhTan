use casestudy_furama;
-- task 2
select * 
from nhan_vien
where (ho_ten like "K%" or ho_ten like "H%" or ho_ten like "T%") 
and length(ho_ten) <= 15;

-- task 3

select *
from khach_hang
where ((year(curdate()) - year(ngay_sinh)) <=50  and   (year(curdate()) - year(ngay_sinh)) >= 18 )
and (dia_chi like "Da Nang" or dia_chi like "Quang Tri");
SET SQL_SAFE_UPDATES = 0;


-- task 4

select hop_dong.id_khach_hang, khach_hang.ho_ten,loai_khach.ten_loai_khach, count(hop_dong.id_dich_vu) as dem_sohd
from hop_dong join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
where loai_khach.ten_loai_khach = "Diamond"
group by hop_dong.id_khach_hang
order by dem_sohd;

-- task 5

select kh.id_khach_hang, kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,
hd.ngay_lam_hop_dong,hd.ngay_ket_thuc, sum(dv.chi_phi_thue + (dvdk.gia * hdct.so_luong)) as tong_tien
from khach_hang as kh left join loai_khach as lk on kh.id_loai_khach = lk.id_loai_khach
					left join hop_dong as hd on kh.id_khach_hang = hd.id_khach_hang
                    left join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
                    left join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
                    left join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by kh.id_khach_hang, hd.id_hop_dong;                   
-- task 6

select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu, hd.ngay_lam_hop_dong, hd.id_hop_dong,dv.id_dich_vu
from dich_vu as dv join loai_dich_vu as ldv
on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong as hd on dv.id_dich_vu = hd.id_dich_vu 
where hd.id_dich_vu not in (select hd.id_dich_vu
							from hop_dong as hd
							where(year(hd.ngay_lam_hop_dong) = 2019) and (month(hd.ngay_lam_hop_dong) in (1,2,3)));



update hop_dong
set ngay_lam_hop_dong = "2019-2-24"
where id_hop_dong = 2;

-- task 7

select dv.id_dich_vu , dv.ten_dich_vu , dv.dien_tich, dv.so_nguoi_toi_da,
dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu as dv join loai_dich_vu as ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong as hd on dv.id_dich_vu = hd.id_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2018) and hd.id_dich_vu not in (select hd.id_dich_vu from hop_dong as hd where year(hd.ngay_lam_hop_dong) =2019);

-- câu lệnh test task 7
-- update hop_dong
-- set ngay_lam_hop_dong = "2018-2-24"
-- where id_hop_dong = 2;

-- task 8
update khach_hang 
set ho_ten = "Hung"
where id_khach_hang = 3;
-- cách 1
select distinct ho_ten from khach_hang;
-- cách 2
select ho_ten from khach_hang  group by ho_ten;
-- cách 3 
select DISTINCTROW ho_ten from khach_hang;
-- cách 4
select ho_ten from khach_hang 
 union
select ho_ten from khach_hang;

-- task 9

-- month(hd.ngay_lam_hop_dong) as "Tháng"
select month(hd.ngay_lam_hop_dong) as "Tháng", sum(dv.chi_phi_thue + (dvdk.gia * hdct.so_luong)) as "tong doanh thu"
from khach_hang as kh join loai_khach as lk on kh.id_loai_khach = lk.id_loai_khach
					join hop_dong as hd on kh.id_khach_hang = hd.id_khach_hang
                    join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
                    join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
                    join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong) = 2019
group by month(hd.ngay_lam_hop_dong);





update hop_dong
set ngay_lam_hop_dong = "2019-03-29"
where id_hop_dong = 2;

-- task 10

select hd.id_hop_dong, hd.ngay_lam_hop_dong , hd.ngay_ket_thuc , hd.tien_dat_coc, count(dvdk.id_dich_vu_di_kem)
from hop_dong as hd join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong 
join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by hdct.id_hop_dong;


-- task 11

select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,lk.ten_loai_khach,kh.dia_chi
from dich_vu dv
join hop_dong hd on dv.id_dich_vu = hd.id_dich_vu
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
where lk.ten_loai_khach = "Diamond" and (kh.dia_chi in ("Vinh","Quang Ngai"))
group by dv.ten_dich_vu;


update khach_hang
set dia_chi = "Da Nang"
where id_khach_hang = 5;

update khach_hang
set id_loai_khach = 1
where id_khach_hang = 1;


-- task 12

select hd.id_hop_dong, nv.ho_ten as "Nhân Viên", kh.ho_ten as "Khách Hàng", kh.so_dien_thoai, dv.ten_dich_vu, hd.ngay_lam_hop_dong, 
count(hdct.id_hop_dong_chi_tiet) as dem, hd.tien_dat_coc
from khach_hang as kh
join hop_dong as hd on kh.id_khach_hang = hd.id_khach_hang
join nhan_vien as nv on hd.id_nhan_vien = nv.id_nhan_vien
join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
where (year(hd.ngay_lam_hop_dong) =2019 and month(ngay_lam_hop_dong) in(10,11,12)) and hd.id_dich_vu 
not in (select hd.id_dich_vu from hop_dong as hd 
where (year(hd.ngay_lam_hop_dong) = 2019) and month(hd.ngay_lam_hop_dong) in (1,2,3,4,5,6))
group by hd.id_hop_dong;

update hop_dong
set ngay_lam_hop_dong = "2019-11-29"
where id_hop_dong = 3;

update hop_dong
set ngay_ket_thuc = "2021-12-12"
where id_hop_dong = 5;

-- task 13

select dvdk.ten_dich_vu_di_kem , dvdk.gia, dvdk.don_vi , sum(hdct.so_luong) as tong_so
from dich_vu_di_kem as dvdk
join hop_dong_chi_tiet as hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong as hd on hdct.id_hop_dong = hd.id_hop_dong
group by dvdk.ten_dich_vu_di_kem, dvdk.id_dich_vu_di_kem 
having tong_so >= all (select sum(hdct.so_luong) from hop_dong_chi_tiet as hdct
						group by hdct.id_dich_vu_di_kem);



-- task 14

select hd.id_hop_dong , dv.ten_dich_vu , dvdk.ten_dich_vu_di_kem, count(dvdk.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong as hd join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having count(dvdk.id_dich_vu_di_kem) = 1;
 
 
 -- task 15
 
 select nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi,count(hd.id_nhan_vien) as "Tổng Hợp Đòng"
 from nhan_vien as nv join trinh_do as td on nv.id_trinh_do = td.id_trinh_do
 join bo_phan as bp on nv.id_bo_phan = bp.id_bo_phan
 join vi_tri as vt on nv.id_vi_tri = vt.id_vi_tri
 join hop_dong as hd on hd.id_nhan_vien = nv.id_nhan_vien
 where year(hd.ngay_lam_hop_dong) between 2018 and 2019 
 group by nv.id_nhan_vien
 having count(hd.id_nhan_vien) <=3 ;
 
 update nhan_vien
 set ho_ten = "Van Long"
 where id_nhan_vien = 2;

 update nhan_vien
 set ho_ten = "Thien Ha"
 where id_nhan_vien = 3;
 
 update hop_dong
 set id_nhan_vien = 1
 where id_hop_dong = 2;
 
  update hop_dong
 set id_nhan_vien = 1
 where id_hop_dong = 3;
 
  update hop_dong
 set id_nhan_vien = 1
 where id_hop_dong = 4;
 
 -- task 16
  SET FOREIGN_KEY_CHECKS=0; -- to disable them
  
alter table hop_dong
add foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien) on delete cascade;
 

 delete from nhan_vien 
  where id_nhan_vien not in (select x.id from(select hop_dong.id_nhan_vien as id from hop_dong
											join nhan_vien 
										    where year(hop_dong.ngay_lam_hop_dong) >=2017 and year(hop_dong.ngay_lam_hop_dong) <2020)x);
SET FOREIGN_KEY_CHECKS=1; -- to re-enable them				
SET SQL_SAFE_UPDATES = 0;

 -- task 17
 
 
 update khach_hang
 set id_loai_khach = 1
 where id_loai_khach = 2  and khach_hang.id_khach_hang in (select id_khach_hang					
						from hop_dong as hd 
						join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
						join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
						join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
                        where year(ngay_lam_hop_dong) = 2019
                        group by hd.id_khach_hang
                        having sum(dv.chi_phi_thue + dvdk.gia * hdct.so_luong) > 10000000);
 
 
 -- task 18 
 
  SET FOREIGN_KEY_CHECKS=0;
  
 alter table hop_dong
 add foreign key (id_khach_hang) references khach_hang(id_khach_hang)
 on delete cascade;
 
 delete from khach_hang as kh where kh.id_khach_hang in
 (select sub_q2.id from (select kh.id_khach_hang as id from khach_hang as kh join hop_dong as
					hd on kh.id_khach_hang = hd.id_hop_dong where year(hd.ngay_lam_hop_dong) < 2016) sub_q2);				
SET FOREIGN_KEY_CHECKS=1;              						
 -- task 19
 SET SQL_SAFE_UPDATES = 0;
 update dich_vu_di_kem as dvdk
 set gia = gia * 2
 where dvdk.id_dich_vu_di_kem in (select sub_qr1.id from (select dvdk.id_dich_vu_di_kem as id , sum(hdct.so_luong) from dich_vu_di_kem as dvdk
									join hop_dong_chi_tiet as hdct on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
                                    join hop_dong as hd on hd.id_hop_dong = hdct.id_hop_dong
                                    where year(hd.ngay_lam_hop_dong) = 2019 
                                     group by hdct.id_dich_vu_di_kem
                                     having sum(hdct.so_luong) >= 10) sub_qr1);
 
 -- task 20
 
 select id_nhan_vien,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi
 from nhan_vien
 union all 
 select id_khach_hang, ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi
 from khach_hang;

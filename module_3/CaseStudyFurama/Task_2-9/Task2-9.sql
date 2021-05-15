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
-- where loai_khach.ten_loai_khach = "Diamond"
group by hop_dong.id_khach_hang
having loai_khach.ten_loai_khach = "Diamond"
order by dem_sohd;


-- task 5

select kh.id_khach_hang, kh.ho_ten,lk.ten_loai_khach,hd.id_hop_dong,dv.ten_dich_vu,
hd.ngay_lam_hop_dong,hd.ngay_ket_thuc, (dv.chi_phi_thue + (dvdk.gia * hdct.so_luong)) as tong_tien
from khach_hang as kh left join loai_khach as lk on kh.id_loai_khach = lk.id_loai_khach
					left join hop_dong as hd on kh.id_khach_hang = hd.id_khach_hang
                    left join dich_vu as dv on hd.id_dich_vu = dv.id_dich_vu
                    left join hop_dong_chi_tiet as hdct on hd.id_hop_dong = hdct.id_hop_dong
                    left join dich_vu_di_kem as dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem;

-- task 6

select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu as dv join loai_dich_vu as ldv
on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
left join hop_dong as hd on dv.id_dich_vu = hd.id_dich_vu 
where not ((year(hd.ngay_lam_hop_dong) = 2019) and (month(hd.ngay_lam_hop_dong) in (1,2,3)));



update hop_dong
set ngay_lam_hop_dong = "2019-2-24"
where id_hop_dong = 2;

-- task 7

select dv.id_dich_vu , dv.ten_dich_vu , dv.dien_tich, dv.so_nguoi_toi_da,
dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu as dv join loai_dich_vu as ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
join hop_dong as hd on dv.id_dich_vu = hd.id_hop_dong
where (year(hd.ngay_lam_hop_dong) = 2018) and hd.id_dich_vu not in (select hd.id_dich_vu from hop_dong as hd where year(hd.ngay_lam_hop_dong) =2019);


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

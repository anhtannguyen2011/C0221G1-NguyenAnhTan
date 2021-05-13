create database bai_tap1;
use bai_tap1;

create table phieu_xuat(
	so_px int primary key,
    ngay_xuat date
);
create table vat_tu(
	ma_vtu int primary key,
    ten_vtu varchar(50)
);	


create table chi_tiet_phieu_xuat(
	so_px int,
    ma_vtu int,
    dg_xuat varchar(40),
    sl_xuat int,
	primary key (so_px,ma_vtu),
    foreign key(so_px) references phieu_xuat(so_px),
    foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table phieu_nhap(
	so_pn int primary key,
    ngay_nhap date
);

create table chi_tiet_phieu_nhap(
	so_pn int,
	ma_vtu int,
    dg_nhap varchar(40),
    sl_nhap int,
    primary key(so_pn,ma_vtu),
	foreign key(so_pn) references phieu_nhap(so_pn),
    foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table don_dh(
	so_dh int primary key,
    ngay_dh date
);

create table chi_tiet_dat_hang(
	ma_vtu int,
    so_dh int,
    primary key (ma_vtu,so_dh),
    foreign key(ma_vtu) references vat_tu(ma_vtu),
     foreign key(so_dh) references don_dh(so_dh)
);
create table nha_cc(
	ma_ncc int primary key,
    ten_ncc varchar(50),
    dia_chi varchar(45),
    so_dh int,
    id_sdt int,
    foreign key (so_dh) references don_dh(so_dh),
    foreign key (id_sdt) references ncc_sdt(id_sdt)
);
create table ncc_sdt(
	id_sdt int primary key,
	sdt int	
);

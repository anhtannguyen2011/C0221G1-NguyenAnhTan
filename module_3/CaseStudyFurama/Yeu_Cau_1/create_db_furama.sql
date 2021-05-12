create database if not exists Furama;
use Furama;
create table ViTri(
	IDViTri int,
    TenViTri varchar(45),
	primary key (IDViTri)
);
create table TrinhDo(
	IDTrinhDo int,
    TrinhDo varchar(45),
    primary key (IDTrinhDo)
);
create table BoPhan(
	IDBoPhan int,
    TenBoPhan varchar(45),
    primary key (IDBoPhan)
);
create table NhanVien(
	IDNhanVien int,
    HoVaTenNV varchar(50),
    IDViTri int,
    IDTrinhDo int,
    IDBoPhan int,
    NgaySinh date,
    SoCMND int,
    Luong float,
    SDT int,
    Email varchar(45),
    DiaChi varchar(45),
    primary key (IDNhanVien),
    foreign key (IDViTri) references ViTri(IDViTri),
    foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
    foreign key (IDBoPhan) references BoPhan(IDBoPhan)
);

create table LoaiKhach(
	IDLoaiKhach int,
    TenLoaiKhach varchar(45),
    primary key (IDLoaiKhach)
);


create table KhachHang(
	IDKhachHang int,
	IDLoaiKhach int,
    HovaTen varchar(45),
    NgaySinh date,
    SoCMND varchar(45),
    SDT int,
    Email varchar(45),
    DiaChi varchar(45),
    primary key (IDKhachHang),
    foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);

create table KieuThue(
	IDKieuThue int,
    TenKieuThue varchar(45),
    Gia int,
    primary key (IDKieuThue)
);
create table LoaiDichVu(
	IDLoaiDichVu int primary key,
    TenLoaiDichVu varchar(45)
);

create table DichVu(
	IDDichVu int primary key,
    TenDichVu varchar(45),
    DienTich float,
    SoTang int,
    SoNguoiToiDa int,
    ChiPhiThue float,
    IDKieuThue int,
    IDLoaiDichVu int,
    TenLoaiDichVu varchar(50),
    foreign key (IDKieuThue) references KieuThue(IDKieuThue),
     foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);

create table DichVuDiKem(
	IDDichVuDiKem int primary key,
    TenDichVuDiKem varchar(45),
    Gia float,
    DonVi float,
    TrangThaiKhaDung varchar(45)

);

create table HopDong(
	IDHopDong int primary key,
    IDNhanVien int,
    IDKhachHang int,
    IDDichVu int,
    NgayLamHopDong date,
    NgayKetThuc date,
    TienDatCoc float,
    TongTien float,
	foreign key (IDNhanVien) references NhanVien(IDNhanVien),
    foreign key (IDKhachHang) references KhachHang(IDKhachHang),
    foreign key (IDDichVu) references DichVu(IDDichVu)
);


create table HopDongChiTiet(
	IDHopDongChiTiet int primary key,
    IDHopDong int,
    TenDichVuDiKem varchar(45),
    SoLuong int,
    foreign key (IDHopDong) references HopDong(IDHopDong),
   foreign key (IDHopDong) references HopDong(IDHopDong)
);


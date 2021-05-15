CREATE DATABASE QuanLyDiemThi;

USE QuanLyDiemThi;
CREATE TABLE hoc_sinh(
    ma_hs VARCHAR(20) PRIMARY KEY,
    ten_hs VARCHAR(50),
    ngay_sinh DATETIME,
    lop VARCHAR(20),
    gt VARCHAR(20)
);
CREATE TABLE mon_hoc(
    ma_mh VARCHAR(20) PRIMARY KEY,
    ten_mh VARCHAR(50)
);
CREATE TABLE giao_vien(
    ma_gv VARCHAR(20) PRIMARY KEY,
    ten_gv VARCHAR(20),
    sdt VARCHAR(10)
);
ALTER TABLE mon_hoc ADD ma_gv VARCHAR(20);
ALTER TABLE mon_hoc ADD CONSTRAINT FK_MaGV FOREIGN KEY (ma_gv) REFERENCES giao_vien(ma_gv);
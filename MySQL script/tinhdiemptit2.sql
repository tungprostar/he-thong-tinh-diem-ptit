drop database if exists tinhdiemptit;
create database tinhdiemptit;
use tinhdiemptit;

CREATE TABLE users (
  username varchar(50) NOT NULL,
  password char(68) NOT NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY (username)
) CHARACTER SET UTF8;

INSERT INTO users
VALUES 
('admin','{bcrypt}$2a$10$9zi5mDR0iCTlWHG8jknu/uCtTE7qgzGepTTg9nNI4a81yy6f6GKhq',1),
('khanh123','{bcrypt}$2a$10$9zi5mDR0iCTlWHG8jknu/uCtTE7qgzGepTTg9nNI4a81yy6f6GKhq',1),
('ngoc123','{bcrypt}$2a$10$9zi5mDR0iCTlWHG8jknu/uCtTE7qgzGepTTg9nNI4a81yy6f6GKhq',1),
('hung123','{bcrypt}$2a$10$9zi5mDR0iCTlWHG8jknu/uCtTE7qgzGepTTg9nNI4a81yy6f6GKhq',1),
('phuong123','{bcrypt}$2a$10$9zi5mDR0iCTlWHG8jknu/uCtTE7qgzGepTTg9nNI4a81yy6f6GKhq',1);

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS authorities;
CREATE TABLE `authorities` (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  UNIQUE KEY authorities_idx_1 (username,authority),
  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
) CHARACTER SET UTF8;

--
-- Dumping data for table `authorities`
--

INSERT INTO authorities
VALUES 
('admin','ROLE_ADMIN'),
('khanh123', 'ROLE_TEACHERINT1427'),
('ngoc123', 'ROLE_TEACHERINT1416'),
('phuong123', 'ROLE_TEACHERINT1408'),
('hung123', 'ROLE_TEACHERINT1427'),
('hung123', 'ROLE_TEACHERINT1408');

create table sinhvien (
  ma_sv   varchar(100) not null, 
  ho_lot  varchar(100), 
  ten     varchar(100), 
  ten_lop varchar(100), 
  primary key (ma_sv), 
  unique index (ma_sv)) CHARACTER SET UTF8;

create table cauhinhdiem(
	ma_cauhinh int primary key auto_increment,
    cauhinh varchar(100)
)CHARACTER SET UTF8;

create table monhoc (
  ma_monhoc  varchar(100) primary key, 
  ten_monhoc varchar(100), 
  so_tc int,
  cauhinhdiem_ma_cauhinh int,
  foreign key (cauhinhdiem_ma_cauhinh) references cauhinhdiem(ma_cauhinh)
  ) CHARACTER SET UTF8;
  
create table nhommonhoc(
	id int primary key auto_increment,
    nhom_monhoc int,
    monhoc_ma_monhoc varchar(100),
    foreign key (monhoc_ma_monhoc) references monhoc(ma_monhoc)
) CHARACTER SET UTF8;
  
create table sinhvien_monhoc (
  id int primary key auto_increment,
  sinhvien_ma_sv   varchar(100) not null, 
  nhommonhoc_id int not null,
  foreign key (sinhvien_ma_sv) references sinhvien(ma_sv),
  foreign key (nhommonhoc_id) references nhommonhoc(id)
  ) CHARACTER SET UTF8;

create table giangvien(
	ma_gv int primary key auto_increment, 
    ho_ten varchar(100),
    username varchar(50) not null,
    foreign key (username) references users(username)
)CHARACTER SET UTF8;

create table monhoc_giangvien(
	nhommonhoc_nhom_monhoc int not null,
    giangvien_ma_gv int not null,
    foreign key (giangvien_ma_gv) references giangvien(ma_gv),
	foreign key (nhommonhoc_nhom_monhoc) references nhommonhoc(id),
    primary key(nhommonhoc_nhom_monhoc, giangvien_ma_gv)
)CHARACTER SET UTF8;

create table diemso(
	ma_diemso int primary key auto_increment,
	diem_cc   int,
	diem_gk		float,
	diem_btl 	float,
	diem_thi 	float,
	diem_tb 	float,
    sinhvien_monhoc_id int,
	foreign key (sinhvien_monhoc_id) references sinhvien_monhoc(id)
)CHARACTER SET UTF8;

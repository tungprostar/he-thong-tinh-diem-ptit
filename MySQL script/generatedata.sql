insert into cauhinhdiem(cauhinh) values
('10/10/20/60'), (''), ('');

insert into monhoc(ma_monhoc, ten_monhoc, so_tc, cauhinhdiem_ma_cauhinh) values
('INT1416', 'Đảm bảo chất lượng phần mềm', 3, 1), 
('INT1427', 'Phát triển phần mềm hướng dịch vụ', 3, 2),
('INT1408', 'Chuyên đề công nghệ phần mềm', 1, 3);

insert into giangvien(ho_ten, username) values 
('Đỗ Thị Bích Ngọc', 'ngoc123'), ('Nguyễn Trọng Khánh', 'khanh123'), ('Nguyễn Duy Phương', 'phuong123'), ('Nguyễn Mạnh Hùng', 'hung123');

insert into nhommonhoc(nhom_monhoc, monhoc_ma_monhoc) values
(1, 'INT1416'), (2, 'INT1416'), (3, 'INT1416'), (4, 'INT1416'), (5, 'INT1416'),
(1, 'INT1427'), (2, 'INT1427'), (3, 'INT1427'),
(1, 'INT1408'), (2, 'INT1408'), (3, 'INT1408'), (4, 'INT1408');

insert into monhoc_giangvien(nhommonhoc_nhom_monhoc, giangvien_ma_gv) values
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1),
(6, 2), (7, 4), (8, 4),
(9, 4), (10, 4), (11, 3), (12, 3);

insert into sinhvien(ma_sv, ten) values
('MSV1', 'a'), ('MSV2', 'b'), ('MSV3', 'c'), ('MSV4', 'd'), ('MSV5', 'e'), ('MSV6', 'f'), ('MSV7', 'g'), ('MSV8', 'h'), ('MSV9', 'i'),
('MSV10', 'a1'), ('MSV11', 'b1'), ('MSV12', 'c1'), ('MSV13', 'd1'), ('MSV14', 'e1'), ('MSV15', 'f1'), ('MSV16', 'g1'), ('MSV17', 'h1'), ('MSV18', 'i1'),
('MSV19', 'a2'), ('MSV20', 'b2'), ('MSV21', 'c2'), ('MSV22', 'd2'), ('MSV23', 'e2'), ('MSV24', 'f2'), ('MSV25', 'g2'), ('MSV26', 'h2'), ('MSV27', 'i2');

## 1-5, 6-8, 9-12
insert into sinhvien_monhoc(sinhvien_ma_sv, nhommonhoc_id) values
('MSV1', 1), ('MSV1', 6), ('MSV1', 10), ('MSV2', 1), ('MSV2', 6), ('MSV2', 10), ('MSV2', 12), ('MSV3', 2),
('MSV4', 6), ('MSV5', 3), ('MSV5', 10), ('MSV5', 7), ('MSV6', 3), ('MSV6', 7), ('MSV7', 1), ('MSV7', 12);

insert into diemso(diem_cc, diem_gk, diem_btl, sinhvien_monhoc_id) values
(10, 8, 9, 1), (4, 2, 9, 2), (7, 8, 6, 3), (10, 5, 4, 4), (10, 2, 6, 5), (9.5, 6.5, 9, 6);

# MSV1 - 1, MSV2 - 4, MSV7 - 15
# 12 -> 2 sv -> INT1408 nhom 4

## NOTE sql
select * from diemso
right join sinhvien_monhoc on sinhvien_monhoc_id = sinhvien_monhoc.id
right join nhommonhoc on nhommonhoc_id = nhommonhoc.id 
right join sinhvien on sinhvien_ma_sv = ma_sv
where monhoc_ma_monhoc = 'INT1408';


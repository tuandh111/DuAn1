CREATE DATABASE CUAHANG_DT
GO
USE CUAHANG_DT
GO

CREATE TABLE VAITRO(
	MaVaiTro CHAR(10) PRIMARY KEY,
	ChucVu NVARCHAR(20) NOT NULL,
	GhiChu TEXT
)
CREATE TABLE NHANVIEN(
	MaNV CHAR(10) PRIMARY KEY,
	HoTen NVARCHAR(50) NOT NULL,
	NgaySinh DATE NOT NULL,
	GioiTinh BIT NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	SDT CHAR(15) NOT NULL UNIQUE,
	Email CHAR(50) NOT NULL UNIQUE,
	MatKhau CHAR(50) NOT NULL,
	MaVaiTro CHAR(10) NOT NULL,
	Hinh CHAR(100) NOT NULL,
	FOREIGN KEY (MaVaiTro) REFERENCES VAITRO(MaVaiTro) ON DELETE NO ACTION ON UPDATE CASCADE
)
alter table NHANVIEN add  TrangThai bit 
alter table NHANVIEN add TRANGTHAIXOA bit 
CREATE TABLE LUONG(
	MaLuong CHAR(10) PRIMARY KEY,
	SoNgayLam FLOAT NOT NULL,
	LuongCoBan MONEY NOT NULL,
	NgayVaoCTY DATE NOT NULL,
	SoGioTangCa FLOAT,
	LuongTangCa MONEY,
	KhoangTru MONEY,
	TongTien MONEY NOT NULL,
	TrangThai BIT NOT NULL,
	FOREIGN KEY (MaLuong) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE GIAMGIA(
	MaGiamGia CHAR(10) PRIMARY KEY,
	NgayBD DATETIME NOT NULL,
	NgayKT DATETIME NOT NULL,
	PhanTram FLOAT NOT NULL,
	MoTa TEXT,
	TrangThai BIT NOT NULL,
	MaNV CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE KHACHHANG(
	MaKH CHAR(10) PRIMARY KEY,
	TenKH NVARCHAR(50) NOT NULL,
	SDT CHAR(15) NOT NULL UNIQUE,
	NgaySinh DATE NOT NULL,
	DiaChi NVARCHAR(50) NOT NULL,
	GioiTinh BIT NOT NULL,
	LoaiKH NVARCHAR(20) NOT NULL,
	TrangThai BIT NOT NULL,
	MoTa TEXT,
	MaNV CHAR(10) NOT NULL,
	Hinh CHAR(100) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE LICHSU(
	ID INT IDENTITY(1,1) PRIMARY KEY,
	ThoiGianThem DATETIME,
	ThoiGianSua DATETIME,
	ThoiGianXoa DATETIME,
	ThoiGianHoatDong DATETIME NOT NULL,
	BangThaoTac NVARCHAR(50) NOT NULL,
	MaNV CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE SANPHAM(
	MaSP CHAR(10) PRIMARY KEY,
	TenSP NVARCHAR(50) NOT NULL,
	MAU NVARCHAR(20) NOT NULL,
	Gia MONEY NOT NULL,
	LoaiSP NVARCHAR(30) NOT NULL,
	NgayNhap DATETIME NOT NULL,
	NoiNhap NVARCHAR(50) NOT NULL,
	SoLuong INT NOT NULL,
	TrangThai BIT NOT NULL,
	Hinh CHAR(100) NOT NULL,
	MaNV CHAR(10) NOT NULL,
	MaGiamGia CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
	
)
create table CPU(
maCPU char(20) primary key,
loaiSP char(50) ,
)
create table ManHinh(
maManHinh char(20) primary key,
loaiSP char(50)
)
create table RAM(
maRAM char(10) primary key,
loaiSP char(50)
)
create table BoNho(
maBoNho char(10) primary key,
loaiSP char(50)
)
create table Camera(
maCamera char(20) primary key,
loaiSP char(50)
)
create table Pin(
maPin char(10) primary key,
loaiSP char(50)
)
CREATE TABLE DIENTHOAI(
	MaDT CHAR(10) PRIMARY KEY,
	CPU CHAR(20) NOT NULL,
	MangHinh CHAR(20) NOT NULL,
	BoNho CHAR(10) NOT NULL,
	MoTa TEXT,
	CAMERA CHAR(20) NOT NULL,
	Pin CHAR(10) NOT NULL,
	RAM CHAR(10) NOT NULL,
	FOREIGN KEY (MaDT) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (CPU) REFERENCES CPU(maCPU) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MangHinh) REFERENCES ManHinh(maManHinh) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (RAM) REFERENCES RAM(maRAM) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (BoNho) REFERENCES BoNho(maBoNho) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (CAMERA) REFERENCES Camera(maCamera) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (Pin) REFERENCES Pin(maPin) ON DELETE NO ACTION ON UPDATE CASCADE
)

CREATE TABLE HOADON(
	MaHD CHAR(10) PRIMARY KEY,
	SoLuong INT,
	TrangThai BIT,
	DonGia MONEY,
	TongTien MONEY,
	NgayXuat DATETIME,
	MoTa TEXT,
	TenCTY NVARCHAR(50),
	MaNV CHAR(10),
	TenKH NVARCHAR(50),
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE HOADONCT(
	MaHDCT INT IDENTITY(1,1) PRIMARY KEY,
	MaSP CHAR(10) NOT NULL,
	SoLuong INT NOT NULL,
	MaHD CHAR(10) NOT NULL,
	Gia money not null,
	FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE NO ACTION
)
CREATE TABLE BAOHANH(
	MaBH CHAR(10) PRIMARY KEY,
	MaHD CHAR(10) ,
	SoIMEI CHAR(15),
	NgayBH DATETIME ,
	NgayHetHan DATETIME ,
	GhiChu TEXT,
	MaKH CHAR(10),
	FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH) ON DELETE NO ACTION ON UPDATE CASCADE,
)
create table BAOHANHCT(
MaBHCT int identity(1,1) primary key,
MaBH char(10) not  null,
MaSP char(10) not null,
soLuong int not null
foreign key (MaSP) references SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE,
foreign key (MaBH) references BAOHANH(MaBH) ON DELETE NO ACTION ON UPDATE NO ACTION
)

CREATE TABLE DATSP(
	MaDH CHAR(10) PRIMARY KEY,
	SoLuong INT NULL,
	SDT CHAR(15)  NULL ,
	TrangThai BIT NULL,
	DonGia MONEY NULL,
	TongTien MONEY NULL,
	ThoiGianDat datetime ,
	MaNV CHAR(10)  NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE DATSPCT(
	MaDatCT INT IDENTITY(1,1) PRIMARY KEY,
	SoLuong INT NOT NULL,
	gia money not null,
	MaDH CHAR(10) NOT NULL,
	MaSP CHAR(10) NOT NULL,
	FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaDH) REFERENCES DATSP(MaDH) ON DELETE NO ACTION ON UPDATE NO ACTION

)
--Them dòng máy







Insert into VAITRO values ('QL',N'Quản lý',null)
Insert into VAITRO values ('NV',N'Nhân Viên',null)

Insert into NHANVIEN values ('NV001',N'Trần Văn An','2003-01-23',1,N'Cần Thơ','0987123456','antv@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,1)
Insert into NHANVIEN values ('NV002',N'Nguyễn Thanh Bình','1999-11-12',1,N'An Giang','0981234556','binhnt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','QL','null',1,1)
Insert into NHANVIEN values ('NV003',N'Trần Ngọc Thạch','2001-10-10',1,N'Trà Vinh','0987126543','thachnt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',0,1)
Insert into NHANVIEN values ('NV004',N'Nguyễn Thị Ngân','2001-12-30',0,N'Cần Thơ','0127123456','ngannt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,1)
Insert into NHANVIEN values ('NV005',N'Lê Thị Chúc','2002-01-10',0,N'Kiên Giang','0247123456','chuclt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',0,1)
Insert into NHANVIEN values ('NV006',N'Trần Thành Ân','1998-01-10',1,N'Cà Mau','0912343456','antt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,0)
Insert into NHANVIEN values ('NV007',N'Nguyễn Văn Minh','1999-01-10',1,N'Long An','0232323456','minhnv@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,1)
Insert into NHANVIEN values ('NV008',N'Nguyễn Thanh Tâm','1998-01-10',1,N'Cần Thơ','0987987987','tamnt@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,1)
Insert into NHANVIEN values ('NV009',N'Lê Ngọc Ánh','2000-01-10',0,N'An Giang','0987456456','anhln@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','QL','null',1,1)
Insert into NHANVIEN values ('NV010',N'Lê Ngọc Hà','2000-01-10',0,N'An Giang','0987456444','haln@gmail.com','JH/FaL0/1KjSg+VbI+Cg9ikGwG8=','NV','null',1,1)

Insert into LUONG values ('NV001','31','20000','2022-12-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV002','30','20000','2023-02-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV003','30','20000','2023-03-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV004','29','20000','2023-02-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV005','28','20000','2023-06-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV006','31','20000','2023-04-18','15','25000',null,'5000000',1)
Insert into LUONG values ('NV007','31','20000','2023-05-25','15','25000',null,'5000000',1)
Insert into LUONG values ('NV008','30','30000','2022-12-27','15','25000',null,'5000000',1)
Insert into LUONG values ('NV009','31','30000','2023-01-30','15','25000',null,'5000000',1)

Insert into GIAMGIA values ('KM001','2022-12-12','2023-01-15','0.1',null,1,'NV001')
Insert into GIAMGIA values ('KM002','2022-12-01','2022-12-15','0.15',null,1,'NV001')
Insert into GIAMGIA values ('KM003','2023-02-12','2023-03-15','0.2',null,1,'NV002')
Insert into GIAMGIA values ('KM004','2023-04-12','2023-05-15','0.05',null,1,'NV001')
Insert into GIAMGIA values ('KM005','2022-10-12','2022-12-15','0.1',null,1,'NV002')
Insert into GIAMGIA values ('KM006','2023-01-12','2023-01-27','0.15',null,1,'NV001')
Insert into GIAMGIA values ('KM007','2022-10-12','2022-12-15','0.2',null,1,'NV002')
Insert into GIAMGIA values ('KM008','2022-11-12','2023-01-05','0.18',null,1,'NV001')

Insert into KHACHHANG values ('KH00001',N'Trần Thị Ánh','0989898989','2002-10-10',N'Cần Thơ',1,'VIP1',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00002',N'Nguyễn Thị Minh','0923232323','2002-10-10',N'Trà Vinh',0,'VIP1',1,null,'NV002','null')
Insert into KHACHHANG values ('KH00003',N'Lê Thanh Chúc','0999999999','2002-10-10',N'Cần Thơ',0,N'Thường',1,null,'NV003','null')
Insert into KHACHHANG values ('KH00004',N'Nguyễn Thanh Ngọc','0988888888','2002-10-10',N'An Giang',0,N'Thường',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00005',N'Trần Ngọc Cầm','0981234567','2002-10-10',N'Hậu Giang',0,N'Thường',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00006',N'Trần Thanh Trí','0912121212','2002-10-10',N'Cần Thơ',1,N'Thường',1,null,'NV002','null')
Insert into KHACHHANG values ('KH00007',N'Trần Anh Khoa','0933112233','2002-10-10',N'Cà Mau',1,'VIP2',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00008',N'Nguyễn Anh Duy','0989898988','2002-10-10',N'Cần Thơ',1,'VIP2',1,null,'NV002','null')


Insert into LICHSU values (null,null,null,'2023-07-01',N'Hóa Đơn','NV001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Bảo Hành','NV001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-06-30',N'Đặt Hàng','NV001')
Insert into LICHSU values (null,null,null,'2023-06-29',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-05-16',N'Đặt Hàng','NV001')
Insert into LICHSU values (null,null,null,'2023-07-15',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-03-01',N'Bảo Hành','NV001')

Insert into SANPHAM values ('SP00001','Samsung A73',N'Trắng','14500000',N'Iphone','2022-01-01',N'Nước Mỹ',12,1,'null','NV001','KM001')
Insert into SANPHAM values ('SP00002','IPHONE 13S',N'Vàng','11500000',N'Iphone','2022-01-01',N'Nước China',20,1,'null','NV001','KM002')
Insert into SANPHAM values ('SP00003','Sony F20',N'Đen','10500000',N'Iphone','2022-01-01',N'Nước Nhật',22,1,'null','NV001','KM003')
Insert into SANPHAM values ('SP00004','IPHONE 14S',N'Trắng','11500000',N'Iphone','2022-01-01',N'Nước Mỹ',17,1,'null','NV002','KM004')
Insert into SANPHAM values ('SP00005','IPHONE 14S',N'Trắng','10500000',N'Iphone','2022-01-01',N'Nước Mỹ',32,1,'null','NV002','KM005')
Insert into SANPHAM values ('SP00006','IPHONE 14S',N'Trắng','9500000',N'Iphone','2022-01-01',N'Nước Nhật',18,1,'null','NV002','KM006')
Insert into SANPHAM values ('SP00007','IPHONE 14S',N'Xanh','22500000',N'Iphone','2022-01-01',N'Nước Nhật',12,1,'null','NV002','KM007')
Insert into SANPHAM values ('SP00008','IPHONE 14S',N'Trắng','15500000',N'Iphone','2022-01-01',N'Nước Nhật',35,1,'null','NV001','KM001')
Insert into SANPHAM values ('SP00009','IPHONE 14S',N'Đen','14500000',N'Iphone','2022-01-01',N'Nước Mỹ',27,1,'null','NV001','KM002')

insert into CPU values ('Bionics','iPhone')
insert into CPU values ('NDragons','iPhone')
insert into CPU values ('Helios','iPhone')
insert into CPU values ('Bionits','SamSung')
insert into CPU values ('NDragos','SamSung')
insert into CPU values ('Helyos','Sony')

insert into BoNho values('12GB','iPhone')
insert into BoNho values('111GB','iPhone')
insert into BoNho values('198GB','iPhone')
insert into BoNho values('11GB','SamSung')
insert into BoNho values('151GB','SamSung')
insert into BoNho values('178GB','Sony')


insert into RAM values('1GB','iPhone')
insert into RAM values('4GB','iPhone')
insert into RAM values('94GB','SamSung')
insert into RAM values('63GB','Sony')


insert into Camera values('26px','iPhone')
insert into Camera values('22Mb','iPhone')
insert into Camera values('27px','SamSung')
insert into Camera values('21Mb','Sony')


insert into Pin values('5453mAh','iPhone')
insert into Pin values('4657Mh','iPhone')
insert into Pin values('4757Mh','SamSung')
insert into Pin values('4627Mh','Sony')


insert into ManHinh values('HDe','iPhone')
insert into ManHinh values('OLEDt','iPhone')
insert into ManHinh values('HDPluys','iPhone')
insert into ManHinh values('HDt','SamSung')
insert into ManHinh values('OLEt','SamSung')
insert into ManHinh values('HDluys','Sony')



Insert into DIENTHOAI values('SP00001','Bionics','HDe','11GB',null,'26px','5453mAh','1GB')
Insert into DIENTHOAI values('SP00002','Bionics','HDe','12GB',null,'26px','5453mAh','4GB')
Insert into DIENTHOAI values('SP00003','Bionics','HDe','111GB',null,'26px','5453mAh','1GB')
Insert into DIENTHOAI values('SP00004','Bionics','HDe','12GB',null,'22Mb','5453mAh','4GB')
Insert into DIENTHOAI values('SP00005','Bionics','HDe','111GB',null,'26px','4657Mh','1GB')
Insert into DIENTHOAI values('SP00006','Bionics','OLEDt','11GB',null,'22Mb','4657Mh','1GB')
Insert into DIENTHOAI values('SP00007','Bionics','OLEDt','12GB',null,'22Mb','4657Mh','1GB')
Insert into DIENTHOAI values('SP00008','Bionics','OLEDt','111GB',null,'22Mb','4657Mh','1GB')
Insert into DIENTHOAI values('SP00009','Bionics','HDe','12GB',null,'22Mb','5453mAh','4GB')


Insert into HOADON values ('HD00001',2,1,'14500000','29000000','2023-07-07',null,'Apple','NV001',N'Trần Thị Ánh')
Insert into HOADON values ('HD00002',1,1,'10500000','10500000','2023-07-07',null,'Apple','NV001',N'Nguyễn Thị Minh')
Insert into HOADON values ('HD00003',3,1,'11500000','34500000','2023-07-07',null,'Apple','NV001',N'Lê Thanh Chúc')
Insert into HOADON values ('HD00004',1,1,'14500000','29000000','2023-07-07',null,'Apple','NV001',N'Nguyễn Thanh Ngọc')
Insert into HOADON values ('HD00005',2,1,'14500000','29000000','2023-07-07',null,'Apple','NV002',N'Trần Ngọc Cầm')
Insert into HOADON values ('HD00006',1,1,'14500000','29000000','2023-07-07',null,'Apple','NV002',N'Trần Thanh Trí')
Insert into HOADON values ('HD00007',2,0,'14500000','29000000','2023-07-07',null,'Apple','NV002',N'Trần Anh Khoa')
Insert into HOADON values ('HD00008',3,1,'14500000','29000000','2023-07-07',null,'Apple','NV002',N'Nguyễn Anh Duy')


Insert into HOADONCT values ('SP00002',3,'HD00001','100000000')
Insert into HOADONCT values ('SP00002',1,'HD00002','100000000')
Insert into HOADONCT values ('SP00001',7,'HD00003','100000000')
Insert into HOADONCT values ('SP00003',4,'HD00004','100000000')
Insert into HOADONCT values ('SP00001',6,'HD00005','100000000')
Insert into HOADONCT values ('SP00002',2,'HD00006','100000000')
Insert into HOADONCT values ('SP00008',6,'HD00007','100000000')
Insert into HOADONCT values ('SP00004',5,'HD00008','100000000')




Insert into BAOHANH values ('BH00001','HD00001','123123','2023-01-20','2023-02-25',null,'KH00001')
Insert into BAOHANH values ('BH00002','HD00002','112121','2023-01-20','2023-02-25',null,'KH00002')
Insert into BAOHANH values ('BH00003','HD00003','234123','2023-01-20','2023-02-25',null,'KH00008')
Insert into BAOHANH values ('BH00004','HD00004','192572','2023-01-20','2023-02-25',null,'KH00006')
Insert into BAOHANH values ('BH00005','HD00005','987123','2023-01-20','2023-02-25',null,'KH00005')
Insert into BAOHANH values ('BH00006','HD00006','567232','2023-01-20','2023-02-25',null,'KH00003')


insert into BAOHANHCT values('BH00001','SP00001','103')
insert into BAOHANHCT values('BH00002','SP00002','112')
insert into BAOHANHCT values('BH00003','SP00003','230')
insert into BAOHANHCT values('BH00004','SP00004','98')
insert into BAOHANHCT values('BH00005','SP00005','198')
insert into BAOHANHCT values('BH00006','SP00006','28')



Insert into DATSP values ('DH00001',5,'0987121212',1,'58500000','60000000',0.1,'NV001')
Insert into DATSP values ('DH00002',3,'0989898989',1,'58500000','60000000',0.1,'NV001')
Insert into DATSP values ('DH00003',15,'0999999999',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00004',20,'0988776690',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00005',8,'0222222222',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00006',12,'0911111111',1,'58500000','60000000',0.1,'NV001')

Insert into DATSPCT values (3,'12000000','DH00001','SP00002')
Insert into DATSPCT values (7,'12000000','DH00002','SP00001')
Insert into DATSPCT values (10,'12000000','DH00003','SP00003')
Insert into DATSPCT values (12,'12000000','DH00004','SP00001')
Insert into DATSPCT values (9,'12000000','DH00005','SP00002')
Insert into DATSPCT values (6,'12000000','DH00006','SP00004')


--doanh thu

CREATE PROCEDURE sp_thongke_doanhthu_tuan
AS
BEGIN

DECLARE @ngaybatdau DATETIME,
    @ngayketthuc DATETIME;

SET @ngaybatdau = DATEADD(DAY, -6, GETDATE());
SET @ngayketthuc = GETDATE();

SELECT
    NgayXuat,
    SUM(TongTien) AS DoanhThu
FROM HOADON
WHERE NgayXuat BETWEEN @ngaybatdau AND @ngayketthuc
GROUP BY NgayXuat;

END;


CREATE PROCEDURE sp_thongke_doanhthu_thang
AS
BEGIN

DECLARE @ngaybatdau DATETIME,
    @ngayketthuc DATETIME;

SET @ngaybatdau = DATEADD(MONTH, -1, GETDATE());
SET @ngayketthuc = GETDATE();

SELECT
    NgayXuat,
    SUM(TongTien) AS DoanhThu
FROM HOADON
WHERE NgayXuat BETWEEN @ngaybatdau AND @ngayketthuc
GROUP BY NgayXuat;

END;

CREATE PROCEDURE sp_thongke_doanhthu_nam
AS
BEGIN

DECLARE @ngaybatdau DATETIME,
    @ngayketthuc DATETIME;

SET @ngaybatdau = DATEADD(YEAR, -1, GETDATE());
SET @ngayketthuc = GETDATE();

SELECT
    NgayXuat,
    SUM(TongTien) AS DoanhThu
FROM HOADON
WHERE NgayXuat BETWEEN @ngaybatdau AND @ngayketthuc
GROUP BY NgayXuat;

END;

--thống kê loại sản phẩm
CREATE PROCEDURE sp_thongke_sanpham
@loaisp NVARCHAR(30)
AS
BEGIN

SELECT
    LoaiSP,
    SUM(SoLuong) AS SoLuong
FROM SANPHAM
WHERE LoaiSP = @loaisp
GROUP BY LoaiSP;

END;


--thống kê tổng tiền đặt hàng
CREATE PROCEDURE sp_thongke_tongtien_dathang
AS
BEGIN

SELECT
    SUM(TongTien) AS TongTien
FROM DATSP;

END;

--thống kê sản phẩm
CREATE PROCEDURE sp_thongKeTongSoLuongSanPhamXoa
AS
BEGIN
    SELECT SUM(SoLuong) AS TongSoLuong
    FROM SANPHAM
    WHERE TrangThai = 1;
END;

--
CREATE PROCEDURE MaxMaSP
AS
BEGIN
    SELECT MAX(MaSP) AS MaxProductCode
    FROM SANPHAM;
END
GO

--
CREATE PROCEDURE MaxMaNV
AS
BEGIN
    SELECT MAX(MaNV) AS MaxProductCode
    FROM NHANVIEN;
END
GO

--
CREATE PROCEDURE MaxMaGG
AS
BEGIN
    SELECT MAX(MaGiamGia) AS MaxProductCode
    FROM GIAMGIA;
END
GO

--
CREATE PROCEDURE MaxMaDH
AS
BEGIN
    SELECT MAX(MaDH) AS MaxProductCode
    FROM DATSP;
END
GO
--
CREATE PROCEDURE MaxMaBH
AS
BEGIN
    SELECT MAX(MaBH) AS MaxProductCode
    FROM BAOHANH;
END
--

CREATE PROCEDURE MaxMaKH
AS
BEGIN
    SELECT MAX(MaKH) AS MaxProductCode
    FROM KHACHHANG;
END
GO
--
CREATE PROCEDURE MaxMadatsp
AS
BEGIN
    SELECT MAX(Madh) AS MaxProductCode
    FROM datSp;
END
GO



CREATE PROCEDURE MaxHDDH
AS
BEGIN
    SELECT MAX(MaHD) AS MaxProductCode
    FROM HOADON;
END
GO
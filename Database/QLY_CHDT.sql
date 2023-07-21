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
	MaDT CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
	
)
CREATE TABLE DIENTHOAI(
	MaDT CHAR(10) PRIMARY KEY,
	CPU CHAR(20) NOT NULL,
	MangHinh CHAR(20) NOT NULL,
	BoNho CHAR(10) NOT NULL,
	MoTa TEXT,
	MaSP CHAR(10) NOT NULL,
	CAMERA CHAR(20) NOT NULL,
	Pin CHAR(10) NOT NULL,
	RAM CHAR(10) NOT NULL,
	FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE
)

CREATE TABLE HOADON(
	MaHD CHAR(10) PRIMARY KEY,
	TenSP NVARCHAR(50) NOT NULL,
	SoLuong INT NOT NULL,
	TrangThai BIT NOT NULL,
	DonGia MONEY NOT NULL,
	TongTien MONEY NOT NULL,
	Thue FLOAT,
	NgayXuat DATETIME NOT NULL,
	MoTa TEXT,
	TenCTY NVARCHAR(50) NOT NULL,
	MaNV CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE HOADONCT(
	MaHDCT INT IDENTITY(1,1) PRIMARY KEY,
	MaSP CHAR(10) NOT NULL,
	SoLuong INT NOT NULL,
	MaHD CHAR(10) NOT NULL,
	FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE NO ACTION
)
CREATE TABLE BAOHANH(
	MaBH CHAR(10) PRIMARY KEY,
	MaHD CHAR(10) NOT NULL,
	SoIMEI CHAR(15) NOT NULL,
	NgayBH DATETIME NOT NULL,
	NgayHetHan DATETIME NOT NULL,
	GhiChu TEXT,
	MaKH CHAR(10) NOT NULL,
	FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD) ON DELETE NO ACTION ON UPDATE NO ACTION
)
CREATE TABLE DATSP(
	MaDH CHAR(10) PRIMARY KEY,
	SoLuong INT NOT NULL,
	SDT CHAR(15) NOT NULL UNIQUE,
	TrangThai BIT NOT NULL,
	DonGia MONEY NOT NULL,
	TongTien MONEY NOT NULL,
	Thue FLOAT,
	MaNV CHAR(10) NOT NULL,
	FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)
CREATE TABLE DATSPCT(
	MaDatCT INT IDENTITY(1,1) PRIMARY KEY,
	SoLuong INT NOT NULL,
	MaDH CHAR(10) NOT NULL,
	MaSP CHAR(10) NOT NULL,
	FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaDH) REFERENCES DATSP(MaDH) ON DELETE NO ACTION ON UPDATE NO ACTION

)

Insert into VAITRO values ('QL',N'Quản lý',null)
Insert into VAITRO values ('NV',N'Nhân Viên',null)

Insert into NHANVIEN values ('NV001',N'Trần Văn An','2003-01-23',1,N'Cần Thơ','0987123456','antv@gmail.com','123','NV','null')
Insert into NHANVIEN values ('QL001',N'Nguyễn Thanh Bình','1999-11-12',1,N'An Giang','0981234556','binhnt@gmail.com','123','QL','null')
Insert into NHANVIEN values ('NV002',N'Trần Ngọc Thạch','2001-10-10',1,N'Trà Vinh','0987126543','thachnt@gmail.com','123','NV','null')
Insert into NHANVIEN values ('NV003',N'Nguyễn Thị Ngân','2001-12-30',0,N'Cần Thơ','0127123456','ngannt@gmail.com','123','NV','null')
Insert into NHANVIEN values ('NV004',N'Lê Thị Chúc','2002-01-10',0,N'Kiên Giang','0247123456','chuclt@gmail.com','123','NV','null')
Insert into NHANVIEN values ('NV005',N'Trần Thành Ân','1998-01-10',1,N'Cà Mau','0912343456','antt@gmail.com','123','NV','null')
Insert into NHANVIEN values ('NV006',N'Nguyễn Văn Minh','1999-01-10',1,N'Long An','0232323456','minhnv@gmail.com','123','NV','null')
Insert into NHANVIEN values ('NV007',N'Nguyễn Thanh Tâm','1998-01-10',1,N'Cần Thơ','0987987987','tamnt@gmail.com','123','NV','null')
Insert into NHANVIEN values ('QL002',N'Lê Ngọc Ánh','2000-01-10',0,N'An Giang','0987456456','anhln@gmail.com','123','QL','null')

Insert into LUONG values ('NV001','31','20000','2022-12-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV002','30','20000','2023-02-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV003','30','20000','2023-03-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV004','29','20000','2023-02-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV005','28','20000','2023-06-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV006','31','20000','2023-04-18','15','25000',null,'5000000',1)
Insert into LUONG values ('NV007','31','20000','2023-05-25','15','25000',null,'5000000',1)
Insert into LUONG values ('QL001','30','30000','2022-12-27','15','25000',null,'5000000',1)
Insert into LUONG values ('QL002','31','30000','2023-01-30','15','25000',null,'5000000',1)

Insert into GIAMGIA values ('GG001','2022-12-12','2023-01-15','0.1',null,1,'NV001')
Insert into GIAMGIA values ('GG002','2022-12-01','2022-12-15','0.15',null,1,'QL001')
Insert into GIAMGIA values ('GG003','2023-02-12','2023-03-15','0.2',null,1,'QL002')
Insert into GIAMGIA values ('GG004','2023-04-12','2023-05-15','0.05',null,1,'QL001')
Insert into GIAMGIA values ('GG005','2022-10-12','2022-12-15','0.1',null,1,'QL002')
Insert into GIAMGIA values ('GG006','2023-01-12','2023-01-27','0.15',null,1,'QL001')
Insert into GIAMGIA values ('GG007','2022-10-12','2022-12-15','0.2',null,1,'QL002')
Insert into GIAMGIA values ('GG008','2022-11-12','2023-01-05','0.18',null,1,'QL001')

Insert into KHACHHANG values ('KH001',N'Trần Thị Ánh','0989898989','2002-10-10',N'Cần Thơ',1,'VIP1',1,null,'NV001','null')
Insert into KHACHHANG values ('KH002',N'Nguyễn Thị Minh','0923232323','2002-10-10',N'Trà Vinh',0,'VIP1',1,null,'NV002','null')
Insert into KHACHHANG values ('KH003',N'Lê Thanh Chúc','0999999999','2002-10-10',N'Cần Thơ',0,N'Thường',1,null,'NV003','null')
Insert into KHACHHANG values ('KH004',N'Nguyễn Thanh Ngọc','0988888888','2002-10-10',N'An Giang',0,N'Thường',1,null,'QL001','null')
Insert into KHACHHANG values ('KH005',N'Trần Ngọc Cầm','0981234567','2002-10-10',N'Hậu Giang',0,N'Thường',1,null,'NV001','null')
Insert into KHACHHANG values ('KH006',N'Trần Thanh Trí','0912121212','2002-10-10',N'Cần Thơ',1,N'Thường',1,null,'QL002','null')
Insert into KHACHHANG values ('KH007',N'Trần Anh Khoa','0933112233','2002-10-10',N'Cà Mau',1,'VIP2',1,null,'QL001','null')
Insert into KHACHHANG values ('KH008',N'Nguyễn Anh Duy','0989898988','2002-10-10',N'Cần Thơ',1,'VIP2',1,null,'QL002','null')

Insert into LICHSU values (null,null,null,'2023-07-01',N'Hóa Đơn','QL001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Bảo Hành','QL001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Hóa Đơn','QL002')
Insert into LICHSU values (null,null,null,'2023-06-30',N'Đặt Hàng','QL001')
Insert into LICHSU values (null,null,null,'2023-06-29',N'Hóa Đơn','QL002')
Insert into LICHSU values (null,null,null,'2023-05-16',N'Đặt Hàng','QL001')
Insert into LICHSU values (null,null,null,'2023-07-15',N'Hóa Đơn','QL002')
Insert into LICHSU values (null,null,null,'2023-03-01',N'Bảo Hành','QL001')

Insert into SANPHAM values ('IP001','IPNONE 14S',N'Trắng','14500000',N'Nhập US','2022-01-01',N'Nước Mỹ',12,1,'null','QL001','GG001','DT001')
Insert into SANPHAM values ('IP002','IPNONE 13S',N'Vàng','11500000',N'Nhập CV','2022-01-01',N'Nước China',20,1,'null','QL001','GG002','DT002')
Insert into SANPHAM values ('IP003','IPNONE 12S',N'Đen','10500000',N'Nhập JV','2022-01-01',N'Nước Nhật',22,1,'null','QL001','GG003','DT003')
Insert into SANPHAM values ('SS001','IPNONE 14S',N'Trắng','11500000',N'Nhập US','2022-01-01',N'Nước Mỹ',17,1,'null','QL002','GG004','DT004')
Insert into SANPHAM values ('SS002','IPNONE 14S',N'Trắng','10500000',N'Nhập US','2022-01-01',N'Nước Mỹ',32,1,'null','QL002','GG005','DT005')
Insert into SANPHAM values ('SS003','IPNONE 14S',N'Trắng','9500000',N'Nhập JV','2022-01-01',N'Nước Nhật',18,1,'null','QL002','GG006','DT006')
Insert into SANPHAM values ('SN001','IPNONE 14S',N'Xanh','22500000',N'Nhập JV','2022-01-01',N'Nước Nhật',12,1,'null','QL002','GG007','DT007')
Insert into SANPHAM values ('SN002','IPNONE 14S',N'Trắng','15500000',N'Nhập JV','2022-01-01',N'Nước Nhật',35,1,'null','QL001','GG001','DT008')
Insert into SANPHAM values ('SN003','IPNONE 14S',N'Đen','14500000',N'Nhập US','2022-01-01',N'Nước Mỹ',27,1,'null','QL001','GG002','DT009')

Insert into DIENTHOAI values('DT001','NDragon','HD','128GB',null,'IP001','24Mb','4000Mh','8GB')
Insert into DIENTHOAI values('DT002','NDragon','HD','64GB',null,'IP003','64Mb','4200Mh','4GB')
Insert into DIENTHOAI values('DT003','NDragon','HD','128GB',null,'IP002','24Mb','4300Mh','8GB')
Insert into DIENTHOAI values('DT004','NDragon','HD','128GB',null,'SS001','24Mb','4500Mh','16GB')
Insert into DIENTHOAI values('DT005','NDragon','HD','128GB',null,'SS002','24Mb','3500Mh','8GB')
Insert into DIENTHOAI values('DT006','NDragon','HD','128GB',null,'SS003','24Mb','4200Mh','4GB')
Insert into DIENTHOAI values('DT007','NDragon','HD','128GB',null,'SN001','24Mb','4000Mh','24GB')
Insert into DIENTHOAI values('DT008','NDragon','HD','128GB',null,'SN002','24Mb','4500Mh','6GB')
Insert into DIENTHOAI values('DT009','NDragon','HD','128GB',null,'SN003','24Mb','3500Mh','8GB')

Insert into HOADON values ('HD001','IPNONE 14S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL001')
Insert into HOADON values ('HD002','IPNONE 12S',1,1,'10500000','10500000',null,'2023-07-07',null,'Apple','QL001')
Insert into HOADON values ('HD003','IPNONE 13S',3,1,'11500000','34500000',null,'2023-07-07',null,'Apple','QL001')
Insert into HOADON values ('HD004','IPNONE 12S',1,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL001')
Insert into HOADON values ('HD005','IPNONE 13S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL002')
Insert into HOADON values ('HD006','IPNONE 12S',1,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL002')
Insert into HOADON values ('HD007','IPNONE 14S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL002')
Insert into HOADON values ('HD008','IPNONE 12S',3,1,'14500000','29000000',null,'2023-07-07',null,'Apple','QL002')

Insert into HOADONCT values ('IP001',3,'HD001')
Insert into HOADONCT values ('IP002',1,'HD002')
Insert into HOADONCT values ('IP003',7,'HD003')
Insert into HOADONCT values ('SS001',4,'HD004')
Insert into HOADONCT values ('SS002',6,'HD005')
Insert into HOADONCT values ('SS003',2,'HD006')
Insert into HOADONCT values ('SN001',6,'HD007')
Insert into HOADONCT values ('SN002',5,'HD008')

Insert into BAOHANH values ('BH001','HD001','123123','2023-01-20','2023-02-25',null,'KH001')
Insert into BAOHANH values ('BH002','HD002','112121','2023-01-20','2023-02-25',null,'KH002')
Insert into BAOHANH values ('BH003','HD003','234123','2023-01-20','2023-02-25',null,'KH008')
Insert into BAOHANH values ('BH004','HD004','192572','2023-01-20','2023-02-25',null,'KH006')
Insert into BAOHANH values ('BH005','HD005','987123','2023-01-20','2023-02-25',null,'KH005')
Insert into BAOHANH values ('BH006','HD006','567232','2023-01-20','2023-02-25',null,'KH003')

Insert into DATSP values ('DH001',5,'0987121212',1,'58500000','60000000',0.1,'QL001')
Insert into DATSP values ('DH002',3,'0989898989',1,'58500000','60000000',0.1,'QL001')
Insert into DATSP values ('DH003',15,'0999999999',1,'58500000','60000000',0.1,'QL002')
Insert into DATSP values ('DH004',20,'0988776690',1,'58500000','60000000',0.1,'QL002')
Insert into DATSP values ('DH005',8,'0222222222',1,'58500000','60000000',0.1,'QL002')
Insert into DATSP values ('DH006',12,'0911111111',1,'58500000','60000000',0.1,'QL001')

Insert into DATSPCT values (3,'DH001','IP001')
Insert into DATSPCT values (7,'DH002','IP002')
Insert into DATSPCT values (10,'DH003','IP003')
Insert into DATSPCT values (12,'DH004','SS001')
Insert into DATSPCT values (9,'DH005','SN001')
Insert into DATSPCT values (6,'DH006','SS003')
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
CREATE TABLE DIENTHOAI(
	MaDT CHAR(10) PRIMARY KEY,
	CPU CHAR(20) NOT NULL,
	MangHinh CHAR(20) NOT NULL,
	BoNho CHAR(10) NOT NULL,
	MoTa TEXT,
	CAMERA CHAR(20) NOT NULL,
	Pin CHAR(10) NOT NULL,
	RAM CHAR(10) NOT NULL,
	FOREIGN KEY (MaDT) REFERENCES SANPHAM(MaSP) ON DELETE NO ACTION ON UPDATE CASCADE
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
CREATE TABLE DONGMAY(
	MaDong int IDENTITY(1,1) PRIMARY KEY,
	LoaiSanPham char(50),
	CPU CHAR(50) NULL,
	MangHinh CHAR(50)  NULL,
	BoNho CHAR(50) NULL,
	MoTa TEXT,
	MaSP CHAR(50) NULL,
	CAMERA CHAR(50) NULL,
	Pin CHAR(50)  NULL,
	RAM CHAR(50)  NULL
)

Insert into VAITRO values ('QL',N'Quản lý',null)
Insert into VAITRO values ('NV',N'Nhân Viên',null)
Update VAITRO set CHUCVU = N'Quản lý',GHICHU = null where MAVAITRO ='QL' 
delete from VAITRO where MAVAITRO='QL'
select * from VAITRO where MAVAITRO = 'QL'

Insert into NHANVIEN values ('NV001',N'Trần Văn An','2003-01-23',1,N'Cần Thơ','0987123456','antv@gmail.com','123','NV','null',1,1)
Insert into NHANVIEN values ('NV002',N'Nguyễn Thanh Bình','1999-11-12',1,N'An Giang','0981234556','binhnt@gmail.com','123','QL','null',1,1)
Insert into NHANVIEN values ('NV003',N'Trần Ngọc Thạch','2001-10-10',1,N'Trà Vinh','0987126543','thachnt@gmail.com','123','NV','null',0,1)
Insert into NHANVIEN values ('NV004',N'Nguyễn Thị Ngân','2001-12-30',0,N'Cần Thơ','0127123456','ngannt@gmail.com','123','NV','null',1,1)
Insert into NHANVIEN values ('NV005',N'Lê Thị Chúc','2002-01-10',0,N'Kiên Giang','0247123456','chuclt@gmail.com','123','NV','null',0,1)
Insert into NHANVIEN values ('NV006',N'Trần Thành Ân','1998-01-10',1,N'Cà Mau','0912343456','antt@gmail.com','123','NV','null',1,0)
Insert into NHANVIEN values ('NV007',N'Nguyễn Văn Minh','1999-01-10',1,N'Long An','0232323456','minhnv@gmail.com','123','NV','null',1,1)
Insert into NHANVIEN values ('NV008',N'Nguyễn Thanh Tâm','1998-01-10',1,N'Cần Thơ','0987987987','tamnt@gmail.com','123','NV','null',1,1)
Insert into NHANVIEN values ('NV009',N'Lê Ngọc Ánh','2000-01-10',0,N'An Giang','0987456456','anhln@gmail.com','123','QL','null',1,1)
Update NHANVIEN set HOTEN ='A',NGAYSINH='2003-01-23',GIOITINH=1,DIACHI=N'Cần Thơ',SDT='0987123456',EMAIL='antv@gmail.com',MATKHAU='123',HINH='null' where MANV='QL'
delete from NHANVIEN where MANV='QL'
select * from NHANVIEN where MAVAITRO = 'QL'

Insert into LUONG values ('NV001','31','20000','2022-12-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV002','30','20000','2023-02-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV003','30','20000','2023-03-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV004','29','20000','2023-02-11','15','25000',null,'5000000',1)
Insert into LUONG values ('NV005','28','20000','2023-06-12','15','25000',null,'5000000',1)
Insert into LUONG values ('NV006','31','20000','2023-04-18','15','25000',null,'5000000',1)
Insert into LUONG values ('NV007','31','20000','2023-05-25','15','25000',null,'5000000',1)
Insert into LUONG values ('NV008','30','30000','2022-12-27','15','25000',null,'5000000',1)
Insert into LUONG values ('NV009','31','30000','2023-01-30','15','25000',null,'5000000',1)
Update LUONG set SONGAYLAM = '2',LUONCOBAN='3000',NGAYVAOCTY='2023-01-30',SOGIOTANGCA ='1',LUONGTANGCA ='2000',KHOANTRU=null,TONGTIEN='5000',TRANGTHAI=1 where MALUONG='NV001'
delete from LUONG where MALUONG ='NV001'
select* from LUONG where MALUONG = 'NV001'

Insert into GIAMGIA values ('GG001','2022-12-12','2023-01-15','0.1',null,1,'NV001')
Insert into GIAMGIA values ('GG002','2022-12-01','2022-12-15','0.15',null,1,'NV001')
Insert into GIAMGIA values ('GG003','2023-02-12','2023-03-15','0.2',null,1,'NV002')
Insert into GIAMGIA values ('GG004','2023-04-12','2023-05-15','0.05',null,1,'NV001')
Insert into GIAMGIA values ('GG005','2022-10-12','2022-12-15','0.1',null,1,'NV002')
Insert into GIAMGIA values ('GG006','2023-01-12','2023-01-27','0.15',null,1,'NV001')
Insert into GIAMGIA values ('GG007','2022-10-12','2022-12-15','0.2',null,1,'NV002')
Insert into GIAMGIA values ('GG008','2022-11-12','2023-01-05','0.18',null,1,'NV001')
Update GIAMGIA set NGAYBD='2022-12-12',NGAYKT='2023-01-15',PHANTRAM ='0.1',MOTA=null,TRANGTHAI=1,MANV='QL001' where MAGIAMGIA ='GG001'
delete from  GIAMGIA where MAGIAMGIA='GG001'
select * from GIAMGIA where MAGIAMGIA='GG001'

Insert into KHACHHANG values ('KH00001',N'Trần Thị Ánh','0989898989','2002-10-10',N'Cần Thơ',1,'VIP1',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00002',N'Nguyễn Thị Minh','0923232323','2002-10-10',N'Trà Vinh',0,'VIP1',1,null,'NV002','null')
Insert into KHACHHANG values ('KH00003',N'Lê Thanh Chúc','0999999999','2002-10-10',N'Cần Thơ',0,N'Thường',1,null,'NV003','null')
Insert into KHACHHANG values ('KH00004',N'Nguyễn Thanh Ngọc','0988888888','2002-10-10',N'An Giang',0,N'Thường',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00005',N'Trần Ngọc Cầm','0981234567','2002-10-10',N'Hậu Giang',0,N'Thường',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00006',N'Trần Thanh Trí','0912121212','2002-10-10',N'Cần Thơ',1,N'Thường',1,null,'NV002','null')
Insert into KHACHHANG values ('KH00007',N'Trần Anh Khoa','0933112233','2002-10-10',N'Cà Mau',1,'VIP2',1,null,'NV001','null')
Insert into KHACHHANG values ('KH00008',N'Nguyễn Anh Duy','0989898988','2002-10-10',N'Cần Thơ',1,'VIP2',1,null,'NV002','null')
Update KHACHHANG set TENKH='A',SDT='09009400922',NGAYSINH='2002-10-10',DIACHI=N'Cần Thơ',GIOITINH=1,LOAIKH='vip2',TRANGTHAI=1,MOTA=null,MANV='QL001',HINH='1' where MAKH='KH001'
delete from KHACHHANG where MAKH='KH001'
select * from KHACHHANG where MAKH='KH001'

Insert into LICHSU values (null,null,null,'2023-07-01',N'Hóa Đơn','NV001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Bảo Hành','NV001')
Insert into LICHSU values (null,null,null,'2023-07-08',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-06-30',N'Đặt Hàng','NV001')
Insert into LICHSU values (null,null,null,'2023-06-29',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-05-16',N'Đặt Hàng','NV001')
Insert into LICHSU values (null,null,null,'2023-07-15',N'Hóa Đơn','NV002')
Insert into LICHSU values (null,null,null,'2023-03-01',N'Bảo Hành','NV001')
Update LICHSU set THOIGIANTHEM=null,THOIGIANSUA=null,THOIGIANXOA=null,THOIGIANHD='2023-07-01',BANGTHAOTAC=N'Hóa Đơn',MANV='QL001' where ID=1
delete from LICHSU where ID=1
select * from LICHSU where ID=1

Insert into SANPHAM values ('SP00001','IPNONE 14S',N'Trắng','14500000',N'Nhập US','2022-01-01',N'Nước Mỹ',12,1,'null','NV001','GG001')
Insert into SANPHAM values ('SP00002','IPNONE 13S',N'Vàng','11500000',N'Nhập CV','2022-01-01',N'Nước China',20,1,'null','NV001','GG002')
Insert into SANPHAM values ('SP00003','IPNONE 12S',N'Đen','10500000',N'Nhập JV','2022-01-01',N'Nước Nhật',22,1,'null','NV001','GG003')
Insert into SANPHAM values ('SP00004','IPNONE 14S',N'Trắng','11500000',N'Nhập US','2022-01-01',N'Nước Mỹ',17,1,'null','NV002','GG004')
Insert into SANPHAM values ('SP00005','IPNONE 14S',N'Trắng','10500000',N'Nhập US','2022-01-01',N'Nước Mỹ',32,1,'null','NV002','GG005')
Insert into SANPHAM values ('SP00006','IPNONE 14S',N'Trắng','9500000',N'Nhập JV','2022-01-01',N'Nước Nhật',18,1,'null','NV002','GG006')
Insert into SANPHAM values ('SP00007','IPNONE 14S',N'Xanh','22500000',N'Nhập JV','2022-01-01',N'Nước Nhật',12,1,'null','NV002','GG007')
Insert into SANPHAM values ('SP00008','IPNONE 14S',N'Trắng','15500000',N'Nhập JV','2022-01-01',N'Nước Nhật',35,1,'null','NV001','GG001')
Insert into SANPHAM values ('SP00009','IPNONE 14S',N'Đen','14500000',N'Nhập US','2022-01-01',N'Nước Mỹ',27,1,'null','NV001','GG002')
Update SANPHAM set TenSP='iPhone 14',MAU='Lam',Gia='1000',LoaiSP='US',NgayNhap='2022-01-01',NoiNhap=N'Mỹ',SoLuong=12,TrangThai=1,Hinh='1',MaNV='QL001',MaGiamGia='GG001',MaDT='DT001' where MaSP='IP001'
delete from SANPHAM where MaSP='IP001' 
select * from SANPHAM where MaSP='IP001'

Insert into DIENTHOAI values('SP00001','NDragon','HD','128GB',null,'24Mb','4000Mh','8GB')
Insert into DIENTHOAI values('SP00002','NDragon','HD','64GB',null,'64Mb','4200Mh','4GB')
Insert into DIENTHOAI values('SP00003','NDragon','HD','128GB',null,'24Mb','4300Mh','8GB')
Insert into DIENTHOAI values('SP00004','NDragon','HD','128GB',null,'24Mb','4500Mh','16GB')
Insert into DIENTHOAI values('SP00005','NDragon','HD','128GB',null,'24Mb','3500Mh','8GB')
Insert into DIENTHOAI values('SP00006','NDragon','HD','128GB',null,'24Mb','4200Mh','4GB')
Insert into DIENTHOAI values('SP00007','NDragon','HD','128GB',null,'24Mb','4000Mh','24GB')
Insert into DIENTHOAI values('SP00008','NDragon','HD','128GB',null,'24Mb','4500Mh','6GB')
Insert into DIENTHOAI values('SP00009','NDragon','HD','128GB',null,'24Mb','3500Mh','8GB')
update DIENTHOAI set CPU='Snapdragon',MANHINH='OLED',BONHO='256GB',MOTA=null,MASP='SS001',RAM='16GB',PIN='5000Mh',CAMERA='32px' where MADT='DT001'
delete from DIENTHOAI where MADT='DT001'
select * from DIENTHOAI where MADT='DT001'

Insert into HOADON values ('HD00001','IPNONE 14S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV001')
Insert into HOADON values ('HD00002','IPNONE 12S',1,1,'10500000','10500000',null,'2023-07-07',null,'Apple','NV001')
Insert into HOADON values ('HD00003','IPNONE 13S',3,1,'11500000','34500000',null,'2023-07-07',null,'Apple','NV001')
Insert into HOADON values ('HD00004','IPNONE 12S',1,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV001')
Insert into HOADON values ('HD00005','IPNONE 13S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV002')
Insert into HOADON values ('HD00006','IPNONE 12S',1,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV002')
Insert into HOADON values ('HD00007','IPNONE 14S',2,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV002')
Insert into HOADON values ('HD00008','IPNONE 12S',3,1,'14500000','29000000',null,'2023-07-07',null,'Apple','NV002')
update HOADON set TENSP='Samsung A73',SOLUONG=2,TRANGTHAI=1,DONGIA='100000',TONGTIEN='200000',MOTA=null,NGAYXUAT='2023-07-07',THUE=null,TENCTY='Samsung',MANV='QL001' where MAHD = 'HD001'
delete from HOADON where MAHD='HD001'
select * from HOADON where MAHD='HD001'

Insert into HOADONCT values ('SP00002',3,'HD001')
Insert into HOADONCT values ('SP00002',1,'HD002')
Insert into HOADONCT values ('SP00001',7,'HD003')
Insert into HOADONCT values ('SP00003',4,'HD004')
Insert into HOADONCT values ('SP00001',6,'HD005')
Insert into HOADONCT values ('SP00002',2,'HD006')
Insert into HOADONCT values ('SP00008',6,'HD007')
Insert into HOADONCT values ('SP00004',5,'HD008')
update HOADONCT set MASP ='IP001',SOLUONG=1,MAHD='HD001' where MAHDCT =1
delete from HOADONCT where MAHDCT=1
select * from HOADONCT where MAHDCT=1

Insert into BAOHANH values ('BH00001','HD001','123123','2023-01-20','2023-02-25',null,'KH00001')
Insert into BAOHANH values ('BH00002','HD002','112121','2023-01-20','2023-02-25',null,'KH00002')
Insert into BAOHANH values ('BH00003','HD003','234123','2023-01-20','2023-02-25',null,'KH00008')
Insert into BAOHANH values ('BH00004','HD004','192572','2023-01-20','2023-02-25',null,'KH00006')
Insert into BAOHANH values ('BH00005','HD005','987123','2023-01-20','2023-02-25',null,'KH00005')
Insert into BAOHANH values ('BH00006','HD006','567232','2023-01-20','2023-02-25',null,'KH00003')
update BAOHANH set MAHD ='HD001',SOIMEI='111222',NGAYBH='2023-01-20',NGAYHETHAN='2023-02-25',GHICHU=null,MAKH='KH001' where MABH='BH001'
delete from BAOHANH where MABH='BH001'
select * from BAOHANH where MABH='BH001'

Insert into DATSP values ('DH00001',5,'0987121212',1,'58500000','60000000',0.1,'NV001')
Insert into DATSP values ('DH00002',3,'0989898989',1,'58500000','60000000',0.1,'NV001')
Insert into DATSP values ('DH00003',15,'0999999999',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00004',20,'0988776690',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00005',8,'0222222222',1,'58500000','60000000',0.1,'NV002')
Insert into DATSP values ('DH00006',12,'0911111111',1,'58500000','60000000',0.1,'NV001')
update DATSP set SOLUONG=1,SDT='009900990',TRANGTHAI=1,DONGIA='500000',TONGTIEN='600000',THUE=0.1,MANV='QL001' where MADHANG='DH001'
delete from DATSP where MADHANG='DH001'
select * from DATSP where MADHANG='DH001'

Insert into DATSPCT values (3,'DH00001','SP00002')
Insert into DATSPCT values (7,'DH00002','SP00001')
Insert into DATSPCT values (10,'DH00003','SP00003')
Insert into DATSPCT values (12,'DH00004','SP00001')
Insert into DATSPCT values (9,'DH00005','SP00002')
Insert into DATSPCT values (6,'DH00006','SP00004')
update DATSPCT set SoLuong=1,MaDH='DH001',MaSP='IP001' where MaDatCT=1
delete from DATSPCT where MaDatCT=1
select * from DATSPCT where MaDatCT=1 
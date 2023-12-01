package nhom2.test.cong;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.SanPhamModel;

public class SanPhamTest {
	SanPhamDAO dao = new SanPhamDAO();
	DienThoaiDao daoDT = new DienThoaiDao();
	
	@Test
	public void testHienThongTin() {
		String kqmd = "Thành công";
		String kqtt= "";
		List<SanPhamModel> model = dao.select();
		if(model!=null) {
		kqtt = "Thành công";	
		}else {
			kqtt= "Thất bại";
		}
		assertEquals(kqtt, kqmd);
	}
	
	
	 
	// test case cập nhật sản phẩm
	
	@Test
	public void testCapNhatSanPhamKhongTen() {
		String kqmd = "Chưa nhập tên sản phẩm";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP(null);
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("27px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa nhập tên sản phẩm";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongGia() {
		String kqmd = "Chưa nhập giá sản phẩm";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("27px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa nhập giá sản phẩm";
		}
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testCapNhatSanPhamKhongNoiNhap() {
		String kqmd = "Chưa nhập nơi nhập";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap(null);
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("27px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa nhập nơi nhập";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongManHinh() {
		String kqmd = "Chưa chọn màn hình";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("27px");
		dt.setMangHinh(null);
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn màn hình";
		}
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testCapNhatSanPhamKhongCamera() {
		String kqmd = "Chưa chọn Camera";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera(null);
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn Camera";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongPin() {
		String kqmd = "Chưa chọn Pin";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin(null);
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn Pin";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongBoNho() {
		String kqmd = "Chưa chọn bộ nhớ trong";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho(null);
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn bộ nhớ trong";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongRam() {
		String kqmd = "Chưa chọn Ram";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam(null);
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn Ram";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongCPU() {
		String kqmd = "Chưa chọn CPU";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU(null);
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn CPU";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongKhuyenMai() {
		String kqmd = "Chưa chọn khuyến mại";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia(null);
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn khuyến mại";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongLoaiSP() {
		String kqmd = "Chưa chọn loại sản phẩm";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP(null);
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn loại sản phẩm";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongSoLuong() {
		String kqmd = "Chưa nhập số lượng";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa nhập số lượng";
		}
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testCapNhatSanPhamKhongNgayNhap() {
		String kqmd = "Chưa nhập ngày nhập";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap(null);
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa nhập ngày nhập";
		}
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testCapNhatSanPhamKhongHinh() {
		String kqmd = "Chưa chọn hình ảnh";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau("đen");
		sp.setHinh(null);
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn hình ảnh";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test
	public void testCapNhatSanPhamKhongMau() {
		String kqmd = "Chưa chọn màu sản phẩm";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A05");
		sp.setMaNV("NV001");
		sp.setGia(3000000);
		sp.setNoiNhap("Trung Quốc");
		sp.setMau(null);
		sp.setHinh("samsung.jpg");
		sp.setNgayNhap("10-03-2023");
		sp.setSoLuong(100);
		sp.setLoaiSP("Samsung");
		sp.setMaGiamGia("KM006");
		sp.setTrangThai(true);
		
		dt.setMaDT("SP00009");
		dt.setCPU("Bionitis");
		dt.setRam("94GB");
		dt.setBoNho("11GB");
		dt.setPin("4757Mh");
		dt.setCamera("17px");
		dt.setMangHinh("HDT");
		dt.setMoTa("Điện thoại");
		
		try {
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Chưa chọn màu sản phẩm";
		}
		assertEquals(kqmd, kqtt);
	}
	
}

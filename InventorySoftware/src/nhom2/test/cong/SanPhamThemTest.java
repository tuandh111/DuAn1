package nhom2.test.cong;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.SanPhamModel;

public class SanPhamThemTest {
	SanPhamDAO dao = new SanPhamDAO();
	DienThoaiDao daoDT = new DienThoaiDao();
	ThongKeDao DaoThongKe = new ThongKeDao();
	 public String TuDongTangMa() {
	        List<Object[]> i = DaoThongKe.getSoLuongSP();
	        String name = (String) i.get(0)[0];
	        String[] tbl = name.split("P");
	        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
	        String ten = "SP";
	        for (int j = 0; j <= 4 - so.length(); j++) {
	            ten += "0";
	        }
	        ten = ten + so;
	        return ten;
	 }
	 @Test 
	 public void testThemSanPham() {
		  String kqmd = "Thêm dữ liệu thành công";
		  String kqtt= null;
		  SanPhamModel sp = new SanPhamModel();
		  DienThoaiModel dt = new DienThoaiModel();
		  String masp = TuDongTangMa();
		  sp.setMaSP(masp);
		  sp.setTenSP("Samsung Galaxy A05");
		  sp.setMaNV("NV001");
		  sp.setGia(3000000);
		  sp.setNoiNhap("Trung Quốc");
		  sp.setMau("Đen");
		  sp.setHinh("samsung.jpg");
		  sp.setNgayNhap("10-03-2023");
		  sp.setSoLuong(100);
		  sp.setLoaiSP("Samsung");
		  sp.setMaGiamGia("KM006");
		  sp.setTrangThai(true);
	  
		  dt.setMaDT(masp);
		  dt.setCPU("Bionits");
		  dt.setRam("94GB");
		  dt.setBoNho("11GB");
		  dt.setPin("4757Mh");
		  dt.setCamera("27px");
		  dt.setMangHinh("HDt");
		  dt.setMoTa("Điện thoại");
	  
	  try { 
		  dao.insert(sp);
		  daoDT.insert(dt);
	  kqtt = "Thêm dữ liệu thành công"; 
	  }catch(Exception ex)
	  { 
		  ex.printStackTrace();
		  kqtt = "Thêm dữ liệu thất bại"; 
	  } 
	  assertEquals(kqmd, kqtt); 
	  }
	// test case thêm sản phẩm
	 
	 @Test public void testThemSanPhamGiaAm() {
		  String kqmd = "Thêm dữ liệu thất bại";
		  String kqtt= null;
		  SanPhamModel sp = new SanPhamModel();
		  DienThoaiModel dt = new DienThoaiModel();
		  String masp = TuDongTangMa();
		  sp.setMaSP(masp);
		  sp.setTenSP("Samsung Galaxy A05");
		  sp.setMaNV("NV001");
		  sp.setGia(-1);
		  sp.setNoiNhap("Trung Quốc");
		  sp.setMau("Đen");
		  sp.setHinh("samsung.jpg");
		  sp.setNgayNhap("10-03-2023");
		  sp.setSoLuong(100);
		  sp.setLoaiSP("Samsung");
		  sp.setMaGiamGia("KM006");
		  sp.setTrangThai(true);
	  
		  dt.setMaDT(masp);
		  dt.setCPU("Bionits");
		  dt.setRam("94GB");
		  dt.setBoNho("11GB");
		  dt.setPin("4757Mh");
		  dt.setCamera("27px");
		  dt.setMangHinh("HDt");
		  dt.setMoTa("Điện thoại");
	  
	  try { 
		  dao.insert(sp);
		  daoDT.insert(dt);
	  kqtt = "Thêm dữ liệu thành công";
	  }catch(Exception ex)
	  { 
		  ex.printStackTrace();
		  kqtt = "Thêm dữ liệu thất bại"; 
	  } 
	  assertEquals(kqmd, kqtt); 
	  }
	 
	 @Test public void testThemSanPhamSoLuongAm() {
		  String kqmd = "Thêm dữ liệu thất bại";
		  String kqtt= null;
		  SanPhamModel sp = new SanPhamModel();
		  DienThoaiModel dt = new DienThoaiModel();
		  String masp = TuDongTangMa();
		  sp.setMaSP(masp);
		  sp.setTenSP("Samsung Galaxy A05");
		  sp.setMaNV("NV001");
		  sp.setGia(3000000);
		  sp.setNoiNhap("Trung Quốc");
		  sp.setMau("Đen");
		  sp.setHinh("samsung.jpg");
		  sp.setNgayNhap("10-03-2023");
		  sp.setSoLuong(-1);
		  sp.setLoaiSP("Samsung");
		  sp.setMaGiamGia("KM006");
		  sp.setTrangThai(true);
	  
		  dt.setMaDT(masp);
		  dt.setCPU("Bionits");
		  dt.setRam("94GB");
		  dt.setBoNho("11GB");
		  dt.setPin("4757Mh");
		  dt.setCamera("27px");
		  dt.setMangHinh("HDt");
		  dt.setMoTa("Điện thoại");
	  
	  try { 
		  dao.insert(sp);
		  daoDT.insert(dt);
	  kqtt = "Thêm dữ liệu thành công"; 
	  }catch(Exception ex)
	  { 
		  ex.printStackTrace();
		  kqtt = "Thêm dữ liệu thất bại"; 
	  } 
	  assertEquals(kqmd, kqtt); 
	  }
	 
	@Test(dataProvider = "dataAdd")
	public void testThemSanPhamThieuDuLieu(String maSP,String tenSP,String maNV,double gia,
			String xuatXu, String mau, String tenHinh,String ngayNhap,int soLuong,String loaiSP,
			String maGiamGia, boolean TrangThai, String cpu, String ram,String boNho,String pin,String camera
			, String manHinh,String moTa,String kq
			) {
		String kqmd = kq;
		String kqtt= null;
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP(maSP);
		sp.setTenSP(tenSP);
		sp.setMaNV(maNV);
		sp.setGia(gia);
		sp.setNoiNhap(xuatXu);
		sp.setMau(mau);
		sp.setHinh(tenHinh);
		sp.setNgayNhap(ngayNhap);
		sp.setSoLuong(soLuong);
		sp.setLoaiSP(loaiSP);
		sp.setMaGiamGia(maGiamGia);
		sp.setTrangThai(TrangThai);
		
		dt.setMaDT(maSP);
		dt.setCPU(cpu);
		dt.setRam(ram);
		dt.setBoNho(boNho);
		dt.setPin(pin);
		dt.setCamera(camera);
		dt.setMangHinh(manHinh);
		dt.setMoTa(moTa);
		
		try {
			dao.insert(sp);
			daoDT.insert(dt);
			kqtt = "Thêm dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = kq;
		}
		assertEquals(kqmd, kqtt);
	}
	@DataProvider
	public Object[][] dataAdd(){
		return new Object[][] {
			// không nhập tên
			new Object[]{TuDongTangMa(),null,"NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa nhập tên sản phẩm"},
			// không nhập nơi nhập
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					null,"Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa nhập nơi nhập"},
			// Không có màu
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc",null,"samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa chọn màu"},
			// không hình
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen",null,"10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa chọn hình"},
			// không có ngày nhập
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg",null,100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa nhập ngày nhập"},
			// Không có loại
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,null,"KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa chọn loại"},
			// Không có khuyến mại
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung",null,true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại","Chưa chọn khuyến mại"},
			//Không CPU
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					null,"94GB","11GB","4757Mh","27px","HDt","Điện thoại","chưa chọn CPU"},
			//Không Ram
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits",null,"11GB","4757Mh","27px","HDt","Điện thoại","Chưa chọn Ram"},
			// không bộ nhớ trong
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB",null,"4757Mh","27px","HDt","Điện thoại","Chọn chọn bộ nhớ trong"},
			// không pin
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB",null,"27px","HDt","Điện thoại","chưa chọn pin"},
			// không camera
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh",null,"HDt","Điện thoại","Chưa chọn camera"},
			// không màn hình
			new Object[]{TuDongTangMa(),"Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px",null,"Điện thoại","Chưa chọn màn hình"},
		};
	}
}

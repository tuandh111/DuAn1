package nhom2.test.cong;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.SanPhamModel;

public class SanPhamThemTest {
	SanPhamDAO dao = new SanPhamDAO();
	DienThoaiDao daoDT = new DienThoaiDao();
	
	 @Test public void testThemSanPham() {
		  String kqmd = "Thành công";
		  String kqtt= null;
		  SanPhamModel sp = new SanPhamModel();
		  DienThoaiModel dt = new DienThoaiModel();
		  sp.setMaSP("SP00014");
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
	  
		  dt.setMaDT("SP00014");
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
	  kqtt = "Thành công"; 
	  }catch(Exception ex)
	  { 
		  ex.printStackTrace();
		  kqtt = "Thất bại"; 
	  } 
	  assertEquals(kqmd, kqtt); 
	  }
	// test case thêm sản phẩm
	@Test(dataProvider = "dataAdd")
	public void testThemSanPhamThieuDuLieu(String maSP,String tenSP,String maNV,double gia,
			String xuatXu, String mau, String tenHinh,String ngayNhap,int soLuong,String loaiSP,
			String maGiamGia, boolean TrangThai, String cpu, String ram,String boNho,String pin,String camera
			, String manHinh,String moTa
			) {
		String kqmd = "Thêm dữ liệu thất bại";
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
			kqtt = "Thêm dữ liệu thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
	@DataProvider
	public Object[][] dataAdd(){
		return new Object[][] {
			// không nhập tên
			new Object[]{"SP00019",null,"NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// giá số âm
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",-1,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// không nhập nơi nhập
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					null,"Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// Không có màu
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc",null,"samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// không hình
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen",null,"10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// không có ngày nhập
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg",null,100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// số lượng nhỏ hơn 0
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",-1,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// Không có loại
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,null,"KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			// Không có khuyến mại
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung",null,true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			//Không CPU
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					null,"94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			//Không Ram
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits",null,"11GB","4757Mh","27px","HDt","Điện thoại"},
			// không bộ nhớ trong
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB",null,"4757Mh","27px","HDt","Điện thoại"},
			// không pin
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB",null,"27px","HDt","Điện thoại"},
			// không camera
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh",null,"HDt","Điện thoại"},
			// không màn hình
			new Object[]{"SP00016","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px",null,"Điện thoại"},
		};
	}
}

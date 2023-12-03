package nhom2.test.cong;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.SanPhamModel;

public class SanPhamCapNhat {
	SanPhamDAO dao = new SanPhamDAO();
	DienThoaiDao daoDT = new DienThoaiDao();
	
	@Test
	public void testCapNhatSanPham() {
		String kqmd = "Cập nhật dữ liệu thành công";
		String kqtt= "";
		SanPhamModel sp = new SanPhamModel();
		DienThoaiModel dt = new DienThoaiModel();
		sp.setMaSP("SP00009");
		sp.setTenSP("Samsung Galaxy A10");
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
			kqtt = "Cập nhật dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Cập nhật dữ liệu thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@Test(dataProvider = "dataAdd")
	public void testCapNhatSanPhamThieuDuLieu(String maSP,String tenSP,String maNV,double gia,
			String xuatXu, String mau, String tenHinh,String ngayNhap,int soLuong,String loaiSP,
			String maGiamGia, boolean TrangThai, String cpu, String ram,String boNho,String pin,String camera
			, String manHinh,String moTa
			) {
		String kqmd = "Cập nhật dữ liệu thất bại";
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
			dao.update(sp);
			daoDT.update(dt);
			kqtt = "Cập nhật dữ liệu thành công";
		}catch(Exception ex) {
			kqtt = "Cập nhật dữ liệu thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
	
	@DataProvider
	public Object[][] dataAdd(){
		return new Object[][] {
			new Object[]{"SP00006",null,"NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",-1,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					null,"Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc",null,"samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen",null,"10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg",null,100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",-1,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,null,"KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung",null,true,
					"Bionits","94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					null,"94GB","11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits",null,"11GB","4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB",null,"4757Mh","27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB",null,"27px","HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh",null,"HDt","Điện thoại"},
			new Object[]{"SP00006","Samsung Galaxy A05","NV001",3000000.0,
					"Trung Quốc","Đen","samsung.jpg","10-03-2023",100,"Samsung","KM006",true,
					"Bionits","94GB","11GB","4757Mh","27px",null,"Điện thoại"},
		};
	}
}

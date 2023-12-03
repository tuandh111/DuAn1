package nhom2.test.cong;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if(!model.isEmpty()) {
		kqtt = "Thành công";	
		}else {
			kqtt= "Thất bại";
		}
		assertEquals(kqtt, kqmd);
	}
	@Test
	public void testTimSanPhamTheoId() {
		SanPhamModel sp = dao.findById("SP00002");
		assertNotNull(sp);
		assertEquals("SP00002", sp.getMaSP().trim());
	}
	@Test
	public void testHienThongTinTop3() {
		String kqmd = "Thành công";
		String kqtt= "";
		boolean found = false;
		List<SanPhamModel> model = dao.selectTop3();
		if(!model.isEmpty()) {
			kqtt = "Thành công"
	;	found = true;	
		}else {
			kqtt= "Thất bại";
		}
		if(found) {
			assertEquals(3, model.size());
		}
		
		assertEquals(kqtt, kqmd);
	}
	
	@Test
	public void testHienThongTinDaXoa() {
		String kqmd = "Thành công";
		String kqtt= "";
		List<SanPhamModel> model = dao.selectDaXoa();
		if(!model.isEmpty()) {
		kqtt = "Thành công";
		for(SanPhamModel sp : model) {
			assertFalse(sp.isTrangThai());;
		}
		}else {
			kqtt= "Thất bại";
		}
		assertEquals(kqtt, kqmd);
	}
	@Test
	public void testHienThongTinDaXoaTheoMa() {
		String kqmd = "Thành công";
		String kqtt= "";
		String maSP = "SP00012";
		List<SanPhamModel> model = dao.selectDaXoaTheoMa(maSP);
		if(!model.isEmpty()) {
		kqtt = "Thành công";	
		for(SanPhamModel sp : model) {
			assertEquals("SP00012", maSP);
			assertFalse(sp.isTrangThai());
		}
		}else {
			kqtt= "Thất bại";
		}
		assertEquals(kqtt, kqmd);
	}
	@Test
	public void testTimKiemTheoTen() {
		String kqmd = "Thành công";
		String kqtt= "";
		String tenSP = "SamSung";
		List<SanPhamModel> model = dao.TimKiemTheoTen(tenSP);
		if(!model.isEmpty()) {
		kqtt = "Thành công";
		}else {
			kqtt= "Thất bại";
		}
		assertEquals(kqtt, kqmd);
	}
	
}

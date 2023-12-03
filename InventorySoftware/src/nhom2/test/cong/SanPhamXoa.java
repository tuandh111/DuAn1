package nhom2.test.cong;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Model.SanPhamModel;

public class SanPhamXoa {
	SanPhamDAO dao = new SanPhamDAO();
	
	@Test
	public void xoaSanPham() {
		String kqtt = "";
		String kqmd = "Thành công";
		String MaSP = "SP00007";
		SanPhamModel sp = dao.findById(MaSP);
		try {
			dao.delete(sp);
			kqtt = "Thành công";
		} catch (Exception e) {
			kqtt = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd,kqtt);
	}
}

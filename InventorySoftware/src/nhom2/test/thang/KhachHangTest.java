package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class KhachHangTest {
	KhachHangDAO dao = new KhachHangDAO();
	String kq = "";
	String kqmd = "Thành Công";

	@Test
	public void test() {
		List<KhachHangModel> list = dao.selectMa("KH00001");
		if (list != null) {
			kq = "Thành Công";
		} else {
			kq = "Thất Bại";
		}
		Assert.assertEquals(kq, kqmd);

	}
}

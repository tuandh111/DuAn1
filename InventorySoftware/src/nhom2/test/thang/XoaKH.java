package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class XoaKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

	String kq = "";
	String kqmd = "Thành công";

	@Test
	public void testDelete() {
		KhachHangModel model = new KhachHangModel();
		String maKH = "";
		model.setMaKH(maKH);
		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.delete(model);
			List<KhachHangModel> list = dao.selectMa(maKH);
			if (list == null) {
				kq = "Thành công";
			} else {
				kq = "Thất Bại";
			}
			Assert.assertEquals(kq, kqmd);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}

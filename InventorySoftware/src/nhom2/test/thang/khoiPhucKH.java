package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class khoiPhucKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

	@Test
	public void testDelete() {
		KhachHangModel model = new KhachHangModel();
		String maKH = null;
		model.setMaKH(maKH);
		String kq = "";
		String kqmd = "Bạn chưa chọn khách hàng để khôi phục";
		try {
			dao.delete(model);
			List<KhachHangModel> list = dao.selectDaXoaTheoMa(maKH);
			if (list.isEmpty()) {
				kq = "Bạn chưa chọn khách hàng để khôi phục";
			} else {
				kq = "Khôi phục thành công";
			}
			Assert.assertEquals(kqmd, kq);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}

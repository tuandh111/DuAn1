package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class TimKHKhoiPhuc {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

	String kq = "";
	String kqmd = "Thành công";

	@Test
	public void timMaDung() {
		List<KhachHangModel> list = dao.selectDaXoaTheoMa("KH00987");
		if (list != null) {
			kq = "Thành công";
		} else {
			kq = "Thất Bại";
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void timMaTrong() {
		List<KhachHangModel> list = dao.selectDaXoaTheoMa("");
		if (list != null) {
			kq = "Thành công";
		} else {
			kq = "Thất Bại";
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void timMaSai() {
		List<KhachHangModel> list = dao.selectDaXoaTheoMa("Địch Lệ Nhiệt Ba");
		if (list != null) {
			kq = "Thất Bại";
		} else {
			kq = "Thành công";
		}
		Assert.assertEquals(kq, kqmd);

	}
}

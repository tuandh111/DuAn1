package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class TimKHKhoiPhuc {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

	

	@Test
	public void timMaDung() {
		String kq = "";
		String kqmd = "Đã tìm thấy";
		List<KhachHangModel> list = dao.selectDaXoaTheoMa("KH00987");
		if (!list.isEmpty()) {
			kq = "Đã tìm thấy";
		} else {
			kq = "Không tìm thấy";
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void timMaTrong() {
		String kq = "";
		String kqmd = "Không tìm thấy";
		List<KhachHangModel> list = dao.selectDaXoaTheoMa(null);
		if (list.isEmpty()) {
			kq = "Không tìm thấy";
		} else {
			kq = "Đã tìm thấy";
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void timMaSai() {
		String kq = "";
		String kqmd = "Không tìm thấy";
		List<KhachHangModel> list = dao.selectDaXoaTheoMa("Địch Lệ Nhiệt Ba");
		if (list.isEmpty()) {
			kq = "Không tìm thấy";
		} else {
			kq = "Đã tìm thấy";
		}
		Assert.assertEquals(kqmd, kq);

	}
}

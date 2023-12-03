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
	public void testMa() {
		List<KhachHangModel> list = dao.selectMa("KH00001");
		if (list != null) {
			kq = "Thành Công";
		} else {
			kq = "Thất Bại";
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void testDelete() {
		KhachHangModel model = new KhachHangModel();
		model.setMaKH("KH00103");
		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.delete(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void testInsert() {
		KhachHangModel model = new KhachHangModel();
		model.setMaKH("KH00966");
		model.setTenKH("GG");
		model.setSDT("0987654321");
		model.setNgaySinh("2003/11/20");
		model.setDiaChi("Cần Thơ");
		model.setGT(false);
		model.setLoaiKH("");
		model.setTrangThai(true);
		model.setMoTa("gg");
		model.setMaNV("NV001");
		model.setHinh("");

		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}
}

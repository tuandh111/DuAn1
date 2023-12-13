package nhom2.test.thanh;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Model.NhanVienModel;

public class TimNV {
	NhanVienDAO1 dao = new NhanVienDAO1();
	NhanVienModel model = new NhanVienModel();
	

	@Test
	public void timMaDung() {
		String kq = "";
		String kqmd = "Đã tìm thấy";
		List<NhanVienModel> list = dao.TimKiemTheoTen("NV001");
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
		List<NhanVienModel> list = dao.TimKiemTheoTen(null);
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
		List<NhanVienModel> list = dao.TimKiemTheoTen("ABC");
		if (list.isEmpty()) {
			kq = "Không tìm thấy";
		} else {
			kq = "Đã tìm thấy";
		}
		Assert.assertEquals(kqmd, kq);

	}
}

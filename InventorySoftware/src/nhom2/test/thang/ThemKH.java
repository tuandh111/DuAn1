package nhom2.test.thang;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Model.KhachHangModel;

public class ThemKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();
	ThongKeDao DaoThongKe = new ThongKeDao();

	public String TuDongTangMa() {
		List<Object[]> i = DaoThongKe.getSoLuongKH();
		String name = (String) i.get(0)[0];
		String[] tbl = name.split("H");
		String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
		String ten = "KH";
		for (int j = 0; j <= 4 - so.length(); j++) {
			ten += "0";
		}
		ten = ten + so;
		return ten;
	}

	@Test
	public void themOK() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0195721238");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonLoaiKH() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898989");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH(null);
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Loại khách hàng bạn chưa chọn";
		try {
			dao.insert(model);
			kq = "Thêm thành công";

		} catch (Exception e) {
			kq = "Loại khách hàng bạn chưa chọn";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonNgaySinh() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898988");
		model.setNgaySinh(null);
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Tuổi không được nhỏ hơn 18";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Tuổi không được nhỏ hơn 18";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonGT() {
		Boolean gt = Boolean.parseBoolean(null);
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898987");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(gt);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Giới tính bạn chưa chọn";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Giới tính bạn chưa chọn";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaNhapDiaChi() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898986");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi(null);
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Địa chỉ không được để trống";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Địa chỉ không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaTenKH() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH(null);
		model.setSDT("0989898985");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Họ và tên không được để trống";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Họ và tên không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaNhapMoTa() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0789118984");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa(null);
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Thêm thành công";
		try {
			dao.insert(model);
			kq = "Thêm thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaNhapSDT() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT(null);
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Số điện thoại không được để trống";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Số điện thoại không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonAvatar() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898983");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh(null);

		String kq = "";
		String kqmd = "Bạn chưa chọn hình ảnh";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Bạn chưa chọn hình ảnh";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonAvatarKhDungDinhDang() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898982");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.docx");

		String kq = "";
		String kqmd = "Hình ảnh không đúng định dạng";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Hình ảnh không đúng định dạng";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void deTrongDuLieu() {
		Boolean gt = Boolean.parseBoolean(null);
		Boolean tt = Boolean.parseBoolean(null);
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH(null);
		model.setSDT(null);
		model.setNgaySinh(null);
		model.setDiaChi(null);
		model.setGT(gt);
		model.setLoaiKH(null);
		model.setTrangThai(tt);
		model.setMoTa(null);
		model.setMaNV(null);
		model.setHinh(null);

		String kq = "";
		String kqmd = "Bạn chưa chọn hình ảnh";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Bạn chưa chọn hình ảnh";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chonNgaySinhNhoHon18() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898981");
		model.setNgaySinh("2023-12-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Tuổi không được nhỏ hơn 18";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Tuổi không được nhỏ hơn 18";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void NhapTenKHSai() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("!@#$%^&*<3");
		model.setSDT("0989898980");
		model.setNgaySinh("2003-12-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Họ tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Họ tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void NhapSDTKHSai() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("@!#^$@^");
		model.setNgaySinh("2003-12-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Số điện thoại của bạn không đúng định dạng";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Số điện thoại của bạn không đúng định dạng";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void NhapDCKHSai() {
		String ma = TuDongTangMa();
		model.setMaKH(ma);
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0456891230");
		model.setNgaySinh("2000-12-1");
		model.setDiaChi("@#$%^&*");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Địa chỉ chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		try {
			dao.insert(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Địa chỉ chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

}

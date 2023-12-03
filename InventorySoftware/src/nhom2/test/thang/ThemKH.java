package nhom2.test.thang;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class ThemKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

//	@Test
//	public void themOK() {
//		model.setMaKH("KH00101");
//		model.setTenKH("Trịnh Trần Hoàng Tuấn");
//		model.setSDT( "0989898989");
//		model.setNgaySinh("2000-1-1");
//		model.setDiaChi("Cần Thơ");
//		model.setGT(true);
//		model.setLoaiKH("VIP1");
//		model.setTrangThai(true);
//		model.setMoTa("hi");
//		model.setMaNV("NV001");
//		model.setHinh("avatar.jpg");
//
//		String kq = "";
//		String kqmd = "Thành công";
//		try {
//			dao.insert(model);
//			kq = "Thành công";
//
//		} catch (Exception e) {
//			kq = "Thất bại";
//			// TODO: handle exception
//		}
//		Assert.assertEquals(kq, kqmd);
//
//	}

	@Test
	public void chuaChonLoaiKH() {
		model.setMaKH("KH00101");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898989");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("");
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
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonNgaySinh() {
		model.setMaKH("KH00102");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898988");
		model.setNgaySinh("");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
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
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonGT() {
		Boolean gt = Boolean.parseBoolean(null);
		model.setMaKH("KH00103");
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

	@Test
	public void chuaNhapDiaChi() {
		model.setMaKH("KH00104");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898986");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("");
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
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaTenKH() {
		model.setMaKH("KH00105");
		model.setTenKH("");
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

	@Test
	public void chuaNhapMoTa() {
		model.setMaKH("KH00106");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898984");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("");
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
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaNhapSDT() {
		model.setMaKH("KH00107");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("");
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
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonAvatar() {
		model.setMaKH("KH00108");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989898983");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
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

	@Test
	public void chuaChonAvatarKhDungDinhDang() {
		model.setMaKH("KH00109");
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

	@Test
	public void deTrongDuLieu() {
		Boolean gt = Boolean.parseBoolean(null);
		Boolean tt = Boolean.parseBoolean(null);
		model.setMaKH("");
		model.setTenKH("");
		model.setSDT("");
		model.setNgaySinh("");
		model.setDiaChi("");
		model.setGT(gt);
		model.setLoaiKH("");
		model.setTrangThai(tt);
		model.setMoTa("");
		model.setMaNV("");
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

	@Test
	public void chonNgaySinhNhoHon18() {
		model.setMaKH("KH00110");
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

	@Test
	public void NhapTenKHSai() {
		model.setMaKH("KH00111");
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

	@Test
	public void NhapSDTKHSai() {
		model.setMaKH("KH00112");
		model.setTenKH("!@#$%^&*<3");
		model.setSDT("1900");
		model.setNgaySinh("2003-12-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
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
		Assert.assertEquals(kq, kqmd);

	}

}

package nhom2.test.thang;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class SuaKH {
	KhachHangModel model = new KhachHangModel();
	KhachHangDAO dao = new KhachHangDAO();

//	@Test
//	public void suaOK() {
//		model.setMaKH("KH00088");
//		model.setTenKH("Trịnh Trần Hoàng Tuấn");
//		model.setSDT("0989898789");
//		model.setNgaySinh("2000-1-1");
//		model.setDiaChi("DakLak");
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
//			dao.update(model);
//			kq = "Thành công";
//
//		} catch (Exception e) {
//			kq = "Thất bại";
//			e.printStackTrace();
//		}
//		Assert.assertEquals(kq, kqmd);
//
//	}

	@Test
	public void chuaChonLoaiKH() {

		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0089898989");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");
		model.setMaKH("KH00088");

		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonNgaySinh() {

		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0929898988");
		model.setNgaySinh("");
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");
		model.setMaKH("KH00088");

		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.update(model);
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

		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0689898987");
		model.setNgaySinh("2000-1-1");
		model.setDiaChi("Cần Thơ");
		model.setGT(gt);
		model.setLoaiKH("VIP1");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");
		model.setMaKH("KH00088");

		String kq = "";
		String kqmd = "Thành công";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaNhapDiaChi() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0912898986");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaTenKH() {
		model.setMaKH("KH00088");
		model.setTenKH("");
		model.setSDT("0989894485");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaNhapMoTa() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0933898984");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaNhapSDT() {
		model.setMaKH("KH00088");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonAvatar() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989777983");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chuaChonAvatarKhDungDinhDang() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0989398983");
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
			dao.update(model);
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
		model.setMaKH("KH00088");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void chonNgaySinhNhoHon18() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0919891911");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void NhapTenKHSai() {
		model.setMaKH("KH00088");
		model.setTenKH("!@#$%^&*<3");
		model.setSDT("0289892920");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void NhapSDTKHSai() {
		model.setMaKH("KH00088");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);

	}
}

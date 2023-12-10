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
		model.setLoaiKH(null);
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");
		model.setMaKH("KH00088");

		String kq = "";
		String kqmd = "Loại khách hàng bạn chưa chọn";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Loại khách hàng bạn chưa chọn";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaChonNgaySinh() {

		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0929898988");
		model.setNgaySinh(null);
		model.setDiaChi("Cần Thơ");
		model.setGT(true);
		model.setLoaiKH("VIP");
		model.setTrangThai(true);
		model.setMoTa("hi");
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");
		model.setMaKH("KH00088");

		String kq = "";
		String kqmd = "Tuổi không được nhỏ hơn 18";
		try {
			dao.update(model);
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
		String kqmd = "Giới tính bạn chưa chọn";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Giới tính bạn chưa chọn";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaNhapDiaChi() {
		model.setMaKH("KH00088");
		model.setTenKH("Trịnh Trần Hoàng Tuấn");
		model.setSDT("0912898986");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Địa chỉ không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaTenKH() {
		model.setMaKH("KH00088");
		model.setTenKH(null);
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
		String kqmd = "Họ và tên không được để trống";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Họ và tên không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

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
		model.setMoTa(null);
		model.setMaNV("NV001");
		model.setHinh("avatar.jpg");

		String kq = "";
		String kqmd = "Thêm thành công";
		try {
			dao.update(model);
			kq = "Thêm thành công";

		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void chuaNhapSDT() {
		model.setMaKH("KH00088");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Số điện thoại không được để trống";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

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
		model.setHinh(null);

		String kq = "";
		String kqmd = "Bạn chưa chọn hình ảnh";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Bạn chưa chọn hình ảnh";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

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
		String kqmd = "Hình ảnh không đúng định dạng";
		try {
			dao.update(model);
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
		model.setMaKH("KH00088");
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
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Bạn chưa chọn hình ảnh";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

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
		String kqmd = "Tuổi không được nhỏ hơn 18";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Tuổi không được nhỏ hơn 18";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

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
		String kqmd = "Họ tên không chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Họ tên không chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}

	@Test
	public void NhapSDTKHSai() {
		model.setMaKH("KH00088");
		model.setTenKH("kk");
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
		String kqmd = "Số điện thoại của bạn không đúng định dạng";
		try {
			dao.update(model);
			kq = "Thành công";

		} catch (Exception e) {
			kq = "Số điện thoại của bạn không đúng định dạng";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);

	}
}

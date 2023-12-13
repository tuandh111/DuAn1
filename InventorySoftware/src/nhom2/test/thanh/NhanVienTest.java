package nhom2.test.thanh;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Model.NhanVienModel;

public class NhanVienTest {
	NhanVienDAO1 dao = new NhanVienDAO1();

	@Test
	public void testMa() {
		String kq = "";
		String kqmd = "Thành Công";
		List<NhanVienModel> list = dao.selectHoatDong();
		if (list != null) {
			kq = "Thành Công";
		} else {
			kq = "Thất Bại";
		}
		Assert.assertEquals(kq, kqmd);

	}

	@Test
	public void ThemNhanVienThanhCong() {
		String kqmd = "Thêm Mới Thành Công!";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV013");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0999911111");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Mới thành công!";
		} catch (Exception ex) {
			kqtt = "Thêm Nhân Viên Thất Bại";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiKhongChonNgay() {
		String kqmd = "Ngày sinh của nhân viên chưa được chọn";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("null");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Ngày sinh của nhân viên chưa được chọn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauBoTrong() {
		String kqmd = "Mật khẩu của nhân viên không được bỏ trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("null");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiChuaChonGioiTinh() {
		String kqmd = "Giới tính của nhân viên chưa được chọn";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();
		Boolean gt = Boolean.parseBoolean(null);
		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(gt);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Giới tính của nhân viên chưa được chọn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiDiaChiBoTrong() {
		String kqmd = "Địa chỉ của nhân viên không được bỏ trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Địa chỉ của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiHoTenBoTrong() {
		String kqmd = "Họ tên của nhân viên không được bỏ trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Họ tên của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTBoTrong() {
		String kqmd = "Số điện thoại của nhân viên không được bỏ trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiKhongChonVaiTro() {
		String kqmd = "Vai trò của nhân viên chưa được chọn";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Vai trò của nhân viên chưa được chọn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiNVChuaDu18T() {
		String kqmd = "Tuổi của nhân viên không thích hợp";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2010");
		nv.setGioiTinh(false);
		nv.setDiaChi("");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Tuổi của nhân viên không thích hợp";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTCoChu() {
		String kqmd = "Số điện thoại của nhân viên có chứa chữ";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678thanh");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên có chứa chữ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiDiaChiCokiTuDacBiet() {
		String kqmd = "Địa chỉ của nhân viên không hợp lệ";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Canther@1#!@#");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Địa chỉ của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauCoKiTuDacBiet() {
		String kqmd = "Mật khẩu của nhân viên không hợp lệ";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("null");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("@!#!@!1111");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiHoTenCoKiTuDacBiet() {
		String kqmd = "Họ tên của nhân viên không hợp lệ";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Văn An @#12");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Họ tên của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTQuaDai() {
		String kqmd = "Số điện thoại của nhân viên quá dài";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678thanh");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiEmailSaiDinhDang() {
		String kqmd = "Email của nhân viên thiếu @";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtngmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Email của nhân viên thiếu @";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauQuaNgan() {
		String kqmd = "Mật khẩu của nhân viên quá ngắn";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("null");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("1");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá ngắn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauQuaDai() {
		String kqmd = "Mật khẩu của nhân viên quá dài";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV("NV011");
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("null");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("a*52");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}
}

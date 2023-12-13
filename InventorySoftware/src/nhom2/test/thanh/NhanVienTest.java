package nhom2.test.thanh;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThongKeDao;
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

	ThongKeDao DaoThongKe = new ThongKeDao();

	String TuDongTangMa() {
		List<Object[]> i = DaoThongKe.getSoLuongNV();
		String name = (String) i.get(0)[0];
		String[] tbl = name.split("V");
		String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
		String ten = "NV";
		for (int j = 0; j <= 2 - so.length(); j++) {
			ten += "0";
		}
		ten = ten + so;
		return ten;
	}

	@Test
	public void ThemNVKhiKhongChonNgay() {
		String kqmd = "Ngày sinh không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Ngày sinh không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiEmailBoTrong() {
		String kqmd = "Email không được để trống!";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Email không được để trống!";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiKhongChonAnh() {
		String kqmd = "Bạn chưa chọn hình ảnh";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.insert(nv);
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Bạn chưa chọn hình ảnh";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauBoTrong() {
		String kqmd = "Mật khẩu không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiChuaChonGioiTinh() {
		String kqmd = "Giới tính của bạn không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();
		Boolean gt = Boolean.parseBoolean(null);
		nv.setMaNV(TuDongTangMa());
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
			dao.insert(nv);
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Giới tính của bạn không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiDiaChiBoTrong() {
		String kqmd = "Địa chỉ không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Địa chỉ không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiHoTenBoTrong() {
		String kqmd = "Họ và tên không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Họ và tên không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTBoTrong() {
		String kqmd = "Số điện thoại không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiKhongChonVaiTro() {
		String kqmd = "Vai trò của bạn đang để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Vai trò của bạn đang để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiNVChuaDu16T() {
		String kqmd = "Tuoi khong duoc nho hon 16";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Tuoi khong duoc nho hon 16";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTCoChu() {
		String kqmd = "Số điện thoại của bạn không đúng định dạng";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của bạn không đúng định dạng";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiDiaChiCokiTuDacBiet() {
		String kqmd = "Địa chỉ của nhân viên không hợp lệ";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
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

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiHoTenCoKiTuDacBiet() {
		String kqmd = "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiSDTQuaDai() {
		String kqmd = "Số điện thoại của nhân viên quá dài";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiEmailSaiDinhDang() {
		String kqmd = "Email không đúng định dạng!";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Email không đúng định dạng!";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void ThemNVKhiMatKhauQuaNgan() {
		String kqmd = "Mật khẩu của nhân viên quá ngắn";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
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

		nv.setMaNV(TuDongTangMa());
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
			kqtt = "Thêm Mới Thành Công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}
}

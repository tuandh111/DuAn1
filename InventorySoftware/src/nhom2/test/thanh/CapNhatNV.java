package nhom2.test.thanh;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Model.NhanVienModel;

public class CapNhatNV {

	NhanVienDAO1 dao = new NhanVienDAO1();

	@Test
	public void CNNhanVienThanhCong() {
		String kqmd = "Cập nhật Nhân Viên Thành Công";
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
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Cập nhật Nhân Viên Thất Bại";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiKhongChonNgay() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Ngày sinh của nhân viên chưa được chọn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauBoTrong() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

//	@Test
//	public void ThemNVKhiChuaChonGioiTinh() {
//		String kqmd = "Giới tính của nhân viên chưa được chọn";
//		String kqtt = "";
//		NhanVienModel nv = new NhanVienModel();
//
//		nv.setMaNV("NV011");
//		nv.setHoTen("Trần Ngọc Bích");
//		nv.setNgaySinh("10-10-2000");
//		nv.setGioiTinh();
//		nv.setDiaChi("Cần Thơ");
//		nv.setSDT("0912345678");
//		nv.setEmail("bichtn@gmail.com");
//		nv.setMatKhau("123456");
//		nv.setVaiTro("NV");
//		nv.setHinh("nhanvien.jpg");
//		nv.setTrangThai(true);
//		nv.setTrangThaiXoa(false);
//
//		try {
//			dao.update(nv);
//			kqtt = "Thêm Nhân Viên Thành Công";
//		} catch (Exception ex) {
//			kqtt = "Giới tính của nhân viên chưa được chọn";
//		}
//		assertEquals(kqmd, kqtt);
//	}
	@Test
	public void CNNVKhiDiaChiBoTrong() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Địa chỉ của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiHoTenBoTrong() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Họ tên của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTBoTrong() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên không được bỏ trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiKhongChonVaiTro() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Vai trò của nhân viên chưa được chọn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiNVChuaDu18T() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Tuổi của nhân viên không thích hợp";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTCoChu() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên có chứa chữ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTQuaDai() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiEmailSaiDinhDang() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Email của nhân viên thiếu @";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauQuaNgan() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá ngắn";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauQuaDai() {
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
			dao.update(nv);
			kqtt = "Cập nhật Nhân Viên Thành Công";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}
	public void testDeleteHoaDon() {
		NhanVienModel nv = new NhanVienModel();
		nv.setMaNV("NV011");
		dao.delete(nv);
		assertFalse(nv.isTrangThai());
	}
}

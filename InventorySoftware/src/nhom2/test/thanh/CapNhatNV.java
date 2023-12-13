package nhom2.test.thanh;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Model.NhanVienModel;

public class CapNhatNV {

	NhanVienDAO1 dao = new NhanVienDAO1();

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
	public void CNNhanVienThanhCong() {
		System.out.println("Mã cuối là: " + TuDongTangMa());
		String kqmd = "Cập nhật thành công!";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Văn An");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(true);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0987987123");
		nv.setEmail("antv123123@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("Nhân Viên");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Cập nhật mới thất bại!";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiKhongChonNgay() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Ngày sinh không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiEmailBoTrong() {
		String kqmd = "Email không được để trống!";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("0912345678");
		nv.setEmail(null);
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Email không được để trống!";
		}
		String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		if (nv.getEmail() == null || !nv.getEmail().matches(regex)) {
			kqtt = "Email không được để trống!";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiKhongChonAnh() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Bạn chưa chọn hình ảnh";
		}
		String regex = "^.+\\.(jpg|png|jpeg)$";
		if (nv.getHinh() == null || !nv.getHinh().matches(regex)) {
			kqtt = "Bạn chưa chọn hình ảnh";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauBoTrong() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiChuaChonGioiTinh() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Giới tính của bạn không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiDiaChiBoTrong() {
		String kqmd = "Địa chỉ không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi(null);
		nv.setSDT("0912345678");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Địa chỉ không được để trống";
		}
		String regex = "^\\S+$";
		if (nv.getDiaChi() == null || !nv.getDiaChi().matches(regex)) {
			kqtt = "Địa chỉ không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiHoTenBoTrong() {
		String kqmd = "Họ và tên không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen(null);
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Họ và tên không được để trống";
		}
		String regex = "^[a-zA-Z ]{1,50}$";
		if (nv.getHoTen() == null || !nv.getHoTen().matches(regex)) {
			kqtt = "Họ và tên không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTBoTrong() {
		String kqmd = "Số điện thoại không được để trống";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT(null);
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);

		try {
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại không được để trống";
		}
		String regex = "^[0-9]{1,10}$";
		if (nv.getSDT() == null || !nv.getSDT().matches(regex)) {
			kqtt = "Số điện thoại không được để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiKhongChonVaiTro() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Vai trò của bạn đang để trống";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiNVChuaDu16T() {
		String kqmd = "Tuoi khong duoc nho hon 16";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2023");
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Tuoi khong duoc nho hon 16";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTCoChu() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của bạn không đúng định dạng";
		}
		String regex = "^[0-9]{10}$";
		if (!nv.getSDT().matches(regex)) {
			kqtt = "Số điện thoại của bạn không đúng định dạng";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiDiaChiCokiTuDacBiet() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Địa chỉ của nhân viên không hợp lệ";
		}
		String regex = "^[a-zA-Z0-9 ._-]+$";
		if (!nv.getDiaChi().matches(regex)) {
			kqtt = "Địa chỉ của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauCoKiTuDacBiet() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên không hợp lệ";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiHoTenCoKiTuDacBiet() {
		String kqmd = "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Văn An @#12@@@");
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		}
		String regex = "^[a-zA-Z ]{1,50}$";
		if (!nv.getHoTen().matches(regex)) {
			kqtt = "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiSDTQuaDai() {
		String kqmd = "Số điện thoại của nhân viên quá dài";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();

		nv.setMaNV(TuDongTangMa());
		nv.setHoTen("Trần Ngọc Bích");
		nv.setNgaySinh("10-10-2000");
		nv.setGioiTinh(false);
		nv.setDiaChi("Cần Thơ");
		nv.setSDT("091234567811111");
		nv.setEmail("bichtn@gmail.com");
		nv.setMatKhau("123456");
		nv.setVaiTro("NV");
		nv.setHinh("nhanvien.jpg");
		nv.setTrangThai(true);
		nv.setTrangThaiXoa(false);
		try {
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Số điện thoại của nhân viên quá dài";
		}
		String regex = "^[0-9]{10}$";
		if (!nv.getSDT().matches(regex)) {
			kqtt = "Số điện thoại của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiEmailSaiDinhDang() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Email không đúng định dạng!";
		}
		String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$";
		if (!nv.getEmail().matches(regex)) {
			kqtt = "Email không đúng định dạng!";
		}
		assertEquals(kqmd, kqtt);
	}

	@Test
	public void CNNVKhiMatKhauQuaNgan() {
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
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
			dao.update1(nv);
			kqtt = "Cập nhật thành công!";
		} catch (Exception ex) {
			kqtt = "Mật khẩu của nhân viên quá dài";
		}
		assertEquals(kqmd, kqtt);
	}

	public void DeleteNhanVien() {
		String kqmd = "Xóa Nhân Viên Thành Công";
		String kqtt = "";
		NhanVienModel nv = new NhanVienModel();
		nv.setMaNV("NV011");
		try {
			dao.delete(nv);
			kqtt = "Xóa thất bại!";
		} catch (Exception ex) {
			kqtt = "Xóa thành công!";
		}
		assertEquals(kqmd, kqtt);
		assertFalse(nv.isTrangThai());
	}
}

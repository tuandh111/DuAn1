package nhom2.test.tuan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.DuAn1.Dao.HoaDonDAO;
import com.DuAn1.Model.HoaDonModel;
import com.DuAn1.form.HoaDon;

public class HoaDonTest {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();

	@Test
	public void testInSertHoaDonThanhCong() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Thêm dữ liệu thành công";
		hoaDonModel.setMaHD("HD00104");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(100000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			hoaDonDAO.insert(hoaDonModel);
			kq = "Thêm dữ liệu thành công";
		} catch (Exception e) {
			kq = "Mã đã tồn tại trong danh sách";
		}
		//Assert.assertNotNull(hoaDonDAO.TimKiem(hoaDonModel.getMaHD()));
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotMa() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã hóa đơn chưa nhập";
		hoaDonModel.setMaHD(null);
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023-01-01");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty(null);
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMaHD() == null) {
				kq = "Mã hóa đơn chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotSoLuong() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Số lượng chưa nhập";
		hoaDonModel.setMaHD("HD00104");
		hoaDonModel.setSoluong(null);
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(100000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getSoluong() == null) {
				kq = "Số lượng chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotDonGia() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Số lượng không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(-1);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getDongia() < 0) {
				kq = "Số lượng không được nhỏ hơn 0";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";

			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotTongTien() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tổng tiền không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(-1);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTongtien() < 0) {
				kq = "Tổng tiền không được nhỏ hơn 0";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotNgayXuat() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Ngày xuất chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat(null);
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getNgayXuat() == null) {
				kq = "Ngày xuất chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotMoTa() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Thêm dữ liệu thành công";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota(null);
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMota() == null) {
				kq = "Mô tả chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotTenCTY() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tên CTY chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty(null);
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTenCty() == null) {
				kq = "Tên CTY chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotMaNV() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã nhân viên chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV(null);
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMaNV() == null) {
				kq = "Mã nhân viên chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotMaKH() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã khách hàng chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH(null);
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTenKH() == null) {
				kq = "Mã khách hàng chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotHinhThuc() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Hình thức chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc(null);
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getHinhThuc() == null) {
				kq = "Hình thức chưa nhập";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotTienKhach() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tiền khách đưa không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(-1);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTienKhach() < 0) {
				kq = "Tiền khách đưa không được nhỏ hơn 0";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotTienKhachKhongHopLe() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Lỗi thêm dữ liệu";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");

		hoaDonModel.setTienCon(10000000);
		try {
			hoaDonModel.setTienKhach(Integer.parseInt("sdfsđfss"));
			hoaDonDAO.insert(hoaDonModel);
			kq = "Thêm dữ liệu thành công";
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Lỗi thêm dữ liệu";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testInSertHoaDonNotTienCon() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Thêm dữ liệu thành công";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(10000000);
		hoaDonModel.setTienCon(-1);
		try {
			if (hoaDonModel.getTienCon() < 0) {
				kq = "Tiền khách đưa không được nhỏ hơn 0";
			} else {
				hoaDonDAO.insert(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateAllHoaDonThanhCong() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Thành công";
		hoaDonModel.setMaHD("HD00101");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(100000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tản");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			hoaDonDAO.update(hoaDonModel);

			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testUpdateHoaDonNotMa() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã hóa đơn chưa nhập";
		hoaDonModel.setMaHD(null);
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023-01-01");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMaHD() == null) {
				kq = "Mã hóa đơn chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotSoLuong() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Số lượng chưa nhập";
		hoaDonModel.setMaHD("HD00104");
		hoaDonModel.setSoluong(null);
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(100000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getSoluong() == null) {
				kq = "Số lượng chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotDonGia() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Số lượng không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(-1);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getDongia() < 0) {
				kq = "Số lượng không được nhỏ hơn 0";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";

			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotTongTien() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tổng tiền không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(-1);
		hoaDonModel.setNgayXuat("2023/02/02");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTongtien() < 0) {
				kq = "Tổng tiền không được nhỏ hơn 0";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotNgayXuat() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Ngày xuất chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat(null);
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getNgayXuat() == null) {
				kq = "Ngày xuất chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotMoTa() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Cập nhật dữ liệu thành công";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("2023/01/01");
		hoaDonModel.setMota(null);
		hoaDonModel.setTenCty("CTY TTA MOBILE");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMota() == null) {
				kq = "Mô tả chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotTenCTY() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tên CTY chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty(null);
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTenCty() == null) {
				kq = "Tên CTY chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotMaNV() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã nhân viên chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV(null);
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getMaNV() == null) {
				kq = "Mã nhân viên chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotMaKH() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Mã khách hàng chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH(null);
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTenKH() == null) {
				kq = "Mã khách hàng chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotHinhThuc() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Hình thức chưa nhập";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc(null);
		hoaDonModel.setTienKhach(20000000);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getHinhThuc() == null) {
				kq = "Hình thức chưa nhập";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotTienKhach() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Tiền khách đưa không được nhỏ hơn 0";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(-1);
		hoaDonModel.setTienCon(10000000);
		try {
			if (hoaDonModel.getTienKhach() < 0) {
				kq = "Tiền khách đưa không được nhỏ hơn 0";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhât dữ liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testUpdateHoaDonNotTienCon() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		String kq = "";
		String kqmd = "Thêm dữ liệu thành công";
		hoaDonModel.setMaHD("HD00108");
		hoaDonModel.setSoluong("10");
		hoaDonModel.setTrangThai(true);
		hoaDonModel.setDongia(1200000);
		hoaDonModel.setTongtien(10000000);
		hoaDonModel.setNgayXuat("");
		hoaDonModel.setMota("Mô tả");
		hoaDonModel.setTenCty("CTY TTA");
		hoaDonModel.setMaNV("NV001");
		hoaDonModel.setTenKH("KH00001");
		hoaDonModel.setHinhThuc("Tiền mặt");
		hoaDonModel.setTienKhach(10000000);
		hoaDonModel.setTienCon(-1);
		try {
			if (hoaDonModel.getTienCon() < 0) {
				kq = "Tiền khách đưa không được nhỏ hơn 0";
			} else {
				hoaDonDAO.update(hoaDonModel);
				kq = "Cập nhật liệu thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = "Mã đã tồn tại trong danh sách";
		}
		Assert.assertEquals(kqmd, kq);
	}

	// @Test
	public void testSelectHoaDon() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		List<HoaDonModel> hoaDonList = hoaDonDAO.select();
		String kq = "";
		String kqmd = "Thành công";
		if (!hoaDonList.isEmpty()) {
			kq = "Thành công";
		}
		Assert.assertEquals(kq, kqmd);
	}

	 @Test
	 //Cần phải có danh sách hóa đơn được tạo trong hôm nay thì test case này sẽ pass
	public void testSelectHomNayHoaDon() {
		List<HoaDonModel> hoaDonListHomNay = hoaDonDAO.selectHomNay();
		String kq = "";
		String kqmm ="Hiển thị danh sách hóa đơn trong hôm nay";
		if (hoaDonListHomNay.isEmpty()) {
			kq = "Không có hóa đơn nào được tạo trong ngày hôm nay";
		} else {
			kq ="Hiển thị danh sách hóa đơn trong hôm nay";
		}
		Assert.assertEquals(kq, kqmm);
	}

	 @Test
	 //Cần có hóa đơn được tạo trong tuần này thì test case này sẽ được pass
	public void testSelectTuanNay() {
		List<HoaDonModel> hoaDonListTuanNay = hoaDonDAO.selectTuanNay();
		String kq = "";
		String kqmm="Hiển thị danh sách hóa đơn trong tuần này";
		if (hoaDonListTuanNay.isEmpty()) {
			kq = "Không có hóa đơn nào được tạo trong tuần này";
		} else {
			kq = "Hiển thị danh sách hóa đơn trong tuần này";
		}
		Assert.assertEquals(kq, kqmm);
	}

	 @Test
	//Cần tạo hóa đơn trong tháng này để có thể trả về danh sách để test case pass
	public void testSelectThangNay() {
		List<HoaDonModel> hoaDonListThangNay = hoaDonDAO.selectThangNay();
		String kq = "";
		String kqmm ="Hiển thị được danh sách tháng này";
		if (hoaDonListThangNay.isEmpty()) {
			kq = "Không có hóa đơn nào được tạo trong tuần này";
		} else {
			kq = "Hiển thị được danh sách tháng này";
		}
		Assert.assertEquals(kq,kqmm);
	}

	@Test
	public void testDeleteHoaDon() {
		HoaDonModel hoaDonModel = new HoaDonModel();
		hoaDonModel.setMaHD("HD00100");
		String kq = "";
		String kbmm = "Xóa dữ liệu thành công";
		try {
			hoaDonDAO.delete(hoaDonModel);
			kq = "Xóa dữ liệu thành công";
		} catch (Exception e) {
			kq = "Xóa dữ liệu không thành công";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kbmm);
		assertFalse(hoaDonModel.isTrangThai());
	}

	@Test
	public void testTimKiem() {
		String maTimKiem = "HD00021";
		String kq = "";
		String kbmm ="Tìm kiếm thành công";
		try {
		List<HoaDonModel> ketQuaTimKiem = hoaDonDAO.TimKiem(maTimKiem);
		if (ketQuaTimKiem != null) {
			assertNotNull(ketQuaTimKiem);
			for (HoaDonModel hoaDon : ketQuaTimKiem) {
				assertTrue(hoaDon.isTrangThai());
				assertTrue(hoaDon.getMaHD().contains(maTimKiem));
			}
			kq="Tìm kiếm thành công";
		}else {
			kq="Tìm kiếm thất bại";
		}
		} catch (Exception e) {
			// TODO: handle exception
			kq="Tìm kiếm thất bại";
		}
		Assert.assertEquals(kq, kbmm);
	}

}

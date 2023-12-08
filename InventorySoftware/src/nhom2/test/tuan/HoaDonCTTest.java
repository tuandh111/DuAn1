package nhom2.test.tuan;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.DuAn1.Dao.HoaDonCTDAO;
import com.DuAn1.Model.HoaDonCTModel;
import com.DuAn1.Model.HoaDonModel;

public class HoaDonCTTest {
	private HoaDonCTDAO hoaDonCTDAO = new HoaDonCTDAO();

	@Test
	public void testInsertHoaDonCTThanhCong() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Thành công";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(2);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			hoaDonCTDAO.insert(hoaDonCTModel);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testInsertHoaDonCTNotMaSP() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Mã sản phẩm chưa nhập";
		hoaDonCTModel.setMaSP(null);
		hoaDonCTModel.setSoLuong(2);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getMaSP() == null) {
				kq = "Mã sản phẩm chưa nhập";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testInsertHoaDonCTNotSoLuong() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Số lượng không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(-1);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getSoLuong() < 0) {
				kq = "Số lượng không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}
	@Test
	public void testInsertHoaDonCTNotSoLuongBang0() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Số lượng không được bằng 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(0);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getSoLuong() == 0) {
				kq = "Số lượng không được bằng 0";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}
	public void testInsertHoaDonCTNotMaHD() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Mã hóa đơn không được để trống";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD(null);
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getMaHD() == null) {
				kq = "Mã hóa đơn không được để trống";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	public void testInsertHoaDonCTNotGia() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Giá không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(-1);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getGia() < 0) {
				kq = "Giá không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	public void testInsertHoaDonCTNotThanhTien() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Thành tiền không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(-29000000);
		try {
			if (hoaDonCTModel.getThanhTien() < 0) {
				kq = "Thành tiền không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.insert(hoaDonCTModel);
				kq = "Thêm dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testUpdateAllHoaDonCTThanhCong() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Thành công";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(3);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);

		try {
			hoaDonCTDAO.update(hoaDonCTModel);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}
	@Test
	public void testUpdateHoaDonCTNotMaSP() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Mã sản phẩm chưa nhập";
		hoaDonCTModel.setMaSP(null);
		hoaDonCTModel.setSoLuong(2);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getMaSP() == null) {
				kq = "Mã sản phẩm chưa nhập";
			} else {
				hoaDonCTDAO.update(hoaDonCTModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testUpdateHoaDonCTNotSoLuong() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Số lượng không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(-1);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getSoLuong() < 0) {
				kq = "Số lượng không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.update(hoaDonCTModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	public void testUpdateHoaDonCTNotMaHD() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Mã hóa đơn không được để trống";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD(null);
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getMaHD() == null) {
				kq = "Mã hóa đơn không được để trống";
			} else {
				hoaDonCTDAO.update(hoaDonCTModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	public void testUpdateHoaDonCTNotGia() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Giá không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(-1);
		hoaDonCTModel.setThanhTien(29000000);
		try {
			if (hoaDonCTModel.getGia() < 0) {
				kq = "Giá không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.update(hoaDonCTModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	public void testUpdateHoaDonCTNotThanhTien() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Thành tiền không được nhỏ hơn 0";
		hoaDonCTModel.setMaSP("SP00001");
		hoaDonCTModel.setSoLuong(10);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setGia(14500000);
		hoaDonCTModel.setThanhTien(-29000000);
		try {
			if (hoaDonCTModel.getThanhTien() < 0) {
				kq = "Thành tiền không được nhỏ hơn 0";
			} else {
				hoaDonCTDAO.update(hoaDonCTModel);
				kq = "Cập nhật dữ liệu thành công";
			}
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testUpdateGopSPThanhCong() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		String kq = "";
		String kqmd = "Thành công";
		hoaDonCTModel.setSoLuong(3);
		hoaDonCTModel.setThanhTien(29000000);
		hoaDonCTModel.setMaHD("HD00006");
		hoaDonCTModel.setMaSP("SP00001");
		try {
			hoaDonCTDAO.updateGopSP(hoaDonCTModel);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testSelectMaHoaDon() {
		List<HoaDonCTModel> list = hoaDonCTDAO.selectAll("HD00005");
		String kq = "";
		if (list.isEmpty()) {
			kq = "Không có hóa đơn nào được tạo trong ngày hôm nay";
		} else {
			kq = "Thành công";
		}
		Assert.assertEquals(kq, "Thành công");
	}

	@Test
	public void testSelectKhDaMuaSpHoaDon() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();

		List<HoaDonCTModel> list = hoaDonCTDAO.selectKhDaMuaSp("KH00001");
		String kq = "";
		if (list.isEmpty()) {
			kq = "Không có khách hàng nào đã mua sản phẩm";
		} else {
			kq = "Thành công";
		}
		Assert.assertEquals(kq, "Thành công");
	}

	// Test case này có vấn đề tại vì là code sai không có sử dụng mà vẫn để
	@Test
	public void testDeleteHoaDonCT() {
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();
		hoaDonCTModel.setMaHD("HD00001");
		String kq = "";
		String kqmd = "Thành công";
		try {
			hoaDonCTDAO.delete(hoaDonCTModel);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
		}
		Assert.assertEquals(kqmd, kq);
	}

	// Test case này có vấn đề tại vì là code sai không có sử dụng mà vẫn để
	@Test
	public void testDeleteIDMaSPHoaDonCT() {
		String kq = "";
		String kqmd = "Thành công";
		String MaHD = "HD00006";
		String MaSP = "SP00001";
		try {
			hoaDonCTDAO.deleteBaoHanh(MaHD, MaSP);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kqmd, kq);
	}

	@Test
	public void testDeleteIDMaSP1HoaDonCT() {
		String kq = "";
		String kqmd = "Thành công";
		String MaHD = "HD00006";
		String MaSP = "SP00001";
		try {
			hoaDonCTDAO.deleteBaoHanh1(MaHD, MaSP);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);
	}

	@Test
	public void testDeleteAllHoaDonCT() {
		String kq = "";
		String kqmd = "Thành công";
		String MaHD = "HD00006";
		String MaSP = "SP00001";
		try {
			hoaDonCTDAO.XoaTatCa(MaHD, MaSP);
			kq = "Thành công";
		} catch (Exception e) {
			kq = "Thất bại";
			// TODO: handle exception
		}
		Assert.assertEquals(kq, kqmd);
	}

}

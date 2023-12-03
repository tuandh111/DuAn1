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

	// @Test
	public void testInsertHoaDonCT() {
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
	public void testUpdateHoaDonCT() {
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
	public void testUpdateGopSP() {
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
		HoaDonCTModel hoaDonCTModel = new HoaDonCTModel();

		List<HoaDonCTModel> list = hoaDonCTDAO.selectAll("HD00006");
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
	//Test case này có vấn đề
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
	//Test case này có vấn đề
	@Test
	public void testDeleteIDMaSPHoaDonCT() {
		String kq = "";
		String kqmd = "Thành công";
		String MaHD ="HD00006";
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
		String MaHD ="HD00006";
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
		String MaHD ="HD00006";
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

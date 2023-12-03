package nhom2.test.thang;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Model.KhachHangModel;

public class ThemKhachHang {

//	@Test
//	public void testInsert() {
//		KhachHangModel model = new KhachHangModel();
//		model.setMaKH("KH00900");
//		model.setTenKH("GG");
//		model.setSDT("0987654321");
//		model.setNgaySinh("2003/11/20");
//		model.setDiaChi("Cần Thơ");
//		model.setGT(false);
//		model.setLoaiKH("VIP 1");
//		model.setTrangThai(true);
//		model.setMoTa("gg");
//		model.setMaNV("NV001");
//		model.setHinh("");
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
	KhachHangDAO dao = new KhachHangDAO();

	@Test(dataProvider = "info")
	public void testThemKHThatBai(String MaKH, String TenKH, String SDT, String NgaySinh, String DiaChi, boolean GT,
			String LoaiKH, boolean TrangThai, String MoTa, String MaNV, String Hinh) {
		String kqmd = "Thêm thất bại";
		String kqtt = null;
		KhachHangModel model = new KhachHangModel();
		model.setMaKH(MaKH);
		model.setTenKH(TenKH);
		model.setSDT(SDT);
		model.setNgaySinh(NgaySinh);
		model.setDiaChi(DiaChi);
		model.setGT(GT);
		model.setLoaiKH(LoaiKH);
		model.setTrangThai(TrangThai);
		model.setMoTa(MoTa);
		model.setMaNV(MaNV);
		model.setHinh(Hinh);

		try {
			dao.insert(model);
			
			kqtt = "Thêm thành công";
		} catch (Exception e) {
			kqtt = "Thêm thất bại";

			e.printStackTrace();
		}

		assertEquals(kqmd, kqtt);

	}

	@DataProvider
	public Object[][] info() {
		return new Object[][] {
//				// 1 chưa chọn loại khách hàng
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", 1, null, 1,
//						"hi", "NV001", "avatar.jpg" },
//				// 2 chưa chọn giới tính
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", null, "VIP1", 1,
//						"hi", "NV001", "avatar.jpg" },
//				// 3 chưa chọn ngày sinh
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", null, "Cần Thơ", 1, "VIP1", 1, "hi",
//						"NV001", "avatar.jpg" },
//				// 4 chưa nhập địa chỉ
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", null, 1, "VIP1", 1, "hi",
//						"NV001", "avatar.jpg" },
//				// 5 chưa nhập tên KH
//				new Object[] { "KH00101", null, "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1, "hi", "NV001",
//						"avatar.jpg" },
//				// 6 chưa nhập mô tả
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1,
//						null, "NV001", "avatar.jpg" },
//				// 7 chưa nhập sdt
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", null, "2000-1-1", "Cần Thơ", 1, "VIP1", 1, "hi",
//						"NV001", "avatar.jpg" },
//				// 8 chưa chọn ảnh đại diện
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1,
//						"hi", "NV001", null },
//				// 9 chọn ảnh kh đúng định dạng
//				new Object[] { null, null, null, null, null, null, null, null, null, null, null },
//				// 10 để trống các dữ liệu
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1,
//						"hi", "NV001", "avatar.jpg" },
//				// 11 chọn ngày sinh <18t
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2023-12-1", "Cần Thơ", 1, "VIP1", 1,
//						"hi", "NV001", "avatar.jpg" },
//				// 12 nhập tên KH sai
//				new Object[] { "KH00101", "@#$%^&*! <3", "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1, "hi",
//						"NV001", "avatar.jpg" },
//				// 13 nhập sdt sai
//				new Object[] { "KH00101", "Trịnh Trần Hoàng Tuấn", "1900", "2000-1-1", "Cần Thơ", 1, "VIP1", 1, "hi",
//						"NV001", "avatar.jpg" },

				new Object[] { "KH10101", "Trịnh Trần Hoàng Tuấn", "0989898989", "2000-1-1", "Cần Thơ", 1, "VIP1", 1,
					"hi", "NV001", "avatar.jpg" }
		};
	}

}

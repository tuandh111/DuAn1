package nhom2.test.len;

import static org.junit.Assert.assertEquals;



import org.testng.annotations.Test;


import com.DuAn1.Dao.DatSPDAO;

import com.DuAn1.Model.DatSPModel;


public class DatHangTest {
	@Test
	public void testDH99() {
		String kqmd = "Thêm dữ liệu thành công";
		String kqtt= null;
		DatSPModel model = new DatSPModel();
		DatSPDAO dao = new DatSPDAO();
		model.setSoLuong("3");
		model.setSDT("01287674336");
		try {
            dao.insert(model);
            kqtt = "Thêm dữ liệu thành công";
        } catch (Exception e) {
        	kqtt = "Thất bại";
        }
		assertEquals(kqmd, kqtt);
	}
}

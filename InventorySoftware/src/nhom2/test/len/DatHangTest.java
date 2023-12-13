package nhom2.test.len;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.testng.annotations.Test;

import com.DuAn1.Dao.DatSPCTDAO;
import com.DuAn1.Dao.DatSPDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.ThaoTacModel;


public class DatHangTest {
	SanPhamDAO daoSP = new SanPhamDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    DatSPDAO daoDatSP = new DatSPDAO();
    DefaultTableModel tblModel;
    DatSPCTDAO daoDatSPCT = new DatSPCTDAO();
    ThongKeDao daoThongKe = new ThongKeDao();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();
    DatSPModel dsp = new DatSPModel();
    public void TuDongTangMa() {
        List<Object[]> i = daoThongKe.getMaxMaDatSP();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("H");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "DH";
        for (int j = 0; j <= 4 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
    }
    
    @Test
	public void testDH26() {
		String kqmd = "Thêm dữ liệu thành công";
		String kqtt= null;
		DatSPModel model = new DatSPModel();
		DatSPDAO dao = new DatSPDAO();
		
		
		try {
			TuDongTangMa();
			model.setSoLuong("3");
			model.setSDT("01287674336");
            daoDatSP.insert(model);
        } catch (Exception e) {
        	kqtt = "Thất bại";
        }
		assertEquals(kqmd, kqtt);
	}
    @Test
	public void testDH30() {
		String kqmd = "Không đủ sản phẩm";
		String kqtt= null;
		DatSPModel model = new DatSPModel();
		DatSPDAO dao = new DatSPDAO();
		
		
		try {
			TuDongTangMa();
			model.setSoLuong("3");
			model.setSDT("01287674336");
            daoDatSP.insert(model);
            kqtt = "Không đủ sản phẩm";
        } catch (Exception e) {
        	kqtt = "Thất bại";
        }
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testDH99() {
		String kqmd = "Thêm dữ liệu thành công";
		String kqtt= null;
		DatSPModel model = new DatSPModel();
		DatSPDAO dao = new DatSPDAO();
		
		
		try {
			TuDongTangMa();
			model.setSoLuong("3");
			model.setSDT("01287674336");
            daoDatSP.insert(model);
        } catch (Exception e) {
        	kqtt = "Thất bại";
        }
		assertEquals(kqmd, kqtt);
	}
	@Test
	public void testDH103() {
		String kqmd = "Thêm dữ liệu thành công";
		String kqtt= null;
		DatSPModel model = new DatSPModel();
		DatSPDAO dao = new DatSPDAO();
		model.setSoLuong("1000");
		model.setSDT("01287674336");
		try {
			TuDongTangMa();
            dao.insert(model);
            kqtt = "Thêm dữ liệu thành công";
        } catch (Exception e) {
        	kqtt = "Thất bại";
        }
		assertEquals(kqmd, kqtt);
	}
}

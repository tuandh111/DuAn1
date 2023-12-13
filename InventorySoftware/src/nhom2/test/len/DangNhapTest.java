package nhom2.test.len;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.MaHoa.MaHoa;
import com.DuAn1.Model.NhanVienModel;

public class DangNhapTest {
	
	
	MaHoa MH = new MaHoa();
    NhanVienDAO1 dao = new NhanVienDAO1();
    MaHoa mahoa = new MaHoa();
    ShareHelper sh = new ShareHelper();
    @Test
    public void testDN4() {
    	String kqmd = "Đăng nhập thành công";
		String kqtt= null;
		String manv = "NV002";
		String mk = MH.toSHA(new String("kkk"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Đăng nhập thành công";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN5() {
    	String kqmd = "Sai mật khẩu";
		String kqtt= null;
		String manv = "NV002";
		String mk = MH.toSHA(new String("1234"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Sai mật khẩu";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    
    @Test
    public void testDN6() {
    	String kqmd = "Tài khoản không được chứa kí tự đặc biệt";
		String kqtt= null;
		String manv = "NV012#";
		String mk = MH.toSHA(new String("kkk"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Tài khoản không được chứa kí tự đặc biệt";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN7() {
    	String kqmd = "Không được bỏ trống tên đăng nhập";
		String kqtt= null;
		String manv = "";
		String mk = MH.toSHA(new String("kkk"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(manv.equals("")) {
				kqtt = "Không được bỏ trống tên đăng nhập";}
			else {
				sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Thành công";}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    
    @Test
    public void testDN8() {
    	String kqmd = "Không được bỏ trống tên đăng nhập";
		String kqtt= null;
		String manv = "";
		String mk = MaHoa.toSHA(new String("123"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(manv.equals("")) {
				kqtt = "Không được bỏ trống tên đăng nhập";}
			else {
				ShareHelper.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Thành công";}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
   
    @Test
    public void testDN9() {
    	String kqmd = "Chưa nhập password";
		String kqtt= null;
		String manv = "NV002";
		String mk = "";
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(mk.equals("")) {
				kqtt = "Chưa nhập password";
			}
			else {
				ShareHelper.USER = taikhoan;
				matKhau.equals(taikhoan.getMatKhau().trim());
				kqtt = "thành công";
			}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    
    @Test
    public void testDN10() {
    	String kqmd = "Vui lòng nhập lại mật khẩu không quá 50 ký tự";
		String kqtt= null;
		String manv = "NV002";
		String mk = MH.toSHA(new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(matKhau.length() > 50) {
				kqtt = "Vui lòng nhập lại mật khẩu không quá 50 ký tự";
			}
			else {
				sh.USER = taikhoan;
				matKhau.equals(taikhoan.getMatKhau().trim());
				kqtt = "thành công";
			}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN11() {
    	String kqmd = "Mật khẩu không được chứa kí tự đặc biệt";
		String kqtt= null;
		String manv = "NV012";
		String mk = MH.toSHA(new String("12%"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Mật khẩu không được chứa kí tự đặc biệt";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN12() {
    	String kqmd = "Tài khoản không được chứa kí tự đặc biệt";
		String kqtt= null;
		String manv = "NV012";
		String mk = MH.toSHA(new String("12%"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Tài khoản không được chứa kí tự đặc biệt";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN15() {
    	String kqmd = "Đăng nhập thành công";
		String kqtt= null;
		String manv = "NV009";
		String mk = MH.toSHA(new String("123"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Đăng nhập thành công";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN16() {
    	String kqmd = "Sai mật khẩu";
		String kqtt= null;
		String manv = "NV009";
		String mk = MH.toSHA(new String("0123"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Sai mật khẩu";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN17() {
    	String kqmd = "Chưa nhập password";
		String kqtt= null;
		String manv = "NV009";
		String mk = "";
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(mk.equals("")) {
				kqtt = "Chưa nhập password";
			}
			else {
				ShareHelper.USER = taikhoan;
				matKhau.equals(taikhoan.getMatKhau().trim());
				kqtt = "thành công";
			}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN18() {
    	String kqmd = "Vui lòng nhập lại mật khẩu không quá 50 ký tự";
		String kqtt= null;
		String manv = "NV009";
		String mk = MH.toSHA(new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(matKhau.length() > 50) {
				kqtt = "Vui lòng nhập lại mật khẩu không quá 50 ký tự";
			}
			else {
				sh.USER = taikhoan;
				matKhau.equals(taikhoan.getMatKhau().trim());
				kqtt = "thành công";
			}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN20() {
    	String kqmd = "Tài khoản không được chứa kí tự đặc biệt";
		String kqtt= null;
		String manv = "NV012#";
		String mk = MH.toSHA(new String("kkk"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Tài khoản không được chứa kí tự đặc biệt";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN21() {
    	String kqmd = "Không được bỏ trống tên đăng nhập";
		String kqtt= null;
		String manv = "";
		String mk = MH.toSHA(new String("123"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(manv.equals("")) {
				kqtt = "Không được bỏ trống tên đăng nhập";}
			else {
				sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Thành công";}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN22() {
    	String kqmd = "Chưa nhập password";
		String kqtt= null;
		String manv = "NV009";
		String mk = "";
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			if(mk.equals("")) {
				kqtt = "Chưa nhập password";
			}
			else {
				ShareHelper.USER = taikhoan;
				matKhau.equals(taikhoan.getMatKhau().trim());
				kqtt = "thành công";
			}
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
    @Test
    public void testDN23() {
    	String kqmd = "Tài khoản không được chứa kí tự đặc biệt";
		String kqtt= null;
		String manv = "NV012#";
		String mk = MH.toSHA(new String("123#"));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
		try {
			sh.USER = taikhoan;
			matKhau.equals(taikhoan.getMatKhau().trim());
			kqtt = "Chưa nhập password";
		}catch(Exception ex) {
			kqtt = "Thất bại";
		}
		assertEquals(kqmd, kqtt);
	}
}

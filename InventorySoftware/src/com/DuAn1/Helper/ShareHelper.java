package com.DuAn1.Helper;
import com.tuandhpc05076.Dao.NhanVienDAO;
import com.DuAn1.Model.NhanVienModel;
import com.tuandhpc05076.Object.O_NhanVien;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Tuấn 
 */
public class ShareHelper {
    /*
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
    public static final Image APP_ICON;
    static{
        // Tải biểu tượng ứng dụng
        String file = "/com/tuandhpc05076/icon1/fptt.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }
    
    /*
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param file là đối tượng file ảnh
     * @return chép được hay không
     */   
    public static boolean saveLogo(File file){
        File dir = new File("Logos");
        // Tạo thư mục nếu chưa tồn tại
        if(!dir.exists()){
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } 
        catch (Exception ex) {
            return false;
        }
    }
    /*
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @return ảnh đọc được
     */   
    public static ImageIcon readLogo(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    } 
    /*
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVienModel USER = null;
    public static String ThoiGianHoatDong=null;
    /*
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        ShareHelper.USER = null;
    }
    /*
     * Kiểm tra xem đăng nhập hay chưa
     * @return đăng nhập hay chưa
     */
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
    /*
      Kiểm tra quyền người dùng có phải là trưởng phòng
    */
    public static boolean isVaiTro(){
        if(USER.getVaiTro().equalsIgnoreCase("QL"))return true;
        return false;
    }
    public static boolean isManager(){
        return ShareHelper.authenticated() && ShareHelper.isVaiTro();
    }
}

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
    public static final Image APP_ICON;
    static{
        String file = "/com/tuandhpc05076/Image/training.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }
      
    public static boolean saveLogo(File file){
        File dir = new File("Logos");
        if(!dir.exists()){
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } 
        catch (Exception ex) {
            return false;
        }
    }  
    public static ImageIcon readLogo(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    } 
    public static NhanVienModel USER = null;
    public static String ThoiGianHoatDong=null;
    public static void logoff() {
        ShareHelper.USER = null;
    }
    public static boolean authenticated() {
        return ShareHelper.USER != null;
    }
    public static boolean isVaiTro(){
        if(USER.getVaiTro().equalsIgnoreCase("QL"))return true;
        return false;
    }
    public static boolean isManager(){
        return ShareHelper.authenticated() && ShareHelper.isVaiTro();
    }
}

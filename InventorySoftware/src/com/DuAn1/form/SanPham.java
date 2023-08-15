/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.DongMayDAO;
import com.DuAn1.Dao.GiamGiaDao;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.QuetMaQR.QuetMa;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import com.DuAn1.main.Main;
import com.tuandhpc05076.Form.ChuyenDe;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.BoNhoModel;
import com.DuAn1.Model.CPUModel;
import com.DuAn1.Model.CameraModel;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.GiamGiaModel;
import com.DuAn1.Model.MangHinhModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.PinModel;
import com.DuAn1.Model.RamModel;
import com.DuAn1.Model.SanPhamModel;
import com.DuAn1.Model.ThaoTacModel;
import static com.tuandhpc05076.Form.NguoiHoc.listNH;
import com.tuandhpc05076.Object.O_NguoiHoc;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL E5470
 */
public class SanPham extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    SanPhamDAO Dao = new SanPhamDAO();
    DienThoaiDao DaoDT = new DienThoaiDao();
    DongMayDAO daoDongMay = new DongMayDAO();
    ThongKeDao DaoThongKe = new ThongKeDao();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();
    // the webcam object
    private WebcamPanel panel;
    int row = -1;

    ;
    public SanPham() {

        initComponents();
//        dateChooser.addEventDateChooser(new EventDateChooser() {
//            @Override
//            public void dateSelected(SelectedAction action, SelectedDate date) {
//                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
//                if (action.getAction() == SelectedAction.DAY_SELECTED) {
//                    dateChooser.hidePopup();
//                }
//            }
//        });
        tblUser.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUser.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblUser.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblUser.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblUser.getColumnModel().getColumn(4).setPreferredWidth(0);

//        TieuDe();
        filltable();
        setLayout(new FlowLayout()); // set the layout of the frame
        // set the default close operation of the frame
        LoadCombobox();
        LoaiSanPham.setBorder(new TitledBorder("Loại sản phẩm"));
        TuDongTangMa();
        txtGia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!txtGia.getText().equals("")) {
                    double gia = Double.parseDouble(txtGia.getText().replace(",", ""));
                    DecimalFormat df = new DecimalFormat("###,###,###");
                    df.setMaximumFractionDigits(0);
                    txtGia.setText(df.format(gia));
                }
            }
        });
    }

    void TuDongTangMa() {
        List<Object[]> i = DaoThongKe.getSoLuongSP();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("P");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "SP";
        for (int j = 0; j <= 4 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtMaSP.setText(ten);
    }

    void LoadCombobox() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        GiamGiaDao daoGiamGia = new GiamGiaDao();
        ArrayList<GiamGiaModel> listGiamGia = (ArrayList<GiamGiaModel>) daoGiamGia.select();
        for (GiamGiaModel gg : listGiamGia) {
            String dateString = gg.getNgayBD();
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            comboboxmodel.addElement(gg.getMaGG().trim() + " (" + gg.getPhanTram() + " %) " + " (" + formattedDate + ") ");
        }
        cboKhuyenMai.setModel(comboboxmodel);
        cboKhuyenMai.setSelectedIndex(-1);
    }

    void LoadComboboxCPU() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<CPUModel> listCPU = (ArrayList<CPUModel>) daoDongMay.selectCPU(cboString);
        for (CPUModel cpu : listCPU) {
            comboboxmodel.addElement(cpu.getMaCPU().trim());
        }
        cboCPU.setModel(comboboxmodel);
        cboCPU.setSelectedIndex(-1);
    }

    void LoadComboboxRam() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<RamModel> listRam = (ArrayList<RamModel>) daoDongMay.selectRam(cboString);
        for (RamModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaRam().trim());
        }
        cboRam.setModel(comboboxmodel1);
        cboRam.setSelectedIndex(-1);
    }

    void LoadComboboxBoNho() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<BoNhoModel> listRam = (ArrayList<BoNhoModel>) daoDongMay.selectBoNho(cboString);
        for (BoNhoModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaBoNho().trim());
        }
        cboBoNho.setModel(comboboxmodel1);
        cboBoNho.setSelectedIndex(-1);
    }

    void LoadComboboxCamera() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<CameraModel> listRam = (ArrayList<CameraModel>) daoDongMay.selectCamera(cboString);
        for (CameraModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaCamera().trim());
        }
        cboCamera.setModel(comboboxmodel1);
        cboCamera.setSelectedIndex(-1);
    }

    void LoadComboboxPin() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<PinModel> listRam = (ArrayList<PinModel>) daoDongMay.selectPin(cboString);
        for (PinModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaPin().trim());
        }
        cboPin.setModel(comboboxmodel1);
        cboPin.setSelectedIndex(-1);
    }

    void LoadComboboxMangHinh() {
        DefaultComboBoxModel comboboxmodel1 = new DefaultComboBoxModel();
        String cboString = (String) cboLoaiSanPham.getSelectedItem();
        ArrayList<MangHinhModel> listRam = (ArrayList<MangHinhModel>) daoDongMay.selectMangHinh(cboString);
        for (MangHinhModel cpu : listRam) {
            comboboxmodel1.addElement(cpu.getMaMangHinh().trim());
        }
        cboMangHinh.setModel(comboboxmodel1);
        cboMangHinh.setSelectedIndex(-1);
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<SanPhamModel> list = Dao.select();
            for (SanPhamModel nv : list) {
                DecimalFormat df = new DecimalFormat("#,##0.##");

                Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong()+" Chiec", nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    SanPhamModel getFormSP() {
        SanPhamModel cd = new SanPhamModel();
        cd.setMaSP(txtMaSP.getText());
        cd.setTenSP(txtTenSP.getText());
        cd.setMau((String) cboMau.getSelectedItem());
        String Gia = txtGia.getText();
        Gia = Gia.replace(",", "");
        cd.setGia(Double.parseDouble(Gia));
        cd.setLoaiSP((String) cboLoaiSanPham.getSelectedItem());

        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayNhap.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            cd.setNgayNhap(ngayNhap);

        } catch (Exception e) {
        }

        cd.setNoiNhap(txtNoiNhap.getText());
        cd.setSoLuong((int) txtSoLuong.getValue());
        cd.setTrangThai(true);
        cd.setHinh(txtHinhAnh.getToolTipText()+txtMaSP.getText().trim());
        cd.setMaNV(ShareHelper.USER.getMaNV());
        String KhuyenMai = (String) cboKhuyenMai.getSelectedItem();
        KhuyenMai = KhuyenMai.substring(0, 5);
        cd.setMaGiamGia(KhuyenMai);
        return cd;
    }

    DienThoaiModel getFormDT() {
        DienThoaiModel dt = new DienThoaiModel();
        dt.setMaDT(txtMaSP.getText());
        dt.setCPU((String) cboCPU.getSelectedItem());
        dt.setMangHinh((String) cboMangHinh.getSelectedItem());
        dt.setBoNho((String) cboBoNho.getSelectedItem());
        dt.setMoTa(txtMoTa.getText());
        dt.setCamera((String) cboCamera.getSelectedItem());
        dt.setPin((String) cboPin.getSelectedItem());
        dt.setRam((String) cboRam.getSelectedItem());
        return dt;
    }
    int kiemSL = 0;

    void setFormSP(SanPhamModel sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        cboMau.setSelectedItem(sp.getMau());

        GiamGiaDao daoGiamGia = new GiamGiaDao();
        ArrayList<GiamGiaModel> listGiamGia = (ArrayList<GiamGiaModel>) daoGiamGia.select();
        for (GiamGiaModel gg : listGiamGia) {
            String dateString = gg.getNgayBD();
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            if (gg.getMaGG().trim().equalsIgnoreCase(sp.getMaGiamGia().trim())) {
                cboKhuyenMai.setSelectedItem(sp.getMaGiamGia().trim() + " (" + gg.getPhanTram() + " %) " + " (" + formattedDate + ") ");
                break;
            }
        }

//        cboKhuyenMai.setSelectedItem(sp.getMaGiamGia().toString());
        DecimalFormat df = new DecimalFormat("#,##0.##");
        txtGia.setText(df.format(sp.getGia()));
        cboLoaiSanPham.setSelectedItem(sp.getLoaiSP());

        try {
            String dateString = sp.getNgayNhap();
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgayNhap.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNoiNhap.setText(sp.getNoiNhap());
        if (sp.getSoLuong() == 0) {
            DialogHelper.alert(this, "So luong san pham nay da het");
            kiemSL = 1;
        } else {
            kiemSL = 0;
        }
        txtSoLuong.setValue(sp.getSoLuong());
        if (sp.getHinh() != null) {
            String TenHinh = sp.getHinh().trim();
            TenHinh=TenHinh.replace(sp.getMaSP().trim(),"");
            txtHinhAnh.setToolTipText(TenHinh);
            txtHinhAnh.setIcon(ShareHelper.readLogo(TenHinh));
            txtHinhAnh.setToolTipText(TenHinh);
            ImageIcon originalIcon = ShareHelper.readLogo(TenHinh);
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH);
            txtHinhAnh.setIcon(new ImageIcon(scaledImage));
        }

    }

    void setFormDT(DienThoaiModel dt
    ) {
        cboCPU.setSelectedItem(dt.getCPU().trim());
        cboMangHinh.setSelectedItem(dt.getMangHinh().trim());
        cboBoNho.setSelectedItem(dt.getBoNho().trim());
        cboCamera.setSelectedItem(dt.getCamera().trim());
        cboPin.setSelectedItem(dt.getPin().trim());
        cboRam.setSelectedItem(dt.getRam().trim());
        if (dt.getMoTa() != null) {
            txtMoTa.setText(dt.getMoTa());
        }

    }

//    void edit() {
//        String manv = (String) tblUser.getValueAt(this.row, 0);
//        SanPhamModel nv = Dao.findById(manv);
//        this.setFormSP(nv);
//        this.updateStatus();
//    }
    void updateStatus(boolean insertable
    ) {
        txtMaSP.setEditable(insertable);
        btnThem.setEnabled(insertable);
        btnSua.setEnabled(!insertable);
        btnXoa.setEnabled(!insertable);

        boolean first = this.row > 0;
        boolean last = this.row < tblUser.getRowCount() - 1;
        btnFirst.setEnabled(!insertable && first);
        btnPrev.setEnabled(!insertable && first);
        btnLast.setEnabled(!insertable && last);
        btnNext.setEnabled(!insertable && last);
    }

    boolean checkForm() {
        if (txtHinhAnh.getToolTipText() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn hình ảnh");
            return false;
        }
        if (txtTenSP.getText().equals("")) {
            DialogHelper.alert(this, "Bạn chưa nhập tên sản phẩm");
            return false;
        }
        if (cboMau.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn màu");
            return false;
        }
        if (txtGia.getText().equals("")) {
            DialogHelper.alert(this, "Bạn chưa nhập giá");
            return false;
        }
        try {
            Float.parseFloat(txtGia.getText());
            if (Float.parseFloat(txtGia.getText()) < 0) {
                DialogHelper.alert(this, "Giá của bạn không được nhỏ hơn 0");
                return false;
            }
        } catch (Exception e) {
//            DialogHelper.alert(this, "Giá không phải lá số");
//            return false;
        }
        if (txtNoiNhap.getText().equals("")) {
            DialogHelper.alert(this, "Bạn chưa nhập nơi nhập");
            return false;
        }
        if ((int) txtSoLuong.getValue() < 0) {
            DialogHelper.alert(this, "Số lượng không được nhỏ hơn 0");
            return false;
        }
        if (cboLoaiSanPham.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn loại sản phẩm");
            return false;
        }
//        if (cboKhuyenMai.getSelectedItem() == null) {
//            DialogHelper.alert(this, "Chọn khuyến mại");
//            return false;
//        }
        if (cboCPU.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn CPU");
            return false;
        }
        if (cboRam.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn Ram");
            return false;
        }
        if (cboBoNho.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn bộ nhớ");
            return false;
        }
        if (cboPin.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn Pin");
            return false;
        }
        if (cboCamera.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn Camera");
            return false;
        }
        if (cboMangHinh.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn Màng hình");
            return false;
        }
        if (cboKhuyenMai.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn khuyến mại");
            return false;
        }
        if (Kiem) {
            DialogHelper.alert(this, "Bạn chưa chọn khuyến mại phù hợp");
            return false;
        }
        return true;
    }

    void them() {
        if (checkForm() == false) {
            return;
        }
        try {
            SanPhamModel model = getFormSP();
            DienThoaiModel modeldt = getFormDT();
            Dao.insert(model);
            DaoDT.insert(modeldt);
            ThaoTacModel ThaoTacModel = getFormThem();
            daoThaoTac.insert(ThaoTacModel);
            DialogHelper.alert(this, "Thêm dữ liệu thành công");
            filltable();
            clear();
            TuDongTangMa();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }

    public ThaoTacModel getFormThem() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);

        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sản Phẩm");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormUpdate() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);

        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sản Phẩm");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormDelete() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);

        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sản Phẩm");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    void delete() {
        int chon = tblUser.getSelectedRow();
        if (chon < 0) {
            DialogHelper.alert(this, "Bạn cần chọn sản phẩm để có thể xóa");
            return;
        }
        SanPhamModel sp = getFormSP();
        try {
            Dao.delete(sp);
            ThaoTacModel ThaoTacModel = getFormDelete();
            daoThaoTac.insert(ThaoTacModel);
            filltable();
            clear();
            DialogHelper.alert(this, "Xóa thành công");
            TuDongTangMa();
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }

    }

    public void btnInDanhSach() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Sản phẩm");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblUser.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblUser.getColumnName(i));
                }

                for (int j = 0; j < tblUser.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblUser.getColumnCount(); k++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(k);
                        if (tblUser.getValueAt(j, k) != null) {
                            cell.setCellValue(tblUser.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                OpenFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public void OpenFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
        }
    }

    void clear() {
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaSP.setText("");
        txtTenSP.setText("");
        cboMau.setSelectedItem(null);
        txtGia.setText("");
        cboLoaiSanPham.setSelectedItem(null);
        txtNgayNhap.setText("");
        txtNoiNhap.setText("");
        txtSoLuong.setValue(0);

        txtHinhAnh.setToolTipText("");
        txtHinhAnh.setIcon(ShareHelper.readLogo(""));

        cboKhuyenMai.setSelectedItem(null);
    }

    public void Sua() {
        int chon = tblUser.getSelectedRow();
        if (chon < 0) {
            DialogHelper.alert(this, "Bạn cần chọn sản phẩm để có thể sua");
            return;
        }
        if ((int) txtSoLuong.getValue()<=0) {
            DialogHelper.alert(this, "Hay xoa san pham hoac cap nhat lai so luong san pham nay");
            return;
        }
        if (checkForm() == false) {
            return;
        }

        SanPhamModel daoSP = getFormSP();
        DienThoaiModel daoDT = getFormDT();
        try {
            Dao.update(daoSP);
            DaoDT.update(daoDT);
            filltable();
            ThaoTacModel ThaoTacModel = getFormUpdate();
            daoThaoTac.insert(ThaoTacModel);
            clear();
            DialogHelper.alert(this, "Cập nhật thông tin thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi sửa thông tin");
            e.printStackTrace();
        }
    }

    void first() {
        this.row = 0;
        tblUser.setRowSelectionInterval(row, row);
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            tblUser.setRowSelectionInterval(row, row);
            this.edit();
        }
    }

    void next() {
        if (this.row < tblUser.getRowCount() - 1) {
            this.row++;
            tblUser.setRowSelectionInterval(row, row);
            this.edit();
        }
    }

    void last() {
        this.row = tblUser.getRowCount() - 1;
        tblUser.setRowSelectionInterval(row, row);
        this.edit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new com.raven.swing.table.Table();
        txtNgayNhap = new com.DuAn1.Swing.TextField();
        txtTenSP = new com.DuAn1.Swing.TextField();
        txtGia = new com.DuAn1.Swing.TextField();
        txtNoiNhap = new com.DuAn1.Swing.TextField();
        txtMoTa = new com.DuAn1.Swing.TextField();
        cboMau = new com.DuAn1.Swing.Combobox();
        cboKhuyenMai = new com.DuAn1.Swing.Combobox();
        cboLoaiSanPham = new com.DuAn1.Swing.Combobox();
        txtSoLuong = new com.DuAn1.Swing.Spinner();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        jPanel1 = new javax.swing.JPanel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        cboSapXep = new com.DuAn1.Swing.Combobox();
        jPanel2 = new javax.swing.JPanel();
        btnTang = new com.DuAn1.Swing.Button();
        btnGiam = new com.DuAn1.Swing.Button();
        LoaiSanPham = new javax.swing.JPanel();
        cboCPU = new com.DuAn1.Swing.Combobox();
        cboRam = new com.DuAn1.Swing.Combobox();
        cboBoNho = new com.DuAn1.Swing.Combobox();
        cboCamera = new com.DuAn1.Swing.Combobox();
        cboMangHinh = new com.DuAn1.Swing.Combobox();
        cboPin = new com.DuAn1.Swing.Combobox();
        btnTimKiem = new com.DuAn1.Swing.Button();
        btnNext = new com.DuAn1.Swing.Button();
        btnFirst = new com.DuAn1.Swing.Button();
        btnPrev = new com.DuAn1.Swing.Button();
        btnLast = new com.DuAn1.Swing.Button();
        txtHinh = new swing.PanelShadow();
        txtHinhAnh = new javax.swing.JLabel();
        txtMaSP = new com.DuAn1.Swing.TextField();
        switchButton1 = new com.DuAn1.swing0.SwitchButton();
        jLabel3 = new javax.swing.JLabel();
        button15 = new com.DuAn1.Swing.Button();

        dateChooser.setFocusCycleRoot(true);
        dateChooser.setTextRefernce(txtNgayNhap);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1058, 741));
        setPreferredSize(new java.awt.Dimension(1058, 741));
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                formCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên sản phẩm", "Giá", "Số lượng", "Giảm giá             "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setName(""); // NOI18N
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);
        if (tblUser.getColumnModel().getColumnCount() > 0) {
            tblUser.getColumnModel().getColumn(4).setMinWidth(100);
            tblUser.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblUser.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        txtNgayNhap.setLabelText("Ngày nhập");
        txtNgayNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayNhapMouseClicked(evt);
            }
        });
        txtNgayNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayNhapActionPerformed(evt);
            }
        });

        txtTenSP.setLabelText("Tên ");
        txtTenSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTenSPCaretUpdate(evt);
            }
        });
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        txtGia.setToolTipText("");
        txtGia.setLabelText("Giá");
        txtGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiaCaretUpdate(evt);
            }
        });
        txtGia.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtGiaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaFocusLost(evt);
            }
        });
        txtGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGiaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtGiaMouseReleased(evt);
            }
        });
        txtGia.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                txtGiaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtGiaInputMethodTextChanged(evt);
            }
        });
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        txtNoiNhap.setLabelText("Nơi nhập");

        txtMoTa.setLabelText("Mô tả");

        cboMau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đen", "Trắng", "Xanh", "Vàng" }));
        cboMau.setSelectedIndex(-1);
        cboMau.setLabeText("Màu sắc");

        cboKhuyenMai.setLabeText("Chọn khuyến mại");
        cboKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhuyenMaiActionPerformed(evt);
            }
        });

        cboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Iphone", "Samsung", "Sony" }));
        cboLoaiSanPham.setSelectedIndex(-1);
        cboLoaiSanPham.setLabeText("Loại sản phẩm");
        cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSanPhamActionPerformed(evt);
            }
        });

        txtSoLuong.setLabelText("Số lượng");

        txtTimKiem.setHint("Tìm kiếm theo tên");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep.setSelectedIndex(-1);
        cboSapXep.setLabeText("Sắp xếp theo");
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiến hành sắp xếp theo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        btnTang.setBackground(new java.awt.Color(153, 153, 255));
        btnTang.setText("Tăng");
        btnTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangActionPerformed(evt);
            }
        });

        btnGiam.setBackground(new java.awt.Color(153, 153, 255));
        btnGiam.setText("Giảm");
        btnGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSapXep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        LoaiSanPham.setBackground(new java.awt.Color(255, 255, 255));
        LoaiSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại sản phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        cboCPU.setLabeText("CPU");
        cboCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCPUActionPerformed(evt);
            }
        });

        cboRam.setLabeText("Ram");

        cboBoNho.setLabeText("Bộ nhớ trong");

        cboCamera.setLabeText("Camera");

        cboMangHinh.setLabeText("Màn hình");

        cboPin.setLabeText("Pin");

        javax.swing.GroupLayout LoaiSanPhamLayout = new javax.swing.GroupLayout(LoaiSanPham);
        LoaiSanPham.setLayout(LoaiSanPhamLayout);
        LoaiSanPhamLayout.setHorizontalGroup(
            LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoaiSanPhamLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCamera, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(cboRam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(cboMangHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LoaiSanPhamLayout.setVerticalGroup(
            LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoaiSanPhamLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(LoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMangHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnTimKiem.setBackground(new java.awt.Color(153, 153, 255));
        btnTimKiem.setText("Tìm kiếm theo Mã");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(153, 153, 255));
        btnNext.setText(">|");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setBackground(new java.awt.Color(153, 153, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(153, 153, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(153, 153, 255));
        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtHinh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhMouseClicked(evt);
            }
        });
        txtHinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnhMouseClicked(evt);
            }
        });
        txtHinh.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 140));

        txtMaSP.setEditable(false);
        txtMaSP.setLabelText("Mã sản phẩm");
        txtMaSP.setLineColor(new java.awt.Color(102, 102, 255));
        txtMaSP.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        switchButton1.setSelectedAnimate(false);
        switchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switchButton1MouseClicked(evt);
            }
        });

        jLabel3.setText("Quét bằng mã");

        button15.setBackground(new java.awt.Color(153, 153, 255));
        button15.setText("In thành file excel");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 231, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53)
                                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(412, 412, 412))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(txtNoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(LoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(9, 9, 9)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(334, 334, 334))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addComponent(txtNoiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(cboLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(170, 170, 170)))
        );

        add(jPanel3, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgayNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayNhapActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNgayNhapActionPerformed

    private void txtNgayNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayNhapMouseClicked
        dateChooser.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayNhapMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them();

// TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Sua();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        String name = (String) cboLoaiSanPham.getSelectedItem();
        LoaiSanPham.setBorder(new TitledBorder(name));
        LoadComboboxCPU();
        LoadComboboxRam();
        LoadComboboxBoNho();
        LoadComboboxCamera();
        LoadComboboxPin();
        LoadComboboxMangHinh();
    }//GEN-LAST:event_cboLoaiSanPhamActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void btnTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangActionPerformed
        if (cboSapXep.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboSapXep.getSelectedItem().equals("Mã")) {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderByMaTang();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");

                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        } else if (cboSapXep.getSelectedItem().equals("Giá")) {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderByGiaTang();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");

                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        } else {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderBySoLuongTang();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");
                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnTangActionPerformed

    private void btnGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamActionPerformed
        // TODO add your handling code here:
        if (cboSapXep.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboSapXep.getSelectedItem().equals("Mã")) {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderByMaGiam();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");

                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }

        } else if (cboSapXep.getSelectedItem().equals("Giá")) {

            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderByGiaGiam();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");

                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        } else {

            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<SanPhamModel> list = Dao.orderBySoLuongGiam();
                for (SanPhamModel nv : list) {
                    DecimalFormat df = new DecimalFormat("#,##0.##");

                    Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), df.format(nv.getGia()) + " VND", nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_btnGiamActionPerformed
    String strHinh = null;
    private void txtHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhMouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
                }

                strHinh = file.getName();
                txtHinhAnh.setText("");

                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh.setToolTipText(file.getName());
                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhMouseClicked

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void formCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formCaretPositionChanged

    private void switchButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_switchButton1MouseClicked
        QuetMa n = null;
        if (switchButton1.isSelected()) {
            // close the webcam if it is not null
            if (QuetMa.webcam != null) {
                QuetMa.webcam.close();
            }
            // close the form if it is not null
            if (n != null) {
                n.dispose();
                n.setVisible(false);
            }
        } else {
            // create and display a new form

            QuetMa n1 = new QuetMa(txtTenSP, txtGia, cboLoaiSanPham, txtNoiNhap);
//            n1.setVisible(true);
//            txtTenSP.setText(QuetMa.getSoLuong());
            switchButton1.setSelectedAnimate(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_switchButton1MouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clear();
        TuDongTangMa();      // TODO add your handling code here:

    }//GEN-LAST:event_btnMoiActionPerformed
//   public void tuDongTangMa() {
//        String name = "";
//        int i = 0;
//        O_NguoiHoc nh = listNH.get(listNH.size() - 1);
//
//        name = nh.getMaNH().trim();
//        String[] tbl = name.split("P");
//        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
//        String ten = "SP";
//        for (int j = 0; j <= 4 - so.length(); j++) {
//            ten += "0";
//        }
//        ten = ten + so;
//        txtMaNguoiHoc.setText(ten);
//
//    }
    private void txtHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnhMouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
                }

                strHinh = file.getName();
                txtHinhAnh.setText("");

                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh.setToolTipText(file.getName());
                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnhMouseClicked

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        btnInDanhSach();        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblUser.rowAtPoint(evt.getPoint());
            if (this.row >= 0) {
                this.edit();
                this.editDT();
            }
        }

    }//GEN-LAST:event_tblUserMouseClicked
    void edit() {
        try {
            String macd = (String) tblUser.getValueAt(this.row, 0);
            SanPhamModel model = Dao.findById(macd);
            DienThoaiModel modelDT = DaoDT.findById(macd);
            if (model != null) {
                this.setFormSP(model);
                this.setFormDT(modelDT);
                this.updateStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void editDT() {
        try {
            String macd = (String) tblUser.getValueAt(this.row, 0);
            DienThoaiModel modelDT = DaoDT.findById(macd);
            if (modelDT != null) {
                this.setFormDT(modelDT);

                this.updateStatus(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(this, "Nhập Mã cần tìm kiếm");
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<SanPhamModel> list = Dao.TimKiemTheoMa(name);
            if (list.size() == 0) {
                DialogHelper.alert(this, "Không tìm thấy");
            }
            for (SanPhamModel nv : list) {
                Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), String.format("%.0f", nv.getGia()), nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMousePressed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cboCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCPUActionPerformed

    private void txtTenSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTenSPCaretUpdate

    }//GEN-LAST:event_txtTenSPCaretUpdate

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        next();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        last();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<SanPhamModel> list = Dao.TimKiemTheoTen(txtTimKiem.getText());
            for (SanPhamModel nv : list) {
                Object[] row = new Object[]{nv.getMaSP(), nv.getTenSP(), String.format("%.0f", nv.getGia()), nv.getSoLuong(), nv.getMaGiamGia(), nv.isTrangThai() ? "Hoạt động" : "Không hoạt động", nv.getNgayNhap(), nv.getNoiNhap(), nv.getHinh()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemCaretUpdate
    GiamGiaDao daoGiamGia = new GiamGiaDao();
    private void cboKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhuyenMaiActionPerformed
        if (cboKhuyenMai.getSelectedItem() != null) {
            String cbo = (String) cboKhuyenMai.getSelectedItem();
            cbo = cbo.substring(0, 5);
            String name = cbo;
            LocalDateTime current = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formatted = current.format(formatter);
            if (name != null) {
                GiamGiaModel list = daoGiamGia.findById(name.trim());
                if (list.getNgayKT().compareTo(formatted) < 0) {
                    DialogHelper.alert(this, "Khuyến mại này đã hết hạn");
                    Kiem = true;
                    return;
                }
                if (list.getNgayBD().compareTo(formatted) > 0) {
                    DialogHelper.alert(this, "Khuyến mại này chưa bắt đầu");
                    Kiem = true;
                    return;
                }
                if (txtGia.getText().equals("")) {
//                DialogHelper.alert(this, "Bạn chưa nhập giá");
                    return;
                }
                String Gia0 = txtGia.getText();
                Gia0 = Gia0.replace(",", "");
                double gia = Double.parseDouble(Gia0);
                DecimalFormat df = new DecimalFormat("#,##0.##");
                if (GiaDau.equals("")) {
                    gia = Double.parseDouble(Gia0) - Double.parseDouble(Gia0) * list.getPhanTram() / 100;
                } else {
                    gia = Double.parseDouble(GiaDau) - Double.parseDouble(GiaDau) * list.getPhanTram() / 100;
                }

//            DecimalFormat df = new DecimalFormat("#,##0.##");
                txtGia.setText(df.format(gia));
                Kiem = false;
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_cboKhuyenMaiActionPerformed

    private void txtGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaFocusLost
        String Gia = txtGia.getText();
        Gia = Gia.replace(",", "");
        if (!Gia.equals("")) {
            try {
                Double.parseDouble(Gia);
            } catch (Exception e) {
                DialogHelper.alert(panel, "Giá không phải là số");
            }
        }
        GiaDau = Gia;         // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaFocusLost

    private void txtGiaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaMouseReleased
    String GiaDau = "";
    Boolean Kiem = false;
    private void txtGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiaCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGiaCaretUpdate

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaMouseClicked

    private void txtGiaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtGiaCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaCaretPositionChanged

    private void txtGiaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtGiaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaInputMethodTextChanged

    private void txtGiaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtGiaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaAncestorAdded

    private void txtGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoaiSanPham;
    private com.DuAn1.Swing.Button btnFirst;
    private com.DuAn1.Swing.Button btnGiam;
    private com.DuAn1.Swing.Button btnLast;
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnNext;
    private com.DuAn1.Swing.Button btnPrev;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnTang;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnTimKiem;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Button button15;
    private com.DuAn1.Swing.Combobox cboBoNho;
    private com.DuAn1.Swing.Combobox cboCPU;
    private com.DuAn1.Swing.Combobox cboCamera;
    private com.DuAn1.Swing.Combobox cboKhuyenMai;
    private com.DuAn1.Swing.Combobox cboLoaiSanPham;
    private com.DuAn1.Swing.Combobox cboMangHinh;
    private com.DuAn1.Swing.Combobox cboMau;
    private com.DuAn1.Swing.Combobox cboPin;
    private com.DuAn1.Swing.Combobox cboRam;
    private com.DuAn1.Swing.Combobox cboSapXep;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.DuAn1.swing0.SwitchButton switchButton1;
    private com.raven.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField txtGia;
    private swing.PanelShadow txtHinh;
    private javax.swing.JLabel txtHinhAnh;
    private com.DuAn1.Swing.TextField txtMaSP;
    private com.DuAn1.Swing.TextField txtMoTa;
    private com.DuAn1.Swing.TextField txtNgayNhap;
    private com.DuAn1.Swing.TextField txtNoiNhap;
    private com.DuAn1.Swing.Spinner txtSoLuong;
    private com.DuAn1.Swing.TextField txtTenSP;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables

}

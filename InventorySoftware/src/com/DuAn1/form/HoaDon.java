/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.HoaDonCTDAO;
import com.DuAn1.Dao.HoaDonDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.HoaDonCTModel;
import com.DuAn1.Model.HoaDonModel;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.SanPhamModel;
import com.DuAn1.Model.ThaoTacModel;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import com.sun.jna.platform.win32.Winspool;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.DuAn1.main.Main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class HoaDon extends javax.swing.JPanel {

    SanPhamDAO daoSP = new SanPhamDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    ThongKeDao daoThongKe = new ThongKeDao();
    HoaDonDAO HDDao = new HoaDonDAO();
    HoaDonCTDAO HDCTDao = new HoaDonCTDAO();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();
    DefaultTableModel tblModel;
    public static String ma = "";
    public static String hoten = "";
    public static String soLuong = "";
    public static String HinhThuc;
    public static String Makh = "";
    public static String Phantram = "";
    public static String MaKH = "";

    public static String getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(String soLuong) {
        HoaDon.soLuong = soLuong;
    }

    public static String getPhantram() {
        return Phantram;
    }

    public static void setPhantram(String Phantram) {
        HoaDon.Phantram = Phantram;
    }

    public static String getMakh() {
        return Makh;
    }

    public static void setMakh(String Makh) {
        HoaDon.Makh = Makh;
    }

    /**
     * Creates new form SanPham1
     */
    public HoaDon() {
        initComponents();
//        imageAvatar1.setImage(new ImageIcon(getClass().getResource("/com/raven/icon/1.png"))); thay đổi hình ảnh
//panelShadow6.setVisible(false); ẩn jpanel
//panelShadow6.setBackground(Color.pink);
        setOpaque(false);
        dateChooser.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooser.hidePopup();
                }
            }
        });
        LbSony1.setVisible(false);
        LbSony2.setVisible(false);
        LbSony3.setVisible(false);
        LbSony4.setVisible(false);
        LbSony5.setVisible(false);
        LbSony6.setVisible(false);
        LbSony7.setVisible(false);
        LbSony8.setVisible(false);
        LbSony9.setVisible(false);
        lbIphone1.setVisible(false);
        lbIphone2.setVisible(false);
        lbIphone3.setVisible(false);
        lbIphone4.setVisible(false);
        lbIphone5.setVisible(false);
        lbIphone6.setVisible(false);
        lbIphone7.setVisible(false);
        lbIphone8.setVisible(false);
        lbIphone9.setVisible(false);
        lbISamSung1.setVisible(false);
        lbISamSung2.setVisible(false);
        lbISamSung3.setVisible(false);
        lbISamSung4.setVisible(false);
        lbISamSung5.setVisible(false);
        lbISamSung6.setVisible(false);
        lbISamSung7.setVisible(false);
        lbISamSung8.setVisible(false);
        lbISamSung9.setVisible(false);
        LoadSP(daoSP.select());
        txtThongBao.setVisible(false);
          txtTienkhach.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!txtTienkhach.getText().equals("")) {
                    double gia = Double.parseDouble(txtTienkhach.getText().replace(".", ""));
                    DecimalFormat df = new DecimalFormat("###,###,###");
                    df.setMaximumFractionDigits(0);
                    txtTienkhach.setText(df.format(gia));
                }
            }
        });
    }

    public void LoadSP(Object nv) {
        List<SanPhamModel> list = (List<SanPhamModel>) nv;
        int i = 0;
        int j = 0;
        int z = 0;
        for (SanPhamModel sp : list) {
            if (sp.getLoaiSP().equalsIgnoreCase("Iphone")) {
                if (i == 0) {
                    txtHinhAnhIphone1.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone1.setText(sp.getTenSP());
                    txtSoLuongConIphone1.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone1.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone1.setText(sp.getMaSP());
                    lbIphone1.setVisible(true);
                }
                if (i == 1) {
                    txtHinhAnhIphone2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone2.setText(sp.getTenSP());
                    txtSoLuongConIphone2.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone2.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone2.setText(sp.getMaSP());
                    lbIphone2.setVisible(true);
                }
                if (i == 2) {
                    txtHinhAnhIphone3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone3.setText(sp.getTenSP());
                    txtSoLuongConIphone3.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone3.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone3.setText(sp.getMaSP());
                    lbIphone3.setVisible(true);
                }
                if (i == 3) {
                    txtHinhAnhIphone4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone4.setText(sp.getTenSP());
                    txtSoLuongConIphone4.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone4.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone4.setText(sp.getMaSP());
                    lbIphone4.setVisible(true);
                }
                if (i == 4) {
                    txtHinhAnhIphone5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone5.setText(sp.getTenSP());
                    txtSoLuongConIphone5.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone5.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone5.setText(sp.getMaSP());
                    lbIphone5.setVisible(true);
                }
                if (i == 5) {
                    txtHinhAnhIphone6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone6.setText(sp.getTenSP());
                    txtSoLuongConIphone6.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone6.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone6.setText(sp.getMaSP());
                    lbIphone6.setVisible(true);
                }
                if (i == 6) {
                    txtHinhAnhIphone7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone7.setText(sp.getTenSP());
                    txtSoLuongConIphone7.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone7.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone7.setText(sp.getMaSP());
                    lbIphone7.setVisible(true);
                }
                if (i == 7) {
                    txtHinhAnhIphone8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone8.setText(sp.getTenSP());
                    txtSoLuongConIphone8.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone8.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone8.setText(sp.getMaSP());
                    lbIphone8.setVisible(true);
                }
                if (i == 8) {
                    txtHinhAnhIphone9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone9.setText(sp.getTenSP());
                    txtSoLuongConIphone9.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaIphone9.setText(String.format("%.0f", sp.getGia()));
                    txtMaIphone9.setText(sp.getMaSP());
                    lbIphone9.setVisible(true);
                }
                i++;
            }
        }

        for (SanPhamModel sp : list) {
            if (sp.getLoaiSP().trim().equalsIgnoreCase("SamSung")) {
                if (j == 0) {
                    txtHinhAnhSamSung1.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung1.setText(sp.getTenSP());
                    txtSoLuongConSamSung1.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung1.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung1.setText(sp.getMaSP());
                    lbISamSung1.setVisible(true);
                }
                if (j == 1) {
                    txtHinhAnhSamSung2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung2.setText(sp.getTenSP());
                    txtSoLuongConSamSung2.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung2.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung2.setText(sp.getMaSP());
                    lbISamSung2.setVisible(true);
                }
                if (j == 2) {
                    txtHinhAnhSamSung3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung3.setText(sp.getTenSP());
                    txtSoLuongConSamSung3.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung3.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung3.setText(sp.getMaSP());
                    lbISamSung3.setVisible(true);
                }
                if (j == 3) {
                    txtHinhAnhSamSung4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung4.setText(sp.getTenSP());
                    txtSoLuongConSamSung4.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung4.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung4.setText(sp.getMaSP());
                    lbISamSung4.setVisible(true);
                }
                if (j == 4) {
                    txtHinhAnhSamSung5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung5.setText(sp.getTenSP());
                    txtSoLuongConSamSung5.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung5.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung5.setText(sp.getMaSP());
                    lbISamSung5.setVisible(true);
                }
                if (j == 5) {
                    txtHinhAnhSamSung6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung6.setText(sp.getTenSP());
                    txtSoLuongConSamSung6.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung6.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung6.setText(sp.getMaSP());
                    lbISamSung6.setVisible(true);
                }
                if (j == 6) {
                    txtHinhAnhSamSung7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung7.setText(sp.getTenSP());
                    txtSoLuongConSamSung7.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung7.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung7.setText(sp.getMaSP());
                    lbISamSung7.setVisible(true);
                }
                if (j == 7) {
                    txtHinhAnhSamSung8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung8.setText(sp.getTenSP());
                    txtSoLuongConSamSung8.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung8.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung8.setText(sp.getMaSP());
                    lbISamSung8.setVisible(true);
                }
                if (j == 8) {
                    txtHinhAnhSamSung9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung9.setText(sp.getTenSP());
                    txtSoLuongConSamSung9.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSamsung9.setText(String.format("%.0f", sp.getGia()));
                    txtMaSamSung9.setText(sp.getMaSP());
                    lbISamSung9.setVisible(true);
                }
                j++;
            }
        }

        for (SanPhamModel sp : list) {
            if (sp.getLoaiSP().trim().equalsIgnoreCase("Sony")) {
                if (z == 0) {
                    txtHinhAnhSony1.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony1.setText(sp.getTenSP());
                    txtSoLuongConSony1.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy1.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony1.setText(sp.getMaSP());
                    LbSony1.setVisible(true);
                }
                if (z == 1) {
                    txtHinhAnhSony2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony2.setText(sp.getTenSP());
                    txtSoLuongConSony2.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy2.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony2.setText(sp.getMaSP());
                    LbSony2.setVisible(true);
                }
                if (z == 2) {
                    txtHinhAnhSony3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony3.setText(sp.getTenSP());
                    txtSoLuongConSony3.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy3.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony3.setText(sp.getMaSP());
                    LbSony3.setVisible(true);
                }
                if (z == 3) {
                    txtHinhAnhSony4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony4.setText(sp.getTenSP());
                    txtSoLuongConSony4.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy4.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony4.setText(sp.getMaSP());
                    LbSony4.setVisible(true);
                }
                if (z == 4) {
                    txtHinhAnhSony5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony5.setText(sp.getTenSP());
                    txtSoLuongConSony5.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy5.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony5.setText(sp.getMaSP());
                    LbSony5.setVisible(true);
                }
                if (z == 5) {
                    txtHinhAnhSony6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony6.setText(sp.getTenSP());
                    txtSoLuongConSony6.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy6.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony6.setText(sp.getMaSP());
                    LbSony6.setVisible(true);
                }
                if (z == 6) {
                    txtHinhAnhSony7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony7.setText(sp.getTenSP());
                    txtSoLuongConSony7.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy7.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony7.setText(sp.getMaSP());
                    LbSony7.setVisible(true);
                }
                if (z == 7) {
                    txtHinhAnhSony8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony8.setText(sp.getTenSP());
                    txtSoLuongConSony8.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy8.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony8.setText(sp.getMaSP());
                    LbSony8.setVisible(true);
                }
                if (z == 8) {
                    txtHinhAnhSony9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony9.setText(sp.getTenSP());
                    txtSoLuongConSony9.setText(String.valueOf(sp.getSoLuong()));
                    txtGiaSoNy9.setText(String.format("%.0f", sp.getGia()));
                    txtMaSony9.setText(sp.getMaSP());
                    LbSony9.setVisible(true);
                }
                z++;
            }

        }
    }

    void Them() {
        try {
            if (Double.parseDouble(txtTienkhach.getText()) < 0) {
                DialogHelper.alert(this, "Tiền khách không được nhỏ hơn 0");
                return;
            }
        } catch (Exception e) {
//            DialogHelper.alert(this, "TIền khách đưa không phải là số vui lòng nhập lại");
//            return;
        }
        if (cboHinhThuc.getSelectedItem() == null) {
            DialogHelper.alert(this, "Chưa chọn hình thức thành toán");
            return;
        }
        if (txtKhachhang.getText().equals("")) {
            DialogHelper.alert(this, "Chưa tên khách hàng");
            return;
        }
        try {
            HoaDonModel model = getFormTao();
            HDDao.update(model);
            com.DuAn1.Helper.DialogHelper.alert(this, "Thêm dữ liệu thành công");
            ThaoTacModel ThaoTacModel = getFormThem();
            daoThaoTac.insert(ThaoTacModel);
            clearForm();
        } catch (Exception e) {
            e.printStackTrace();
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi thêm dữ liệu");
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
        cd.setBanThaoTac("Hóa đơn");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    void clearForm() {
        txtMa.setText("");
        txtTongTien.setText("0");
        txtDonGia.setText("0");
        txtSoLuong.setText("0");
        txtConlai.setText("0");
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
//        String formatted = current.format(formatter);
//        txtNgayXuat.setText(formatted);
        txtTienkhach.setText("0");
        txtMota.setText("");
        txtKhachhang.setText("");
        txtGiamGiaTheoLoai.setText("0");
        txtThongBao.setVisible(false);
    }

    HoaDonModel getFormTao() {
        HoaDonModel dt = new HoaDonModel();
        dt.setMaHD(txtMa.getText());
        dt.setSoluong(String.valueOf(txtSoLuong.getText()));
        dt.setTenKH(txtKhachhang.getText());
        dt.setTrangThai(true);
        String gia = txtDonGia.getText();
        gia = gia.replace(".", "");
        dt.setDongia(Double.parseDouble(gia));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        try {
            String number = String.valueOf(df.parse(txtTongTien.getText()));
            dt.setTongtien(Double.parseDouble(number));
        } catch (ParseException ex) {
            Logger.getLogger(ThanhToanLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").parse(txtNgayXuat.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);

        } catch (Exception e) {
        }
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        dt.setNgayXuat(formatted);
        if (cboHinhThuc.getSelectedItem() != null) {
            if (cboHinhThuc.getSelectedItem().equals("Tiền Mặt")) {
                dt.setHinhThuc("Tiền Mặt");
            } else {
                dt.setHinhThuc("Chuyển Khoản");
            }
        }
        String tienKhach = txtTienkhach.getText();
        tienKhach = tienKhach.replace(".", "");
        dt.setTienKhach(Double.parseDouble(tienKhach));
        String tienConlai = txtConlai.getText();
        tienConlai = tienConlai.replace(".", "");
        dt.setTienCon(Double.parseDouble(tienConlai));
        dt.setMota(txtMota.getText());
//        dt.setNgayXuat(formatted);
        dt.setMaNV(ShareHelper.USER.getMaNV());
        return dt;
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblHoadon.getModel();
        tblModel.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,##0.##");
        try {
            List<HoaDonCTModel> list = HDCTDao.selectAll(txtMa.getText());
            for (HoaDonCTModel nv : list) {
                Object[] row = new Object[]{nv.getMaSP(), nv.getSoLuong(), nv.getMaHD(), df.format(nv.getGia()) + " VND", df.format(nv.getThanhTien()) + " VND"};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    boolean check() {
        if (txtMa.getText().equals("")) {
            com.tuandhpc05076.helper.DialogHelper.alert(this, "Mã bạn đã để trống");
            return false;
        }
        return true;
    }

    public void Delete() {
        if (check() == false) {
            return;
        }
        try {
            HoaDonModel model = getFormTao();
            HDDao.delete(model);
            ThaoTacModel ThaoTacModel = getFormDelete();
            daoThaoTac.insert(ThaoTacModel);
            clearForm();
            com.DuAn1.Helper.DialogHelper.alert(this, "Xóa dữ liệu thành công");
        } catch (Exception e) {
            e.printStackTrace();
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi Xóa dữ liệu");
        }
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
        cd.setBanThaoTac("Hủy Hóa Đơn");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    void TuDongTangMa() {
        List<Object[]> i = daoThongKe.getMaxHDDH();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("D");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "HD";
        for (int j = 0; j <= 4 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtMa.setText(ten);
    }

    public void them() {
        try {
            HoaDonModel model = getFormTao();
            HDDao.insert(model);
        } catch (Exception e) {
            e.printStackTrace();
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        imageAvatar68 = new swing.ImageAvatar();
        jPanel1 = new javax.swing.JPanel();
        txtTongtien = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtMa = new com.DuAn1.Swing.TextField();
        btnMoiHD = new com.DuAn1.swing0.button0();
        btnHuyHD = new com.DuAn1.swing0.button0();
        button3 = new com.DuAn1.swing0.button0();
        btnThanhtoan = new com.DuAn1.swing0.button0();
        txtMota = new com.DuAn1.Swing.TextField();
        button9 = new com.DuAn1.swing0.button0();
        button4 = new com.DuAn1.swing0.button0();
        txtNgayXuat = new com.DuAn1.Swing.TextField();
        txtDonGia = new com.DuAn1.Swing.TextField();
        txtSoLuong = new com.DuAn1.Swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtThongBao = new javax.swing.JLabel();
        btnInBill = new com.DuAn1.swing0.button0();
        txtConlai = new com.DuAn1.Swing.TextField();
        txtTienkhach = new com.DuAn1.Swing.TextField();
        button10 = new com.DuAn1.swing0.button0();
        txtKhachhang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGiamGiaTheoLoai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboHinhThuc = new com.DuAn1.Swing.Combobox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoadon = new javaswingdev.swing.table.Table();
        btnXoasp = new com.DuAn1.swing0.button0();
        btnThem = new com.DuAn1.swing0.button0();
        materialTabbed1 = new swing.MaterialTabbed();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        LbSony1 = new swing.PanelShadow();
        txtHinhAnhSony1 = new swing.ImageAvatar();
        btnAdd1 = new com.DuAn1.swing0.button0();
        txtTenSony1 = new javax.swing.JLabel();
        txtSoLuongConSony1 = new javax.swing.JLabel();
        txtGiaSoNy1 = new javax.swing.JLabel();
        txtMaSony1 = new javax.swing.JLabel();
        txtGiaIphone20 = new javax.swing.JLabel();
        LbSony2 = new swing.PanelShadow();
        txtHinhAnhSony2 = new swing.ImageAvatar();
        txtadd3 = new com.DuAn1.swing0.button0();
        txtTenSony2 = new javax.swing.JLabel();
        txtSoLuongConSony2 = new javax.swing.JLabel();
        txtGiaSoNy2 = new javax.swing.JLabel();
        txtMaSony2 = new javax.swing.JLabel();
        txtGiaIphone21 = new javax.swing.JLabel();
        LbSony3 = new swing.PanelShadow();
        txtHinhAnhSony3 = new swing.ImageAvatar();
        txtadd4 = new com.DuAn1.swing0.button0();
        txtTenSony3 = new javax.swing.JLabel();
        txtSoLuongConSony3 = new javax.swing.JLabel();
        txtGiaSoNy3 = new javax.swing.JLabel();
        txtMaSony3 = new javax.swing.JLabel();
        txtGiaIphone22 = new javax.swing.JLabel();
        LbSony4 = new swing.PanelShadow();
        txtHinhAnhSony4 = new swing.ImageAvatar();
        txtadd1 = new com.DuAn1.swing0.button0();
        txtTenSony4 = new javax.swing.JLabel();
        txtSoLuongConSony4 = new javax.swing.JLabel();
        txtGiaSoNy4 = new javax.swing.JLabel();
        txtMaSony4 = new javax.swing.JLabel();
        txtGiaIphone23 = new javax.swing.JLabel();
        LbSony5 = new swing.PanelShadow();
        txtHinhAnhSony5 = new swing.ImageAvatar();
        txtadd2 = new com.DuAn1.swing0.button0();
        txtTenSony5 = new javax.swing.JLabel();
        txtSoLuongConSony5 = new javax.swing.JLabel();
        txtGiaSoNy5 = new javax.swing.JLabel();
        txtMaSony5 = new javax.swing.JLabel();
        txtGiaIphone24 = new javax.swing.JLabel();
        LbSony6 = new swing.PanelShadow();
        txtHinhAnhSony6 = new swing.ImageAvatar();
        txtadd5 = new com.DuAn1.swing0.button0();
        txtTenSony6 = new javax.swing.JLabel();
        txtSoLuongConSony6 = new javax.swing.JLabel();
        txtGiaSoNy6 = new javax.swing.JLabel();
        txtMaSony6 = new javax.swing.JLabel();
        txtGiaIphone25 = new javax.swing.JLabel();
        LbSony7 = new swing.PanelShadow();
        txtHinhAnhSony7 = new swing.ImageAvatar();
        txtadd6 = new com.DuAn1.swing0.button0();
        txtTenSony7 = new javax.swing.JLabel();
        txtSoLuongConSony7 = new javax.swing.JLabel();
        txtGiaSoNy7 = new javax.swing.JLabel();
        txtMaSony7 = new javax.swing.JLabel();
        txtGiaIphone28 = new javax.swing.JLabel();
        LbSony8 = new swing.PanelShadow();
        txtHinhAnhSony8 = new swing.ImageAvatar();
        txtadd7 = new com.DuAn1.swing0.button0();
        txtTenSony8 = new javax.swing.JLabel();
        txtSoLuongConSony8 = new javax.swing.JLabel();
        txtGiaSoNy8 = new javax.swing.JLabel();
        txtMaSony8 = new javax.swing.JLabel();
        txtGiaIphone27 = new javax.swing.JLabel();
        LbSony9 = new swing.PanelShadow();
        txtHinhAnhSony9 = new swing.ImageAvatar();
        txtadd8 = new com.DuAn1.swing0.button0();
        txtTenSony9 = new javax.swing.JLabel();
        txtSoLuongConSony9 = new javax.swing.JLabel();
        txtGiaSoNy9 = new javax.swing.JLabel();
        txtMaSony9 = new javax.swing.JLabel();
        txtGiaIphone26 = new javax.swing.JLabel();
        cboSapXep3 = new com.DuAn1.Swing.Combobox();
        cboHinhThuc1 = new com.DuAn1.Swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lbIphone3 = new swing.PanelShadow();
        txtHinhAnhIphone3 = new swing.ImageAvatar();
        txtTenIphone3 = new javax.swing.JLabel();
        txtSoLuongConIphone3 = new javax.swing.JLabel();
        txtGiaIphone3 = new javax.swing.JLabel();
        txtMaIphone3 = new javax.swing.JLabel();
        btnAdd4 = new com.DuAn1.swing0.button0();
        txtGiaIphone12 = new javax.swing.JLabel();
        lbIphone2 = new swing.PanelShadow();
        txtHinhAnhIphone2 = new swing.ImageAvatar();
        txtTenIphone2 = new javax.swing.JLabel();
        txtSoLuongConIphone2 = new javax.swing.JLabel();
        txtGiaIphone2 = new javax.swing.JLabel();
        txtMaIphone2 = new javax.swing.JLabel();
        btnAdd3 = new com.DuAn1.swing0.button0();
        txtGiaIphone11 = new javax.swing.JLabel();
        lbIphone4 = new swing.PanelShadow();
        txtHinhAnhIphone4 = new swing.ImageAvatar();
        txtTenIphone4 = new javax.swing.JLabel();
        txtSoLuongConIphone4 = new javax.swing.JLabel();
        txtGiaIphone4 = new javax.swing.JLabel();
        txtMaIphone4 = new javax.swing.JLabel();
        btnAdd5 = new com.DuAn1.swing0.button0();
        txtGiaIphone13 = new javax.swing.JLabel();
        lbIphone6 = new swing.PanelShadow();
        txtHinhAnhIphone6 = new swing.ImageAvatar();
        txtTenIphone6 = new javax.swing.JLabel();
        txtSoLuongConIphone6 = new javax.swing.JLabel();
        txtGiaIphone6 = new javax.swing.JLabel();
        txtMaIphone6 = new javax.swing.JLabel();
        btnAdd7 = new com.DuAn1.swing0.button0();
        txtGiaIphone15 = new javax.swing.JLabel();
        lbIphone5 = new swing.PanelShadow();
        txtHinhAnhIphone5 = new swing.ImageAvatar();
        txtTenIphone5 = new javax.swing.JLabel();
        txtSoLuongConIphone5 = new javax.swing.JLabel();
        txtGiaIphone5 = new javax.swing.JLabel();
        txtMaIphone5 = new javax.swing.JLabel();
        btnAdd6 = new com.DuAn1.swing0.button0();
        txtGiaIphone14 = new javax.swing.JLabel();
        lbIphone8 = new swing.PanelShadow();
        txtHinhAnhIphone8 = new swing.ImageAvatar();
        txtTenIphone8 = new javax.swing.JLabel();
        txtSoLuongConIphone8 = new javax.swing.JLabel();
        txtGiaIphone8 = new javax.swing.JLabel();
        txtMaIphone8 = new javax.swing.JLabel();
        btnAdd9 = new com.DuAn1.swing0.button0();
        txtGiaIphone18 = new javax.swing.JLabel();
        lbIphone7 = new swing.PanelShadow();
        txtHinhAnhIphone7 = new swing.ImageAvatar();
        txtTenIphone7 = new javax.swing.JLabel();
        txtSoLuongConIphone7 = new javax.swing.JLabel();
        txtGiaIphone7 = new javax.swing.JLabel();
        txtMaIphone7 = new javax.swing.JLabel();
        btnAdd8 = new com.DuAn1.swing0.button0();
        txtGiaIphone16 = new javax.swing.JLabel();
        txtGiaIphone17 = new javax.swing.JLabel();
        lbIphone9 = new swing.PanelShadow();
        txtHinhAnhIphone9 = new swing.ImageAvatar();
        txtTenIphone9 = new javax.swing.JLabel();
        txtSoLuongConIphone9 = new javax.swing.JLabel();
        txtGiaIphone9 = new javax.swing.JLabel();
        txtMaIphone9 = new javax.swing.JLabel();
        btnAdd10 = new com.DuAn1.swing0.button0();
        txtGiaIphone19 = new javax.swing.JLabel();
        lbIphone1 = new swing.PanelShadow();
        txtHinhAnhIphone1 = new swing.ImageAvatar();
        txtTenIphone1 = new javax.swing.JLabel();
        txtSoLuongConIphone1 = new javax.swing.JLabel();
        txtGiaIphone1 = new javax.swing.JLabel();
        txtMaIphone1 = new javax.swing.JLabel();
        btnAdd20 = new com.DuAn1.swing0.button0();
        txtGiaIphone39 = new javax.swing.JLabel();
        cboSapXep5 = new com.DuAn1.Swing.Combobox();
        cboHinhThuc4 = new com.DuAn1.Swing.Combobox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        lbISamSung1 = new swing.PanelShadow();
        txtHinhAnhSamSung1 = new swing.ImageAvatar();
        txtTenSamSung1 = new javax.swing.JLabel();
        txtMaSamSung1 = new javax.swing.JLabel();
        txtGiaSamsung1 = new javax.swing.JLabel();
        txtSoLuongConSamSung1 = new javax.swing.JLabel();
        btnAdd11 = new com.DuAn1.swing0.button0();
        txtGiaIphone29 = new javax.swing.JLabel();
        lbISamSung2 = new swing.PanelShadow();
        txtHinhAnhSamSung2 = new swing.ImageAvatar();
        txtTenSamSung2 = new javax.swing.JLabel();
        txtMaSamSung2 = new javax.swing.JLabel();
        txtGiaSamsung2 = new javax.swing.JLabel();
        txtSoLuongConSamSung2 = new javax.swing.JLabel();
        btnAdd12 = new com.DuAn1.swing0.button0();
        txtGiaIphone30 = new javax.swing.JLabel();
        lbISamSung4 = new swing.PanelShadow();
        txtHinhAnhSamSung4 = new swing.ImageAvatar();
        txtTenSamSung4 = new javax.swing.JLabel();
        txtMaSamSung4 = new javax.swing.JLabel();
        txtGiaSamsung4 = new javax.swing.JLabel();
        txtSoLuongConSamSung4 = new javax.swing.JLabel();
        btnAdd14 = new com.DuAn1.swing0.button0();
        txtGiaIphone32 = new javax.swing.JLabel();
        lbISamSung3 = new swing.PanelShadow();
        txtHinhAnhSamSung3 = new swing.ImageAvatar();
        txtTenSamSung3 = new javax.swing.JLabel();
        txtMaSamSung3 = new javax.swing.JLabel();
        txtGiaSamsung3 = new javax.swing.JLabel();
        txtSoLuongConSamSung3 = new javax.swing.JLabel();
        btnAdd13 = new com.DuAn1.swing0.button0();
        txtGiaIphone31 = new javax.swing.JLabel();
        lbISamSung6 = new swing.PanelShadow();
        txtHinhAnhSamSung6 = new swing.ImageAvatar();
        txtTenSamSung6 = new javax.swing.JLabel();
        txtMaSamSung6 = new javax.swing.JLabel();
        txtGiaSamsung6 = new javax.swing.JLabel();
        txtSoLuongConSamSung6 = new javax.swing.JLabel();
        btnAdd16 = new com.DuAn1.swing0.button0();
        txtGiaIphone34 = new javax.swing.JLabel();
        lbISamSung5 = new swing.PanelShadow();
        txtHinhAnhSamSung5 = new swing.ImageAvatar();
        txtTenSamSung5 = new javax.swing.JLabel();
        txtMaSamSung5 = new javax.swing.JLabel();
        txtGiaSamsung5 = new javax.swing.JLabel();
        txtSoLuongConSamSung5 = new javax.swing.JLabel();
        btnAdd15 = new com.DuAn1.swing0.button0();
        txtGiaIphone33 = new javax.swing.JLabel();
        lbISamSung7 = new swing.PanelShadow();
        txtHinhAnhSamSung7 = new swing.ImageAvatar();
        txtTenSamSung7 = new javax.swing.JLabel();
        txtMaSamSung7 = new javax.swing.JLabel();
        txtGiaSamsung7 = new javax.swing.JLabel();
        txtSoLuongConSamSung7 = new javax.swing.JLabel();
        btnAdd17 = new com.DuAn1.swing0.button0();
        txtGiaIphone37 = new javax.swing.JLabel();
        lbISamSung8 = new swing.PanelShadow();
        txtTenSamSung8 = new javax.swing.JLabel();
        txtHinhAnhSamSung8 = new swing.ImageAvatar();
        txtSoLuongConSamSung8 = new javax.swing.JLabel();
        txtGiaSamsung8 = new javax.swing.JLabel();
        txtMaSamSung8 = new javax.swing.JLabel();
        btnAdd18 = new com.DuAn1.swing0.button0();
        txtGiaIphone36 = new javax.swing.JLabel();
        lbISamSung9 = new swing.PanelShadow();
        txtHinhAnhSamSung9 = new swing.ImageAvatar();
        txtTenSamSung9 = new javax.swing.JLabel();
        txtSoLuongConSamSung9 = new javax.swing.JLabel();
        txtGiaSamsung9 = new javax.swing.JLabel();
        txtMaSamSung9 = new javax.swing.JLabel();
        btnAdd19 = new com.DuAn1.swing0.button0();
        txtGiaIphone35 = new javax.swing.JLabel();
        cboSapXep2 = new com.DuAn1.Swing.Combobox();
        cboHinhThuc2 = new com.DuAn1.Swing.Combobox();

        dateChooser.setDoubleBuffered(false);
        dateChooser.setTextRefernce(txtNgayXuat);

        imageAvatar68.setBorderSize(5);
        imageAvatar68.setBorderSpace(0);
        imageAvatar68.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar68.setGradientColor2(new java.awt.Color(255, 255, 255));
        imageAvatar68.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        setPreferredSize(new java.awt.Dimension(1058, 1643));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 1643));

        txtTongtien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setText("Hóa đơn");

        txtMa.setLabelText("Mã hóa đơn");
        txtMa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaCaretUpdate(evt);
            }
        });

        btnMoiHD.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiHD.setText("làm mới");
        btnMoiHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiHDActionPerformed(evt);
            }
        });

        btnHuyHD.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyHD.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHD.setText("Hủy bỏ");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        button3.setBackground(new java.awt.Color(153, 153, 255));
        button3.setText("Xem danh sách hóa đơn");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        btnThanhtoan.setBackground(new java.awt.Color(153, 153, 255));
        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        txtMota.setLabelText("Mô tả");
        txtMota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMotaMouseClicked(evt);
            }
        });

        button9.setBackground(new java.awt.Color(153, 153, 255));
        button9.setText("+");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(153, 153, 255));
        button4.setText("Tạo hóa đơn");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        txtNgayXuat.setLabelText("Ngày gian xuất");
        txtNgayXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayXuatMouseClicked(evt);
            }
        });

        txtDonGia.setEditable(false);
        txtDonGia.setText("0");
        txtDonGia.setLabelText("Tổng đơn giá");
        txtDonGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDonGiaCaretUpdate(evt);
            }
        });

        txtSoLuong.setEditable(false);
        txtSoLuong.setText("0");
        txtSoLuong.setLabelText("Tổng số lượng");
        txtSoLuong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoLuongCaretUpdate(evt);
            }
        });

        jLabel1.setText("Tổng tiền:");

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 51, 51));
        txtTongTien.setText("0");

        jLabel4.setText("Đồng");

        txtThongBao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtThongBao.setForeground(new java.awt.Color(255, 0, 0));

        btnInBill.setBackground(new java.awt.Color(153, 153, 255));
        btnInBill.setText("In hóa đơn");
        btnInBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBillActionPerformed(evt);
            }
        });

        txtConlai.setEditable(false);
        txtConlai.setText("0");
        txtConlai.setLabelText("Tiền còn lại");
        txtConlai.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtConlaiCaretUpdate(evt);
            }
        });

        txtTienkhach.setText("0");
        txtTienkhach.setLabelText("Tiền khách đưa");
        txtTienkhach.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienkhachCaretUpdate(evt);
            }
        });
        txtTienkhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienkhachActionPerformed(evt);
            }
        });

        button10.setBackground(new java.awt.Color(0, 51, 255));
        button10.setForeground(new java.awt.Color(255, 255, 255));
        button10.setText("Khách hàng đã có");
        button10.setToolTipText("");
        button10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        txtKhachhang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtKhachhang.setForeground(new java.awt.Color(153, 0, 153));
        txtKhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setText("%");

        txtGiamGiaTheoLoai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtGiamGiaTheoLoai.setForeground(new java.awt.Color(255, 51, 51));
        txtGiamGiaTheoLoai.setText("0");

        jLabel2.setText("Giảm giá LKH:");

        cboHinhThuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cboHinhThuc.setSelectedIndex(-1);
        cboHinhThuc.setLabeText("Hình thức");
        cboHinhThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtTongtienLayout = new javax.swing.GroupLayout(txtTongtien);
        txtTongtien.setLayout(txtTongtienLayout);
        txtTongtienLayout.setHorizontalGroup(
            txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTongtienLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addComponent(txtNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createSequentialGroup()
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createSequentialGroup()
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(btnMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4))
                            .addComponent(btnThanhtoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(txtTongtienLayout.createSequentialGroup()
                                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createSequentialGroup()
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienkhach, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtConlai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGiamGiaTheoLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboHinhThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        txtTongtienLayout.setVerticalGroup(
            txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTongtienLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(txtThongBao)
                .addGap(29, 29, 29)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConlai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtGiamGiaTheoLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(578, 578, 578))
        );

        tblHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Số lượng", "Mã hóa đơn", "Giá", "Thành tiền"
            }
        ));
        jScrollPane4.setViewportView(tblHoadon);

        btnXoasp.setBackground(new java.awt.Color(255, 51, 51));
        btnXoasp.setText("Xóa sản phẩm");
        btnXoasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaspActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm vào giỏ hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        LbSony1.setBackground(new java.awt.Color(246, 88, 88));
        LbSony1.setShadowOpacity(0.3F);

        txtHinhAnhSony1.setBorderSize(5);
        txtHinhAnhSony1.setBorderSpace(0);
        txtHinhAnhSony1.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony1.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        btnAdd1.setText("Thêm ");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        txtTenSony1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony1.setText("Mr. Dara");

        txtSoLuongConSony1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony1.setText("10");

        txtGiaSoNy1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy1.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy1.setText("Đã bán:");

        txtMaSony1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony1.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony1.setText("0");

        txtGiaIphone20.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone20.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone20.setText("Đ");

        javax.swing.GroupLayout LbSony1Layout = new javax.swing.GroupLayout(LbSony1);
        LbSony1.setLayout(LbSony1Layout);
        LbSony1Layout.setHorizontalGroup(
            LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony1)
                    .addComponent(txtHinhAnhSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony1Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGiaIphone20)))
                .addGap(12, 12, 12))
            .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        LbSony1Layout.setVerticalGroup(
            LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(txtMaSony1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony1)
                    .addComponent(txtGiaSoNy1)
                    .addComponent(txtGiaIphone20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony1Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        LbSony2.setBackground(new java.awt.Color(246, 88, 88));
        LbSony2.setShadowOpacity(0.3F);

        txtHinhAnhSony2.setBorderSize(5);
        txtHinhAnhSony2.setBorderSpace(0);
        txtHinhAnhSony2.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony2.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd3.setText("Thêm ");
        txtadd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd3ActionPerformed(evt);
            }
        });

        txtTenSony2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony2.setText("Mr. Dara");

        txtSoLuongConSony2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony2.setText("10");

        txtGiaSoNy2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy2.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy2.setText("Đã bán:");

        txtMaSony2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony2.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony2.setText("0");

        txtGiaIphone21.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone21.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone21.setText("Đ");

        javax.swing.GroupLayout LbSony2Layout = new javax.swing.GroupLayout(LbSony2);
        LbSony2.setLayout(LbSony2Layout);
        LbSony2Layout.setHorizontalGroup(
            LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony2Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony2)
                    .addComponent(txtHinhAnhSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtadd3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony2Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone21)))
                .addGap(12, 12, 12))
            .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        LbSony2Layout.setVerticalGroup(
            LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtMaSony2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony2)
                    .addComponent(txtGiaSoNy2)
                    .addComponent(txtGiaIphone21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony2Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        LbSony3.setBackground(new java.awt.Color(246, 88, 88));
        LbSony3.setShadowOpacity(0.3F);

        txtHinhAnhSony3.setBorderSize(5);
        txtHinhAnhSony3.setBorderSpace(0);
        txtHinhAnhSony3.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony3.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd4.setText("Thêm ");
        txtadd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd4ActionPerformed(evt);
            }
        });

        txtTenSony3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony3.setText("Mr. Dara");

        txtSoLuongConSony3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony3.setText("10");

        txtGiaSoNy3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy3.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy3.setText("Đã bán:");

        txtMaSony3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony3.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony3.setText("0");

        txtGiaIphone22.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone22.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone22.setText("Đ");

        javax.swing.GroupLayout LbSony3Layout = new javax.swing.GroupLayout(LbSony3);
        LbSony3.setLayout(LbSony3Layout);
        LbSony3Layout.setHorizontalGroup(
            LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony3Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony3Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone22)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LbSony3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtMaSony3)))
                .addGap(19, 19, 19))
            .addGroup(LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony3Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        LbSony3Layout.setVerticalGroup(
            LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtMaSony3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony3)
                    .addComponent(txtGiaSoNy3)
                    .addComponent(txtGiaIphone22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony3Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        LbSony4.setBackground(new java.awt.Color(246, 88, 88));
        LbSony4.setShadowOpacity(0.3F);

        txtHinhAnhSony4.setBorderSize(5);
        txtHinhAnhSony4.setBorderSpace(0);
        txtHinhAnhSony4.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony4.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony4.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd1.setText("Thêm ");
        txtadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd1ActionPerformed(evt);
            }
        });

        txtTenSony4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony4.setText("Mr. Dara");

        txtSoLuongConSony4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony4.setText("10");

        txtGiaSoNy4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy4.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy4.setText("Đã bán:");

        txtMaSony4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony4.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony4.setText("0");

        txtGiaIphone23.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone23.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone23.setText("Đ");

        javax.swing.GroupLayout LbSony4Layout = new javax.swing.GroupLayout(LbSony4);
        LbSony4.setLayout(LbSony4Layout);
        LbSony4Layout.setHorizontalGroup(
            LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LbSony4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtadd1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony4Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone23)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony4Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony4)
                    .addComponent(txtHinhAnhSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony4Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony4Layout.setVerticalGroup(
            LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaSony4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaSoNy4)
                    .addComponent(txtSoLuongConSony4)
                    .addComponent(txtGiaIphone23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony4Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        LbSony5.setBackground(new java.awt.Color(246, 88, 88));
        LbSony5.setShadowOpacity(0.3F);

        txtHinhAnhSony5.setBorderSize(5);
        txtHinhAnhSony5.setBorderSpace(0);
        txtHinhAnhSony5.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony5.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd2.setText("Thêm ");
        txtadd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd2ActionPerformed(evt);
            }
        });

        txtTenSony5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony5.setText("Mr. Dara");

        txtSoLuongConSony5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony5.setText("10");

        txtGiaSoNy5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy5.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy5.setText("Đã bán:");

        txtMaSony5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony5.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony5.setText("0");

        txtGiaIphone24.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone24.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone24.setText("Đ");

        javax.swing.GroupLayout LbSony5Layout = new javax.swing.GroupLayout(LbSony5);
        LbSony5.setLayout(LbSony5Layout);
        LbSony5Layout.setHorizontalGroup(
            LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony5Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone24)
                        .addGap(7, 7, 7)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony5)
                    .addComponent(txtHinhAnhSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony5Layout.setVerticalGroup(
            LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaSony5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony5)
                    .addComponent(txtGiaSoNy5)
                    .addComponent(txtGiaIphone24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony5Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        LbSony6.setBackground(new java.awt.Color(246, 88, 88));
        LbSony6.setShadowOpacity(0.3F);

        txtHinhAnhSony6.setBorderSize(5);
        txtHinhAnhSony6.setBorderSpace(0);
        txtHinhAnhSony6.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony6.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd5.setText("Thêm ");
        txtadd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd5ActionPerformed(evt);
            }
        });

        txtTenSony6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony6.setText("Mr. Dara");

        txtSoLuongConSony6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony6.setText("10");

        txtGiaSoNy6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy6.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy6.setText("Đã bán:");

        txtMaSony6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony6.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony6.setText("0");

        txtGiaIphone25.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone25.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone25.setText("Đ");

        javax.swing.GroupLayout LbSony6Layout = new javax.swing.GroupLayout(LbSony6);
        LbSony6.setLayout(LbSony6Layout);
        LbSony6Layout.setHorizontalGroup(
            LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtMaSony6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony6Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHinhAnhSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtadd5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone25)))
                .addGap(15, 15, 15))
            .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony6Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
        );
        LbSony6Layout.setVerticalGroup(
            LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtMaSony6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony6)
                    .addComponent(txtGiaSoNy6)
                    .addComponent(txtGiaIphone25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony6Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(73, Short.MAX_VALUE)))
        );

        LbSony7.setBackground(new java.awt.Color(246, 88, 88));
        LbSony7.setShadowOpacity(0.3F);

        txtHinhAnhSony7.setBorderSize(5);
        txtHinhAnhSony7.setBorderSpace(0);
        txtHinhAnhSony7.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony7.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony7.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd6.setText("Thêm ");
        txtadd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd6ActionPerformed(evt);
            }
        });

        txtTenSony7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony7.setText("Mr. Dara");

        txtSoLuongConSony7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony7.setText("10");

        txtGiaSoNy7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy7.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy7.setText("Đã bán:");

        txtMaSony7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony7.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony7.setText("0");

        txtGiaIphone28.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone28.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone28.setText("Đ");

        javax.swing.GroupLayout LbSony7Layout = new javax.swing.GroupLayout(LbSony7);
        LbSony7.setLayout(LbSony7Layout);
        LbSony7Layout.setHorizontalGroup(
            LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony7Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone28)
                        .addGap(7, 7, 7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony7Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony7)
                    .addComponent(txtHinhAnhSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony7Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony7Layout.setVerticalGroup(
            LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtMaSony7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony7)
                    .addComponent(txtGiaSoNy7)
                    .addComponent(txtGiaIphone28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony7Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        LbSony8.setBackground(new java.awt.Color(246, 88, 88));
        LbSony8.setShadowOpacity(0.3F);

        txtHinhAnhSony8.setBorderSize(5);
        txtHinhAnhSony8.setBorderSpace(0);
        txtHinhAnhSony8.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony8.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony8.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd7.setText("Thêm ");
        txtadd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd7ActionPerformed(evt);
            }
        });

        txtTenSony8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony8.setText("Mr. Dara");

        txtSoLuongConSony8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony8.setText("10");

        txtGiaSoNy8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy8.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy8.setText("Đã bán:");

        txtMaSony8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony8.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony8.setText("0");

        txtGiaIphone27.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone27.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone27.setText("Đ");

        javax.swing.GroupLayout LbSony8Layout = new javax.swing.GroupLayout(LbSony8);
        LbSony8.setLayout(LbSony8Layout);
        LbSony8Layout.setHorizontalGroup(
            LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony8Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony8)
                    .addComponent(txtHinhAnhSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtadd7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony8Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone27)))
                .addGap(13, 13, 13))
            .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony8Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony8Layout.setVerticalGroup(
            LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSony8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony8)
                    .addComponent(txtGiaSoNy8)
                    .addComponent(txtGiaIphone27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony8Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        LbSony9.setBackground(new java.awt.Color(246, 88, 88));
        LbSony9.setShadowOpacity(0.3F);

        txtHinhAnhSony9.setBorderSize(5);
        txtHinhAnhSony9.setBorderSpace(0);
        txtHinhAnhSony9.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony9.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSony9.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtadd8.setText("Thêm ");
        txtadd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadd8ActionPerformed(evt);
            }
        });

        txtTenSony9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSony9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony9.setText("Mr. Dara");

        txtSoLuongConSony9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSony9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony9.setText("10");

        txtGiaSoNy9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSoNy9.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSoNy9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSoNy9.setText("Đã bán:");

        txtMaSony9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSony9.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSony9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSony9.setText("0");

        txtGiaIphone26.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone26.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone26.setText("Đ");

        javax.swing.GroupLayout LbSony9Layout = new javax.swing.GroupLayout(LbSony9);
        LbSony9.setLayout(LbSony9Layout);
        LbSony9Layout.setHorizontalGroup(
            LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony9Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSoNy9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone26)
                        .addGap(7, 7, 7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony9Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSony9)
                    .addComponent(txtHinhAnhSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony9Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony9Layout.setVerticalGroup(
            LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSony9)
                .addGap(9, 9, 9)
                .addComponent(txtHinhAnhSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony9)
                    .addComponent(txtGiaSoNy9)
                    .addComponent(txtGiaIphone26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony9Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        cboSapXep3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep3.setSelectedIndex(-1);
        cboSapXep3.setLabeText("Sắp xếp theo");
        cboSapXep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXep3ActionPerformed(evt);
            }
        });

        cboHinhThuc1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng", "Giảm" }));
        cboHinhThuc1.setSelectedIndex(-1);
        cboHinhThuc1.setLabeText("Hình thức");
        cboHinhThuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThuc1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboSapXep3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(LbSony4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbSony5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LbSony6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(LbSony7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LbSony8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LbSony9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(LbSony1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LbSony2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LbSony3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LbSony8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LbSony9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(LbSony7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jScrollPane3.setViewportView(jPanel8);

        materialTabbed1.addTab("SONY", jScrollPane3);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbIphone3.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone3.setShadowOpacity(0.3F);

        txtHinhAnhIphone3.setBorderSize(5);
        txtHinhAnhIphone3.setBorderSpace(0);
        txtHinhAnhIphone3.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone3.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone3.setText("Mr. Dara");

        txtSoLuongConIphone3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone3.setText("10");

        txtGiaIphone3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone3.setText("Đã bán:");

        txtMaIphone3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone3.setText("0");

        btnAdd4.setText("Thêm ");
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });

        txtGiaIphone12.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone12.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone12.setText("Đ");

        javax.swing.GroupLayout lbIphone3Layout = new javax.swing.GroupLayout(lbIphone3);
        lbIphone3.setLayout(lbIphone3Layout);
        lbIphone3Layout.setHorizontalGroup(
            lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(lbIphone3Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGiaIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGiaIphone12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lbIphone3Layout.createSequentialGroup()
                            .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lbIphone3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtTenIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMaIphone3))
                            .addGap(8, 8, 8)))
                    .addComponent(txtHinhAnhIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        lbIphone3Layout.setVerticalGroup(
            lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaIphone3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtTenIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone3)
                    .addComponent(txtGiaIphone3)
                    .addComponent(txtGiaIphone12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone2.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone2.setShadowOpacity(0.3F);

        txtHinhAnhIphone2.setBorderSize(5);
        txtHinhAnhIphone2.setBorderSpace(0);
        txtHinhAnhIphone2.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone2.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone2.setText("Mr. Dara");

        txtSoLuongConIphone2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone2.setText("10");

        txtGiaIphone2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone2.setText("Đã bán:");

        txtMaIphone2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone2.setText("0");

        btnAdd3.setText("Thêm ");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });

        txtGiaIphone11.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone11.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone11.setText("Đ");

        javax.swing.GroupLayout lbIphone2Layout = new javax.swing.GroupLayout(lbIphone2);
        lbIphone2.setLayout(lbIphone2Layout);
        lbIphone2Layout.setHorizontalGroup(
            lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaIphone2)
                    .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTenIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHinhAnhIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone2Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone2Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        lbIphone2Layout.setVerticalGroup(
            lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaIphone2)
                .addGap(1, 1, 1)
                .addComponent(txtHinhAnhIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone2)
                    .addComponent(txtGiaIphone2)
                    .addComponent(txtGiaIphone11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone4.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone4.setShadowOpacity(0.3F);

        txtHinhAnhIphone4.setBorderSize(5);
        txtHinhAnhIphone4.setBorderSpace(0);
        txtHinhAnhIphone4.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone4.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone4.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone4.setText("Mr. Dara");

        txtSoLuongConIphone4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone4.setText("10");

        txtGiaIphone4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone4.setText("Đã bán:");

        txtMaIphone4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone4.setText("0");

        btnAdd5.setText("Thêm ");
        btnAdd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd5ActionPerformed(evt);
            }
        });

        txtGiaIphone13.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone13.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone13.setText("Đ");

        javax.swing.GroupLayout lbIphone4Layout = new javax.swing.GroupLayout(lbIphone4);
        lbIphone4.setLayout(lbIphone4Layout);
        lbIphone4Layout.setHorizontalGroup(
            lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone4Layout.createSequentialGroup()
                .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtMaIphone4))
                    .addGroup(lbIphone4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbIphone4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(lbIphone4Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(txtGiaIphone13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHinhAnhIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(lbIphone4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(txtTenIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(7, 7, 7)))))
                .addContainerGap())
        );
        lbIphone4Layout.setVerticalGroup(
            lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaIphone4)
                .addGap(5, 5, 5)
                .addComponent(txtHinhAnhIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone4)
                    .addComponent(txtGiaIphone4)
                    .addComponent(txtGiaIphone13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone6.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone6.setShadowOpacity(0.3F);

        txtHinhAnhIphone6.setBorderSize(5);
        txtHinhAnhIphone6.setBorderSpace(0);
        txtHinhAnhIphone6.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone6.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone6.setText("Mr. Dara");

        txtSoLuongConIphone6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone6.setText("10");

        txtGiaIphone6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone6.setText("Đã bán:");

        txtMaIphone6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone6.setText("0");

        btnAdd7.setText("Thêm ");
        btnAdd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd7ActionPerformed(evt);
            }
        });

        txtGiaIphone15.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone15.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone15.setText("Đ");

        javax.swing.GroupLayout lbIphone6Layout = new javax.swing.GroupLayout(lbIphone6);
        lbIphone6.setLayout(lbIphone6Layout);
        lbIphone6Layout.setHorizontalGroup(
            lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone6Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
            .addGroup(lbIphone6Layout.createSequentialGroup()
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaIphone15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lbIphone6Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(txtTenIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lbIphone6Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHinhAnhIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaIphone6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lbIphone6Layout.setVerticalGroup(
            lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaIphone6)
                .addGap(5, 5, 5)
                .addComponent(txtHinhAnhIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone6)
                    .addComponent(txtGiaIphone6)
                    .addComponent(txtGiaIphone15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone5.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone5.setShadowOpacity(0.3F);

        txtHinhAnhIphone5.setBorderSize(5);
        txtHinhAnhIphone5.setBorderSpace(0);
        txtHinhAnhIphone5.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone5.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone5.setText("Mr. Dara");

        txtSoLuongConIphone5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone5.setText("10");

        txtGiaIphone5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone5.setText("Đã bán:");

        txtMaIphone5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone5.setText("0");

        btnAdd6.setText("Thêm ");
        btnAdd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd6ActionPerformed(evt);
            }
        });

        txtGiaIphone14.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone14.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone14.setText("Đ");

        javax.swing.GroupLayout lbIphone5Layout = new javax.swing.GroupLayout(lbIphone5);
        lbIphone5.setLayout(lbIphone5Layout);
        lbIphone5Layout.setHorizontalGroup(
            lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone5Layout.createSequentialGroup()
                .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbIphone5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbIphone5Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(lbIphone5Layout.createSequentialGroup()
                        .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbIphone5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(txtTenIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbIphone5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtMaIphone5))
                            .addGroup(lbIphone5Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtHinhAnhIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        lbIphone5Layout.setVerticalGroup(
            lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaIphone5)
                .addGap(4, 4, 4)
                .addComponent(txtHinhAnhIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone5)
                    .addComponent(txtGiaIphone5)
                    .addComponent(txtGiaIphone14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone8.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone8.setShadowOpacity(0.3F);

        txtHinhAnhIphone8.setBorderSize(5);
        txtHinhAnhIphone8.setBorderSpace(0);
        txtHinhAnhIphone8.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone8.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone8.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone8.setText("Mr. Dara");

        txtSoLuongConIphone8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone8.setText("10");

        txtGiaIphone8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone8.setText("Đã bán:");

        txtMaIphone8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone8.setText("0");

        btnAdd9.setText("Thêm ");
        btnAdd9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd9ActionPerformed(evt);
            }
        });

        txtGiaIphone18.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone18.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone18.setText("Đ");

        javax.swing.GroupLayout lbIphone8Layout = new javax.swing.GroupLayout(lbIphone8);
        lbIphone8.setLayout(lbIphone8Layout);
        lbIphone8Layout.setHorizontalGroup(
            lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone8Layout.createSequentialGroup()
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaIphone8)
                            .addComponent(txtTenIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtHinhAnhIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        lbIphone8Layout.setVerticalGroup(
            lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtMaIphone8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone8)
                    .addComponent(txtGiaIphone8)
                    .addComponent(txtGiaIphone18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone7.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone7.setShadowOpacity(0.3F);

        txtHinhAnhIphone7.setBorderSize(5);
        txtHinhAnhIphone7.setBorderSpace(0);
        txtHinhAnhIphone7.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone7.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone7.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone7.setText("Mr. Dara");

        txtSoLuongConIphone7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone7.setText("10");

        txtGiaIphone7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone7.setText("Đã bán:");

        txtMaIphone7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone7.setText("0");

        btnAdd8.setText("Thêm ");
        btnAdd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd8ActionPerformed(evt);
            }
        });

        txtGiaIphone16.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone16.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone16.setText("Đ");

        txtGiaIphone17.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone17.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone17.setText("Đ");

        javax.swing.GroupLayout lbIphone7Layout = new javax.swing.GroupLayout(lbIphone7);
        lbIphone7.setLayout(lbIphone7Layout);
        lbIphone7Layout.setHorizontalGroup(
            lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaIphone17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaIphone7)
                        .addComponent(txtTenIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone7Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
            .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lbIphone7Layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(txtGiaIphone16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );
        lbIphone7Layout.setVerticalGroup(
            lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtMaIphone7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone7)
                    .addComponent(txtGiaIphone7)
                    .addComponent(txtGiaIphone17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lbIphone7Layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(txtGiaIphone16)
                    .addContainerGap(91, Short.MAX_VALUE)))
        );

        lbIphone9.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone9.setShadowOpacity(0.3F);

        txtHinhAnhIphone9.setBorderSize(5);
        txtHinhAnhIphone9.setBorderSpace(0);
        txtHinhAnhIphone9.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone9.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone9.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone9.setText("Mr. Dara");

        txtSoLuongConIphone9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone9.setText("10");

        txtGiaIphone9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone9.setText("Đã bán:");

        txtMaIphone9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone9.setText("0");

        btnAdd10.setText("Thêm ");
        btnAdd10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd10ActionPerformed(evt);
            }
        });

        txtGiaIphone19.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone19.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone19.setText("Đ");

        javax.swing.GroupLayout lbIphone9Layout = new javax.swing.GroupLayout(lbIphone9);
        lbIphone9.setLayout(lbIphone9Layout);
        lbIphone9Layout.setHorizontalGroup(
            lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone9Layout.createSequentialGroup()
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaIphone9)
                            .addComponent(txtTenIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtGiaIphone19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone9Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone9Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        lbIphone9Layout.setVerticalGroup(
            lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtMaIphone9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone9)
                    .addComponent(txtGiaIphone9)
                    .addComponent(txtGiaIphone19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone1.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone1.setShadowOpacity(0.3F);

        txtHinhAnhIphone1.setBorderSize(5);
        txtHinhAnhIphone1.setBorderSpace(0);
        txtHinhAnhIphone1.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone1.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone1.setText("Mr. Dara");

        txtSoLuongConIphone1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone1.setText("10");

        txtGiaIphone1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone1.setText("Đã bán:");

        txtMaIphone1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtMaIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaIphone1.setText("0");

        btnAdd20.setText("Thêm ");
        btnAdd20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd20ActionPerformed(evt);
            }
        });

        txtGiaIphone39.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone39.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone39.setText("Đ");

        javax.swing.GroupLayout lbIphone1Layout = new javax.swing.GroupLayout(lbIphone1);
        lbIphone1.setLayout(lbIphone1Layout);
        lbIphone1Layout.setHorizontalGroup(
            lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaIphone1)
                    .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTenIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHinhAnhIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone1Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd20, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone1Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone39, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        lbIphone1Layout.setVerticalGroup(
            lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaIphone1)
                .addGap(1, 1, 1)
                .addComponent(txtHinhAnhIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone1)
                    .addComponent(txtGiaIphone1)
                    .addComponent(txtGiaIphone39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cboSapXep5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep5.setSelectedIndex(-1);
        cboSapXep5.setLabeText("Sắp xếp theo");
        cboSapXep5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXep5ActionPerformed(evt);
            }
        });

        cboHinhThuc4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng", "Giảm" }));
        cboHinhThuc4.setSelectedIndex(-1);
        cboHinhThuc4.setLabeText("Hình thức");
        cboHinhThuc4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThuc4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbIphone7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIphone4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbIphone5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbIphone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbIphone3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lbIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(cboSapXep5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboHinhThuc4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIphone3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIphone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIphone2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(61, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jScrollPane1.setViewportView(jPanel2);

        materialTabbed1.addTab("IPHONE", jScrollPane1);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lbISamSung1.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung1.setShadowOpacity(0.3F);

        txtHinhAnhSamSung1.setBorderSize(5);
        txtHinhAnhSamSung1.setBorderSpace(0);
        txtHinhAnhSamSung1.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung1.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung1.setText("Mr. Dara");

        txtMaSamSung1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung1.setText("0");

        txtGiaSamsung1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung1.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung1.setText("Đã bán:");

        txtSoLuongConSamSung1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung1.setText("10");

        btnAdd11.setText("Thêm ");
        btnAdd11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd11ActionPerformed(evt);
            }
        });

        txtGiaIphone29.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone29.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone29.setText("Đ");

        javax.swing.GroupLayout lbISamSung1Layout = new javax.swing.GroupLayout(lbISamSung1);
        lbISamSung1.setLayout(lbISamSung1Layout);
        lbISamSung1Layout.setHorizontalGroup(
            lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung1Layout.createSequentialGroup()
                .addGroup(lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbISamSung1Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaSamsung1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone29))))
                    .addGroup(lbISamSung1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtMaSamSung1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHinhAnhSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        lbISamSung1Layout.setVerticalGroup(
            lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtMaSamSung1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung1)
                    .addComponent(txtGiaSamsung1)
                    .addComponent(txtGiaIphone29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnAdd11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbISamSung2.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung2.setShadowOpacity(0.3F);

        txtHinhAnhSamSung2.setBorderSize(5);
        txtHinhAnhSamSung2.setBorderSpace(0);
        txtHinhAnhSamSung2.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung2.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung2.setText("Mr. Dara");

        txtMaSamSung2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung2.setText("0");

        txtGiaSamsung2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung2.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung2.setText("Đã bán:");

        txtSoLuongConSamSung2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung2.setText("10");

        btnAdd12.setText("Thêm ");
        btnAdd12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd12ActionPerformed(evt);
            }
        });

        txtGiaIphone30.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone30.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone30.setText("Đ");

        javax.swing.GroupLayout lbISamSung2Layout = new javax.swing.GroupLayout(lbISamSung2);
        lbISamSung2.setLayout(lbISamSung2Layout);
        lbISamSung2Layout.setHorizontalGroup(
            lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtMaSamSung2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(lbISamSung2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung2Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSamsung2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone30))
                    .addGroup(lbISamSung2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHinhAnhSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        lbISamSung2Layout.setVerticalGroup(
            lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSamSung2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung2)
                    .addComponent(txtGiaSamsung2)
                    .addComponent(txtGiaIphone30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbISamSung4.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung4.setShadowOpacity(0.3F);

        txtHinhAnhSamSung4.setBorderSize(5);
        txtHinhAnhSamSung4.setBorderSpace(0);
        txtHinhAnhSamSung4.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung4.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung4.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung4.setText("Mr. Dara");

        txtMaSamSung4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung4.setText("0");

        txtGiaSamsung4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung4.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung4.setText("Đã bán:");

        txtSoLuongConSamSung4.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung4.setText("10");

        btnAdd14.setText("Thêm ");
        btnAdd14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd14ActionPerformed(evt);
            }
        });

        txtGiaIphone32.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone32.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone32.setText("Đ");

        javax.swing.GroupLayout lbISamSung4Layout = new javax.swing.GroupLayout(lbISamSung4);
        lbISamSung4.setLayout(lbISamSung4Layout);
        lbISamSung4Layout.setHorizontalGroup(
            lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbISamSung4Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSamsung4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone32))
                    .addGroup(lbISamSung4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenSamSung4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMaSamSung4)
                                .addComponent(txtHinhAnhSamSung4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        lbISamSung4Layout.setVerticalGroup(
            lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtMaSamSung4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung4)
                    .addComponent(txtGiaSamsung4)
                    .addComponent(txtGiaIphone32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbISamSung3.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung3.setShadowOpacity(0.3F);

        txtHinhAnhSamSung3.setBorderSize(5);
        txtHinhAnhSamSung3.setBorderSpace(0);
        txtHinhAnhSamSung3.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung3.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung3.setText("Mr. Dara");

        txtMaSamSung3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung3.setText("0");

        txtGiaSamsung3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung3.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung3.setText("Đã bán:");

        txtSoLuongConSamSung3.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung3.setText("10");

        btnAdd13.setText("Thêm ");
        btnAdd13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd13ActionPerformed(evt);
            }
        });

        txtGiaIphone31.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone31.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone31.setText("Đ");

        javax.swing.GroupLayout lbISamSung3Layout = new javax.swing.GroupLayout(lbISamSung3);
        lbISamSung3.setLayout(lbISamSung3Layout);
        lbISamSung3Layout.setHorizontalGroup(
            lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtTenSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbISamSung3Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSamsung3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lbISamSung3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSamSung3))
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lbISamSung3Layout.setVerticalGroup(
            lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSamSung3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTenSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung3)
                    .addComponent(txtGiaSamsung3)
                    .addComponent(txtGiaIphone31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbISamSung6.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung6.setShadowOpacity(0.3F);

        txtHinhAnhSamSung6.setBorderSize(5);
        txtHinhAnhSamSung6.setBorderSpace(0);
        txtHinhAnhSamSung6.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung6.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung6.setText("Mr. Dara");

        txtMaSamSung6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung6.setText("0");

        txtGiaSamsung6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung6.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung6.setText("Đã bán:");

        txtSoLuongConSamSung6.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung6.setText("10");

        btnAdd16.setText("Thêm ");
        btnAdd16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd16ActionPerformed(evt);
            }
        });

        txtGiaIphone34.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone34.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone34.setText("Đ");

        javax.swing.GroupLayout lbISamSung6Layout = new javax.swing.GroupLayout(lbISamSung6);
        lbISamSung6.setLayout(lbISamSung6Layout);
        lbISamSung6Layout.setHorizontalGroup(
            lbISamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaSamsung6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaIphone34))
                    .addGroup(lbISamSung6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbISamSung6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lbISamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHinhAnhSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSamSung6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lbISamSung6Layout.setVerticalGroup(
            lbISamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSamSung6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung6)
                    .addComponent(txtGiaSamsung6)
                    .addComponent(txtGiaIphone34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbISamSung5.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung5.setShadowOpacity(0.3F);

        txtHinhAnhSamSung5.setBorderSize(5);
        txtHinhAnhSamSung5.setBorderSpace(0);
        txtHinhAnhSamSung5.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung5.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung5.setText("Mr. Dara");

        txtMaSamSung5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung5.setText("0");

        txtGiaSamsung5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung5.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung5.setText("Đã bán:");

        txtSoLuongConSamSung5.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung5.setText("10");

        btnAdd15.setText("Thêm ");
        btnAdd15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd15ActionPerformed(evt);
            }
        });

        txtGiaIphone33.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone33.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone33.setText("Đ");

        javax.swing.GroupLayout lbISamSung5Layout = new javax.swing.GroupLayout(lbISamSung5);
        lbISamSung5.setLayout(lbISamSung5Layout);
        lbISamSung5Layout.setHorizontalGroup(
            lbISamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung5Layout.createSequentialGroup()
                .addGroup(lbISamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lbISamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung5Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtTenSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbISamSung5Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaSamsung5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone33))
                            .addGroup(lbISamSung5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHinhAnhSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(lbISamSung5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtMaSamSung5)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        lbISamSung5Layout.setVerticalGroup(
            lbISamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtMaSamSung5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung5)
                    .addComponent(txtGiaSamsung5)
                    .addComponent(txtGiaIphone33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbISamSung7.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung7.setShadowOpacity(0.3F);

        txtHinhAnhSamSung7.setBorderSize(5);
        txtHinhAnhSamSung7.setBorderSpace(0);
        txtHinhAnhSamSung7.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung7.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung7.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung7.setText("Mr. Dara");

        txtMaSamSung7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung7.setText("0");

        txtGiaSamsung7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung7.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung7.setText("Đã bán:");

        txtSoLuongConSamSung7.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung7.setText("10");

        btnAdd17.setText("Thêm ");
        btnAdd17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd17ActionPerformed(evt);
            }
        });

        txtGiaIphone37.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone37.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone37.setText("Đ");

        javax.swing.GroupLayout lbISamSung7Layout = new javax.swing.GroupLayout(lbISamSung7);
        lbISamSung7.setLayout(lbISamSung7Layout);
        lbISamSung7Layout.setHorizontalGroup(
            lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTenSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung7Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung7Layout.createSequentialGroup()
                        .addGroup(lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbISamSung7Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaSamsung7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone37)))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaSamSung7)
                        .addComponent(txtHinhAnhSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        lbISamSung7Layout.setVerticalGroup(
            lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSamSung7)
                .addGap(5, 5, 5)
                .addComponent(txtHinhAnhSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung7)
                    .addComponent(txtGiaSamsung7)
                    .addComponent(txtGiaIphone37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbISamSung8.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung8.setShadowOpacity(0.3F);

        txtTenSamSung8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung8.setText("Mr. Dara");

        txtHinhAnhSamSung8.setBorderSize(5);
        txtHinhAnhSamSung8.setBorderSpace(0);
        txtHinhAnhSamSung8.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung8.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung8.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtSoLuongConSamSung8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung8.setText("10");

        txtGiaSamsung8.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung8.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung8.setText("Đã bán:");

        txtMaSamSung8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung8.setText("0");

        btnAdd18.setText("Thêm ");
        btnAdd18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd18ActionPerformed(evt);
            }
        });

        txtGiaIphone36.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone36.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone36.setText("Đ");

        javax.swing.GroupLayout lbISamSung8Layout = new javax.swing.GroupLayout(lbISamSung8);
        lbISamSung8.setLayout(lbISamSung8Layout);
        lbISamSung8Layout.setHorizontalGroup(
            lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTenSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lbISamSung8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lbISamSung8Layout.createSequentialGroup()
                        .addGroup(lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung8Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd18, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbISamSung8Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaSamsung8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone36)))
                        .addGap(1, 1, 1))
                    .addGroup(lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaSamSung8)
                        .addComponent(txtHinhAnhSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        lbISamSung8Layout.setVerticalGroup(
            lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtMaSamSung8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung8)
                    .addComponent(txtGiaSamsung8)
                    .addComponent(txtGiaIphone36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbISamSung9.setBackground(new java.awt.Color(246, 88, 88));
        lbISamSung9.setShadowOpacity(0.3F);

        txtHinhAnhSamSung9.setBorderSize(5);
        txtHinhAnhSamSung9.setBorderSpace(0);
        txtHinhAnhSamSung9.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung9.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung9.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtTenSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung9.setText("Mr. Dara");

        txtSoLuongConSamSung9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtSoLuongConSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung9.setText("10");

        txtGiaSamsung9.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaSamsung9.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaSamsung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaSamsung9.setText("Đã bán:");

        txtMaSamSung9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtMaSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtMaSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMaSamSung9.setText("0");

        btnAdd19.setText("Thêm ");
        btnAdd19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd19ActionPerformed(evt);
            }
        });

        txtGiaIphone35.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
        txtGiaIphone35.setForeground(new java.awt.Color(235, 235, 235));
        txtGiaIphone35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGiaIphone35.setText("Đ");

        javax.swing.GroupLayout lbISamSung9Layout = new javax.swing.GroupLayout(lbISamSung9);
        lbISamSung9.setLayout(lbISamSung9Layout);
        lbISamSung9Layout.setHorizontalGroup(
            lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdd19, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(lbISamSung9Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGiaSamsung9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtGiaIphone35)
                            .addGap(7, 7, 7)))
                    .addGroup(lbISamSung9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHinhAnhSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSamSung9))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        lbISamSung9Layout.setVerticalGroup(
            lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung9Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(txtMaSamSung9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung9)
                    .addComponent(txtGiaSamsung9)
                    .addComponent(txtGiaIphone35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cboSapXep2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep2.setSelectedIndex(-1);
        cboSapXep2.setLabeText("Sắp xếp theo");
        cboSapXep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXep2ActionPerformed(evt);
            }
        });

        cboHinhThuc2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng", "Giảm" }));
        cboHinhThuc2.setSelectedIndex(-1);
        cboHinhThuc2.setLabeText("Hình thức");
        cboHinhThuc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThuc2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbISamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbISamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbISamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cboSapXep2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboHinhThuc2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbISamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbISamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbISamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbISamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbISamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbISamSung6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(49, 62, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbISamSung3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbISamSung1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbISamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbISamSung7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane2.setViewportView(jPanel6);

        materialTabbed1.addTab("SAMSUNG", jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(151, 151, 151)
                            .addComponent(btnXoasp, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoasp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1010, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        DanhSachMH1 danhSach = new DanhSachMH1(com.DuAn1.main.Main.getMain(), true);
        danhSach.setVisible(true);
         DecimalFormat df = new DecimalFormat("#,##0.##");
        txtMa.setText(DanhSachMH.getName1());
        txtSoLuong.setText(String.valueOf(DanhSachMH.getSoLuong()));
        txtDonGia.setText(df.format( DanhSachMH.getDonGia()));
//          DecimalFormat df = new DecimalFormat("#,##0.##");
        txtTongTien.setText(df.format( DanhSachMH.getTongTien()));
        txtNgayXuat.setText(DanhSachMH.getNgay());
        txtKhachhang.setText(DanhSachMH.getTen());
//        if(DanhSachMH1.getHinhThuc().trim().equals("Tiền Mặt")){
//            
//        }

        cboHinhThuc.setSelectedItem(DanhSachMH.getHinhThuc().trim());
        txtTienkhach.setText(df.format( DanhSachMH.getTienkhach()));
        txtConlai.setText(df.format( DanhSachMH.getTienCon()));
        txtThongBao.setVisible(true);
        btnXoasp.setEnabled(true);
        btnThem.setEnabled(true);
        btnThanhtoan.setEnabled(true);
        btnHuyHD.setEnabled(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        Them();

    }//GEN-LAST:event_btnThanhtoanActionPerformed
    void deleteAll() {
        if (txtMa.getText().equals("")) {
            com.tuandhpc05076.helper.DialogHelper.alert(this, "Bạn có đặt hàng nào");
            return;
        }
        try {
            HDCTDao.XoaTatCa(txtMa.getText());

            filltable();

            com.DuAn1.Helper.DialogHelper.alert(this, "Xóa tất cả sản phẩm thành công");
        } catch (Exception e) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }

    }
    private void btnXoaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaspActionPerformed
        deleteAll();
    }//GEN-LAST:event_btnXoaspActionPerformed

    private void txtMotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMotaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotaMouseClicked

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        HoaDon.setSoLuong(txtKhachhang.getText());
        ThemKH kh = new ThemKH(com.DuAn1.main.Main.getMain(), true);
        kh.setVisible(true);
        txtKhachhang.setText(HoaDon.getSoLuong());
        daoKH.select();
        String gia = txtDonGia.getText();
        gia = gia.replace(".", "");
        List<KhachHangModel> listKH = daoKH.TimKiemTheoMa(HoaDon.getSoLuong().trim());
        System.out.println(listKH.size());
        for (KhachHangModel khachHangModel : listKH) {
            if (khachHangModel.getLoaiKH().trim().equalsIgnoreCase("VIP1")) {
                txtGiamGiaTheoLoai.setText("5");
            } else if (khachHangModel.getLoaiKH().trim().equalsIgnoreCase("VIP2")) {
                txtGiamGiaTheoLoai.setText("10");
            } else {
                txtGiamGiaTheoLoai.setText("0");
            }
        }
        DecimalFormat df = new DecimalFormat("#,##0.##");
        txtTongTien.setText(df.format(Double.parseDouble(gia) - Double.parseDouble(gia) * Double.parseDouble(txtGiamGiaTheoLoai.getText()) / 100));
    }//GEN-LAST:event_button9ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        TuDongTangMa();
        them();
    }//GEN-LAST:event_button4ActionPerformed

    private void txtNgayXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayXuatMouseClicked
        dateChooser.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayXuatMouseClicked

    private void txtDonGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDonGiaCaretUpdate
        // TODO add your handling code here
    }//GEN-LAST:event_txtDonGiaCaretUpdate

    private void txtSoLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoLuongCaretUpdate

        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongCaretUpdate

    private void txtMaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaCaretUpdate
        filltable();
    }//GEN-LAST:event_txtMaCaretUpdate

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        double tongGia = 0;
        int tongSoLuong = 0;
        double TongTien = 0;
        DecimalFormat df = new DecimalFormat("#,##0.##");
        try {
            List<HoaDonCTModel> list = HDCTDao.selectAll(txtMa.getText());
            for (HoaDonCTModel nv : list) {
                tongGia += nv.getGia();
                tongSoLuong += nv.getSoLuong();
                TongTien += nv.getThanhTien();
            }
            txtDonGia.setText(df.format(TongTien));
            txtSoLuong.setText(String.valueOf(tongSoLuong));
//            double tongTien = Double.parseDouble(txtDonGia.getText()) * Double.parseDouble(txtSoLuong.getText());
//             tongTien = tongTien - (tongTien * Double.parseDouble(txtGiamGiaTheoLoai.getText()) / 100);
            TongTien=TongTien-TongTien*Double.parseDouble(txtGiamGiaTheoLoai.getText())/100;
            txtTongTien.setText(df.format(TongTien));
            txtTienkhach.setText(txtTienkhach.getText());
            txtConlai.setText(txtTongTien.getText());
            ThaoTacModel ThaoTacModel = getFormUpdate();
            daoThaoTac.insert(ThaoTacModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed
    public ThaoTacModel getFormUpdate() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);

        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm vào Hóa đơn");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }
    private void btnMoiHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiHDActionPerformed
        clearForm();
    }//GEN-LAST:event_btnMoiHDActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony1();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void txtadd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd3ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony2();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd3ActionPerformed

    private void txtadd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd4ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony3();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd4ActionPerformed

    private void txtadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd1ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony4();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd1ActionPerformed

    private void txtadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd2ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony5();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd2ActionPerformed

    private void txtadd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony6();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd5ActionPerformed

    private void txtadd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony7();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd6ActionPerformed

    private void txtadd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony8();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd7ActionPerformed

    private void txtadd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSony9();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd8ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone3();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone2();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone4();

            HDCTDao.insert(model);
            filltable();
            DialogHelper.alert(this, "Thêm sản phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd5ActionPerformed

    private void btnAdd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone6();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd7ActionPerformed

    private void btnAdd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone5();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd6ActionPerformed

    private void btnAdd9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd9ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone8();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd9ActionPerformed

    private void btnAdd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone7();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd8ActionPerformed

    private void btnAdd10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd10ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemIPhone9();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd10ActionPerformed

    private void btnAdd20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd20ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        themSPCT();
    }//GEN-LAST:event_btnAdd20ActionPerformed

    private void btnAdd11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd11ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung1();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd11ActionPerformed

    private void btnAdd12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd12ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung2();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd12ActionPerformed

    private void btnAdd14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd14ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung4();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd14ActionPerformed

    private void btnAdd13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd13ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung3();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd13ActionPerformed

    private void btnAdd16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd16ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung6();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd16ActionPerformed

    private void btnAdd15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd15ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung5();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd15ActionPerformed

    private void btnAdd17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd17ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung7();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd17ActionPerformed

    private void btnAdd18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd18ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung8();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd18ActionPerformed

    private void btnAdd19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd19ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            HoaDonCTModel model = getFormThemSamsung9();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd19ActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        Delete();
    }//GEN-LAST:event_btnHuyHDActionPerformed
    public static String GiamGia = "";

    public static String getGiamGia() {
        return GiamGia;
    }

    public static void setGiamGia(String GiamGia) {
        HoaDon.GiamGia = GiamGia;
    }

    private void btnInBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBillActionPerformed
        HoaDon.setPhantram(txtGiamGiaTheoLoai.getText());
        ma = txtMa.getText();
        HoaDon.setGiamGia(txtGiamGiaTheoLoai.getText());
        hoten = txtKhachhang.getText();

        InHoaDon hd = new InHoaDon(com.DuAn1.main.Main.getMain(), true);
        hd.setVisible(true);


    }//GEN-LAST:event_btnInBillActionPerformed

    private void txtConlaiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtConlaiCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConlaiCaretUpdate

    private void txtTienkhachCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienkhachCaretUpdate
        if (txtTienkhach.getText().equalsIgnoreCase("")) {
            return;
        }
        String gia = txtTongTien.getText();
        String TienKhach = txtTienkhach.getText();
        gia = gia.replace(".", "");
        TienKhach= TienKhach.replace(".", "");
        DecimalFormat df = new DecimalFormat("#,##0.##");
        txtConlai.setText(df.format(Double.parseDouble(TienKhach) - Double.parseDouble(gia)));        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienkhachCaretUpdate

    private void txtTienkhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienkhachActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienkhachActionPerformed

    private void cboSapXep3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXep3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXep3ActionPerformed

    private void cboHinhThuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc1ActionPerformed
        if (cboSapXep3.getSelectedItem() == null) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboHinhThuc1.getSelectedItem().equals("Tăng")) {
            if (cboSapXep3.getSelectedItem().equals("Mã")) {
                try {
                    LoadSP(Dao.orderByMaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep3.getSelectedItem().equals("Giá")) {
                try {
                    LoadSP(Dao.orderByGiaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {
                    LoadSP(Dao.orderBySoLuongTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        } else {
            if (cboSapXep3.getSelectedItem().equals("Mã")) {
                try {
                    LoadSP(Dao.orderByMaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep3.getSelectedItem().equals("Giá")) {
                try {
                    LoadSP(Dao.orderByGiaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {
                    LoadSP(Dao.orderBySoLuongGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThuc1ActionPerformed

    private void cboSapXep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXep2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXep2ActionPerformed

    private void cboHinhThuc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc2ActionPerformed
        // TODO add your handling code here:
        if (cboSapXep2.getSelectedItem() == null) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboHinhThuc2.getSelectedItem().equals("Tăng")) {
            if (cboSapXep2.getSelectedItem().equals("Mã")) {
                try {

                    LoadSP(Dao.orderByMaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep2.getSelectedItem().equals("Giá")) {
                try {

                    LoadSP(Dao.orderByGiaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {

                    LoadSP(Dao.orderBySoLuongTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        } else {
            if (cboSapXep2.getSelectedItem() == null) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
                return;
            }
            if (cboSapXep2.getSelectedItem().equals("Mã")) {
                try {

                    LoadSP(Dao.orderByMaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep2.getSelectedItem().equals("Giá")) {
                try {

                    LoadSP(Dao.orderByGiaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {

                    LoadSP(Dao.orderBySoLuongGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        }        // TO
    }//GEN-LAST:event_cboHinhThuc2ActionPerformed

    private void cboSapXep5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXep5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXep5ActionPerformed
    SanPhamDAO Dao = new SanPhamDAO();
    private void cboHinhThuc4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc4ActionPerformed
        // TODO add your handling code here:
        if (cboSapXep5.getSelectedItem() == null) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboHinhThuc4.getSelectedItem().equals("Tăng")) {
            if (cboSapXep5.getSelectedItem().equals("Mã")) {

                try {

                    LoadSP(Dao.orderByMaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep5.getSelectedItem().equals("Giá")) {
                try {

                    LoadSP(Dao.orderByGiaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {

                    LoadSP(Dao.orderBySoLuongTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        } else {
            if (cboSapXep5.getSelectedItem() == null) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
                return;
            }
            if (cboSapXep5.getSelectedItem().equals("Mã")) {
                try {

                    LoadSP(Dao.orderByMaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep5.getSelectedItem().equals("Giá")) {
                try {

                    LoadSP(Dao.orderByGiaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            } else {
                try {

                    LoadSP(Dao.orderBySoLuongGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }
            }
        }        // TO
    }//GEN-LAST:event_cboHinhThuc4ActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        HoaDon.setMakh(txtKhachhang.getText());
        KHDC kh = new KHDC(com.DuAn1.main.Main.getMain(), true);
        kh.setVisible(true);
        String gia = txtDonGia.getText();
        gia = gia.replace(",", "");
        txtKhachhang.setText(KHDC.getMaKH());
        List<KhachHangModel> listKH = daoKH.TimKiemTheoMa(KHDC.getMaKH());
        for (KhachHangModel khachHangModel : listKH) {
            if (khachHangModel.getLoaiKH().trim().equalsIgnoreCase("VIP1")) {
                txtGiamGiaTheoLoai.setText("5");
            } else if (khachHangModel.getLoaiKH().trim().equalsIgnoreCase("VIP2")) {
                txtGiamGiaTheoLoai.setText("10");
            } else {
                txtGiamGiaTheoLoai.setText("0");
            }
        }
        DecimalFormat df = new DecimalFormat("#,##0.##");
        txtTongTien.setText(df.format(Double.parseDouble(gia) - Double.parseDouble(gia) * Double.parseDouble(txtGiamGiaTheoLoai.getText()) / 100));
    }//GEN-LAST:event_button10ActionPerformed

    private void cboHinhThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThucActionPerformed
    public void themSPCT() {
        try {
            HoaDonCTModel model = getFormThemIPhone1();

            HDCTDao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }

    HoaDonCTModel getFormThemIPhone1() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone1.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone1.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone1.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone2() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone2.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone2.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone2.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone3() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone3.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone3.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone3.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone4() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone4.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone4.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone4.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone5() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone5.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone5.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone5.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone6() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone6.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone6.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone6.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone7() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone7.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone7.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone7.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone8() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone8.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone8.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone8.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemIPhone9() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaIphone9.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaIphone9.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaIphone9.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony1() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy1.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony1.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy1.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony2() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy2.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony2.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy2.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony3() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy3.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony3.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy3.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony4() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy4.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony4.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy4.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony5() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy5.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony5.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy5.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony6() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy6.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony6.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy6.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony7() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy7.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony7.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy7.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony8() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy8.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony8.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy8.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSony9() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSoNy9.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSony9.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSoNy9.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung1() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung1.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung1.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung1.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung2() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung2.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung2.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung2.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung3() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung3.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung3.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung3.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung4() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung4.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung4.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung4.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung5() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung5.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung5.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung5.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung6() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung6.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung6.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung6.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung7() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung7.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung7.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung7.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung8() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung8.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung8.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung8.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    HoaDonCTModel getFormThemSamsung9() {
        HoaDonCTModel cd = new HoaDonCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setGia(Double.parseDouble(txtGiaSamsung9.getText()));
        cd.setMaHD(txtMa.getText());
        cd.setMaSP(txtMaSamSung9.getText());
        cd.setThanhTien(Double.parseDouble(txtGiaSamsung9.getText()) * SoLuong.getSoLuong());
        return cd;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PanelShadow LbSony1;
    private swing.PanelShadow LbSony2;
    private swing.PanelShadow LbSony3;
    private swing.PanelShadow LbSony4;
    private swing.PanelShadow LbSony5;
    private swing.PanelShadow LbSony6;
    private swing.PanelShadow LbSony7;
    private swing.PanelShadow LbSony8;
    private swing.PanelShadow LbSony9;
    private com.DuAn1.swing0.button0 btnAdd1;
    private com.DuAn1.swing0.button0 btnAdd10;
    private com.DuAn1.swing0.button0 btnAdd11;
    private com.DuAn1.swing0.button0 btnAdd12;
    private com.DuAn1.swing0.button0 btnAdd13;
    private com.DuAn1.swing0.button0 btnAdd14;
    private com.DuAn1.swing0.button0 btnAdd15;
    private com.DuAn1.swing0.button0 btnAdd16;
    private com.DuAn1.swing0.button0 btnAdd17;
    private com.DuAn1.swing0.button0 btnAdd18;
    private com.DuAn1.swing0.button0 btnAdd19;
    private com.DuAn1.swing0.button0 btnAdd20;
    private com.DuAn1.swing0.button0 btnAdd3;
    private com.DuAn1.swing0.button0 btnAdd4;
    private com.DuAn1.swing0.button0 btnAdd5;
    private com.DuAn1.swing0.button0 btnAdd6;
    private com.DuAn1.swing0.button0 btnAdd7;
    private com.DuAn1.swing0.button0 btnAdd8;
    private com.DuAn1.swing0.button0 btnAdd9;
    private com.DuAn1.swing0.button0 btnHuyHD;
    private com.DuAn1.swing0.button0 btnInBill;
    private com.DuAn1.swing0.button0 btnMoiHD;
    private com.DuAn1.swing0.button0 btnThanhtoan;
    private com.DuAn1.swing0.button0 btnThem;
    private com.DuAn1.swing0.button0 btnXoasp;
    private com.DuAn1.swing0.button0 button10;
    private com.DuAn1.swing0.button0 button3;
    private com.DuAn1.swing0.button0 button4;
    private com.DuAn1.swing0.button0 button9;
    private com.DuAn1.Swing.Combobox cboHinhThuc;
    private com.DuAn1.Swing.Combobox cboHinhThuc1;
    private com.DuAn1.Swing.Combobox cboHinhThuc2;
    private com.DuAn1.Swing.Combobox cboHinhThuc4;
    private com.DuAn1.Swing.Combobox cboSapXep2;
    private com.DuAn1.Swing.Combobox cboSapXep3;
    private com.DuAn1.Swing.Combobox cboSapXep5;
    private com.raven.datechooser.DateChooser dateChooser;
    private swing.ImageAvatar imageAvatar68;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private swing.PanelShadow lbISamSung1;
    private swing.PanelShadow lbISamSung2;
    private swing.PanelShadow lbISamSung3;
    private swing.PanelShadow lbISamSung4;
    private swing.PanelShadow lbISamSung5;
    private swing.PanelShadow lbISamSung6;
    private swing.PanelShadow lbISamSung7;
    private swing.PanelShadow lbISamSung8;
    private swing.PanelShadow lbISamSung9;
    private swing.PanelShadow lbIphone1;
    private swing.PanelShadow lbIphone2;
    private swing.PanelShadow lbIphone3;
    private swing.PanelShadow lbIphone4;
    private swing.PanelShadow lbIphone5;
    private swing.PanelShadow lbIphone6;
    private swing.PanelShadow lbIphone7;
    private swing.PanelShadow lbIphone8;
    private swing.PanelShadow lbIphone9;
    private swing.MaterialTabbed materialTabbed1;
    private javaswingdev.swing.table.Table tblHoadon;
    private com.DuAn1.Swing.TextField txtConlai;
    private com.DuAn1.Swing.TextField txtDonGia;
    private javax.swing.JLabel txtGiaIphone1;
    private javax.swing.JLabel txtGiaIphone11;
    private javax.swing.JLabel txtGiaIphone12;
    private javax.swing.JLabel txtGiaIphone13;
    private javax.swing.JLabel txtGiaIphone14;
    private javax.swing.JLabel txtGiaIphone15;
    private javax.swing.JLabel txtGiaIphone16;
    private javax.swing.JLabel txtGiaIphone17;
    private javax.swing.JLabel txtGiaIphone18;
    private javax.swing.JLabel txtGiaIphone19;
    private javax.swing.JLabel txtGiaIphone2;
    private javax.swing.JLabel txtGiaIphone20;
    private javax.swing.JLabel txtGiaIphone21;
    private javax.swing.JLabel txtGiaIphone22;
    private javax.swing.JLabel txtGiaIphone23;
    private javax.swing.JLabel txtGiaIphone24;
    private javax.swing.JLabel txtGiaIphone25;
    private javax.swing.JLabel txtGiaIphone26;
    private javax.swing.JLabel txtGiaIphone27;
    private javax.swing.JLabel txtGiaIphone28;
    private javax.swing.JLabel txtGiaIphone29;
    private javax.swing.JLabel txtGiaIphone3;
    private javax.swing.JLabel txtGiaIphone30;
    private javax.swing.JLabel txtGiaIphone31;
    private javax.swing.JLabel txtGiaIphone32;
    private javax.swing.JLabel txtGiaIphone33;
    private javax.swing.JLabel txtGiaIphone34;
    private javax.swing.JLabel txtGiaIphone35;
    private javax.swing.JLabel txtGiaIphone36;
    private javax.swing.JLabel txtGiaIphone37;
    private javax.swing.JLabel txtGiaIphone39;
    private javax.swing.JLabel txtGiaIphone4;
    private javax.swing.JLabel txtGiaIphone5;
    private javax.swing.JLabel txtGiaIphone6;
    private javax.swing.JLabel txtGiaIphone7;
    private javax.swing.JLabel txtGiaIphone8;
    private javax.swing.JLabel txtGiaIphone9;
    private javax.swing.JLabel txtGiaSamsung1;
    private javax.swing.JLabel txtGiaSamsung2;
    private javax.swing.JLabel txtGiaSamsung3;
    private javax.swing.JLabel txtGiaSamsung4;
    private javax.swing.JLabel txtGiaSamsung5;
    private javax.swing.JLabel txtGiaSamsung6;
    private javax.swing.JLabel txtGiaSamsung7;
    private javax.swing.JLabel txtGiaSamsung8;
    private javax.swing.JLabel txtGiaSamsung9;
    private javax.swing.JLabel txtGiaSoNy1;
    private javax.swing.JLabel txtGiaSoNy2;
    private javax.swing.JLabel txtGiaSoNy3;
    private javax.swing.JLabel txtGiaSoNy4;
    private javax.swing.JLabel txtGiaSoNy5;
    private javax.swing.JLabel txtGiaSoNy6;
    private javax.swing.JLabel txtGiaSoNy7;
    private javax.swing.JLabel txtGiaSoNy8;
    private javax.swing.JLabel txtGiaSoNy9;
    private javax.swing.JLabel txtGiamGiaTheoLoai;
    private swing.ImageAvatar txtHinhAnhIphone1;
    private swing.ImageAvatar txtHinhAnhIphone2;
    private swing.ImageAvatar txtHinhAnhIphone3;
    private swing.ImageAvatar txtHinhAnhIphone4;
    private swing.ImageAvatar txtHinhAnhIphone5;
    private swing.ImageAvatar txtHinhAnhIphone6;
    private swing.ImageAvatar txtHinhAnhIphone7;
    private swing.ImageAvatar txtHinhAnhIphone8;
    private swing.ImageAvatar txtHinhAnhIphone9;
    private swing.ImageAvatar txtHinhAnhSamSung1;
    private swing.ImageAvatar txtHinhAnhSamSung2;
    private swing.ImageAvatar txtHinhAnhSamSung3;
    private swing.ImageAvatar txtHinhAnhSamSung4;
    private swing.ImageAvatar txtHinhAnhSamSung5;
    private swing.ImageAvatar txtHinhAnhSamSung6;
    private swing.ImageAvatar txtHinhAnhSamSung7;
    private swing.ImageAvatar txtHinhAnhSamSung8;
    private swing.ImageAvatar txtHinhAnhSamSung9;
    private swing.ImageAvatar txtHinhAnhSony1;
    private swing.ImageAvatar txtHinhAnhSony2;
    private swing.ImageAvatar txtHinhAnhSony3;
    private swing.ImageAvatar txtHinhAnhSony4;
    private swing.ImageAvatar txtHinhAnhSony5;
    private swing.ImageAvatar txtHinhAnhSony6;
    private swing.ImageAvatar txtHinhAnhSony7;
    private swing.ImageAvatar txtHinhAnhSony8;
    private swing.ImageAvatar txtHinhAnhSony9;
    private javax.swing.JLabel txtKhachhang;
    private com.DuAn1.Swing.TextField txtMa;
    private javax.swing.JLabel txtMaIphone1;
    private javax.swing.JLabel txtMaIphone2;
    private javax.swing.JLabel txtMaIphone3;
    private javax.swing.JLabel txtMaIphone4;
    private javax.swing.JLabel txtMaIphone5;
    private javax.swing.JLabel txtMaIphone6;
    private javax.swing.JLabel txtMaIphone7;
    private javax.swing.JLabel txtMaIphone8;
    private javax.swing.JLabel txtMaIphone9;
    private javax.swing.JLabel txtMaSamSung1;
    private javax.swing.JLabel txtMaSamSung2;
    private javax.swing.JLabel txtMaSamSung3;
    private javax.swing.JLabel txtMaSamSung4;
    private javax.swing.JLabel txtMaSamSung5;
    private javax.swing.JLabel txtMaSamSung6;
    private javax.swing.JLabel txtMaSamSung7;
    private javax.swing.JLabel txtMaSamSung8;
    private javax.swing.JLabel txtMaSamSung9;
    private javax.swing.JLabel txtMaSony1;
    private javax.swing.JLabel txtMaSony2;
    private javax.swing.JLabel txtMaSony3;
    private javax.swing.JLabel txtMaSony4;
    private javax.swing.JLabel txtMaSony5;
    private javax.swing.JLabel txtMaSony6;
    private javax.swing.JLabel txtMaSony7;
    private javax.swing.JLabel txtMaSony8;
    private javax.swing.JLabel txtMaSony9;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgayXuat;
    private com.DuAn1.Swing.TextField txtSoLuong;
    private javax.swing.JLabel txtSoLuongConIphone1;
    private javax.swing.JLabel txtSoLuongConIphone2;
    private javax.swing.JLabel txtSoLuongConIphone3;
    private javax.swing.JLabel txtSoLuongConIphone4;
    private javax.swing.JLabel txtSoLuongConIphone5;
    private javax.swing.JLabel txtSoLuongConIphone6;
    private javax.swing.JLabel txtSoLuongConIphone7;
    private javax.swing.JLabel txtSoLuongConIphone8;
    private javax.swing.JLabel txtSoLuongConIphone9;
    private javax.swing.JLabel txtSoLuongConSamSung1;
    private javax.swing.JLabel txtSoLuongConSamSung2;
    private javax.swing.JLabel txtSoLuongConSamSung3;
    private javax.swing.JLabel txtSoLuongConSamSung4;
    private javax.swing.JLabel txtSoLuongConSamSung5;
    private javax.swing.JLabel txtSoLuongConSamSung6;
    private javax.swing.JLabel txtSoLuongConSamSung7;
    private javax.swing.JLabel txtSoLuongConSamSung8;
    private javax.swing.JLabel txtSoLuongConSamSung9;
    private javax.swing.JLabel txtSoLuongConSony1;
    private javax.swing.JLabel txtSoLuongConSony2;
    private javax.swing.JLabel txtSoLuongConSony3;
    private javax.swing.JLabel txtSoLuongConSony4;
    private javax.swing.JLabel txtSoLuongConSony5;
    private javax.swing.JLabel txtSoLuongConSony6;
    private javax.swing.JLabel txtSoLuongConSony7;
    private javax.swing.JLabel txtSoLuongConSony8;
    private javax.swing.JLabel txtSoLuongConSony9;
    private javax.swing.JLabel txtTenIphone1;
    private javax.swing.JLabel txtTenIphone2;
    private javax.swing.JLabel txtTenIphone3;
    private javax.swing.JLabel txtTenIphone4;
    private javax.swing.JLabel txtTenIphone5;
    private javax.swing.JLabel txtTenIphone6;
    private javax.swing.JLabel txtTenIphone7;
    private javax.swing.JLabel txtTenIphone8;
    private javax.swing.JLabel txtTenIphone9;
    private javax.swing.JLabel txtTenSamSung1;
    private javax.swing.JLabel txtTenSamSung2;
    private javax.swing.JLabel txtTenSamSung3;
    private javax.swing.JLabel txtTenSamSung4;
    private javax.swing.JLabel txtTenSamSung5;
    private javax.swing.JLabel txtTenSamSung6;
    private javax.swing.JLabel txtTenSamSung7;
    private javax.swing.JLabel txtTenSamSung8;
    private javax.swing.JLabel txtTenSamSung9;
    private javax.swing.JLabel txtTenSony1;
    private javax.swing.JLabel txtTenSony2;
    private javax.swing.JLabel txtTenSony3;
    private javax.swing.JLabel txtTenSony4;
    private javax.swing.JLabel txtTenSony5;
    private javax.swing.JLabel txtTenSony6;
    private javax.swing.JLabel txtTenSony7;
    private javax.swing.JLabel txtTenSony8;
    private javax.swing.JLabel txtTenSony9;
    private javax.swing.JLabel txtThongBao;
    private com.DuAn1.Swing.TextField txtTienkhach;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JPanel txtTongtien;
    private com.DuAn1.swing0.button0 txtadd1;
    private com.DuAn1.swing0.button0 txtadd2;
    private com.DuAn1.swing0.button0 txtadd3;
    private com.DuAn1.swing0.button0 txtadd4;
    private com.DuAn1.swing0.button0 txtadd5;
    private com.DuAn1.swing0.button0 txtadd6;
    private com.DuAn1.swing0.button0 txtadd7;
    private com.DuAn1.swing0.button0 txtadd8;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.BaoHanhCTDAO;
import com.DuAn1.Dao.BaoHanhDAO;
import com.DuAn1.Dao.HoaDonDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Model.BaoHanhCTModel;
import com.DuAn1.Model.BaoHanhModel;
import com.DuAn1.Model.HoaDonModel;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.SanPhamModel;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.main.Main;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import com.sun.jna.platform.win32.Winspool;
import com.tuandhpc05076.helper.ShareHelper;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class BaoHanh extends javax.swing.JPanel {

    DefaultTableModel model;
    int row = -1;
    BaoHanhDAO dao = new BaoHanhDAO();
    BaoHanhCTDAO bhctdao = new BaoHanhCTDAO();
    SanPhamDAO daosp = new SanPhamDAO();
    ThongKeDao daoThongKe = new ThongKeDao();
    KhachHangDAO daoKH = new KhachHangDAO();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();

    public static String soLuong = "";

    public static String getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(String soLuong) {
        BaoHanh.soLuong = soLuong;
    }

    public BaoHanh() {
        initComponents();
        tieude();
//        loadCboHD();
//        loadCboKH();
//        fillTable();
        setOpaque(false);
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
        LoadSP(daosp.select());
    }

    BaoHanhCTModel getFormThemIPhone1() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone1.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone2() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());

        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone2.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone3() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());

        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone3.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone4() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone4.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone5() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone5.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone6() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone6.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone7() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone7.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone8() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone8.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemIPhone9() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaIphone9.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony1() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony1.getText());
        cd.setSoLuong(SoLuong.getSoLuong());
        return cd;
    }

    BaoHanhCTModel getFormThemSony2() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony2.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony3() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony3.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony4() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony4.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony5() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony5.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony6() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaSony6.getText());
        cd.setMaHD(txtSoluong.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony7() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony7.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony8() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony8.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSony9() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSony9.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung1() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung1.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung2() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung2.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung3() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung3.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung4() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung4.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung5() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung5.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung6() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung6.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung7() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung7.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung8() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung8.getText());
        return cd;
    }

    BaoHanhCTModel getFormThemSamsung9() {
        BaoHanhCTModel cd = new BaoHanhCTModel();
        cd.setSoLuong(SoLuong.getSoLuong());
        cd.setMaBH(txtMaBH.getText());
        cd.setMaHD(txtMaSamSung9.getText());
        return cd;
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
                    txtMaIphone1.setText(sp.getMaSP());
                    lbIphone1.setVisible(true);
                }
                if (i == 1) {
                    txtHinhAnhIphone2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone3.setText(sp.getTenSP());
                    txtSoLuongConIphone2.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone2.setText(sp.getMaSP());
                    lbIphone2.setVisible(true);
                }
                if (i == 2) {
                    txtHinhAnhIphone3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone2.setText(sp.getTenSP());
                    txtSoLuongConIphone3.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone3.setText(sp.getMaSP());
                    lbIphone3.setVisible(true);
                }
                if (i == 3) {
                    txtHinhAnhIphone4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone4.setText(sp.getTenSP());
                    txtSoLuongConIphone4.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone4.setText(sp.getMaSP());
                    lbIphone4.setVisible(true);
                }
                if (i == 4) {
                    txtHinhAnhIphone5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone5.setText(sp.getTenSP());
                    txtSoLuongConIphone5.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone5.setText(sp.getMaSP());
                    lbIphone5.setVisible(true);
                }
                if (i == 5) {
                    txtHinhAnhIphone6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone6.setText(sp.getTenSP());
                    txtSoLuongConIphone6.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone6.setText(sp.getMaSP());
                    lbIphone6.setVisible(true);
                }
                if (i == 6) {
                    txtHinhAnhIphone7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone7.setText(sp.getTenSP());
                    txtSoLuongConIphone7.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone7.setText(sp.getMaSP());
                    lbIphone7.setVisible(true);
                }
                if (i == 7) {
                    txtHinhAnhIphone8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone8.setText(sp.getTenSP());
                    txtSoLuongConIphone8.setText(String.valueOf(sp.getSoLuong()));
                    txtMaIphone8.setText(sp.getMaSP());
                    lbIphone8.setVisible(true);
                }
                if (i == 8) {
                    txtHinhAnhIphone9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone9.setText(sp.getTenSP());
                    txtSoLuongConIphone9.setText(String.valueOf(sp.getSoLuong()));
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
                    txtMaSamSung1.setText(sp.getMaSP());
                    lbISamSung1.setVisible(true);
                }
                if (j == 1) {
                    txtHinhAnhSamSung2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung2.setText(sp.getTenSP());
                    txtSoLuongConSamSung2.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung2.setText(sp.getMaSP());
                    lbISamSung2.setVisible(true);
                }
                if (j == 2) {
                    txtHinhAnhSamSung4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung4.setText(sp.getTenSP());
                    txtSoLuongConSamSung3.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung3.setText(sp.getMaSP());
                    lbISamSung3.setVisible(true);
                }
                if (j == 3) {
                    txtHinhAnhSamSung4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung4.setText(sp.getTenSP());
                    txtSoLuongConSamSung4.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung4.setText(sp.getMaSP());
                    lbISamSung4.setVisible(true);
                }
                if (j == 4) {
                    txtHinhAnhSamSung5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung5.setText(sp.getTenSP());
                    txtSoLuongConSamSung5.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung5.setText(sp.getMaSP());
                    lbISamSung5.setVisible(true);
                }
                if (j == 5) {
                    txtHinhAnhSamSung6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung6.setText(sp.getTenSP());
                    txtSoLuongConSamSung6.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung6.setText(sp.getMaSP());
                    lbISamSung6.setVisible(true);
                }
                if (j == 6) {
                    txtHinhAnhSamSung7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung7.setText(sp.getTenSP());
                    txtSoLuongConSamSung7.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung7.setText(sp.getMaSP());
                    lbISamSung7.setVisible(true);
                }
                if (j == 7) {
                    txtHinhAnhSamSung8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung8.setText(sp.getTenSP());
                    txtSoLuongConSamSung8.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSamSung8.setText(sp.getMaSP());
                    lbISamSung8.setVisible(true);
                }
                if (j == 8) {
                    txtHinhAnhSamSung9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung9.setText(sp.getTenSP());
                    txtSoLuongConSamSung9.setText(String.valueOf(sp.getSoLuong()));
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
                    txtMaSony1.setText(sp.getMaSP());
                    LbSony1.setVisible(true);
                }
                if (z == 1) {
                    txtHinhAnhSony2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony2.setText(sp.getTenSP());
                    txtSoLuongConSony2.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony2.setText(sp.getMaSP());
                    LbSony2.setVisible(true);
                }
                if (z == 2) {
                    txtHinhAnhSony3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony3.setText(sp.getTenSP());
                    txtSoLuongConSony3.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony3.setText(sp.getMaSP());
                    LbSony3.setVisible(true);
                }
                if (z == 3) {
                    txtHinhAnhSony4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony4.setText(sp.getTenSP());
                    txtSoLuongConSony4.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony4.setText(sp.getMaSP());
                    LbSony4.setVisible(true);
                }
                if (z == 4) {
                    txtHinhAnhSony4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony5.setText(sp.getTenSP());
                    txtSoLuongConSony5.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony5.setText(sp.getMaSP());
                    LbSony5.setVisible(true);
                }
                if (z == 5) {
                    txtHinhAnhSony5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony6.setText(sp.getTenSP());
                    txtSoLuongConSony6.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony6.setText(sp.getMaSP());
                    LbSony6.setVisible(true);
                }
                if (z == 6) {
                    txtHinhAnhSony6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony7.setText(sp.getTenSP());
                    txtSoLuongConSony7.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony7.setText(sp.getMaSP());
                    LbSony7.setVisible(true);
                }
                if (z == 7) {
                    txtHinhAnhSony7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony8.setText(sp.getTenSP());
                    txtSoLuongConSony8.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony8.setText(sp.getMaSP());
                    LbSony8.setVisible(true);
                }
                if (z == 8) {
                    txtHinhAnhSony8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony9.setText(sp.getTenSP());
                    txtSoLuongConSony9.setText(String.valueOf(sp.getSoLuong()));
                    txtMaSony9.setText(sp.getMaSP());
                    LbSony9.setVisible(true);
                }

            }
            z++;
        }
    }

    void tieude() {
        model = new DefaultTableModel();
        String[] name = new String[]{"Mã bảo hành", "Mã sản phẩm", "Số Lượng"};
        model.setColumnIdentifiers(name);
        tblBH.setModel(model);
    }

    void filltable() {
        model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        try {
            List<BaoHanhCTModel> list = bhctdao.selectAll(txtMaBH.getText());
            for (BaoHanhCTModel bhct : list) {
                Object[] row = new Object[]{bhct.getMaBH(), bhct.getMaHD(), bhct.getSoLuong()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }
//void loadCboHD(){
//    DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
//    HoaDonDAO hddao = new HoaDonDAO();
//    ArrayList<HoaDonModel> listhd = (ArrayList<HoaDonModel>) hddao.select();
//    for (HoaDonModel nv : listhd) {
//            cboModel.addElement(nv.getMaHD().trim());
//        }
//        cboMaHD.setModel(cboModel);
//        cboMaHD.setSelectedIndex(-1);
//}
//void loadCboKH(){
//    DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
//    KhachHangDAO hddao = new KhachHangDAO();
//    ArrayList<KhachHangModel> listhd = (ArrayList<KhachHangModel>) hddao.select();
//    for (KhachHangModel nv : listhd) {
//            cboModel.addElement(nv.getMaKH().trim());
//        }
//        cboMaKH.setModel(cboModel);
//        cboMaKH.setSelectedIndex(-1);
//}

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
        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtNgayHetHan = new com.DuAn1.Swing.TextField();
        txtemei = new com.DuAn1.Swing.TextField();
        txtMaBH = new com.DuAn1.Swing.TextField();
        button01 = new com.DuAn1.swing0.button0();
        button2 = new com.DuAn1.swing0.button0();
        btnXemDSBH = new com.DuAn1.swing0.button0();
        button7 = new com.DuAn1.swing0.button0();
        txtMoTa = new com.DuAn1.Swing.TextField();
        txtNgayBaoHanh = new com.DuAn1.Swing.TextField();
        btnTaoBH = new com.DuAn1.swing0.button0();
        txtSoluong = new com.DuAn1.Swing.TextField();
        txtKhachhang = new com.DuAn1.Swing.TextField();
        button9 = new com.DuAn1.swing0.button0();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBH = new javaswingdev.swing.table.Table();
        button5 = new com.DuAn1.swing0.button0();
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
        cboSapXep1 = new com.DuAn1.Swing.Combobox();
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
        cboSapXep2 = new com.DuAn1.Swing.Combobox();
        cboHinhThuc2 = new com.DuAn1.Swing.Combobox();
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
        cboSapXep3 = new com.DuAn1.Swing.Combobox();
        cboHinhThuc3 = new com.DuAn1.Swing.Combobox();

        dateChooser.setTextRefernce(txtNgayBaoHanh);

        imageAvatar68.setBorderSize(5);
        imageAvatar68.setBorderSpace(0);
        imageAvatar68.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar68.setGradientColor2(new java.awt.Color(255, 255, 255));
        imageAvatar68.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        dateChooser1.setTextRefernce(txtNgayHetHan);

        setPreferredSize(new java.awt.Dimension(1058, 1643));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 1643));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setText("Bảo hành");

        txtNgayHetHan.setLabelText("Ngày hết hạn");
        txtNgayHetHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayHetHanMouseClicked(evt);
            }
        });

        txtemei.setLabelText("Số IMEI");
        txtemei.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtemeiCaretUpdate(evt);
            }
        });

        txtMaBH.setLabelText("Mã bào hành");
        txtMaBH.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtMaBHCaretUpdate(evt);
            }
        });

        button01.setBackground(new java.awt.Color(153, 153, 255));
        button01.setText("làm mới");
        button01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button01ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(255, 51, 51));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Hủy bỏ");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        btnXemDSBH.setBackground(new java.awt.Color(153, 153, 255));
        btnXemDSBH.setText("Xem danh sách bảo hành");
        btnXemDSBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSBHActionPerformed(evt);
            }
        });

        button7.setBackground(new java.awt.Color(153, 153, 255));
        button7.setText("Bảo hành");
        button7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        txtMoTa.setLabelText("Lí do");
        txtMoTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMoTaMouseClicked(evt);
            }
        });

        txtNgayBaoHanh.setLabelText("Ngày bảo hành");
        txtNgayBaoHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayBaoHanhMouseClicked(evt);
            }
        });

        btnTaoBH.setBackground(new java.awt.Color(153, 153, 255));
        btnTaoBH.setText("Tạo bảo hành");
        btnTaoBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoBHActionPerformed(evt);
            }
        });

        txtSoluong.setEditable(false);
        txtSoluong.setLabelText("Số lượng");

        txtKhachhang.setEditable(false);
        txtKhachhang.setLabelText("Mã khách hàng");
        txtKhachhang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKhachhangCaretUpdate(evt);
            }
        });
        txtKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtKhachhangMousePressed(evt);
            }
        });
        txtKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachhangActionPerformed(evt);
            }
        });

        button9.setBackground(new java.awt.Color(153, 153, 255));
        button9.setText("+");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(button01, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 153, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnXemDSBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTaoBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtMoTa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayBaoHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtemei, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(txtSoluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemDSBH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(btnTaoBH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtemei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(581, 581, 581))
        );

        tblBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblBH);

        button5.setBackground(new java.awt.Color(255, 51, 51));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("Hủy tất cả");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm bảo hành");
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
                .addContainerGap(13, Short.MAX_VALUE)
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
                    .addContainerGap(23, Short.MAX_VALUE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addContainerGap(32, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addContainerGap(32, Short.MAX_VALUE)))
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

        cboSapXep1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep1.setSelectedIndex(-1);
        cboSapXep1.setLabeText("Sắp xếp theo");
        cboSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXep1ActionPerformed(evt);
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
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(cboSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(LbSony1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LbSony2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LbSony3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(LbSony7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LbSony8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(LbSony4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LbSony5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbSony6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LbSony9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LbSony8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(lbIphone3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtHinhAnhIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboSapXep2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cboHinhThuc2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                                .addGap(20, 20, 20)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
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
                        .addContainerGap(12, Short.MAX_VALUE))
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
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbISamSung1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(lbISamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTenSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHinhAnhSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbISamSung2Layout.createSequentialGroup()
                        .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(txtTenSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lbISamSung2Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaSamsung2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiaIphone30)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(lbISamSung2Layout.createSequentialGroup()
                        .addGroup(lbISamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHinhAnhSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(lbISamSung2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtMaSamSung2)
                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(lbISamSung3Layout.createSequentialGroup()
                        .addGroup(lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbISamSung3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(lbISamSung3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtMaSamSung3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lbISamSung3Layout.setVerticalGroup(
            lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbISamSung3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtMaSamSung3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbISamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung3)
                    .addComponent(txtGiaSamsung3)
                    .addComponent(txtGiaIphone31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(10, Short.MAX_VALUE))
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
                .addContainerGap(11, Short.MAX_VALUE))
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

        cboSapXep3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Giá", "Số lượng" }));
        cboSapXep3.setSelectedIndex(-1);
        cboSapXep3.setLabeText("Sắp xếp theo");
        cboSapXep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXep3ActionPerformed(evt);
            }
        });

        cboHinhThuc3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tăng", "Giảm" }));
        cboHinhThuc3.setSelectedIndex(-1);
        cboHinhThuc3.setLabeText("Hình thức");
        cboHinhThuc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThuc3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbISamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbISamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbISamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(lbISamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(lbISamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbISamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(lbISamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(lbISamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbISamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cboSapXep3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cboHinhThuc3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThuc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSapXep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbISamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbISamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbISamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbISamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane2.setViewportView(jPanel6);

        materialTabbed1.addTab("SAMSUNG", jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1036, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMoTaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMoTaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaMouseClicked
    void themBH() {
        try {
            BaoHanhModel model = getFormTao();
            dao.update(model);
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

        cd.setThoIGianHoatDong(com.DuAn1.Helper.ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Bảo hành");
        cd.setMaNV(com.DuAn1.Helper.ShareHelper.USER.getMaNV());
        return cd;
    }

    void clearForm() {
        txtMaBH.setText("");
        txtKhachhang.setText("");
        txtSoluong.setText("");
        txtemei.setText("");
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
//        String formatted = current.format(formatter);
//        txtNgayXuat.setText(formatted);
        txtMoTa.setText("");
    }

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        themBH();

    }//GEN-LAST:event_button7ActionPerformed

    private void btnXemDSBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSBHActionPerformed
        // TODO add your handling code here:
        DanhSachBH1 dsbh = new DanhSachBH1(com.DuAn1.main.Main.getMain(), true);
        dsbh.setVisible(true);
        txtMaBH.setText(DanhSachBH1.getMaBH());
        txtSoluong.setText(String.valueOf(DanhSachBH1.getMaSP()));
        txtemei.setText(DanhSachBH1.getSoEmei());
        txtNgayBaoHanh.setText(DanhSachBH1.getNgayBH());
        txtNgayHetHan.setText(DanhSachBH1.getNgayHH());
        txtMoTa.setText(DanhSachBH1.getGhiChu());
    }//GEN-LAST:event_btnXemDSBHActionPerformed

    private void txtemeiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtemeiCaretUpdate
        // TODO add your handling code here:
//        float TongTien = 0;
//        TongTien = Float.parseFloat(txtDonGia.getText()) * Float.parseFloat(txtSoLuong.getText());
//        TongTien=TongTien+TongTien*(Float.parseFloat(txtThue.getText())/100);
//        txtTongTien.setText(String.format("%.2f", TongTien));
//        float tong = 0;
//        if (txtTienKhachDua.getText().equals("")) {
//            return;
//        }
//        tong = Float.parseFloat(txtTongTien.getText()) - Float.parseFloat(txtTienKhachDua.getText());
//        txtTienConLai.setText(String.format("%.2f", tong));
    }//GEN-LAST:event_txtemeiCaretUpdate

    private void txtNgayHetHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayHetHanMouseClicked
        dateChooser1.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayHetHanMouseClicked

    private void txtNgayBaoHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayBaoHanhMouseClicked
        // TODO add your handling code here:
        dateChooser.showPopup();
    }//GEN-LAST:event_txtNgayBaoHanhMouseClicked
    BaoHanhModel getFormTao() {
        BaoHanhModel bh = new BaoHanhModel();
        bh.setMaBH(txtMaBH.getText());
        bh.setMaHD(txtSoluong.getText());
        bh.setSoEmei(txtemei.getText());
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayBaoHanh.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            bh.setNgayBH(ngayNhap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayHetHan.getText());

            String ngayNhap1 = new SimpleDateFormat("yyyy-MM-dd").format(date);

            bh.setNgayHetHan(ngayNhap1);

        } catch (Exception e) {
        }
        bh.setGhiChu(txtMoTa.getText());
        bh.setMaKH(txtKhachhang.getText());
        return bh;
    }

    void TuDongTangMa() {
        List<Object[]> i = daoThongKe.getMaxMaBH();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("H");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "BH";
        for (int j = 0; j <= 4 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtMaBH.setText(ten);
    }

    void themTaoBH() {
        try {
            BaoHanhModel model = getFormTao();
            dao.insert(model);
        } catch (Exception e) {
            e.printStackTrace();
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }
    private void btnTaoBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoBHActionPerformed
        // TODO add your handling code here:
        TuDongTangMa();
        themTaoBH();
    }//GEN-LAST:event_btnTaoBHActionPerformed

    private void txtMaBHCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtMaBHCaretUpdate
        // TODO add your handling code here:
        filltable();
    }//GEN-LAST:event_txtMaBHCaretUpdate

    private void txtKhachhangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhachhangCaretUpdate

    }//GEN-LAST:event_txtKhachhangCaretUpdate

    private void txtKhachhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKhachhangMousePressed

    }//GEN-LAST:event_txtKhachhangMousePressed

    private void txtKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachhangActionPerformed

    }//GEN-LAST:event_txtKhachhangActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        BaoHanh.setSoLuong(txtKhachhang.getText());
        KhachHangBaoHanh kh = new KhachHangBaoHanh(com.DuAn1.main.Main.getMain(), true);
        kh.setVisible(true);
        txtKhachhang.setText(KhachHangBaoHanh.getMaKH());
    }//GEN-LAST:event_button9ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        double tongGia = 0;
        int tongSoLuong = 0;
        try {
            List<BaoHanhCTModel> list = bhctdao.selectAll(txtMaBH.getText());
            for (BaoHanhCTModel bhct : list) {
                tongGia += bhct.getSoLuong();
            }
            txtSoluong.setText(String.valueOf(tongGia));
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

        cd.setThoIGianHoatDong(com.DuAn1.Helper.ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm vào bảo hành");
        cd.setMaNV(com.DuAn1.Helper.ShareHelper.USER.getMaNV());
        return cd;
    }
    private void btnAdd19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd19ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung9();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd19ActionPerformed

    private void btnAdd18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd18ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung8();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd18ActionPerformed

    private void btnAdd17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd17ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung7();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd17ActionPerformed

    private void btnAdd15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd15ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung5();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd15ActionPerformed

    private void btnAdd16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd16ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung6();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd16ActionPerformed

    private void btnAdd13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd13ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung3();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd13ActionPerformed

    private void btnAdd14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd14ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung4();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd14ActionPerformed

    private void btnAdd12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd12ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung2();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd12ActionPerformed

    private void btnAdd11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd11ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSamsung1();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd11ActionPerformed

    private void btnAdd20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd20ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        themSPCT();
    }//GEN-LAST:event_btnAdd20ActionPerformed

    private void btnAdd10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd10ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone9();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd10ActionPerformed

    private void btnAdd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone7();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd8ActionPerformed

    private void btnAdd9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd9ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone8();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd9ActionPerformed

    private void btnAdd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone5();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd6ActionPerformed

    private void btnAdd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone6();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd7ActionPerformed

    private void btnAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone4();

            bhctdao.insert(model);
            filltable();
            DialogHelper.alert(this, "Thêm sản phẩm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd5ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone2();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemIPhone3();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void txtadd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony9();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd8ActionPerformed

    private void txtadd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony8();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd7ActionPerformed

    private void txtadd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony7();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd6ActionPerformed

    private void txtadd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony6();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd5ActionPerformed

    private void txtadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd2ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony5();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd2ActionPerformed

    private void txtadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd1ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony4();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd1ActionPerformed

    private void txtadd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd4ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony3();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd4ActionPerformed

    private void txtadd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd3ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony2();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_txtadd3ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        try {
            BaoHanhCTModel model = getFormThemSony1();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed
    void DeleteAll() {
        if (txtMaBH.getText().equals("")) {
            com.tuandhpc05076.helper.DialogHelper.alert(this, "Bạn có đặt hàng nào");
            return;
        }
        try {
            bhctdao.XoaTatCa(txtMaBH.getText());

            filltable();

            com.DuAn1.Helper.DialogHelper.alert(this, "Xóa tất cả sản phẩm thành công");
        } catch (Exception e) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }

    }
    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        DeleteAll();
    }//GEN-LAST:event_button5ActionPerformed
    boolean check() {
        if (txtMaBH.getText().equals("")) {
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
            BaoHanhModel model = getFormTao();
            dao.delete(model);
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

        cd.setThoIGianHoatDong(com.DuAn1.Helper.ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Hủy Bảo hành");
        cd.setMaNV(com.DuAn1.Helper.ShareHelper.USER.getMaNV());
        return cd;
    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        Delete();
    }//GEN-LAST:event_button2ActionPerformed

    private void button01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button01ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_button01ActionPerformed

    private void cboSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXep1ActionPerformed
    SanPhamDAO Dao = new SanPhamDAO();
    private void cboHinhThuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc1ActionPerformed
        if (cboSapXep1.getSelectedItem() == null) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboHinhThuc1.getSelectedItem().equals("Tăng")) {
            if (cboSapXep1.getSelectedItem().equals("Mã")) {
                try {
                    LoadSP(Dao.orderByMaTang());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep1.getSelectedItem().equals("Giá")) {
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
            if (cboSapXep1.getSelectedItem().equals("Mã")) {
                try {
                    LoadSP(Dao.orderByMaGiam());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
                }

            } else if (cboSapXep1.getSelectedItem().equals("Giá")) {
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
        }         // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThuc2ActionPerformed

    private void cboSapXep3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXep3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXep3ActionPerformed

    private void cboHinhThuc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThuc3ActionPerformed
        if (cboSapXep3.getSelectedItem() == null) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboHinhThuc3.getSelectedItem().equals("Tăng")) {
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
        }         // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThuc3ActionPerformed
    public void themSPCT() {
        try {
            BaoHanhCTModel model = getFormThemIPhone1();

            bhctdao.insert(model);
            filltable();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi thêm dữ liệu");
        }
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
    private com.DuAn1.swing0.button0 btnTaoBH;
    private com.DuAn1.swing0.button0 btnThem;
    private com.DuAn1.swing0.button0 btnXemDSBH;
    private com.DuAn1.swing0.button0 button01;
    private com.DuAn1.swing0.button0 button2;
    private com.DuAn1.swing0.button0 button5;
    private com.DuAn1.swing0.button0 button7;
    private com.DuAn1.swing0.button0 button9;
    private com.DuAn1.Swing.Combobox cboHinhThuc1;
    private com.DuAn1.Swing.Combobox cboHinhThuc2;
    private com.DuAn1.Swing.Combobox cboHinhThuc3;
    private com.DuAn1.Swing.Combobox cboSapXep1;
    private com.DuAn1.Swing.Combobox cboSapXep2;
    private com.DuAn1.Swing.Combobox cboSapXep3;
    private com.raven.datechooser.DateChooser dateChooser;
    private com.raven.datechooser.DateChooser dateChooser1;
    private swing.ImageAvatar imageAvatar68;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javaswingdev.swing.table.Table tblBH;
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
    private com.DuAn1.Swing.TextField txtKhachhang;
    private com.DuAn1.Swing.TextField txtMaBH;
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
    private com.DuAn1.Swing.TextField txtMoTa;
    private com.DuAn1.Swing.TextField txtNgayBaoHanh;
    private com.DuAn1.Swing.TextField txtNgayHetHan;
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
    private com.DuAn1.Swing.TextField txtSoluong;
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
    private com.DuAn1.swing0.button0 txtadd1;
    private com.DuAn1.swing0.button0 txtadd2;
    private com.DuAn1.swing0.button0 txtadd3;
    private com.DuAn1.swing0.button0 txtadd4;
    private com.DuAn1.swing0.button0 txtadd5;
    private com.DuAn1.swing0.button0 txtadd6;
    private com.DuAn1.swing0.button0 txtadd7;
    private com.DuAn1.swing0.button0 txtadd8;
    private com.DuAn1.Swing.TextField txtemei;
    // End of variables declaration//GEN-END:variables
}

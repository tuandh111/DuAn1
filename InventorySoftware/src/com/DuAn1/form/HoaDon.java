/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Model.SanPhamModel;
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
import com.tuandhpc05076.helper.ShareHelper;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class HoaDon extends javax.swing.JPanel {

    SanPhamDAO daoSP = new SanPhamDAO();
    KhachHangDAO daoKH = new KhachHangDAO();

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
        lblSamSung1.setVisible(false);
        lblSamSung2.setVisible(false);
        lblSamSung3.setVisible(false);
        lblSamSung4.setVisible(false);
        lblSamSung5.setVisible(false);
        lblSamSung6.setVisible(false);
        lblSamSung7.setVisible(false);
        lblSamSung8.setVisible(false);
        lblSamSung9.setVisible(false);
        LoadSP();
        txtThongBao.setVisible(false);
    }

    public void LoadSP() {
        List<SanPhamModel> list = daoSP.select();
        int i = 0;
        int j = 0;
        int z = 0;
        for (SanPhamModel sp : list) {
            if (sp.getLoaiSP().equalsIgnoreCase("Iphone")) {
                if (i == 0) {
                    txtHinhAnhIphone1.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone1.setText(sp.getTenSP());
                    txtSoLuongConIphone1.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone1.setVisible(true);
                }
                if (i == 1) {
                    txtHinhAnhIphone2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone2.setText(sp.getTenSP());
                    txtSoLuongConIphone2.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone2.setVisible(true);
                }
                if (i == 2) {
                    txtHinhAnhIphone3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone3.setText(sp.getTenSP());
                    txtSoLuongConIphone3.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone3.setVisible(true);
                }
                if (i == 3) {
                    txtHinhAnhIphone4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone4.setText(sp.getTenSP());
                    txtSoLuongConIphone4.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone4.setVisible(true);
                }
                if (i == 4) {
                    txtHinhAnhIphone5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone5.setText(sp.getTenSP());
                    txtSoLuongConIphone5.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone5.setVisible(true);
                }
                if (i == 5) {
                    txtHinhAnhIphone6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone6.setText(sp.getTenSP());
                    txtSoLuongConIphone6.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone6.setVisible(true);
                }
                if (i == 6) {
                    txtHinhAnhIphone7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone7.setText(sp.getTenSP());
                    txtSoLuongConIphone7.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone7.setVisible(true);
                }
                if (i == 7) {
                    txtHinhAnhIphone8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone8.setText(sp.getTenSP());
                    txtSoLuongConIphone8.setText(String.valueOf(sp.getSoLuong()));
                    lbIphone8.setVisible(true);
                }
                if (i == 8) {
                    txtHinhAnhIphone9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenIphone9.setText(sp.getTenSP());
                    txtSoLuongConIphone9.setText(String.valueOf(sp.getSoLuong()));
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
                    lblSamSung1.setVisible(true);
                }
                if (j == 1) {
                    txtHinhAnhSamSung2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung2.setText(sp.getTenSP());
                    txtSoLuongConSamSung2.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung2.setVisible(true);
                }
                if (j == 2) {
                    txtHinhAnhSamSung4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung4.setText(sp.getTenSP());
                    txtSoLuongConSamSung3.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung3.setVisible(true);
                }
                if (j == 3) {
                    txtHinhAnhSamSung4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung4.setText(sp.getTenSP());
                    txtSoLuongConSamSung4.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung4.setVisible(true);
                }
                if (j == 4) {
                    txtHinhAnhSamSung5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung5.setText(sp.getTenSP());
                    txtSoLuongConSamSung5.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung5.setVisible(true);
                }
                if (j == 5) {
                    txtHinhAnhSamSung6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung6.setText(sp.getTenSP());
                    txtSoLuongConSamSung6.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung6.setVisible(true);
                }
                if (j == 6) {
                    txtHinhAnhSamSung7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung7.setText(sp.getTenSP());
                    txtSoLuongConSamSung7.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung7.setVisible(true);
                }
                if (j == 7) {
                    txtHinhAnhSamSung8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung8.setText(sp.getTenSP());
                    txtSoLuongConSamSung8.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung8.setVisible(true);
                }
                if (j == 8) {
                    txtHinhAnhSamSung9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSamSung9.setText(sp.getTenSP());
                    txtSoLuongConSamSung9.setText(String.valueOf(sp.getSoLuong()));
                    lblSamSung9.setVisible(true);
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
                    LbSony1.setVisible(true);
                }
                if (z == 1) {
                    txtHinhAnhSony2.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony2.setText(sp.getTenSP());
                    txtSoLuongConSony2.setText(String.valueOf(sp.getSoLuong()));
                    LbSony2.setVisible(true);
                }
                if (z == 2) {
                    txtHinhAnhSony3.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony3.setText(sp.getTenSP());
                    txtSoLuongConSony3.setText(String.valueOf(sp.getSoLuong()));
                    LbSony3.setVisible(true);
                }
                if (z == 3) {
                    txtHinhAnhSony4.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony4.setText(sp.getTenSP());
                    txtSoLuongConSony4.setText(String.valueOf(sp.getSoLuong()));
                    LbSony4.setVisible(true);
                }
                if (z == 4) {
                    txtHinhAnhSony5.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony5.setText(sp.getTenSP());
                    txtSoLuongConSony5.setText(String.valueOf(sp.getSoLuong()));
                    LbSony5.setVisible(true);
                }
                if (z == 5) {
                    txtHinhAnhSony6.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony6.setText(sp.getTenSP());
                    txtSoLuongConSony6.setText(String.valueOf(sp.getSoLuong()));
                    LbSony6.setVisible(true);
                }
                if (z == 6) {
                    txtHinhAnhSony7.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony7.setText(sp.getTenSP());
                    txtSoLuongConSony7.setText(String.valueOf(sp.getSoLuong()));
                    LbSony7.setVisible(true);
                }
                if (z == 7) {
                    txtHinhAnhSony8.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony8.setText(sp.getTenSP());
                    txtSoLuongConSony8.setText(String.valueOf(sp.getSoLuong()));
                    LbSony8.setVisible(true);
                }
                if (z == 8) {
                    txtHinhAnhSony9.setImage(ShareHelper.readLogo(sp.getHinh()));
                    txtTenSony9.setText(sp.getTenSP());
                    txtSoLuongConSony9.setText(String.valueOf(sp.getSoLuong()));
                    LbSony9.setVisible(true);
                }

            }
            z++;
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
        materialTabbed1 = new swing.MaterialTabbed();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        LbSony1 = new swing.PanelShadow();
        txtHinhAnhSony1 = new swing.ImageAvatar();
        btnAdd1 = new com.DuAn1.swing0.button0();
        txtTenSony1 = new javax.swing.JLabel();
        txtSoLuongConSony1 = new javax.swing.JLabel();
        txtSoLuong146 = new javax.swing.JLabel();
        txtSoLuongBan1 = new javax.swing.JLabel();
        LbSony2 = new swing.PanelShadow();
        txtHinhAnhSony2 = new swing.ImageAvatar();
        txtadd3 = new com.DuAn1.swing0.button0();
        txtTenSony2 = new javax.swing.JLabel();
        txtSoLuongConSony2 = new javax.swing.JLabel();
        txtSoLuong149 = new javax.swing.JLabel();
        txtSoLuongBan2 = new javax.swing.JLabel();
        LbSony3 = new swing.PanelShadow();
        txtHinhAnhSony3 = new swing.ImageAvatar();
        txtadd4 = new com.DuAn1.swing0.button0();
        txtTenSony3 = new javax.swing.JLabel();
        txtSoLuongConSony3 = new javax.swing.JLabel();
        txtSoLuong152 = new javax.swing.JLabel();
        txtSoLuongBan3 = new javax.swing.JLabel();
        LbSony4 = new swing.PanelShadow();
        txtHinhAnhSony4 = new swing.ImageAvatar();
        txtadd1 = new com.DuAn1.swing0.button0();
        txtTenSony4 = new javax.swing.JLabel();
        txtSoLuongConSony4 = new javax.swing.JLabel();
        txtSoLuong155 = new javax.swing.JLabel();
        txtSoLuongBan4 = new javax.swing.JLabel();
        LbSony5 = new swing.PanelShadow();
        txtHinhAnhSony5 = new swing.ImageAvatar();
        txtadd2 = new com.DuAn1.swing0.button0();
        txtTenSony5 = new javax.swing.JLabel();
        txtSoLuongConSony5 = new javax.swing.JLabel();
        txtSoLuong158 = new javax.swing.JLabel();
        txtSoLuongBan5 = new javax.swing.JLabel();
        LbSony6 = new swing.PanelShadow();
        txtHinhAnhSony6 = new swing.ImageAvatar();
        txtadd5 = new com.DuAn1.swing0.button0();
        txtTenSony6 = new javax.swing.JLabel();
        txtSoLuongConSony6 = new javax.swing.JLabel();
        txtSoLuong161 = new javax.swing.JLabel();
        txtSoLuongBan6 = new javax.swing.JLabel();
        LbSony7 = new swing.PanelShadow();
        txtHinhAnhSony7 = new swing.ImageAvatar();
        txtadd6 = new com.DuAn1.swing0.button0();
        txtTenSony7 = new javax.swing.JLabel();
        txtSoLuongConSony7 = new javax.swing.JLabel();
        txtSoLuong170 = new javax.swing.JLabel();
        txtSoLuongBan7 = new javax.swing.JLabel();
        LbSony8 = new swing.PanelShadow();
        txtHinhAnhSony8 = new swing.ImageAvatar();
        txtadd7 = new com.DuAn1.swing0.button0();
        txtTenSony8 = new javax.swing.JLabel();
        txtSoLuongConSony8 = new javax.swing.JLabel();
        txtSoLuong167 = new javax.swing.JLabel();
        txtSoLuongBan8 = new javax.swing.JLabel();
        LbSony9 = new swing.PanelShadow();
        txtHinhAnhSony9 = new swing.ImageAvatar();
        txtadd8 = new com.DuAn1.swing0.button0();
        txtTenSony9 = new javax.swing.JLabel();
        txtSoLuongConSony9 = new javax.swing.JLabel();
        txtSoLuong164 = new javax.swing.JLabel();
        txtSoLuongBan9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbIphone1 = new swing.PanelShadow();
        txtHinhAnhIphone1 = new swing.ImageAvatar();
        txtTenIphone1 = new javax.swing.JLabel();
        txtSoLuongConIphone1 = new javax.swing.JLabel();
        txtSoLuong110 = new javax.swing.JLabel();
        txtSoLuongBanIphone1 = new javax.swing.JLabel();
        btnAdd2 = new com.DuAn1.swing0.button0();
        lbIphone2 = new swing.PanelShadow();
        txtHinhAnhIphone3 = new swing.ImageAvatar();
        txtTenIphone3 = new javax.swing.JLabel();
        txtSoLuongConIphone3 = new javax.swing.JLabel();
        txtSoLuong114 = new javax.swing.JLabel();
        txtSoLuongBanIphone3 = new javax.swing.JLabel();
        btnAdd4 = new com.DuAn1.swing0.button0();
        lbIphone3 = new swing.PanelShadow();
        txtHinhAnhIphone2 = new swing.ImageAvatar();
        txtTenIphone2 = new javax.swing.JLabel();
        txtSoLuongConIphone2 = new javax.swing.JLabel();
        txtSoLuong112 = new javax.swing.JLabel();
        txtSoLuongBanIphone2 = new javax.swing.JLabel();
        btnAdd3 = new com.DuAn1.swing0.button0();
        lbIphone4 = new swing.PanelShadow();
        txtHinhAnhIphone4 = new swing.ImageAvatar();
        txtTenIphone4 = new javax.swing.JLabel();
        txtSoLuongConIphone4 = new javax.swing.JLabel();
        txtSoLuong120 = new javax.swing.JLabel();
        txtSoLuongBanIphone4 = new javax.swing.JLabel();
        btnAdd5 = new com.DuAn1.swing0.button0();
        lbIphone5 = new swing.PanelShadow();
        txtHinhAnhIphone5 = new swing.ImageAvatar();
        txtTenIphone5 = new javax.swing.JLabel();
        txtSoLuongConIphone6 = new javax.swing.JLabel();
        txtSoLuong116 = new javax.swing.JLabel();
        txtSoLuongBanIphone6 = new javax.swing.JLabel();
        btnAdd7 = new com.DuAn1.swing0.button0();
        lbIphone6 = new swing.PanelShadow();
        txtHinhAnhIphone6 = new swing.ImageAvatar();
        txtTenIphone6 = new javax.swing.JLabel();
        txtSoLuongConIphone5 = new javax.swing.JLabel();
        txtSoLuong118 = new javax.swing.JLabel();
        txtSoLuongBanIphone5 = new javax.swing.JLabel();
        btnAdd6 = new com.DuAn1.swing0.button0();
        lbIphone7 = new swing.PanelShadow();
        txtHinhAnhIphone7 = new swing.ImageAvatar();
        txtTenIphone7 = new javax.swing.JLabel();
        txtSoLuongConIphone8 = new javax.swing.JLabel();
        txtSoLuong124 = new javax.swing.JLabel();
        txtSoLuongBanIphone8 = new javax.swing.JLabel();
        btnAdd9 = new com.DuAn1.swing0.button0();
        lbIphone8 = new swing.PanelShadow();
        txtHinhAnhIphone8 = new swing.ImageAvatar();
        txtTenIphone8 = new javax.swing.JLabel();
        txtSoLuongConIphone7 = new javax.swing.JLabel();
        txtSoLuong122 = new javax.swing.JLabel();
        txtSoLuongBanIphone7 = new javax.swing.JLabel();
        btnAdd8 = new com.DuAn1.swing0.button0();
        lbIphone9 = new swing.PanelShadow();
        txtHinhAnhIphone9 = new swing.ImageAvatar();
        txtTenIphone9 = new javax.swing.JLabel();
        txtSoLuongConIphone9 = new javax.swing.JLabel();
        txtSoLuong126 = new javax.swing.JLabel();
        txtSoLuongBanIphone9 = new javax.swing.JLabel();
        btnAdd10 = new com.DuAn1.swing0.button0();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        lblSamSung1 = new swing.PanelShadow();
        txtHinhAnhSamSung1 = new swing.ImageAvatar();
        txtTenSamSung1 = new javax.swing.JLabel();
        txtSoLuongBanSamSung1 = new javax.swing.JLabel();
        txtSoLuong98 = new javax.swing.JLabel();
        txtSoLuongConSamSung1 = new javax.swing.JLabel();
        btnAdd11 = new com.DuAn1.swing0.button0();
        lblSamSung2 = new swing.PanelShadow();
        txtHinhAnhSamSung2 = new swing.ImageAvatar();
        txtTenSamSung2 = new javax.swing.JLabel();
        txtSoLuongBanSamSung2 = new javax.swing.JLabel();
        txtSoLuong99 = new javax.swing.JLabel();
        txtSoLuongConSamSung2 = new javax.swing.JLabel();
        btnAdd12 = new com.DuAn1.swing0.button0();
        lblSamSung3 = new swing.PanelShadow();
        txtHinhAnhSamSung3 = new swing.ImageAvatar();
        txtTenSamSung3 = new javax.swing.JLabel();
        txtSoLuongBanSamSung4 = new javax.swing.JLabel();
        txtSoLuong103 = new javax.swing.JLabel();
        txtSoLuongConSamSung4 = new javax.swing.JLabel();
        btnAdd14 = new com.DuAn1.swing0.button0();
        lblSamSung4 = new swing.PanelShadow();
        txtHinhAnhSamSung4 = new swing.ImageAvatar();
        txtTenSamSung4 = new javax.swing.JLabel();
        txtSoLuongBanSamSung3 = new javax.swing.JLabel();
        txtSoLuong100 = new javax.swing.JLabel();
        txtSoLuongConSamSung3 = new javax.swing.JLabel();
        btnAdd13 = new com.DuAn1.swing0.button0();
        lblSamSung5 = new swing.PanelShadow();
        txtHinhAnhSamSung5 = new swing.ImageAvatar();
        txtTenSamSung5 = new javax.swing.JLabel();
        txtSoLuongBanSamSung6 = new javax.swing.JLabel();
        txtSoLuong101 = new javax.swing.JLabel();
        txtSoLuongConSamSung6 = new javax.swing.JLabel();
        btnAdd16 = new com.DuAn1.swing0.button0();
        lblSamSung6 = new swing.PanelShadow();
        txtHinhAnhSamSung6 = new swing.ImageAvatar();
        txtTenSamSung6 = new javax.swing.JLabel();
        txtSoLuongBanSamSung5 = new javax.swing.JLabel();
        txtSoLuong102 = new javax.swing.JLabel();
        txtSoLuongConSamSung5 = new javax.swing.JLabel();
        btnAdd15 = new com.DuAn1.swing0.button0();
        lblSamSung7 = new swing.PanelShadow();
        txtHinhAnhSamSung7 = new swing.ImageAvatar();
        txtTenSamSung7 = new javax.swing.JLabel();
        txtSoLuongBanSamSung7 = new javax.swing.JLabel();
        txtSoLuong104 = new javax.swing.JLabel();
        txtSoLuongConSamSung7 = new javax.swing.JLabel();
        btnAdd17 = new com.DuAn1.swing0.button0();
        lblSamSung8 = new swing.PanelShadow();
        txtTenSamSung8 = new javax.swing.JLabel();
        txtHinhAnhSamSung8 = new swing.ImageAvatar();
        txtSoLuongConSamSung8 = new javax.swing.JLabel();
        txtSoLuong106 = new javax.swing.JLabel();
        txtSoLuongBanSamSung8 = new javax.swing.JLabel();
        btnAdd18 = new com.DuAn1.swing0.button0();
        lblSamSung9 = new swing.PanelShadow();
        txtHinhAnhSamSung9 = new swing.ImageAvatar();
        txtTenSamSung9 = new javax.swing.JLabel();
        txtSoLuongConSamSung9 = new javax.swing.JLabel();
        txtSoLuong108 = new javax.swing.JLabel();
        txtSoLuongBanSamSung9 = new javax.swing.JLabel();
        btnAdd19 = new com.DuAn1.swing0.button0();
        txtThongBao = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtKhachhang = new com.DuAn1.Swing.TextField();
        txtNgayXuat = new com.DuAn1.Swing.TextField();
        txtDonGia = new com.DuAn1.Swing.TextField();
        txtMa = new com.DuAn1.Swing.TextField();
        txtSoLuong = new com.DuAn1.Swing.TextField();
        txtThue = new com.DuAn1.Swing.TextField();
        btnMoiHD = new com.DuAn1.swing0.button0();
        btnHuyHD = new com.DuAn1.swing0.button0();
        button3 = new com.DuAn1.swing0.button0();
        btnThanhtoan = new com.DuAn1.swing0.button0();
        buttonBadges1 = new com.DuAn1.swing1.ButtonBadges();
        jLabel1 = new javax.swing.JLabel();
        txtTienKhachDua = new com.DuAn1.Swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        cboHinhthuc = new com.DuAn1.Swing.Combobox();
        txtMota = new com.DuAn1.Swing.TextField();
        txtTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTienConLai = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        button9 = new com.DuAn1.swing0.button0();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoadon = new javaswingdev.swing.table.Table();
        btnMoi = new com.DuAn1.swing0.button0();
        btnSua = new com.DuAn1.swing0.button0();
        btnHuy = new com.DuAn1.swing0.button0();
        btnThem = new com.DuAn1.swing0.button0();

        dateChooser.setTextRefernce(txtNgayXuat);

        imageAvatar68.setBorderSize(5);
        imageAvatar68.setBorderSpace(0);
        imageAvatar68.setGradientColor1(new java.awt.Color(255, 255, 255));
        imageAvatar68.setGradientColor2(new java.awt.Color(255, 255, 255));
        imageAvatar68.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        setPreferredSize(new java.awt.Dimension(1058, 1643));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 1643));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel102.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(77, 77, 77));
        jLabel102.setText("Sony");

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

        txtTenSony1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony1.setText("Mr. Dara");

        txtSoLuongConSony1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony1.setText("10");

        txtSoLuong146.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong146.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong146.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong146.setText("Đã bán:");

        txtSoLuongBan1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan1.setText("0");

        javax.swing.GroupLayout LbSony1Layout = new javax.swing.GroupLayout(LbSony1);
        LbSony1.setLayout(LbSony1Layout);
        LbSony1Layout.setHorizontalGroup(
            LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHinhAnhSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony1Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong146, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongBan1)))
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
                .addGap(16, 16, 16)
                .addComponent(txtHinhAnhSony1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony1)
                    .addComponent(txtSoLuong146)
                    .addComponent(txtSoLuongBan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtTenSony2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony2.setText("Mr. Dara");

        txtSoLuongConSony2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony2.setText("10");

        txtSoLuong149.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong149.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong149.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong149.setText("Đã bán:");

        txtSoLuongBan2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan2.setText("0");

        javax.swing.GroupLayout LbSony2Layout = new javax.swing.GroupLayout(LbSony2);
        LbSony2.setLayout(LbSony2Layout);
        LbSony2Layout.setHorizontalGroup(
            LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony2Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHinhAnhSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtadd3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony2Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong149, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongBan2)))
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
                .addGap(16, 16, 16)
                .addComponent(txtHinhAnhSony2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony2)
                    .addComponent(txtSoLuong149)
                    .addComponent(txtSoLuongBan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

        txtTenSony3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony3.setText("Mr. Dara");

        txtSoLuongConSony3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony3.setText("10");

        txtSoLuong152.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong152.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong152.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong152.setText("Đã bán:");

        txtSoLuongBan3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan3.setText("0");

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
                        .addComponent(txtSoLuong152, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBan3)))
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
                .addGap(19, 19, 19)
                .addComponent(txtHinhAnhSony3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(LbSony3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony3)
                    .addComponent(txtSoLuong152)
                    .addComponent(txtSoLuongBan3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtTenSony4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony4.setText("Mr. Dara");

        txtSoLuongConSony4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony4.setText("10");

        txtSoLuong155.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong155.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong155.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong155.setText("Đã bán:");

        txtSoLuongBan4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan4.setText("0");

        javax.swing.GroupLayout LbSony4Layout = new javax.swing.GroupLayout(LbSony4);
        LbSony4.setLayout(LbSony4Layout);
        LbSony4Layout.setHorizontalGroup(
            LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony4Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LbSony4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtadd1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LbSony4Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong155, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongBan4)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony4Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony4Layout.setVerticalGroup(
            LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong155)
                    .addComponent(txtSoLuongConSony4)
                    .addComponent(txtSoLuongBan4))
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

        txtTenSony5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony5.setText("Mr. Dara");

        txtSoLuongConSony5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony5.setText("10");

        txtSoLuong158.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong158.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong158.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong158.setText("Đã bán:");

        txtSoLuongBan5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan5.setText("0");

        javax.swing.GroupLayout LbSony5Layout = new javax.swing.GroupLayout(LbSony5);
        LbSony5.setLayout(LbSony5Layout);
        LbSony5Layout.setHorizontalGroup(
            LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony5Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong158, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBan5)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony5Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony5Layout.setVerticalGroup(
            LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(LbSony5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony5)
                    .addComponent(txtSoLuong158)
                    .addComponent(txtSoLuongBan5))
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

        txtTenSony6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony6.setText("Mr. Dara");

        txtSoLuongConSony6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony6.setText("10");

        txtSoLuong161.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong161.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong161.setText("Đã bán:");

        txtSoLuongBan6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan6.setText("0");

        javax.swing.GroupLayout LbSony6Layout = new javax.swing.GroupLayout(LbSony6);
        LbSony6.setLayout(LbSony6Layout);
        LbSony6Layout.setHorizontalGroup(
            LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony6Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony6Layout.createSequentialGroup()
                        .addComponent(txtHinhAnhSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong161, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuongBan6)
                        .addGap(12, 12, 12))
                    .addGroup(LbSony6Layout.createSequentialGroup()
                        .addComponent(txtadd5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony6Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony6Layout.setVerticalGroup(
            LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSony6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(LbSony6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony6)
                    .addComponent(txtSoLuong161)
                    .addComponent(txtSoLuongBan6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
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

        txtTenSony7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony7.setText("Mr. Dara");

        txtSoLuongConSony7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony7.setText("10");

        txtSoLuong170.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong170.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong170.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong170.setText("Đã bán:");

        txtSoLuongBan7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan7.setText("0");

        javax.swing.GroupLayout LbSony7Layout = new javax.swing.GroupLayout(LbSony7);
        LbSony7.setLayout(LbSony7Layout);
        LbSony7Layout.setHorizontalGroup(
            LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony7Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony7Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong170, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBan7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony7Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony7Layout.setVerticalGroup(
            LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSony7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(LbSony7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony7)
                    .addComponent(txtSoLuong170)
                    .addComponent(txtSoLuongBan7))
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

        txtTenSony8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony8.setText("Mr. Dara");

        txtSoLuongConSony8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony8.setText("10");

        txtSoLuong167.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong167.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong167.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong167.setText("Đã bán:");

        txtSoLuongBan8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan8.setText("0");

        javax.swing.GroupLayout LbSony8Layout = new javax.swing.GroupLayout(LbSony8);
        LbSony8.setLayout(LbSony8Layout);
        LbSony8Layout.setHorizontalGroup(
            LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony8Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony8Layout.createSequentialGroup()
                        .addComponent(txtHinhAnhSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony8Layout.createSequentialGroup()
                        .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtadd7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LbSony8Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong167, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuongBan8)))
                        .addContainerGap())))
            .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony8Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(txtTenSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        LbSony8Layout.setVerticalGroup(
            LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LbSony8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(LbSony8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony8)
                    .addComponent(txtSoLuong167)
                    .addComponent(txtSoLuongBan8))
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

        txtTenSony9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSony9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSony9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSony9.setText("Mr. Dara");

        txtSoLuongConSony9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSony9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSony9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSony9.setText("10");

        txtSoLuong164.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong164.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong164.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong164.setText("Đã bán:");

        txtSoLuongBan9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBan9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBan9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBan9.setText("0");

        javax.swing.GroupLayout LbSony9Layout = new javax.swing.GroupLayout(LbSony9);
        LbSony9.setLayout(LbSony9Layout);
        LbSony9Layout.setHorizontalGroup(
            LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LbSony9Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(txtHinhAnhSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtadd8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LbSony9Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong164, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBan9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(txtHinhAnhSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSony9)
                    .addComponent(txtSoLuong164)
                    .addComponent(txtSoLuongBan9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtadd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(LbSony9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LbSony9Layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addComponent(txtTenSony9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(LbSony1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LbSony2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbSony3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(LbSony4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(LbSony5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LbSony6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(LbSony7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(LbSony8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(LbSony9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(752, 752, 752))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel102)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel102)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LbSony5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LbSony8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbSony9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(1094, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel8);

        materialTabbed1.addTab("SONY", jScrollPane3);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(77, 77, 77));
        jLabel11.setText("IPHONE");

        lbIphone1.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone1.setShadowOpacity(0.3F);

        txtHinhAnhIphone1.setBorderSize(5);
        txtHinhAnhIphone1.setBorderSpace(0);
        txtHinhAnhIphone1.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone1.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone1.setText("Mr. Dara");

        txtSoLuongConIphone1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone1.setText("10");

        txtSoLuong110.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong110.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong110.setText("Đã bán:");

        txtSoLuongBanIphone1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone1.setText("0");

        btnAdd2.setText("Thêm ");
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone1Layout = new javax.swing.GroupLayout(lbIphone1);
        lbIphone1.setLayout(lbIphone1Layout);
        lbIphone1Layout.setHorizontalGroup(
            lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone1Layout.createSequentialGroup()
                            .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lbIphone1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtTenIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtHinhAnhIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone1Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuong110, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSoLuongBanIphone1)
                            .addContainerGap()))))
        );
        lbIphone1Layout.setVerticalGroup(
            lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone1)
                    .addComponent(txtSoLuong110)
                    .addComponent(txtSoLuongBanIphone1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone2.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone2.setShadowOpacity(0.3F);

        txtHinhAnhIphone3.setBorderSize(5);
        txtHinhAnhIphone3.setBorderSpace(0);
        txtHinhAnhIphone3.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone3.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone3.setText("Mr. Dara");

        txtSoLuongConIphone3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone3.setText("10");

        txtSoLuong114.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong114.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong114.setText("Đã bán:");

        txtSoLuongBanIphone3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone3.setText("0");

        btnAdd4.setText("Thêm ");
        btnAdd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone2Layout = new javax.swing.GroupLayout(lbIphone2);
        lbIphone2.setLayout(lbIphone2Layout);
        lbIphone2Layout.setHorizontalGroup(
            lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone2Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone2Layout.createSequentialGroup()
                            .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(lbIphone2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtTenIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtHinhAnhIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone2Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuong114, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSoLuongBanIphone3)
                            .addContainerGap()))))
        );
        lbIphone2Layout.setVerticalGroup(
            lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone3)
                    .addComponent(txtSoLuong114)
                    .addComponent(txtSoLuongBanIphone3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone3.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone3.setShadowOpacity(0.3F);

        txtHinhAnhIphone2.setBorderSize(5);
        txtHinhAnhIphone2.setBorderSpace(0);
        txtHinhAnhIphone2.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone2.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone2.setText("Mr. Dara");

        txtSoLuongConIphone2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone2.setText("10");

        txtSoLuong112.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong112.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong112.setText("Đã bán:");

        txtSoLuongBanIphone2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone2.setText("0");

        btnAdd3.setText("Thêm ");
        btnAdd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone3Layout = new javax.swing.GroupLayout(lbIphone3);
        lbIphone3.setLayout(lbIphone3Layout);
        lbIphone3Layout.setHorizontalGroup(
            lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone3Layout.createSequentialGroup()
                .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lbIphone3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTenIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHinhAnhIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lbIphone3Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong112, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuongBanIphone2)))))
                .addContainerGap())
        );
        lbIphone3Layout.setVerticalGroup(
            lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone2)
                    .addComponent(txtSoLuong112)
                    .addComponent(txtSoLuongBanIphone2))
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

        txtTenIphone4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone4.setText("Mr. Dara");

        txtSoLuongConIphone4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone4.setText("10");

        txtSoLuong120.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong120.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong120.setText("Đã bán:");

        txtSoLuongBanIphone4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone4.setText("0");

        btnAdd5.setText("Thêm ");
        btnAdd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone4Layout = new javax.swing.GroupLayout(lbIphone4);
        lbIphone4.setLayout(lbIphone4Layout);
        lbIphone4Layout.setHorizontalGroup(
            lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHinhAnhIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lbIphone4Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuong120, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSoLuongBanIphone4))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        lbIphone4Layout.setVerticalGroup(
            lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone4)
                    .addComponent(txtSoLuong120)
                    .addComponent(txtSoLuongBanIphone4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone5.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone5.setShadowOpacity(0.3F);

        txtHinhAnhIphone5.setBorderSize(5);
        txtHinhAnhIphone5.setBorderSpace(0);
        txtHinhAnhIphone5.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone5.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone5.setText("Mr. Dara");

        txtSoLuongConIphone6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone6.setText("10");

        txtSoLuong116.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong116.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong116.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong116.setText("Đã bán:");

        txtSoLuongBanIphone6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone6.setText("0");

        btnAdd7.setText("Thêm ");
        btnAdd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone5Layout = new javax.swing.GroupLayout(lbIphone5);
        lbIphone5.setLayout(lbIphone5Layout);
        lbIphone5Layout.setHorizontalGroup(
            lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone5Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong116, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanIphone6)))
                .addContainerGap())
        );
        lbIphone5Layout.setVerticalGroup(
            lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone6)
                    .addComponent(txtSoLuong116)
                    .addComponent(txtSoLuongBanIphone6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnAdd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone6.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone6.setShadowOpacity(0.3F);

        txtHinhAnhIphone6.setBorderSize(5);
        txtHinhAnhIphone6.setBorderSpace(0);
        txtHinhAnhIphone6.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone6.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone6.setText("Mr. Dara");

        txtSoLuongConIphone5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone5.setText("10");

        txtSoLuong118.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong118.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong118.setText("Đã bán:");

        txtSoLuongBanIphone5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone5.setText("0");

        btnAdd6.setText("Thêm ");
        btnAdd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone6Layout = new javax.swing.GroupLayout(lbIphone6);
        lbIphone6.setLayout(lbIphone6Layout);
        lbIphone6Layout.setHorizontalGroup(
            lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHinhAnhIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong118, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanIphone5)))
                .addContainerGap())
        );
        lbIphone6Layout.setVerticalGroup(
            lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone5)
                    .addComponent(txtSoLuong118)
                    .addComponent(txtSoLuongBanIphone5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone7.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone7.setShadowOpacity(0.3F);

        txtHinhAnhIphone7.setBorderSize(5);
        txtHinhAnhIphone7.setBorderSpace(0);
        txtHinhAnhIphone7.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone7.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone7.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone7.setText("Mr. Dara");

        txtSoLuongConIphone8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone8.setText("10");

        txtSoLuong124.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong124.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong124.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong124.setText("Đã bán:");

        txtSoLuongBanIphone8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone8.setText("0");

        btnAdd9.setText("Thêm ");
        btnAdd9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone7Layout = new javax.swing.GroupLayout(lbIphone7);
        lbIphone7.setLayout(lbIphone7Layout);
        lbIphone7Layout.setHorizontalGroup(
            lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lbIphone7Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong124, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanIphone8)))
                .addContainerGap())
        );
        lbIphone7Layout.setVerticalGroup(
            lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone8)
                    .addComponent(txtSoLuong124)
                    .addComponent(txtSoLuongBanIphone8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIphone8.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone8.setShadowOpacity(0.3F);

        txtHinhAnhIphone8.setBorderSize(5);
        txtHinhAnhIphone8.setBorderSpace(0);
        txtHinhAnhIphone8.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone8.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone8.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone8.setText("Mr. Dara");

        txtSoLuongConIphone7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone7.setText("10");

        txtSoLuong122.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong122.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong122.setText("Đã bán:");

        txtSoLuongBanIphone7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone7.setText("0");

        btnAdd8.setText("Thêm ");
        btnAdd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone8Layout = new javax.swing.GroupLayout(lbIphone8);
        lbIphone8.setLayout(lbIphone8Layout);
        lbIphone8Layout.setHorizontalGroup(
            lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbIphone8Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong122, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanIphone7)))
                .addContainerGap())
        );
        lbIphone8Layout.setVerticalGroup(
            lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone7)
                    .addComponent(txtSoLuong122)
                    .addComponent(txtSoLuongBanIphone7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbIphone9.setBackground(new java.awt.Color(246, 88, 88));
        lbIphone9.setShadowOpacity(0.3F);

        txtHinhAnhIphone9.setBorderSize(5);
        txtHinhAnhIphone9.setBorderSpace(0);
        txtHinhAnhIphone9.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone9.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhIphone9.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenIphone9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenIphone9.setText("Mr. Dara");

        txtSoLuongConIphone9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConIphone9.setText("10");

        txtSoLuong126.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong126.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong126.setText("Đã bán:");

        txtSoLuongBanIphone9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanIphone9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanIphone9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanIphone9.setText("0");

        btnAdd10.setText("Thêm ");
        btnAdd10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbIphone9Layout = new javax.swing.GroupLayout(lbIphone9);
        lbIphone9.setLayout(lbIphone9Layout);
        lbIphone9Layout.setHorizontalGroup(
            lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHinhAnhIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbIphone9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lbIphone9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lbIphone9Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong126, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanIphone9)))
                .addContainerGap())
        );
        lbIphone9Layout.setVerticalGroup(
            lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbIphone9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbIphone9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConIphone9)
                    .addComponent(txtSoLuong126)
                    .addComponent(txtSoLuongBanIphone9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel11)
                        .addGap(287, 287, 287))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                    .addComponent(lbIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbIphone6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lbIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(820, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIphone4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIphone6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIphone7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIphone8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(1177, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbIphone9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jScrollPane1.setViewportView(jPanel2);

        materialTabbed1.addTab("IPHONE", jScrollPane1);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(null);

        jLabel101.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(77, 77, 77));
        jLabel101.setText("SAMSUNG");
        jPanel6.add(jLabel101);
        jLabel101.setBounds(86, 0, 153, 39);

        lblSamSung1.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung1.setShadowOpacity(0.3F);

        txtHinhAnhSamSung1.setBorderSize(5);
        txtHinhAnhSamSung1.setBorderSpace(0);
        txtHinhAnhSamSung1.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung1.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung1.setText("Mr. Dara");

        txtSoLuongBanSamSung1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung1.setText("0");

        txtSoLuong98.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong98.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong98.setText("Đã bán:");

        txtSoLuongConSamSung1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung1.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung1.setText("10");

        btnAdd11.setText("Thêm ");
        btnAdd11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung1Layout = new javax.swing.GroupLayout(lblSamSung1);
        lblSamSung1.setLayout(lblSamSung1Layout);
        lblSamSung1Layout.setHorizontalGroup(
            lblSamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtHinhAnhSamSung1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung1Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong98, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblSamSung1Layout.setVerticalGroup(
            lblSamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung1)
                    .addComponent(txtSoLuong98)
                    .addComponent(txtSoLuongBanSamSung1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(lblSamSung1);
        lblSamSung1.setBounds(35, 57, 137, 202);

        lblSamSung2.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung2.setShadowOpacity(0.3F);

        txtHinhAnhSamSung2.setBorderSize(5);
        txtHinhAnhSamSung2.setBorderSpace(0);
        txtHinhAnhSamSung2.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung2.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung2.setText("Mr. Dara");

        txtSoLuongBanSamSung2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung2.setText("0");

        txtSoLuong99.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong99.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong99.setText("Đã bán:");

        txtSoLuongConSamSung2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung2.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung2.setText("10");

        btnAdd12.setText("Thêm ");
        btnAdd12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung2Layout = new javax.swing.GroupLayout(lblSamSung2);
        lblSamSung2.setLayout(lblSamSung2Layout);
        lblSamSung2Layout.setHorizontalGroup(
            lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lblSamSung2Layout.createSequentialGroup()
                        .addGroup(lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtHinhAnhSamSung2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lblSamSung2Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong99, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuongBanSamSung2)))
                        .addContainerGap(10, Short.MAX_VALUE))))
        );
        lblSamSung2Layout.setVerticalGroup(
            lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung2)
                    .addComponent(txtSoLuong99)
                    .addComponent(txtSoLuongBanSamSung2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(lblSamSung2);
        lblSamSung2.setBounds(181, 57, 141, 202);

        lblSamSung3.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung3.setShadowOpacity(0.3F);

        txtHinhAnhSamSung3.setBorderSize(5);
        txtHinhAnhSamSung3.setBorderSpace(0);
        txtHinhAnhSamSung3.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung3.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung3.setText("Mr. Dara");

        txtSoLuongBanSamSung4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung4.setText("0");

        txtSoLuong103.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong103.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong103.setText("Đã bán:");

        txtSoLuongConSamSung4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung4.setText("10");

        btnAdd14.setText("Thêm ");
        btnAdd14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung3Layout = new javax.swing.GroupLayout(lblSamSung3);
        lblSamSung3.setLayout(lblSamSung3Layout);
        lblSamSung3Layout.setHorizontalGroup(
            lblSamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung3Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong103, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung4))
                    .addGroup(lblSamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lblSamSung3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(txtTenSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        lblSamSung3Layout.setVerticalGroup(
            lblSamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung4)
                    .addComponent(txtSoLuong103)
                    .addComponent(txtSoLuongBanSamSung4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(lblSamSung3);
        lblSamSung3.setBounds(32, 290, 141, 202);

        lblSamSung4.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung4.setShadowOpacity(0.3F);

        txtHinhAnhSamSung4.setBorderSize(5);
        txtHinhAnhSamSung4.setBorderSpace(0);
        txtHinhAnhSamSung4.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung4.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung4.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung4.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung4.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung4.setText("Mr. Dara");

        txtSoLuongBanSamSung3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung3.setText("0");

        txtSoLuong100.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong100.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong100.setText("Đã bán:");

        txtSoLuongConSamSung3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung3.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung3.setText("10");

        btnAdd13.setText("Thêm ");
        btnAdd13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung4Layout = new javax.swing.GroupLayout(lblSamSung4);
        lblSamSung4.setLayout(lblSamSung4Layout);
        lblSamSung4Layout.setHorizontalGroup(
            lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lblSamSung4Layout.createSequentialGroup()
                        .addGroup(lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtHinhAnhSamSung4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(lblSamSung4Layout.createSequentialGroup()
                                .addComponent(txtSoLuongConSamSung3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong100, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoLuongBanSamSung3)))
                        .addContainerGap(10, Short.MAX_VALUE))))
        );
        lblSamSung4Layout.setVerticalGroup(
            lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung3)
                    .addComponent(txtSoLuong100)
                    .addComponent(txtSoLuongBanSamSung3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(lblSamSung4);
        lblSamSung4.setBounds(340, 57, 141, 202);

        lblSamSung5.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung5.setShadowOpacity(0.3F);

        txtHinhAnhSamSung5.setBorderSize(5);
        txtHinhAnhSamSung5.setBorderSpace(0);
        txtHinhAnhSamSung5.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung5.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung5.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung5.setText("Mr. Dara");

        txtSoLuongBanSamSung6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung6.setText("0");

        txtSoLuong101.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong101.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong101.setText("Đã bán:");

        txtSoLuongConSamSung6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung6.setText("10");

        btnAdd16.setText("Thêm ");
        btnAdd16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung5Layout = new javax.swing.GroupLayout(lblSamSung5);
        lblSamSung5.setLayout(lblSamSung5Layout);
        lblSamSung5Layout.setHorizontalGroup(
            lblSamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung5Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong101, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung6))
                    .addGroup(lblSamSung5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lblSamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHinhAnhSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        lblSamSung5Layout.setVerticalGroup(
            lblSamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung6)
                    .addComponent(txtSoLuong101)
                    .addComponent(txtSoLuongBanSamSung6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(lblSamSung5);
        lblSamSung5.setBounds(340, 290, 148, 202);

        lblSamSung6.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung6.setShadowOpacity(0.3F);

        txtHinhAnhSamSung6.setBorderSize(5);
        txtHinhAnhSamSung6.setBorderSpace(0);
        txtHinhAnhSamSung6.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung6.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung6.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung6.setText("Mr. Dara");

        txtSoLuongBanSamSung5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung5.setText("0");

        txtSoLuong102.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong102.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong102.setText("Đã bán:");

        txtSoLuongConSamSung5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung5.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung5.setText("10");

        btnAdd15.setText("Thêm ");
        btnAdd15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung6Layout = new javax.swing.GroupLayout(lblSamSung6);
        lblSamSung6.setLayout(lblSamSung6Layout);
        lblSamSung6Layout.setHorizontalGroup(
            lblSamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtHinhAnhSamSung6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung6Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong102, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung5))
                    .addGroup(lblSamSung6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        lblSamSung6Layout.setVerticalGroup(
            lblSamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung5)
                    .addComponent(txtSoLuong102)
                    .addComponent(txtSoLuongBanSamSung5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(lblSamSung6);
        lblSamSung6.setBounds(180, 290, 141, 202);

        lblSamSung7.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung7.setShadowOpacity(0.3F);

        txtHinhAnhSamSung7.setBorderSize(5);
        txtHinhAnhSamSung7.setBorderSpace(0);
        txtHinhAnhSamSung7.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung7.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung7.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung7.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung7.setText("Mr. Dara");

        txtSoLuongBanSamSung7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung7.setText("0");

        txtSoLuong104.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong104.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong104.setText("Đã bán:");

        txtSoLuongConSamSung7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung7.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung7.setText("10");

        btnAdd17.setText("Thêm ");
        btnAdd17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung7Layout = new javax.swing.GroupLayout(lblSamSung7);
        lblSamSung7.setLayout(lblSamSung7Layout);
        lblSamSung7Layout.setHorizontalGroup(
            lblSamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHinhAnhSamSung7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblSamSung7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(lblSamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung7Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong104, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung7)))
                .addContainerGap())
        );
        lblSamSung7Layout.setVerticalGroup(
            lblSamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung7)
                    .addComponent(txtSoLuong104)
                    .addComponent(txtSoLuongBanSamSung7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(lblSamSung7);
        lblSamSung7.setBounds(30, 510, 140, 202);

        lblSamSung8.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung8.setShadowOpacity(0.3F);

        txtTenSamSung8.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung8.setText("Mr. Dara");

        txtHinhAnhSamSung8.setBorderSize(5);
        txtHinhAnhSamSung8.setBorderSpace(0);
        txtHinhAnhSamSung8.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung8.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung8.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtSoLuongConSamSung8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung8.setText("10");

        txtSoLuong106.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong106.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong106.setText("Đã bán:");

        txtSoLuongBanSamSung8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung8.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung8.setText("0");

        btnAdd18.setText("Thêm ");
        btnAdd18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung8Layout = new javax.swing.GroupLayout(lblSamSung8);
        lblSamSung8.setLayout(lblSamSung8Layout);
        lblSamSung8Layout.setHorizontalGroup(
            lblSamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lblSamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHinhAnhSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(lblSamSung8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd18, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lblSamSung8Layout.createSequentialGroup()
                        .addComponent(txtSoLuongConSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong106, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongBanSamSung8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        lblSamSung8Layout.setVerticalGroup(
            lblSamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung8)
                    .addComponent(txtSoLuong106)
                    .addComponent(txtSoLuongBanSamSung8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(lblSamSung8);
        lblSamSung8.setBounds(180, 510, 140, 202);

        lblSamSung9.setBackground(new java.awt.Color(246, 88, 88));
        lblSamSung9.setShadowOpacity(0.3F);

        txtHinhAnhSamSung9.setBorderSize(5);
        txtHinhAnhSamSung9.setBorderSpace(0);
        txtHinhAnhSamSung9.setGradientColor1(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung9.setGradientColor2(new java.awt.Color(255, 255, 255));
        txtHinhAnhSamSung9.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/img1_d.jpg"))); // NOI18N

        txtTenSamSung9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        txtTenSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtTenSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTenSamSung9.setText("Mr. Dara");

        txtSoLuongConSamSung9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongConSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongConSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongConSamSung9.setText("10");

        txtSoLuong108.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuong108.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuong108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuong108.setText("Đã bán:");

        txtSoLuongBanSamSung9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        txtSoLuongBanSamSung9.setForeground(new java.awt.Color(235, 235, 235));
        txtSoLuongBanSamSung9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSoLuongBanSamSung9.setText("0");

        btnAdd19.setText("Thêm ");
        btnAdd19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblSamSung9Layout = new javax.swing.GroupLayout(lblSamSung9);
        lblSamSung9.setLayout(lblSamSung9Layout);
        lblSamSung9Layout.setHorizontalGroup(
            lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAdd19, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(lblSamSung9Layout.createSequentialGroup()
                            .addComponent(txtSoLuongConSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoLuong108, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSoLuongBanSamSung9)))
                    .addGroup(lblSamSung9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHinhAnhSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        lblSamSung9Layout.setVerticalGroup(
            lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblSamSung9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHinhAnhSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSamSung9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblSamSung9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongConSamSung9)
                    .addComponent(txtSoLuong108)
                    .addComponent(txtSoLuongBanSamSung9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(lblSamSung9);
        lblSamSung9.setBounds(340, 510, 149, 202);

        txtThongBao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtThongBao.setForeground(new java.awt.Color(255, 0, 0));
        txtThongBao.setText("jLabel3");
        jPanel6.add(txtThongBao);
        txtThongBao.setBounds(380, 30, 134, 29);

        jScrollPane2.setViewportView(jPanel6);

        materialTabbed1.addTab("SAMSUNG", jScrollPane2);

        txtTongtien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setText("Hóa đơn");

        txtKhachhang.setLabelText("Khách hàng");

        txtNgayXuat.setLabelText("Ngày xuất");
        txtNgayXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayXuatMouseClicked(evt);
            }
        });

        txtDonGia.setLabelText("Tổng đơn giá");
        txtDonGia.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDonGiaCaretUpdate(evt);
            }
        });

        txtMa.setLabelText("Mã đặt hàng");

        txtSoLuong.setLabelText("Tổng số lượng");
        txtSoLuong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoLuongCaretUpdate(evt);
            }
        });

        txtThue.setText("0");
        txtThue.setLabelText("Thuế (%)");
        txtThue.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtThueCaretUpdate(evt);
            }
        });

        btnMoiHD.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiHD.setText("làm mới");

        btnHuyHD.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyHD.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyHD.setText("Hủy bỏ");

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

        buttonBadges1.setForeground(new java.awt.Color(250, 49, 49));
        buttonBadges1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/notification.png"))); // NOI18N
        buttonBadges1.setBadges(10);
        buttonBadges1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBadges1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tổng tiền:");

        txtTienKhachDua.setText("0");
        txtTienKhachDua.setLabelText("Tiền khách đưa");
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        jLabel2.setText("Số tiền còn lại:");

        cboHinhthuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cboHinhthuc.setSelectedIndex(-1);
        cboHinhthuc.setLabeText("Hình thức thanh toán");

        txtMota.setLabelText("Mô tả");
        txtMota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMotaMouseClicked(evt);
            }
        });

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTongTien.setText("0");

        jLabel4.setText("Đồng");

        txtTienConLai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTienConLai.setText("0");

        jLabel6.setText("Đồng");

        button9.setBackground(new java.awt.Color(153, 153, 255));
        button9.setText("+");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtTongtienLayout = new javax.swing.GroupLayout(txtTongtien);
        txtTongtien.setLayout(txtTongtienLayout);
        txtTongtienLayout.setHorizontalGroup(
            txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTongtienLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(txtTongtienLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(61, 61, 61)
                                .addComponent(txtTongTien)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel4))
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(txtTienConLai)
                                .addGap(122, 122, 122)
                                .addComponent(jLabel6)))
                        .addGap(0, 165, Short.MAX_VALUE))
                    .addComponent(txtMota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(txtTongtienLayout.createSequentialGroup()
                                .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(cboHinhthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        txtTongtienLayout.setVerticalGroup(
            txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTongtienLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createSequentialGroup()
                        .addComponent(buttonBadges1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTongtienLayout.createSequentialGroup()
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)))
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTongTien)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addComponent(cboHinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienConLai)
                            .addComponent(jLabel2)))
                    .addGroup(txtTongtienLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addGap(13, 13, 13)
                .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtTongtienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(581, 581, 581))
        );

        tblHoadon.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblHoadon);

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Làm mới");

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy bỏ");

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1048, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        DanhSachHoaDon dshd = new DanhSachHoaDon(true);
        dshd.setVisible(true);
    }//GEN-LAST:event_button3ActionPerformed

    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhtoanActionPerformed

    private void buttonBadges1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBadges1ActionPerformed
        // TODO add your handling code here:
        HoaDonCho hdc = new HoaDonCho(Main.getMain(), true);
        hdc.setVisible(true);
    }//GEN-LAST:event_buttonBadges1ActionPerformed

    private void txtNgayXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayXuatMouseClicked
        dateChooser.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayXuatMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtadd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony9.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony9.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan9.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan9.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd8ActionPerformed

    private void txtadd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony8.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony8.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan8.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan8.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd7ActionPerformed

    private void txtadd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony7.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony7.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan7.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan7.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd6ActionPerformed

    private void txtadd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony6.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony6.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan6.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan6.setText(String.valueOf(j));
    }//GEN-LAST:event_txtadd5ActionPerformed

    private void txtadd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd2ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony5.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony5.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan5.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan5.setText(String.valueOf(j));
    }//GEN-LAST:event_txtadd2ActionPerformed

    private void txtadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd1ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony4.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony4.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan4.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan4.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_txtadd1ActionPerformed

    private void txtadd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd4ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony3.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony3.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan3.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan3.setText(String.valueOf(j));
    }//GEN-LAST:event_txtadd4ActionPerformed

    private void txtadd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadd3ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony2.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony2.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan2.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan2.setText(String.valueOf(j));
    }//GEN-LAST:event_txtadd3ActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:     
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSony1.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSony1.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBan1.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBan1.setText(String.valueOf(j));

    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void txtMotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMotaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotaMouseClicked

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        // TODO add your handling code here:
        float tong = 0;
        if (txtTienKhachDua.getText().equals("")) {
            return;
        }
        tong = Float.parseFloat(txtTongTien.getText()) - Float.parseFloat(txtTienKhachDua.getText());
        txtTienConLai.setText(String.format("%.2f", tong));
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtDonGiaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDonGiaCaretUpdate
        // TODO add your handling code here:
        float TongTien = 0;
        TongTien = Float.parseFloat(txtDonGia.getText()) * Float.parseFloat(txtSoLuong.getText());
        TongTien = TongTien + TongTien * (Float.parseFloat(txtThue.getText()) / 100);
        txtTongTien.setText(String.format("%.2f", TongTien));
        float tong = 0;
        if (txtTienKhachDua.getText().equals("")) {
            return;
        }
        tong = Float.parseFloat(txtTongTien.getText()) - Float.parseFloat(txtTienKhachDua.getText());
        txtTienConLai.setText(String.format("%.2f", tong));
    }//GEN-LAST:event_txtDonGiaCaretUpdate

    private void txtSoLuongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoLuongCaretUpdate
        float TongTien = 0;
        TongTien = Float.parseFloat(txtDonGia.getText()) * Float.parseFloat(txtSoLuong.getText());
        TongTien = TongTien + TongTien * (Float.parseFloat(txtThue.getText()) / 100);
        txtTongTien.setText(String.format("%.2f", TongTien));
        float tong = 0;
        if (txtTienKhachDua.getText().equals("")) {
            return;
        }
        tong = Float.parseFloat(txtTongTien.getText()) - Float.parseFloat(txtTienKhachDua.getText());
        txtTienConLai.setText(String.format("%.2f", tong));
// TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongCaretUpdate

    private void txtThueCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtThueCaretUpdate
        float TongTien = 0;
        TongTien = Float.parseFloat(txtDonGia.getText()) * Float.parseFloat(txtSoLuong.getText());
        TongTien = TongTien + TongTien * (Float.parseFloat(txtThue.getText()) / 100);
        txtTongTien.setText(String.format("%.2f", TongTien));
        float tong = 0;
        if (txtTienKhachDua.getText().equals("")) {
            return;
        }
        tong = Float.parseFloat(txtTongTien.getText()) - Float.parseFloat(txtTienKhachDua.getText());
        txtTienConLai.setText(String.format("%.2f", tong));        // TODO add your handling code here:
    }//GEN-LAST:event_txtThueCaretUpdate

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone1.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone1.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone1.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone1.setText(String.valueOf(j));
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnAdd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd3ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone2.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone2.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone2.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone2.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd3ActionPerformed

    private void btnAdd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd4ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone3.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone3.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone3.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone3.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd4ActionPerformed

    private void btnAdd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd5ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone4.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone4.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone4.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone4.setText(String.valueOf(j));
    }//GEN-LAST:event_btnAdd5ActionPerformed

    private void btnAdd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd6ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone5.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone5.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone5.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone5.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd6ActionPerformed

    private void btnAdd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd7ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone6.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone6.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone6.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone6.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd7ActionPerformed

    private void btnAdd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd8ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone7.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone7.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone7.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone7.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd8ActionPerformed

    private void btnAdd9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd9ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone8.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone8.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone8.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone8.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd9ActionPerformed

    private void btnAdd10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd10ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConIphone9.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConIphone9.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanIphone9.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanIphone9.setText(String.valueOf(j));        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd10ActionPerformed

    private void btnAdd11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd11ActionPerformed
        // TODO add your handling code here:
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung1.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung1.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung1.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung1.setText(String.valueOf(j));
    }//GEN-LAST:event_btnAdd11ActionPerformed

    private void btnAdd12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd12ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung2.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung2.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung2.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung2.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd12ActionPerformed

    private void btnAdd13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd13ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung3.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung3.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung3.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung3.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd13ActionPerformed

    private void btnAdd14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd14ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung4.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung4.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung4.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung4.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd14ActionPerformed

    private void btnAdd15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd15ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung5.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung5.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung5.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung5.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd15ActionPerformed

    private void btnAdd16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd16ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung6.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung6.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung6.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung6.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd16ActionPerformed

    private void btnAdd17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd17ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung7.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung7.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung7.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung7.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd17ActionPerformed

    private void btnAdd18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd18ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung8.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung8.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung8.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung8.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd18ActionPerformed

    private void btnAdd19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd19ActionPerformed
        SoLuong sl = new SoLuong(com.DuAn1.main.Main.getMain(), true);
        sl.setVisible(true);
        int i = Integer.parseInt(txtSoLuongConSamSung9.getText());
        i = i - sl.getSoLuong();
        txtSoLuongConSamSung9.setText(String.valueOf(i));
        int j = Integer.parseInt(txtSoLuongBanSamSung9.getText());
        j = j + sl.getSoLuong();
        txtSoLuongBanSamSung9.setText(String.valueOf(j));         // TODO add your handling code here:
    }//GEN-LAST:event_btnAdd19ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button9ActionPerformed


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
    private com.DuAn1.swing0.button0 btnAdd2;
    private com.DuAn1.swing0.button0 btnAdd3;
    private com.DuAn1.swing0.button0 btnAdd4;
    private com.DuAn1.swing0.button0 btnAdd5;
    private com.DuAn1.swing0.button0 btnAdd6;
    private com.DuAn1.swing0.button0 btnAdd7;
    private com.DuAn1.swing0.button0 btnAdd8;
    private com.DuAn1.swing0.button0 btnAdd9;
    private com.DuAn1.swing0.button0 btnHuy;
    private com.DuAn1.swing0.button0 btnHuyHD;
    private com.DuAn1.swing0.button0 btnMoi;
    private com.DuAn1.swing0.button0 btnMoiHD;
    private com.DuAn1.swing0.button0 btnSua;
    private com.DuAn1.swing0.button0 btnThanhtoan;
    private com.DuAn1.swing0.button0 btnThem;
    private com.DuAn1.swing0.button0 button3;
    private com.DuAn1.swing0.button0 button9;
    private com.DuAn1.swing1.ButtonBadges buttonBadges1;
    private com.DuAn1.Swing.Combobox cboHinhthuc;
    private com.raven.datechooser.DateChooser dateChooser;
    private swing.ImageAvatar imageAvatar68;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private swing.PanelShadow lbIphone1;
    private swing.PanelShadow lbIphone2;
    private swing.PanelShadow lbIphone3;
    private swing.PanelShadow lbIphone4;
    private swing.PanelShadow lbIphone5;
    private swing.PanelShadow lbIphone6;
    private swing.PanelShadow lbIphone7;
    private swing.PanelShadow lbIphone8;
    private swing.PanelShadow lbIphone9;
    private swing.PanelShadow lblSamSung1;
    private swing.PanelShadow lblSamSung2;
    private swing.PanelShadow lblSamSung3;
    private swing.PanelShadow lblSamSung4;
    private swing.PanelShadow lblSamSung5;
    private swing.PanelShadow lblSamSung6;
    private swing.PanelShadow lblSamSung7;
    private swing.PanelShadow lblSamSung8;
    private swing.PanelShadow lblSamSung9;
    private swing.MaterialTabbed materialTabbed1;
    private javaswingdev.swing.table.Table tblHoadon;
    private com.DuAn1.Swing.TextField txtDonGia;
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
    private com.DuAn1.Swing.TextField txtMa;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgayXuat;
    private com.DuAn1.Swing.TextField txtSoLuong;
    private javax.swing.JLabel txtSoLuong100;
    private javax.swing.JLabel txtSoLuong101;
    private javax.swing.JLabel txtSoLuong102;
    private javax.swing.JLabel txtSoLuong103;
    private javax.swing.JLabel txtSoLuong104;
    private javax.swing.JLabel txtSoLuong106;
    private javax.swing.JLabel txtSoLuong108;
    private javax.swing.JLabel txtSoLuong110;
    private javax.swing.JLabel txtSoLuong112;
    private javax.swing.JLabel txtSoLuong114;
    private javax.swing.JLabel txtSoLuong116;
    private javax.swing.JLabel txtSoLuong118;
    private javax.swing.JLabel txtSoLuong120;
    private javax.swing.JLabel txtSoLuong122;
    private javax.swing.JLabel txtSoLuong124;
    private javax.swing.JLabel txtSoLuong126;
    private javax.swing.JLabel txtSoLuong146;
    private javax.swing.JLabel txtSoLuong149;
    private javax.swing.JLabel txtSoLuong152;
    private javax.swing.JLabel txtSoLuong155;
    private javax.swing.JLabel txtSoLuong158;
    private javax.swing.JLabel txtSoLuong161;
    private javax.swing.JLabel txtSoLuong164;
    private javax.swing.JLabel txtSoLuong167;
    private javax.swing.JLabel txtSoLuong170;
    private javax.swing.JLabel txtSoLuong98;
    private javax.swing.JLabel txtSoLuong99;
    private javax.swing.JLabel txtSoLuongBan1;
    private javax.swing.JLabel txtSoLuongBan2;
    private javax.swing.JLabel txtSoLuongBan3;
    private javax.swing.JLabel txtSoLuongBan4;
    private javax.swing.JLabel txtSoLuongBan5;
    private javax.swing.JLabel txtSoLuongBan6;
    private javax.swing.JLabel txtSoLuongBan7;
    private javax.swing.JLabel txtSoLuongBan8;
    private javax.swing.JLabel txtSoLuongBan9;
    private javax.swing.JLabel txtSoLuongBanIphone1;
    private javax.swing.JLabel txtSoLuongBanIphone2;
    private javax.swing.JLabel txtSoLuongBanIphone3;
    private javax.swing.JLabel txtSoLuongBanIphone4;
    private javax.swing.JLabel txtSoLuongBanIphone5;
    private javax.swing.JLabel txtSoLuongBanIphone6;
    private javax.swing.JLabel txtSoLuongBanIphone7;
    private javax.swing.JLabel txtSoLuongBanIphone8;
    private javax.swing.JLabel txtSoLuongBanIphone9;
    private javax.swing.JLabel txtSoLuongBanSamSung1;
    private javax.swing.JLabel txtSoLuongBanSamSung2;
    private javax.swing.JLabel txtSoLuongBanSamSung3;
    private javax.swing.JLabel txtSoLuongBanSamSung4;
    private javax.swing.JLabel txtSoLuongBanSamSung5;
    private javax.swing.JLabel txtSoLuongBanSamSung6;
    private javax.swing.JLabel txtSoLuongBanSamSung7;
    private javax.swing.JLabel txtSoLuongBanSamSung8;
    private javax.swing.JLabel txtSoLuongBanSamSung9;
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
    private com.DuAn1.Swing.TextField txtThue;
    private javax.swing.JLabel txtTienConLai;
    private com.DuAn1.Swing.TextField txtTienKhachDua;
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

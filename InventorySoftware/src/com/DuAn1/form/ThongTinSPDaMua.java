/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.BaoHanhCTDAO;
import com.DuAn1.Dao.HoaDonCTDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.BaoHanhCTModel;
import com.DuAn1.Model.HoaDonCTModel;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ThongTinSPDaMua extends javax.swing.JDialog {

    DefaultTableModel model;
    HoaDonCTDAO bhctdao = new HoaDonCTDAO();
    public static String MaHDChiTietBaoHanh;
    public static String MaSPChiTietBaoHanh;
    public static String SoLuong;

    public static String getSoLuong() {
        return SoLuong;
    }

    public static void setSoLuong(String SoLuong) {
        ThongTinSPDaMua.SoLuong = SoLuong;
    }

    public static String getMaHDChiTietBaoHanh() {
        return MaHDChiTietBaoHanh;
    }

    public static void setMaHDChiTietBaoHanh(String MaHDChiTietBaoHanh) {
        ThongTinSPDaMua.MaHDChiTietBaoHanh = MaHDChiTietBaoHanh;
    }

    public static String getMaSPChiTietBaoHanh() {
        return MaSPChiTietBaoHanh;
    }

    public static void setMaSPChiTietBaoHanh(String MaSPChiTietBaoHanh) {
        ThongTinSPDaMua.MaSPChiTietBaoHanh = MaSPChiTietBaoHanh;
    }

    public ThongTinSPDaMua(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(ShareHelper.APP_ICON);
        filltable();
    }

    void filltable() {
        model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        try {
            List<HoaDonCTModel> list = bhctdao.selectKhDaMuaSp(KhachHangBaoHanh.getMaKH());
            for (HoaDonCTModel bhct : list) {
                DecimalFormat df = new DecimalFormat("#,##0.##");
                Object[] row = new Object[]{bhct.getMaSP(), bhct.getSoLuong(), bhct.getMaHD(), df.format(bhct.getGia()), df.format(bhct.getThanhTien())};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBH = new javaswingdev.swing.table.Table();
        button2 = new com.DuAn1.Swing.Button();
        button3 = new com.DuAn1.Swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Số lượng", "Mã hóa đơn", "Giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBH);

        button2.setText("Tách sản phẩm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setText("Áp dụng bảo hành");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(392, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBHMouseClicked
        int chon = tblBH.getSelectedRow();
        String maBH = (String) tblBH.getValueAt(chon, 0);
//        JOptionPane.shơ
//        KhachHangBaoHanh.setMaKH(maBH);
//dispose();

        //        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tblBHMouseClicked
int SoLuong1=0;
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:

        int row = tblBH.getSelectedRow();
        String SoLuong0 = String.valueOf(tblBH.getValueAt(row, 1));
        SoLuong0 = SoLuong0.replace(".0", "");
         SoLuong1 = Integer.parseInt(SoLuong0.trim());
        HoaDonCTModel model1 = getForm();
        String MaSP = String.valueOf(tblBH.getValueAt(row, 0));
        String MaHD = String.valueOf(tblBH.getValueAt(row, 2));
        HoaDonCTModel hoadonThem = getForm1();
        bhctdao.update(hoadonThem);
        
        for (int i = 0; i < SoLuong1 ; i++) {

            bhctdao.insert(model1);
        }
        model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        try {
            List<HoaDonCTModel> list = bhctdao.selectKhDaMuaSp(KhachHangBaoHanh.getMaKH());
            for (HoaDonCTModel bhct : list) {
                DecimalFormat df = new DecimalFormat("#,##0.##");
                Object[] row1 = new Object[]{bhct.getMaSP(), bhct.getSoLuong(), bhct.getMaHD(), df.format(bhct.getGia()), df.format(bhct.getThanhTien())};
                model.addRow(row1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }SoLuong1=0;
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        int chon = tblBH.getSelectedRow();
        String masp = String.valueOf(tblBH.getValueAt(chon, 0));
        String SoLuong = String.valueOf(tblBH.getValueAt(chon, 1));
        String mahd = String.valueOf(tblBH.getValueAt(chon, 2));
        ThongTinSPDaMua.setMaSPChiTietBaoHanh(masp);
        SoLuong = SoLuong.replace(".0", "");
        ThongTinSPDaMua.setSoLuong(SoLuong);
        ThongTinSPDaMua.setMaHDChiTietBaoHanh(mahd);
        dispose();
    }//GEN-LAST:event_button3ActionPerformed
    HoaDonCTModel getForm() {
        HoaDonCTModel hd = new HoaDonCTModel();
        int chon = tblBH.getSelectedRow();
        String MaSP = String.valueOf(tblBH.getValueAt(chon, 0));
        double SoLuong = (double) tblBH.getValueAt(chon, 1);
        String MaHD = String.valueOf(tblBH.getValueAt(chon, 2));
        String Gia = String.valueOf(tblBH.getValueAt(chon, 3));
        String ThanTien = (String) tblBH.getValueAt(chon, 4);
        hd.setMaSP(MaSP.trim());

        hd.setSoLuong(1);
        hd.setMaHD(MaHD.trim());
        hd.setGia(Double.parseDouble(Gia.replace(",", "")));
        if (ThanTien != null) {
            hd.setThanhTien(Double.parseDouble(ThanTien.replace(",", "")) / SoLuong1);
        }

        return hd;
    }
   HoaDonCTModel getForm1() {
        HoaDonCTModel hd = new HoaDonCTModel();
        int chon = tblBH.getSelectedRow();
        String MaSP = String.valueOf(tblBH.getValueAt(chon, 0));
        double SoLuong = (double) tblBH.getValueAt(chon, 1);
        String MaHD = String.valueOf(tblBH.getValueAt(chon, 2));
        String Gia = String.valueOf(tblBH.getValueAt(chon, 3));
        String ThanTien = (String) tblBH.getValueAt(chon, 4);
        hd.setMaSP(MaSP.trim());
       String sl= JOptionPane.showInputDialog("nhap so luong");
//       sl=String.valueOf(SoLuong1-Integer.parseInt(sl));
        hd.setSoLuong(Integer.parseInt(sl));
     
        hd.setMaHD(MaHD.trim());
        hd.setGia(Double.parseDouble(Gia.replace(",", "")));
        if (ThanTien != null) {
            hd.setThanhTien(Double.parseDouble(ThanTien.replace(",", "")) /SoLuong* Integer.parseInt(sl));
        }
           SoLuong1=SoLuong1-Integer.parseInt(sl);
        return hd;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongTinSPDaMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinSPDaMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinSPDaMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinSPDaMua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinSPDaMua dialog = new ThongTinSPDaMua(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button button2;
    private com.DuAn1.Swing.Button button3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblBH;
    // End of variables declaration//GEN-END:variables
}

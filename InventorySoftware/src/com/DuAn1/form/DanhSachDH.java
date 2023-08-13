/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.DatSPCTDAO;
import com.DuAn1.Dao.DatSPDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.SanPhamModel;
import com.raven.dialog.Message;
import com.DuAn1.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.DuAn1.tabledark.Test;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class DanhSachDH extends javax.swing.JDialog {

    DefaultTableModel tblModel;
    DatSPDAO daoSP = new DatSPDAO();
    public static String name1 = "";
    public static int soLuong = 0;
    public static double DonGia = 0;
    public static double tongTien = 0;
    public static String SDT = "";
    public static String ngay = "";

    public static String getNgay() {
        return ngay;
    }

    public static String getSDT() {
        return SDT;
    }

    public static void setSDT(String SDT) {
        DanhSachDH.SDT = SDT;
    }

    public static void setNgay(String ngay) {
        DanhSachDH.ngay = ngay;
    }

    public static int getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(int soLuong) {
        DanhSachDH.soLuong = soLuong;
    }

    public static double getDonGia() {
        return DonGia;
    }

    public static void setDonGia(double DonGia) {
        DanhSachDH.DonGia = DonGia;
    }

    public static double getTongTien() {
        return tongTien;
    }

    public static void setTongTien(double tongTien) {
        DanhSachDH.tongTien = tongTien;
    }

    public static String getName1() {
        return name1;
    }

    public static void setName1(String name1) {
        DanhSachDH.name1 = name1;
    }

    public DanhSachDH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tblUser.fixTable(jScrollPane4);
//        initTableData();
        filltable();
        setIconImage(ShareHelper.APP_ICON);
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<DatSPModel> list = daoSP.select();
            for (DatSPModel nv : list) {
                String ThoiGianThem = "";
                DecimalFormat df = new DecimalFormat("#,##0.##");
                if (nv.getThoiGianDat() != null) {
                    String dateString = nv.getThoiGianDat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), df.format(nv.getDonGia()), df.format(nv.getTongTien()), ThoiGianThem, nv.getMaNV()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

//    private void initTableData() {
//        EventAction eventAction = new EventAction() {
//            @Override
//            public void delete(ModelStudent student) {
//
//                JOptionPane.showMessageDialog(rootPane, "Đặng Hoàng Tuấn");
//
//            }
//
//            @Override
//            public void update(ModelStudent student) {
//                JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn in hóa đơn này không?");
//            }
//        };
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg")), "Tuấn", "Nam", "Java", 200).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile1.jpg")), "Bình", "Nam", "C++", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "An", "Nữ", "C#", 400).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Thành", "Nam", "C#", 600).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bảo", "Nam", "C#", 800).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Lê", "Nữ", "C#", 400).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Ngọc", "Nữ", "C#", 100).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Anh", "Nữ", "C#", 600).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Vũ", "Nam", "C#", 400).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Đại", "Đại", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Hoa", "Nữ", "C#", 100).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Trân", "Nữ", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Yến", "Nữ", "C#", 700).toRowTable(eventAction));
//    }
    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        button2 = new com.DuAn1.Swing.Button();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUser = new javaswingdev.swing.table.Table();
        cboThoiGian = new com.DuAn1.Swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách đặt hàng ");

        txtTimKiem.setToolTipText("");
        txtTimKiem.setHint("Tìm kiếm");
        txtTimKiem.setName(""); // NOI18N
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

        button2.setText("Tìm kiếm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ĐH", "Số lượng", "Số điện thoại", "Đơn giá", "Tổng tiền", "Thời gian đặt", "Mã NV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblUser);

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hôm nay", "Tuan này", "Tháng này" }));
        cboThoiGian.setSelectedIndex(-1);
        cboThoiGian.setLabeText("Thời gian");
        cboThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int chon = tblUser.getSelectedRow();
        String name = (String) tblUser.getValueAt(chon, 0);
        String soLuong = (String) tblUser.getValueAt(chon, 1);
        String SDT = (String) tblUser.getValueAt(chon, 2);

        String gia = (String) tblUser.getValueAt(chon, 3);
        gia = gia.replace(",", "");
        String donGia = String.valueOf(Double.parseDouble(gia));

        String tien = (String) tblUser.getValueAt(chon, 4);
        tien = tien.replace(",", "");
        String tongtien = String.valueOf(Double.parseDouble(tien));

        String ThoiGian = (String) tblUser.getValueAt(chon, 5);
        DanhSachDH.setTongTien(Double.parseDouble(tongtien));
        DanhSachDH.setSoLuong(Integer.parseInt(soLuong));
        DanhSachDH.setDonGia(Double.parseDouble(donGia));
        DanhSachDH.setSDT(SDT.trim());
        DanhSachDH.setName1(name);
        DanhSachDH.setNgay(ThoiGian);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void cboThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianActionPerformed
        // TODO add your handling code here:
        if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<DatSPModel> list = daoSP.selectHomNay();

                for (DatSPModel nv : list) {
                    String ThoiGianThem = "";
                    DecimalFormat df = new DecimalFormat("#,##0.##");
                    if (nv.getThoiGianDat() != null) {
                        String dateString = nv.getThoiGianDat();
                        Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                        ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                    }
                    Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), df.format(nv.getDonGia()), df.format(nv.getTongTien()), ThoiGianThem, nv.getMaNV()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }else if(cboThoiGian.getSelectedItem().equals("Tuan này")){
              tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<DatSPModel> list = daoSP.selectTuanNay();

                for (DatSPModel nv : list) {
                    String ThoiGianThem = "";
                    DecimalFormat df = new DecimalFormat("#,##0.##");
                    if (nv.getThoiGianDat() != null) {
                        String dateString = nv.getThoiGianDat();
                        Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                        ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                    }
                    Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), df.format(nv.getDonGia()), df.format(nv.getTongTien()), ThoiGianThem, nv.getMaNV()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }else if(cboThoiGian.getSelectedItem().equals("Tháng này")){
              tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<DatSPModel> list = daoSP.selectThangNay();

                for (DatSPModel nv : list) {
                    String ThoiGianThem = "";
                    DecimalFormat df = new DecimalFormat("#,##0.##");
                    if (nv.getThoiGianDat() != null) {
                        String dateString = nv.getThoiGianDat();
                        Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                        ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                    }
                    Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), df.format(nv.getDonGia()), df.format(nv.getTongTien()), ThoiGianThem, nv.getMaNV()};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_cboThoiGianActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DanhSachDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachDH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachDH dialog = new DanhSachDH(new javax.swing.JFrame(), true);
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
    private com.DuAn1.Swing.Combobox cboThoiGian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

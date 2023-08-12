/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.HoaDonDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.HoaDonModel;
import com.DuAn1.Model.KhachHangModel;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class KhachHangBaoHanh extends javax.swing.JDialog {

    DefaultTableModel tblModel;
      public static String MaKH = "";

    public static String getMaKH() {
        return MaKH;
    }

    public static void setMaKH(String MaKH) {
        KhachHangBaoHanh.MaKH = MaKH;
    }

 
    KhachHangDAO daoKH = new KhachHangDAO();
    HoaDonDAO daoHD = new HoaDonDAO();
    public KhachHangBaoHanh(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tieude();
 
        setLocationRelativeTo(null);
        setIconImage(ShareHelper.APP_ICON);
        loadCombobox();
    }

    void tieude() {
        tblModel = new DefaultTableModel();
        String[] name = new String[]{"Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Ngày Sinh", "Địa Chỉ"};
        tblModel.setColumnIdentifiers(name);
        tblUser.setModel(tblModel);
    }
    ThongKeDao DaoThongKe = new ThongKeDao();
    public void loadCombobox(){
        List<Object[]> j = DaoThongKe.getlayKHDaMua();
        DefaultComboBoxModel tbl = new DefaultComboBoxModel();
//        List<HoaDonModel> list = daoHD.selectMaMua();
        for (Object[] objects : j) {
            tbl.addElement(Arrays.toString(objects).replace("[", "").replace("]",""));
        }
        cboHinhThuc.setModel(tbl);
        cboHinhThuc.setSelectedIndex(-1);
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<KhachHangModel> list = daoKH.selectMa((String) cboHinhThuc.getSelectedItem());
            for (KhachHangModel model : list) {
                   String ThoiGianThem = "";

                if (model.getNgaySinh()!= null) {
                    String dateString = model.getNgaySinh();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy").format(date0);
                }
                Object[] row = new Object[]{
                    
                    model.getMaKH(),
                    model.getTenKH(),
                    model.getSDT(),
                    ThoiGianThem,
                    model.getDiaChi(),
                    model.isGT() ? "Nam" : "Nữ",
                    model.getLoaiKH(),
                    model.isTrangThai(),
                    model.getMoTa(),
                    model.getMaNV(),
                    model.getHinh()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(jPanel1, "Lỗi truy vấn dữ liệu");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUser = new javaswingdev.swing.table.Table();
        txtTim = new com.DuAn1.Swing.TextField1();
        button2 = new com.DuAn1.Swing.Button();
        cboHinhThuc = new com.DuAn1.Swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã BH", "Mã ", "Số Emei", "Ngày bảo hành", "Ngày hết hạn", "Ghi Chú", "Mã KH"
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblUserMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(tblUser);

        txtTim.setToolTipText("");
        txtTim.setHint("Tìm kiếm");
        txtTim.setName(""); // NOI18N
        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        button2.setText("Tìm kiếm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        cboHinhThuc.setLabeText("Mã khách hàng đã mua");
        cboHinhThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
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

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int chon = tblUser.getSelectedRow();
        String maBH = (String) tblUser.getValueAt(chon, 0);
        KhachHangBaoHanh.setMaKH(maBH);
        ThongTinSPDaMua ThongTinKH = new ThongTinSPDaMua(com.DuAn1.main.Main.getMain(), true);
        ThongTinKH.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
//   
       if (txtTim.getText().equals("")) {
            this.filltable();
        } else {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<KhachHangModel> list = daoKH.TimKiemTheoMa(txtTim.getText());
                for (KhachHangModel model : list) {
                    Object[] row = new Object[]{model.getMaKH(),
                        model.getTenKH(),
                        model.getSDT(),
                        model.getNgaySinh(),
                        model.getDiaChi(),};
                    tblModel.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_txtTimCaretUpdate

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void cboHinhThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHinhThucActionPerformed
       filltable();        // TODO add your handling code here:
    }//GEN-LAST:event_cboHinhThucActionPerformed

    private void tblUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseEntered

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
            java.util.logging.Logger.getLogger(KhachHangBaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangBaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangBaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangBaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KhachHangBaoHanh dialog = new KhachHangBaoHanh(new javax.swing.JFrame(), true);
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
    private com.DuAn1.Swing.Combobox cboHinhThuc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 txtTim;
    // End of variables declaration//GEN-END:variables
}

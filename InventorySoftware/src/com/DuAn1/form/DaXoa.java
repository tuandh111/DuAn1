/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.DatSPCTDAO;
import com.DuAn1.Dao.DatSPDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.ThaoTacModel;
import com.tuandhpc05076.helper.DialogHelper;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class DaXoa extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    DatSPDAO daoSP = new DatSPDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    DatSPDAO daoDatSP = new DatSPDAO();
    DatSPCTDAO daoDatSPCT = new DatSPCTDAO();
    ThongKeDao daoThongKe = new ThongKeDao();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();

    /**
     * Creates new form DaXoa
     */
    public DaXoa() {
        initComponents();
        filltable();
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<DatSPModel> list = daoSP.selectDaXoa();
            for (DatSPModel nv : list) {
                String formattedDate = "";
                if (nv.getThoiGianDat()!=null) {
                  String   dateString = nv.getThoiGianDat();
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date);
                }
                Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), nv.getDonGia(), nv.getTongTien(), formattedDate, nv.getMaNV()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void them() {
        int chon = tblUser.getSelectedRow();

        if (chon < 0) {
            DialogHelper.alert(this, "Bạn chưa chọn danh sách trong bảng để khôi phục");
            return;
        }
        String MaDH = (String) tblUser.getValueAt(chon, 0);
        try {

            daoDatSP.KhoiPhuc(MaDH);
            filltable();
            ThaoTacModel ThaoTacModel = getFormThem();
            daoThaoTac.insert(ThaoTacModel);
            com.DuAn1.Helper.DialogHelper.alert(this, "Khôi phục thành công");
        } catch (Exception e) {
            e.printStackTrace();
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi khôi phục dữ liệu");
        }
    }

    public ThaoTacModel getFormThem() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);

        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Khôi phục Đặt hàng");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTimKiem = new com.DuAn1.Swing.TextField1();
        button1 = new com.DuAn1.Swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setHint("Tìm kiếm");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        button1.setBackground(new java.awt.Color(51, 153, 255));
        button1.setText("Khôi phục ");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ĐH", "Số lượng", "SĐT", "Đơn giá", "Tổng tiền", "Thời gian đặt", "Mã nhân viên"
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
        jScrollPane1.setViewportView(tblUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(461, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
//        int chon = tblUser.getSelectedRow();
//        String name = (String) tblUser.getValueAt(chon, 0);
//        String soLuong = (String) tblUser.getValueAt(chon, 1);
//        String SDT = (String) tblUser.getValueAt(chon, 2);
//        String donGia = (String) tblUser.getValueAt(chon, 3);
//        String tongTien = (String) tblUser.getValueAt(chon, 4);
//        String ThoiGian = (String) tblUser.getValueAt(chon, 5);
//        DanhSachDH.setTongTien(Double.parseDouble(tongTien));
//        DanhSachDH.setSoLuong(Integer.parseInt(soLuong));
//        DanhSachDH.setDonGia(Double.parseDouble(donGia));
//        DanhSachDH.setSDT(SDT);
//        DanhSachDH.setName1(name);
//        DanhSachDH.setNgay(ThoiGian);
//        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        them();


    }//GEN-LAST:event_button1ActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:

        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<DatSPModel> list = daoSP.selectDaXoaTheoMa(txtTimKiem.getText());
            for (DatSPModel nv : list) {
                Object[] row = new Object[]{nv.getMaDH(), nv.getSoLuong(), nv.getSDT(), nv.getDonGia(), nv.getTongTien(), nv.getThoiGianDat(), nv.getMaNV()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }

    }//GEN-LAST:event_txtTimKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button button1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

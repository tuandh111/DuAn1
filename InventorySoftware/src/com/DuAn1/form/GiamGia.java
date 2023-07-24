/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.GiamGiaDao;
import com.DuAn1.Model.GiamGiaModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class GiamGia extends javax.swing.JPanel {

    DefaultTableModel model;
    GiamGiaDao Dao = new GiamGiaDao();
    int row = -1;

    /**
     * Creates new form GiamGia
     */
    public GiamGia() {
        initComponents();
        this.row = -1;
        this.tieude();
        this.filltable();
    }

    void tieude() {
        model = new DefaultTableModel();
        String[] name = new String[]{"Mã Giảm Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Phần Trăm", "Mô Tả", "Trạng Thái", "Mã Nhân Viên"};
        model.setColumnIdentifiers(name);
        tblGiamgia.setModel(model);
    }

    void filltable() {
        model = (DefaultTableModel) tblGiamgia.getModel();
        model.setRowCount(0);
        try {
            List<GiamGiaModel> list = Dao.select();
            System.out.println(list.size());
            for (GiamGiaModel nv : list) {
                Object[] row = new Object[]{nv.getMaGG(), nv.getNgayBD(), nv.getNgayKT(), nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn Khuyến Mại" : "Hết Khuyến Mại", nv.getMaNV()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void insert() {
        GiamGiaModel nv = getForm();
        try {
            Dao.insert(nv);
            this.filltable();
            this.ClearForm();
            JOptionPane.showMessageDialog(this, "Thêm Mới thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        GiamGiaModel nv = getForm();
        try {
            Dao.update(nv);
            this.filltable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật mới thất bại!");
        }
    }

    void delete() {

    }

    GiamGiaModel getForm() {
        GiamGiaModel nv = new GiamGiaModel();
        nv.setMaNV(txtTaikhoan.getText());
        nv.setHoTen(txtHoten.getText());
        nv.setNgaySinh(txtNgaysinh.getText());
        if (cboGioitinh.getSelectedItem().equals("Nam")) {
            nv.setGioiTinh(true);
        } else {
            nv.setGioiTinh(false);
        }
        nv.setDiaChi(txtDiachi.getText());
        nv.setSDT(txtSdt.getText());
        nv.setEmail(txtEmail.getText());
        nv.setMatKhau(txtMatkhau.getText());
        if (cboVaitro.getSelectedItem().equals("Quản lý")) {
            nv.setVaiTro("QL");
        } else {
            nv.setVaiTro("NV");
        }
        nv.setHinh(txtHinhAnh1.getToolTipText());
        nv.setTrangThai(true);
        if (btnTrangthai.isSelected()) {
            nv.setTrangThai(true);
        } else {
            nv.setTrangThai(false);
        }
        return nv;
    }

    void setForm(GiamGiaModel nv) {
        txtTaikhoan.setText(nv.getMaNV());
        txtHoten.setText(nv.getHoTen());
        txtNgaysinh.setText(nv.getNgaySinh());
        cboGioitinh.setSelectedItem(nv.isGioiTinh() ? "Nam" : "Nữ");
        txtDiachi.setText(nv.getDiaChi());
        txtSdt.setText(nv.getSDT());
        txtEmail.setText(nv.getEmail());
        txtMatkhau.setText(nv.getMatKhau());
        if (nv.getVaiTro().trim().equalsIgnoreCase("QL")) {
            cboVaitro.setSelectedIndex(0);
        } else {
            cboVaitro.setSelectedItem("Nhân Viên");
        }
        if (nv.getHinh() != "null") {
            txtHinhAnh1.setToolTipText(nv.getHinh());
            txtHinhAnh1.setIcon(ShareHelper.readLogo(nv.getHinh()));
        }

        if (nv.isTrangThai()) {
            btnTrangthai.setSelectedAnimate(true);
            txtTrangthai.setText("Đang hoạt động");
        } else {
            btnTrangthai.setSelectedAnimate(false);
            txtTrangthai.setText("Không hoạt động");
        }
    }

    void ClearForm() {
        cboLoaiSP.setSelectedItem("");
        cboSanpham.setSelectedItem("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
        txtPhantram.setText("");
        txtMota.setText("");
        cboLoc.setSelectedItem("");
    }

    void edit() {
        String manv = (String) tblGiamgia.getValueAt(this.row, 0);
        GiamGiaModel nv = Dao.findById(manv);
        this.setForm(nv);
        this.updateStatus();
    }

    void first() {
        this.row = 0;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        if (this.row < tblGiamgia.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblGiamgia.getRowCount() - 1;
        this.edit();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblGiamgia.getRowCount() - 1);
        cboLoaiSP.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiamgia = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        cboSanpham = new com.DuAn1.Swing.Combobox();
        cboLoaiSP = new com.DuAn1.Swing.Combobox();
        txtNgayBD = new com.DuAn1.Swing.TextField();
        txtNgayKT = new com.DuAn1.Swing.TextField();
        txtMota = new com.DuAn1.Swing.TextField();
        txtPhantram = new com.DuAn1.Swing.TextField();
        cboLoc = new com.DuAn1.Swing.Combobox();
        txtTim = new com.DuAn1.Swing.TextField1();
        jPanel2 = new javax.swing.JPanel();
        btnSua = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        btnMoi = new com.DuAn1.Swing.Button();
        btnTim = new com.DuAn1.Swing.Button();

        setMinimumSize(new java.awt.Dimension(1058, 741));
        setPreferredSize(new java.awt.Dimension(1058, 741));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1058, 741));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 741));

        tblGiamgia.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGiamgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGiamgiaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGiamgia);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Giảm giá");

        cboSanpham.setLabeText("Sản phẩm");

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IPHONE", "SAMSUNG", "SONY" }));
        cboLoaiSP.setSelectedIndex(-1);
        cboLoaiSP.setLabeText("Loại sản phẩm");

        txtNgayBD.setLabelText("Ngày bắt đầu");

        txtNgayKT.setLabelText("Ngày kết thúc");

        txtMota.setLabelText("Mô tả");

        txtPhantram.setLabelText("Phần trăm giảm giá");

        cboLoc.setLabeText("Lọc ");
        cboLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocActionPerformed(evt);
            }
        });

        txtTim.setHint("Tìm kiếm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        btnTim.setBackground(new java.awt.Color(153, 153, 255));
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(794, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblGiamgiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiamgiaMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblGiamgia.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblGiamgiaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnTim;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Combobox cboLoaiSP;
    private com.DuAn1.Swing.Combobox cboLoc;
    private com.DuAn1.Swing.Combobox cboSanpham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblGiamgia;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgayBD;
    private com.DuAn1.Swing.TextField txtNgayKT;
    private com.DuAn1.Swing.TextField txtPhantram;
    private com.DuAn1.Swing.TextField1 txtTim;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.ThanhToanLuongDAO;
import com.DuAn1.Model.ThanhToanLuongModel;
import com.tuandhpc05076.helper.DateHelper;
import com.tuandhpc05076.helper.DialogHelper;
import java.awt.Color;
import java.awt.geom.Path2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class ThanhToanLuong extends javax.swing.JPanel {

    ThanhToanLuongDAO dao = new ThanhToanLuongDAO();
    int row = -1;

    /**
     * Creates new form GiamGia
     */
    public ThanhToanLuong() {
        initComponents();
        tblThanhToanLuong.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblThanhToanLuong.getColumnModel().getColumn(1).setPreferredWidth(40);
        fillTable();
    }

    void fillTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblThanhToanLuong.getModel();
        tblModel.setRowCount(0);
        try {
            List<ThanhToanLuongModel> list = dao.select();
            for (ThanhToanLuongModel ttl : list) {
                Object[] rows = {ttl.getMaLuong(), ttl.getSoNgayLam(), ttl.getLuongCoBan(), ttl.getNgayVaoCTy(), ttl.getSoGioTangCa(), ttl.getLuongTangCa(), ttl.getKhoanTru(),
                    ttl.getTongTien(), ttl.isTrangThai()};
                tblModel.addRow(rows);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            e.printStackTrace();
        }
    }

    void setForm(ThanhToanLuongModel ttl) {
        txtMaLuong.setText(ttl.getMaLuong());
        txtLuongCoBan.setText(String.valueOf(ttl.getLuongCoBan()));
        txtSoNgayLamViec.setText(String.valueOf(ttl.getSoNgayLam()));
        txtNgayVaoCTY.setText(String.valueOf(ttl.getNgayVaoCTy()));
        txtSoHTangCa.setText(String.valueOf(ttl.getSoGioTangCa()));
        txtLuongTangCa.setText(String.valueOf(ttl.getLuongTangCa()));
        txtKhoangTru.setText(String.valueOf(ttl.getKhoanTru()));
        lblTongTien.setText(String.valueOf(ttl.getTongTien()));
        if (ttl.isTrangThai()) {
            switchButton1.setSelectedAnimate(true);
            lblTrangThai.setText("Đã thanh toán");
        } else {
            switchButton1.setSelectedAnimate(false);
            lblTrangThai.setText("Chưa thanh toán");
        }
    }

    ThanhToanLuongModel getForm() {
        ThanhToanLuongModel ttl = new ThanhToanLuongModel();
        ttl.setMaLuong(txtMaLuong.getText());
        ttl.setLuongCoBan(Double.parseDouble(txtLuongCoBan.getText()));
        ttl.setSoNgayLam(Float.parseFloat(txtSoNgayLamViec.getText()));
        ttl.setNgayVaoCTy(DateHelper.toDate("dd-MM-yyyy", txtNgayVaoCTY.getText()));
        ttl.setSoGioTangCa(Float.parseFloat(txtSoHTangCa.getText()));
        ttl.setLuongTangCa(Double.parseDouble(txtLuongTangCa.getText()));
        ttl.setKhoanTru(Double.parseDouble(txtKhoangTru.getText()));
        ttl.setTongTien(Double.parseDouble(lblTongTien.getText()));
        ttl.setTrangThai(true);
        if (switchButton1.isSelected()) {
            ttl.setTrangThai(true);
        } else {
            ttl.setTrangThai(false);
        }

        return ttl;
    }

    void clearForm() {
        txtMaLuong.setText("");
        txtLuongCoBan.setText("");
        txtLuongTangCa.setText("");
        txtSoHTangCa.setText("");
        txtSoNgayLamViec.setText("");
        txtKhoangTru.setText("");
        txtNgayVaoCTY.setText("");
        lblTongTien.setText("0");
        lblTrangThai.setText("Chưa thanh toán ");
        lblTrangThai.setForeground(Color.red);

    }

    void UpdateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblThanhToanLuong.getRowCount() - 1);

        txtMaLuong.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    void edit() {
        String maLuong = (String) tblThanhToanLuong.getValueAt(this.row, 0);
        ThanhToanLuongModel ttl = dao.findById(maLuong);
        this.setForm(ttl);
        this.UpdateStatus();
    }

    boolean check() {
        if (txtMaLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã lương!");
            return false;
        } else if (txtLuongTangCa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lương cơ bản!");
            return false;
        } else if (txtSoNgayLamViec.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập số ngày làm việc!");
            return false;
        } else if (txtSoHTangCa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập số giờ tăng ca!");
            return false;
        } else if (txtLuongTangCa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập lương tăng ca!");
            return false;
        }
//    else if()
        return true;
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToanLuong = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        txtSoNgayLamViec = new com.DuAn1.Swing.TextField();
        txtLuongCoBan = new com.DuAn1.Swing.TextField();
        txtSoHTangCa = new com.DuAn1.Swing.TextField();
        txtMaLuong = new com.DuAn1.Swing.TextField();
        txtLuongTangCa = new com.DuAn1.Swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        switchButton1 = new com.DuAn1.swing0.SwitchButton();
        lblTrangThai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        cboLoc = new com.DuAn1.Swing.Combobox();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        btnSua1 = new com.DuAn1.Swing.Button();
        txtKhoangTru = new com.DuAn1.Swing.TextField();
        txtNgayVaoCTY = new com.DuAn1.Swing.TextField();

        dateChooser.setTextRefernce(txtNgayVaoCTY);

        setMinimumSize(new java.awt.Dimension(1058, 741));
        setPreferredSize(new java.awt.Dimension(1058, 741));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1058, 741));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 741));

        tblThanhToanLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lương", "Số ngày làm ", "Lương cơ bản", "Ngày vào CTY", "Số giờ tăng ca ", "Lương tăng ca ", "Khoảng trừ", "Tổng tiền ", "Trạng thái "
            }
        ));
        tblThanhToanLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhToanLuongMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThanhToanLuongMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblThanhToanLuong);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thanh toán lương");

        txtSoNgayLamViec.setLabelText("Số ngày làm việc");
        txtSoNgayLamViec.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoNgayLamViecCaretUpdate(evt);
            }
        });

        txtLuongCoBan.setLabelText("Lương cơ bản ");
        txtLuongCoBan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLuongCoBanCaretUpdate(evt);
            }
        });
        txtLuongCoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongCoBanActionPerformed(evt);
            }
        });

        txtSoHTangCa.setLabelText("Số giờ tăng ca ");
        txtSoHTangCa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoHTangCaCaretUpdate(evt);
            }
        });

        txtMaLuong.setLabelText("Mã số lương");

        txtLuongTangCa.setLabelText("Lương tăng ca");
        txtLuongTangCa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLuongTangCaCaretUpdate(evt);
            }
        });
        txtLuongTangCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongTangCaActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái:");

        switchButton1.setSelectedAnimate(false);
        switchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switchButton1MouseClicked(evt);
            }
        });

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(255, 0, 0));
        lblTrangThai.setText("Chưa thanh toán");

        jLabel4.setText("Tổng tiền: ");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 51));
        lblTongTien.setText("0");

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        cboLoc.setLabeText("Lọc ");

        txtTimKiem.setHint("Tìm kiếm");

        btnSua1.setBackground(new java.awt.Color(153, 153, 255));
        btnSua1.setText("Tìm kiếm");

        txtKhoangTru.setLabelText("Khoảng trừ");
        txtKhoangTru.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtKhoangTruCaretUpdate(evt);
            }
        });
        txtKhoangTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhoangTruActionPerformed(evt);
            }
        });

        txtNgayVaoCTY.setLabelText("Ngày vào CTY");
        txtNgayVaoCTY.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayVaoCTYMouseClicked(evt);
            }
        });
        txtNgayVaoCTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayVaoCTYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoHTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtKhoangTru, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblTrangThai))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtLuongTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(63, 63, 63)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblTongTien))
                                            .addComponent(txtNgayVaoCTY, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayVaoCTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLuongCoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoHTangCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKhoangTru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangThai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblTongTien))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void switchButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_switchButton1MouseClicked
        // TODO add your handling code here:
        if (!switchButton1.isSelected()) {
            lblTrangThai.setText("Đã thanh toán");
            lblTrangThai.setForeground(Color.green);
        } else {
            lblTrangThai.setText("Chưa thanh toán");
            lblTrangThai.setForeground(Color.red);
        }
    }//GEN-LAST:event_switchButton1MouseClicked

    private void txtLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongCoBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongCoBanActionPerformed

    private void txtLuongCoBanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLuongCoBanCaretUpdate
        // TODO add your handling code here:
        double tongTien = 1;
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_txtLuongCoBanCaretUpdate

    private void tblThanhToanLuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanLuongMousePressed
//         TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblThanhToanLuong.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblThanhToanLuongMousePressed
    void them() {
        ThanhToanLuongModel ttl = getForm();
        try {
            dao.insert(ttl);
            fillTable();
            clearForm();
            DialogHelper.alert(this, "Thêm mới thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm mới thất bại");

        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSoNgayLamViecCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoNgayLamViecCaretUpdate
        // TODO add your handling code here:
        double tongTien = 1;
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_txtSoNgayLamViecCaretUpdate

    private void txtKhoangTruCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhoangTruCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txtKhoangTruCaretUpdate

    private void txtKhoangTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhoangTruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhoangTruActionPerformed

    private void txtNgayVaoCTYMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayVaoCTYMouseClicked
        dateChooser.showPopup();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayVaoCTYMouseClicked

    private void txtNgayVaoCTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayVaoCTYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayVaoCTYActionPerformed

    private void txtLuongTangCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongTangCaActionPerformed
        // TODO add your handling code here:   

    }//GEN-LAST:event_txtLuongTangCaActionPerformed

    private void txtLuongTangCaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLuongTangCaCaretUpdate
        // TODO add your handling code here:
        double tongTien = 0;
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText())
                + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());

        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_txtLuongTangCaCaretUpdate

    private void txtSoHTangCaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoHTangCaCaretUpdate
        // TODO add your handling code here:
        double tongTien = 0;
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText())
                + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());

        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_txtSoHTangCaCaretUpdate
    void sua() {
        ThanhToanLuongModel ttl = getForm();
        try {
            dao.update(ttl);
            this.fillTable();
            this.clearForm();
            DialogHelper.alert(this, " Cập nhật thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, " Cập nhật thất bại");
        }
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        sua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblThanhToanLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanLuongMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblThanhToanLuong.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblThanhToanLuongMouseClicked
void xoa(){
    String maluong = txtMaLuong.getText();
         if(DialogHelper.confirm(this, "Bạn muốn xóa chuyên đề này?")){
            try {
                dao.delete(maluong);
                this.fillTable();
                this.clearForm();
                DialogHelper.alert(this, "Xóa  thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                DialogHelper.alert(this, "Xóa  thất bại!");
            }
            }
}
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnSua1;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Combobox cboLoc;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private com.DuAn1.swing0.SwitchButton switchButton1;
    private com.raven.swing.table.Table tblThanhToanLuong;
    private com.DuAn1.Swing.TextField txtKhoangTru;
    private com.DuAn1.Swing.TextField txtLuongCoBan;
    private com.DuAn1.Swing.TextField txtLuongTangCa;
    private com.DuAn1.Swing.TextField txtMaLuong;
    private com.DuAn1.Swing.TextField txtNgayVaoCTY;
    private com.DuAn1.Swing.TextField txtSoHTangCa;
    private com.DuAn1.Swing.TextField txtSoNgayLamViec;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.NhanVienModel;
import com.tuandhpc05076.Form.ChuyenDe;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class NhanVien extends javax.swing.JPanel {

    DefaultTableModel model;
    NhanVienDAO1 Dao = new NhanVienDAO1();
    int row = -1;

    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        txtNgaysinh.setText("1-1-2000");
        this.row = -1;
        this.tieude();
        this.filltable();
    }

    void tieude() {
        model = new DefaultTableModel();
        String[] name = new String[]{"Mã Nhân Viên", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Email", "Mật Khẩu",
            "Mã Vai Trò", "Hình", "Trạng Thái"};
        model.setColumnIdentifiers(name);
        tblNhanvien.setModel(model);
    }

    void filltable() {
        model = (DefaultTableModel) tblNhanvien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVienModel> list = Dao.select();
            System.out.println(list.size());
            for (NhanVienModel nv : list) {
                Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(), nv.getSDT(), nv.getEmail(), nv.getMatKhau(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void insert() {
        NhanVienModel nv = getForm();
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
        NhanVienModel nv = getForm();
        try {
            Dao.update(nv);
            this.filltable();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật mới thất bại!");
        }
    }

    void delete() {
        NhanVienModel nv = getForm();
        try {
            Dao.delete(nv);
            this.filltable();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    NhanVienModel getForm() {
        NhanVienModel nv = new NhanVienModel();
        nv.setMaNV(txtTaikhoan.getText());
        nv.setHoTen(txtHoten.getText());
        nv.setNgaySinh(txtNgaysinh.getText());
        if(cboGioitinh.getSelectedItem().equals("Nam")){
            nv.setGioiTinh(true);
        }else{
            nv.setGioiTinh(false);
        }
        nv.setDiaChi(txtDiachi.getText());
        nv.setSDT(txtSdt.getText());
        nv.setEmail(txtEmail.getText());
        nv.setMatKhau(txtMatkhau.getText());
        if(cboVaitro.getSelectedItem().equals("Quản lý")){
            nv.setVaiTro("QL");
        }else{
            nv.setVaiTro("NV");
        }
        nv.setHinh(txtHinhAnh1.getToolTipText());
        nv.setTrangThai(true);
        if(btnTrangthai.isSelected()){
            nv.setTrangThai(true);
        }else{
            nv.setTrangThai(false);
        }
        return nv;
    }

    void setForm(NhanVienModel nv) {
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
        
        if(nv.isTrangThai()){
            btnTrangthai.setSelectedAnimate(true);
            txtTrangthai.setText("Đang hoạt động");
        }else{
            btnTrangthai.setSelectedAnimate(false);
            txtTrangthai.setText("Không hoạt động");
        }
    }

    void ClearForm() {
        txtTaikhoan.setText("");
        txtHoten.setText("");
        txtNgaysinh.setText("");
        cboGioitinh.setSelectedItem("Nam");
        txtDiachi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtMatkhau.setText("");
        cboVaitro.setSelectedItem("Quản Lý");
        txtHinhAnh1.setToolTipText("null");
    }

    void edit() {
        String manv = (String) tblNhanvien.getValueAt(this.row, 0);
        NhanVienModel nv = Dao.findById(manv);
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
        if (this.row < tblNhanvien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblNhanvien.getRowCount() - 1;
        this.edit();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhanvien.getRowCount() - 1);
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

        dateChooser = new com.raven.datechooser.DateChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanvien = new com.raven.swing.table.Table();
        txtNgaysinh = new com.DuAn1.Swing.TextField();
        txtMatkhau = new com.DuAn1.Swing.TextField();
        txtEmail = new com.DuAn1.Swing.TextField();
        txtDiachi = new com.DuAn1.Swing.TextField();
        txtTaikhoan = new com.DuAn1.Swing.TextField();
        cboVaitro = new com.DuAn1.Swing.Combobox();
        cboGioitinh = new com.DuAn1.Swing.Combobox();
        txtHoten = new com.DuAn1.Swing.TextField();
        txtSdt = new com.DuAn1.Swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnTrangthai = new com.DuAn1.swing0.SwitchButton();
        txtTrangthai = new javax.swing.JLabel();
        btnTaianh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        txtTim = new com.DuAn1.Swing.TextField1();
        txtHinh1 = new swing.PanelShadow();
        txtHinhAnh1 = new javax.swing.JLabel();

        dateChooser.setTextRefernce(txtNgaysinh);

        setBackground(new java.awt.Color(255, 255, 255));

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd", "sdfds", "sdfs"},
                {"sdf", "sdfs", "sdf", "sdf"},
                {"dsf", "sdf", "sdf", null},
                {null, null, null, null}
            },
            new String [] {
                "sdfsdf", "sdfds", "Title 3sdfsdf", "Title 4"
            }
        ));
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanvienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanvien);

        txtNgaysinh.setLabelText("Ngày sinh");
        txtNgaysinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaysinhMouseClicked(evt);
            }
        });
        txtNgaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaysinhActionPerformed(evt);
            }
        });

        txtMatkhau.setLabelText("Mật khẩu");
        txtMatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMatkhauMouseClicked(evt);
            }
        });

        txtEmail.setLabelText("Email");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });

        txtDiachi.setLabelText("Địa chỉ");
        txtDiachi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDiachiMouseClicked(evt);
            }
        });

        txtTaikhoan.setLabelText("Tài khoản");
        txtTaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTaikhoanMouseClicked(evt);
            }
        });

        cboVaitro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản lý", "Nhân Viên" }));
        cboVaitro.setSelectedIndex(-1);
        cboVaitro.setLabeText("Vai trò");

        cboGioitinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
        cboGioitinh.setSelectedIndex(-1);
        cboGioitinh.setLabeText("Giới tính");
        cboGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioitinhActionPerformed(evt);
            }
        });

        txtHoten.setLabelText("Họ tên");
        txtHoten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHotenMouseClicked(evt);
            }
        });

        txtSdt.setLabelText("Số điện thoại");
        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSdtMouseClicked(evt);
            }
        });

        jLabel1.setText("Trạng thái:");

        btnTrangthai.setSelectedAnimate(false);

        txtTrangthai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTrangthai.setForeground(new java.awt.Color(0, 204, 51));
        txtTrangthai.setText("Đang hoạt động");

        btnTaianh.setText("Tải hình ảnh");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nhân Viên");

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

        txtTim.setHint("Tìm kiếm");

        txtHinh1.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinh1MouseClicked(evt);
            }
        });
        txtHinh1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh1.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh1.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnh1MouseClicked(evt);
            }
        });
        txtHinh1.add(txtHinhAnh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(txtHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(btnTaianh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(8, 8, 8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTaianh)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrangthai)))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaysinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaysinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhMouseClicked

    private void txtMatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatkhauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatkhauMouseClicked

    private void txtNgaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaysinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtDiachiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiachiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiachiMouseClicked

    private void txtTaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTaikhoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaikhoanMouseClicked

    private void cboGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGioitinhActionPerformed

    private void txtHotenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHotenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenMouseClicked

    private void txtSdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSdtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void tblNhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblNhanvien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanvienMousePressed
    String strHinh = null;
    private void txtHinh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinh1MouseClicked
//        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                // Hiển thị hình lên form
//                Image img = null;
//                try {
//                    img = ImageIO.read(file);
//                } catch (IOException ex) {
//                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                strHinh = file.getName();
//                txtHinhAnh.setText("");
//
//                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
//                txtHinhAnh.setToolTipText(file.getName());
//                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
//            }
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinh1MouseClicked

    private void txtHinhAnh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnh1MouseClicked
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
                txtHinhAnh1.setText("null");

                txtHinhAnh1.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh1.setToolTipText(file.getName());
                txtHinhAnh1.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnh1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private javax.swing.JButton btnTaianh;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.swing0.SwitchButton btnTrangthai;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Combobox cboGioitinh;
    private com.DuAn1.Swing.Combobox cboVaitro;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblNhanvien;
    private com.DuAn1.Swing.TextField txtDiachi;
    private com.DuAn1.Swing.TextField txtEmail;
    private swing.PanelShadow txtHinh;
    private swing.PanelShadow txtHinh1;
    private javax.swing.JLabel txtHinhAnh;
    private javax.swing.JLabel txtHinhAnh1;
    private com.DuAn1.Swing.TextField txtHoten;
    private com.DuAn1.Swing.TextField txtMatkhau;
    private com.DuAn1.Swing.TextField txtNgaysinh;
    private com.DuAn1.Swing.TextField txtSdt;
    private com.DuAn1.Swing.TextField txtTaikhoan;
    private com.DuAn1.Swing.TextField1 txtTim;
    private javax.swing.JLabel txtTrangthai;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThaoTacModel;
import com.tuandhpc05076.helper.DialogHelper;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class LichSu extends javax.swing.JPanel {

    NhanVienDAO1 dao = new NhanVienDAO1();
    ThaoTacDAO daoThaoTac = new ThaoTacDAO();

    public LichSu() {
        initComponents();
        LoadComboboxNV();
        fillToTable();
    }

    void LoadComboboxNV() {
        DefaultComboBoxModel cboNV = new DefaultComboBoxModel();
        ArrayList<NhanVienModel> list = (ArrayList<NhanVienModel>) dao.select();
        for (NhanVienModel nhanVienModel : list) {
            cboNV.addElement(nhanVienModel.getMaNV().trim() + '-' + nhanVienModel.getHoTen().trim());
        }
        cboNhanVien.setModel(cboNV);
        cboNhanVien.setSelectedIndex(-1);

    }

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        try {
            List<ThaoTacModel> list = daoThaoTac.select();
            for (ThaoTacModel nv : list) {
                Object[] row = {
                    nv.getID(),
                    nv.getThoiGianThem(),
                    nv.getThoiGianSua(),
                    nv.getThoiGianXoa(),
                    nv.getThoIGianHoatDong(),
                    nv.getBanThaoTac(),
                    nv.getMaNV()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javaswingdev.swing.table.Table();
        textField11 = new com.DuAn1.Swing.TextField1();
        button1 = new com.DuAn1.Swing.Button();
        cboNhanVien = new com.DuAn1.Swing.Combobox();
        cboBangThaoTac = new com.DuAn1.Swing.Combobox();
        cboThoiGian = new com.DuAn1.Swing.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Thời gian thêm", "Thời gian sửa", "Thời gian xóa", "Thời gian hoạt động", "Bảng thao tác", "Nhân viên thực hiện"
            }
        ));
        jScrollPane1.setViewportView(tblUser);

        textField11.setHint("Tìm kiếm");

        button1.setBackground(new java.awt.Color(51, 153, 255));
        button1.setText("Tìm kiếm");

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cboNhanVien.setSelectedIndex(-1);
        cboNhanVien.setLabeText("Nhân viên");
        cboNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNhanVienMouseClicked(evt);
            }
        });
        cboNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienActionPerformed(evt);
            }
        });

        cboBangThaoTac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sản Phẩm", "Nhân viên", "Thanh toán lương", "Hóa Đơn", "Đặt hàng", "Bảo hành", "Đăng nhập" }));
        cboBangThaoTac.setSelectedIndex(-1);
        cboBangThaoTac.setLabeText("Bảng thao tác");
        cboBangThaoTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBangThaoTacActionPerformed(evt);
            }
        });

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hôm nay", "Tuần này", "Tháng này", "Năm này" }));
        cboThoiGian.setSelectedIndex(-1);
        cboThoiGian.setLabeText("Thời gian");
        cboThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboThoiGian, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(cboBangThaoTac, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBangThaoTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboBangThaoTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBangThaoTacActionPerformed
        // TODO add your handling code here:
        String BangThaoTac = (String) cboBangThaoTac.getSelectedItem();
        String MaNV = (String) cboNhanVien.getSelectedItem();
        String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
            try {
                List<ThaoTacModel> list = daoThaoTac.selectDieuKien(maNVTrim, BangThaoTac);
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else if (cboThoiGian.getSelectedItem().equals("Tuần này")) {
            try {
                List<ThaoTacModel> list = daoThaoTac.selectDieuKienTuanNay(maNVTrim, BangThaoTac);
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else if (cboThoiGian.getSelectedItem().equals("Tháng này")) {
            try {
                List<ThaoTacModel> list = daoThaoTac.selectDieuKienThangNay(maNVTrim, BangThaoTac);
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            try {
                List<ThaoTacModel> list = daoThaoTac.selectDieuKienNamNay(maNVTrim, BangThaoTac);
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        }
    }//GEN-LAST:event_cboBangThaoTacActionPerformed

    private void cboNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienActionPerformed
        // TODO add your handling code here:   

        if (cboThoiGian.getSelectedItem() == null) {
            return;
        }
        if (cboBangThaoTac.getSelectedItem() == null) {
            if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
                if (cboNhanVien.getSelectedItem() == null) {
                    return;
                }
                String MaNV = (String) cboNhanVien.getSelectedItem();
                String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
                DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                model.setRowCount(0);
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienMa(maNVTrim);
                    System.out.println(list.size());
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else if (cboThoiGian.getSelectedItem().equals("Tuần này")) {
                if (cboNhanVien.getSelectedItem() == null) {
                    return;
                }
                String MaNV = (String) cboNhanVien.getSelectedItem();
                String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
                DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                model.setRowCount(0);
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienMaTuan(maNVTrim);
                    System.out.println(list.size());
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else if (cboThoiGian.getSelectedItem().equals("Tháng này")) {
                if (cboNhanVien.getSelectedItem() == null) {
                    return;
                }
                String MaNV = (String) cboNhanVien.getSelectedItem();
                System.out.println(MaNV);
                String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
                DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                model.setRowCount(0);
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienMaThang(maNVTrim);
                    System.out.println(list.size());
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else {
                if (cboNhanVien.getSelectedItem() == null) {
                    return;
                }
                String MaNV = (String) cboNhanVien.getSelectedItem();
                String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
                DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                model.setRowCount(0);
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienMaNam(maNVTrim);
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            }
        } else {
            if (cboNhanVien.getSelectedItem() == null) {
                return;
            }
            if (cboBangThaoTac.getSelectedItem() == null) {
                return;
            }
            String BangThaoTac = (String) cboBangThaoTac.getSelectedItem();
            String MaNV = (String) cboNhanVien.getSelectedItem();
            String maNVTrim = MaNV.substring(0, MaNV.indexOf("-"));
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKien(maNVTrim, BangThaoTac);
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else if (cboThoiGian.getSelectedItem().equals("Tuần này")) {
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienTuanNay(maNVTrim, BangThaoTac);
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else if (cboThoiGian.getSelectedItem().equals("Tháng này")) {
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienThangNay(maNVTrim, BangThaoTac);
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            } else {
                try {
                    List<ThaoTacModel> list = daoThaoTac.selectDieuKienNamNay(maNVTrim, BangThaoTac);
                    for (ThaoTacModel nv : list) {
                        Object[] row = {
                            nv.getID(),
                            nv.getThoiGianThem(),
                            nv.getThoiGianSua(),
                            nv.getThoiGianXoa(),
                            nv.getThoIGianHoatDong(),
                            nv.getBanThaoTac(),
                            nv.getMaNV()
                        };
                        model.addRow(row);

                    }
                } catch (Exception e) {
                    com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
                }
            }
        }
    }//GEN-LAST:event_cboNhanVienActionPerformed

    private void cboNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhanVienMouseClicked

    private void cboThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianActionPerformed

        if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            try {
                List<ThaoTacModel> list = daoThaoTac.selectHomNay();
                System.out.println(list.size());
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else if (cboThoiGian.getSelectedItem().equals("Tháng này")) {
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            try {
                List<ThaoTacModel> list = daoThaoTac.selectThangNay();
                System.out.println(list.size());
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else if (cboThoiGian.getSelectedItem().equals("Tuần này")) {
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            try {
                List<ThaoTacModel> list = daoThaoTac.selectTuanNay();
                System.out.println(list.size());
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
            model.setRowCount(0);
            try {
                List<ThaoTacModel> list = daoThaoTac.selectNamNay();
                System.out.println(list.size());
                for (ThaoTacModel nv : list) {
                    Object[] row = {
                        nv.getID(),
                        nv.getThoiGianThem(),
                        nv.getThoiGianSua(),
                        nv.getThoiGianXoa(),
                        nv.getThoIGianHoatDong(),
                        nv.getBanThaoTac(),
                        nv.getMaNV()
                    };
                    model.addRow(row);

                }
            } catch (Exception e) {
                com.DuAn1.Helper.DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        }
        if (cboNhanVien.getSelectedItem() != null) {
            cboNhanVien.setSelectedIndex(-1);
        }
        if (cboBangThaoTac.getSelectedItem() != null) {
            cboBangThaoTac.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_cboThoiGianActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button button1;
    private com.DuAn1.Swing.Combobox cboBangThaoTac;
    private com.DuAn1.Swing.Combobox cboNhanVien;
    private com.DuAn1.Swing.Combobox cboThoiGian;
    private javax.swing.JScrollPane jScrollPane1;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 textField11;
    // End of variables declaration//GEN-END:variables
}

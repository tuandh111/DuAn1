/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template6
 */
package com.DuAn1.form;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThanhToanLuongDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.GiamGiaModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThanhToanLuongModel;
import com.DuAn1.Model.ThaoTacModel;
import com.tuandhpc05076.Dao.NhanVienDAO;
import com.tuandhpc05076.helper.DateHelper;
import com.tuandhpc05076.helper.DialogHelper;
import java.awt.Color;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class ThanhToanLuong extends javax.swing.JPanel {

    ThaoTacDAO thaotacdao = new ThaoTacDAO();
    ThanhToanLuongDAO dao = new ThanhToanLuongDAO();
    int row = -1;
    DefaultTableModel model;

    /**
     * Creates new form GiamGia
     */
    public ThanhToanLuong() {
        initComponents();
        tblThanhToanLuong.getColumnModel().getColumn(1).setPreferredWidth(40);

        fillTable();
        LoadCBOMaLuong();

    }

    public ThaoTacModel getFormThaoTacThem() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Thanh Toán Lương");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSua() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Thanh Toán Lương");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoa() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Thanh Toán Lương");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    void LoadCBOMaLuong() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        NhanVienDAO1 NVdao = new NhanVienDAO1();
        ArrayList<NhanVienModel> listnv = (ArrayList<NhanVienModel>) NVdao.selectcombobox();
        for (NhanVienModel nv : listnv) {
            cboModel.addElement(nv.getMaNV().trim());
        }
        cboMaLuong.setModel(cboModel);
        cboMaLuong.setSelectedIndex(-1);

    }

    void fillTable() {

        model = (DefaultTableModel) tblThanhToanLuong.getModel();
        model.setRowCount(0);
        try {
            List<ThanhToanLuongModel> list = dao.select();
            System.out.println(list.size());
            for (ThanhToanLuongModel ttl : list) {
                String dateString = ttl.getNgayVaoCTy();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                Object[] rows = {ttl.getMaLuong(), ttl.getSoNgayLam(), ttl.getLuongCoBan(),
                    formattedDate,
                    ttl.getSoGioTangCa(),
                    ttl.getLuongTangCa(), ttl.getKhoanTru(), ttl.getTongTien(), ttl.isTrangThai()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    ThanhToanLuongModel getForm() {
        ThanhToanLuongModel ttl = new ThanhToanLuongModel();
        ttl.setMaLuong((String) cboMaLuong.getSelectedItem());
        ttl.setSoNgayLam(Float.parseFloat(txtSoNgayLamViec.getText()));
        ttl.setLuongCoBan(Double.parseDouble(txtLuongCoBan.getText()));
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayVaoCTY.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            ttl.setNgayVaoCTy(ngayNhap);

        } catch (Exception e) {
        }
        ttl.setSoGioTangCa(Float.parseFloat(txtSoHTangCa.getText()));
        ttl.setLuongTangCa(Double.parseDouble(txtLuongTangCa.getText()));
        ttl.setKhoanTru(Double.parseDouble(txtKhoangTru.getText()));
          DecimalFormat df = new DecimalFormat("#,##0.##");
        try {
            double number =  (double) df.parse(lblTongTien.getText());
             ttl.setTongTien(number);
        } catch (ParseException ex) {
            Logger.getLogger(ThanhToanLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ttl.setTrangThai(true);
        if (btnTrangThai.isSelected()) {
            ttl.setTrangThai(true);
        } else {
            ttl.setTrangThai(false);
        }
        return ttl;
    }

    void setForm(ThanhToanLuongModel ttl) {

        cboMaLuong.setSelectedItem(ttl.getMaLuong().trim());
        txtSoNgayLamViec.setText(String.valueOf(ttl.getSoNgayLam()));
        txtLuongCoBan.setText(String.valueOf(ttl.getLuongCoBan()));
        try {
            String dateString = ttl.getNgayVaoCTy();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgayVaoCTY.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(ThanhToanLuong.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtSoHTangCa.setText(String.valueOf(ttl.getSoGioTangCa()));
        txtLuongTangCa.setText(String.valueOf(ttl.getLuongTangCa()));
        txtKhoangTru.setText(String.valueOf(ttl.getKhoanTru()));
        lblTongTien.setText(String.valueOf(ttl.getTongTien()));
        if (ttl.isTrangThai() == true) {
            btnTrangThai.setSelectedAnimate(true);
            lblTrangThai.setText("Đã thanh toán");
            lblTrangThai.setForeground(Color.green);
        } else {
            btnTrangThai.setSelectedAnimate(false);
            lblTrangThai.setText("Chưa thanh toán");
        }
    }

    void clearForm() {
        cboMaLuong.setSelectedItem(null);
        txtLuongCoBan.setText("0");
        txtSoNgayLamViec.setText("0");
        txtSoHTangCa.setText("0");
        txtLuongTangCa.setText("0");
        txtKhoangTru.setText("0");
        lblTongTien.setText("0");
        btnTrangThai.setSelectedAnimate(false);
        lblTrangThai.setText("Chưa thanh toán");
        lblTrangThai.setForeground(Color.red);
    }

    void edit() {
        String maluong = (String) tblThanhToanLuong.getValueAt(this.row, 0);
        ThanhToanLuongModel ttl = dao.findById(maluong);
        this.setForm(ttl);
        this.updateStatus();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblThanhToanLuong.getRowCount() - 1);

        cboMaLuong.setEditable(!edit);
        btnThem.setEnabled(edit);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToanLuong = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        txtSoNgayLamViec = new com.DuAn1.Swing.TextField();
        txtSoHTangCa = new com.DuAn1.Swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        btnTrangThai = new com.DuAn1.swing0.SwitchButton();
        lblTrangThai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        txtKhoangTru = new com.DuAn1.Swing.TextField();
        txtNgayVaoCTY = new com.DuAn1.Swing.TextField();
        txtLuongCoBan = new com.DuAn1.Swing.TextField();
        txtLuongTangCa = new com.DuAn1.Swing.TextField();
        cboMaLuong = new com.DuAn1.Swing.Combobox();
        btnTim = new com.DuAn1.Swing.Button();
        txtLoc = new com.DuAn1.Swing.TextField1();
        btnLoc = new com.DuAn1.Swing.Button();

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        txtSoNgayLamViec.setText("0");
        txtSoNgayLamViec.setLabelText("Số ngày làm việc");
        txtSoNgayLamViec.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoNgayLamViecCaretUpdate(evt);
            }
        });

        txtSoHTangCa.setText("0");
        txtSoHTangCa.setLabelText("Số giờ tăng ca ");
        txtSoHTangCa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSoHTangCaCaretUpdate(evt);
            }
        });

        jLabel2.setText("Trạng thái:");

        btnTrangThai.setEnabled(false);
        btnTrangThai.setSelectedAnimate(false);
        btnTrangThai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangThaiMouseClicked(evt);
            }
        });

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(255, 0, 0));
        lblTrangThai.setText("Chưa thanh toán");

        jLabel4.setText("Tổng tiền: ");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 51));
        lblTongTien.setText("0");
        lblTongTien.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblTongTienAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

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

        txtTimKiem.setHint("Tìm  theo mã");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        txtKhoangTru.setText("0");
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

        txtLuongCoBan.setText("0");
        txtLuongCoBan.setLabelText("Lương cơ bản");
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

        txtLuongTangCa.setText("0");
        txtLuongTangCa.setLabelText("Lương tăng ca");
        txtLuongTangCa.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLuongTangCaCaretUpdate(evt);
            }
        });

        cboMaLuong.setLabeText("Mã lương");
        cboMaLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaLuongActionPerformed(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(153, 153, 255));
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtLoc.setHint("Lọc theo lương");
        txtLoc.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtLocCaretUpdate(evt);
            }
        });

        btnLoc.setBackground(new java.awt.Color(153, 153, 255));
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoHTangCa, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(txtLuongCoBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMaLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKhoangTru, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTrangThai))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(txtLuongTangCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblTongTien))
                                    .addComponent(txtNgayVaoCTY, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayVaoCTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
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
                            .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangThai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnTrangThaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangThaiMouseClicked
        // TODO add your handling code here:
        if (!btnTrangThai.isSelected()) {
            lblTrangThai.setText("Đã thanh toán");
            lblTrangThai.setForeground(Color.green);
        } else {
            lblTrangThai.setText("Chưa thanh toán");
            lblTrangThai.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnTrangThaiMouseClicked

    private void tblThanhToanLuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanLuongMousePressed
//         TODO add your handling code here:
//        if (evt.getClickCount() == 1) {
//            this.row = tblThanhToanLuong.getSelectedRow();
//            this.edit();
//        }
    }//GEN-LAST:event_tblThanhToanLuongMousePressed
    void them() {
        ThanhToanLuongModel ttl = getForm();
        try {
            dao.insert(ttl);
            this.fillTable();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThem();
            thaotacdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    boolean check() {
        boolean check = false;
        String name = (String) cboMaLuong.getSelectedItem();
        List<ThanhToanLuongModel> list = dao.select();
        for (ThanhToanLuongModel nv : list) {
            if (nv.getMaLuong().trim().equals(name.trim())) {
                check = true;
            }
        }
        if (check) {
            DialogHelper.alert(this, "Nhân viên đã thanh toán lương rồi");
            return false;
        }
        if (cboMaLuong.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn mã lương!");
            return false;
        }
        if (txtSoNgayLamViec.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập số ngày làm việc!");
            return false;
        }
        try {
            Float.parseFloat(txtSoNgayLamViec.getText());
        } catch (Exception e) {
            DialogHelper.alert(this, "Số ngày làm việc không hợp lệ!");
            return false;
        }
        if (Float.parseFloat(txtSoNgayLamViec.getText()) < 0) {
            DialogHelper.alert(this, "Số ngày làm việc không hợp lệ!");
            return false;
        }
        if (txtNgayVaoCTY.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập ngày vào CTY!");
            return false;
        }
        if (txtLuongCoBan.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập lương cơ bản");
            return false;
        }
        try {
            Double.parseDouble(txtLuongCoBan.getText());
        } catch (Exception e) {
            DialogHelper.alert(this, "Số lương cơ bản không hợp lệ!");
            return false;
        }
        if (Double.parseDouble(txtLuongCoBan.getText()) < 0) {
            DialogHelper.alert(this, "Số lương cơ bản không hợp lệ!");
            return false;
        }
        if (txtLuongTangCa.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập lương tăng ca!");
            return false;
        }
        try {
            Double.parseDouble(txtLuongTangCa.getText());
        } catch (Exception e) {
            DialogHelper.alert(this, "Số lương tăng ca không hợp lệ!");
            return false;
        }
        if (Double.parseDouble(txtLuongTangCa.getText()) < 0) {
            DialogHelper.alert(this, "Số lương tăng ca không hợp lệ!");
            return false;
        }
        if (txtSoHTangCa.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập số giờ tăng ca!");
            return false;
        }
        try {
            Double.parseDouble(txtSoHTangCa.getText());
        } catch (Exception e) {
            DialogHelper.alert(this, "Số giờ tăng ca không hợp lệ!");
            return false;
        }
        if (Double.parseDouble(txtSoHTangCa.getText()) < 0) {
            DialogHelper.alert(this, "Số giờ tăng ca không hợp lệ!");
            return false;
        }
        if (txtKhoangTru.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập khoảng trừ!");
            return false;
        }
        try {
            Double.parseDouble(txtKhoangTru.getText());
        } catch (Exception e) {
            DialogHelper.alert(this, "Số khoảng trừ không hợp lệ!");
            return false;
        }
        if (Double.parseDouble(txtKhoangTru.getText()) < 0) {
            DialogHelper.alert(this, "Số khoảng trừ không hợp lệ!");
            return false;
        }
        return true;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (check()) {
            them();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSoNgayLamViecCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoNgayLamViecCaretUpdate
        // TODO add your handling code here:
      
        double tongTien = 1;
        double luongTangCa = 1;
        luongTangCa = Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        if (txtLuongCoBan.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        if (Double.parseDouble(txtLuongTangCa.getText()) != 0) {
            tongTien = tongTien + luongTangCa;
        }
        if (Double.parseDouble(txtKhoangTru.getText()) != 0) {
            tongTien = tongTien + luongTangCa - Double.parseDouble(txtKhoangTru.getText());;
        }
//        lblTongTien.setText(String.valueOf(tongTien));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTongTien.setText(df.format(tongTien));
    }//GEN-LAST:event_txtSoNgayLamViecCaretUpdate

    private void txtKhoangTruCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtKhoangTruCaretUpdate
        // TODO add your handling code here:
        double tongTien = 1;
        double luongTangCa = 1;
        luongTangCa = Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());
        if (txtKhoangTru.getText().equals("")) {
            return;
        }
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        if (txtLuongCoBan.getText().equals("")) {
            return;
        }

        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        if (Double.parseDouble(txtLuongTangCa.getText()) != 0) {
            tongTien = tongTien + luongTangCa;
        }
        if (Double.parseDouble(txtKhoangTru.getText()) != 0) {
            tongTien = tongTien + luongTangCa - Double.parseDouble(txtKhoangTru.getText());;
        }

        lblTongTien.setText(String.valueOf(tongTien));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTongTien.setText(df.format(tongTien));
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

    private void txtSoHTangCaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSoHTangCaCaretUpdate
        // TODO add your handling code here:
        double tongTien = 1;

        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        if (txtLuongCoBan.getText().equals("")) {
            return;
        }
        if (txtLuongTangCa.getText().equals("")) {
            return;
        }
        if (txtSoHTangCa.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        if (Double.parseDouble(txtLuongTangCa.getText()) != 0) {
            tongTien = tongTien + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());

        }
        if (Double.parseDouble(txtKhoangTru.getText()) != 0) {
            tongTien = tongTien + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText()) - Double.parseDouble(txtKhoangTru.getText());
        }

        lblTongTien.setText(String.valueOf(tongTien));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTongTien.setText(df.format(tongTien));
    }//GEN-LAST:event_txtSoHTangCaCaretUpdate
    void sua() {
        ThanhToanLuongModel ttl = getForm();
        try {
            dao.update(ttl);
            this.fillTable();
            ThaoTacModel model = getFormThaoTacSua();
            thaotacdao.insert(model);
            DialogHelper.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại");
            e.printStackTrace();
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
    void xoa() {
        String maluong = (String) cboMaLuong.getSelectedItem();
        if (DialogHelper.confirm(this, "Bạn muốn xoá nội dung này?")) {
            try {
                dao.delete(maluong);
                this.fillTable();
                this.clearForm();
                ThaoTacModel model = getFormThaoTacXoa();
                thaotacdao.insert(model);
                DialogHelper.alert(this, "Xóa thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại");
            }
        }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtLuongCoBanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLuongCoBanCaretUpdate
        // TODO add your handling code here:
        double tongTien = 0;
        double luongTangCa = 1;
        luongTangCa = Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        if (txtLuongCoBan.getText().equals("")) {
            return;
        }
        if (txtLuongTangCa.getText().equals("")) {
            return;
        }
        if (txtKhoangTru.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        if (Double.parseDouble(txtLuongTangCa.getText()) != 0) {
            tongTien = tongTien + luongTangCa;
        }
        if (Double.parseDouble(txtKhoangTru.getText()) != 0) {
            tongTien = tongTien + luongTangCa - Double.parseDouble(txtKhoangTru.getText());
        }
        lblTongTien.setText(String.valueOf(tongTien));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTongTien.setText(df.format(tongTien));
    }//GEN-LAST:event_txtLuongCoBanCaretUpdate

    private void txtLuongTangCaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLuongTangCaCaretUpdate
        // TODO add your handling code here:
        double tongTien = 1;
        if (txtSoNgayLamViec.getText().equals("")) {
            return;
        }
        if (txtLuongCoBan.getText().equals("")) {
            return;
        }
        if (txtLuongTangCa.getText().equals("")) {
            return;
        }
        if (txtSoHTangCa.getText().equals("")) {
            return;
        }
        tongTien = Double.parseDouble(txtLuongCoBan.getText()) / 26 * Double.parseDouble(txtSoNgayLamViec.getText());
        if (Double.parseDouble(txtLuongTangCa.getText()) != 0) {
            tongTien = tongTien + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText());;
        }
        if (Double.parseDouble(txtKhoangTru.getText()) != 0) {
            tongTien = tongTien + Double.parseDouble(txtLuongTangCa.getText()) * Double.parseDouble(txtSoHTangCa.getText()) - Double.parseDouble(txtKhoangTru.getText());;
        }
        lblTongTien.setText(String.valueOf(tongTien));
        DecimalFormat df = new DecimalFormat("#,##0.##");
        lblTongTien.setText(df.format(tongTien));
    }//GEN-LAST:event_txtLuongTangCaCaretUpdate

    private void txtLuongCoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongCoBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongCoBanActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

        if (txtTimKiem.getText().equals("")) {
            this.fillTable();
        }
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tblThanhToanLuong.getModel();
        model.setRowCount(0);
        try {
            List<ThanhToanLuongModel> list = (List<ThanhToanLuongModel>) dao.TimTheoMaLuong(txtTimKiem.getText());
            for (ThanhToanLuongModel ttl : list) {
                Object[] row = new Object[]{ttl.getMaLuong(), ttl.getSoNgayLam(), ttl.getLuongCoBan(), ttl.getNgayVaoCTy(),
                    ttl.getSoGioTangCa(), ttl.getLuongTangCa(), ttl.getKhoanTru(), ttl.getTongTien(), ttl.isTrangThai()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tblThanhToanLuong.getModel();
        model.setRowCount(0);
        try {
            List<ThanhToanLuongModel> list = (List<ThanhToanLuongModel>) dao.LocTheoLuongCoBan(txtLoc.getText());
            for (ThanhToanLuongModel ttl : list) {
                Object[] row = new Object[]{ttl.getMaLuong(), ttl.getSoNgayLam(), ttl.getLuongCoBan(), ttl.getNgayVaoCTy(),
                    ttl.getSoGioTangCa(), ttl.getLuongTangCa(), ttl.getKhoanTru(), ttl.getTongTien(), ttl.isTrangThai()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void txtLocCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtLocCaretUpdate
        // TODO add your handling code here:
        if (txtLoc.getText().equals("")) {
            this.fillTable();
        }
    }//GEN-LAST:event_txtLocCaretUpdate

    private void lblTongTienAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblTongTienAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTongTienAncestorAdded

    private void cboMaLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaLuongActionPerformed
        // TODO add your handling code here:
        btnTrangThai.setSelectedAnimate(true);
        lblTrangThai.setText("Thanh toán");
    }//GEN-LAST:event_cboMaLuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnLoc;
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnTim;
    private com.DuAn1.swing0.SwitchButton btnTrangThai;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Combobox cboMaLuong;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTrangThai;
    private com.raven.swing.table.Table tblThanhToanLuong;
    private com.DuAn1.Swing.TextField txtKhoangTru;
    private com.DuAn1.Swing.TextField1 txtLoc;
    private com.DuAn1.Swing.TextField txtLuongCoBan;
    private com.DuAn1.Swing.TextField txtLuongTangCa;
    private com.DuAn1.Swing.TextField txtNgayVaoCTY;
    private com.DuAn1.Swing.TextField txtSoHTangCa;
    private com.DuAn1.Swing.TextField txtSoNgayLamViec;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

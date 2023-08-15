/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.GiamGiaDao;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.GiamGiaModel;
import com.DuAn1.Model.ThaoTacModel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * String date1 = "1-1-2002"; String date2 = "2-1-2023";
 *
 * Date date1Obj = Date.parse(date1); Date date2Obj = Date.parse(date2);
 *
 * @author DELL E5470
 */
public class GiamGia extends javax.swing.JPanel {

    ThongKeDao DaoThongKe = new ThongKeDao();
    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
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
        TuDongTangMa();
    }

    void TuDongTangMa() {
        List<Object[]> i = DaoThongKe.getSoLuongGG();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("M");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "KM";
        for (int j = 0; j <= 2 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtMaGG.setText(ten);
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
                String dateString = nv.getNgayBD();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                String dateString1 = nv.getNgayKT();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
                String formattedDate1 = new SimpleDateFormat("dd-MM-yyyy").format(date1);
                Object[] row = new Object[]{nv.getMaGG(), formattedDate, formattedDate1, nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn Khuyến Mại" : "Hết Khuyến Mại", nv.getMaNV()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void insert() {
        if (txtPhantram.getText().equals("")) {
            DialogHelper.alert(this, "Bạn chưa nhập phần trăm giảm giá");
            return;
        }
        try {
            Double phanTram = Double.parseDouble(txtPhantram.getText());
            if (phanTram < 0 || phanTram > 100) {
                DialogHelper.alert(this, "Phần trăm nhập chỉ có thể từ 0 đến 100");
                return;
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Phần trăm không phải là số");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // Tạo 2 ngày từ chuỗi
            Date date1 = sdf.parse(txtNgayBD.getText());
            Date date2 = sdf.parse(txtNgayKT.getText());
            if (date1.compareTo(date2) > 0) {
                DialogHelper.alert(this, "Ngày ket thuc khong duoc nho hon ngay bat dau");
                return;
            }
        } catch (ParseException ex) {
            Logger.getLogger(GiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }

        GiamGiaModel nv = getForm();
        try {
            Dao.insert(nv);
            this.filltable();
            this.ClearForm();
            ThaoTacModel model = getFormThem();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Thêm Mới thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
        }
    }

    void update() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            // Tạo 2 ngày từ chuỗi
            Date date1 = sdf.parse(txtNgayBD.getText());
            Date date2 = sdf.parse(txtNgayKT.getText());
            if (date1.compareTo(date2) > 0) {
                DialogHelper.alert(this, "Ngày ket thuc khong duoc nho hon ngay bat dau");
                return;
            }
        } catch (ParseException ex) {
            Logger.getLogger(GiamGia.class.getName()).log(Level.SEVERE, null, ex);
        }
        GiamGiaModel nv = getForm();
        try {
            Dao.update(nv);
            this.filltable();
            ThaoTacModel model = getFormSua();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            ClearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật mới thất bại!");
        }
    }

    void delete() {
        GiamGiaModel nv = getForm();
        try {
            Dao.delete(txtMaGG.getText());
            this.filltable();
            ClearForm();
            ThaoTacModel model = getFormXoa();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    GiamGiaModel getForm() {
        GiamGiaModel nv = new GiamGiaModel();
        nv.setMaGG(txtMaGG.getText());
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayBD.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            nv.setNgayBD(ngayNhap);

        } catch (Exception e) {
        }
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgayKT.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            nv.setNgayKT(ngayNhap);

        } catch (Exception e) {
        }
        nv.setPhanTram((float) Double.parseDouble(txtPhantram.getText()));
        nv.setMota(txtMota.getText());
        nv.setTrangThai(true);
        if (btnTrangthai.isSelected()) {
            nv.setTrangThai(true);
        } else {
            nv.setTrangThai(false);
        }
        nv.setMaNV(ShareHelper.USER.getMaNV());
        return nv;
    }

    void setForm(GiamGiaModel nv) {
        txtMaGG.setText(nv.getMaGG());
        try {
            String dateString = nv.getNgayBD();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgayBD.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String dateString = nv.getNgayKT();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgayKT.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtPhantram.setText(String.valueOf(nv.getPhanTram()));
        if (nv.getMota() != null) {
            txtMota.setText(nv.getMota());
        }
        if (nv.isTrangThai()) {
            btnTrangthai.setSelectedAnimate(true);
            txtTrangthai.setText("Còn khuyến mại");
        } else {
            btnTrangthai.setSelectedAnimate(false);
            txtTrangthai.setText("Hết khuyến mại");
        }
    }

    void ClearForm() {
        txtMaGG.setText("");
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
        btnThem.setEnabled(edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    public ThaoTacModel getFormThem() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Khuyến Mại");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormSua() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Khuyến Mại");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormXoa() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Khuyến Mại");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public boolean check() {
        if (txtPhantram.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Phần trăm khuyến mại không được để trống!");
            return false;
        }
        if (txtMota.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mô tả khuyến mại không được để trống!");
            return false;
        }
        if (txtNgayBD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu khuyến mại không được để trống!");
            return false;
        }
        if (txtNgayKT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc khuyến mại không được để trống!");
            return false;
        }
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGiamgia = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        txtNgayKT = new com.DuAn1.Swing.TextField();
        txtMota = new com.DuAn1.Swing.TextField();
        txtMaGG = new com.DuAn1.Swing.TextField();
        jPanel2 = new javax.swing.JPanel();
        btnSua = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        btnMoi = new com.DuAn1.Swing.Button();
        btnTim = new com.DuAn1.Swing.Button();
        txtNgayBD = new com.DuAn1.Swing.TextField();
        txtPhantram = new com.DuAn1.Swing.TextField();
        jLabel2 = new javax.swing.JLabel();
        btnTrangthai = new com.DuAn1.swing0.SwitchButton();
        txtTrangthai = new javax.swing.JLabel();
        button15 = new com.DuAn1.Swing.Button();
        txtTim = new com.DuAn1.Swing.TextField1();
        cboLoc = new com.DuAn1.Swing.Combobox();

        dateChooser1.setTextRefernce(txtNgayKT);

        dateChooser2.setTextRefernce(txtNgayBD);

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGiamgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblGiamgiaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblGiamgia);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Giảm giá");

        txtNgayKT.setLabelText("Ngày kết thúc");

        txtMota.setLabelText("Mô tả");

        txtMaGG.setLabelText("Mã Giảm Giá");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

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
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
        );

        btnTim.setBackground(new java.awt.Color(153, 153, 255));
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtNgayBD.setLabelText("Ngày bắt đầu");
        txtNgayBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBDActionPerformed(evt);
            }
        });

        txtPhantram.setLabelText("Phần trăm giảm giá");
        txtPhantram.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhantramFocusLost(evt);
            }
        });

        jLabel2.setText("Trạng thái:");

        btnTrangthai.setSelectedAnimate(false);
        btnTrangthai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangthaiMouseClicked(evt);
            }
        });

        txtTrangthai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTrangthai.setForeground(new java.awt.Color(0, 204, 51));
        txtTrangthai.setText("Hết khuyến mại");

        button15.setBackground(new java.awt.Color(153, 153, 255));
        button15.setText("In thành file excel");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        txtTim.setHint("Tìm kiếm theo mã");
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
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });

        cboLoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã Tăng", "Mã Giảm" }));
        cboLoc.setSelectedIndex(-1);
        cboLoc.setToolTipText("");
        cboLoc.setLabeText("Lọc ");
        cboLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 117, Short.MAX_VALUE))
                            .addComponent(cboLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTrangthai))
                                    .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(100, 100, 100)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhantram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(btnTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTrangthai)
                                .addGap(11, 11, 11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
        TuDongTangMa();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
        TuDongTangMa();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
        TuDongTangMa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        model = (DefaultTableModel) tblGiamgia.getModel();
        model.setRowCount(0);
        try {
            List<GiamGiaModel> list = Dao.TimKiemTheoTen(txtTim.getText());
            for (GiamGiaModel nv : list) {
                Object[] row = new Object[]{nv.getMaGG(), nv.getNgayBD(), nv.getNgayKT(), nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn khuyến mại" : "Hết khuyến mại", nv.getMaNV()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
        btnThem.setEnabled(true);
        TuDongTangMa();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblGiamgiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGiamgiaMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblGiamgia.getSelectedRow();
            this.edit();
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_tblGiamgiaMousePressed

    private void txtNgayBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBDActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        btnInDanhSach();        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed

    private void btnTrangthaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangthaiMouseClicked
        // TODO add your handling code here:
        if (btnTrangthai.isSelected() == false) {
            txtTrangthai.setText("Còn khuyến mại ");
        } else {
            txtTrangthai.setText("Hết khuyến mại");
        }
    }//GEN-LAST:event_btnTrangthaiMouseClicked

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        if (txtTim.getText().equals("")) {
            this.filltable();
        } else {
            model = (DefaultTableModel) tblGiamgia.getModel();
            model.setRowCount(0);
            try {
                List<GiamGiaModel> list = Dao.TimKiemTheoTen(txtTim.getText());
                for (GiamGiaModel nv : list) {
                    Object[] row = new Object[]{nv.getMaGG(), nv.getNgayBD(), nv.getNgayKT(), nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn khuyến mại" : "Hết khuyến mại", nv.getMaNV()};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_txtTimCaretUpdate

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed

    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed

    }//GEN-LAST:event_txtTimKeyPressed

    private void txtPhantramFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhantramFocusLost
        // TODO add your handling code here:
        try {
            Double phanTram = Double.parseDouble(txtPhantram.getText());
            if (phanTram < 0 || phanTram > 100) {
                DialogHelper.alert(this, "Phần trăm nhập chỉ có thể từ 0 đến 100");
                txtPhantram.setText("");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Phần trăm không phải là số");
            txtPhantram.setText("");
        }
    }//GEN-LAST:event_txtPhantramFocusLost

    private void cboLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocActionPerformed
        if (cboLoc.getSelectedItem().equals("Mã Tăng")) {
            model = (DefaultTableModel) tblGiamgia.getModel();
            model.setRowCount(0);
            try {
                List<GiamGiaModel> list = Dao.orderByTang();
                for (GiamGiaModel nv : list) {
                    String dateString = nv.getNgayBD();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                    String dateString1 = nv.getNgayKT();
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
                    String formattedDate1 = new SimpleDateFormat("dd-MM-yyyy").format(date1);
                    Object[] row = new Object[]{nv.getMaGG(), formattedDate, formattedDate1, nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn Khuyến Mại" : "Hết Khuyến Mại", nv.getMaNV()};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }

        } else {

            model = (DefaultTableModel) tblGiamgia.getModel();
            model.setRowCount(0);
            try {
                List<GiamGiaModel> list = Dao.orderByGiam();
                for (GiamGiaModel nv : list) {
                    String dateString = nv.getNgayBD();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                    String dateString1 = nv.getNgayKT();
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
                    String formattedDate1 = new SimpleDateFormat("dd-MM-yyyy").format(date1);
                    Object[] row = new Object[]{nv.getMaGG(), formattedDate, formattedDate1, nv.getPhanTram(), nv.getMota(), nv.isTrangThai() ? "Còn Khuyến Mại" : "Hết Khuyến Mại", nv.getMaNV()};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_cboLocActionPerformed
    public void btnInDanhSach() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Giảm giá");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblGiamgia.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblGiamgia.getColumnName(i));
                }

                for (int j = 0; j < tblGiamgia.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblGiamgia.getColumnCount(); k++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(k);
                        if (tblGiamgia.getValueAt(j, k) != null) {
                            cell.setCellValue(tblGiamgia.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                OpenFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public void OpenFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnTim;
    private com.DuAn1.swing0.SwitchButton btnTrangthai;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Button button15;
    private com.DuAn1.Swing.Combobox cboLoc;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblGiamgia;
    private com.DuAn1.Swing.TextField txtMaGG;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgayBD;
    private com.DuAn1.Swing.TextField txtNgayKT;
    private com.DuAn1.Swing.TextField txtPhantram;
    private com.DuAn1.Swing.TextField1 txtTim;
    private javax.swing.JLabel txtTrangthai;
    // End of variables declaration//GEN-END:variables
}

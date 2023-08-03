/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.ThaoTacModel;
import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import com.DuAn1.main.Main;
import com.tuandhpc05076.Form.ChuyenDe;
import java.awt.Desktop;
import java.awt.Image;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL E5470
 */
public class KhachHang extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    ThongKeDao DaoThongKe = new ThongKeDao();
    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    int row = -1;

    public KhachHang() {
        initComponents();
        tieude();
        filltable();
        this.row = -1;
        TuDongTangMa();
    }

    void TuDongTangMa() {
        List<Object[]> i = DaoThongKe.getSoLuongKH();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("H");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "KH";
        for (int j = 0; j <= 4 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtma.setText(ten);
    }

    void tieude() {
        tblModel = new DefaultTableModel();
        String[] name = new String[]{"Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Ngày Sinh", "Địa Chỉ"};
        tblModel.setColumnIdentifiers(name);
        tblUser.setModel(tblModel);
    }

    public void btnInDanhSach() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Khách hàng");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblUser.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblUser.getColumnName(i));
                }

                for (int j = 0; j < tblUser.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblUser.getColumnCount(); k++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(k);
                        if (tblUser.getValueAt(j, k) != null) {
                            cell.setCellValue(tblUser.getValueAt(j, k).toString());
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

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<KhachHangModel> list = daoKH.select();
            for (KhachHangModel model : list) {
                String dateString = model.getNgaySinh();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                Object[] row = new Object[]{
                    model.getMaKH(),
                    model.getTenKH(),
                    model.getSDT(),
                    formattedDate,
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

    void insert() {
        KhachHangModel nv = getForm();
        try {
            daoKH.insert(nv);
            this.filltable();
            this.ClearForm();
            ThaoTacModel model = getFormThem();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Thêm Mới thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        KhachHangModel nv = getForm();
        try {
            daoKH.update(nv);
            this.filltable();
            ThaoTacModel model = getFormSua();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật mới thất bại!");

        }
    }

    void delete() {
        if(tblUser.getSelectedRow()<0){
            DialogHelper.alert(this,"Bạn chưa chọn khách hàng để có thể xóa");
            return ;
        }
        KhachHangModel nv = getForm();
        try {
            daoKH.delete(nv);
            this.filltable();
            ThaoTacModel model = getFormXoa();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    KhachHangModel getForm() {
        KhachHangModel nv = new KhachHangModel();
        nv.setMaKH(txtma.getText());
        nv.setTenKH(txtTen.getText());
        nv.setSDT(txtSdt.getText());
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySinh.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            nv.setNgaySinh(ngayNhap);

        } catch (Exception e) {
        }
        nv.setDiaChi(txtDiachi.getText());
        if (cboGioitinh.getSelectedItem().equals("Nam")) {
            nv.setGT(true);
        } else {
            nv.setGT(false);
        }
        if (cbokhach.getSelectedItem().equals("VIP1")) {
            nv.setLoaiKH("VIP1");
        } else if (cbokhach.getSelectedItem().equals("VIP2")) {
            nv.setLoaiKH("VIP2");
        } else {
            nv.setLoaiKH("Thường");
        }
        nv.setTrangThai(true);
        nv.setMoTa(txtMota.getText());
        nv.setMaNV(ShareHelper.USER.getMaNV());
        nv.setHinh(txtHinhAnh2.getToolTipText());

        return nv;
    }

    void setForm(KhachHangModel nv) {
        txtma.setText(nv.getMaKH());
        txtTen.setText(nv.getTenKH());
        txtSdt.setText(nv.getSDT().trim());
        try {
            String dateString = nv.getNgaySinh();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgaySinh.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtDiachi.setText(nv.getDiaChi());
        cboGioitinh.setSelectedItem(nv.isGT() ? "Nam" : "Nữ");
        if (nv.getLoaiKH().trim().equalsIgnoreCase("VIP1")) {
            cbokhach.setSelectedItem("VIP1");
        } else if (nv.getLoaiKH().trim().equalsIgnoreCase("VIP2")) {
            cbokhach.setSelectedItem("VIP2");
        } else {
            cbokhach.setSelectedItem("Thường");
        }
        if (nv.getMoTa() != null) {
            txtMota.setText(nv.getMoTa());
        }
        if (nv.getHinh() != null) {
            txtHinhAnh2.setToolTipText(nv.getHinh());
            txtHinhAnh2.setIcon(ShareHelper.readLogo(nv.getHinh()));
            txtHinhAnh2.setToolTipText(nv.getHinh());
            ImageIcon originalIcon = ShareHelper.readLogo(nv.getHinh());
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(txtHinhAnh2.getWidth(), txtHinhAnh2.getHeight(), Image.SCALE_SMOOTH);
            txtHinhAnh2.setIcon(new ImageIcon(scaledImage));
        }
    }

    void ClearForm() {
        btnThem.setEnabled(true);
        txtma.setText("");
        txtTen.setText("");
        txtNgaySinh.setText("");
        cboGioitinh.setSelectedItem("Nam");
        txtDiachi.setText("");
        txtSdt.setText("");
        cbokhach.setSelectedItem("VIP2");
        txtHinhAnh2.setToolTipText("");
        txtHinhAnh2.setIcon(ShareHelper.readLogo(""));
    }

    void edit() {
        String manv = (String) tblUser.getValueAt(this.row, 0);
        KhachHangModel nv = daoKH.findById(manv);
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
        if (this.row < tblUser.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblUser.getRowCount() - 1;
        this.edit();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblUser.getRowCount() - 1);
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
        cd.setBanThaoTac("Thêm Khách Hàng");
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
        cd.setBanThaoTac("Sửa Khách Hàng");
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
        cd.setBanThaoTac("Xóa Khách Hàng");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }
    String so = "0\\d{9,10}";

    public boolean check() {
//        if (Dao.findById(txtTaikhoan.getText()) != null) {
//            DialogHelper.alert(this, "Mã Nhân Viên đã tồn tại!");
//            return false;
//        }
        if (txtHinhAnh2.getToolTipText() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn hình ảnh");
            return false;
        }
//        if (txtma.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Mã Khách Hàng không được để trống");
//            return false;
//        }
        if (txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống");
            return false;
        }
        if (!txtTen.getText().matches("^[\\p{L}\\s]{0,50}$")) {
            JOptionPane.showMessageDialog(this, "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự");
            return false;
        }
        if (txtNgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống");
            return false;
        }
        if (txtSdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txtSdt.getText().matches(so)) {
            DialogHelper.alert(this, "Số điện thoại của bạn không đúng định dạng");
            return false;
        }
        if (txtDiachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbokhach = new com.DuAn1.Swing.Combobox();
        txtNgaySinh = new com.DuAn1.Swing.TextField();
        txtDiachi = new com.DuAn1.Swing.TextField();
        txtTen = new com.DuAn1.Swing.TextField();
        txtMota = new com.DuAn1.Swing.TextField();
        txtSdt = new com.DuAn1.Swing.TextField();
        txtma = new com.DuAn1.Swing.TextField();
        btnThem = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        btnMoi = new com.DuAn1.Swing.Button();
        txtTim = new com.DuAn1.Swing.TextField1();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUser = new javaswingdev.swing.table.Table();
        txtHinh2 = new swing.PanelShadow();
        txtHinhAnh2 = new javax.swing.JLabel();
        cboGioitinh = new com.DuAn1.Swing.Combobox();
        button15 = new com.DuAn1.Swing.Button();

        dateChooser.setTextRefernce(txtNgaySinh);

        setMinimumSize(new java.awt.Dimension(1058, 741));
        setPreferredSize(new java.awt.Dimension(1058, 741));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1058, 741));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 741));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Khách hàng");

        cbokhach.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VIP2", "VIP1", "Thường" }));
        cbokhach.setSelectedIndex(-1);
        cbokhach.setLabeText("Loại khách hàng");

        txtNgaySinh.setLabelText("Ngày sinh");
        txtNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinhMouseClicked(evt);
            }
        });

        txtDiachi.setLabelText("Địa chỉ");

        txtTen.setLabelText("Tên khách hàng");

        txtMota.setLabelText("Mô tả");

        txtSdt.setLabelText("Số điện thoại");
        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });

        txtma.setLabelText("Mã khách hàng ");
        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
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

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        txtTim.setHint("Tìm kiếm mã");
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

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Số điện thoại", "Ngày sinh", "Địa chỉ"
            }
        ));
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblUser);

        txtHinh2.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinh2MouseClicked(evt);
            }
        });
        txtHinh2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh2.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh2.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnh2MouseClicked(evt);
            }
        });
        txtHinh2.add(txtHinhAnh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 180));

        cboGioitinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
        cboGioitinh.setSelectedIndex(-1);
        cboGioitinh.setLabeText("Giới tính");
        cboGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioitinhActionPerformed(evt);
            }
        });

        button15.setBackground(new java.awt.Color(153, 153, 255));
        button15.setText("In thành file excel");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(447, 447, 447)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(cbokhach, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(40, 40, 40)
                            .addComponent(txtHinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtHinh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbokhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhMouseClicked

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaActionPerformed

    private void txtHinhAnh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnh2MouseClicked
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
                txtHinhAnh2.setText("");

                txtHinhAnh2.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh2.setToolTipText(file.getName());
                txtHinhAnh2.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnh2MouseClicked
    String strHinh = null;
    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
        TuDongTangMa();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void tblUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMousePressed
        btnThem.setEnabled(false);
        if (evt.getClickCount() == 1) {
            this.row = tblUser.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblUserMousePressed

    private void cboGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGioitinhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check() == false) {
            return;
        }
        insert();
        ClearForm();
        TuDongTangMa();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (check() == false) {
            return;
        }
        update();
        ClearForm();
        TuDongTangMa();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
        ClearForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
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

    private void txtHinh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinh2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinh2MouseClicked

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        btnInDanhSach();        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Button button15;
    private com.DuAn1.Swing.Combobox cboGioitinh;
    private com.DuAn1.Swing.Combobox cbokhach;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField txtDiachi;
    private swing.PanelShadow txtHinh2;
    private javax.swing.JLabel txtHinhAnh2;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgaySinh;
    private com.DuAn1.Swing.TextField txtSdt;
    private com.DuAn1.Swing.TextField txtTen;
    private com.DuAn1.Swing.TextField1 txtTim;
    private com.DuAn1.Swing.TextField txtma;
    // End of variables declaration//GEN-END:variables
}

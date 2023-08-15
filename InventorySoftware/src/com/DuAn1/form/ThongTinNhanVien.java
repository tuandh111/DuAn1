/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.MaHoa.MaHoa;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.main.Main;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author DELL E5470
 */
public class ThongTinNhanVien extends javax.swing.JDialog {

    ThaoTacDAO daoThaoTac = new ThaoTacDAO();

    MaHoa MH = new MaHoa();
    String strHinh = "";
    NhanVienDAO1 dao = new NhanVienDAO1();
    public static String soLuong = "";

    public static String getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(String soLuong) {
        ThongTinNhanVien.soLuong = soLuong;
    }

    public ThaoTacModel getFormUpdate() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);

        cd.setThoIGianHoatDong(com.DuAn1.Helper.ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thay đổi cá nhân nhân viên");
        cd.setMaNV(com.DuAn1.Helper.ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThongTinNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        txtMaNV.setText(ShareHelper.USER.getMaNV());
//        txtHoTen.setText(ShareHelper.USER.getHoTen());
//        txtDiaChi.setText(ShareHelper.USER.getDiaChi());
//        txtSoDienThoai.setText(ShareHelper.USER.getSDT());
//        txtNgaySinh.setText(ShareHelper.USER.getNgaySinh());
//        txtEmail.setText(ShareHelper.USER.getEmail());
//        txtVaiTro.setText(ShareHelper.USER.getVaiTro());
//        if (ShareHelper.USER.isGioiTinh()) {
//            rdoNam.setSelected(true);
//        } else {
//            rdoNu.setSelected(false);
//        }
//        if (ShareHelper.USER.getHinh() != null) {
//
//            txtHinhAnh.setToolTipText(ShareHelper.USER.getHinh());
//            ImageIcon originalIcon = ShareHelper.readLogo(ShareHelper.USER.getHinh());
//            Image originalImage = originalIcon.getImage();
//            Image scaledImage = originalImage.getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH);
//            txtHinhAnh.setIcon(new ImageIcon(scaledImage));
//
//        }

        setIconImage(ShareHelper.APP_ICON);
        select();
    }

    public void select() {
        NhanVienModel nv = dao.findById(txtMaNV.getText());
        txtHoTen.setText(nv.getHoTen().trim());
        txtDiaChi.setText(nv.getDiaChi());
        txtSoDienThoai.setText(nv.getSDT().trim());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(nv.getNgaySinh());
            String ngayNhap = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgaySinh.setText(ngayNhap);
        } catch (Exception e) {
        }

        txtEmail.setText(nv.getEmail().trim());
        txtVaiTro.setText(nv.getVaiTro());
        if (nv.isGioiTinh()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        if (nv.getHinh() != null) {
             String TenHinh = nv.getHinh().trim();
            TenHinh=TenHinh.replace(nv.getMaNV().trim(),"");
            txtHinhAnh.setToolTipText(TenHinh);
            ImageIcon originalIcon = ShareHelper.readLogo(TenHinh);
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(txtHinhAnh.getWidth(), txtHinhAnh.getHeight(), Image.SCALE_SMOOTH);
            txtHinhAnh.setIcon(new ImageIcon(scaledImage));

        }
    }

    public void updateNV() {
        NhanVienModel nv = getForm();

        try {
            dao.update1(nv);
            DialogHelper.alert(this, "Cập nhật thành công!");
            ThongTinNhanVien.setSoLuong(nv.getHinh());
            ThaoTacModel ThaoTacModel = getFormUpdate();
            daoThaoTac.insert(ThaoTacModel);
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }
    String so = "0\\d{9,10}";

    public boolean check() {
//        if (Dao.findById(txtTaikhoan.getText()) != null) {
//            DialogHelper.alert(this, "Mã Nhân Viên đã tồn tại!");
//            return false;
//        }
        Date today = new Date();
        if (txtMatKhau.getText().equals("")) {
            DialogHelper.alert(this, "Mật khẩu không được để trống");
            return false;
        }
        // Get the date from the JTextField.
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySinh.getText());
            int age = (int) ((today.getTime() - date.getTime()) / (1000 * 60 * 60 * 24 * 365.25));
            if (age < 16) {
                DialogHelper.alert(this, "Tuoi khong duoc nho hon 16");
                return false;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ThongTinNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Calculate the age.
        String mk = MH.toSHA(new String(txtMatKhau.getPassword()));
        if (!mk.equals(ShareHelper.USER.getMatKhau().trim())) {
            DialogHelper.alert(this, "Mật khẩu hiện tại sai");
            return false;
        }
        if (txtHoTen.getText().equals("")) {
            DialogHelper.alert(this, "Họ và tên không được để trống");
            return false;
        }
        if (txtNgaySinh.getText().equals("")) {
            DialogHelper.alert(this, "Ngày sinh không được để trống");
            return false;
        }
        if (!txtHoTen.getText().matches("^[\\p{L}\\s]{0,50}$")) {
            DialogHelper.alert(this, "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự");
            return false;
        }
        if (txtSoDienThoai.getText().equals("")) {
            DialogHelper.alert(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txtSoDienThoai.getText().matches(so)) {
            DialogHelper.alert(this, "Số điện thoại của bạn không đúng định dạng");
            return false;
        }
        if (txtDiaChi.getText().equals("")) {
            DialogHelper.alert(this, "Địa chỉ không được để trống");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            DialogHelper.alert(this, "Email không được để trống!");
            return false;
        }
        if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            DialogHelper.alert(this, "Email không đúng định dạng!");
            return false;
        }
        if (buttonGroup1.getSelection() == null) {
            DialogHelper.alert(this, "Giới tính của bạn không được để trống");
            return false;
        }
        if (!txtNhapLaiMatKhau.getText().equals("")) {
            {
                if (txtNhapLaiMatKhau.getText().equals("")) {
                    DialogHelper.alert(this, "Mật khẩu mới để trống");
                    return false;
                }
                if (!txtNhapLaiMatKhau.getText().equals(txtNhapLaiMatKhauMoi.getText())) {
                    DialogHelper.alert(this, "Nhập lại mật khẩu không chính xác");
                    return false;
                }
            }

        }
        return true;

    }

    NhanVienModel getForm() {
        NhanVienModel cd = new NhanVienModel();

        cd.setHoTen(txtHoTen.getText());
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaySinh.getText());
            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);
            cd.setNgaySinh(ngayNhap);
        } catch (ParseException ex) {
            Logger.getLogger(ThongTinNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (rdoNam.isSelected()) {
            cd.setGioiTinh(true);
        } else {
            cd.setGioiTinh(false);
        }
        cd.setDiaChi(txtDiaChi.getText());
        cd.setSDT(txtSoDienThoai.getText());
        cd.setEmail(txtEmail.getText());
        if (!txtNhapLaiMatKhau.getText().equals("")) {
            String mk = MH.toSHA(new String(txtNhapLaiMatKhauMoi.getPassword()));
            cd.setMatKhau(mk);
        } else {
            String mk = MH.toSHA(new String(txtMatKhau.getPassword()));
            cd.setMatKhau(mk);
        }
        cd.setVaiTro(txtVaiTro.getText());
        cd.setHinh(txtHinhAnh.getToolTipText());
        cd.setMaNV(txtMaNV.getText());
        cd.setTrangThai(true);
        cd.setTrangThaiXoa(true);
        return cd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        dateChooser = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtMaNV = new com.DuAn1.Swing.TextField();
        txtNgaySinh = new com.DuAn1.Swing.TextField();
        txtHoTen = new com.DuAn1.Swing.TextField();
        txtMatKhau = new com.DuAn1.Swing.PasswordField();
        txtNhapLaiMatKhau = new com.DuAn1.Swing.PasswordField();
        txtVaiTro = new com.DuAn1.Swing.TextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtEmail = new com.DuAn1.Swing.TextField();
        button1 = new com.DuAn1.Swing.Button();
        txtSoDienThoai = new com.DuAn1.Swing.TextField();
        txtDiaChi = new com.DuAn1.Swing.TextField();
        textImage1 = new com.DuAn1.Swing.TextImage();
        txtHinh = new swing.PanelShadow();
        txtHinhAnh = new javax.swing.JLabel();
        txtNhapLaiMatKhauMoi = new com.DuAn1.Swing.PasswordField();
        button2 = new com.DuAn1.Swing.Button();

        dateChooser.setTextRefernce(txtNgaySinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtMaNV.setEditable(false);
        txtMaNV.setEnabled(false);
        txtMaNV.setLabelText("Mã nhân viên");

        txtNgaySinh.setLabelText("Ngày sinh");

        txtHoTen.setLabelText("Họ và tên");

        txtMatKhau.setLabelText("Mật khẩu hiện tại");
        txtMatKhau.setShowAndHide(true);

        txtNhapLaiMatKhau.setLabelText("Mật khẩu mới");
        txtNhapLaiMatKhau.setShowAndHide(true);

        txtVaiTro.setEnabled(false);
        txtVaiTro.setLabelText("Vai trò");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtEmail.setLabelText("Email");

        button1.setText("Cập nhật thông tin");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        txtSoDienThoai.setLabelText("Số điện thoại");

        txtDiaChi.setLabelText("Địa chỉ");

        textImage1.setText("Thông tin nhân viên");
        textImage1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N

        txtHinh.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhMouseClicked(evt);
            }
        });
        txtHinh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnhMouseClicked(evt);
            }
        });
        txtHinh.add(txtHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 140));

        txtNhapLaiMatKhauMoi.setLabelText("Xác nhận mật khẩu mới");
        txtNhapLaiMatKhauMoi.setShowAndHide(true);

        button2.setText("Xem bang luong");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(88, 88, 88)
                                .addComponent(rdoNu))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(103, 103, 103))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(textImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNhapLaiMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNhapLaiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhapLaiMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        if (check() == false) {
            return;
        }
        updateNV();
        dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void txtHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnhMouseClicked
//        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                // Hiển thị hình lên form
//                Image img = null;
//                try {
//                    img = ImageIO.read(file);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
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
    }//GEN-LAST:event_txtHinhAnhMouseClicked

    private void txtHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhMouseClicked
//        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                // Hiển thị hình lên form
//                Image img = null;
//                try {
//                    img = ImageIO.read(file);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
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
    }//GEN-LAST:event_txtHinhMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        XemLuongCaNhan Luong = new XemLuongCaNhan(com.DuAn1.main.Main.getMain(), true);
        Luong.setVisible(true);
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinNhanVien dialog = new ThongTinNhanVien(new javax.swing.JFrame(), true);
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
    private com.DuAn1.Swing.Button button1;
    private com.DuAn1.Swing.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private com.DuAn1.Swing.TextImage textImage1;
    private com.DuAn1.Swing.TextField txtDiaChi;
    private com.DuAn1.Swing.TextField txtEmail;
    private swing.PanelShadow txtHinh;
    private javax.swing.JLabel txtHinhAnh;
    private com.DuAn1.Swing.TextField txtHoTen;
    private com.DuAn1.Swing.TextField txtMaNV;
    private com.DuAn1.Swing.PasswordField txtMatKhau;
    private com.DuAn1.Swing.TextField txtNgaySinh;
    private com.DuAn1.Swing.PasswordField txtNhapLaiMatKhau;
    private com.DuAn1.Swing.PasswordField txtNhapLaiMatKhauMoi;
    private com.DuAn1.Swing.TextField txtSoDienThoai;
    private com.DuAn1.Swing.TextField txtVaiTro;
    // End of variables declaration//GEN-END:variables
}

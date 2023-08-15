/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.KhachHangDAO;
import com.tuandhpc05076.Dao.NhanVienDAO;
import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.main.Main;
import com.tuandhpc05076.MaHoa.MaHoa;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author Administrator
 */
public class ThemKH extends javax.swing.JDialog {

    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    ThongKeDao DaoThongKe = new ThongKeDao();
    MaHoa MH = new MaHoa();
    DefaultTableModel tblModel;
    String strHinh = "";
    NhanVienDAO1 dao = new NhanVienDAO1();

    

    /**
     * Creates new form ThemKH
     */
    public ThemKH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(ShareHelper.APP_ICON);
        TuDongTangMa();
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
        nv.setHinh(txtHinhAnh2.getToolTipText().trim()+nv.getMaKH().trim());

        return nv;
    }

    void ClearForm() {
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

    public boolean check() {
        String so = "0\\d{9,10}";

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
        if (txtDiachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }
        if (txtMota.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống!");
            return false;
        }
        if(!txtSdt.getText().matches(so)){
            com.tuandhpc05076.helper.DialogHelper.alert(this, "Số điện thoại bạn nhập không đúng định dạng");
        }     
        
        return true;
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

    void insert() {
        KhachHangModel nv = getForm();
        try {
            daoKH.insert(nv);
            ThaoTacModel model = getFormThem();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Thêm Mới thành công!");
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        dateChooser = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbokhach = new com.DuAn1.Swing.Combobox();
        txtNgaySinh = new com.DuAn1.Swing.TextField();
        txtDiachi = new com.DuAn1.Swing.TextField();
        txtTen = new com.DuAn1.Swing.TextField();
        txtMota = new com.DuAn1.Swing.TextField();
        txtSdt = new com.DuAn1.Swing.TextField();
        txtma = new com.DuAn1.Swing.TextField();
        jButton1 = new javax.swing.JButton();
        btnThem = new com.DuAn1.Swing.Button();
        txtHinh2 = new swing.PanelShadow();
        txtHinhAnh2 = new javax.swing.JLabel();
        cboGioitinh = new com.DuAn1.Swing.Combobox();

        dateChooser.setEnabled(false);
        dateChooser.setTextRefernce(txtNgaySinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1058, 741));

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

        jButton1.setText("Tải hình ảnh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

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
        txtHinh2.add(txtHinhAnh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 200));

        cboGioitinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
        cboGioitinh.setSelectedIndex(-1);
        cboGioitinh.setLabeText("Giới tính");
        cboGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioitinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addGap(375, 375, 375)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(txtHinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(109, 109, 109)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtHinh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(100, 100, 100))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check() == false) {
            return;
        }
        insert();
      
        HoaDon.setSoLuong(txtma.getText());
        //        BaoHanh.setSoLuong(txtma.getText());
        dispose();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtHinhAnh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnh2MouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi");
                }

                strHinh = file.getName();
                txtHinhAnh2.setText("");

                txtHinhAnh2.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh2.setToolTipText(file.getName());
                txtHinhAnh2.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }
    }//GEN-LAST:event_txtHinhAnh2MouseClicked

    private void txtHinh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinh2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinh2MouseClicked

    private void cboGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGioitinhActionPerformed

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
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemKH dialog = new ThemKH(new javax.swing.JFrame(), true);
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
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Combobox cboGioitinh;
    private com.DuAn1.Swing.Combobox cbokhach;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private com.DuAn1.Swing.TextField txtDiachi;
    private swing.PanelShadow txtHinh2;
    private javax.swing.JLabel txtHinhAnh2;
    private com.DuAn1.Swing.TextField txtMota;
    private com.DuAn1.Swing.TextField txtNgaySinh;
    private com.DuAn1.Swing.TextField txtSdt;
    private com.DuAn1.Swing.TextField txtTen;
    private com.DuAn1.Swing.TextField txtma;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DuAn1.DangNhap;

import com.raven.model.ModelCard;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import static com.tuandhpc05076.DangNhap.Login.list1;
import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.MaHoa.MaHoa;
import com.tuandhpc05076.Main.Main;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.Swing.PasswordField;
import com.DuAn1.Swing.TextField;
import com.DuAn1.component.CardRegister;
import com.tuandhpc05076.Object.O_DangNhap;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Van Vu Chi Thanh
 */
public class NewSignin extends javax.swing.JFrame {

    MaHoa MH = new MaHoa();
    NhanVienDAO1 dao = new NhanVienDAO1();
    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
    NhanVienDAO1 daonv = new NhanVienDAO1();
    MaHoa mahoa = new MaHoa();
    public static String ma = "";
    public static String Email = "";

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        NewSignin.Email = Email;
    }

    public NewSignin() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel6.setVisible(false);
        jLabel_SoftZyd.setVisible(true);
        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    public void dangNhap() throws SQLException {
        if (checkText() == false) {
            return;
        }
        String manv = txtusername.getText();
        String mk = MH.toSHA(new String(txtmatkhau.getPassword()));
        String matKhau = new String(mk);
        NhanVienModel taikhoan = null;
        taikhoan = dao.findById(manv);
        if (taikhoan == null) {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!");
        } else if (!matKhau.equals(taikhoan.getMatKhau().trim())) {
            JOptionPane.showMessageDialog(this, "Sai mật khẩu!");
        } else {
            ShareHelper.USER = taikhoan;
            ThaoTacModel model = getForm();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            com.DuAn1.main.Main main = new com.DuAn1.main.Main();
            main.setVisible(true);
            this.dispose();
        }

    }

    public ThaoTacModel getForm() {
        ThaoTacModel cd = new ThaoTacModel();
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(formatted);
        cd.setBanThaoTac("Đăng Nhập");
        cd.setMaNV(txtusername.getText());
        return cd;
    }

    public boolean checkText() {
        if (txtusername.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống tên đăng nhập");
            txtusername.requestFocus();
            return false;
        }
        if (txtusername.getText().length() > 20) {
            DialogHelper.alert(null, "Tên đăng nhập không được quá 20 kí tự");
            txtusername.requestFocus();
            return false;
        }

        if (new String(txtmatkhau.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập password");
            txtmatkhau.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel_SoftZyd = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        cardRegister2 = new com.DuAn1.component.CardRegister();
        txtEmail = new com.DuAn1.Swing.TextField();
        cardRegister3 = new com.DuAn1.component.CardRegister();
        jTextField_Email2 = new com.DuAn1.Swing.TextField();
        jButton7 = new javax.swing.JButton();
        txtmatkhau = new com.DuAn1.Swing.PasswordField();
        txtusername = new com.DuAn1.Swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Quên Mật Khẩu");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setRequestFocusEnabled(false);
        jButton1.setVerifyInputWhenFocusTarget(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconLogin-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconSwitter-removebg-preview (1).png"))); // NOI18N
        jButton2.setToolTipText("Twitter");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 28));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconFB-removebg-preview (1).png"))); // NOI18N
        jButton3.setToolTipText("Facebook");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_7.png"))); // NOI18N
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 11, -1, 28));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconInsta-removebg-preview (1).png"))); // NOI18N
        jButton4.setToolTipText("Instagram");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px_3.png"))); // NOI18N
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 11, -1, 28));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconGmail-removebg-preview (1).png"))); // NOI18N
        jButton5.setToolTipText("Email");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 11, -1, 28));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconYTB-removebg-preview (1).png"))); // NOI18N
        jButton6.setToolTipText("YouTube");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px_1.png"))); // NOI18N
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 11, -1, 28));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(169, 224, 49));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Password.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 45));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(169, 224, 49));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user-removebg-preview (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 45));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 172, 150, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconCancel-removebg-preview (1).png"))); // NOI18N
        jButton10.setToolTipText("Close");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setRequestFocusEnabled(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Cancel_30px_3.png"))); // NOI18N
        jButton10.setVerifyInputWhenFocusTarget(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 40));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconminus-removebg-preview (1).png"))); // NOI18N
        jButton11.setToolTipText("Minimize");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setFocusPainted(false);
        jButton11.setRequestFocusEnabled(false);
        jButton11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Minus_30px_3.png"))); // NOI18N
        jButton11.setVerifyInputWhenFocusTarget(false);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 40, 40));

        jLabel_SoftZyd.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel_SoftZyd.setForeground(new java.awt.Color(0, 102, 204));
        jLabel_SoftZyd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-removebg-preview (1).png"))); // NOI18N
        jLabel_SoftZyd.setText("TTA MOBILE");
        jPanel3.add(jLabel_SoftZyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 314, 70));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-removebg-preview (1).png"))); // NOI18N
        jLabel13.setText("TTA MOBILE");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 310, 100));

        jButton14.setBackground(new java.awt.Color(0, 102, 204));
        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(0, 102, 204));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconBackTo-removebg-preview (1).png"))); // NOI18N
        jButton14.setText("Quay lại");
        jButton14.setBorder(null);
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setRequestFocusEnabled(false);
        jButton14.setVerifyInputWhenFocusTarget(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 110, -1));

        jButton8.setBackground(new java.awt.Color(0, 102, 204));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Xác nhận");
        jButton8.setBorder(null);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 330, 40));
        jPanel6.add(cardRegister2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, 30));

        txtEmail.setToolTipText("200");
        txtEmail.setLabelText("Nhập Email");
        jPanel6.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 310, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 550));

        cardRegister3.setBackground(new java.awt.Color(102, 0, 102));
        jPanel3.add(cardRegister3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 620));

        jTextField_Email2.setCaretColor(new java.awt.Color(0, 102, 204));
        jTextField_Email2.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        jTextField_Email2.setLabelText("Tài khoản");
        jTextField_Email2.setLineColor(new java.awt.Color(0, 102, 204));
        jTextField_Email2.setSelectedTextColor(new java.awt.Color(169, 224, 49));
        jPanel3.add(jTextField_Email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 330, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 450, 620));

        jButton7.setBackground(new java.awt.Color(0, 102, 204));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Đăng nhập");
        jButton7.setBorder(null);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 260, 40));

        txtmatkhau.setText("123");
        txtmatkhau.setCaretColor(new java.awt.Color(0, 102, 204));
        txtmatkhau.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtmatkhau.setLabelText("Mật khẩu");
        txtmatkhau.setLineColor(new java.awt.Color(0, 102, 204));
        txtmatkhau.setSelectedTextColor(new java.awt.Color(169, 224, 49));
        txtmatkhau.setSelectionColor(new java.awt.Color(169, 224, 49));
        txtmatkhau.setShowAndHide(true);
        jPanel1.add(txtmatkhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 260, -1));

        txtusername.setText("NV001");
        txtusername.setLabelText("Tài khoản");
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel_SoftZyd.setVisible(false);
        jPanel6.setVisible(true);
        //       jLabel7.setVisible(false);
        //       jLabel8.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    public static ArrayList<O_DangNhap> list1 = new ArrayList<>();
    O_DangNhap dn = new O_DangNhap();
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {
            //        String user = txtusername.getText();
//        String pass = txtmatkhau.getText();
//
//        if (user.equals("admin") && pass.equals("123")) {
//            com.raven.main.Main main = new com.raven.main.Main();
//            main.setVisible(true);
//            this.dispose();
//        } else {
//
//            JOptionPane.showMessageDialog(null, "Email or Password Invalid");
//        }
            dangNhap();
        } catch (SQLException ex) {
            Logger.getLogger(NewSignin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        List<NhanVienModel> list = daonv.select();
        boolean kiem = true;
        for (NhanVienModel nv : list) {
            if (nv.getEmail().equals(txtEmail.getText())) {
                kiem = false;
            }
        }
        NewSignin.setEmail(txtEmail.getText());
        if (kiem == false) {
            try {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);
                String accountName = "hoangtuan97531@gmail.com";
                String accountPassword = "sjwomehzrjwnafpd";

                Session s = Session.getInstance(p,
                        new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(accountName, accountPassword);
                    }
                });
                String form = "hoangtuan97531@gmail.com";
                ;
                String subject = "Quên mật khẩu";
                Random random = new Random();
                int number = random.nextInt(10000) % 10000;
                String body = String.valueOf(number);
                String ccmail = txtEmail.getText();
                Message msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress(form));
//                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tos));
//                if (!txtduongdan.getText().equals("")) {
                msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccmail));
//                }
                MimeBodyPart contenPart = new MimeBodyPart();
                contenPart.setContent(body, "text/html; charset=utf-8");
                msg.setSubject(subject);
                msg.setText(body);
//                if (!txtduongdan.getText().equals("")) {
//                    MimeBodyPart filepart = new MimeBodyPart();
//                    File file = new File(duongdan);
//                    FileDataSource fds = new FileDataSource(file);
//                    filepart.setDataHandler(new DataHandler(fds));
//                    filepart.setFileName(file.getName());
//                    MimeMultipart multipart = new MimeMultipart();
//                    multipart.addBodyPart(contenPart);
//                    multipart.addBodyPart(filepart);
//                    msg.setContent(multipart);
//                }
                ma = String.valueOf(number);
                Transport.send(msg);
                String a = JOptionPane.showInputDialog(this, "Nhập mã");
                if (a.equals(String.valueOf(number))) {

                    XacNhaThayDoiMatKhau xacNhan = new XacNhaThayDoiMatKhau(this, true);
                    xacNhan.setVisible(true);
//                    NhanVienModel nv = getForm1();
//                    daonv.quenMK(nv);
//                    DialogHelper.alert(this, "Xác nhận mã thành công");
                } else {
                    DialogHelper.alert(this, "Xác nhận mật khẩu không thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            DialogHelper.alert(this, "Email bạn nhập không tồn tại");
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    NhanVienModel getForm1() {
        NhanVienModel nv = new NhanVienModel();
        String name = mahoa.toSHA(ma);
        nv.setMatKhau(name);
        nv.setEmail(txtEmail.getText());
        return nv;
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jPanel6.setVisible(false);
        jLabel_SoftZyd.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSignin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.component.CardRegister cardRegister2;
    private com.DuAn1.component.CardRegister cardRegister3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_SoftZyd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private com.DuAn1.Swing.TextField jTextField_Email2;
    private com.DuAn1.Swing.TextField txtEmail;
    private com.DuAn1.Swing.PasswordField txtmatkhau;
    private com.DuAn1.Swing.TextField txtusername;
    // End of variables declaration//GEN-END:variables
}

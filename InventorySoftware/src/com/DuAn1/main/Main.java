package com.DuAn1.main;

import com.DuAn1.component.Header;
import com.DuAn1.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.Form1;
import com.raven.form.Form_Home;
import com.raven.form.MainForm;
import com.DuAn1.swing1.MenuItem;
import com.DuAn1.swing1.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.DuAn1.BieuDo.FormHome;
import com.DuAn1.ThoiGian.Time;
import com.DuAn1.form.BaoHanh;
import com.DuAn1.form.DaXoa;
import com.DuAn1.form.SanPham;
import com.DuAn1.form.DatHang1;
import com.DuAn1.form.DongMay;
import com.DuAn1.form.ThanhToanLuong;
import com.DuAn1.form.GiamGia;
import com.DuAn1.form.HoaDon;
import com.DuAn1.form.KhachHang;
import com.DuAn1.form.LichSu;
import com.DuAn1.form.NhanVien;
import com.DuAn1.form.ThongTinNhanVien;
import com.DuAn1.form.VaiTro;
import com.DuAn1.DangNhap.NewSignin;
import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.form.DaXoaKH;
import com.DuAn1.form.DaXoaSP;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;

    private Animator animator;
    private static Main main1;

    public Main() {
        initComponents();
        Time time = new Time(txtThoiGian);
        time.start();
        titleBar1.initJFram(this);
        init();
        lbUserName.setText(ShareHelper.USER.getMaNV());
        lbRole.setText(ShareHelper.USER.getVaiTro());
        NhanVienDAO1 dao= new NhanVienDAO1();
        NhanVienModel nv =dao.findById(lbUserName.getText());
        if (nv != null) {
            pic.setToolTipText(nv.getHinh());
            pic.setIcon(ShareHelper.readLogo(nv.getHinh()));
        }main.repaint(); 
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new Form_Home());
                } else if (menuIndex == 1) {
                    if (subMenuIndex == 0) {
                        main.showForm(new com.DuAn1.MainAn.MainAn());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new com.DuAn1.MainAn.MainAn1());
                    } else if (subMenuIndex == 2) {
                        main.showForm(new com.DuAn1.MainAn.MainAn2());
                    } else if (subMenuIndex == 3) {
                        main.showForm(new LichSu());
                    }
                } else if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
                        main.showForm(new SanPham());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new DongMay());
                    } else if (subMenuIndex == 2) {
                        main.showForm(new DaXoaSP());
                    }
                } else if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
                        main.showForm(new DatHang1());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new DaXoa());
                    }
                } else if (menuIndex == 4) {
                    if (subMenuIndex == 0) {
                        main.showForm(new HoaDon());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new BaoHanh());
                    }
                } else if (menuIndex == 5) {
                    main.showForm(new GiamGia());
                } else if (menuIndex == 6) {
                    if (subMenuIndex == 0) {
                        main.showForm(new NhanVien());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new VaiTro());
                    } else if (subMenuIndex == 2) {
                        main.showForm(new DaXoa());
                    }

                } else if (menuIndex == 7) {
                    if (subMenuIndex == 0) {
                        main.showForm(new KhachHang());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new DaXoaKH());
                    }
                } else if (menuIndex == 8) {

                    main.showForm(new ThanhToanLuong());

                } else if (menuIndex == 9) {
                    if (subMenuIndex == 0) {
                        NewSignin quen = new NewSignin();
                        quen.setVisible(true);
                        dispose();
                    } else if (subMenuIndex == 1) {
                        System.exit(0);
                    }
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 40!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Form_Home());
    }

    public static Main getMain() {
        return main1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        titleBar1 = new javaswingdev.swing.titlebar.TitleBar();
        pic = new com.DuAn1.swing1.ImageAvatar();
        lbRole = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        txtThoiGian = new javax.swing.JLabel();
        txtThoiGian1 = new javax.swing.JLabel();
        txtThoiGian2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);
        bg.setPreferredSize(new java.awt.Dimension(1100, 700));
        bg.setLayout(new java.awt.BorderLayout());
        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1315, 46));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg"))); // NOI18N
        pic.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                picAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                picMousePressed(evt);
            }
        });

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Admin");

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(127, 127, 127));
        lbUserName.setText("User Name");

        txtThoiGian.setBackground(new java.awt.Color(255, 0, 51));
        txtThoiGian.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGian.setText("jLabel1");

        txtThoiGian1.setBackground(new java.awt.Color(255, 0, 51));
        txtThoiGian1.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGian1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        txtThoiGian1.setText("Giới thiệu");

        txtThoiGian2.setBackground(new java.awt.Color(255, 0, 51));
        txtThoiGian2.setForeground(new java.awt.Color(0, 0, 0));
        txtThoiGian2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconGmail-removebg-preview (1).png"))); // NOI18N
        txtThoiGian2.setText("Hướng dẫn sử dụng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(txtThoiGian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addComponent(txtThoiGian2)
                .addGap(126, 126, 126)
                .addComponent(txtThoiGian1)
                .addGap(262, 262, 262)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUserName)
                    .addComponent(lbRole))
                .addGap(18, 18, 18)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbRole)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThoiGian)
                        .addComponent(txtThoiGian1)
                        .addComponent(txtThoiGian2)))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void picAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_picAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_picAncestorAdded

    private void picMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseClicked
        ThongTinNhanVien tt = new ThongTinNhanVien(Main.getMain(), false);
        tt.setVisible(true);
         NhanVienDAO1 dao = new NhanVienDAO1();
        NhanVienModel nv =dao.findById(lbUserName.getText());
        if (nv != null) {
            pic.setToolTipText(ThongTinNhanVien.getSoLuong());
            pic.setIcon(ShareHelper.readLogo(ThongTinNhanVien.getSoLuong()));
        }  
        
        // TODO add your handling code here:
    }//GEN-LAST:event_picMouseClicked

    private void picMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMousePressed
             // TODO add your handling code here:
    }//GEN-LAST:event_picMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private com.DuAn1.swing1.ImageAvatar pic;
    private javaswingdev.swing.titlebar.TitleBar titleBar1;
    private javax.swing.JLabel txtThoiGian;
    private javax.swing.JLabel txtThoiGian1;
    private javax.swing.JLabel txtThoiGian2;
    // End of variables declaration//GEN-END:variables
}

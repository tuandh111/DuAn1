/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DuAn1.test;

import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.SanPhamModel;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author raven
 */
public class Slide1 extends javax.swing.JPanel {
    ThongKeDao DaoThongKe = new ThongKeDao();
    SanPhamDAO daoSP = new SanPhamDAO();
    public Slide1() {
        initComponents();
//        pictureBox1.setImage(new ImageIcon(getClass().getResource("")));
//thongke();

        List<SanPhamModel> list= daoSP.selectTop3();
        int i=0;
        for (SanPhamModel sanPhamModel : list) {
            if(i==0){
                pictureBox1.setImage(ShareHelper.readLogo(sanPhamModel.getHinh().trim()));
                txtTenSP.setText(sanPhamModel.getTenSP());
                break;
            }
            i++;
        }
    }

//    public void thongke(){
//         List<Object[]> j = DaoThongKe.Top3SP();
//         
//         String name = (String) j.get(0)[1];
//         if(name!=null)
//         pictureBox1.setImage(new ImageIcon(getClass().getResource("/logos"+name)));
//      
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new swing.PictureBox_1();
        panelTransparent1 = new swing.PanelTransparent();
        txtTenSP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Images/Iphone.jpg"))); // NOI18N

        panelTransparent1.setBackground(new java.awt.Color(255, 255, 255));
        panelTransparent1.setAlpha(0.5F);

        txtTenSP.setFont(new java.awt.Font("sansserif", 1, 40)); // NOI18N
        txtTenSP.setForeground(new java.awt.Color(255, 0, 0));
        txtTenSP.setText("Iphone 14");

        javax.swing.GroupLayout panelTransparent1Layout = new javax.swing.GroupLayout(panelTransparent1);
        panelTransparent1.setLayout(panelTransparent1Layout);
        panelTransparent1Layout.setHorizontalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        panelTransparent1Layout.setVerticalGroup(
            panelTransparent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenSP)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hand.png"))); // NOI18N
        jButton1.setText(" Visit Here");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pictureBox1.setLayer(panelTransparent1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pictureBox1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pictureBox1Layout = new javax.swing.GroupLayout(pictureBox1);
        pictureBox1.setLayout(pictureBox1Layout);
        pictureBox1Layout.setHorizontalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pictureBox1Layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        pictureBox1Layout.setVerticalGroup(
            pictureBox1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pictureBox1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(pictureBox1Layout.createSequentialGroup()
                .addComponent(panelTransparent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "You click visit here");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private swing.PanelTransparent panelTransparent1;
    private swing.PictureBox_1 pictureBox1;
    private javax.swing.JLabel txtTenSP;
    // End of variables declaration//GEN-END:variables
}

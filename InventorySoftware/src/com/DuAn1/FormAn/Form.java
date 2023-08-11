/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.FormAn;

import com.DuAn1.ChartAn.ModelChart;
import com.DuAn1.Dao.ThongKeDao;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author trana
 */
public class Form extends javax.swing.JPanel {

    ThongKeDao DaoThongKe = new ThongKeDao();

    public Form() {
        initComponents();
        setOpaque(false);
        init();

    }

    private void init() {
        int IphoneT1 = 0; int IphoneT2 = 0;int IphoneT3 = 0;int IphoneT4 = 0;int IphoneT5 = 0;int IphoneT6 = 0;int IphoneT7 = 0;int IphoneT8 = 0;int IphoneT9 = 0;int IphoneT10 = 0;int IphoneT11 = 0;int IphoneT12 = 0;
        int SamsungT1 = 0; int SamsungT2 = 0;int SamsungT3 = 0;int SamsungT4 = 0;int SamsungT5 = 0;int SamsungT6 = 0;int SamsungT7 = 0;int SamsungT8 = 0;int SamsungT9 = 0;int SamsungT10 = 0;int SamsungT11 = 0;int SamsungT12 = 0;
        int SonyT1 = 0;int SonyT2 = 0;int SonyT3 = 0;int SonyT4 = 0;int SonyT5 = 0;int SonyT6 = 0;int SonyT7 = 0;int SonyT8 = 0;int SonyT9 = 0;int SonyT10 = 0;int SonyT11 = 0;int SonyT12 = 0;
        
        List<Object[]> list = DaoThongKe.getThongKeTungLoaiSP();

        chart.addLegend("Iphone", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Samsung", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Sony", new Color(5, 125, 0), new Color(95, 209, 69));
        for (Object[] objects : list) {
            if (objects[0].equals(1) && objects[1].equals("Sony")) {
                SonyT1 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(1) && objects[1].equals("SamSung")) {
                SamsungT1 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(1) && objects[1].equals("Iphone")) {
                IphoneT1 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(2) && objects[1].equals("Sony")) {
                SonyT2 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(2) && objects[1].equals("SamSung")) {
                SamsungT2 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(2) && objects[1].equals("Iphone")) {
                IphoneT2 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(3) && objects[1].equals("Sony")) {
                SonyT3 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(3) && objects[1].equals("SamSung")) {
                SamsungT3 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(3) && objects[1].equals("Iphone")) {
                IphoneT3 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(4) && objects[1].equals("Sony")) {
                SonyT4 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(4) && objects[1].equals("SamSung")) {
                SamsungT4 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(4) && objects[1].equals("Iphone")) {
                IphoneT4 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(5) && objects[1].equals("Sony")) {
                SonyT5 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(5) && objects[1].equals("SamSung")) {
                SamsungT5 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(5) && objects[1].equals("Iphone")) {
                IphoneT5 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(6) && objects[1].equals("Sony")) {
                SonyT6 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(6) && objects[1].equals("SamSung")) {
                SamsungT6 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(6) && objects[1].equals("Iphone")) {
                IphoneT6 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(7) && objects[1].equals("Sony")) {
                SonyT7 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(7) && objects[1].equals("SamSung")) {
                SamsungT7 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(7) && objects[1].equals("Iphone")) {
                IphoneT7 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(8) && objects[1].equals("Sony")) {
                SonyT8 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(8) && objects[1].equals("SamSung")) {
                SamsungT8 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(8) && objects[1].equals("Iphone")) {
                IphoneT8 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(9) && objects[1].equals("Sony")) {
                SonyT9 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(9) && objects[1].equals("SamSung")) {
                SamsungT9 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(9) && objects[1].equals("Iphone")) {
                IphoneT9 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(10) && objects[1].equals("Sony")) {
                SonyT10 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(10) && objects[1].equals("SamSung")) {
                SamsungT10 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(10) && objects[1].equals("Iphone")) {
                IphoneT10 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(11) && objects[1].equals("Sony")) {
                SonyT11 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(11) && objects[1].equals("SamSung")) {
                SamsungT11 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(11) && objects[1].equals("Iphone")) {
                IphoneT11 = Integer.parseInt(objects[2].toString());
            }
             if (objects[0].equals(12) && objects[1].equals("Sony")) {
                SonyT12 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(12) && objects[1].equals("SamSung")) {
                SamsungT12 = Integer.parseInt(objects[2].toString());
            }
            if (objects[0].equals(12) && objects[1].equals("Iphone")) {
                IphoneT12 = Integer.parseInt(objects[2].toString());
            }
        }
        chart.addData(new ModelChart("Tháng 1", new double[]{IphoneT1, SamsungT1, SonyT1}));
        chart.addData(new ModelChart("Tháng 2",new double[]{IphoneT2, SamsungT2, SonyT2}));
        chart.addData(new ModelChart("Tháng 3",new double[]{IphoneT3, SamsungT3, SonyT3}));
        chart.addData(new ModelChart("Tháng 4", new double[]{IphoneT4, SamsungT4, SonyT4}));
        chart.addData(new ModelChart("Tháng 5", new double[]{IphoneT5, SamsungT5, SonyT5}));
        chart.addData(new ModelChart("Tháng 6", new double[]{IphoneT6, SamsungT6, SonyT6}));
        chart.addData(new ModelChart("Tháng 7", new double[]{IphoneT7, SamsungT7, SonyT7}));
        chart.addData(new ModelChart("Tháng 8",new double[]{IphoneT8, SamsungT8, SonyT8}));
        chart.addData(new ModelChart("Tháng 9", new double[]{IphoneT9, SamsungT9, SonyT9}));
        chart.addData(new ModelChart("Tháng 10",new double[]{IphoneT10, SamsungT10, SonyT10}));
        chart.addData(new ModelChart("Tháng 11", new double[]{IphoneT11, SamsungT11, SonyT11}));
        chart.addData(new ModelChart("Tháng 12", new double[]{IphoneT12, SamsungT12, SonyT12}));

        chart.start();
//        lineChart.addLegend("ND1", new Color(12, 84, 175), new Color(0, 108, 247));
//        lineChart.addLegend("ND2", new Color(54, 4, 143), new Color(104, 49, 200));
//        lineChart.addLegend("ND3", new Color(5, 125, 0), new Color(95, 209, 69));
//        lineChart.addData(new ModelChart("Tháng 1", new double[]{500, 200, 80, 89}));
//        lineChart.addData(new ModelChart("Tháng 2", new double[]{600, 750, 90, 150}));
//        lineChart.addData(new ModelChart("Tháng 3", new double[]{300, 400, 85, 189}));
//        lineChart.addData(new ModelChart("Tháng 4", new double[]{100, 290, 980, 189}));
//        lineChart.addData(new ModelChart("Tháng 5", new double[]{500, 200, 180, 189}));
//        lineChart.start();
//        progress1.start();
//        progress2.start();
//        progress3.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.DuAn1.SwingAn.RoundPanel();
        roundPanel4 = new com.DuAn1.SwingAn.RoundPanel();
        roundPanel5 = new com.DuAn1.SwingAn.RoundPanel();
        chart = new com.DuAn1.ChartAn.Chart();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        roundPanel4.setBackground(new java.awt.Color(0, 51, 51));
        roundPanel4.setLayout(new java.awt.BorderLayout());

        roundPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Số lượng sản phẩm nhập từng tháng");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(560, 560, 560)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(roundPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.ChartAn.Chart chart;
    private javax.swing.JLabel jLabel2;
    private com.DuAn1.SwingAn.RoundPanel roundPanel1;
    private com.DuAn1.SwingAn.RoundPanel roundPanel4;
    private com.DuAn1.SwingAn.RoundPanel roundPanel5;
    // End of variables declaration//GEN-END:variables
}

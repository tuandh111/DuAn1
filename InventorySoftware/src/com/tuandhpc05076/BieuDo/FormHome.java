/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.tuandhpc05076.BieuDo;

import com.tuandhpc05076.Form.ThongKeBangDiem;
import com.tuandhpc05076.Form.ThongKeDoanhThu;
import static com.tuandhpc05076.Form.ThongKeDoanhThu.listDoanhThu;
import com.tuandhpc05076.Object.O_ThongKeDoanhThu;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class FormHome extends javax.swing.JPanel {
    public FormHome() {
        initComponents();
       

        chart.addLegend("Doanh thu chuyên đề", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Thu nhập", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Khoảng chi", new Color(12, 84, 175), new Color(0, 108, 247));
        
        chart.addLegend("Thu Nhập", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Khoản chi", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("2021", new double[]{0,100,100}));
        chart.addData(new ModelChart("2022", new double[]{0,99,77}));
        chart.addData(new ModelChart("2023", new double[]{10,100,67}));
        chart.addData(new ModelChart("2022", new double[]{0,99,72}));
        chart.addData(new ModelChart("2023", new double[]{18,101,67}));


        chart.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chart = new com.tuandhpc05076.BieuDo.CurveChart();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        chart.setBackground(new java.awt.Color(0, 0, 0));
        chart.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tuandhpc05076.BieuDo.CurveChart chart;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

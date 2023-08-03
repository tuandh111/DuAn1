/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.MainAn;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.chart.ModelChart;
import com.DuAn1.test.DatabaseConnection;
import com.DuAn1.test.ModelData;

/**
 *
 * @author DELL E5470
 */
public class MainAn2 extends javax.swing.JPanel {

    /**
     * Creates new form MainAn2
     */
     public MainAn2() {
        initComponents();
        chart.setTitle("Doanh thu năm");
        chart.addLegend("IPhone", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Samsung", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Sony", Color.decode("#0099F7"), Color.decode("#F11712"));
        test();
    }

    private void setData() {
        try {
            List<ModelData> lists = new ArrayList<>();
            DatabaseConnection.getInstance().connectToDatabase();
            String sql = "select DATE_FORMAT(Date,'%M') as `Month`, SUM(TotalAmount) as Amount, SUM(TotalCost) as Cost, SUM(TotalProfit) as Profit from orders group by DATE_FORMAT(Date,'%m%Y') order by Date DESC limit 7";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String month = r.getString("Month");
                double amount = r.getDouble("Amount");
                double cost = r.getDouble("Cost");
                double profit = r.getDouble("Profit");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            r.close();
            p.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test() {
        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{500000000, 500000000, 1008757743}));
        chart.addData(new ModelChart("Tháng 2", new double[]{600000080, 300000000, 150000000}));
        chart.addData(new ModelChart("Tháng 3", new double[]{200765435, 509875424, 900975435}));
        chart.addData(new ModelChart("Tháng 4", new double[]{480676467, 700964677, 1008765432}));
        chart.addData(new ModelChart("Tháng 5", new double[]{350765456, 540987888, 500987654}));
        chart.addData(new ModelChart("Tháng 6", new double[]{450767856, 800987777, 100998755}));
         chart.addData(new ModelChart("Tháng 7", new double[]{60004500, 300045000, 150004400}));
        chart.addData(new ModelChart("Tháng 8", new double[]{200765435, 509875424, 900975435}));
        chart.addData(new ModelChart("Tháng 9", new double[]{480673567, 700964677, 100875432}));
        chart.addData(new ModelChart("Tháng 10", new double[]{350765456, 540987888, 50087654}));
         chart.addData(new ModelChart("Tháng 11", new double[]{60000000, 300004540, 15000000}));
        chart.addData(new ModelChart("Tháng 12", new double[]{200765435, 509875423, 902975435}));
        chart.start();
    }
        private void test1() {
        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{50000500, 500500000, 100857743}));
        chart.addData(new ModelChart("Tháng 2", new double[]{600005460, 300005000, 15000000}));
        chart.addData(new ModelChart("Tháng 3", new double[]{200576535, 509857424, 900975435}));
        chart.addData(new ModelChart("Tháng 4", new double[]{486576467, 700964677, 100865432}));
        chart.addData(new ModelChart("Tháng 5", new double[]{355076546, 540987888, 500987654}));
        chart.addData(new ModelChart("Tháng 6", new double[]{450576756, 800987777, 100998755}));
         chart.addData(new ModelChart("Tháng 7", new double[]{60050500, 300045000, 15000400}));
        chart.addData(new ModelChart("Tháng 8", new double[]{20075435, 509875424, 900975435}));
        chart.addData(new ModelChart("Tháng 9", new double[]{48073567, 700964677, 100875432}));
        chart.addData(new ModelChart("Tháng 10", new double[]{357565456, 540987888, 500857654}));
         chart.addData(new ModelChart("Tháng 11", new double[]{60000050, 300004540, 15000000}));
        chart.addData(new ModelChart("Tháng 12", new double[]{200754355, 509875235, 90975435}));
        chart.start();
    }
            private void test2() {
        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{500000000, 500000000, 1008757743}));
        chart.addData(new ModelChart("Tháng 2", new double[]{600000043, 300000000, 150000000}));
        chart.addData(new ModelChart("Tháng 3", new double[]{200765435, 509875424, 900975435}));
        chart.addData(new ModelChart("Tháng 4", new double[]{480676467, 700964677, 1008765432}));
        chart.addData(new ModelChart("Tháng 5", new double[]{350765456, 540987888, 500987654}));
        chart.addData(new ModelChart("Tháng 6", new double[]{450767856, 800987777, 100998755}));
         chart.addData(new ModelChart("Tháng 7", new double[]{60004500, 300045000, 150004400}));
        chart.addData(new ModelChart("Tháng 8", new double[]{20095435, 50875424, 9097535}));
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

        chart = new raven.chart.CurveLineChart();
        cboNhanVien = new com.DuAn1.Swing.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        chart.setForeground(new java.awt.Color(0, 0, 0));
        chart.setFillColor(true);

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2021", "2022", "2023" }));
        cboNhanVien.setSelectedIndex(-1);
        cboNhanVien.setLabeText("Chọn năm");
        cboNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboNhanVienMouseClicked(evt);
            }
        });
        cboNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboNhanVienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhanVienMouseClicked

    private void cboNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienActionPerformed
        // TODO add your handling code here:

      if(cboNhanVien.getSelectedItem().equals("2021")){
      test();
      }else if(cboNhanVien.getSelectedItem().equals("2022")){
          test1();
      }else{
          test2();
      }
    }//GEN-LAST:event_cboNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Combobox cboNhanVien;
    private raven.chart.CurveLineChart chart;
    // End of variables declaration//GEN-END:variables
}

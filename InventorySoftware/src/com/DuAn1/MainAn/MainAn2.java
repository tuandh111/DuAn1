/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.MainAn;

import com.DuAn1.Dao.ThongKeDao;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.chart.ModelChart;
import com.DuAn1.test.DatabaseConnection;
import com.DuAn1.test.ModelData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;

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
        chart.addLegend("Doanh thu", Color.decode("#7b4397"), Color.decode("#dc2430"));
//        chart.addLegend("Samsung", Color.decode("#e65c00"), Color.decode("#F9D423"));
//        chart.addLegend("Sony", Color.decode("#0099F7"), Color.decode("#F11712"));
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formatted = current.format(formatter);
        int nam = Integer.parseInt(formatted);
        DefaultComboBoxModel df = new DefaultComboBoxModel();
        for (int i = 0; i <= nam - 2021; i++) {
            df.addElement(2021 + i);
        }
        cboNhanVien.setModel(df);
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
    ThongKeDao daoThongKe = new ThongKeDao();

    private void test() {
        double Thang1 = 0;
        double Thang2 = 0;
        double Thang3 = 0;
        double Thang4 = 0;
        double Thang5 = 0;
        double Thang6 = 0;
        double Thang7 = 0;
        double Thang8 = 0;
        double Thang9 = 0;
        double Thang10 = 0;
        double Thang11 = 0;
        double Thang12 = 0;
        List<Object[]> daoThongKe1 = daoThongKe.getThongKeDoanhThuTungNamTrongTungThang(2021);
        for (Object[] objects : daoThongKe1) {
            if (objects[1].equals(1)) {
                Thang1 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(2)) {
                Thang2 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(3)) {
                Thang3 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(4)) {
                Thang4 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(5)) {
                Thang5 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(6)) {
                Thang6 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(7)) {
                Thang7 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(8)) {
                Thang8 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(9)) {
                Thang9 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(10)) {
                Thang10 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(11)) {
                Thang11 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(12)) {
                Thang12 = Double.parseDouble(objects[2].toString());
            }
        }

        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{Thang1}));
        chart.addData(new ModelChart("Tháng 2", new double[]{Thang2}));
        chart.addData(new ModelChart("Tháng 3", new double[]{Thang3}));
        chart.addData(new ModelChart("Tháng 4", new double[]{Thang4}));
        chart.addData(new ModelChart("Tháng 5", new double[]{Thang5}));
        chart.addData(new ModelChart("Tháng 6", new double[]{Thang6}));
        chart.addData(new ModelChart("Tháng 7", new double[]{Thang7}));
        chart.addData(new ModelChart("Tháng 8", new double[]{Thang8}));
        chart.addData(new ModelChart("Tháng 9", new double[]{Thang9}));
        chart.addData(new ModelChart("Tháng 10", new double[]{Thang10}));
        chart.addData(new ModelChart("Tháng 11", new double[]{Thang11}));
        chart.addData(new ModelChart("Tháng 12", new double[]{Thang12}));
        chart.start();
    }

    private void test1() {
        double Thang1 = 0;
        double Thang2 = 0;
        double Thang3 = 0;
        double Thang4 = 0;
        double Thang5 = 0;
        double Thang6 = 0;
        double Thang7 = 0;
        double Thang8 = 0;
        double Thang9 = 0;
        double Thang10 = 0;
        double Thang11 = 0;
        double Thang12 = 0;
        List<Object[]> daoThongKe1 = daoThongKe.getThongKeDoanhThuTungNamTrongTungThang(2022);
        for (Object[] objects : daoThongKe1) {
            if (objects[1].equals(1)) {
                Thang1 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(2)) {
                Thang2 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(3)) {
                Thang3 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(4)) {
                Thang4 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(5)) {
                Thang5 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(6)) {
                Thang6 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(7)) {
                Thang7 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(8)) {
                Thang8 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(9)) {
                Thang9 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(10)) {
                Thang10 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(11)) {
                Thang11 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(12)) {
                Thang12 = Double.parseDouble(objects[2].toString());
            }
        }

        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{Thang1}));
        chart.addData(new ModelChart("Tháng 2", new double[]{Thang2}));
        chart.addData(new ModelChart("Tháng 3", new double[]{Thang3}));
        chart.addData(new ModelChart("Tháng 4", new double[]{Thang4}));
        chart.addData(new ModelChart("Tháng 5", new double[]{Thang5}));
        chart.addData(new ModelChart("Tháng 6", new double[]{Thang6}));
        chart.addData(new ModelChart("Tháng 7", new double[]{Thang7}));
        chart.addData(new ModelChart("Tháng 8", new double[]{Thang8}));
        chart.addData(new ModelChart("Tháng 9", new double[]{Thang9}));
        chart.addData(new ModelChart("Tháng 10", new double[]{Thang10}));
        chart.addData(new ModelChart("Tháng 11", new double[]{Thang11}));
        chart.addData(new ModelChart("Tháng 12", new double[]{Thang12}));
        chart.start();
    }

    private void test2() {
        double Thang1 = 0;
        double Thang2 = 0;
        double Thang3 = 0;
        double Thang4 = 0;
        double Thang5 = 0;
        double Thang6 = 0;
        double Thang7 = 0;
        double Thang8 = 0;
        double Thang9 = 0;
        double Thang10 = 0;
        double Thang11 = 0;
        double Thang12 = 0;
        List<Object[]> daoThongKe1 = daoThongKe.getThongKeDoanhThuTungNamTrongTungThang((int) cboNhanVien.getSelectedItem());
        for (Object[] objects : daoThongKe1) {
            if (objects[1].equals(1)) {
                Thang1 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(2)) {
                Thang2 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(3)) {
                Thang3 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(4)) {
                Thang4 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(5)) {
                Thang5 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(6)) {
                Thang6 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(7)) {
                Thang7 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(8)) {
                Thang8 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(9)) {
                Thang9 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(10)) {
                Thang10 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(11)) {
                Thang11 = Double.parseDouble(objects[2].toString());
            }
            if (objects[1].equals(12)) {
                Thang12 = Double.parseDouble(objects[2].toString());
            }
        }

        chart.clear();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy");
        String formatted = current.format(formatter);
        String formatted1 = current.format(formatter1);
        if (Integer.parseInt(formatted1) > (int) cboNhanVien.getSelectedItem()) {
            chart.addData(new ModelChart("Tháng 1", new double[]{Thang1}));
            chart.addData(new ModelChart("Tháng 2", new double[]{Thang2}));
            chart.addData(new ModelChart("Tháng 3", new double[]{Thang3}));
            chart.addData(new ModelChart("Tháng 4", new double[]{Thang4}));
            chart.addData(new ModelChart("Tháng 5", new double[]{Thang5}));
            chart.addData(new ModelChart("Tháng 6", new double[]{Thang6}));
            chart.addData(new ModelChart("Tháng 7", new double[]{Thang7}));
            chart.addData(new ModelChart("Tháng 8", new double[]{Thang8}));
            chart.addData(new ModelChart("Tháng 9", new double[]{Thang9}));
            chart.addData(new ModelChart("Tháng 10", new double[]{Thang10}));
            chart.addData(new ModelChart("Tháng 11", new double[]{Thang11}));
            chart.addData(new ModelChart("Tháng 12", new double[]{Thang12}));
        } else {
            if (Integer.parseInt(formatted) > 0) {
                chart.addData(new ModelChart("Tháng 1", new double[]{Thang1}));
            }
            if (Integer.parseInt(formatted) > 1) {
                chart.addData(new ModelChart("Tháng 2", new double[]{Thang2}));
            }
            if (Integer.parseInt(formatted) > 2) {
                chart.addData(new ModelChart("Tháng 3", new double[]{Thang3}));
            }
            if (Integer.parseInt(formatted) > 3) {
                chart.addData(new ModelChart("Tháng 4", new double[]{Thang4}));
            }
            if (Integer.parseInt(formatted) > 4) {
                chart.addData(new ModelChart("Tháng 5", new double[]{Thang5}));
            }
            if (Integer.parseInt(formatted) > 5) {
                chart.addData(new ModelChart("Tháng 6", new double[]{Thang6}));
            }
            if (Integer.parseInt(formatted) > 6) {
                chart.addData(new ModelChart("Tháng 7", new double[]{Thang7}));
            }
            if (Integer.parseInt(formatted) > 7) {
                chart.addData(new ModelChart("Tháng 8", new double[]{Thang8}));
            }
            if (Integer.parseInt(formatted) > 8) {
                chart.addData(new ModelChart("Tháng 9", new double[]{Thang9}));
            }
            if (Integer.parseInt(formatted) > 9) {
                chart.addData(new ModelChart("Tháng 10", new double[]{Thang10}));
            }
            if (Integer.parseInt(formatted) > 10) {
                chart.addData(new ModelChart("Tháng 11", new double[]{Thang11}));
            }
            if (Integer.parseInt(formatted) > 11) {
                chart.addData(new ModelChart("Tháng 12", new double[]{Thang12}));
            }
        }
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

        if (cboNhanVien.getSelectedItem().equals(2021)) {
            test();
        } else if (cboNhanVien.getSelectedItem().equals(2022)) {
            test1();
        } else {
            test2();
        }
    }//GEN-LAST:event_cboNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Combobox cboNhanVien;
    private raven.chart.CurveLineChart chart;
    // End of variables declaration//GEN-END:variables
}

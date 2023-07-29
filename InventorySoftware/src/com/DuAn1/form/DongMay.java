/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.DienThoaiDao;
import com.DuAn1.Dao.DongMayDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.BoNhoModel;
import com.DuAn1.Model.CPUModel;
import com.DuAn1.Model.CameraModel;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.MangHinhModel;
import com.DuAn1.Model.PinModel;
import com.DuAn1.Model.RamModel;
import com.DuAn1.Model.ThaoTacModel;
import com.tuandhpc05076.helper.DialogHelper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class DongMay extends javax.swing.JPanel {

    ThaoTacDAO ttdao = new ThaoTacDAO();
    DefaultTableModel model;
    DongMayDAO dao = new DongMayDAO();
    int row = -1;

    /**
     * Creates new form DongMay
     */
    public DongMay() {
        initComponents();
        fillTableCPU();
        fillTableRAM();
        fillTableROM();
        fillTableCamera();
        fillTableManHinh();
        fillTablePin();
    }

    public ThaoTacModel getFormThaoTacThemCPU() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm CPU");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacThemRAM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm RAM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacThemROM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm ROM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacThemManHinh() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Màn Hình");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacThemCamera() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Camera");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacThemPin() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Pin");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaCPU() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa CPU");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaRAM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa RAM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaROM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa ROM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaCamera() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Camera");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaManHinh() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Màn Hình");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacSuaPin() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Pin");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaCPU() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa CPU");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaRAM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa RAM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaROM() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa ROM");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaManHinh() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Màn Hình");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaCamera() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Camera");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormThaoTacXoaPin() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Pin");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    //Load các cbo
    void LoadComboboxCPU() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<CPUModel> listVaitro = (ArrayList<CPUModel>) vtDao.selectallCPU();
        for (CPUModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSanPham().trim());
        }
        cboCPU.setModel(comboboxmodel);
        cboCPU.setSelectedIndex(-1);
    }

    void LoadComboboxRAM() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<RamModel> listVaitro = (ArrayList<RamModel>) vtDao.selectallRAM();
        for (RamModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSP().trim());
        }
        cboLoaiSPRAM.setModel(comboboxmodel);
        cboLoaiSPRAM.setSelectedIndex(-1);
    }

    void LoadComboboxROM() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<BoNhoModel> listVaitro = (ArrayList<BoNhoModel>) vtDao.selectallROM();
        for (BoNhoModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSP().trim());
        }
        cboLoaiSPBoNho.setModel(comboboxmodel);
        cboLoaiSPBoNho.setSelectedIndex(-1);
    }

    void LoadComboboxManHinh() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<MangHinhModel> listVaitro = (ArrayList<MangHinhModel>) vtDao.selectallManHinh();
        for (MangHinhModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSp().trim());
        }
        cboLoaiSPManHinh.setModel(comboboxmodel);
        cboLoaiSPManHinh.setSelectedIndex(-1);
    }

    void LoadComboboxCamera() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<CameraModel> listVaitro = (ArrayList<CameraModel>) vtDao.selectallCamera();
        for (CameraModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSP().trim());
        }
        cboCamera.setModel(comboboxmodel);
        cboCamera.setSelectedIndex(-1);
    }

    void LoadComboboxPin() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        DongMayDAO vtDao = new DongMayDAO();
        ArrayList<PinModel> listVaitro = (ArrayList<PinModel>) vtDao.selectallPin();
        for (PinModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getLoaiSP().trim());
        }
        cboPin.setModel(comboboxmodel);
        cboPin.setSelectedIndex(-1);
    }

    //Fill các table
    void fillTableCPU() {
        model = (DefaultTableModel) tblCPU.getModel();
        model.setRowCount(0);
        try {

            List<CPUModel> list = dao.selectallCPU();
            for (CPUModel cpu : list) {
                Object[] row = new Object[]{cpu.getMaCPU(), cpu.getLoaiSanPham()};
                model.addRow(row);
                System.out.println(cpu.getLoaiSanPham());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTableRAM() {
        model = (DefaultTableModel) tblRAM.getModel();
        model.setRowCount(0);
        try {

            List<RamModel> list = dao.selectallRAM();
            for (RamModel ram : list) {
                Object[] row = new Object[]{ram.getMaRam(), ram.getLoaiSP()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTableROM() {
        model = (DefaultTableModel) tblROM.getModel();
        model.setRowCount(0);
        try {

            List<BoNhoModel> list = dao.selectallROM();
            for (BoNhoModel rom : list) {
                Object[] row = new Object[]{rom.getMaBoNho(), rom.getLoaiSP()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTableCamera() {
        model = (DefaultTableModel) tblCamera.getModel();
        model.setRowCount(0);
        try {

            List<CameraModel> list = dao.selectallCamera();
            for (CameraModel rom : list) {
                Object[] row = new Object[]{rom.getMaCamera(), rom.getLoaiSP()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTableManHinh() {
        model = (DefaultTableModel) tblManHinh.getModel();
        model.setRowCount(0);
        try {

            List<MangHinhModel> list = dao.selectallManHinh();
            for (MangHinhModel rom : list) {
                Object[] row = new Object[]{rom.getMaMangHinh(), rom.getLoaiSp()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTablePin() {
        model = (DefaultTableModel) tblPin.getModel();
        model.setRowCount(0);
        try {

            List<PinModel> list = dao.selectallPin();
            for (PinModel rom : list) {
                Object[] row = new Object[]{rom.getMaPin(), rom.getLoaiSP()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    //Get set các bảng
    CPUModel getForm() {
        CPUModel cpu = new CPUModel();
        cpu.setLoaiSanPham((String) cboCPU.getSelectedItem());
        cpu.setMaCPU(txtCPU.getText());
        return cpu;
    }

    void setForm(CPUModel cpu) {
        cboCPU.setSelectedItem(cpu.getLoaiSanPham().trim());
        txtCPU.setText(cpu.getMaCPU().trim());
    }

    MangHinhModel getFormMH() {
        MangHinhModel cpu = new MangHinhModel();
        cpu.setLoaiSp((String) cboLoaiSPManHinh.getSelectedItem());
        cpu.setMaMangHinh(txtManHinh.getText());
        return cpu;
    }

    void setFormMH(MangHinhModel cpu) {
        cboLoaiSPManHinh.setSelectedItem(cpu.getLoaiSp().trim());
        txtManHinh.setText(cpu.getMaMangHinh().trim());
    }

    CameraModel getFormCamera() {
        CameraModel cpu = new CameraModel();
        cpu.setLoaiSP((String) cboCamera.getSelectedItem());
        cpu.setMaCamera(txtCamera.getText());
        return cpu;
    }

    void setFormCamera(CameraModel cpu) {
        cboCamera.setSelectedItem(cpu.getLoaiSP().trim());
        txtCamera.setText(cpu.getMaCamera().trim());
    }

    BoNhoModel getFormRom() {
        BoNhoModel cpu = new BoNhoModel();
        cpu.setLoaiSP((String) cboLoaiSPBoNho.getSelectedItem());
        cpu.setMaBoNho(txtBoNho.getText());
        return cpu;
    }

    void setFormRom(BoNhoModel cpu) {
        cboLoaiSPBoNho.setSelectedItem(cpu.getLoaiSP().trim());
        txtBoNho.setText(cpu.getMaBoNho().trim());
    }

    RamModel getFormRam() {
        RamModel cpu = new RamModel();
        cpu.setLoaiSP((String) cboLoaiSPRAM.getSelectedItem());
        cpu.setMaRam(txtRAM.getText());
        return cpu;
    }

    void setFormRam(RamModel cpu) {
        cboLoaiSPRAM.setSelectedItem(cpu.getLoaiSP().trim());
        txtRAM.setText(cpu.getMaRam().trim());
    }

    PinModel getFormPin() {
        PinModel cpu = new PinModel();
        cpu.setLoaiSP((String) cboPin.getSelectedItem());
        cpu.setMaPin(txtPin.getText());
        return cpu;
    }

    void setFormPin(PinModel cpu) {
        cboPin.setSelectedItem(cpu.getLoaiSP().trim());
        txtPin.setText(cpu.getMaPin().trim());
    }

    void clearForm() {
        txtCPU.setText("");
        cboCPU.setSelectedItem(null);
        txtBoNho.setText("");
        cboLoaiSPBoNho.setSelectedItem(null);
        txtRAM.setText("");
        cboLoaiSPRAM.setSelectedItem(null);
        txtManHinh.setText("");
        cboLoaiSPManHinh.setSelectedItem(null);
        txtPin.setText("");
        cboPin.setSelectedItem(null);
        txtCamera.setText("");
        cboCamera.setSelectedItem(null);
    }

    // uptStatus
    void updateStatusCPU() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblCPU.getRowCount() - 1);

        btnThemCPU.setEnabled(edit);
        btnSuaCPU.setEnabled(edit);
        btnXoaCPU.setEnabled(edit);
    }

    void updateStatusRam() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblRAM.getRowCount() - 1);

        btnThemRAM.setEnabled(edit);
        btnSuaRAM.setEnabled(edit);
        btnXoaRAM.setEnabled(edit);
    }

    void updateStatusRom() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblROM.getRowCount() - 1);

        btnThemRom.setEnabled(edit);
        btnSuaRom.setEnabled(edit);
        btnXoaRom.setEnabled(edit);
    }

    void updateStatusManHinh() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblManHinh.getRowCount() - 1);

        btnThemManHinh.setEnabled(edit);
        btnSuaManHinh.setEnabled(edit);
        btnXoaManHinh.setEnabled(edit);
    }

    void updateStatusCam() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblCamera.getRowCount() - 1);

        btnThemCamera.setEnabled(edit);
        btnSuaCamera.setEnabled(edit);
        btnXoaCamera.setEnabled(edit);
    }

    void updateStatusPin() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblPin.getRowCount() - 1);

        btnThemPin.setEnabled(edit);
        btnSuaPin.setEnabled(edit);
        btnXoaPin.setEnabled(edit);
    }

    //edit các bảng
    void editCPU() {
        String maluong = (String) tblCPU.getValueAt(this.row, 0);
        CPUModel ttl = dao.findByIdCPU(maluong);
        this.setForm(ttl);
        this.updateStatusCPU();
    }

    void editRam() {
        String maluong = (String) tblRAM.getValueAt(this.row, 0);
        RamModel ttl = dao.findByIdRAM(maluong);
        this.setFormRam(ttl);
        this.updateStatusRam();
    }

    void editRom() {
        String maluong = (String) tblROM.getValueAt(this.row, 0);
        BoNhoModel ttl = dao.findByIdROM(maluong);
        this.setFormRom(ttl);
        this.updateStatusRom();
    }

    void editManHinh() {
        String maluong = (String) tblManHinh.getValueAt(this.row, 0);
        MangHinhModel ttl = dao.findByIdManHinh(maluong);
        this.setFormMH(ttl);
        this.updateStatusManHinh();
    }

    void editCamera() {
        String maluong = (String) tblCamera.getValueAt(this.row, 0);
        CameraModel ttl = dao.findByIdCamera(maluong);
        this.setFormCamera(ttl);
        this.updateStatusCam();
    }

    void editPin() {
        String maluong = (String) tblPin.getValueAt(this.row, 0);
        PinModel ttl = dao.findByIdPin(maluong);
        this.setFormPin(ttl);
        this.updateStatusPin();
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
        jLabel1 = new javax.swing.JLabel();
        materialTabbed1 = new swing.MaterialTabbed();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblManHinh = new com.raven.swing.table.Table();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRAM = new com.raven.swing.table.Table();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblROM = new com.raven.swing.table.Table();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCPU = new com.raven.swing.table.Table();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCamera = new com.raven.swing.table.Table();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblPin = new com.raven.swing.table.Table();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtBoNho = new com.DuAn1.Swing.TextField();
        btnMoiRom = new com.DuAn1.Swing.Button();
        btnThemRom = new com.DuAn1.Swing.Button();
        btnSuaRom = new com.DuAn1.Swing.Button();
        btnXoaRom = new com.DuAn1.Swing.Button();
        cboLoaiSPBoNho = new com.DuAn1.Swing.Combobox();
        jPanel10 = new javax.swing.JPanel();
        txtManHinh = new com.DuAn1.Swing.TextField();
        btnMoiManHinh = new com.DuAn1.Swing.Button();
        btnThemManHinh = new com.DuAn1.Swing.Button();
        btnSuaManHinh = new com.DuAn1.Swing.Button();
        btnXoaManHinh = new com.DuAn1.Swing.Button();
        cboLoaiSPManHinh = new com.DuAn1.Swing.Combobox();
        jPanel11 = new javax.swing.JPanel();
        txtCamera = new com.DuAn1.Swing.TextField();
        btnMoiCamera = new com.DuAn1.Swing.Button();
        btnThemCamera = new com.DuAn1.Swing.Button();
        btnSuaCamera = new com.DuAn1.Swing.Button();
        btnXoaCamera = new com.DuAn1.Swing.Button();
        cboCamera = new com.DuAn1.Swing.Combobox();
        jPanel12 = new javax.swing.JPanel();
        txtPin = new com.DuAn1.Swing.TextField();
        btnMoiPin = new com.DuAn1.Swing.Button();
        btnThemPin = new com.DuAn1.Swing.Button();
        btnSuaPin = new com.DuAn1.Swing.Button();
        btnXoaPin = new com.DuAn1.Swing.Button();
        cboPin = new com.DuAn1.Swing.Combobox();
        jPanel13 = new javax.swing.JPanel();
        txtCPU = new com.DuAn1.Swing.TextField();
        btnMoiCPU = new com.DuAn1.Swing.Button();
        btnThemCPU = new com.DuAn1.Swing.Button();
        btnSuaCPU = new com.DuAn1.Swing.Button();
        btnXoaCPU = new com.DuAn1.Swing.Button();
        cboCPU = new com.DuAn1.Swing.Combobox();
        jPanel14 = new javax.swing.JPanel();
        txtRAM = new com.DuAn1.Swing.TextField();
        btnMoiRAM = new com.DuAn1.Swing.Button();
        btnThemRAM = new com.DuAn1.Swing.Button();
        btnSuaRAM = new com.DuAn1.Swing.Button();
        btnXoaRAM = new com.DuAn1.Swing.Button();
        cboLoaiSPRAM = new com.DuAn1.Swing.Combobox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Dòng máy");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblManHinh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Màn Hình", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblManHinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã Màn Hình", "Loại Sản Phẩm"
            }
        ));
        tblManHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManHinhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblManHinhMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblManHinh);

        tblRAM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RAM", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblRAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã Ram", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRAMMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRAMMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblRAM);

        tblROM.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ROM", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblROM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã Bộ Nhớ", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblROM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblROMMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblROMMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblROM);

        tblCPU.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPU", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã CPU", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCPUMousePressed(evt);
            }
        });
        jScrollPane7.setViewportView(tblCPU);

        tblCamera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAMERA", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblCamera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã Camera", "Loại Sản Phẩm"
            }
        ));
        tblCamera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCameraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCameraMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(tblCamera);

        tblPin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PIN", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tblPin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd"},
                {"sdf", "sdfs"},
                {"dsf", "sdf"},
                {null, null}
            },
            new String [] {
                "Mã Pin ", "Loại Sản Phẩm"
            }
        ));
        tblPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPinMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPinMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(tblPin);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        materialTabbed1.addTab("Danh sách", jScrollPane1);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ROM", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtBoNho.setLabelText("Bộ nhớ");
        txtBoNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBoNhoActionPerformed(evt);
            }
        });

        btnMoiRom.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiRom.setText("Mới");
        btnMoiRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiRomActionPerformed(evt);
            }
        });

        btnThemRom.setBackground(new java.awt.Color(153, 153, 255));
        btnThemRom.setText("Thêm");
        btnThemRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemRomActionPerformed(evt);
            }
        });

        btnSuaRom.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaRom.setText("Sửa");
        btnSuaRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaRomActionPerformed(evt);
            }
        });

        btnXoaRom.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaRom.setText("Xóa");
        btnXoaRom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRomActionPerformed(evt);
            }
        });

        cboLoaiSPBoNho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "iPhone", "Sony", "SamSung" }));
        cboLoaiSPBoNho.setSelectedIndex(-1);
        cboLoaiSPBoNho.setLabeText("Loại Sản Phẩm");
        cboLoaiSPBoNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPBoNhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnSuaRom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnXoaRom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnMoiRom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemRom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoaiSPBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBoNho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboLoaiSPBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBoNho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Màn Hình", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtManHinh.setLabelText("Màn hình");
        txtManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManHinhActionPerformed(evt);
            }
        });

        btnMoiManHinh.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiManHinh.setText("Mới");
        btnMoiManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiManHinhActionPerformed(evt);
            }
        });

        btnThemManHinh.setBackground(new java.awt.Color(153, 153, 255));
        btnThemManHinh.setText("Thêm");
        btnThemManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemManHinhActionPerformed(evt);
            }
        });

        btnSuaManHinh.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaManHinh.setText("Sửa");
        btnSuaManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaManHinhActionPerformed(evt);
            }
        });

        btnXoaManHinh.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaManHinh.setText("Xóa");
        btnXoaManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaManHinhActionPerformed(evt);
            }
        });

        cboLoaiSPManHinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sony", "iPhone", "Samsung" }));
        cboLoaiSPManHinh.setSelectedIndex(-1);
        cboLoaiSPManHinh.setLabeText("Loại Sản Phẩm");
        cboLoaiSPManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPManHinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnSuaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(btnMoiManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)
                                .addComponent(btnThemManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoaiSPManHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtManHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboLoaiSPManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Camera", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtCamera.setLabelText("Camera");
        txtCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCameraActionPerformed(evt);
            }
        });

        btnMoiCamera.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiCamera.setText("Mới");
        btnMoiCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiCameraActionPerformed(evt);
            }
        });

        btnThemCamera.setBackground(new java.awt.Color(153, 153, 255));
        btnThemCamera.setText("Thêm");
        btnThemCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCameraActionPerformed(evt);
            }
        });

        btnSuaCamera.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaCamera.setText("Sửa");
        btnSuaCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCameraActionPerformed(evt);
            }
        });

        btnXoaCamera.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaCamera.setText("Xóa");
        btnXoaCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCameraActionPerformed(evt);
            }
        });

        cboCamera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "iPhone", "Sony", "SamSung" }));
        cboCamera.setSelectedIndex(-1);
        cboCamera.setLabeText("Loại Sản Phẩm");
        cboCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCameraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnSuaCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnXoaCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnMoiCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(btnThemCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtPin.setLabelText("Pin");
        txtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActionPerformed(evt);
            }
        });

        btnMoiPin.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiPin.setText("Mới");
        btnMoiPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiPinActionPerformed(evt);
            }
        });

        btnThemPin.setBackground(new java.awt.Color(153, 153, 255));
        btnThemPin.setText("Thêm");
        btnThemPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPinActionPerformed(evt);
            }
        });

        btnSuaPin.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaPin.setText("Sửa");
        btnSuaPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPinActionPerformed(evt);
            }
        });

        btnXoaPin.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaPin.setText("Xóa");
        btnXoaPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPinActionPerformed(evt);
            }
        });

        cboPin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "iPhone", "Sony", "SamSung" }));
        cboPin.setSelectedIndex(-1);
        cboPin.setLabeText("Loại Sản Phẩm");
        cboPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(btnSuaPin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnXoaPin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(btnMoiPin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemPin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPU", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtCPU.setLabelText("CPU");
        txtCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPUActionPerformed(evt);
            }
        });

        btnMoiCPU.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiCPU.setText("Mới");
        btnMoiCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiCPUActionPerformed(evt);
            }
        });

        btnThemCPU.setBackground(new java.awt.Color(153, 153, 255));
        btnThemCPU.setText("Thêm");
        btnThemCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCPUActionPerformed(evt);
            }
        });

        btnSuaCPU.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaCPU.setText("Sửa");
        btnSuaCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCPUActionPerformed(evt);
            }
        });

        btnXoaCPU.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaCPU.setText("Xóa");
        btnXoaCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCPUActionPerformed(evt);
            }
        });

        cboCPU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "iPhone", "Sony", "SamSung" }));
        cboCPU.setSelectedIndex(-1);
        cboCPU.setLabeText("Loại Sản Phẩm");
        cboCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(btnSuaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnXoaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(btnMoiCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cboCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RAM", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        txtRAM.setLabelText("Ram");
        txtRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRAMActionPerformed(evt);
            }
        });

        btnMoiRAM.setBackground(new java.awt.Color(153, 153, 255));
        btnMoiRAM.setText("Mới");
        btnMoiRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiRAMActionPerformed(evt);
            }
        });

        btnThemRAM.setBackground(new java.awt.Color(153, 153, 255));
        btnThemRAM.setText("Thêm");
        btnThemRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemRAMActionPerformed(evt);
            }
        });

        btnSuaRAM.setBackground(new java.awt.Color(153, 153, 255));
        btnSuaRAM.setText("Sửa");
        btnSuaRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaRAMActionPerformed(evt);
            }
        });

        btnXoaRAM.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaRAM.setText("Xóa");
        btnXoaRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRAMActionPerformed(evt);
            }
        });

        cboLoaiSPRAM.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "iPhone", "Sony", "SamSung" }));
        cboLoaiSPRAM.setSelectedIndex(-1);
        cboLoaiSPRAM.setLabeText("Loại Sản Phẩm");
        cboLoaiSPRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPRAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(btnSuaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(btnXoaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(btnMoiRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThemRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLoaiSPRAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cboLoaiSPRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoiRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(429, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        materialTabbed1.addTab("Quản lý", jScrollPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(949, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManHinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManHinhActionPerformed

    private void btnMoiManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiManHinhActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiManHinhActionPerformed

    private void btnThemManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemManHinhActionPerformed
        // TODO add your handling code here:
        if (checkManHinh()) {
            themMH();
        }
    }//GEN-LAST:event_btnThemManHinhActionPerformed

    private void cboLoaiSPManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPManHinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiSPManHinhActionPerformed

    private void txtCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPUActionPerformed

    private void btnMoiCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiCPUActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiCPUActionPerformed

    private void btnThemCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCPUActionPerformed
        // TODO add your handling code here:
        if (checkCPU()) {
            themCPU();
        }
    }//GEN-LAST:event_btnThemCPUActionPerformed

    private void cboCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCPUActionPerformed

    private void tblManHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManHinhMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblManHinh.getSelectedRow();
             materialTabbed1.setSelectedIndex(1);
            this.editManHinh();
        }
    }//GEN-LAST:event_tblManHinhMouseClicked

    private void tblManHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManHinhMousePressed
//        if (evt.getClickCount() == 1) {
//            this.row = tblManHinh.getSelectedRow();
//
//        }
    }//GEN-LAST:event_tblManHinhMousePressed

    private void tblRAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRAMMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblRAM.getSelectedRow();
             materialTabbed1.setSelectedIndex(1);
            this.editRam();
        }
    }//GEN-LAST:event_tblRAMMouseClicked

    private void tblRAMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRAMMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRAMMousePressed

    private void tblROMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblROMMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblROM.getSelectedRow();
             materialTabbed1.setSelectedIndex(1);
            this.editRom();
        }
    }//GEN-LAST:event_tblROMMouseClicked

    private void tblROMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblROMMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblROMMousePressed

    private void tblCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblCPU.getSelectedRow();
            materialTabbed1.setSelectedIndex(1);
            this.editCPU();
        }
    }//GEN-LAST:event_tblCPUMouseClicked

    private void tblCPUMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCPUMousePressed

    private void tblCameraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCameraMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblCamera.getSelectedRow();
             materialTabbed1.setSelectedIndex(1);
            this.editCamera();
        }
    }//GEN-LAST:event_tblCameraMouseClicked

    private void tblCameraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCameraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCameraMousePressed

    private void tblPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPinMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.row = tblPin.getSelectedRow();
             materialTabbed1.setSelectedIndex(1);
            this.editPin();
        }
    }//GEN-LAST:event_tblPinMouseClicked

    private void tblPinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPinMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPinMousePressed

    private void cboPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPinActionPerformed

    private void btnThemPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPinActionPerformed
        // TODO add your handling code here:
        if (checkPin()) {
            themPin();
        }
    }//GEN-LAST:event_btnThemPinActionPerformed

    private void btnMoiPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiPinActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiPinActionPerformed

    private void txtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinActionPerformed

    private void cboLoaiSPBoNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPBoNhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiSPBoNhoActionPerformed

    private void btnThemRomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemRomActionPerformed
        // TODO add your handling code here:
        if (checkROM()) {
            themRom();
        }
    }//GEN-LAST:event_btnThemRomActionPerformed

    private void btnMoiRomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiRomActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiRomActionPerformed

    private void txtBoNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBoNhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBoNhoActionPerformed

    private void cboCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCameraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCameraActionPerformed

    private void btnThemCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCameraActionPerformed
        // TODO add your handling code here:
        if (checkCam()) {
            themCamera();
        }
    }//GEN-LAST:event_btnThemCameraActionPerformed

    private void btnMoiCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiCameraActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiCameraActionPerformed

    private void txtCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCameraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCameraActionPerformed

    private void txtRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRAMActionPerformed
    void themRam() {
        RamModel ram = getFormRam();
        try {
            dao.insertRAM(ram);
            this.fillTableRAM();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemRAM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    void suaRam() {
        RamModel ram = getFormRam();
        try {
            dao.updateRAM(ram);
            this.fillTableRAM();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaRAM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }

    void suaCPU() {
        CPUModel ram = getForm();
        try {
            dao.updateCPU(ram);
            this.fillTableCPU();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaCPU();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }

    void suaRom() {
        BoNhoModel ram = getFormRom();
        try {
            dao.updateROM(ram);
            this.fillTableROM();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaROM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }

    void suaCamera() {
        CameraModel ram = getFormCamera();
        try {
            dao.updateCamera(ram);
            this.fillTableCamera();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaCamera();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }
    boolean checkRAM(){
        if (cboLoaiSPRAM.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtRAM.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập RAM");
            return false;
        }
        return true;
    }
    boolean checkROM(){
        if (cboLoaiSPBoNho.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtBoNho.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập ROM");
            return false;
        }
        return true;
    }
    boolean checkCam(){
        if (cboCamera.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtCamera.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập Camera");
            return false;
        }
        return true;
    }
    boolean checkManHinh(){
         if (cboLoaiSPManHinh.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtManHinh.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập màn hình");
            return false;
        }
        return true;
    }
    boolean checkPin(){
         if (cboPin.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtPin.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập pin");
            return false;
        }
        return true;
    }
    boolean checkCPU() {
        if (cboCPU.getSelectedItem() == null) {
            DialogHelper.alert(this, "Hãy chọn loại sản phẩm");
            return false;
        }
        if (txtCPU.getText().equals("")) {
            DialogHelper.alert(this, "Hãy nhập CPU");
            return false;
        }
     return true;
    }

    void suaManHinh() {
        MangHinhModel ram = getFormMH();
        try {
            dao.updateManHinh(ram);
            this.fillTableManHinh();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaManHinh();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }

    void suaPin() {
        PinModel ram = getFormPin();
        try {
            dao.updatePin(ram);
            this.fillTablePin();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacSuaPin();
            ttdao.insert(model);
            DialogHelper.alert(this, "Sửa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Sửa thất bại");
            e.printStackTrace();
        }
    }

    void xoaRam() {
        RamModel sp = getFormRam();
        try {
            dao.deleteRAM(sp);
            fillTableRAM();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaRAM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }
    }

    void xoaCPU() {
        CPUModel sp = getForm();
        try {
            dao.deleteCPU(sp);
            fillTableCPU();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaCPU();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }

    }

    void xoaRom() {
        BoNhoModel sp = getFormRom();
        try {
            dao.deleteROM(sp);
            fillTableROM();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaROM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }
    }

    void xoaCamera() {
        CameraModel sp = getFormCamera();
        try {
            dao.deleteCamera(sp);
            fillTableCamera();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaCamera();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }
    }

    void xoaManHinh() {
        MangHinhModel sp = getFormMH();
        try {
            dao.deleteManHinh(sp);
            fillTableManHinh();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaManHinh();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }
    }

    void xoaPin() {
        PinModel sp = getFormPin();
        try {
            dao.deletePin(sp);
            fillTablePin();
            clearForm();
            ThaoTacModel model = getFormThaoTacXoaPin();
            ttdao.insert(model);
            DialogHelper.alert(this, "Xóa thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi xóa dữ liệu");
        }
    }

    void themRom() {
        BoNhoModel rom = getFormRom();
        try {
            dao.insertROM(rom);
            this.fillTableROM();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemROM();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    void themCPU() {
        CPUModel cpu = getForm();
        try {
            dao.insertCPU(cpu);
            this.fillTableCPU();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemCPU();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    void themMH() {
        MangHinhModel ram = getFormMH();
        try {
            dao.insertManHinh(ram);
            this.fillTableManHinh();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemManHinh();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    void themCamera() {
        CameraModel ram = getFormCamera();
        try {
            dao.insertCamera(ram);
            this.fillTableCamera();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemCamera();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }

    void themPin() {
        PinModel ram = getFormPin();
        try {
            dao.insertPin(ram);
            this.fillTablePin();
            this.clearForm();
            ThaoTacModel model = getFormThaoTacThemPin();
            ttdao.insert(model);
            DialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại");
            e.printStackTrace();
        }
    }
    private void btnMoiRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiRAMActionPerformed
        // TODO add your handling code here:
        
        clearForm();
    }//GEN-LAST:event_btnMoiRAMActionPerformed

    private void btnThemRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemRAMActionPerformed
        // TODO add your handling code here:
        if (checkRAM()) {
            themRam();
        }
    }//GEN-LAST:event_btnThemRAMActionPerformed

    private void cboLoaiSPRAMActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cboCPU3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCPU3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCPU3ActionPerformed

    private void txtRAM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRAM4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRAM4ActionPerformed

    private void btnMoi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoi4ActionPerformed

    private void btnThem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem4ActionPerformed

    private void cboCPU4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCPU4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCPU4ActionPerformed

    private void txtRAM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRAM5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRAM5ActionPerformed

    private void btnMoi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoi5ActionPerformed

    private void btnThem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem5ActionPerformed

    private void cboCPU5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCPU5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCPU5ActionPerformed

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void tblNhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMousePressed
//        if (evt.getClickCount() == 1) {
//            this.row = tblNhanvien.getSelectedRow();
//            //this.edit();
//        }
    }//GEN-LAST:event_tblNhanvienMousePressed

    private void tblNhanvien1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien1MouseClicked

    private void tblNhanvien1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien1MousePressed

    private void tblNhanvien2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien2MouseClicked

    private void tblNhanvien2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien2MousePressed

    private void tblNhanvien3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien3MouseClicked

    private void tblNhanvien3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien3MousePressed

    private void tblNhanvien4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien4MouseClicked

    private void tblNhanvien4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien4MousePressed

    private void tblNhanvien5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien5MouseClicked

    private void tblNhanvien5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvien5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvien5MousePressed

    private void btnSuaRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaRAMActionPerformed
        // TODO add your handling code here:
        suaRam();
    }//GEN-LAST:event_btnSuaRAMActionPerformed

    private void btnXoaRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRAMActionPerformed
        // TODO add your handling code here:
        xoaRam();
    }//GEN-LAST:event_btnXoaRAMActionPerformed

    private void btnXoaRomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRomActionPerformed
        // TODO add your handling code here:
        xoaRom();
    }//GEN-LAST:event_btnXoaRomActionPerformed

    private void btnXoaManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaManHinhActionPerformed
        // TODO add your handling code here:
        xoaManHinh();
    }//GEN-LAST:event_btnXoaManHinhActionPerformed

    private void btnXoaCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCameraActionPerformed
        // TODO add your handling code here:
        xoaCamera();
    }//GEN-LAST:event_btnXoaCameraActionPerformed

    private void btnXoaPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPinActionPerformed
        // TODO add your handling code here:
        xoaPin();
    }//GEN-LAST:event_btnXoaPinActionPerformed

    private void btnXoaCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCPUActionPerformed
        // TODO add your handling code here:
        xoaCPU();
    }//GEN-LAST:event_btnXoaCPUActionPerformed

    private void btnSuaRomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaRomActionPerformed
        // TODO add your handling code here:
        suaRom();
    }//GEN-LAST:event_btnSuaRomActionPerformed

    private void btnSuaManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaManHinhActionPerformed
        // TODO add your handling code here:
        suaManHinh();
    }//GEN-LAST:event_btnSuaManHinhActionPerformed

    private void btnSuaCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCameraActionPerformed
        // TODO add your handling code here:
        suaCamera();
    }//GEN-LAST:event_btnSuaCameraActionPerformed

    private void btnSuaPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPinActionPerformed
        // TODO add your handling code here:
        suaPin();
    }//GEN-LAST:event_btnSuaPinActionPerformed

    private void btnSuaCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCPUActionPerformed
        // TODO add your handling code here:
        suaCPU();
    }//GEN-LAST:event_btnSuaCPUActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoiCPU;
    private com.DuAn1.Swing.Button btnMoiCamera;
    private com.DuAn1.Swing.Button btnMoiManHinh;
    private com.DuAn1.Swing.Button btnMoiPin;
    private com.DuAn1.Swing.Button btnMoiRAM;
    private com.DuAn1.Swing.Button btnMoiRom;
    private com.DuAn1.Swing.Button btnSuaCPU;
    private com.DuAn1.Swing.Button btnSuaCamera;
    private com.DuAn1.Swing.Button btnSuaManHinh;
    private com.DuAn1.Swing.Button btnSuaPin;
    private com.DuAn1.Swing.Button btnSuaRAM;
    private com.DuAn1.Swing.Button btnSuaRom;
    private com.DuAn1.Swing.Button btnThemCPU;
    private com.DuAn1.Swing.Button btnThemCamera;
    private com.DuAn1.Swing.Button btnThemManHinh;
    private com.DuAn1.Swing.Button btnThemPin;
    private com.DuAn1.Swing.Button btnThemRAM;
    private com.DuAn1.Swing.Button btnThemRom;
    private com.DuAn1.Swing.Button btnXoaCPU;
    private com.DuAn1.Swing.Button btnXoaCamera;
    private com.DuAn1.Swing.Button btnXoaManHinh;
    private com.DuAn1.Swing.Button btnXoaPin;
    private com.DuAn1.Swing.Button btnXoaRAM;
    private com.DuAn1.Swing.Button btnXoaRom;
    private com.DuAn1.Swing.Combobox cboCPU;
    private com.DuAn1.Swing.Combobox cboCamera;
    private com.DuAn1.Swing.Combobox cboLoaiSPBoNho;
    private com.DuAn1.Swing.Combobox cboLoaiSPManHinh;
    private com.DuAn1.Swing.Combobox cboLoaiSPRAM;
    private com.DuAn1.Swing.Combobox cboPin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private swing.MaterialTabbed materialTabbed1;
    private com.raven.swing.table.Table tblCPU;
    private com.raven.swing.table.Table tblCamera;
    private com.raven.swing.table.Table tblManHinh;
    private com.raven.swing.table.Table tblPin;
    private com.raven.swing.table.Table tblRAM;
    private com.raven.swing.table.Table tblROM;
    private com.DuAn1.Swing.TextField txtBoNho;
    private com.DuAn1.Swing.TextField txtCPU;
    private com.DuAn1.Swing.TextField txtCamera;
    private com.DuAn1.Swing.TextField txtManHinh;
    private com.DuAn1.Swing.TextField txtPin;
    private com.DuAn1.Swing.TextField txtRAM;
    // End of variables declaration//GEN-END:variables
}

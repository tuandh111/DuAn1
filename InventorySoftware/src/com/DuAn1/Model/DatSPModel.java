/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class DatSPModel {
    private String MaDH;
    private String SoLuong;
    private String SDT;
    private String TrangThai;
    private String DonGia;
    private String TongTien;
    private String Thue;
    private String MaNV;

    public DatSPModel(String MaDH, String SoLuong, String SDT, String TrangThai, String DonGia, String TongTien, String Thue, String MaNV) {
        this.MaDH = MaDH;
        this.SoLuong = SoLuong;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
        this.Thue = Thue;
        this.MaNV = MaNV;
    }

    public DatSPModel() {
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public String getThue() {
        return Thue;
    }

    public void setThue(String Thue) {
        this.Thue = Thue;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}

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
    private boolean TrangThai;
    private String DonGia;
    private String TongTien;
    private String ThoiGianDat;
    private String MaNV;

    public DatSPModel(String MaDH, String SoLuong, String SDT, boolean TrangThai, String DonGia, String TongTien, String ThoiGianDat, String MaNV) {
        this.MaDH = MaDH;
        this.SoLuong = SoLuong;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
        this.DonGia = DonGia;
        this.TongTien = TongTien;
        this.ThoiGianDat = ThoiGianDat;
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

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
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

    public String getThoiGianDat() {
        return ThoiGianDat;
    }

    public void setThoiGianDat(String ThoiGianDat) {
        this.ThoiGianDat = ThoiGianDat;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}

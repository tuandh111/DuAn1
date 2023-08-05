/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author Administrator
 */
public class HoaDonModel {

    private String MaHD;
    private String Soluong;
    private boolean TrangThai;
    private double Dongia;
    private double Tongtien;
    private String NgayXuat;
    private String Mota;
    private String TenCty;
    private String MaNV;
    private String TenKH;
    private String HinhThuc;
    private double TienKhach;
    private double TienCon;

    public HoaDonModel() {
    }

    public HoaDonModel(String MaHD, String Soluong, boolean TrangThai, double Dongia, double Tongtien, String NgayXuat, String Mota, String TenCty, String MaNV, String TenKH, String HinhThuc, double TienKhach, double TienCon) {
        this.MaHD = MaHD;
        this.Soluong = Soluong;
        this.TrangThai = TrangThai;
        this.Dongia = Dongia;
        this.Tongtien = Tongtien;
        this.NgayXuat = NgayXuat;
        this.Mota = Mota;
        this.TenCty = TenCty;
        this.MaNV = MaNV;
        this.TenKH = TenKH;
        this.HinhThuc = HinhThuc;
        this.TienKhach = TienKhach;
        this.TienCon = TienCon;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getSoluong() {
        return Soluong;
    }

    public void setSoluong(String Soluong) {
        this.Soluong = Soluong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getTenCty() {
        return TenCty;
    }

    public void setTenCty(String TenCty) {
        this.TenCty = TenCty;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getHinhThuc() {
        return HinhThuc;
    }

    public void setHinhThuc(String HinhThuc) {
        this.HinhThuc = HinhThuc;
    }

    public double getTienKhach() {
        return TienKhach;
    }

    public void setTienKhach(double TienKhach) {
        this.TienKhach = TienKhach;
    }

    public double getTienCon() {
        return TienCon;
    }

    public void setTienCon(double TienCon) {
        this.TienCon = TienCon;
    }


}

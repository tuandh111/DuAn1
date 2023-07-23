/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class SanPhamModel {
    private String MaSP;
    private String TenSP;
    private String Mau;
    private double Gia;
    private String LoaiSP;
    private String NgayNhap;
    private String NoiNhap;
    private int SoLuong;
    private boolean  TrangThai;
    private String Hinh;
    private String MaNV;
    private String MaGiamGia;


    public SanPhamModel() {
    }

    public SanPhamModel(String MaSP, String TenSP, String Mau, double Gia, String LoaiSP, String NgayNhap, String NoiNhap, int SoLuong, boolean TrangThai, String Hinh, String MaNV, String MaGiamGia) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Mau = Mau;
        this.Gia = Gia;
        this.LoaiSP = LoaiSP;
        this.NgayNhap = NgayNhap;
        this.NoiNhap = NoiNhap;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
        this.Hinh = Hinh;
        this.MaNV = MaNV;
        this.MaGiamGia = MaGiamGia;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getNoiNhap() {
        return NoiNhap;
    }

    public void setNoiNhap(String NoiNhap) {
        this.NoiNhap = NoiNhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(String MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    
}

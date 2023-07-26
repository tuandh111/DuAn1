/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class KhachHangModel {
    private String MaKH,TenKH,SDT,NgaySinh,DiaChi;
    private boolean GT;
    private String LoaiKH;
    private boolean TrangThai;
    private String MoTa,MaNV,Hinh;

    public KhachHangModel(String MaKH, String TenKH, String SDT, String NgaySinh, String DiaChi, boolean GT, String LoaiKH, boolean TrangThai, String MoTa, String MaNV, String Hinh) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.GT = GT;
        this.LoaiKH = LoaiKH;
        this.TrangThai = TrangThai;
        this.MoTa = MoTa;
        this.MaNV = MaNV;
        this.Hinh = Hinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isGT() {
        return GT;
    }

    public void setGT(boolean GT) {
        this.GT = GT;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(String LoaiKH) {
        this.LoaiKH = LoaiKH;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public KhachHangModel() {
    }

            
}

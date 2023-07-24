/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author Administrator
 */
public class GiamGiaModel {

    private String MaGG;
    private String NgayBD;
    private String NgayKT;
    private float PhanTram;
    private String Mota;
    private boolean TrangThai;
    private String MaNV;

    public GiamGiaModel() {
    }

    public GiamGiaModel(String MaGG, String NgayBD, String NgayKT, float PhanTram, String Mota, boolean TrangThai, String MaNV) {
        this.MaGG = MaGG;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.PhanTram = PhanTram;
        this.Mota = Mota;
        this.TrangThai = TrangThai;
        this.MaNV = MaNV;
    }

    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public String getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(String NgayBD) {
        this.NgayBD = NgayBD;
    }

    public String getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(String NgayKT) {
        this.NgayKT = NgayKT;
    }

    public float getPhanTram() {
        return PhanTram;
    }

    public void setPhanTram(float PhanTram) {
        this.PhanTram = PhanTram;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

}

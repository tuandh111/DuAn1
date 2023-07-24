/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class GiamGiaModel {
   private String MaGG;
   private String NgayBD;
   private String NgayKT;
   private String PhanTram;
   private String MoTa;
   private boolean TrangThai;
   private String MaNV;

    public GiamGiaModel(String MaGG, String NgayBD, String NgayKT, String PhanTram, String MoTa, boolean TrangThai, String MaNV) {
        this.MaGG = MaGG;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.PhanTram = PhanTram;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
        this.MaNV = MaNV;
    }

    public GiamGiaModel() {
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

    public String getPhanTram() {
        return PhanTram;
    }

    public void setPhanTram(String PhanTram) {
        this.PhanTram = PhanTram;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
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

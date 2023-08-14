/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

import java.util.Date;

/**
 *
 * @author trana
 */
public class ThanhToanLuongModel {
    private String maLuong;
    private float soNgayLam;
    private double luongCoBan;
    private String ngayVaoCTy;
    private float soGioTangCa;
    private double luongTangCa;
    private double khoanTru;
    private double tongTien;
    private boolean trangThai;
    private String LiDo;
    public ThanhToanLuongModel() {
    }

    public ThanhToanLuongModel(String maLuong, float soNgayLam, double luongCoBan, String ngayVaoCTy, float soGioTangCa, double luongTangCa, double khoanTru, double tongTien, boolean trangThai,String LiDo) {
        this.maLuong = maLuong;
        this.soNgayLam = soNgayLam;
        this.luongCoBan = luongCoBan;
        this.ngayVaoCTy = ngayVaoCTy;
        this.soGioTangCa = soGioTangCa;
        this.luongTangCa = luongTangCa;
        this.khoanTru = khoanTru;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.LiDo= LiDo;
    }

    public String getLiDo() {
        return LiDo;
    }

    public void setLiDo(String LiDo) {
        this.LiDo = LiDo;
    }
    
    public String getMaLuong() {
        return maLuong;
    }
    
    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public float getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(float soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getNgayVaoCTy() {
        return ngayVaoCTy;
    }

    public void setNgayVaoCTy(String ngayVaoCTy) {
        this.ngayVaoCTy = ngayVaoCTy;
    }

    public float getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(float soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    public double getLuongTangCa() {
        return luongTangCa;
    }

    public void setLuongTangCa(double luongTangCa) {
        this.luongTangCa = luongTangCa;
    }

    public double getKhoanTru() {
        return khoanTru;
    }

    public void setKhoanTru(double khoanTru) {
        this.khoanTru = khoanTru;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}

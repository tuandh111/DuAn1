/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author trana
 */
public class BaoHanhModel {
    private String maBH,maHD,soEmei,ghiChu,maKH,ngayBH,ngayHetHan;

    public BaoHanhModel() {
    }

    public BaoHanhModel(String maBH, String maHD, String soEmei, String ghiChu, String maKH, String ngayBH, String ngayHetHan) {
        this.maBH = maBH;
        this.maHD = maHD;
        this.soEmei = soEmei;
        this.ghiChu = ghiChu;
        this.maKH = maKH;
        this.ngayBH = ngayBH;
        this.ngayHetHan = ngayHetHan;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getSoEmei() {
        return soEmei;
    }

    public void setSoEmei(String soEmei) {
        this.soEmei = soEmei;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayBH() {
        return ngayBH;
    }

    public void setNgayBH(String ngayBH) {
        this.ngayBH = ngayBH;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    
    
}

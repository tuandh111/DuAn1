/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class MangHinhModel {
    private String MaMangHinh;
    private String loaiSp;

    public MangHinhModel(String MaMangHinh, String loaiSp) {
        this.MaMangHinh = MaMangHinh;
        this.loaiSp = loaiSp;
    }

    public MangHinhModel() {
    }

    public String getMaMangHinh() {
        return MaMangHinh;
    }

    public void setMaMangHinh(String MaMangHinh) {
        this.MaMangHinh = MaMangHinh;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }
    
}

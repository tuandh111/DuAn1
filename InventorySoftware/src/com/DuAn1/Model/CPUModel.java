/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class CPUModel {
    private String MaCPU;
    private String LoaiSanPham;

    public CPUModel() {
    }

    public CPUModel(String MaCPU, String LoaiSanPham) {
        this.MaCPU = MaCPU;
        this.LoaiSanPham = LoaiSanPham;
    }

    public String getMaCPU() {
        return MaCPU;
    }

    public void setMaCPU(String MaCPU) {
        this.MaCPU = MaCPU;
    }

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String LoaiSanPham) {
        this.LoaiSanPham = LoaiSanPham;
    }
    
}

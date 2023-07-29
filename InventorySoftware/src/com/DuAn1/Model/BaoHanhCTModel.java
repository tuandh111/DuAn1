/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author trana
 */
public class BaoHanhCTModel {
    private int maBHCT,soLuong;
    private String maBH,maHD;

    public BaoHanhCTModel() {
    }

    public BaoHanhCTModel(int maBHCT, int soLuong, String maBH, String maHD) {
        this.maBHCT = maBHCT;
        this.soLuong = soLuong;
        this.maBH = maBH;
        this.maHD = maHD;
    }

    public int getMaBHCT() {
        return maBHCT;
    }

    public void setMaBHCT(int maBHCT) {
        this.maBHCT = maBHCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
    
}

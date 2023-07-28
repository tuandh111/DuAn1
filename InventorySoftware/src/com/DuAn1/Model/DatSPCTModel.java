/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class DatSPCTModel {
    private int ID;
    private String MaSP;
    private String MaDH;
    private String SoLuong;

    public DatSPCTModel(int ID, String MaSP, String MaHD, String SoLuong) {
        this.ID = ID;
        this.MaSP = MaSP;
        this.MaDH = MaHD;
        this.SoLuong = SoLuong;
    }

    public DatSPCTModel() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}

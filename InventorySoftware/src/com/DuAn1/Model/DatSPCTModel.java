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
    private double gia;
    private int SoLuong;

    public DatSPCTModel(int ID, String MaSP, String MaDH, double gia, int SoLuong) {
        this.ID = ID;
        this.MaSP = MaSP;
        this.MaDH = MaDH;
        this.gia = gia;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
 

    
}

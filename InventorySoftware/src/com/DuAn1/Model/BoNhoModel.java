/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class BoNhoModel {
    private String MaBoNho;
    private String LoaiSP;

    public String getMaBoNho() {
        return MaBoNho;
    }

    public void setMaBoNho(String MaBoNho) {
        this.MaBoNho = MaBoNho;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public BoNhoModel(String MaBoNho, String LoaiSP) {
        this.MaBoNho = MaBoNho;
        this.LoaiSP = LoaiSP;
    }

    public BoNhoModel() {
    }
    
    
}

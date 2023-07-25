/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class RamModel {
    private String MaRam;
    private String LoaiSP;

    public RamModel() {
    }

    public RamModel(String MaRam, String LoaiSP) {
        this.MaRam = MaRam;
        this.LoaiSP = LoaiSP;
    }

    public String getMaRam() {
        return MaRam;
    }

    public void setMaRam(String MaRam) {
        this.MaRam = MaRam;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }
    
}

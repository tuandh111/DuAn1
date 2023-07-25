/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class PinModel {
    private String MaPin;
    private String LoaiSP;

    public PinModel(String MaPin, String LoaiSP) {
        this.MaPin = MaPin;
        this.LoaiSP = LoaiSP;
    }

    public PinModel() {
    }

    public String getMaPin() {
        return MaPin;
    }

    public void setMaPin(String MaPin) {
        this.MaPin = MaPin;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }
    
}

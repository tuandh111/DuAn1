/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author Administrator
 */
public class VaiTroModel {

    private String MaVT;
    private String TenVT;
    private String Ghichu;

    public VaiTroModel() {
    }

    public VaiTroModel(String MaVT, String TenVT, String Ghichu) {
        this.MaVT = MaVT;
        this.TenVT = TenVT;
        this.Ghichu = Ghichu;
    }

    public String getMaVT() {
        return MaVT;
    }

    public void setMaVT(String MaVT) {
        this.MaVT = MaVT;
    }

    public String getTenVT() {
        return TenVT;
    }

    public void setTenVT(String TenVT) {
        this.TenVT = TenVT;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

}

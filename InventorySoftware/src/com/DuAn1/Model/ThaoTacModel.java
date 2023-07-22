/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class ThaoTacModel {
    private int ID;
    private String ThoiGianThem;
    private String ThoiGianSua;
    private String ThoiGianXoa;
    private String ThoIGianHoatDong;
    private String BanThaoTac;
    private String MaNV;

    public ThaoTacModel(int ID, String ThoiGianThem, String ThoiGianSua, String ThoiGianXoa, String ThoIGianHoatDong, String BanThaoTac, String MaNV) {
        this.ID = ID;
        this.ThoiGianThem = ThoiGianThem;
        this.ThoiGianSua = ThoiGianSua;
        this.ThoiGianXoa = ThoiGianXoa;
        this.ThoIGianHoatDong = ThoIGianHoatDong;
        this.BanThaoTac = BanThaoTac;
        this.MaNV = MaNV;
    }

    public ThaoTacModel() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getThoiGianThem() {
        return ThoiGianThem;
    }

    public void setThoiGianThem(String ThoiGianThem) {
        this.ThoiGianThem = ThoiGianThem;
    }

    public String getThoiGianSua() {
        return ThoiGianSua;
    }

    public void setThoiGianSua(String ThoiGianSua) {
        this.ThoiGianSua = ThoiGianSua;
    }

    public String getThoiGianXoa() {
        return ThoiGianXoa;
    }

    public void setThoiGianXoa(String ThoiGianXoa) {
        this.ThoiGianXoa = ThoiGianXoa;
    }

    public String getThoIGianHoatDong() {
        return ThoIGianHoatDong;
    }

    public void setThoIGianHoatDong(String ThoIGianHoatDong) {
        this.ThoIGianHoatDong = ThoIGianHoatDong;
    }

    public String getBanThaoTac() {
        return BanThaoTac;
    }

    public void setBanThaoTac(String BanThaoTac) {
        this.BanThaoTac = BanThaoTac;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class CameraModel {
    private String MaCamera;
    private String LoaiSP;

    public CameraModel(String MaCamera, String LoaiSP) {
        this.MaCamera = MaCamera;
        this.LoaiSP = LoaiSP;
    }

    public CameraModel() {
    }

    public String getMaCamera() {
        return MaCamera;
    }

    public void setMaCamera(String MaCamera) {
        this.MaCamera = MaCamera;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }
    
}

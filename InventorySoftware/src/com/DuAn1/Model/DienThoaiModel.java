/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author DELL E5470
 */
public class DienThoaiModel {
    private String MaDT;
    private String CPU;
    private String MangHinh;
    private String BoNho;
    private String Camera;
    private String Pin;
    private String Ram;
    private String MoTa;

    public DienThoaiModel(String MaDT, String CPU, String MangHinh, String BoNho, String Camera, String Pin, String Ram, String MoTa) {
        this.MaDT = MaDT;
        this.CPU = CPU;
        this.MangHinh = MangHinh;
        this.BoNho = BoNho;
        this.Camera = Camera;
        this.Pin = Pin;
        this.Ram = Ram;
        this.MoTa = MoTa;
    }

    public DienThoaiModel() {
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getMangHinh() {
        return MangHinh;
    }

    public void setMangHinh(String MangHinh) {
        this.MangHinh = MangHinh;
    }

    public String getBoNho() {
        return BoNho;
    }

    public void setBoNho(String BoNho) {
        this.BoNho = BoNho;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}

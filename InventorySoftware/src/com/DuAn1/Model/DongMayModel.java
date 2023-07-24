/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author trana
 */
public class DongMayModel {
    private int maDong;
    private String loaiSP;
    private String CPU;
    private String manHinh;
    private String boNho,moTa,maSP,Camera,pin,RAM;

    public DongMayModel() {
    }

    public DongMayModel(int maDong, String loaiSP, String CPU, String manHinh, String boNho, String moTa, String maSP, String Camera, String pin, String RAM) {
        this.maDong = maDong;
        this.loaiSP = loaiSP;
        this.CPU = CPU;
        this.manHinh = manHinh;
        this.boNho = boNho;
        this.moTa = moTa;
        this.maSP = maSP;
        this.Camera = Camera;
        this.pin = pin;
        this.RAM = RAM;
    }

    public int getMaDong() {
        return maDong;
    }

    public void setMaDong(int maDong) {
        this.maDong = maDong;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getCamera() {
        return Camera;
    }

    public void setCamera(String Camera) {
        this.Camera = Camera;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
    
}

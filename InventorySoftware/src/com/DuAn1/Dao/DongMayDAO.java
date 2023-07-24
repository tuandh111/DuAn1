/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DongMayModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThanhToanLuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author trana
 */
public class DongMayDAO {
    public void insert(DongMayModel model) {
        String sql = "insert into DONGMAY values (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaDong(),
                model.getLoaiSP(),
                model.getCPU(),
                model.getManHinh(),
                model.getBoNho(),
                model.getMoTa(),
                model.getMaSP(),
                model.getCamera(),
                model.getPin(),
                model.getRAM());
    }
    public void update(DongMayModel model) {
        String sql = "update DONGMAY set LoaiSanPham=?,CPU=?,MangHinh=?,BoNho=?,MoTa=?,MaSP=?,CAMERA=?,Pin=?,RAM=? where MaDong=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaDong(),
                model.getLoaiSP(),
                model.getCPU(),
                model.getManHinh(),
                model.getBoNho(),
                model.getMoTa(),
                model.getMaSP(),
                model.getCamera(),
                model.getPin(),
                model.getRAM());
    }
    public void delete(String MaDong) {
        String sql = "DELETE FROM DONGMAY WHERE MaDong=?";
        JdbcHelper.executeUpdate(sql, MaDong);
    }
    public List<DongMayModel> select() {
        String sql = "SELECT * FROM DONGMAY ";
        return select(sql);
    }
    public DongMayModel findById(String maDong) {
        String sql = "SELECT * FROM DONGMAY WHERE MaDong=?";
        List<DongMayModel> list = select(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<DongMayModel> select(String sql, Object... args) {
        List<DongMayModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs =com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                   DongMayModel model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("tuan");
        return list;
    }
    private DongMayModel readFromResultSet(ResultSet rs) throws SQLException {
        DongMayModel model = new DongMayModel();
        model.setMaDong(rs.getInt("MaDong"));
        model.setLoaiSP(rs.getString("LoaiSanPham"));
        model.setCPU(rs.getString("CPU"));
        model.setManHinh(rs.getString("MangHinh"));
        model.setBoNho(rs.getString("BoNho"));
        model.setMoTa(rs.getString("MoTa"));
        model.setMaSP(rs.getString("MaSP"));
        model.setCamera(rs.getString("CAMERA"));
        model.setPin(rs.getString("Pin"));
        model.setRAM(rs.getString("RAM"));
        

        return model;
    }
    public List<DongMayModel> orderByName() {
        String sql = "SELECT * FROM DONGMAY order by LoaiSanPham";
        return select(sql);
    }
    public List<DongMayModel> orderById() {
        String sql = "SELECT * FROM DONGMAY order by LoaiSanPham desc";
        return select(sql);
    }
}

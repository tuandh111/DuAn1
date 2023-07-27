/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DienThoaiModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.SanPhamModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class DienThoaiDao {

    public void insert(DienThoaiModel model) {
        String sql = "Insert into DienThoai values (?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaDT(),
                model.getCPU(),
                model.getMangHinh(),
                model.getBoNho(),
                model.getMoTa(),
                model.getCamera(),
                model.getPin(),
                model.getRam()
        );
    }

    public void update(DienThoaiModel model) {
        String sql = "update DIENTHOAI set CPU=?,MangHinh=?,BoNho=?,MoTa=?,CAMERA=?,PIN=?,RAM=? where MADT=?";
        JdbcHelper.executeUpdate(sql,
                model.getCPU(),
                model.getMangHinh(),
                model.getBoNho(),
                model.getMoTa(),
                model.getCamera(),
                model.getPin(),
                model.getRam(),
                model.getMaDT()
        );
    }

    public List<DienThoaiModel> select() {
        String sql = "SELECT * FROM DIENTHOAI";
        return select(sql);
    }

    public DienThoaiModel findById(String makh) {
        String sql = "SELECT * FROM DIENTHOAI WHERE MaDT=?";
        List<DienThoaiModel> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<DienThoaiModel> select(String sql, Object... args) {
        List<DienThoaiModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DienThoaiModel model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private DienThoaiModel readFromResultSet(ResultSet rs) throws SQLException {
        DienThoaiModel model = new DienThoaiModel();
        model.setMaDT(rs.getString("MaDT"));
        model.setCPU(rs.getString("CPU"));
        model.setMangHinh(rs.getString("MangHinh"));
        model.setBoNho(rs.getString("BoNho"));
        model.setMoTa(rs.getString("MoTa"));
        model.setCamera(rs.getString("CAMERA"));
        model.setPin(rs.getString("Pin"));
        model.setRam(rs.getString("RAM"));
        return model;
    }
}

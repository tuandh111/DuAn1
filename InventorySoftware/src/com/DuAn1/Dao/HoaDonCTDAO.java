/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.HoaDonCTModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HoaDonCTDAO {
    public void insert(HoaDonCTModel model) {
        String sql = "Insert into HOADONCT values (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHDCT(),
                model.getMaSP(),
                model.getSoLuong(),
                model.getMaHD()
        );
    }

    public List<HoaDonCTModel> select() {
        String sql = "SELECT * FROM HOADONCT";
        return select(sql);
    }

    public void delete(HoaDonCTModel model) {
        String sql = "DELETE HOADONCT WHERE MaHD = ?";
        JdbcHelper.executeUpdate(sql, model.getMaHD());
    }

    private List<HoaDonCTModel> select(String sql, Object... args) {
        List<HoaDonCTModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonCTModel model = readFromResultSet(rs);
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

    private HoaDonCTModel readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonCTModel model = new HoaDonCTModel();
        model.setMaHDCT(rs.getString(1));
        model.setMaSP(rs.getString(2));
        model.setSoLuong(rs.getFloat(3));
        model.setMaHD(rs.getString(4));
        return model;
    }
}
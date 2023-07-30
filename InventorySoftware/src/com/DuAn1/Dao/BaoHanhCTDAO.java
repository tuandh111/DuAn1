/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Model.BaoHanhCTModel;
import com.DuAn1.Model.HoaDonCTModel;
import com.tuandhpc05076.helper.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class BaoHanhCTDAO {

    public void insert(BaoHanhCTModel model) {
        String sql = "Insert into BAOHANHCT values (?,?,?)";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql,
                model.getMaBH(),
                model.getMaHD(),
                model.getSoLuong()
        );
    }

    public void delete(BaoHanhCTModel model) {
        String sql = "DELETE BAOHANHCT WHERE MaBHCT = ?";
        JdbcHelper.executeUpdate(sql, model.getMaHD());
    }

    public List<BaoHanhCTModel> selectAll(String MaBHCT) {
        String sql = "SELECT * FROM BAOHANHCT WHERE MaBH = ?";
        return select(sql, MaBHCT);
    }

    public void XoaTatCa(String MaDH) {
        String sql = "DELETE BAOHANHCT WHERE MaBH = ?";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql, MaDH);
    }

    public List<BaoHanhCTModel> select(String sql, Object... args) {
        List<BaoHanhCTModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BaoHanhCTModel model = readFromResultSet(rs);
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

    private BaoHanhCTModel readFromResultSet(ResultSet rs) throws SQLException {
        BaoHanhCTModel model = new BaoHanhCTModel();
        model.setMaBHCT(rs.getInt(1));
        model.setMaBH(rs.getString(2));
        model.setMaHD(rs.getString(3));
        model.setSoLuong(rs.getInt(4));
        return model;
    }
}

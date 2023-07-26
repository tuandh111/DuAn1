/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.KhachHangModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class DatSPDAO {

    public void insert(DatSPModel model) {
        String sql = "Insert into DATSP values (?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaDH(),
                model.getSoLuong(),
                model.getSDT(),
                model.isTrangThai(),
                model.getDonGia(),
                model.getTongTien(),
                model.getThue(),
                model.getMaNV()
        );
    }
       private List<KhachHangModel> select(String sql, Object... args) {
        List<KhachHangModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHangModel model = readFromResultSet(rs);
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

    private KhachHangModel readFromResultSet(ResultSet rs) throws SQLException {
        KhachHangModel model = new KhachHangModel();
        model.setMaKH(rs.getString(1));
        model.setTenKH(rs.getString(2));
        model.setSDT(rs.getString(3));
        model.setNgaySinh(rs.getString(4));
        model.setDiaChi(rs.getString(5));
        model.setGT(rs.getBoolean(6));
        model.setLoaiKH(rs.getString(7));
        model.setTrangThai(rs.getBoolean(8));
        model.setMoTa(rs.getString(9));
        model.setMaNV(rs.getString(10));
        model.setHinh(rs.getString(11));
        return model;
    }
}

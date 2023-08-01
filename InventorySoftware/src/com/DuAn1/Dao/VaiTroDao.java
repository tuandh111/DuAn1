/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.VaiTroModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class VaiTroDao {

    public void insert(VaiTroModel model) {
        String sql = "Insert into VAITRO values (?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaVT(),
                model.getTenVT(),
                model.getGhichu()
        );
    }

    public void update(VaiTroModel model) {
        String sql = "update VAITRO set ChucVu=?,GhiChu=? where MaVaiTro=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenVT(),
                model.getGhichu(),
                model.getMaVT()
        );
    }

    public List<VaiTroModel> select() {
        String sql = "SELECT * FROM VAITRO";
        return select(sql);
    }

    public void delete(VaiTroModel model) {
        String sql = "DELETE VAITRO WHERE MAVaiTro = ?";
        JdbcHelper.executeUpdate(sql, model.getMaVT());
    }

    public VaiTroModel findById(String makh) {
        String sql = "SELECT * FROM VAITRO WHERE MaVaiTro=?";
        List<VaiTroModel> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<VaiTroModel> orderByTang() {
        String sql = "select * from VAITRO order by MaVaiTro";
        return this.select(sql);
    }

    public List<VaiTroModel> orderByGiam() {
        String sql = "select * from VAITRO order by MaVaiTro desc";
        return this.select(sql);
    }

    private List<VaiTroModel> select(String sql, Object... args) {
        List<VaiTroModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    VaiTroModel model = readFromResultSet(rs);
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

    private VaiTroModel readFromResultSet(ResultSet rs) throws SQLException {
        VaiTroModel model = new VaiTroModel();
        model.setMaVT(rs.getString("MavaiTro"));
        model.setTenVT(rs.getString("ChucVu"));
        model.setGhichu(rs.getString("GhiChu"));
        return model;
    }

    public List<VaiTroModel> TimKiemTheoTen(String MaGG) {
        String sql = "SELECT * FROM VAITRO WHERE MaVaiTro LIKE ?";
        return select(sql, "%" + MaGG + "%");
    }
}

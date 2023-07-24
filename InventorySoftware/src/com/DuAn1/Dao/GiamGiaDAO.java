/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.GiamGiaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class GiamGiaDAO {
    public void insert(GiamGiaModel model) {
        String sql = "Insert into GIAMGIA values (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaGG(),
                model.getNgayBD(),
                model.getNgayKT(),
                model.getPhanTram(),
                model.getMota(),
                model.isTrangThai(),
                model.getMaNV()
        );
    }

    public void update(GiamGiaModel model) {
        String sql = "Update GIAMGIA set NgayBD=?,NgayKT=?,PhanTram=?,MoTa=?,TrangThai=?,MaNV=? where MaGiamGia=?";
        JdbcHelper.executeUpdate(sql,
                model.getNgayBD(),
                model.getNgayKT(),
                model.getPhanTram(),
                model.getMota(),
                model.isTrangThai(),
                model.getMaNV(),
                model.getMaGG()
        );
    }

    public List<GiamGiaModel> select() {
        String sql = "SELECT * FROM GIAMGIA";
        return select(sql);
    }

    private List<GiamGiaModel> select(String sql, Object... args) {
        List<GiamGiaModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    GiamGiaModel model = readFromResultSet(rs);
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

    private GiamGiaModel readFromResultSet(ResultSet rs) throws SQLException {
        GiamGiaModel model = new GiamGiaModel();
        model.setMaGG(rs.getString("MaGiamGia"));
        model.setNgayBD(rs.getString("NgayBD"));
        model.setNgayKT(rs.getString("NgayKT"));
        model.setPhanTram(rs.getFloat("PhanTram"));
        model.setMota(rs.getString("MoTa"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setMaNV(rs.getString("MaNV"));
        return model;
    }
    public GiamGiaModel findById(String makh) {
        String sql = "SELECT * FROM GIAMGIA WHERE MaGiamGia=?";
        List<GiamGiaModel> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
}

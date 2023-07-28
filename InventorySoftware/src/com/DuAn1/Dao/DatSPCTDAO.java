/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DatSPCTModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class DatSPCTDAO {

    public void insert(DatSPCTModel model) {
        String sql = "Insert into DATSPCT values (?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getSoLuong(),
                model.getMaDH(),
                model.getMaSP()
        );
    }

    public List<DatSPCTModel> select(String ma) {
        String sql = "SELECT * FROM DATSPCT WHERE MaDH=?";
        return select(sql, ma);
    }

    public void delete(DatSPCTModel model) {
        String sql = "DELETE DATSPCT WHERE MaSP = ?";
        JdbcHelper.executeUpdate(sql, model.getMaSP());
    }

    private List<DatSPCTModel> select(String sql, Object... args) {
        List<DatSPCTModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DatSPCTModel model = readFromResultSet(rs);
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

    private DatSPCTModel readFromResultSet(ResultSet rs) throws SQLException {
        DatSPCTModel model = new DatSPCTModel();
        model.setID(rs.getInt(1));
        model.setSoLuong(rs.getString(2));
        model.setMaDH(rs.getString(3));
        model.setMaSP(rs.getString(4));
        return model;
    }
}

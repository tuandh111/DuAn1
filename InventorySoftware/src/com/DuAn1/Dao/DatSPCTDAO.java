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
        String sql = "Insert into DATSPCT values (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getSoLuong(),
                model.getGia(),
                model.getMaDH(),
                model.getMaSP()
        );
    }

    public List<DatSPCTModel> select(String ma) {
        String sql = "SELECT * FROM DATSPCT WHERE MaDH=?";
        return select(sql, ma);
    }

    public void delete(DatSPCTModel model) {
        String sql = "UPDATE DATSP SET TRANGTHAI = 0 WHERE MaDH = ?";
        JdbcHelper.executeUpdate(sql, model.getMaSP());
    }
       public void Xoa(String maDH,String MaSP) {
        String sql = "DELETE DATSPCT WHERE MaDH = ? and MaSP=?";
        JdbcHelper.executeUpdate(sql,maDH,MaSP );
    }
     public void XoaTatCa(String MaDH) {
        String sql = "DELETE DATSPCT WHERE MaDH = ?";
        JdbcHelper.executeUpdate(sql, MaDH);
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
        model.setSoLuong(rs.getInt(2));
        model.setGia(rs.getDouble(3));
        model.setMaDH(rs.getString(4));
        model.setMaSP(rs.getString(5));
        return model;
    }
}

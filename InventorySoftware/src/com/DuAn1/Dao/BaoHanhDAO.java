/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.BaoHanhModel;
import com.DuAn1.Model.DatSPModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class BaoHanhDAO {

    public void insert(BaoHanhModel model) {
        String sql = "Insert into BAOHANH values (?,?,?,?,?,?,?,?,?) ";
        JdbcHelper.executeUpdate(sql,
                model.getMaBH(),
                model.getMaHD(),
                model.getSoEmei(),
                model.getNgayBH(),
                model.getNgayHetHan(),
                model.getGhiChu(),
                model.getMaKH(),
                model.getMaSPCu(),
                model.getMaHDCu()
        );
    }

    public List<BaoHanhModel> select1(String MaBH) {
        String sql = "SELECT * FROM BaoHanh WHERE MaBH like ?";
        return select(sql, "%" + MaBH + "%");
    }

    public List<BaoHanhModel> selectall() {
        String sql = "select * from baohanh";
        return select(sql);
    }

    public List<BaoHanhModel> TimKiem(String Ma) {
        String sql = "SELECT * FROM baohanh WHERE maBH like ?";
        return select(sql, "%" + Ma + "%");
    }

    public void update(BaoHanhModel model) {
        String sql = "update BaoHanh set MaSP=?,SoIMEI=?,NgayBH=?,NgayHetHan=?,GhiChu=?,MaKH=? , MaSPCu=? , MaHDCu =?where MaBH=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaHD(),
                model.getSoEmei(),
                model.getNgayBH(),
                model.getNgayHetHan(),
                model.getGhiChu(),
                model.getMaKH(),
                model.getMaBH(), 
                model.getMaSPCu(),
                model.getMaHDCu());
    }

    public void delete(BaoHanhModel model) {
        String sql = "DELETE BaoHanh WHERE MaBH = ?";
        JdbcHelper.executeUpdate(sql, model.getMaBH());
    }

    private List<BaoHanhModel> select(String sql, Object... args) {
        List<BaoHanhModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BaoHanhModel model = readFromResultSet(rs);
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

    private BaoHanhModel readFromResultSet(ResultSet rs) throws SQLException {
        BaoHanhModel model = new BaoHanhModel();
        model.setMaBH(rs.getString(1));
        model.setMaHD(rs.getString(2));
        model.setSoEmei(rs.getString(3));
        model.setNgayBH(rs.getString(4));
        model.setNgayHetHan(rs.getString(5));
        model.setGhiChu(rs.getString(6));
        model.setMaKH(rs.getString(7));
        model.setMaSPCu(rs.getString(8));
         model.setMaHDCu(rs.getString(9));
        return model;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DongMayModel;
import com.DuAn1.Model.ThaoTacModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class ThaoTacDAO {

    public void insert(ThaoTacModel model) throws SQLException {
        String sql = "Insert into LICHSU (ThoiGianThem,ThoiGianSua, ThoiGianXoa,ThoiGianHoatDong,BangThaoTac,MaNV)values (?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getThoiGianThem(),
                model.getThoiGianSua(),
                model.getThoiGianXoa(),
                model.getThoIGianHoatDong(),
                model.getBanThaoTac(),
                model.getMaNV()
        );
    }

    public List<ThaoTacModel> select() {
        String sql = "SELECT * FROM LICHSU";
        return select(sql);
    }
       public List<ThaoTacModel> selectMa(String MaNV) {
        String sql = "SELECT * FROM LICHSU  where  MaNV like ?";
        return select(sql, "%" + MaNV + "%");
    }
    public List<ThaoTacModel> selectDieuKien(String MaNV, String BangThaoTac) {
        String sql = "SELECT * FROM LICHSU where DAY(ThoiGianHoatDong) = DAY(GETDATE()) and MaNV like ? and BangThaoTac like ?";
        return select(sql, "%" + MaNV + "%", "%" + BangThaoTac + "%");

    }

    public List<ThaoTacModel> selectDieuKienTuanNay(String MaNV, String BangThaoTac) {
        String sql = "SELECT * FROM LICHSU where  MONTH(ThoiGianHoatDong) = MONTH(GETDATE()) AND DAY(ThoiGianHoatDong) >= DAY(GETDATE()) - 7 AND DAY(ThoiGianHoatDong) <= DAY(GETDATE()) and MaNV like ? and BangThaoTac like ?";
        return select(sql, "%" + MaNV + "%", "%" + BangThaoTac + "%");

    }

    public List<ThaoTacModel> selectDieuKienThangNay(String MaNV, String BangThaoTac) {
        String sql = "SELECT * FROM LICHSU where MONTH(ThoiGianHoatDong) = MONTH(GETDATE()) and MaNV like ? and BangThaoTac like ?";
        return select(sql, "%" + MaNV + "%", "%" + BangThaoTac + "%");

    }

    public List<ThaoTacModel> selectDieuKienNamNay(String MaNV, String BangThaoTac) {
        String sql = "SELECT * FROM LICHSU where YEAR(ThoiGianHoatDong) = YEAR(GETDATE()) and MaNV like ? and BangThaoTac like ?";
        return select(sql, "%" + MaNV + "%", "%" + BangThaoTac + "%");

    }

    public List<ThaoTacModel> selectDieuKienMa(String MaNV) {
        String sql = "SELECT * FROM LICHSU where DAY(ThoiGianHoatDong) = DAY(GETDATE()) and MaNV like ?";
        return select(sql, "%" + MaNV + "%");

    }

    public List<ThaoTacModel> selectDieuKienMaTuan(String MaNV) {
        String sql = "SELECT * FROM LICHSU where MONTH(ThoiGianHoatDong) = MONTH(GETDATE()) AND DAY(ThoiGianHoatDong) >= DAY(GETDATE()) - 7 AND DAY(ThoiGianHoatDong) <= DAY(GETDATE()) and MaNV like ?";
        return select(sql, "%" + MaNV + "%");

    }

    public List<ThaoTacModel> selectDieuKienMaThang(String MaNV) {
        String sql = "SELECT * FROM LICHSU where MONTH(ThoiGianHoatDong) = MONTH(GETDATE()) and MaNV like ?";
        return select(sql, "%" + MaNV + "%");

    }

    public List<ThaoTacModel> selectDieuKienMaNam(String MaNV) {
        String sql = "SELECT * FROM LICHSU where YEAR(ThoiGianHoatDong) = YEAR(GETDATE()) and MaNV like ?";
        return select(sql, "%" + MaNV + "%");

    }

    public List<ThaoTacModel> selectHomNay() {
        String sql = "SELECT *FROM lichsu WHERE DAY(ThoiGianHoatDong) = DAY(GETDATE())";
        return select(sql);
    }

    public List<ThaoTacModel> selectTuanNay() {
        String sql = "SELECT * FROM lichsu WHERE MONTH(ThoiGianHoatDong) = MONTH(GETDATE()) AND DAY(ThoiGianHoatDong) >= DAY(GETDATE()) - 7 AND DAY(ThoiGianHoatDong) <= DAY(GETDATE())";
        return select(sql);
    }

    public List<ThaoTacModel> selectThangNay() {
        String sql = "select * FROM lichsu WHERE MONTH(ThoiGianHoatDong) = MONTH(GETDATE())";
        return select(sql);
    }

    public List<ThaoTacModel> selectNamNay() {
        String sql = "SELECT *FROM lichsu WHERE YEAR(ThoiGianHoatDong) = YEAR(GETDATE())";
        return select(sql);
    }

    private List<ThaoTacModel> select(String sql, Object... args) {
        List<ThaoTacModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThaoTacModel model = readFromResultSet(rs);
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

    private ThaoTacModel readFromResultSet(ResultSet rs) throws SQLException {
        ThaoTacModel model = new ThaoTacModel();
        model.setID(rs.getInt("ID"));
        model.setThoiGianThem(rs.getString("ThoiGianThem"));
        model.setThoiGianSua(rs.getString("ThoiGianSua"));
        model.setThoiGianXoa(rs.getString("ThoiGianXoa"));
        model.setThoIGianHoatDong(rs.getString("ThoiGianHoatDong"));
        model.setBanThaoTac(rs.getString("BangThaoTac"));
        model.setMaNV(rs.getString("MaNV"));
        return model;
    }
}

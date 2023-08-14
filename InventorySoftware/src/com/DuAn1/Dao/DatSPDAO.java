/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.SanPhamModel;
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
                model.getThoiGianDat(),
                model.getMaNV()
        );
    }

    public void update(DatSPModel model) {
        String sql = "update DATSP set  SoLuong=?,SDT=?,TrangThai=?,DonGia=?,TongTien=?,ThoiGianDat=?,MaNV=? where MaDH =? ";
        JdbcHelper.executeUpdate(sql,
                model.getSoLuong(),
                model.getSDT(),
                model.isTrangThai(),
                model.getDonGia(),
                model.getTongTien(),
                model.getThoiGianDat(),
                model.getMaNV(),
                model.getMaDH()
        );
    }

    public List<DatSPModel> select() {
        String sql = "SELECT * FROM DATSP WHERE TrangThai =1 ORDER BY ThoiGianDat DESC";
        return select(sql);
    }
    public List<DatSPModel> selectHomNay() {
        String sql = "SELECT * FROM DATSP WHERE DAY(ThoiGianDat) = Day(GETDATE()) ORDER BY ThoiGianDat DESC";
        return select(sql);
    }
     public List<DatSPModel> selectTuanNay() {
        String sql = "SELECT * FROM datsp where  MONTH(ThoiGiandat) = MONTH(GETDATE()) \n" +
"AND DAY(ThoiGiandat) >= DAY(GETDATE()) - 7 AND DAY(ThoiGiandat) <= DAY(GETDATE()) ORDER BY ThoiGianDat DESC";
        return select(sql);
    }
   public List<DatSPModel> selectThangNay() {
        String sql = "SELECT * FROM datsp where MONTH(ThoiGiandat) = MONTH(GETDATE()) ORDER BY ThoiGianDat DESC";
        return select(sql);
    }
    public List<DatSPModel> TimKiem(String Ma) {
        String sql = "SELECT * FROM DATSP WHERE TrangThai =1 and MaDH like ? ORDER BY ThoiGianDat DESC";
        return select(sql, "%" + Ma + "%");
    }

    public List<DatSPModel> selectDaXoa() {
        String sql = "SELECT * FROM DATSP WHERE TrangThai =0";
        return select(sql);
    }

    public List<DatSPModel> selectDaXoaTheoMa(String Ma) {
        String sql = "SELECT * FROM DATSP WHERE TrangThai =0 and MaDH like ?";
        return select(sql, "%" + Ma + "%");
    }

    public void delete(DatSPModel model) {
        String sql = "update datsp set TrangThai=0 where MaDH= ?";
        JdbcHelper.executeUpdate(sql, model.getMaDH());
    }

    public void KhoiPhuc(String model) {
        String sql = "update datsp set TrangThai=1 where MaDH= ?";
        JdbcHelper.executeUpdate(sql, model);
    }

    private List<DatSPModel> select(String sql, Object... args) {
        List<DatSPModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DatSPModel model = readFromResultSet(rs);
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

    private DatSPModel readFromResultSet(ResultSet rs) throws SQLException {
        DatSPModel model = new DatSPModel();
        model.setMaDH(rs.getString(1));
        model.setSoLuong(rs.getString(2));
        model.setSDT(rs.getString(3));
        model.setTrangThai(rs.getBoolean(4));
        model.setDonGia(rs.getDouble(5));
        model.setTongTien(rs.getDouble(6));
        model.setThoiGianDat(rs.getString(7));
        model.setMaNV(rs.getString(8));
        return model;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.HoaDonModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO {

    public void insert(HoaDonModel model) {
        String sql = "Insert into HOADON values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaHD(),
                model.getSoluong(),
                model.isTrangThai(),
                model.getDongia(),
                model.getTongtien(),
                model.getNgayXuat(),
                model.getMota(),
                model.getTenCty(),
                model.getMaNV(),
                model.getTenKH(),
                model.getHinhThuc(),
                model.getTienKhach(),
                model.getTienCon()
        );
    }

    public void update(HoaDonModel model) {
        String sql = "update HOADON set  SoLuong=?,TrangThai=?,DonGia=?,TongTien=?,NgayXuat=?,MoTa=?,TenCTY = ?,MaNV=?, TenKH=?,HinhThucTT=?,TienKhach=?,TienCon=? where MaHD =? ";
        JdbcHelper.executeUpdate(sql,
                model.getSoluong(),
                model.isTrangThai(),
                model.getDongia(),
                model.getTongtien(),
                model.getNgayXuat(),
                model.getMota(),
                model.getTenCty(),
                model.getMaNV(),
                model.getTenKH(),
                model.getHinhThuc(),
                model.getTienKhach(),
                model.getTienCon(),
                model.getMaHD()
        );
    }

    public List<HoaDonModel> select() {
        String sql = "SELECT * FROM HOADON WHERE TrangThai =1";
        return select(sql);
    }

    public void delete(HoaDonModel model) {
        String sql = "update HoaDon set TrangThai=0 where MaHD= ?";
        JdbcHelper.executeUpdate(sql, model.getMaHD());
    }

    public List<HoaDonModel> TimKiem(String Ma) {
        String sql = "SELECT * FROM HOADON WHERE TrangThai =1 and MaHD like ?";
        return select(sql, "%" + Ma + "%");
    }

    private List<HoaDonModel> select(String sql, Object... args) {
        List<HoaDonModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonModel model = readFromResultSet(rs);
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

    private HoaDonModel readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonModel model = new HoaDonModel();
        model.setMaHD(rs.getString(1));
        model.setSoluong(rs.getString(2));
        model.setTrangThai(rs.getBoolean(3));
        model.setDongia(rs.getString(4));
        model.setTongtien(rs.getString(5));
        model.setNgayXuat(rs.getString(6));
        model.setMota(rs.getString(7));
        model.setTenCty(rs.getString(8));
        model.setMaNV(rs.getString(9));
        model.setTenKH(rs.getString(10));
        model.setHinhThuc(rs.getString(11));
        model.setTienKhach(rs.getString(12));
        model.setTienCon(rs.getString(13));
        return model;
    }
}

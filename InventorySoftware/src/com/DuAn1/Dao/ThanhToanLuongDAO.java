/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThanhToanLuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class ThanhToanLuongDAO {

    public void insert(ThanhToanLuongModel model) {
        String sql = "Insert into LUONG values (?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaLuong(),
                model.getSoNgayLam(),
                model.getLuongCoBan(),
                model.getNgayVaoCTy(),
                model.getSoGioTangCa(),
                model.getLuongTangCa(),
                model.getKhoanTru(),
                model.getTongTien(),
                model.isTrangThai());
    }

    public void update(ThanhToanLuongModel model) {
        String sql = "Update LUONG set SoNgayLam = ?,LuongCoBan=?,NGAYVAOCTY=?,SOGIOTANGCA =?,LUONGTANGCA =?,KHOANGTRU=?,TONGTIEN=?,TRANGTHAI=? where MALUONG=?";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql,
                model.getSoNgayLam(),
                model.getLuongCoBan(),
                model.getNgayVaoCTy(),
                model.getSoGioTangCa(),
                model.getLuongTangCa(),
                model.getKhoanTru(),
                model.getTongTien(),
                model.isTrangThai(),
                model.getMaLuong()
        );
    }

    public void delete(String maLuong) {
        String sql = "DELETE FROM LUONG WHERE MaLuong=?";
        JdbcHelper.executeUpdate(sql, maLuong);
    }

    public List<ThanhToanLuongModel> select() {
        String sql = "SELECT * FROM LUONG";
        return select(sql);
    }

    public ThanhToanLuongModel findById(String maLuong) {
        String sql = "SELECT * FROM LUONG WHERE MaLuong like ?";
        List<ThanhToanLuongModel> list = select(sql, maLuong);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<ThanhToanLuongModel> select(String sql, Object... args) {
        List<ThanhToanLuongModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThanhToanLuongModel model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("tuan");
        return list;
    }

    public List<ThanhToanLuongModel> TimTheoMaLuong(String maLuong) {
        String sql = "select* from LUONG where MaLuong like ?";
        return select(sql, "%" + maLuong + "%");
    }

    public List<ThanhToanLuongModel> LocTheoLuongCoBan(String maLuong) {
        String sql = "select* from LUONG where LuongCoBan like ?";
        return select(sql, "%" + maLuong + "%");
    }

    public List<ThanhToanLuongModel> XemThanhToanLuongCaNhan(int thang, String MaNV) {
        String sql = "SELECT * from LUONG\n"
                + "WHERE MONTH(NgayVaoCTY) = ? and MaLuong=?";
        return select(sql, thang,  MaNV );
    }

    private ThanhToanLuongModel readFromResultSet(ResultSet rs) throws SQLException {
        ThanhToanLuongModel model = new ThanhToanLuongModel();
        model.setMaLuong(rs.getString(1));
        model.setSoNgayLam(rs.getFloat(2));
        model.setLuongCoBan(rs.getDouble(3));
        model.setNgayVaoCTy(rs.getString(4));
        model.setSoGioTangCa(rs.getFloat(5));
        model.setLuongTangCa(rs.getDouble(6));
        model.setKhoanTru(rs.getDouble(7));
        model.setTongTien(rs.getDouble(8));
        model.setTrangThai(rs.getBoolean(9));

        return model;
    }

    public List<ThanhToanLuongModel> orderByName() {
        String sql = "SELECT * FROM LUONG order by LuongCoBan";
        return select(sql);
    }

    public List<ThanhToanLuongModel> orderById() {
        String sql = "SELECT * FROM LUONG order by LuongCoBan desc";
        return select(sql);
    }
}

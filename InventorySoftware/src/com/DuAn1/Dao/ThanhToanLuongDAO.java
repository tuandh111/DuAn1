/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThanhToanLuongModel;
import com.tuandhpc05076.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author trana
 */
public class ThanhToanLuongDAO {
    public void insert(ThanhToanLuongModel model ){
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
    public void update(ThanhToanLuongModel model){
        String sql = "Update LUONG set SONGAYLAM = ?,LUONCOBAN=?,NGAYVAOCTY=?,SOGIOTANGCA =?,LUONGTANGCA =?,KHOANTRU=?,TONGTIEN=?,TRANGTHAI=? where MALUONG=?";
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
    public void delete(String  maLuong){
        String sql = "DELETE FROM LUONG WHERE MaLuong=?";
        JdbcHelper.executeUpdate(sql, maLuong);
    }
    public List<ThanhToanLuongModel> select() {
        String sql = "SELECT * FROM LUONG";
        return select(sql);
    }
    public ThanhToanLuongModel findById(String maLuong) {
        String sql = "SELECT * FROM LUONG WHERE MaLuong=?";
        List<ThanhToanLuongModel> list = select(sql, maLuong);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<ThanhToanLuongModel> select(String sql, Object... args) {
        List<ThanhToanLuongModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs =com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
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
    private ThanhToanLuongModel readFromResultSet(ResultSet rs) throws SQLException {
        ThanhToanLuongModel model = new ThanhToanLuongModel();
        model.setMaLuong(rs.getString("MaLuong"));
        model.setSoNgayLam(rs.getFloat("SoNgayLam"));
        model.setLuongCoBan(rs.getDouble("LuongCoBan"));
        model.setNgayVaoCTy(rs.getDate("NgayVaoCTY"));
        model.setSoGioTangCa(rs.getFloat("SoGioTangCa"));
        model.setLuongTangCa(rs.getDouble("LuongTangCa"));
        model.setKhoanTru(rs.getDouble("KhoangTru"));
        model.setTongTien(rs.getDouble("TongTien"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        

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

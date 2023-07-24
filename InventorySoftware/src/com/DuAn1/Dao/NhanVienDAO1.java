/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.NhanVienModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class NhanVienDAO1 {

//    public void insert(NhanVienModel model) throws SQLException {
//        String sql = "Insert into NHANVIEN values (?,?,?,?,?,?,?,?,?,?)";
//      JdbcHelper.executeUpdate(sql,
//                model.getMaNV(),
//                model.getHoTen(),
//                model.getNgaySinh(),
//                model.isGioiTinh(),
//                model.getDiaChi(),
//                model.getSDT(),
//                model.getEmail(),
//                model.getMatKhau(),
//                model.getVaiTro(),
//                model.getHinh()
//        );
//    }
//
//    public void update(NhanVienModel model) throws SQLException {
//        String sql = "UPDATE NHANVIEN SET HoTen  = ?, NgaySinh=?, GioiTinh=?, SDT=?, Email =?, MatKhau=?, MaVaiTro=?, Hinh=? WHERE MaNV=?";
//         JdbcHelper.executeUpdate(sql,
//                model.getHoTen(),
//                model.getNgaySinh(),
//                model.isGioiTinh(),
//                model.getDiaChi(),
//                model.getSDT(),
//                model.getEmail(),
//                model.getMatKhau(),
//                model.getVaiTro(),
//                model.getHinh(),
//                model.getMaNV()
//        );
//    }
//
//    public void delete(String id) throws SQLException {
//        String sql = "DELETE FROM NHANVIEN WHERE MaNV=?";
//        JdbcHelper.executeUpdate(sql, id);
//    }
//
//    public List<NhanVienModel> selectAll() {
//        String sql = "SELECT * FROM NHANVIEN";
//        return this.selectBySql(sql);
//    }
//
//    public NhanVienModel selectById(String id) {
//        String sql = "SELECT * FROM NHANVIEN WHERE MaNV =?";
//        List<NhanVienModel> list = this.selectBySql(sql, id);
//        if (list.isEmpty()) {
//            return null;
//
//        }
//        return list.get(0);
//    }
//
//    public List<NhanVienModel> selectByKeyword(String keyword) {
//        String sql = "SELECT * FROM NHANVIEN WHERE HoTen LIKE ?";
//        return selectBySql(sql, "%" + keyword + "%");
//    }
//
//    private List<NhanVienModel> selectBySql(String sql, Object... args) {
//        List<NhanVienModel> list = new ArrayList<NhanVienModel>();
//        try {
//            ResultSet rs =  JdbcHelper.executeQuery(sql, args);
//            while (rs.next()) {
//                NhanVienModel model = new NhanVienModel();
//                model.setMaNV(rs.getString(1));
//                model.setHoTen(rs.getString(2));
//                model.setNgaySinh(rs.getString(3));
//                model.setGioiTinh(rs.getBoolean(4));
//                model.setDiaChi(rs.getString(5));
//                model.setSDT(rs.getString(6));
//                model.setEmail(rs.getString(7));
//                model.setMatKhau(rs.getString(8));
//                model.setVaiTro(rs.getString(9));
//                model.setHinh(rs.getString(10));
//                list.add(model);
//            }
//            rs.getStatement().getConnection().close();
//            return list;
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
    public void insert(NhanVienModel model) {
        String sql = "Insert into NHANVIEN values (?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getSDT(),
                model.getEmail(),
                model.getMatKhau(),
                model.getVaiTro(),
                model.getHinh(),
                model.isTrangThai(),
                model.isTrangThaiXoa());
    }

    public void update(NhanVienModel model) {
        String sql = "UPDATE NHANVIEN SET HoTen  = ?, NgaySinh=?, GioiTinh=?,DiaChi=? ,SDT=?, Email =?, MatKhau=?, MaVaiTro=?, Hinh=?, TrangThai=?, TRANGTHAIXOA=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,
                model.getHoTen(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getSDT(),
                model.getEmail(),
                model.getMatKhau(),
                model.getVaiTro(),
                model.getHinh(),
                model.isTrangThai(),
                model.isTrangThaiXoa(),
                model.getMaNV()
        );
    }

    public void delete(NhanVienModel model) {
        String sql = "UPDATE NHANVIEN SET TRANGTHAIXOA = 0 WHERE MaNV = ?";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV()
                );
    }

    public List<NhanVienModel> select() {
        String sql = "SELECT * FROM NHANVIEN where TrangThaiXoa=1";
        return select(sql);
    }
    public List<NhanVienModel> selectHoatDong() {
        String sql = "SELECT * FROM NHANVIEN where TrangThai=1 and TrangThaiXoa=1";
        return select(sql);
    }
    public NhanVienModel findById(String makh) {
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV=?";
        List<NhanVienModel> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVienModel> select(String sql, Object... args) {
        List<NhanVienModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVienModel model = readFromResultSet(rs);
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

    private NhanVienModel readFromResultSet(ResultSet rs) throws SQLException {
        NhanVienModel model = new NhanVienModel();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoTen(rs.getString("HoTen"));
        model.setNgaySinh(rs.getString("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setSDT(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getString("MaVaiTro"));
        model.setHinh(rs.getString("Hinh"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setTrangThaiXoa(rs.getBoolean("TRANGTHAIXOA"));

        return model;
    }

    public List<NhanVienModel> orderByName() {
        String sql = "SELECT * FROM NHANVIEN order by HoTen";
        return select(sql);
    }

    public List<NhanVienModel> orderById() {
        String sql = "SELECT * FROM NHANVIEN order by MaNV desc";
        return select(sql);
    }
}

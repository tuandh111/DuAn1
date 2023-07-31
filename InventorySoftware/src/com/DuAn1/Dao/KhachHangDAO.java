/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.KhachHangModel;
import com.DuAn1.Model.NhanVienModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class KhachHangDAO {

    public void insert(KhachHangModel model) {
        String sql = "Insert into KHACHHANG values (?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaKH(),
                model.getTenKH(),
                model.getSDT(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.isGT(),
                model.getLoaiKH(),
                model.isTrangThai(),
                model.getMoTa(),
                model.getMaNV(),
                model.getHinh()
        );
    }

    public void update(KhachHangModel model) {
        String sql = "Update KHACHHANG set TENKH= ?,SDT=?,NGAYSINH=?,DIACHI=?,GIOITINH=?,LOAIKH=?,TRANGTHAI=?,MOTA=?,MANV=?,HINH=? where MAKH=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenKH(),
                model.getSDT(),
                model.getNgaySinh(),
                model.getDiaChi(),
                model.isGT(),
                model.getLoaiKH(),
                model.isTrangThai(),
                model.getMoTa(),
                model.getMaNV(),
                model.getHinh(),
                model.getMaKH()
        );
    }

    public KhachHangModel findById(String makh) {
        String sql = "select * from KHACHHANG WHERE MaKH = ?";
        List<KhachHangModel> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void delete(KhachHangModel model) {
        String sql = "Update KHACHHANG set TrangThai=0 where MaKH=?";
        JdbcHelper.executeUpdate(sql, model.getMaKH());
    }

    public List<KhachHangModel> select() {
        String sql = "SELECT * from KHACHHANG where TrangThai=1";
        return select(sql);
    }

    public List<KhachHangModel> selectDaXoa() {
        String sql = "SELECT * from KHACHHANG where TrangThai=0";
        return select(sql);
    }

    public List<KhachHangModel> selectSDT(String SDT) {
        String sql = "SELECT * from KHACHHANG where SDT = ?";
        return select(sql, SDT);
    }

    public List<KhachHangModel> selectTen(String SDT) {
        String sql = "SELECT * from KHACHHANG where TenKH = ?";
        return select(sql, SDT);
    }

    public void KhoiPhuc(String model) {
        String sql = "update KHACHHANG set TrangThai=1 where MaKH= ?";
        JdbcHelper.executeUpdate(sql, model);
    }

    public List<KhachHangModel> selectDaXoaTheoMa(String Ma) {
        String sql = "SELECT * FROM KhachHang WHERE  MaKH like ?";
        return select(sql, "%" + Ma + "%");
    }
       public List<KhachHangModel> selectDaX(String Ma) {
        String sql = "SELECT * FROM KhachHang WHERE  MaKH like ? and TrangThai=0";
        return select(sql, "%" + Ma + "%");
    }
    private List<KhachHangModel> select(String sql, Object... args) {
        List<KhachHangModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHangModel model = readFromResultSet(rs);
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

    private KhachHangModel readFromResultSet(ResultSet rs) throws SQLException {
        KhachHangModel model = new KhachHangModel();
        model.setMaKH(rs.getString(1));
        model.setTenKH(rs.getString(2));
        model.setSDT(rs.getString(3));
        model.setNgaySinh(rs.getString(4));
        model.setDiaChi(rs.getString(5));
        model.setGT(rs.getBoolean(6));
        model.setLoaiKH(rs.getString(7));
        model.setTrangThai(rs.getBoolean(8));
        model.setMoTa(rs.getString(9));
        model.setMaNV(rs.getString(10));
        model.setHinh(rs.getString(11));
        return model;
    }

    public List<KhachHangModel> TimKiemTheoMa(String MaKH) {
        String sql = "SELECT * FROM KHACHHANG WHERE MaKH LIKE ?";
        return select(sql, "%" + MaKH + "%");
    }
}

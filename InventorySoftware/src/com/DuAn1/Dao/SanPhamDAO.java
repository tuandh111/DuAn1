/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.SanPhamModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class SanPhamDAO {

    public void insert(SanPhamModel model) {
        String sql = "Insert into SANPHAM values (?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getMau(),
                model.getGia(),
                model.getLoaiSP(),
                model.getNgayNhap(),
                model.getNoiNhap(),
                model.getSoLuong(),
                model.isTrangThai(),
                model.getHinh(),
                model.getMaNV(),
                model.getMaGiamGia()
        );
    }

    public void update(SanPhamModel model) {
        String sql = "Update SANPHAM set TenSP=?,MAU=?,Gia=?,LoaiSP=?,NgayNhap=?,NoiNhap=?,SoLuong=?,TrangThai=?,Hinh=?,MaNV=?,MaGiamGia=? where MaSP=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenSP(),
                model.getMau(),
                model.getGia(),
                model.getLoaiSP(),
                model.getNgayNhap(),
                model.getNoiNhap(),
                model.getSoLuong(),
                model.isTrangThai(),
                model.getHinh(),
                model.getMaNV(),
                model.getMaGiamGia(),
                model.getMaSP()
        );
    }
   public void updateSL(SanPhamModel model) {
        String sql = "Update SANPHAM set SoLuong=? where MaSP=?";
        JdbcHelper.executeUpdate(sql,
                model.getSoLuong(),
                model.getMaSP()
        );
    }
    public void delete(SanPhamModel model) {
        String sql = "Update SANPHAM set TrangThai=0 where MaSP=?";
        JdbcHelper.executeUpdate(sql, model.getMaSP());
    }

    public List<SanPhamModel> select() {
        String sql = "SELECT * FROM SANPHAM where TrangThai=1";
        return select(sql);
    }

    public List<SanPhamModel> selectDaXoa() {
        String sql = "SELECT * FROM SANPHAM where TrangThai=0";
        return select(sql);
    }

    public List<SanPhamModel> selectDaXoaTheoMa(String Ma) {
        String sql = "SELECT * FROM sanpham WHERE TrangThai =0 and MaSP like ?";
        return select(sql, "%" + Ma + "%");
    }

    public void khoiphuc(String model) {
        String sql = "update sanpham set TrangThai=1 where MaSP like ?";
        JdbcHelper.executeUpdate(sql, model);
    }

    public List<SanPhamModel> TimKiemTheoTen(String TenSP) {
        String sql = "SELECT * FROM SANPHAM where TenSP like ? and TrangThai=1";
        return select(sql, "%" + TenSP + "%");
    }
 public List<SanPhamModel> TimKiemTheoMa(String TenSP) {
        String sql = "SELECT * FROM SANPHAM where MaSP like ? and TrangThai=1";
        return select(sql, "%" + TenSP + "%");
    }
    public List<SanPhamModel> selectSoLuong() {
        String sql = "SELECT * FROM SANPHAM";
        return select(sql);
    }

    public SanPhamModel findById(String makh) {
        String sql = "SELECT * FROM SANPHAM WHERE MaSP=?";
        List<SanPhamModel> list1 = select(sql, makh);
        return list1.size() > 0 ? list1.get(0) : null;
    }

    private List<SanPhamModel> select(String sql, Object... args) {
        List<SanPhamModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPhamModel model = readFromResultSet(rs);
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

    private SanPhamModel readFromResultSet(ResultSet rs) throws SQLException {
        SanPhamModel model = new SanPhamModel();
        model.setMaSP(rs.getString("MaSP"));
        model.setTenSP(rs.getString("TenSP"));
        model.setMau(rs.getString("MAU"));
        model.setGia(rs.getDouble("Gia"));
        model.setLoaiSP(rs.getString("LoaiSP"));
        model.setNgayNhap(rs.getString("NgayNhap"));
        model.setNoiNhap(rs.getString("NoiNhap"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setHinh(rs.getString("Hinh"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaGiamGia(rs.getString("MaGiamGia"));
        return model;
    }

    public List<Object[]> getSoLuongSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_thongKeTongSoLuongSanPhamXoa}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("TongSoLuong")};

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

    public List<SanPhamModel> orderByMaTang() {
        String sql = "select * from sanpham order by MaSP";
        return this.select(sql);
    }

    public List<SanPhamModel> orderByMaGiam() {
        String sql = "select * from sanpham order by MaSP desc";
        return this.select(sql);
    }

    public List<SanPhamModel> orderByGiaTang() {
        String sql = "select * from sanpham order by Gia";
        return this.select(sql);
    }

    public List<SanPhamModel> orderByGiaGiam() {
        String sql = "select * from sanpham order by Gia desc";
        return this.select(sql);
    }

    public List<SanPhamModel> orderBySoLuongTang() {
        String sql = "select * from sanpham order by SoLuong";
        return this.select(sql);
    }

    public List<SanPhamModel> orderBySoLuongGiam() {
        String sql = "select * from sanpham order by SoLuong desc";
        return this.select(sql);
    }

}

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
        String sql = "Insert into LUONG values (?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaLuong(),
                model.getSoNgayLam(),
                model.getLuongCoBan(),
                model.getNgayVaoCTy(),
                model.getSoGioTangCa(),
                model.getLuongTangCa(),
                model.getKhoanTru(),
                model.getTongTien(),
                model.isTrangThai(),
                model.getLiDo()
                );
    }

    public void update(ThanhToanLuongModel model) {
        String sql = "Update LUONG set SoNgayLam = ?,LuongCoBan=?,SOGIOTANGCA =?,LUONGTANGCA =?,KHOANGTRU=?,TONGTIEN=?,TRANGTHAI=? where MALUONG=? and NGAYVAOCTY=?";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql,
                model.getSoNgayLam(),
                model.getLuongCoBan(),
                model.getSoGioTangCa(),
                model.getLuongTangCa(),
                model.getKhoanTru(),
                model.getTongTien(),
                model.isTrangThai(),
                model.getMaLuong(),
                model.getNgayVaoCTy()
        );
    }
  public void updateKhieuNay(ThanhToanLuongModel model) {
        String sql = "Update LUONG set TRANGTHAI= 0 , Lido=? where MALUONG=? and NGAYVAOCTY=?";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql,
                model.getLiDo(),
                model.getMaLuong(),
                model.getNgayVaoCTy()
        );
    }
    public void delete(String maLuong,String Ngay) {
        String sql = "DELETE FROM LUONG WHERE MaLuong=? and NGAYVAOCTY= ?";
        JdbcHelper.executeUpdate(sql, maLuong,Ngay);
    }

    public List<ThanhToanLuongModel> select1(int Thang, int Nam) {
        String sql = "select * from Luong where MONTH(NgayVaoCTY)= ? and YEAR(NgayVaoCTY)= ?";
        return select(sql, Thang, Nam);
    }

    public ThanhToanLuongModel findById(String maLuong,String NgayVaoCTY) {
        String sql = "SELECT * FROM LUONG WHERE MaLuong like ? and NgayVaoCTY =?";
        List<ThanhToanLuongModel> list = select(sql,"%" +maLuong+"%",NgayVaoCTY);
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

    public List<ThanhToanLuongModel> XemThanhToanLuongCaNhan(int thang, int nam, String MaNV) {
        String sql = "SELECT * from LUONG\n"
                + "WHERE MONTH(NgayVaoCTY) = ? and Year(NgayVaoCTY) = ? and MaLuong=?";
        return select(sql, thang, nam, MaNV);
    }

    private ThanhToanLuongModel readFromResultSet(ResultSet rs) throws SQLException {
        ThanhToanLuongModel model = new ThanhToanLuongModel();
        model.setMaLuong(rs.getString("MaLuong"));
        model.setSoNgayLam(rs.getFloat("SoNgayLam"));
        model.setLuongCoBan(rs.getDouble("LuongCoBan"));
        model.setNgayVaoCTy(rs.getString("NgayVaoCTy"));
        model.setSoGioTangCa(rs.getFloat("SoGioTangCa"));
        model.setLuongTangCa(rs.getDouble("LuongTangCa"));
        model.setKhoanTru(rs.getDouble("KhoangTru"));
        model.setTongTien(rs.getDouble("TongTien"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setLiDo(rs.getString("Lido"));
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.BoNhoModel;
import com.DuAn1.Model.CPUModel;
import com.DuAn1.Model.CameraModel;
import com.DuAn1.Model.MangHinhModel;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.PinModel;
import com.DuAn1.Model.RamModel;
import com.DuAn1.Model.ThanhToanLuongModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class DongMayDAO {

//    public void insert(DongMayModel model) {
//        String sql = "insert into DONGMAY values (?,?,?,?,?,?,?,?,?)";
//        JdbcHelper.executeUpdate(sql,
//                model.getMaDong(),
//                model.getLoaiSP(),
//                model.getCPU(),
//                model.getManHinh(),
//                model.getBoNho(),
//                model.getMoTa(),
//                model.getMaSP(),
//                model.getCamera(),
//                model.getPin(),
//                model.getRAM());
//    }
//
//    public void update(DongMayModel model) {
//        String sql = "update DONGMAY set LoaiSanPham=?,CPU=?,MangHinh=?,BoNho=?,MoTa=?,MaSP=?,CAMERA=?,Pin=?,RAM=? where MaDong=?";
//        JdbcHelper.executeUpdate(sql,
//                model.getLoaiSP(),
//                model.getCPU(),
//                model.getManHinh(),
//                model.getBoNho(),
//                model.getMoTa(),
//                model.getMaSP(),
//                model.getCamera(),
//                model.getPin(),
//                model.getRAM(),
//                model.getMaDong());
//    }
    public List<CPUModel> selectCPU(String loai) {
        String sql = "SELECT * FROM CPU where loaiSP like ?";
        return selectCPU(sql, "%" + loai + "%");
    }

    public List<MangHinhModel> selectMangHinh(String loai) {
        String sql = "SELECT * FROM MangHinh where loaiSP like ?";
        return selectMangHinh(sql, "%" + loai + "%");
    }

    public List<RamModel> selectRam(String loai) {
        String sql = "SELECT * FROM RAM where loaiSP like ?";
        return selectRam(sql, "%" + loai + "%");
    }

    public List<BoNhoModel> selectBoNho(String loai) {
        String sql = "SELECT * FROM BoNho where loaiSP like ?";
        return selectBoNho(sql, "%" + loai + "%");
    }

    public List<CameraModel> selectCamera(String loai) {
        String sql = "SELECT * FROM Camera where loaiSP like ?";
        return selectCamera(sql, "%" + loai + "%");
    }

    public List<PinModel> selectPin(String loai) {
        String sql = "SELECT * FROM Pin where loaiSP like ?";
        return selectPin(sql, "%" + loai + "%");
    }

    private List<CPUModel> selectCPU(String sql, Object... args) {
        List<CPUModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CPUModel model = readFromResultSetCPU(rs);
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

    private List<MangHinhModel> selectMangHinh(String sql, Object... args) {
        List<MangHinhModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    MangHinhModel model = readFromResultSetMangHinh(rs);
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

    private List<RamModel> selectRam(String sql, Object... args) {
        List<RamModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    RamModel model = readFromResultSetRam(rs);
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

    private List<BoNhoModel> selectBoNho(String sql, Object... args) {
        List<BoNhoModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BoNhoModel model = readFromResultSetBoNho(rs);
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

    private List<CameraModel> selectCamera(String sql, Object... args) {
        List<CameraModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CameraModel model = readFromResultSetCamera(rs);
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

    private List<PinModel> selectPin(String sql, Object... args) {
        List<PinModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PinModel model = readFromResultSetPin(rs);
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

    private CPUModel readFromResultSetCPU(ResultSet rs) throws SQLException {
        CPUModel model = new CPUModel();
        model.setMaCPU(rs.getString("maCPU"));
        model.setLoaiSanPham(rs.getString("loaiSP"));
        return model;
    }

    private MangHinhModel readFromResultSetMangHinh(ResultSet rs) throws SQLException {
        MangHinhModel model = new MangHinhModel();
        model.setMaMangHinh(rs.getString("maMangHinh"));
        model.setLoaiSp(rs.getString("loaiSP"));
        return model;
    }

    private RamModel readFromResultSetRam(ResultSet rs) throws SQLException {
        RamModel model = new RamModel();
        model.setMaRam(rs.getString("maRAM"));
        model.setLoaiSP(rs.getString("loaiSP"));
        return model;
    }

    private BoNhoModel readFromResultSetBoNho(ResultSet rs) throws SQLException {
        BoNhoModel model = new BoNhoModel();
        model.setMaBoNho(rs.getString("maBoNho"));
        model.setLoaiSP(rs.getString("loaiSP"));
        return model;
    }

    private CameraModel readFromResultSetCamera(ResultSet rs) throws SQLException {
        CameraModel model = new CameraModel();
        model.setMaCamera(rs.getString("maCamera"));
        model.setLoaiSP(rs.getString("loaiSP"));
        return model;
    }

    private PinModel readFromResultSetPin(ResultSet rs) throws SQLException {
        PinModel model = new PinModel();
        model.setMaPin(rs.getString("maCPU"));
        model.setLoaiSP(rs.getString("loaiSP"));
        return model;
    }

//    public DongMayModel findById(String maDong) {
//        String sql = "SELECT * FROM DONGMAY WHERE MaDong=?";
//        List<DongMayModel> list = select(sql, maDong);
//        return list.size() > 0 ? list.get(0) : null;
//    }
//
//    public List<DongMayModel> orderByName() {
//        String sql = "SELECT * FROM DONGMAY order by LoaiSanPham";
//        return select(sql);
//    }
//
//    public List<DongMayModel> orderById() {
//        String sql = "SELECT * FROM DONGMAY order by LoaiSanPham desc";
//        return select(sql);
//    }
}

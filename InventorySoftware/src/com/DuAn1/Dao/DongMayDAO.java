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
    // CPU
    public void insertCPU(CPUModel cpumodel){
        String sql="insert into CPU values (?,?) ";
        JdbcHelper.executeUpdate(sql, cpumodel.getMaCPU(),cpumodel.getLoaiSanPham());
    }
    public void updateCPU(CPUModel cpumodel){
        String sql="update CPU set loaiSP = ? where maCPU=? ";
        JdbcHelper.executeUpdate(sql, cpumodel.getLoaiSanPham(),cpumodel.getMaCPU());
    }
    public void deleteCPU(CPUModel maCPU){
        String sql = "delete from CPU where maCPU=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaCPU());
    }
    //RAM
    public void insertRAM(RamModel rammodel){
        String sql="insert into RAM values (?,?) ";
        JdbcHelper.executeUpdate(sql, rammodel.getMaRam(),rammodel.getLoaiSP());
    }
    public void updateRAM(RamModel rammodel){
        String sql="update RAM set loaiSP = ? where maRAM=? ";
        JdbcHelper.executeUpdate(sql, rammodel.getLoaiSP(),rammodel.getMaRam());
    }
    public void deleteRAM(RamModel maCPU){
        String sql = "delete from Ram where maRAM=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaRam());
    }
    //ROM
    public void insertROM(BoNhoModel rommodel){
        String sql="insert into BoNho values (?,?) ";
        JdbcHelper.executeUpdate(sql, rommodel.getMaBoNho(),rommodel.getLoaiSP());
    }
    public void updateROM(BoNhoModel rommodel){
        String sql="update BoNho set loaiSP = ? where maBoNho=? ";
        JdbcHelper.executeUpdate(sql, rommodel.getLoaiSP(),rommodel.getMaBoNho());
    }
    public void deleteROM(BoNhoModel maCPU){
        String sql = "delete from BoNho where maBoNho=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaBoNho());
    }
    //Camera
    public void insertCamera(CameraModel cammodel){
        String sql ="insert into Camera values(?,?)";
        JdbcHelper.executeUpdate(sql, cammodel.getMaCamera(),cammodel.getLoaiSP());
    }
    public void updateCamera(CameraModel cammodel){
        String sql = "update Camera set loaiSP=? where maCamera=?";
        JdbcHelper.executeUpdate(sql,cammodel.getLoaiSP(),cammodel.getMaCamera());
    }
    public void deleteCamera(CameraModel maCPU){
        String sql = "delete from Camera where maCamera=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaCamera());
    }
    //Màn hình
    public void insertManHinh(MangHinhModel cammodel){
        String sql ="insert into ManHinh values(?,?)";
        JdbcHelper.executeUpdate(sql, cammodel.getMaMangHinh(),cammodel.getLoaiSp());
    }
    public void updateManHinh(MangHinhModel cammodel){
        String sql ="update ManHinh set loaiSP=? where maManHinh=?";
        JdbcHelper.executeUpdate(sql, cammodel.getLoaiSp(),cammodel.getMaMangHinh());
    }
    public void deleteManHinh(MangHinhModel maCPU){
        String sql = "delete from ManHinh where maManHinh=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaMangHinh());
    }
    //Pin
     public void insertPin(PinModel cammodel){
        String sql ="insert into Pin values(?,?)";
        JdbcHelper.executeUpdate(sql, cammodel.getMaPin(),cammodel.getLoaiSP());
    }
     public void updatePin(PinModel cammodel){
        String sql ="update Pin set loaiSP=? where maPin=?";
        JdbcHelper.executeUpdate(sql, cammodel.getLoaiSP(),cammodel.getMaPin());
    }
     public void deletePin(PinModel maCPU){
        String sql = "delete from Pin where maPin=?";
        JdbcHelper.executeUpdate(sql, maCPU.getMaPin());
    }
     
     private List<CPUModel> selectallCPU(String sql, Object... args) {
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
     private List<MangHinhModel> selectallMangHinh(String sql, Object... args) {
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
     private List<RamModel> selectallRam(String sql, Object... args) {
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
     private List<BoNhoModel> selectallBoNho(String sql, Object... args) {
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

    private List<CameraModel> selectallCamera(String sql, Object... args) {
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

    private List<PinModel> selectallPin(String sql, Object... args) {
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
    public List<CPUModel> selectallCPU() {
        String sql = "SELECT * FROM CPU";
        return selectallCPU(sql);
    }
    
    public List<RamModel> selectallRAM() {
        String sql = "SELECT * FROM RAM";
        return selectallRam(sql);
    }
    public List<BoNhoModel> selectallROM() {
        String sql = "SELECT * FROM BoNho ";
        return selectallBoNho(sql);
    }
    public List<MangHinhModel> selectallManHinh() {
        String sql = "SELECT * FROM ManHinh ";
        return selectallMangHinh(sql);
    }
    public List<CameraModel> selectallCamera() {
        String sql = "SELECT * FROM Camera ";
        return selectallCamera(sql);
    }
    public List<PinModel> selectallPin() {
        String sql = "SELECT * FROM Pin ";
        return selectallPin(sql);
    }
    //
    public List<CPUModel> selectCPU(String loai) {
        String sql = "SELECT * FROM CPU where loaiSP like ?";
        return selectCPU(sql, "%" + loai + "%");
    }

    public List<MangHinhModel> selectMangHinh(String loai) {
        String sql = "SELECT * FROM ManHinh where loaiSP like ?";
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
        model.setMaMangHinh(rs.getString("maManHinh"));
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
        model.setMaPin(rs.getString("maPin"));
        model.setLoaiSP(rs.getString("loaiSP"));
        return model;
    }

    public CPUModel findByIdCPU(String maDong) {
        String sql = "SELECT * FROM CPU WHERE MaCPU=?";
        List<CPUModel> list = selectCPU(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public RamModel findByIdRAM(String maDong) {
        String sql = "SELECT * FROM RAM WHERE MaRAM=?";
        List<RamModel> list = selectRam(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public BoNhoModel findByIdROM(String maDong) {
        String sql = "SELECT * FROM BoNho WHERE MaBoNho=?";
        List<BoNhoModel> list = selectBoNho(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public MangHinhModel findByIdManHinh(String maDong) {
        String sql = "SELECT * FROM ManHinh WHERE MaManHinh=?";
        List<MangHinhModel> list = selectMangHinh(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public CameraModel findByIdCamera(String maDong) {
        String sql = "SELECT * FROM Camera WHERE MaCamera=?";
        List<CameraModel> list = selectCamera(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public PinModel findByIdPin(String maDong) {
        String sql = "SELECT * FROM Pin WHERE MaPin=?";
        List<PinModel> list = selectPin(sql, maDong);
        return list.size() > 0 ? list.get(0) : null;
    }
    
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuandhpc05076.Dao;

import com.tuandhpc05076.Helper.JdbcHelper;
import com.tuandhpc05076.Model.ThaoTacModel;
import java.sql.SQLException;

/**
 *
 * @author DELL E5470
 */
public class ThaoTacDAO {
        public void insert(ThaoTacModel model) throws SQLException {
        String sql = "Insert into LICHSU (ThoiGianThem,ThoiGianSua, ThoiGianXoa,ThoiGianHoatDong,BangThaoTac,MaNV)values (?,?,?,?,?,?)";
      JdbcHelper.executeUpdate(sql,
                 model.getThoiGianThem(),
                model.getThoiGianSua(),
                model.getThoiGianXoa(),
                model.getThoIGianHoatDong(),
                model.getBanThaoTac(),
                model.getMaNV()
                
        );
    }
}

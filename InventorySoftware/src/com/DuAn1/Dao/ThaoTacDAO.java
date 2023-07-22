/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.ThaoTacModel;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class ThongKeDao {
     public List<Object[]> getSoLuongSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call maxMaSP}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),
                    };

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
}

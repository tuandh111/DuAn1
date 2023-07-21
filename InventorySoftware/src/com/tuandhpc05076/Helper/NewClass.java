/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuandhpc05076.Helper;

import com.tuandhpc05076.Dao.NhanVienDAO;
import com.tuandhpc05076.Model.NhanVienModel;
import java.util.ArrayList;

/**
 *
 * @author DELL E5470
 */
public class NewClass {
    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();
        ArrayList<NhanVienModel> nv = (ArrayList<NhanVienModel>) dao.select();
        System.out.println(nv.get(0));
      
    }
    
}

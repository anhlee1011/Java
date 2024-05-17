/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BACH
 */
public class NhanVienDAO {
    List<NhanVien> ls = new ArrayList<>();
    public int add(NhanVien nv){
        ls.add(nv);
        return 1;
    }
    public List<NhanVien> getALLNhanVien(){
            return ls;
    }
}

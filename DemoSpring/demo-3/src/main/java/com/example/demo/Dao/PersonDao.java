package com.example.demo.Dao;

import com.example.demo.model.Admin;
import com.example.demo.model.Ban;
import com.example.demo.model.NhanVien;

import java.util.List;

public interface PersonDao {
    Admin showAdmin(String userName);
    int insertAdmin(Admin admin);
    int updateAdmin(Admin admin);

    int insertThuKho(NhanVien nhanVien);
    int updateThuKho(NhanVien nhanVien);
    int updateThuKho1(NhanVien nhanVien);
    int deleteThuKho(String idNV);
    NhanVien showThuKho(String userName);
    Ban showBan(String userName);
    NhanVien showThuKho1(String userName);
    List<NhanVien> showListThuKho();
    List<Ban> ShowBan();
    int InsertBan(Ban b);
    int UpdateBan(Ban b);
    NhanVien check_id(String id);
}

package com.example.demo.service;

import com.example.demo.model.Admin;

import com.example.demo.model.Ban;
import com.example.demo.model.NhanVien;

import java.util.List;

public interface PersonService {
    Admin showAdmin(String userName);
    int insertAdmin(Admin admin);
    int updateAdmin(Admin admin);

    int insertThuKho(NhanVien nhanVien);
    int updateThuKho(NhanVien nhanVien);
    int updateThuKho1(NhanVien nhanVien);
    int deleteThuKho(String idNV);
    NhanVien showThuKho(String userName);
    Ban showBan(String userName);
    NhanVien showThuKho1(String id);
    List<NhanVien> showListThuKho();
    NhanVien check_id(String id);
    List<Ban> ShowBan();
    int InsertBan(Ban ban);
    int UpdateBan(Ban ban);
}

package com.example.demo.model.mapper;

import com.example.demo.model.Accounts;


import com.example.demo.model.NhanVien;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanVienMapper implements RowMapper<NhanVien> {
    @Override
    public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
        NhanVien ad = new NhanVien();
        ad.setID(rs.getString("MaTK"));
        ad.setTen(rs.getString("TenTK"));
        ad.setGioiTinh(rs.getBoolean("GioiTinh"));
        ad.setNgaySinh(rs.getDate("NgaySinh"));
        ad.setSoDT(rs.getString("SDT"));
        
        ad.setCCCD(rs.getString("CCCD"));
        ad.setNgayBatDauLam(rs.getDate("NgayBatDau"));
        ad.setLuong(rs.getDouble("Luong"));
        ad.setSoTienTrenGio(rs.getDouble("SoTienTrenGio"));
        ad.setTaiKhoan(new Accounts(rs.getString("UserName")));
        
        
        
        return ad;
    }
}

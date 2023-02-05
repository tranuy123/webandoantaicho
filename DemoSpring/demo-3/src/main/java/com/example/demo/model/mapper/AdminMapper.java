package com.example.demo.model.mapper;

import com.example.demo.model.Accounts;


import com.example.demo.model.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin ad = new Admin();
        ad.setID(rs.getString("MaQL"));
        ad.setGioiTinh(rs.getBoolean("GioiTinh"));
        ad.setTen(rs.getString("TenQL"));
        ad.setSoDT(rs.getString("SDT"));
        ad.setNgaySinh(rs.getDate("NgaySinh"));
        ad.setCCCD(rs.getString("CCCD"));
        ad.setTaiKhoan(new Accounts(rs.getString("UserName")));
        return ad;
    }
}

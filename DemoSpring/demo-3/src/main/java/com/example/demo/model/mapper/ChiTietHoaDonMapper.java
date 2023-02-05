package com.example.demo.model.mapper;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.Menu;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietHoaDonMapper implements RowMapper<ChiTietHoaDon> {
    @Override
    public ChiTietHoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
    	ChiTietHoaDon c = new ChiTietHoaDon();
        c.setDonGia(rs.getDouble("DonGia"));
        c.setMenu(new Menu(rs.getString("IDF")));
        c.setSoLuong(rs.getInt("SoLuong"));
        c.setThanhTien(rs.getDouble("ThanhTien"));
        return c;
    }
}

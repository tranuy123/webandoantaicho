package com.example.demo.model.mapper;

import com.example.demo.model.HoaDon;
import com.example.demo.model.Accounts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoaDonMapper implements RowMapper<HoaDon> {
    @Override
    public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
        HoaDon h = new HoaDon();
        h.setMaHD(rs.getString("MaHD"));
        h.setNgayXuatHD(rs.getDate("NgayXuatHD"));
        h.setSoLoaiFood(rs.getInt("SoLoaiFood"));
        h.setTongTien(rs.getDouble("TongTien"));
        h.setTrangThai(rs.getBoolean("TrangThai"));
        h.setAccounts(new Accounts(rs.getString("UserName")));
        return h;
    }
}

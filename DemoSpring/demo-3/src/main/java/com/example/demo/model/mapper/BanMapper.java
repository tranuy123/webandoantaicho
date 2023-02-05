package com.example.demo.model.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Accounts;
import com.example.demo.model.Ban;
import com.example.demo.model.NhanVien;


public class BanMapper implements RowMapper<Ban>{
	@Override
    public Ban mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ban b = new Ban();
		b.setMaBan(rs.getString("MaBan"));
		b.setTenBan(rs.getString("TenBan"));
		b.setTaiKhoan(new Accounts(rs.getString("UserName")));
        b.setTrangThai(rs.getBoolean("TrangThai"));
        b.setTrangThaiYC(rs.getBoolean("TrangThaiYC"));

		return b ;
	}
}

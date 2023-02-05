package com.example.demo.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Menu;

public class MenuMapper implements RowMapper<Menu>{
	@Override
	 public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu ad = new Menu();
        ad.setIDF(rs.getString("IDF"));
        ad.setTenF(rs.getString("TenF"));
        ad.setImage(rs.getBlob("image"));
        ad.setPrice(rs.getDouble("price"));
        ad.setIDloaiF(rs.getString("IDloaiF"));
        ad.setTrangThai(rs.getBoolean("trangthai"));
               
        return ad;
	}

}

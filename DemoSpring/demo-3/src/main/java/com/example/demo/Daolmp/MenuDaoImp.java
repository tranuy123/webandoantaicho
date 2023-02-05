package com.example.demo.Daolmp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.demo.model.mapper.*;

import com.example.demo.model.*;

import com.example.demo.Dao.MenuDao;

@Repository
public class MenuDaoImp implements MenuDao{
	@Autowired
	JdbcTemplate JdbcTemplate ; 
	@Override
	public List<Menu> ShowMenu(){
		String query = "select * from menu";
		 return JdbcTemplate.query(query,new MenuMapper());
	}
	@Override
	public Menu ShowDetail(String IDF) {
		String query = "select * from menu where idf = '"+IDF+"'";
		if(JdbcTemplate.query(query,new MenuMapper()).size()==0)
	        return null;
	        else return JdbcTemplate.query(query,new MenuMapper()).get(0);
	}	
	@Override
	public int Insert(Menu m) throws IOException  {
		String query = "insert into menu(`idf`,`tenf`,`image`,`price`,`idloaif`)"
				+ "values(?,?,?,?,?)";
		int kq= JdbcTemplate.update(query,new Object[] {m.getIDF(),m.getTenF(),m.getHinhAnhbit().getBytes(),m.getPrice(),m.getIDloaiF()});
		return kq ;
	}
	@Override
	public int Update (Menu m ) throws IOException{
		int kq;
        if(!m.getHinhAnhbit().isEmpty()) {
            String querym = "update menu set tenf = ?, image =?, price =?, idloaif=?,trangthai=? where idf=?;";
            kq = JdbcTemplate.update(querym, new Object[]{m.getTenF(), m.getHinhAnhbit().getBytes(), m.getPrice(), m.getIDloaiF(), m.isTrangThai(),
                     m.getIDF()});
        }
        else {
            String querym = "update menu set tenf = ?, price =?, idloaif=?,trangthai=? where idf=?;";
            kq = JdbcTemplate.update(querym, new Object[]{m.getTenF(), m.getPrice(), m.getIDloaiF(), m.isTrangThai(),
                    m.getIDF()});
        }
        return kq;

	}
	@Override
	public int Delete (String idf) {
		 String query= "delete from menu where idf='"+idf+"'";

	      int kq;
	        kq = JdbcTemplate.update(query);
	        return kq;
	        
	}
}

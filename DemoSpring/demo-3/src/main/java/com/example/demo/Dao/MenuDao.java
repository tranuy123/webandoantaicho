package com.example.demo.Dao;
import java.io.IOException;
import java.util.List
;

import com.example.demo.model.*;
public interface MenuDao {
	List<Menu> ShowMenu();
	Menu ShowDetail(String IDF);
	int Insert(Menu m ) throws IOException ;
	int Update(Menu m ) throws IOException;
	int Delete(String id);
}

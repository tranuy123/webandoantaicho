package com.example.demo.servicelmp;
import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Dao.*;
import com.example.demo.model.Menu;
import com.example.demo.service.*;

@Service
public class MenuServiceImp implements MenuService{
@Autowired
 MenuDao  MenuDao;
	@Override
	public List<Menu> ShowMenu(){
		return MenuDao.ShowMenu();
	}
	@Override
	public Menu ShowDetail(String IDF) {
		return MenuDao.ShowDetail(IDF);
	}
	@Override
	public int Insert(Menu m) throws IOException  {
		return MenuDao.Insert(m);
	}
	@Override
	public int Update(Menu m ) throws IOException{
		return MenuDao.Update(m);
	}
	@Override
	public int Delete(String id) {
		return MenuDao.Delete(id);
	}
}

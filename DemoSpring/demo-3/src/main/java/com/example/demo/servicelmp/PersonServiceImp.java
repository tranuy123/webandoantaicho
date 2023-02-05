package com.example.demo.servicelmp;

import com.example.demo.Dao.PersonDao;

import com.example.demo.model.Admin;
import com.example.demo.model.Ban;
import com.example.demo.model.NhanVien;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {
    @Autowired
    PersonDao personDao;
    @Override
    public Admin showAdmin(String userName) {
        return personDao.showAdmin(userName);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return personDao.updateAdmin(admin);
    }

    @Override
    public int insertThuKho(NhanVien thukho) {
    	return personDao.insertThuKho(thukho);
    }

    @Override
    public int updateThuKho(NhanVien nhanVien) {
        return personDao.updateThuKho(nhanVien);
    }
    @Override
    public int updateThuKho1(NhanVien nhanVien) {
        return personDao.updateThuKho1(nhanVien);
    }

    @Override
    public int deleteThuKho(String idNV) {
    	 return personDao.deleteThuKho(idNV);
    }

    @Override
    public NhanVien showThuKho(String userName) {
        return personDao.showThuKho(userName);
    }
    @Override
    public Ban showBan(String userName) {
        return personDao.showBan(userName);
    }
    @Override
    public NhanVien showThuKho1(String id) {
        return personDao.showThuKho1(id);
    }
    @Override
    public List<NhanVien> showListThuKho() {
        return personDao.showListThuKho() ;
    }
    @Override
    public List<Ban> ShowBan() {
        return personDao.ShowBan() ;
    }
    @Override
    public NhanVien check_id(String id) {
        return personDao.check_id(id);
    }
    @Override
    public int InsertBan(Ban b) {
    	return personDao.InsertBan(b);
    }
    @Override
    public int UpdateBan(Ban b) {
    	return personDao.UpdateBan(b);
    }
    
}

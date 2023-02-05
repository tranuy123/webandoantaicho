package com.example.demo.Daolmp;

import com.example.demo.Dao.AccountDao;

import com.example.demo.model.mapper.AccountMapper;
import com.example.demo.model.mapper.MenuMapper;
import com.example.demo.model.Accounts;
import com.example.demo.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountImp implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Boolean CheckAccount(Accounts accounts) {
        return null;
    }

    @Override
    public Accounts CheckUserName(String userName) {
        String query = "select*from account where UserName ='"+userName+"'";
        List<Accounts> list = jdbcTemplate.query(query,new AccountMapper());
        if(list.size()==0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int insertAccount(Accounts accounts) {
        return 0;
    }

    @Override
    public int updateAccount(Accounts accounts) {
        String query = "update account set password =? where UserName = ?";
        return jdbcTemplate.update(query, new Object[]{accounts.getPassword(),accounts.getUserName()});
    }

    @Override
    public int XoaAccount(String userName) {
        return 0;
    }
    @Override
	public Accounts ShowDetail(String user) {
		String query = "select * from account where username = '"+user+"'";
		if(jdbcTemplate.query(query,new AccountMapper()).size()==0)
	        return null;
	        else return jdbcTemplate.query(query,new AccountMapper()).get(0);
	}
}

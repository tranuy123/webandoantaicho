package com.example.demo.servicelmp;

import com.example.demo.Dao.AccountDao

;
import com.example.demo.model.Accounts;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoginServiceImp implements LoginService, UserDetailsService {

    @Autowired
    AccountDao accountDao;

    @Override
    public Boolean CheckAccount(Accounts accounts) {
        return accountDao.CheckAccount(accounts);
    }
    @Override
    public Accounts ShowDetail(String user) {
    	return accountDao.ShowDetail(user);
    }

    @Override
    public Accounts CheckUserName(String userName) {
        return accountDao.CheckUserName(userName);
    }

    @Override
    public int insertAccount(Accounts accounts) {
        return accountDao.insertAccount(accounts);
    }

    @Override
    public int updateAccount(Accounts accounts) {
        return accountDao.updateAccount(accounts);
    }

    @Override
    public int XoaAccount(String userName) {
        return accountDao.XoaAccount(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts accounts = accountDao.CheckUserName(username);

        if(accounts==null){
            new UsernameNotFoundException("Loign fail!");
        }
        else {
            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            UserDetails user = User
                    .withUsername(accounts.getUserName())
                    .password(accounts.getPassword())
                    .roles(accounts.getRole().getMaRL())
                    .build();
            return user;
        }
        return null;
    }
}

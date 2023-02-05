package com.example.demo.Dao;

import com.example.demo.model.Accounts;

public interface AccountDao {
    Boolean CheckAccount(Accounts accounts);

    Accounts CheckUserName(String userName);

    int insertAccount(Accounts accounts);

    int updateAccount(Accounts accounts);

    int XoaAccount(String userName);
    Accounts ShowDetail(String user);
}

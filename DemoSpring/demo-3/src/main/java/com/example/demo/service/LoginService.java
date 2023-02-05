package com.example.demo.service;

import com.example.demo.model.Accounts;

public interface LoginService {
    Boolean CheckAccount(Accounts accounts);

    Accounts CheckUserName(String userName);

    int insertAccount(Accounts accounts);

    int updateAccount(Accounts accounts);

    int XoaAccount(String userName);
    Accounts ShowDetail(String user);
}

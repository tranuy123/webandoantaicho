package com.example.demo.model;

public class Accounts {
private String userName;
private String passWord;
private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Accounts(String userName) {
        this.userName = userName;
    }
    public Accounts() {

    }
    public Accounts(String userName, String passWord, Role role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }
}

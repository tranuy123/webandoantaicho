package com.example.demo.model;

public class Role {
    private String MaRL;
    private String TenRL;

    public String getMaRL() {
        return MaRL;
    }

    public void setMaRL(String maRL) {
        MaRL = maRL;
    }

    public String getTenRL() {
        return TenRL;
    }

    public void setTenRL(String tenRL) {
        TenRL = tenRL;
    }

    public Role(String maRL) {
        MaRL = maRL;
    }
    public Role() {
    }
}

package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Admin {
    private String ID;
    private String Ten;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String soDT;
    private String CCCD;
    private Accounts taiKhoan;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Accounts getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(Accounts taiKhoan) {
        this.taiKhoan = taiKhoan;
    }


}

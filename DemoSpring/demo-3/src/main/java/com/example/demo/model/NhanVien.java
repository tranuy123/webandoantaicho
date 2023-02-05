package com.example.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NhanVien extends Admin{
    private Double soTienTrenGio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDauLam;
    private Double luong;

    public Double getSoTienTrenGio() {
        return soTienTrenGio;
    }

    public void setSoTienTrenGio(Double soTienTrenGio) {
        this.soTienTrenGio = soTienTrenGio;
    }

    public Date getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }
}

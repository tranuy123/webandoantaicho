package com.example.demo.model;

import java.util.Date;


import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class HoaDon {
	    private String MaHD;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date NgayXuatHD;
	    private int SoLoaiFood;
	    private Double TongTien;
	    private boolean TrangThai;
	    private Accounts accounts;
	    private String username ;
	    private List<ChiTietHoaDon> chitiethoadon;
		public HoaDon() {
			super();
			// TODO Auto-generated constructor stub
		}
		public HoaDon(String maHD, Date ngayXuatHD, int soLoaiFood, Double tongTien, boolean trangThai,
				Accounts accounts, List<ChiTietHoaDon> chitiethoadon) {
			super();
			MaHD = maHD;
			NgayXuatHD = ngayXuatHD;
			SoLoaiFood = soLoaiFood;
			TongTien = tongTien;
			TrangThai = trangThai;
			this.accounts = accounts;
			this.chitiethoadon = chitiethoadon;
		}
		public String getMaHD() {
			return MaHD;
		}
		public void setMaHD(String maHD) {
			MaHD = maHD;
		}
		public Date getNgayXuatHD() {
			return NgayXuatHD;
		}
		public void setNgayXuatHD(Date ngayXuatHD) {
			NgayXuatHD = ngayXuatHD;
		}
		public int getSoLoaiFood() {
			return SoLoaiFood;
		}
		public void setSoLoaiFood(int soLoaiFood) {
			SoLoaiFood = soLoaiFood;
		}
		public Double getTongTien() {
			return TongTien;
		}
		public void setTongTien(Double tongTien) {
			TongTien = tongTien;
		}
		public boolean isTrangThai() {
			return TrangThai;
		}
		public void setTrangThai(boolean trangThai) {
			TrangThai = trangThai;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Accounts getAccounts() {
			return accounts;
		}
		public void setAccounts(Accounts accounts) {
			this.accounts = accounts;
		}
		public List<ChiTietHoaDon> getChitiethoadon() {
			return chitiethoadon;
		}
		
		public void setChitiethoadon(List<ChiTietHoaDon> chitiethoadon) {
			this.chitiethoadon = chitiethoadon;
		}
	    
	    
}

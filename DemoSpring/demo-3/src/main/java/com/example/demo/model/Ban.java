package com.example.demo.model;

public class Ban extends Admin{
	private String MaBan ; 
	private String TenBan ;
	private boolean TrangThai;
	private boolean TrangThaiYC;

	public Ban() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Ban(String maBan, String tenBan, boolean trangThai, boolean trangThaiYC) {
		super();
		MaBan = maBan;
		TenBan = tenBan;
		TrangThai = trangThai;
		TrangThaiYC = trangThaiYC;
	}

	public String getMaBan() {
		return MaBan;
	}
	public void setMaBan(String maBan) {
		MaBan = maBan;
	}
	public String getTenBan() {
		return TenBan;
	}
	public void setTenBan(String tenBan) {
		TenBan = tenBan;
	}
	
	
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	
	public boolean isTrangThaiYC() {
		return TrangThaiYC;
	}

	public void setTrangThaiYC(boolean trangThaiYC) {
		TrangThaiYC = trangThaiYC;
	}

	@Override
	public String toString() {
		return "Ban [MaBan=" + MaBan + ", TenBan=" + TenBan + ", TrangThai=" + TrangThai + ", TrangThaiYC="
				+ TrangThaiYC + "]";
	}

	
	

}

package com.example.demo.model;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public class Menu {
	private String IDF;
	private String TenF;
	private Blob image ; 
	private double price ; 
	private String IDloaiF; 
	private boolean TrangThai ;
	private MultipartFile hinhAnhbit;

	   
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String iDF, String tenF, Blob image, double price, String iDloaiF, boolean trangThai) {
		super();
		IDF = iDF;
		TenF = tenF;
		this.image = image;
		this.price = price;
		IDloaiF = iDloaiF;
		TrangThai = trangThai;
	}
	public String getIDF() {
		return IDF;
	}
	public void setIDF(String iDF) {
		IDF = iDF;
	}
	public String getTenF() {
		return TenF;
	}
	public void setTenF(String tenF) {
		TenF = tenF;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIDloaiF() {
		return IDloaiF;
	}
	public void setIDloaiF(String iDloaiF) {
		IDloaiF = iDloaiF;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	public Menu(String IDF) {
        this.IDF = IDF;
    }
	public MultipartFile getHinhAnhbit() {
	        return hinhAnhbit;
	    }

	public void setHinhAnhbit(MultipartFile hinhAnhbit) {
	        this.hinhAnhbit = hinhAnhbit;
	    }
	@Override
	public String toString() {
		return "Menu [IDF=" + IDF + ", TenF=" + TenF + ", image=" + image + ", price=" + price + ", IDloaiF=" + IDloaiF
				+ ", TrangThai=" + TrangThai + "]";
	}
	
	
	
}

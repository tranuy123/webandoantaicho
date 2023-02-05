package com.example.demo.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.model.Menu;

public interface HoaDonService {
	int InsertHoaDon(HoaDon h)  ;	
	Menu ShowDetailF(String id);
	List<HoaDon> ShowList();
	List<HoaDon> ShowListHoaDon(String mahd);
	List<HoaDon> SearchHD(Date ngay);

	HoaDon ShowDetailHoaDon(String id);
	
	int InsertHoaDon1(HoaDon h);
	int UpdateHoaDon(HoaDon h);
}

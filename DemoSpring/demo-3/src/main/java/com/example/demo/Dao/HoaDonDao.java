package com.example.demo.Dao;

import java.util.Date;
import java.util.List;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.model.Menu;

public interface HoaDonDao {
	int InsertHoaDon(HoaDon h);
	int InsertHoaDon1(HoaDon h);
	int UpdateHoaDon(HoaDon h);
	Menu ShowDetailF(String id);
	List<HoaDon> ShowList();
	List<HoaDon> ShowListHoaDon(String id);
	List<HoaDon> SearchHD(Date ngay);
	HoaDon ShowDetailHoaDon(String id);
}

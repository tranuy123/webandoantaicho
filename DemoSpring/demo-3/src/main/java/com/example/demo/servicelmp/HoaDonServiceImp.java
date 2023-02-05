package com.example.demo.servicelmp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.HoaDonDao;
import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.model.Menu;
import com.example.demo.service.HoaDonService;
import com.example.demo.service.LoginService;

@Service
public class HoaDonServiceImp implements HoaDonService{
	@Autowired
	HoaDonDao HoaDonDao;
	@Override
	public int InsertHoaDon(HoaDon h)  {
		return HoaDonDao.InsertHoaDon(h);
	}
	@Override
	public int InsertHoaDon1(HoaDon h)  {
		return HoaDonDao.InsertHoaDon1(h);
	}
	@Override
	public Menu ShowDetailF(String id) {
		
		return HoaDonDao.ShowDetailF(id);
	}
	@Override
    public List<HoaDon> ShowList() {
        return HoaDonDao.ShowList();
    }
	@Override
    public List<HoaDon> ShowListHoaDon(String id) {
        return HoaDonDao.ShowListHoaDon(id);
    }
	@Override
    public List<HoaDon> SearchHD(Date ngay) {
        return HoaDonDao.SearchHD(ngay);
    }
	 @Override
	    public HoaDon ShowDetailHoaDon(String id) {
	        HoaDon hoadon = HoaDonDao.ShowDetailHoaDon(id);
	        if(hoadon==null) return null;
	        List<ChiTietHoaDon> list = new ArrayList<>();
	        for(ChiTietHoaDon ct : hoadon.getChitiethoadon()){
	            ct.setMenu(ShowDetailF(ct.getMenu().getIDF()));
	            list.add(ct);
	        }
	        hoadon.setChitiethoadon(list);
	        return hoadon;
	    }
	 @Override
	    public int UpdateHoaDon(HoaDon h) {
	        List<ChiTietHoaDon> list = new ArrayList<>();
	        for(ChiTietHoaDon ct : h.getChitiethoadon()){
	            ct.setMenu(ShowDetailF(ct.getIdf()));
	            list.add(ct);
	        }
	        h.setChitiethoadon(list);

	        return HoaDonDao.UpdateHoaDon(h);
	    }

}

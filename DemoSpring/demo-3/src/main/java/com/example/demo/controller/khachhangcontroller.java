package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.model.Menu;
@RequestMapping("/khach-hang")
@Controller
public class khachhangcontroller extends common{
	
	@GetMapping("/menu")
    public ModelAndView menu(HttpSession session){
        List<Menu> list = new ArrayList<>();
        mv.addObject("menus",list);
        mv.setViewName("khachhang");
        mv.addObject("menus",MenuService.ShowMenu());
        session.setAttribute("listfood",list);        
        return mv;
    }
//	 @GetMapping("/khach-hang/{user}")
//	 @ResponseBody
//	    public ModelAndView DeTail_account(@PathVariable("user") String user){
//	        mv.addObject("acc",LoginService.ShowDetail(user));
//	        mv.addObject("menu",new Menu());
//			mv.addObject("menus",MenuService.ShowMenu());
//	        mv.setViewName("khachhang");
//	        return mv;
//	    }
	 @PostMapping("/them-food-session")
	    public ModelAndView them_food_session(HttpSession session,@RequestParam("id") String idf){
	        mv.setViewName("khachhang :: #listfood");
	        List<Menu> list = (List<Menu>) session.getAttribute("listfood");
	        list.add(HoaDonService.ShowDetailF(idf));
	        session.setAttribute("listfood",list);
	        return mv;
	    }

	 @GetMapping("/xac-nhan-chi-tiet")
	    public ModelAndView xac_nhan_chi_tiet(HttpSession session,Principal principal){
	        mv.setViewName("Chitietdon");
	        List<Menu> list = (List<Menu>) session.getAttribute("listfood");
	        String userName = principal.getName();
	        HoaDon hoadon = new HoaDon();
	        List<ChiTietHoaDon> listChitiet = new ArrayList<>();
	        for(Menu hh : list){
	        	ChiTietHoaDon chitiet= new ChiTietHoaDon();
	            chitiet.setMenu(hh);
	            listChitiet.add(chitiet);
	        }
	        hoadon.setChitiethoadon(listChitiet);
	        hoadon.setNgayXuatHD(new Date());
	        hoadon.setAccounts(LoginService.CheckUserName(userName));
	        hoadon.setSoLoaiFood(listChitiet.size());
	        mv.addObject("hoadon",hoadon);
	        return mv;
	    }
	 @GetMapping("/xac-nhan-chi-tiet-1")
	    public ModelAndView xac_nhan_chi_tiet1(HttpSession session,Principal principal){
	        mv.setViewName("Chitietdon1");
	        List<Menu> list = (List<Menu>) session.getAttribute("listfood");
	        String userName = principal.getName();
	        HoaDon hoadon = new HoaDon();
	        List<ChiTietHoaDon> listChitiet = new ArrayList<>();
	        for(Menu hh : list){
	        	ChiTietHoaDon chitiet= new ChiTietHoaDon();
	            chitiet.setMenu(hh);
	            listChitiet.add(chitiet);
	        }
	        hoadon.setChitiethoadon(listChitiet);
	        hoadon.setNgayXuatHD(new Date());
	        hoadon.setAccounts(LoginService.CheckUserName(userName));
	        hoadon.setSoLoaiFood(listChitiet.size());
	        mv.addObject("hoadon",hoadon);
	        return mv;
	    }
	 @PostMapping("/confirm")
	    public ModelAndView comfirm(HttpSession session,HoaDon HoaDon,Principal principal){
		 HoaDon.setAccounts(LoginService.CheckUserName(principal.getName()));
	        for(int i = 0; i<HoaDon.getChitiethoadon().size();i++){
	        	HoaDon.getChitiethoadon().get(i)
	                    .setMenu(HoaDonService.ShowDetailF(HoaDon.getChitiethoadon().get(0).getIdf()));
	        	HoaDon.getChitiethoadon().get(i).setDonGia(HoaDon.getChitiethoadon().get(0).getMenu().getPrice());
	        }
	       
				HoaDonService.InsertHoaDon(HoaDon);
				session.setAttribute("hoadon",HoaDon);				
	        mv.setViewName("redirect:/khach-hang/menu");	       
	        return mv;
	    }
	 @PostMapping("/confirm1")
	    public ModelAndView comfirm1(HttpSession session,HoaDon HoaDon,Principal principal){
		 HoaDon.setAccounts(LoginService.CheckUserName(principal.getName()));
	        for(int i = 0; i<HoaDon.getChitiethoadon().size();i++){
	        	HoaDon.getChitiethoadon().get(i)
	                    .setMenu(HoaDonService.ShowDetailF(HoaDon.getChitiethoadon().get(0).getIdf()));
	        	HoaDon.getChitiethoadon().get(i).setDonGia(HoaDon.getChitiethoadon().get(0).getMenu().getPrice());
	        }
	       
				HoaDonService.InsertHoaDon1(HoaDon);
				session.setAttribute("hoadon",HoaDon);				
	        mv.setViewName("redirect:/khach-hang/menu");	       
	        return mv;
	    }
	 
	 @GetMapping("/lich-su-xuat-hoa-don")
	    public ModelAndView lich_su_xuat_hoa_don(){
	        mv.setViewName("Lichsuxuathoadon");
	        mv.addObject("Phieus",HoaDonService.ShowList());
	        return mv;
	    }
	 @GetMapping ("/xem-hoa-don/{mahd}")
	    public ModelAndView xem_hoa_don(HttpSession session,@PathVariable("mahd") String mahd){
		 	List<HoaDon> list = new ArrayList<>();
	        mv.addObject("hoadons",list);
	        mv.setViewName("Client-XemHoaDon");
	        mv.addObject("hoadons",HoaDonService.ShowListHoaDon(mahd));
	        session.setAttribute("hoadons",list);        
	        return mv;
	    }
	 @GetMapping ("/lich-su/{maPhieu}")
	    public ModelAndView chi_tiet_phieu_nhap(HttpSession session,@PathVariable("maPhieu") String maPhieu){
	        mv.setViewName("SuaCTDN");
	        HoaDon p = HoaDonService.ShowDetailHoaDon(maPhieu);
	        List<ChiTietHoaDon> list = p.getChitiethoadon();
	        session.setAttribute("hoadons",list);
	        mv.addObject("hoadon",p);
	        return mv;
	    }
	 @GetMapping("/anh-mon-an/{IDF}")
	 public void load_anh_laptop(@PathVariable("IDF") String idf, HttpServletResponse response) throws SQLException, IOException {
	     response.setContentType("image/jpeg");

	     Blob ph = HoaDonService.ShowDetailF(idf).getImage();

	     byte[] bytes = ph.getBytes(1, (int) ph.length());
	     InputStream inputStream = new ByteArrayInputStream(bytes);
	     IOUtils.copy(inputStream, response.getOutputStream());
	    }
	
}

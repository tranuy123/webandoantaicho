package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Ban;
import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.HoaDon;
import com.example.demo.model.Menu;
import com.example.demo.model.NhanVien;

@RequestMapping("/quan-ly")
@Controller
public class QuanLyController extends common {
	@GetMapping("/menu")
	public ModelAndView menu() {
		mv.setViewName("Server-QuanLyMonAn");
        mv.addObject("menu",new Menu());
        mv.addObject("menus",MenuService.ShowMenu());
        return mv;
	}
	@PostMapping("/them-mon-an")	
    public ModelAndView them_mon_an(Menu menu) throws IOException {
        MenuService.Insert(menu);
        mv.setViewName("redirect:/quan-ly/menu");
        return mv;
    }
	@PostMapping("/sua-mon-an")
    public ModelAndView sua_mon_an(Menu menu) throws IOException {
        MenuService.Update(menu);
        mv.setViewName("redirect:/quan-ly/menu");
        return mv;
    }
//	@GetMapping("/chi-tiet-mon")
//	public ModelAndView chi_tiet_mon1() {
//		mv.setViewName("ChiTietMonAn");
//        mv.addObject("menu",new Menu());
//        mv.addObject("menus",MenuService.ShowMenu());
//        return mv;
//	}
	 @GetMapping("/chi-tiet-mon/{IDF}")
	 public ModelAndView chi_tiet_mon(@PathVariable("IDF") String idf){
		 Menu n = HoaDonService.ShowDetailF(idf);
	    mv.addObject("menu",n);
	    mv.setViewName("ChiTietMonAn");
	    return mv;
	    }
	@PostMapping("/xoa-mon-an")
    public ModelAndView xoa_mon_an(@RequestParam("IDF")String idf){
        MenuService.Delete(idf);

        return mv;
    }
	@PostMapping("/show-mon-an-on-modal")
    public ModelAndView show_mon_an_on_modal(String idf){
		 Menu n = HoaDonService.ShowDetailF(idf);
        mv.setViewName("Server-QuanLyMonAn :: #modalSua");
        mv.addObject("menu",n);
        return mv;
    }
	 @GetMapping("/anh-mon-an/{IDF}")
	 public void load_anh_mon_an(@PathVariable("IDF") String idf, HttpServletResponse response) throws SQLException, IOException {
	     response.setContentType("image/jpeg");

	     Blob ph = HoaDonService.ShowDetailF(idf).getImage();

	     byte[] bytes = ph.getBytes(1, (int) ph.length());
	     InputStream inputStream = new ByteArrayInputStream(bytes);
	     IOUtils.copy(inputStream, response.getOutputStream());
	    }
	 // Nhân viên
	 @GetMapping("/nhan-vien")
	    public ModelAndView load_nhan_vien(){
	        mv.setViewName("QuanlyNV");
	        mv.addObject("nhanvien",new NhanVien());
	        mv.addObject("nhanviens",PersonService.showListThuKho());
	        return mv;
	    }
	 @PostMapping("/xoa-thu-kho")
	    public ModelAndView xoa_thu_kho(@RequestParam("maTK")String idtk){
	        PersonService.deleteThuKho(idtk);
	        return mv;
	    }
	
	 @GetMapping("/them-nhan-vien")
	 	public ModelAndView page_nhan_vien() {
		 mv.addObject("nhanvien",new NhanVien());
		 mv.setViewName("ThemTK");
		 return mv ; 
	 }
	 @PostMapping("/them-tk")
	    public ModelAndView them_tk(@ModelAttribute NhanVien nhanvien,@RequestParam("matKhau")String matKhau) {
	        nhanvien.getTaiKhoan().setPassword(passwordEncoder.encode(matKhau));
	        PersonService.insertThuKho(nhanvien);
	        mv.setViewName("redirect:/quan-ly/nhan-vien");
	        return mv;
	    }
	 @GetMapping ("/xem-hoa-don/{mahd}")
	    public ModelAndView xem_hoa_don(HttpSession session,@PathVariable("mahd") String mahd){
		 	List<HoaDon> list = new ArrayList<>();
	        mv.addObject("hoadons",list);
	        mv.setViewName("Server-XemHoaDon");
	        mv.addObject("hoadons",HoaDonService.ShowListHoaDon(mahd));
	        session.setAttribute("hoadons",list);        
	        return mv;
	    }
	 @PostMapping("/them-ban")
	    public ModelAndView them_ban(@ModelAttribute Ban ban,@RequestParam("matKhau")String matKhau) {
	        ban.getTaiKhoan().setPassword(passwordEncoder.encode(matKhau));
	        PersonService.InsertBan(ban);
	        mv.setViewName("redirect:/quan-ly/ban");
	        return mv;
	    }
	 @GetMapping("/ban")
		public ModelAndView ban() {
			mv.setViewName("QuanLyBan");
	        mv.addObject("ban",new Menu());
	        mv.addObject("bans",PersonService.ShowBan());
	        return mv;
		}
	 @GetMapping ("/lich-su/{maPhieu}")
	    public ModelAndView chi_tiet_phieu_nhap(HttpSession session,@PathVariable("maPhieu") String maPhieu){
	        mv.setViewName("Server-XemChiTietHoaDon");
	        HoaDon p = HoaDonService.ShowDetailHoaDon(maPhieu);
	        List<ChiTietHoaDon> list = p.getChitiethoadon();
	        session.setAttribute("hoadons",list);
	        mv.addObject("hoadon",p);
	        return mv;
	    }
	 @PostMapping("/sua")
	    public ModelAndView sua(HoaDon hoadon){
	        HoaDonService.UpdateHoaDon(hoadon);	        
	            mv.setViewName("redirect:/Quan-Ly-Ban/ban");
	        return mv;
	    }
	 @GetMapping("/hoa-don")
		public ModelAndView hoa_don() {
			mv.setViewName("Server-QuanLyHoaDon");
	        mv.addObject("hoadon",new HoaDon());
	        mv.addObject("hoadons",HoaDonService.ShowList());
	        return mv;
		}
	 @GetMapping("/tim-hoa-don")	
	    public ModelAndView tim_hoa_don(Date hd){
		 	mv.setViewName("redirect:/Quan-Ly-Ban/hoa-don");
	        mv.addObject("hoadon",new HoaDon());
	        mv.addObject("hoadons",HoaDonService.SearchHD(hd));
	        return mv;
	    }
	 @PostMapping("/show-ban-on-modal")
	    public ModelAndView show_ban_on_modal(String idf){
			 Ban n = PersonService.showBan(idf);
	        mv.setViewName("chitietban :: #modalSua");
	        mv.addObject("bans",n);
	        return mv;
	    }
	 @GetMapping("/thong-ke")
	 	public ModelAndView thongke() {
		 mv.setViewName("ThongKe");
		 return mv ; 
	 }
	
	
}

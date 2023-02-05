package com.example.demo.Daolmp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Dao.HoaDonDao;
import com.example.demo.model.HoaDon;
import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.model.Menu;
import com.example.demo.model.mapper.ChiTietHoaDonMapper;
import com.example.demo.model.mapper.HoaDonMapper;
import com.example.demo.model.mapper.MenuMapper;
@Repository
public class HoaDonDaoImp implements HoaDonDao{
	@Autowired
	JdbcTemplate JdbcTemplate ; 
	@Override
	public int InsertHoaDon(HoaDon h) {
        
        h.setTrangThai(false);
        String query = "insert into hoadon values(?,?,?,?,?,?)";
        int kq = JdbcTemplate.update(query,new Object[]{h.getMaHD(),h.getNgayXuatHD(),h.getSoLoaiFood(),h.getTongTien(),h.isTrangThai(),h.getAccounts().getUserName()});
        
            for(ChiTietHoaDon ct : h.getChitiethoadon()){
                String sql = "insert into chitiethoadon values(?,?,?,?,?)";
                JdbcTemplate.update(sql,new Object[]{h.getMaHD(),ct.getIdf(),ct.getSoLuong(),ct.getDonGia(),ct.getThanhTien()});
                String sql2 = "update ban set trangthai = "+h.isTrangThai()+ ",trangthaiyc = "+h.isTrangThai()+" where maban='"+ct.getIdf()+"'";
                JdbcTemplate.update(sql2);
         
        }
            
            String query2="update ban set trangthai=?,trangthaiyc=? where username=?";
            int kq2 = JdbcTemplate.update(query2,new Object[] {h.isTrangThai(),h.isTrangThai(),h.getAccounts().getUserName()});
       
		return kq+kq2;
    }
	@Override
	public int InsertHoaDon1(HoaDon h) {
        
        h.setTrangThai(true);
        String query = "\"update ban set trangthai = \"+h.isTrangThai()+ \" where maban='\"+ct.getIdf()+\"'\"";
        int kq = JdbcTemplate.update(query,new Object[]{h.getMaHD(),h.getNgayXuatHD(),h.getSoLoaiFood(),h.getTongTien(),h.isTrangThai(),h.getAccounts().getUserName()});
        
            for(ChiTietHoaDon ct : h.getChitiethoadon()){
                String sql = "insert into chitiethoadon values(?,?,?,?,?)";
                JdbcTemplate.update(sql,new Object[]{h.getMaHD(),ct.getIdf(),ct.getSoLuong(),ct.getDonGia(),ct.getThanhTien()});
                String sql2 = "update ban set trangthai = "+h.isTrangThai()+ " where maban='"+ct.getIdf()+"'";
                JdbcTemplate.update(sql2);
         
        }
            
       
		return kq;
    }
	@Override
    public Menu ShowDetailF(String id) {
        String q = "select*from Menu where IDF='"+id+"'";
        return JdbcTemplate.query(q,new MenuMapper()).get(0);
    }
	 @Override
	    public List<HoaDon> ShowList( ) {
	        String query = "select * from hoadon  order by ngayxuathd desc";
	        List<HoaDon> hoadons = JdbcTemplate.query(query,new HoaDonMapper());
	        return hoadons;
	    }
	 @Override
	    public List<HoaDon> ShowListHoaDon( String mahd) {
	        String query = "select*from hoadon where username='"+mahd+"' and trangthai=0";
	        List<HoaDon> hoadons = JdbcTemplate.query(query,new HoaDonMapper());
	        return hoadons;
	    }
	 @Override
	    public List<HoaDon> SearchHD( Date mahd) {
	        String query = "select*from hoadon where ngayxuathd='"+mahd+"' order by ngayxuathd desc";
	        List<HoaDon> hoadons = JdbcTemplate.query(query,new HoaDonMapper());
	        return hoadons;
	    }
	 @Override
	    public HoaDon ShowDetailHoaDon(String id) {
	        String query = "select*from hoadon where mahd ='"+id+"'";
	        List<HoaDon> list = JdbcTemplate.query(query,new HoaDonMapper());
	        if(list.size()==0) return null;
	        String sql = "select*from chitiethoadon where mahd ='"+id+"'";
	        List<ChiTietHoaDon> list1 = JdbcTemplate.query(sql,new ChiTietHoaDonMapper());
	        list.get(0).setChitiethoadon(list1);
	        return list.get(0);
	    }
	 @Override
	    public int UpdateHoaDon(HoaDon p) {
	        String updatehoadon = "update hoadon set TrangThai=?,SoLoaiFood=?,TongTien=? where MaHD =?";
	        int kq = JdbcTemplate.update(updatehoadon,new Object[]{p.isTrangThai(),p.getChitiethoadon().size(),p.getTongTien(),p.getMaHD()});
	        String updateban="update ban set trangthaiYC = True where username= ?";
	        int kq3 = JdbcTemplate.update(updateban,new Object[] {p.getUsername()});
	        List<ChiTietHoaDon> chiTietPhieu = ShowDetailHoaDon(p.getMaHD()).getChitiethoadon();
	        String delete = "delete from chitiethoadon where mahd ='"+p.getMaHD()+"'";
	        int kq1 =JdbcTemplate.update(delete);

	        String insertCt = "insert into chitiethoadon values(?,?,?,?,?)";
	        int kq2=0;
	        for(ChiTietHoaDon ct: p.getChitiethoadon()) {
	           kq2 +=JdbcTemplate.update(insertCt,new Object[]{p.getMaHD(),ct.getIdf(),ct.getSoLuong(),ct.getMenu().getPrice(),ct.getThanhTien()});
	        }
	        return 1;
	    }
}

package com.example.demo.Daolmp;

import com.example.demo.Dao.PersonDao;
import com.example.demo.model.Accounts;
import com.example.demo.model.Admin;
import com.example.demo.model.Ban;
import com.example.demo.model.Menu;
import com.example.demo.model.mapper.AccountMapper;
import com.example.demo.model.mapper.AdminMapper;
import com.example.demo.model.mapper.BanMapper;
import com.example.demo.model.mapper.MenuMapper;
import com.example.demo.model.mapper.NhanVienMapper;
import com.example.demo.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDaoImp implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Admin showAdmin(String userName) {
        String query = "select*from quanly where UserName='"+userName+"'";
        List<Admin> listAdmin = jdbcTemplate.query(query,new AdminMapper());
        return listAdmin.get(0);
    }

    @Override
    public int insertAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        String query = "update quanly set TenQL=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }

    @Override
    public int insertThuKho(NhanVien tk) {
    	String querytk = "INSERT INTO account " +
                "(`username`, `password`, `marl`) VALUES (?,?,?);";
        int kq1= jdbcTemplate.update(querytk,new Object[]{tk.getTaiKhoan().getUserName(),tk.getTaiKhoan().getPassword(),tk.getTaiKhoan().getRole().getMaRL()});

        String querytk1 = "insert into nhanvien(`matk`,`username`,`ngaybatdau`,`sotientrengio`) values(?,?,?,?)";
        int kq2 = jdbcTemplate.update(querytk1,new Object[]{tk.getID(),tk.getTaiKhoan().getUserName(),tk.getNgayBatDauLam(),tk.getSoTienTrenGio()});
        return kq1+kq2;
        
    }

    @Override
    public int updateThuKho(NhanVien admin) {
        String query = "update nhanvien set TenTK=?,NgaySinh=?,GioiTinh=?,CCCD=?,SDT=? where UserName = ?";
        return jdbcTemplate.update(query,new Object[]{admin.getTen(), admin.getNgaySinh(),admin.getGioiTinh(),admin.getCCCD(),admin.getSoDT(),admin.getTaiKhoan().getUserName()});

    }
    public int updateThuKho1(NhanVien admin) {
        String query = "update nhanvien set sotientrengio=? where matk = ?";
        return jdbcTemplate.update(query,new Object[]{ admin.getSoTienTrenGio(),admin.getID()});

    }

    @Override
    public int deleteThuKho(String idNV) {
        String userName = showThuKho1(idNV).getTaiKhoan().getUserName();
        String query2 = "delete from nhanvien where matk='"+idNV+"'";
        int kq = jdbcTemplate.update(query2);

        String query = "delete from account where UserName ='"+userName+"'";
        jdbcTemplate.update(query);
        return kq;
    }
    public int delete(String id) {
        String query = "delete from account where UserName ='"+showThuKho1(id).getTaiKhoan().getUserName()+"'";
        jdbcTemplate.update(query);
        String query2 = "delete from nhanvien where matk='"+id+"'";
        int kq = jdbcTemplate.update(query2);
        return kq;
    }

    @Override
    public NhanVien showThuKho(String userName) {
        String query = "select*from nhanvien where UserName='"+userName+"'";
        List<NhanVien> listAdmin = jdbcTemplate.query(query,new NhanVienMapper());
        return listAdmin.get(0);
    }
    @Override
    public Ban showBan(String userName) {
        String query = "select*from ban where UserName='"+userName+"'";
        return jdbcTemplate.query(query, new BanMapper()).get(0);
    }
  
    public NhanVien showThuKho1(String id) {
        String query = "select*from nhanvien where matk='"+id+"'";
        List<NhanVien> listAdmin = jdbcTemplate.query(query,new NhanVienMapper());
        return listAdmin.get(0);
    }

    @Override
    public List<NhanVien> showListThuKho() {
    	String query="select * from nhanvien";
    	 return jdbcTemplate.query(query,new NhanVienMapper());
    }
    @Override
    public List<Ban> ShowBan() {
    	String query="select * from ban";
    	 return jdbcTemplate.query(query,new BanMapper());
    }
    @Override
    public NhanVien check_id(String id) {
        String query = "select*from nhanvien where matk = '"+id+"'";
        if(jdbcTemplate.query(query,new NhanVienMapper()).size()==0)
            return null;
        else return jdbcTemplate.query(query,new NhanVienMapper()).get(0);
    }
    @Override
    public int InsertBan(Ban tk) {
    	String querytk = "INSERT INTO account " +
                "(`username`,`password`,`marl`) VALUES (?,?,?);";
        int kq1= jdbcTemplate.update(querytk,new Object[]{tk.getTaiKhoan().getUserName(),tk.getTaiKhoan().getPassword(),tk.getTaiKhoan().getRole().getMaRL()});

        String querytk1 = "insert into ban(`maban`,`username`,`trangthai`) values(?,?,?)";
        int kq2 = jdbcTemplate.update(querytk1,new Object[]{tk.getMaBan(),tk.getTaiKhoan().getUserName(),tk.isTrangThai()});
        return kq1+kq2;
        
    }

@Override
public int UpdateBan(Ban ban) {
    String query = "update ban set trangthai=?,trangthaiyc=? where username = ?";
    return jdbcTemplate.update(query,new Object[]{ ban.isTrangThai(),ban.isTrangThaiYC(),ban.getTaiKhoan().getUserName()});

}
}

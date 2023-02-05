package com.example.demo.controller;
import com.example.demo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Objects;

@Controller
public class HoSoController extends common{
    @GetMapping("/ho-so")
    public ModelAndView ho_so(HttpSession session,Principal principal){
        session.setAttribute("admin",perSon(principal));
        mv.setViewName("HoSo");
        return mv;
    }
    @PostMapping ("/ho-so")
    public ModelAndView update_thong_tin(NhanVien person, Principal principal, HttpSession session){
        mv.setViewName("HoSo");
        person.setTaiKhoan(new Accounts(principal.getName()));
        if(Objects.equals(LoginService.CheckUserName(principal.getName()).getRole().getMaRL(), "ADMIN")){
            PersonService.updateAdmin(person);
            Admin admin = PersonService.showAdmin(principal.getName());
            admin.setTaiKhoan(LoginService.CheckUserName(principal.getName()));
            session.setAttribute("admin",admin);
        }
        else{
            PersonService.updateThuKho(person);
            NhanVien nhanvien = PersonService.showThuKho(principal.getName());
            nhanvien.setTaiKhoan(LoginService.CheckUserName(principal.getName()));
            session.setAttribute("admin",nhanvien);
        }
        return mv;
    }
    @PostMapping("/update-password")
    public ModelAndView update_password( @RequestParam("passWord") String pw, @RequestParam("userName")String userName, @RequestParam("newPassWord") String newPass){
       String pass = LoginService.CheckUserName(userName).getPassword();
        boolean ss = passwordEncoder.matches(pw,pass);
        if(ss){
            Accounts accounts = new Accounts();
            accounts.setPassword(passwordEncoder.encode(newPass));
            accounts.setUserName(userName);
            LoginService.updateAccount(accounts);
            mv.setViewName("Fragments/1Vai :: #KetQuaDung");
        }else {
            mv.setViewName("Fragments/1Vai :: #KetQuaSai");
        }
        return mv;
    }
}

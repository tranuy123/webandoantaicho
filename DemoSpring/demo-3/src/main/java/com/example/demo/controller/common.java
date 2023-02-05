package com.example.demo.controller;
import com.example.demo.model.Admin;

import com.example.demo.model.Ban;
import com.example.demo.model.NhanVien;

import com.example.demo.service.LoginService;
import com.example.demo.service.PersonService;

import com.example.demo.service.*;


import java.security.Principal;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

public class common {
	ModelAndView mv = new ModelAndView();
	@Autowired
    public PasswordEncoder passwordEncoder;
	@Autowired
	MenuService MenuService ;
	@Autowired 
	LoginService LoginService ;
	@Autowired
	HoaDonService HoaDonService;
	@Autowired 
	PersonService PersonService;
	
	   Admin perSon(Principal principal){
	        if(Objects.equals(LoginService.CheckUserName(principal.getName()).getRole().getMaRL(), "ADMIN")){
	            Admin admin = PersonService.showAdmin(principal.getName());
	            admin.setTaiKhoan(LoginService.CheckUserName(principal.getName()));
	            return admin;
	        }else if (Objects.equals(LoginService.CheckUserName(principal.getName()).getRole().getMaRL(), "NHANVIEN")){
	            NhanVien nhanVien = PersonService.showThuKho(principal.getName());
	            nhanVien.setTaiKhoan(LoginService.CheckUserName(principal.getName()));
	            return nhanVien;
	        } else {
	        	 Ban ban = PersonService.showBan(principal.getName());
		            ban.setTaiKhoan(LoginService.CheckUserName(principal.getName()));
		            return ban;
	        }
	    }
}

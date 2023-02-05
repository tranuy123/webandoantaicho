package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Menu;

@Controller
public class trangchucontroller extends common{
	@GetMapping("/trang-chu")
	public ModelAndView hien_thi_trang_chu(HttpSession session, Principal principal) {
		session.setAttribute("admin",perSon(principal));
		mv.setViewName("index");
		return mv;
	}
	
}

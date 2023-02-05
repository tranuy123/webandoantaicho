package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends common{
    @GetMapping("/")
    public ModelAndView hien_thi_login(){
        mv.setViewName("pages-login");
        return mv;
    }
}

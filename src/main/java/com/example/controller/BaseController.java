package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Des     : (一句话描述)
 *
 * @Author : liuyu
 * @Date : 2017/10/12.
 */
@Controller
public class BaseController {


    @Value("${address}")
    private String address;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/")
    public String signIndex(Model map){
        map.addAttribute("address", address);
        return "sign";
    }
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Des     : (一句话描述)
 *
 * @Author : liuyu
 * @Date : 2017/7/12.
 */
@Controller
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${bookTitle}")
    private String bookTitle;

    @RequestMapping("/hello")
    public String index(ModelMap map, HttpServletRequest req){
        map.addAttribute("name", name);
        map.addAttribute("bookTitle", bookTitle);
        map.put("ctx", req.getContextPath());
        map.put("tip", "");
        return "welcome";
    }

    @RequestMapping("/hello/login")
    public String innerIndex(ModelMap map, HttpServletRequest req){
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if(!"lossingfish".equals(userName) && !"1234556".equals(password)){
            map.addAttribute("name", name);
            map.addAttribute("bookTitle", bookTitle);
            map.put("ctx", req.getContextPath());
            map.put("tip", "用户名或密码错误！");
            return "welcome";
        } else
            return "success";
    }

    @RequestMapping("/hello/thymeleaf")
    public String thyIndex(Model map, HttpServletRequest req){
        map.addAttribute("name", name);
        map.addAttribute("bookTitle", bookTitle);
        map.addAttribute("ctx", req.getContextPath());
        map.addAttribute("tip", "");
        return "thyIndex";
    }

}

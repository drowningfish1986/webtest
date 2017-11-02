package com.example.controller;

import com.example.util.SignUtils;
import com.example.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Des     : 云金服签名测试
 *
 * @Author : liuyu
 * @Date : 2017/10/12.
 */
@Controller
public class SignAndTestController {

    @Value("${remoteServer}")
    private String remoteServer;

    @RequestMapping("/sign/usual")
    public String signUsual(HttpServletRequest request, Model map){

        String appKey = request.getParameter("appKey1");
        String secure = request.getParameter("secure1");
        String version = request.getParameter("version1");
        String timestamp = request.getParameter("timestamp1");
        String jsonData = request.getParameter("jsonData1");
        if(StringUtils.isBlank(appKey)){
            return "appKey不能为空";
        }
        if(StringUtils.isBlank(timestamp)){
            return "timestamp不能为空";
        }
        if(StringUtils.isBlank(jsonData)){
            return "jsonData不能为空";
        }
        String sign = SignUtils.sign(new String[]{appKey, secure, version, timestamp, jsonData});
        StringBuilder sb = new StringBuilder();
        sb.append("appKey=").append(appKey)
                .append("&sign=").append(sign)
                .append("&version=").append(version)
                .append("&amp;timestamp=").append(timestamp);
        map.addAttribute("signValue", sb.toString());
        return "result";
    }

    @RequestMapping(value = "/sign/form", method = RequestMethod.POST)
    public ModelAndView signForm(HttpServletRequest request, HttpServletResponse response, Model map) throws ServletException, IOException {
        ModelAndView mv = new ModelAndView();

        String appKey = request.getParameter("appKey2");
        String secure = request.getParameter("secure2");
        String version = request.getParameter("version2");
        String timestamp = request.getParameter("timestamp2");
        String userId = request.getParameter("userId2");
        String redirectUrlAcct = request.getParameter("redirectUrlAcct2");
        if(StringUtils.isBlank(appKey)){
            String msg = "appKey can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
//            return mv;
        }
        if(StringUtils.isBlank(timestamp)){
            String msg = "timestamp can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
//            return mv;
        }
        if(StringUtils.isBlank(userId)){
            String msg = "userId can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
//            return mv;
        }
        String sign = SignUtils.sign(new String[]{appKey, secure, version, timestamp, userId});
//        StringBuilder sb = new StringBuilder();
//        sb.append("appKey=").append(appKey)
//                .append("&amp;sign=").append(sign)
//                .append("&amp;version=").append(version)
//                .append("&amp;timestamp=").append(timestamp)
//                .append("&amp;userId=").append(userId);
//        map.addAttribute("signValue", sb.toString());
        String typeValue = request.getParameter("type");
        String type = "0".equals(typeValue) ? "person" : "corporation";
        StringBuilder url = new StringBuilder("http://").append(remoteServer).append("/api/server/cust/");
        url.append(type).append("/url?appKey=").append(appKey)
                .append("&sign=").append(sign)
                .append("&version=").append(version)
                .append("&timestamp=").append(timestamp)
                .append("&userId=").append(userId)
                .append("&redirectUrl=").append(redirectUrlAcct);
        System.out.println("url=" + url.toString());
        mv.setViewName("redirect:" + url.toString());
        return mv;
//        try {
//            response.sendRedirect(url.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//            request.getRequestDispatcher(url).forward(request, response);
    }

    @RequestMapping(value = "/sign/withdraw", method = RequestMethod.POST)
    public ModelAndView signWithdraw(HttpServletRequest request, HttpServletResponse response, Model map){
        ModelAndView mv = new ModelAndView();

        String appKey = request.getParameter("appKey3");
        String secure = request.getParameter("secure3");
        String version = request.getParameter("version3");
        String timestamp = request.getParameter("timestamp3");
        String userId = request.getParameter("userId3");
        String redirect = request.getParameter("redirect3");
        String orderNo = request.getParameter("orderNo3");
        if(StringUtils.isBlank(appKey)){
            String msg = "appKey can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        if(StringUtils.isBlank(timestamp)){
            String msg = "timestamp can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        if(StringUtils.isBlank(userId)){
            String msg = "userId can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        if(StringUtils.isBlank(orderNo)){
            String msg = "orderNo can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        String sign = SignUtils.sign(new String[]{appKey, secure, version, timestamp, userId});
//        StringBuilder sb = new StringBuilder();
//        sb.append("appKey=").append(appKey)
//                .append("&amp;sign=").append(sign)
//                .append("&amp;version=").append(version)
//                .append("&amp;timestamp=").append(timestamp)
//                .append("&amp;userId=").append(userId);
//        map.addAttribute("signValue", sb.toString());
        String typeValue = request.getParameter("type");
        String type = "0".equals(typeValue) ? "person" : "corporation";
        StringBuilder url = new StringBuilder("http://").append(remoteServer).append("/api/server/trans/url");
//        StringBuilder url = new StringBuilder("http://localhost:18180/server/withdraw/");
        url.append("?appKey=").append(appKey)
                .append("&sign=").append(sign)
                .append("&version=").append(version)
                .append("&timestamp=").append(timestamp)
                .append("&userId=").append(userId)
                .append("&orderNo=").append(orderNo)
                .append("&type=").append("1");
        if(StringUtils.isNotBlank(redirect)){
            url.append("&redirectUrl=").append(redirect);
        }
        System.out.println("url=" + url.toString());
        mv.setViewName("redirect:" + url.toString());
        return mv;
//        try {
//            response.sendRedirect(url.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//            request.getRequestDispatcher(url).forward(request, response);
    }

    @RequestMapping(value = "/password/change", method = RequestMethod.POST)
    public ModelAndView changePassword(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();

        String appKey = request.getParameter("appKey4");
        String secure = request.getParameter("secure4");
        String version = request.getParameter("version4");
        String timestamp = request.getParameter("timestamp4");
        String userId = request.getParameter("userId4");
        String redirect = request.getParameter("redirect4");
        if(StringUtils.isBlank(appKey)){
            String msg = "appKey can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        if(StringUtils.isBlank(timestamp)){
            String msg = "timestamp can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        if(StringUtils.isBlank(userId)){
            String msg = "userId can't be blank";
            mv.setViewName("redirect:/errorpage?msg=" + msg);
            return mv;
        }
        String sign = SignUtils.sign(new String[]{appKey, secure, version, timestamp, userId});
        StringBuilder url = new StringBuilder("http://").append(remoteServer).append("/api/server/pwdChange/url");
        url.append("?appKey=").append(appKey)
                .append("&sign=").append(sign)
                .append("&version=").append(version)
                .append("&timestamp=").append(timestamp)
                .append("&userId=").append(userId)
                .append("&type=").append("1");
        if(StringUtils.isNotBlank(redirect)){
            url.append("&redirectUrl=").append(redirect);
        }
        System.out.println("url=" + url.toString());
        mv.setViewName("redirect:" + url.toString());
        return mv;
    }

    @RequestMapping("/errorpage")
    public String goError(HttpServletRequest request, Model map){
        String msg = request.getParameter("msg");
        map.addAttribute("signValue", msg);
        return "result";
    }
}

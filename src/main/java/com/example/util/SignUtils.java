package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Des     : 云金服签名和验签工具
 *
 * @Author : liuyu
 * @Date : 2017/9/13.
 */
public class SignUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignUtils.class);
    public static boolean checkRequest(HttpServletRequest request, String jsonData){
        String appKey = request.getParameter("appKey");
        String signValue = request.getParameter("sign");
        String secure = "YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=";
        String version = request.getParameter("version");
        String timestamp = request.getParameter("timestamp");
        if(StringUtils.isBlank(appKey)
                || StringUtils.isBlank(signValue)
                || StringUtils.isBlank(version)
                || StringUtils.isBlank(timestamp)
                || StringUtils.isBlank(jsonData)){
            return false;
        }
        String[] data = {appKey, secure, version, timestamp, jsonData};
        String signCloud = sign(data);
        return (StringUtils.isNotBlank(signValue) && signValue.equals(signCloud));
    }

    public static boolean checkPageRequest(HttpServletRequest request){
        String appKey = request.getParameter("appKey");
        String signValue = request.getParameter("sign");
        String secure = "YjY1Y2NkNTA5MmU0MTFlN2FiYzRjZWMyNzhiNmI1MGE=";
        String version = request.getParameter("version");
        String timestamp = request.getParameter("timestamp");
        String userId = request.getParameter("userId");
        if(StringUtils.isBlank(appKey)
                || StringUtils.isBlank(signValue)
                || StringUtils.isBlank(version)
                || StringUtils.isBlank(timestamp)
                || StringUtils.isBlank(userId)){
            return false;
        }
        String[] data = {appKey, secure, version, timestamp, userId};
        String signCloud = sign(data);
        return (StringUtils.isNotBlank(signValue) && signValue.equals(signCloud));
    }

    public static String sign(String[] data){
        try {
            Arrays.sort(data);
            StringBuilder sb = new StringBuilder();
            for(String s : data){
                sb.append(s);
            }
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(sb.toString().getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("签名出错");
        }
        return null;
    }
}

package com.zzb.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :zzb
 * @createDate :2020/9/1 10:59
 * @desc :
 */
@Controller
public class HelloController {
    private final Log log = LogFactory.getLog(HelloController.class);

    @RequestMapping("/")
    public String hello(HttpServletRequest request){
        log.info("请求开始时间》》》》》》》》》》》》》》》》》》》》》》》》：" + System.currentTimeMillis());
        log.info("请求IP 》》》》》》》》》》》》》》》》》》》》》》》》：" + getIpAddr(request));
        return "index";
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf("0.0.0.0")>=0) {
            ip = "127.0.0.1";
        }
        String[] ips=ip.split(",");
        if (ips.length>0) {
            ip=ips[0];
        }
        return ip;
    }

}

package com.zzb.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author :zzb
 * @createDate :2021/1/7 8:33 下午
 * @desc :
 */
@Configuration
public class CorsConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 允许跨域访问的路径
                .allowedOrigins("*")// 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
                .maxAge(168000)// 预检间隔时间
                .allowCredentials(true);// 是否发送cookie
    }
}

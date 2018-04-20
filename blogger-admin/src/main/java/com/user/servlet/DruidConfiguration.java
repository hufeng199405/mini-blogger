package com.user.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 类备注：Druid监控servelet和filter配置
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-20 15:37
 * @desc
 * @since 1.8
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidServlet() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

        servletRegistrationBean.setServlet(new StatViewServlet());

        servletRegistrationBean.addUrlMappings("/druid/*");

        Map<String, String> initParameters = new HashMap<String, String>();

        // 用户名
        initParameters.put("loginUsername", "admin");

        // 密码
        initParameters.put("loginPassword", "admin");

        // 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", "false");

        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", "");

        //initParameters.put("deny", "192.168.20.38");// IP黑名单

        //(存在共同时，deny优先于allow)

        servletRegistrationBean.setInitParameters(initParameters);

        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new WebStatFilter());

        filterRegistrationBean.addUrlPatterns("/*");

        //@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//

        //忽略资源
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }
}

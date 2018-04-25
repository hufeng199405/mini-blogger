package com.user.controller;

import com.user.constant.LoginConstant;
import com.user.utils.HttpUtils;
import com.user.domain.UserRecord;
import com.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 22:02
 * @desc
 * @since 1.8
 */

@Controller
@RequestMapping("/loginController")
public class LoginController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    // 登录方法
    @RequestMapping(value = "/aa/{userName}",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, @PathVariable("userName") String userName) throws Exception {

        //String userName = request.getParameter("userName");

        String password = request.getParameter("password");

        logger.info(RequestMethod.POST);

        UserRecord record = userService.updateUserLogin("hufeng", "199405");

        if (record != null) {

            // 如果登录成功，则缓存对象
            HttpUtils.putSession(request.getSession(), LoginConstant.LOGIN_SUCCESS_SIGN.getValue(), record);
        }

        request.setAttribute("test", 1111);

        return "index";
    }

    @RequestMapping("/regiter")
    public String register(HttpServletRequest request) throws Exception {

        request.setAttribute("test", 1111);

        return "index";
    }
}

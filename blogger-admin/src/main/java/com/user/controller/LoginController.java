package com.user.controller;

import com.user.constant.LoginConstant;
import com.user.utils.HttpUtils;
import com.user.domain.UserRecord;
import com.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userName = request.getParameter("userName");

        String password = request.getParameter("password");

        UserRecord record = userService.updateUserLogin("hufeng", "199405");

        if (record != null) {

            // 如果登录成功，则缓存对象
            HttpUtils.putSession(request.getSession(), LoginConstant.LOGIN_SUCCESS_SIGN.getValue(), record);
        }

        request.setAttribute("test", 1111);

        return "index";
    }
}

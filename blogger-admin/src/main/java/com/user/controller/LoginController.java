package com.user.controller;

import com.user.domain.UserRecord;
import com.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/loginController")
public class LoginController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    // 登录方法
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userName = request.getParameter("userName");

        String password = request.getParameter("password");

        UserRecord record = userService.updateUserLogin("hufeng","199405");

        return "index.jsp";
    }
}

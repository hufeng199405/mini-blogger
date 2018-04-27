package com.user.servlet;


import compoment.captcha.AccountCaptchaService;
import compoment.captcha.impl.AccountCaptchaServiceImp;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 类备注：生成验证码
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-27 15:38
 * @desc
 * @since 1.8
 */
public class CheckImgServlet extends HttpServlet {

    Logger logger = Logger.getLogger(this.getClass());

    public final static int CHECK_CODE_COUNT = 4;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);
    }

    /**
     * 生成验证码
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            AccountCaptchaService accountCaptchaService = new AccountCaptchaServiceImp();

            String key = accountCaptchaService.generateCaptchaKey();

            byte[] resultByte = accountCaptchaService.generateCaptchaImage(key);

            OutputStream stream = resp.getOutputStream();

            stream.write(resultByte);

            stream.flush();
        } catch (Exception e) {

            logger.error("生成验证码出错", e);
        }
    }
}

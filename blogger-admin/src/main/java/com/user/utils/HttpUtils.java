package com.user.utils;

import javax.servlet.http.HttpSession;

/**
 * 类备注：http工具类
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-20 22:09
 * @desc
 * @since 1.8
 */

public class HttpUtils {

    public static void putSession(HttpSession session, String key, Object value) throws Exception {

        session.setAttribute(key, value);
    }
}

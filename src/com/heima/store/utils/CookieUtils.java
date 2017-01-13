package com.heima.store.utils;

import javax.servlet.http.Cookie;

/**
 * Created by Feng on 2017/1/12.
 * Cookie工具类
 */
public class CookieUtils {
    /**
     * 从Cookies中获取指定的Cookie
     *
     * @param cookies
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        if (cookies==null||cookieName==null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }

        }
        return null;
    }
}

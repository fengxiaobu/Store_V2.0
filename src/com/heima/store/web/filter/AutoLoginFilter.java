package com.heima.store.web.filter;

import com.heima.store.domain.User;
import com.heima.store.service.UserService;
import com.heima.store.service.impl.UserServiceImpl;
import com.heima.store.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 自动登录
 * Created by Feng on 2017/1/12.
 */
@WebFilter(filterName = "AutoLoginFilter", urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    /**
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        User userBean = (User) request.getSession().getAttribute("userBean");
        if (userBean != null) {
            chain.doFilter(request, resp);
        } else {
            Cookie[] cookies = request.getCookies();
            Cookie autoLogin = CookieUtils.getCookie(cookies, "autoLogin");
            if (autoLogin == null) {
                chain.doFilter(request, resp);
            } else {
                String value = autoLogin.getValue();
                System.out.println("autoLogin:" + value);
                String[] strings = value.split("_");
                String username = strings[0];
                String password = strings[1];
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                UserService userService = new UserServiceImpl();
                try {
                    User userDomain = userService.login(user);
                    if (userDomain != null) {
                        request.getSession().setAttribute("userBean", userDomain);
                        chain.doFilter(request, resp);
                    } else {
                        chain.doFilter(request, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package com.heima.store.web.servlet;

import com.heima.store.domain.User;
import com.heima.store.service.UserService;
import com.heima.store.service.impl.UserServiceImpl;
import com.heima.store.utils.BaseServlet;
import com.heima.store.utils.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Feng on 2017/1/10.
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    private static UserService us = new UserServiceImpl();

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request, HttpServletResponse response) {
        try {
            //获得用户名,密码
            Map<String, String[]> parameterMap = request.getParameterMap();
            //封装数据
            User user = new User();
            BeanUtils.populate(user, parameterMap);
            //执行登录
            User userBean = us.login(user);
            System.out.println(userBean);
            if (userBean == null) {
                request.setAttribute("msg", "用户名或密码错误或账户未激活!");
                return "/UserServlet?method=loginUI";
            } else {
                String auto_login = request.getParameter("auto_login");
                String save_username = request.getParameter("save_username");
                if ("true".equals(auto_login)) {
                    //设置自动登录,把用户名和密码存入Cookie,保存一周
                    Cookie cookie = new Cookie("autoLogin", userBean.getUsername() + "_" + userBean.getPassword());
                    cookie.setPath(request.getContextPath());
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(cookie);
                }
                if ("true".equals(save_username)) {
                    //设置记住用户名,把用户名存入Cookie,保存一周
                    Cookie cookie = new Cookie("save_username", userBean.getUsername());
                    cookie.setPath(request.getContextPath());
                    cookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(cookie);
                }
                request.getSession().setAttribute("userBean", userBean);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * 跳转到注册页面
     *
     * @param request
     * @param response
     * @return
     */
    public String registerUI(HttpServletRequest request, HttpServletResponse response) {

        return "/client/register.jsp";
    }

    /**
     * 注册
     *
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            ConvertUtils.register(new MyDateConverter(), Date.class);
            BeanUtils.populate(user, parameterMap);
            System.out.println(user);
            int i = us.save(user);
            if (i > 0) {
                request.setAttribute("msg", "注册成功,请前往邮箱收取激活链接!");
                return "/client/msg.jsp";
            } else {

                return "/client/register.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 跳转登录页面
     *
     * @param request
     * @param response
     * @return
     */
    public String loginUI(HttpServletRequest request, HttpServletResponse response) {
        return "/client/login.jsp";
    }

    /**
     * 激活账户
     *
     * @param request
     * @param response
     * @return
     */
    public String active(HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = request.getParameter("code");

            User userBean = us.findByCode(code);
            if (userBean == null) {
                request.setAttribute("msg", "激活码错误!请重新激活!");
            } else {
                userBean.setCode(null);
                userBean.setState(1);//设置账户为激活状态
                us.update(userBean);
                request.setAttribute("msg", "激活成功!你可以登录了!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/client/msg.jsp";
    }

    /**
     * 退出
     *
     * @param request
     * @param response
     * @return
     */
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userBean");
        return "/client/index.jsp";
    }

    public String chackUsername(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        User userBean = null;
        try {

            userBean = us.chackUsername(username);
            System.out.println(userBean);
            if (userBean == null) {
                response.getWriter().println("0");
            } else {
                response.getWriter().println("1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

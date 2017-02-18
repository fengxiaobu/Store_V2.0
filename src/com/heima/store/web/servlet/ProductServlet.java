package com.heima.store.web.servlet;

import com.heima.store.domain.PageBean;
import com.heima.store.domain.Product;
import com.heima.store.service.ProductService;
import com.heima.store.utils.BaseServlet;
import com.heima.store.utils.BeanFactory;
import com.heima.store.utils.CookieUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Feng on 2017/1/13.
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends BaseServlet {
    private static ProductService productService = (ProductService) BeanFactory.getBean("productService");

    //查询分类商品信息
    public String findByCid(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currPage = Integer.parseInt(request.getParameter("currPage"));
            System.out.println("currPage = " + currPage);
            String cid = request.getParameter("cid");
            System.out.println("cid = " + cid);

            request.setAttribute("pageCid", cid);
            PageBean<Product> productList = productService.findByCid(cid, currPage);
            request.setAttribute("productList", productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/client/product_list.jsp";
    }

    public String clearHistry(HttpServletRequest request, HttpServletResponse response) {
        //String url = (String) request.getAttribute("url");
        String url = (String) request.getSession().getAttribute("url_list");
        System.out.println("url_list = " + url);
        Cookie cookie = new Cookie("history", "");
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询商品详情
     *
     * @param request
     * @param response
     * @return
     */
    public String findByPid(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pid = request.getParameter("pid");

            Product product = productService.findByPid(pid);

            Cookie[] cookies = request.getCookies();
            Cookie history = CookieUtils.getCookie(cookies, "history");
            if (history == null) {
                //记住浏览的商品
                Cookie cookie = new Cookie("history", pid);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);
            } else {
                String historyValue = history.getValue();
                String[] split = historyValue.split("_");
                LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
                //判断是否浏览过
                if (list.contains(pid)) {
                    //浏览过直接先移除,在添加到第一个
                    list.remove(pid);
                    list.addFirst(pid);
                } else {
                    if (list.size() >= 6) {
                        //超出6个 先移除最后一个,在添加到第一个
                        list.removeFirst();
                        list.addFirst(pid);

                    } else {
                        //记录没超出6个,直接添加到第一个
                        list.addFirst(pid);
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : list) {
                    stringBuffer.append(str).append("_");
                }
                System.out.println("list = " + list);
                //截取最后一个'_'
                String substring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                System.out.println("substring = " + substring);
                Cookie cookie = new Cookie("history", substring);
                cookie.setPath(request.getContextPath());
                cookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(cookie);
            }
            request.setAttribute("product", product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/client/product_info.jsp";
    }
}

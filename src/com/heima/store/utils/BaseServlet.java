package com.heima.store.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Feng on 2017/1/10.
 * 通用方法
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //获得方法名称
        String methodName = req.getParameter("method");
        System.out.println("方法名: " + methodName);
        if (methodName == null || "".equals(methodName)) {
            resp.getWriter().println("method参数为null!!!");
            return;
        }
        Class clazz = this.getClass();
        try {
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String path = (String) method.invoke(this, req, resp);
            if (path != null && path != "") {
                req.getRequestDispatcher(path).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


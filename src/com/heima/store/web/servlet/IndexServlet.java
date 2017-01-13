package com.heima.store.web.servlet;

import com.heima.store.utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Feng on 2017/1/11.
 */
@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends BaseServlet {
        public String  index(HttpServletRequest request, HttpServletResponse response){

            return "/client/index.jsp";
        }
}

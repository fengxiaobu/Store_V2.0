package com.heima.store.web.servlet;

import com.heima.store.domain.Product;
import com.heima.store.service.ProductService;
import com.heima.store.service.impl.ProductServiceImpl;
import com.heima.store.utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/11.
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/IndexServlet")
public class IndexServlet extends BaseServlet {
    private static ProductService productService = new ProductServiceImpl();

    public String index(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<Product> hotList = productService.findHot();
            List<Product> newList = productService.findNew();

            request.setAttribute("hotList", hotList);
            request.setAttribute("newList", newList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "/client/index.jsp";
    }
}

package com.heima.store.web.servlet;

import com.heima.store.domain.PageBean;
import com.heima.store.domain.Product;
import com.heima.store.service.ProductService;
import com.heima.store.service.impl.ProductServiceImpl;
import com.heima.store.utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Feng on 2017/1/13.
 */
@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends BaseServlet {
    private static ProductService productService = new ProductServiceImpl();

    public String findByCid(HttpServletRequest request, HttpServletResponse response) {
        try {
            Integer currPage = Integer.parseInt(request.getParameter("currPage"));
            System.out.println("currPage = " + currPage);
            String cid = request.getParameter("cid");
            System.out.println("cid = " + cid);


            PageBean<Product> productList = productService.findByCid(cid, currPage);
            request.setAttribute("productList",productList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/client/product_list.jsp";
    }
}

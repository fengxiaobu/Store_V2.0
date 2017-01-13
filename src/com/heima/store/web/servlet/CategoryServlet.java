package com.heima.store.web.servlet;

import com.heima.store.domain.Category;
import com.heima.store.service.CategoryService;
import com.heima.store.service.impl.CategoryServiceImpl;
import com.heima.store.utils.BaseServlet;
import net.sf.json.JSONArray;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 * 商品分类Servlet
 */
@WebServlet(name = "CategoryServlet", urlPatterns = "/CategoryServlet")
public class CategoryServlet extends BaseServlet {
    private static final CategoryService categoryService = new CategoryServiceImpl();

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> list=categoryService.finAll();
            JSONArray jsonArray = JSONArray.fromObject(list);
            System.out.println("jsonArray = " + jsonArray.toString());
            response.getWriter().print(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

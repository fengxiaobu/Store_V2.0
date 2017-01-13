package com.heima.store.service;

import com.heima.store.domain.PageBean;
import com.heima.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public interface ProductService {
    List<Product> findHot() throws SQLException;

    List<Product> findNew() throws SQLException;

    PageBean<Product> findByCid(String cid, Integer currPage) throws SQLException;
}

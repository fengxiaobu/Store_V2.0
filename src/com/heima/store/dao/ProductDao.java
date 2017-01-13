package com.heima.store.dao;

import com.heima.store.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public interface ProductDao {

    List<Product> findNew() throws SQLException;

    List<Product> findHot() throws SQLException;

    List<Product> findByCid(String cid, int begin, Integer pageSize) throws SQLException;

    Integer findCountByCid(String cid) throws SQLException;
}

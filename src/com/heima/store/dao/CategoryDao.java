package com.heima.store.dao;

import com.heima.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public interface CategoryDao {
    List<Category> finAll() throws SQLException;
}

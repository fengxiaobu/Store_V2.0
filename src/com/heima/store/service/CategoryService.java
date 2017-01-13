package com.heima.store.service;

import com.heima.store.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public interface CategoryService {
    List<Category> finAll() throws SQLException;
}

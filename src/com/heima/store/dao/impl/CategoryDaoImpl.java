package com.heima.store.dao.impl;

import com.heima.store.dao.CategoryDao;
import com.heima.store.domain.Category;
import com.heima.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> finAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category";
        List<Category> list = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        return list;
    }
}

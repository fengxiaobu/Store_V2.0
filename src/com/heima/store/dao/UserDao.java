package com.heima.store.dao;

import com.heima.store.domain.User;

import java.sql.SQLException;

/**
 * Created by Feng on 2017/1/11.
 */
public interface UserDao {
    User login(User user) throws SQLException;

    User chackUsername(String username) throws SQLException;

    int save(User user) throws SQLException;

    User findByCode(String code) throws SQLException;

    void update(User userBean) throws SQLException;

}

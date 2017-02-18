package com.heima.store.service.impl;

import com.heima.store.dao.UserDao;
import com.heima.store.domain.User;
import com.heima.store.service.UserService;
import com.heima.store.utils.BeanFactory;
import com.heima.store.utils.MailUtils;
import com.heima.store.utils.UUIDUtils;

import java.sql.SQLException;

/**
 * Created by Feng on 2017/1/10.
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = (UserDao) BeanFactory.getBean("userDao");

    public User login(User user) throws SQLException {
        return ud.login(user);
    }

    @Override
    public User chackUsername(String username) throws SQLException {
        return ud.chackUsername(username);
    }

    @Override
    public int save(User user) throws SQLException {
        user.setState(0);//0未激活,1激活
        user.setUid(UUIDUtils.getUUID());
        user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
        MailUtils.sendMail(user.getEmail(), user.getCode());
        return ud.save(user);
    }

    @Override
    public void update(User userBean) throws SQLException {
        ud.update(userBean);
    }

    @Override
    public User findByCode(String code) throws SQLException {

        return ud.findByCode(code);
    }
}

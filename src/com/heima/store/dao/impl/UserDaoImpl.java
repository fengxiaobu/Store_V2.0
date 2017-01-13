package com.heima.store.dao.impl;

import com.heima.store.dao.UserDao;
import com.heima.store.domain.User;
import com.heima.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Feng on 2017/1/10.
 */
public class UserDaoImpl implements UserDao {
    /**
     * 激活账户
     * @param userBean
     * @throws SQLException
     */
    @Override
    public void update(User userBean) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
        Object[] objects = {userBean.getUsername(), userBean.getPassword(), userBean.getName(), userBean.getEmail(), userBean.getTelephone(), userBean.getBirthday(), userBean.getSex(), userBean.getState(), userBean.getCode(),userBean.getUid()};
        queryRunner.update(sql, objects);
    }

    /**
     * 验证激活码
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public User findByCode(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where code=?";
        User userBean = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        return userBean;
    }

    /**
     * 登录
     * @param user
     * @return
     * @throws SQLException
     */
    public User login(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=? and password=? and state=1";
        Object[] objects = {user.getUsername(), user.getPassword()};
        User userBean = queryRunner.query(sql, new BeanHandler<User>(User.class), objects);
        return userBean;
    }

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     * @throws SQLException
     */
    @Override
    public User chackUsername(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=?";

        User userBean = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
        return userBean;
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int save(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = {user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode()};
        int update = queryRunner.update(sql, objects);
        return update;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("uerBean");
        return "/index.jsp";
    }
}

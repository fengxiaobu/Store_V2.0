package com.heima.store.dao.impl;

import com.heima.store.dao.ProductDao;
import com.heima.store.domain.Product;
import com.heima.store.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 新商品
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findNew() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pflag=? order  by pdate desc limit ?";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0, 9);
        return list;
    }

    /**
     * 热门商品
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findHot() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pflag=? and is_hot=? order  by pdate desc limit ?";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0, 1, 9);
        return list;
    }

    /**
     * 查询分类商品并分页显示
     *
     * @param cid
     * @param begin
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findByCid(String cid, int begin, Integer pageSize) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from product where pflag=? and  cid=?  order  by pdate desc limit ?,?";
        List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0, cid, begin, pageSize);
        return list;
    }

    /**
     * 总商品数
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    @Override
    public Integer findCountByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from product where pflag=? and cid=?";
        Long count = (Long) queryRunner.query(sql, new ScalarHandler(), 0, cid);
        return count.intValue();
    }
}

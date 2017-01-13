package com.heima.store.service.impl;

import com.heima.store.dao.ProductDao;
import com.heima.store.dao.impl.ProductDaoImpl;
import com.heima.store.domain.PageBean;
import com.heima.store.domain.Product;
import com.heima.store.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public class ProductServiceImpl implements ProductService {
    private static ProductDao productDao=new ProductDaoImpl();

    /**
     * 最热门商品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findHot() throws SQLException {
        return productDao.findHot();
    }

    /**
     * 最新商品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findNew() throws SQLException {
        return productDao.findNew();
    }

    /**
     * 分类显示
     * @param cid
     * @param currPage
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Product> findByCid(String cid, Integer currPage) throws SQLException {

        PageBean<Product> productPageBean = new PageBean<>();
        productPageBean.setCurrPage(currPage);
        Integer pageSize=12;
        productPageBean.setPageSize(pageSize);
        Integer totalCount=productDao.findCountByCid(cid);
        productPageBean.setTotalCount(totalCount);

        double dc=(double)totalCount;
        Double ceil = Math.ceil(dc / pageSize);
        productPageBean.setTotalPage(ceil.intValue());
        int begin=(currPage-1)*pageSize;
        List<Product> productList=productDao.findByCid(cid,begin,pageSize);
        productPageBean.setList(productList);

        return productPageBean;
    }

}

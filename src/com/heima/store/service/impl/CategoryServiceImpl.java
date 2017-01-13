package com.heima.store.service.impl;

import com.heima.store.dao.CategoryDao;
import com.heima.store.dao.impl.CategoryDaoImpl;
import com.heima.store.domain.Category;
import com.heima.store.service.CategoryService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Feng on 2017/1/13.
 */
public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 读取商品分类
     * @return
     * @throws SQLException
     */
    @Override
    public List<Category> finAll() throws SQLException {
        List<Category> list = null;
        CacheManager cacheManager = CacheManager.create(CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml"));
        Cache cache = cacheManager.getCache("categoryCache");

        Element element = cache.get("list");
        if (element == null) {
            System.out.println("缓存没有数据======");
            list = categoryDao.finAll();
            element = new Element("list", list);
            cache.put(element);
        } else {
            System.out.println("缓存有数据======");
            list = (List<Category>) element.getObjectValue();
        }
        return list;
    }
}

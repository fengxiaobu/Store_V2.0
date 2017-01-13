package com.heima.store.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Feng on 2017/1/10.
 * 连接池工具类
 */
public class JDBCUtils {
    private static final ComboPooledDataSource COMBO_POOLED_DATA_SOURCE = new ComboPooledDataSource();

    //获得连接对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = COMBO_POOLED_DATA_SOURCE.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //获得连接池
    public static DataSource getDataSource() {
        return COMBO_POOLED_DATA_SOURCE;
    }
}

package com.heima.store.domain;

/**
 * Created by Feng on 2017/1/10.
 * 商品订单中间表
 */
public class Orderitem {
    /**
     * `itemid` varchar(32) NOT NULL,
     `count` int(11) DEFAULT NULL,
     `subtotal` double DEFAULT NULL,
     `pid` varchar(32) DEFAULT NULL,
     `oid` varchar(32) DEFAULT NULL,
     */

    private String itemid;//ID
    private int count;//数量
    private double subtoal;//小计
    private String pid;//商品ID
    private String oid;//订单ID
}

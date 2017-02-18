package com.heima.store.domain;

/**
 * Created by Feng on 2017/1/10.
 * 商品订单中间表
 */
public class Orderitem {
    /**
     * `itemid` varchar(32) NOT NULL,
     * `count` int(11) DEFAULT NULL,
     * `subtotal` double DEFAULT NULL,
     * `pid` varchar(32) DEFAULT NULL,
     * `oid` varchar(32) DEFAULT NULL,
     */

    private String itemid;//ID
    private int count;//数量
    private Double subtotal;//小计
    private Product product;//商品
    private Orders orders;//订单

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}

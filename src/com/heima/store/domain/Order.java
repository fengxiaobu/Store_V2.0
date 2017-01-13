package com.heima.store.domain;

import java.util.Date;

/**
 * Created by Feng on 2017/1/10.
 * 订单
 */
public class Order {
    /**
     * `oid` varchar(32) NOT NULL,
     * `ordertime` datetime DEFAULT NULL,
     * `total` double DEFAULT NULL,
     * `state` int(11) DEFAULT NULL,
     * `address` varchar(30) DEFAULT NULL,
     * `name` varchar(20) DEFAULT NULL,
     * `telephone` varchar(20) DEFAULT NULL,
     * `uid` varchar(32) DEFAULT NULL,
     */
    private String oid;
    private Date ordertime;
    private double total;
    private int state;
    private String address;
    private String name;
    private String teltphone;
    private String uid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeltphone() {
        return teltphone;
    }

    public void setTeltphone(String teltphone) {
        this.teltphone = teltphone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

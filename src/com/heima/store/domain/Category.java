package com.heima.store.domain;

import java.io.Serializable;

/**
 * Created by Feng on 2017/1/10.
 * 商品种类
 */
public class Category implements Serializable{
    private String cid;//商品类型ID
    private String cname;//类型名称

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

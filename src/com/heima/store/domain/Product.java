package com.heima.store.domain;

import java.util.Date;

/**
 * Created by Feng on 2017/1/10.
 * 商品
 */
public class Product {
    /**
     * `pid` varchar(32) NOT NULL,
     `pname` varchar(50) DEFAULT NULL,
     `market_price` double DEFAULT NULL,
     `shop_price` double DEFAULT NULL,
     `pimage` varchar(200) DEFAULT NULL,
     `pdate` date DEFAULT NULL,
     `is_hot` int(11) DEFAULT NULL,
     `pdesc` varchar(255) DEFAULT NULL,
     `pflag` int(11) DEFAULT NULL,
     `cid` varchar(32) DEFAULT NULL,
     */
    private  String pid;//商品ID
    private String pname;//商品名称
    private double shop_price;//商城价格
    private double market_price;//市场价格
    private String pimage;//图片路径
    private Date pdate;//上架时间
    private int is_hot;//是否热门
    private String pdesc;//商品描述
    private int pflag;//是否下架
    private String cid;//商品类型

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}

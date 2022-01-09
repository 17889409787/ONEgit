package com.iuexam.entity;

import java.util.Date;
/**
 * 
 * 商品信息持久化类
 *
 */
public class Product {
    private String proid;  //商品id

    private String pname;  //名称

    private Double price;  //销售价格

    private Double inprice;  //进货价格

    private Date prodate;  //生产时间

    private Date reledate;  //过期时间

    private String supname;  //生产商名称

    private String protype;  //商品类型

    private String unit;  //计件方式

    private String marks;  //备注
    
    private Kcxx kcxx;
    
    public Kcxx getkcxx() {
		return kcxx;
	}

	public void setKcxx(Kcxx kcxx) {
		this.kcxx = kcxx;
	}

	public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }

    public Date getReledate() {
        return reledate;
    }

    public void setReledate(Date reledate) {
        this.reledate = reledate;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname == null ? null : supname.trim();
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype == null ? null : protype.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks == null ? null : marks.trim();
    }
}
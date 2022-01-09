package com.iuexam.entity;

import java.util.Date;
/**
 * 
 * 进货信息持久化类
 *
 */
public class Ckin {
    private String inid;  //订单id

    private String proid;  //商品id

    private String pname;  //名称

    private Integer num;  //数量

    private Date indate;  //进货日期

    private String marks;  //备注
    
    	public String getInid() {
        return inid;
    }

    public void setInid(String inid) {
        this.inid = inid == null ? null : inid.trim();
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks == null ? null : marks.trim();
    }
}
package com.iuexam.entity;
/**
 * 
 * 普通员工持久化类
 *
 */
public class Staff {
    private String staffid;  //员工id

    private String staffname;  //姓名

    private String card;  //身份证号

    private String sex;  //性别

    private String tel;  //手机号

    private String stafftype;  //身份类型

    private String pwd;  //密码

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid == null ? null : staffid.trim();
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getStafftype() {
        return stafftype;
    }

    public void setStafftype(String stafftype) {
        this.stafftype = stafftype == null ? null : stafftype.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

	@Override
	public String toString() {
		return "Staff [staffid=" + staffid + ", staffname=" + staffname + ", card=" + card + ", sex=" + sex + ", tel="
				+ tel + ", stafftype=" + stafftype + ", pwd=" + pwd + "]";
	}
    
}
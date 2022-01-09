package com.iuexam.entity;

import java.util.Calendar;
/**
 * 提醒持久化类
 */
import java.util.Date;

public class Attention {
	@Override
	public String toString() {
		return "Kcxx [proid=" + proid + ", pname=" + pname + ", num=" + num + ", marks=" + marks + "]";
	}

	private String proid;  //商品id

	private String pname;  //名称

	private Integer num;  //数量

	private String marks;  //备注

	static Product product;
	static Date now = new Date();

	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) 
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) 
				{
					timeDistance += 366;
				} else 
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else 
		{
			System.out.println("保质期day2 - day1 : " + (day2 - day1));
			return day2 - day1;
		}
	}

	public Product getProduct() {
		return product;
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

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks == null ? null : marks.trim();
	}

}
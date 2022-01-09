package com.iuexam.service;

import com.iuexam.entity.Manager;
import com.iuexam.entity.Staff;
/**
 * 
 * 管理员Service层接口
 *
 */
public interface IManagerService {
//	验证登录信息
	Manager getManager(String managerid,String pwd);
	
//	修改个人信息
	boolean update(Manager manager);
	
//	查看个人信息
	Manager getbyid(String managerid);
}
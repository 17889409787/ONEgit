package com.iuexam.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.iuexam.entity.Manager;
/**
 * 
 * 管理员Dao层接口
 *
 */
public interface ManagerMapper {
	
//	验证登录信息
	Manager getManager(@Param("managerid") String manageid);
	
//	修改个人信息
	boolean update(Manager manager);

//	查看个人信息
	Manager getbyid(String manageid);
	
	
}
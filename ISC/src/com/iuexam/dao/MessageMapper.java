package com.iuexam.dao;

import java.util.List;
import com.iuexam.entity.Message;
/**
 * 
 * 消息Dao层
 *
 */
public interface MessageMapper {

	
//	获取接收信息
	List<Message> selectByExample();

	int insert(Message record);
	
	
}

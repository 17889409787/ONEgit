package com.iuexam.service;

import java.util.List;
import com.iuexam.entity.Message;
/**
 * 
 * 消息Service层接口
 *
 */
public interface MessageService {

//	获取所有消息
public List<Message> getall();
	
//	获取所有提醒
public List<Message> getallattention();

//发布消息
public int insert(Message record);
	
}

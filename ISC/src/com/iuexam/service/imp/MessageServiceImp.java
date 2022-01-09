package com.iuexam.service.imp;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.iuexam.dao.MessageMapper;
import com.iuexam.entity.Message;
import com.iuexam.service.MessageService;

/**
 * 
 * 消息Service接口实现类
 *
 */
@Service
public class MessageServiceImp implements MessageService{
	@Resource
	private MessageMapper messageDao;

	public List<Message> getall() {
		
		// TODO Auto-generated method stub
		return messageDao.selectByExample();
	}

	public List<Message> getbyid(String message) {
		// TODO Auto-generated method stub
		return messageDao.selectByExample();
	}

	public List<Message> getallattention() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(Message record) {
		// TODO Auto-generated method stub
		return messageDao.insert(record);
	}

}

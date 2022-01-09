package com.iuexam.service.imp;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.iuexam.dao.AttentionMapper;
import com.iuexam.entity.Attention;
import com.iuexam.service.AttentionService;

@Service
public class AttentionServiceImp implements AttentionService {
	@Resource
	AttentionMapper attentionMapper;
	

	public int delete(String proid) {
		// TODO Auto-generated method stub
		return attentionMapper.delete(proid);
	}

	public List<Attention> selectAll() {
		// TODO Auto-generated method stub
		return attentionMapper.selectAll();
	}


	public int insert(Attention record) {
		// TODO Auto-generated method stub
		return attentionMapper.insert(record);
	}

}

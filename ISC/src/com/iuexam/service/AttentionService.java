package com.iuexam.service;
/**
 * 
 * 提醒Service层接口
 *
 */
import java.util.List;
import com.iuexam.entity.Attention;

public interface AttentionService {

	public List<Attention> selectAll();
	
	public int insert(Attention record);
	
	public int delete(String proid);

}

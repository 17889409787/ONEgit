package com.iuexam.dao;

import java.util.List;
import com.iuexam.entity.Attention;
/**
 * 
 * 提醒Dao层
 *
 */
public interface AttentionMapper {

    public int delete(String proid);
    
    public int insert(Attention record);
    
    public List<Attention> selectAll();
}

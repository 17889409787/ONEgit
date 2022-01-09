package com.iuexam.service;

import java.util.List;

import com.iuexam.entity.Kcxx;
/**
 * 
 * 库存信息Service层接口
 *
 */
public interface IKcxxService {
	int delete(String proid);

    int insert(Kcxx record);

    List<Kcxx> getall();

    Kcxx getbyid(String proid);
    
    List<Kcxx> selectAll();

    Boolean update(Kcxx record);
    
    Kcxx kcxxWithPro(String proid);
    
    List<Kcxx> kcxxWithPronum();
    
    List<Kcxx> kcxxWithProdata();
    
    List<Kcxx> getbyparams(String proid,String pname);

}

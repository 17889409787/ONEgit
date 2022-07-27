package com.unit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

//import cn.edu.neu.model.Category;
import cn.edu.neu.model.Goods;
import cn.edu.neu.service.GoodsService;
import cn.edu.neu.service.HomeService;

@WebServlet("*.action")

public class GoodsController extends HttpServlet {

    public GoodsController() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	//@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getServletPath();
				//�µ���Ʒ�ƶ��˽ӿ�json	
		if(url.equals("/goods/newGoodsForMobile.action")){
			resp.setContentType("text/json; charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			List<Goods> goodslist=new ArrayList<Goods>();
			goodslist=GoodsService.getNewgoods();

			ObjectMapper mapper = new ObjectMapper(); 
	        String jsonlist = mapper.writeValueAsString(goodslist);  
	        System.out.println(jsonlist);  
			out.print(jsonlist);
			out.flush();
		}
		else if(url.equals("/goods!searchGoodsJson.action")){
			resp.setContentType("text/json; charset=utf-8");
			PrintWriter out = resp.getWriter();
			String goodsname=req.getParameter("kw");
			System.out.println(goodsname); 
			List<Goods> goodslist=new ArrayList<Goods>();
			goodslist=GoodsService.getSearchGoods(goodsname);

			ObjectMapper mapper = new ObjectMapper(); 
	        String jsonlist = mapper.writeValueAsString(goodslist);  
	        System.out.println(jsonlist);  
			out.print(jsonlist);
			out.flush();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.iuexam.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iuexam.entity.Attention;
import com.iuexam.entity.Ckin;
import com.iuexam.entity.Kcxx;
import com.iuexam.entity.Message;
import com.iuexam.service.AttentionService;
import com.iuexam.service.IKcxxService;
import com.iuexam.service.MessageService;
import com.iuexam.service.imp.AttentionServiceImp;
import com.iuexam.service.imp.MessageServiceImp;

/**
 * 消息控制器类
 *
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	@Autowired
	MessageServiceImp messageServiceImp;
	@Autowired
	IKcxxService kcxxService;
	@Autowired
	AttentionService attentionService;
	@Autowired
	AttentionServiceImp attentionServiceImp;

//跳转到通告页面-管理员
    @RequestMapping("/postmessage")  
    public String postmessage(HttpServletRequest request,Map<String, Object> msg){    
    	List l = messageService.getall();
    	System.out.println(l.get(0));
    	msg.put("sendname", l);
        return "postmessage";  
    }
//跳转到提醒页面-管理员
    @RequestMapping("/attention")  
    public String attention(HttpServletRequest request,Model model,Map<String,Object> map){
    	List<Attention> l = attentionService.selectAll();
        map.put("proid", l);
        for(Attention k : l) {
        	System.out.println(k);
        }
        return "attention";   
    }
//跳转到消息页面-普通员工
    @RequestMapping("/getmessage")  
    public String getbyid1(String send,HttpServletRequest request,Map<String, Object> msg){    
    	List l = messageService.getall();
    	System.out.println(l.get(0));
    	msg.put("sendname", l);
        return "message";  
    } 
//跳转到提醒进货信息页面-普通员工
    @RequestMapping("/atnckin")  
  public String atnckin (){  
  	return "atnckin";

  }
    
//新增消息-数据库
    @RequestMapping("/insert_msg")  
    public String insert_msg (Message message,HttpServletRequest request,Model model){  
    		messageServiceImp.insert(message);    		
    	return "redirect:postmessage";
    }
//新增提醒-数据库
    @RequestMapping("/insert_atn")  
    public String insert_atn (Attention attention,HttpServletRequest request,Model model){  
    		attentionServiceImp.insert(attention);    		
    	return "kcxx_warn";
    } 
//删除提醒-数据库
    @RequestMapping("/delete")  
    public String delete(String proid) {
    	attentionServiceImp.delete(proid);
    	return "redirect:attention";
    } 

    
}

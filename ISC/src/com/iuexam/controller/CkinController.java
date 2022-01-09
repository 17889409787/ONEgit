package com.iuexam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iuexam.entity.Ckin;
import com.iuexam.entity.Kcxx;
import com.iuexam.service.ICkinService;
import com.iuexam.service.imp.CkinServiceImp;
/**
 * 
 * 进货信息控制器类
 *
 */
@Controller
@RequestMapping("/ckin")
public class CkinController {
	@Autowired
	CkinServiceImp ckinServiceImp;
	@Autowired
	ICkinService ckinService;

//跳转到进货信息页面
    @RequestMapping("/getckin")  
    public String getckin(HttpServletRequest request,Map<String,Object> map){  
    	List<Ckin> l = ckinService.getall();
    	map.put("inid", l);
    	for(Ckin c : l) {
    		System.out.println(c);
    	}
        return "ckin";  
    }
//跳转到修改进货信息页面
	@RequestMapping("edit")
	public String edit(Ckin ckin,HttpServletRequest request,Model model){
		model.addAttribute("ckin", ckinServiceImp.getbyid(ckin.getInid()));
		return "editckin";
	}	
//跳转到新增进货信息页面
    @RequestMapping("/toadd")  
  public String toadd (){  
  	return "addckin";

  } 


 //新增库存信息-数据库（先判断数据库有没有，有就更新，没有就新增）
    @RequestMapping("/insert")  
    public String insert (Ckin	ckin,HttpServletRequest request,Model model){  
    	if(null==ckinServiceImp.getbyid(ckin.getInid())) {
        	ckinServiceImp.insert(ckin);    		
    	}else {
    		ckinServiceImp.update(ckin);
    	}
    	return "redirect:getckin";

    } 
//删除库存信息-数据库
    @RequestMapping("/delete")  
    public String deletete(String inid,HttpServletRequest request,Model model){  
    	ckinServiceImp.delete(inid);
        return "redirect:getckin";  
    } 
//更新库存信息-数据库
	@RequestMapping("update")
	public String update(Ckin ckin,HttpServletRequest request,Model model){  
    	if(ckinServiceImp.update(ckin)) {
    		ckin=ckinServiceImp.getbyid(ckin.getInid());
    		model.addAttribute("ckin", ckin);
    		return "redirect:getckin"; 
    	}
    	return null;    
    } 
	
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
//按条件获取所有进货信息
	@RequestMapping("getbyparams")
	public String getbyparams(HttpServletRequest request,Model model,@RequestParam(value="proid",required=false)String proid,
    		@RequestParam(value="inid",required=false)String inid,@RequestParam(value="pname",required=false)String pname,
    		@RequestParam(value="indate",required=false)String indate)  {
		return null;
		
	}
}


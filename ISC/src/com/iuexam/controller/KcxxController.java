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
import org.springframework.web.bind.annotation.ResponseBody;

import com.iuexam.entity.Kcxx;
import com.iuexam.service.IKcxxService;
import com.iuexam.service.imp.KcxxServiceImp;
/**
 * 
 * 库存信息控制器类
 *
 */
@Controller
@RequestMapping("/kcxx")
public class KcxxController {
	@Autowired
	KcxxServiceImp kcxxServiceImp;
	@Autowired
	IKcxxService kcxxService;
	
//跳转到库存信息页面-管理员
    @RequestMapping("/getkcxx")  
    public String getkcxx_A(HttpServletRequest request,Model model,Map<String,Object> map){  
//        request.setAttribute("kcxx", kcxxServiceImp.selectByPrimaryKey(proid));
//        model.addAttribute("kcxx",kcxxServiceImp.selectByPrimaryKey(proid));
    	List<Kcxx> l = kcxxService.getall();
    	map.put("proid", l);
    	for(Kcxx k : l) {
    		System.out.println(k);
    	}
    	return "kcxx";  
    }
//跳转到库存预警页面-普通员工
    @RequestMapping("/getkcxx_warn")  
    public String getkcxx_warn(HttpServletRequest request,Map<String,Object> map){  
    	List<Kcxx> l = kcxxService.selectAll();
    	map.put("proid", l);
    	for(Kcxx k : l) {
    		System.out.println(k);
    	}
    	return "kcxx_warn"; 
    }

//新增库存信息-数据库  
    @RequestMapping("/insert")  
    public String insert(Kcxx kcxx,HttpServletRequest request,Model model){  
    	if(null==kcxxServiceImp.getbyid(kcxx.getProid())) {
    		kcxxServiceImp.insert(kcxx);    		
    	}else {
    		kcxxServiceImp.update(kcxx);
    	}
    	return "redirect:getall";

    } 
//删除库存信息-数据库
    @RequestMapping("/delete")
    public String delete(String proid) {
    	kcxxServiceImp.delete(proid);
    	return "redirect:getall";
    }
//修改库存信息-数据库
    @RequestMapping("/update")
    public String update(Kcxx kcxx,HttpServletRequest request,Model model){
    	if(kcxxServiceImp.update(kcxx)) {
    		kcxx=kcxxServiceImp.getbyid(kcxx.getProid());
    		model.addAttribute("kcxx", kcxx);
    		return "redirect:getall"; 
    	}
    	return null;
    }    
//根据条件查询
  	@RequestMapping("getbyparams")
  	public String getbyparams(HttpServletRequest request,Model model,@RequestParam(value="proid",required=false)String proid,
      		@RequestParam(value="pname",required=false)String pname)  {
  		return null;
  		
  	}

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


}

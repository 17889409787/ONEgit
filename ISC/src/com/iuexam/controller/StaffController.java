package com.iuexam.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iuexam.entity.Kcxx;
import com.iuexam.entity.Staff;
import com.iuexam.service.IStaffService;
import com.iuexam.service.imp.StaffServiceImp;
import com.iuexam.tools.Constants;
/**
 * 
 * 普通员工控制器类
 *
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffServiceImp staffServiceImp;
	@Autowired
	IStaffService istaffService;
	
//登录
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("loginname") String staffid,@RequestParam("password") String pwd,
			HttpSession session,HttpServletRequest request) {
		Staff staff=staffServiceImp.getStaff(staffid, pwd);
		if(staff!=null) {
			//登录成功
			session.setAttribute(Constants.Staff_SESSION, staff);		//session 添加员工信息
			session.setAttribute("staffid", staff.getStaffid());
			session.setAttribute("staffname", staff.getStaffname());		//session 添加员工信息
			session.setAttribute("card", staff.getCard());
			session.setAttribute("sex", staff.getSex());
			session.setAttribute("tel", staff.getTel());
			session.setAttribute("stafftype", staff.getStafftype());
			session.setAttribute("pwd", staff.getPwd());
			return "redirect:/staff/flatform/WEB-INF/jsp/";
		}else {
			//登录失败
			request.setAttribute("error", "您的账号或密码错误");
			return "error";
		}
	}
	@RequestMapping(value="/flatform/WEB-INF/jsp/")
	//验证是否有session信息，防止非法登录，没有就跳转到登录页面
	public String main(HttpSession session,HttpServletRequest request) {
		if(session.getAttribute(Constants.Staff_SESSION)==null)		//登录失败返回登录界面
		{
			return "redirect:/staff/login";
		}
		return "home_B";
	}
//退出登录
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		//退出清除esison
		session.removeAttribute(Constants.Staff_SESSION);
		return "login";
		
	}
	
//跳转到主页
	@RequestMapping(value="/gethome_B")
	public String gethome_B(){
     return "home_B"; 	
	}
//跳转到个人信息修改页面
	@RequestMapping("/getinformation")
	public String getinformation(String staffid,HttpServletRequest request,Model model){
		 request.setAttribute("staff", staffServiceImp.getbyid(staffid));
	     model.addAttribute("staff",staffServiceImp.getbyid(staffid));  
	     return "information"; 	
	}	
//跳转到修改个人信息页面
	@RequestMapping("/editinformation")
	public String editinformation(){
		return "editinformation"; 
	}
//跳转到员工信息页面
	@RequestMapping("/getstaff")
	public String getstaff(HttpServletRequest request,Model model,Map<String,Object> map){
    	List<Staff> l = istaffService.getall();
    	map.put("staffid", l);
    	for(Staff s : l) {
    		System.out.println(s);
    	}
    	return "staff";		
	}
//跳转到修改员工信息页面
    @RequestMapping("/toupdate")  
	public String editstaff(Staff staff,HttpServletRequest request,Model model){
		model.addAttribute("staff", staffServiceImp.getbyid(staff.getStaffid()));
		return "editstaff";
	}
//跳转到新增员工信息页面	
  @RequestMapping("/toadd")  
  public String toadd(){  
  	return "addstaff";

  } 
	
//新增员工信息-数据库（先判断数据库有没有，有就更新，没有就新增）
    @RequestMapping("/insert")  
    public String insert(Staff staff,HttpServletRequest request,Model model){  
    	if(null==staffServiceImp.getbyid(staff.getStaffid())) {
    		staffServiceImp.insert(staff);    		
    	}else {
    		staffServiceImp.update(staff);
    	}
    	return "redirect:getstaff";

    } 

//删除员工信息-数据库
    @RequestMapping("/delete")
    public String delete(String staffid) {
    	staffServiceImp.delete(staffid);
    	return "redirect:getstaff";
    }

//更新员工信息-数据库
   	@RequestMapping("/update")
       public String update(Staff staff,HttpServletRequest request,Model model){
       	if(staffServiceImp.update(staff)) {
       		staff=staffServiceImp.getbyid(staff.getStaffid());
       		model.addAttribute("custom", staff);
       		return "redirect:getstaff"; 
       	}
       	return null;
       }    
//根据条件查询-数据库
  @RequestMapping("getbyparams")
  public String getbyparams(@RequestParam(value="staffname",required=false)String staffname,@RequestParam(value="staffid",required=false)String staffid,
	@RequestParam(defaultValue="1",required=true,value="pn") Integer pn,HttpServletRequest request,Model model
		) {
	return "getstaffbyparams";
 
  }

}


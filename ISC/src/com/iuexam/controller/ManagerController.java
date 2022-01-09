package com.iuexam.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.iuexam.entity.Kcxx;
import com.iuexam.entity.Manager;
import com.iuexam.entity.Staff;
import com.iuexam.service.imp.KcxxServiceImp;
import com.iuexam.service.imp.ManagerServiceImp;
import com.iuexam.service.imp.StaffServiceImp;
import com.iuexam.tools.Constants;
/**
 * 
 * 管理员控制器类
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	ManagerServiceImp managerServiceImp;
	@Autowired
	StaffServiceImp staffServiceImp;
	@Autowired
	KcxxServiceImp kcxxServiceImp;
//登录
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("loginname") String managerid,@RequestParam("password") String pwd,
			HttpSession session,HttpServletRequest request) {
		Manager manager=managerServiceImp.getbyid(managerid);
		if(manager != null && manager.getPwd().equals(pwd)) {
			//登录成功
			session.setAttribute(Constants.Manager_SESSION, manager);		//session 添加员工信息
			System.out.println(manager.getManagername());
			session.setAttribute("managername", manager.getManagername());		//session 添加员工信息
			return "redirect:/manager/flatform/WEB-INF/jsp/";
		}else {
			//登录失败
			request.setAttribute("error", "您的账号或密码错误");
			return "error";
		}
	}
	@RequestMapping(value="/flatform/WEB-INF/jsp/")
	public String main(HttpSession session,HttpServletRequest request) {
		//验证是否有session信息，防止非法登录，没有就跳转到登录页面
		if(session.getAttribute(Constants.Manager_SESSION)==null)
		{
			return "redirect:/manager/login";
		}
		return "home_A";
	}
//退出登录
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		//退出清除esison
		session.removeAttribute(Constants.Manager_SESSION);
		session.invalidate();
		return "login";
		
	}
//跳转到主页
	@RequestMapping(value="/gethome_A")
	public String gethome_A(){
     return "home_A"; 	
	}
//跳转到增加员工信息页面	
  @RequestMapping("/toadd")  
  public String toadd(){  
  	return "addstaff";

  } 
//跳转到修改员工信息页面
  @RequestMapping("/toupdatestaff")  
	public String editstaff(Staff staff,HttpServletRequest request,Model model){
		model.addAttribute("staff", staffServiceImp.getbyid(staff.getStaffid()));
		return "editstaff";
	}  
  
//修改员工信息
	@RequestMapping("/updatestaff")
    public String updatestaff(Staff staff,HttpServletRequest request,Model model){
    	if(staffServiceImp.update(staff)) {
    		staff=staffServiceImp.getbyid(staff.getStaffid());
    		model.addAttribute("staff", staff);
    		return "redirect:getall"; 
    	}
    	return null;
    }
// 先判断数据库有没有，有就更新，没有就新增  
    @RequestMapping("/insert")  
    public String insert(Staff staff,HttpServletRequest request,Model model){  
    	if(null==staffServiceImp.getbyid(staff.getStaffid())) {
    		staffServiceImp.insert(staff);    		
    	}else {
    		staffServiceImp.update(staff);
    	}
    	return "redirect:getall";

    } 
//删除   
    @RequestMapping("/delete")
    public String delete(String staffid) {
    	staffServiceImp.delete(staffid);
    	return "redirect:getall";
    }


}

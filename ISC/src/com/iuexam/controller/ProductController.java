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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iuexam.entity.Kcxx;
import com.iuexam.entity.Product;
import com.iuexam.service.IProductService;
import com.iuexam.service.imp.ProductServiceImp;
/**
 * 
 * 商品信息控制器类
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductServiceImp productServiceImp;
	@Autowired
	IProductService productService;
	
	
//跳转到商品信息页面-管理员
    @RequestMapping("/getpro_A")  
    public String getpro_A(HttpServletRequest request,Map<String,Object> map){  
    	List<Product> l = productService.getlist();
    	map.put("proid", l);
    	for(Product p : l) {
    		System.out.println(p);
    	} 
        return "product_A";  
    }
//跳转到商品信息页面-普通员工
    @RequestMapping("/getpro_B")  
    public String getpro_B(HttpServletRequest request,Map<String,Object> map){  
    	List<Product> l = productService.getlist();
    	map.put("proid", l);
    	for(Product p : l) {
    		System.out.println(p);
    	} 
    	return "product_B";  
    }
//跳转到修改商品信息页面
	@RequestMapping("editpro_A")
	public String editProduct_A(Product pro,HttpServletRequest request,Model model){
		model.addAttribute("product", productServiceImp.selectByPrimaryKey(pro.getProid()));
		return "editpro_A";
	}
//  跳转到新增商品页面
    @RequestMapping("/toaddpro_A")  
  public String toaddpro_A(){  
  	return "addpro_A";
  }     
    
//新增商品信息-数据库（先判断数据库有没有，有就更新，没有就新增）-管理员
    @RequestMapping("/insert_A")  
  public String insertpro_A(Product product,HttpServletRequest request,Model model){  
  	if(null==productServiceImp.selectByPrimaryKey(product.getProid())) {
      	productServiceImp.insert(product);   
      	return "redirect:getpro_A";
  	}else {
  		request.setAttribute("msg", "新增失败，系统中存在该id的商品，请重新输入！");
  		return "toaddpro_A";
  	}
  } 
//删除商品信息-数据库(管理员）
    @RequestMapping("/delete_A")  
    public String deletetepro_A(String proid,HttpServletRequest request,Model model){  
    	productServiceImp.deleteByPrimaryKey(proid);
        return "redirect:getpro_A";  
    }
//修改商品信息-数据库(管理员）
	@RequestMapping("update_A")
	public String updatepro_A(Product product,HttpServletRequest request,Model model){  
    	if(productServiceImp.updateByPrimaryKey(product)) {
    		product=productServiceImp.selectByPrimaryKey(product.getProid());
    		model.addAttribute("product", product);
    		return "redirect:getpro_A"; 
    	}
    	return null;  
    }   
//根据条件查询-数据库
    @RequestMapping("/getbyparams")  
    public String getbyparams(HttpServletRequest request,Model model,@RequestParam(value="proid",required=false)String proid,
    		@RequestParam(value="pname",required=false)String pname,
    		@RequestParam(value="protype",required=false)String protype
    		){
		return "getprobyparams";  
    }

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    
}

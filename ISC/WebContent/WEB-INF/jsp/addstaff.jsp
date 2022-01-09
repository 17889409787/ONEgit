<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
    <div class="right_col" role="main"> 
	<form class="form-horizontal form-label-left"  method="post" action="insert" onsubmit="return checkall()" >
    <div class="top">
    <div class="top_content">
      <div class="header">新增员工信息</div>
    </div>
    </div>
    <div class="form">
                      <div>
                        <label>员工id<span >*</span>
                        </label>
                        <div>
                          <input id="staffid" name="staffid"value=""  type="text"  >
                        </div>
                      </div>
                      <div>
                        <label >姓名<span >*</span>
                        </label>
                        <div >
                          <input id="staffname" name="staffname" value=""  type="text" onblur="checkname()" ><span id="demo1" style="color: red;"></span>
                        </div>
                      </div>
                      <div >
                        <label >身份证 <span >*</span>
                        </label>
                        <div >
                          <input id="card" name="card" value=""  type="text" onblur="checkcard()" ><span id="demo2" style="color: red;"></span>
                        </div>
                      </div>
                      <div >
                        <label >性别 <span >*</span>
                        </label>
                        <div >
                          <input id="sex" name="sex" value=""  type="text"  >                        
                      </div>
                      	</div>
                      <div >
                        <label >电话<span >*</span>
                        </label>
                        <div >
                          <input id="tel" name="tel" value="" type="text" onblur="checktel()" >   <span id="demo3" style="color: red;"></span>                     
                          </div>
                      </div>
                      <div >
                        <label >身份类型<span >*</span>
                        </label>
                        <div >
                          <input id="stafftype" name="stafftype" value="" type="text"  >
                        </div>
                      </div>
                       <div >
                        <label >密码<span >*</span>
                        </label>
                        <div >
                          <input id="pwd" name="pwd"  value=""  type="password" placeholder="请填写密码"  >
                        </div>
                      </div> 
                      <div >
                        <label  >密码<span >*</span>
                        </label>
                        <div >
                          <input id="pwd2" name="pwd2" type="password" placeholder="请再次填写密码"  onkeyup="validate()"><span id="tishi"></span>
                        </div>
                      </div>                     
                      </div>
						<a onclick="javascript:history.back(-1);" class="btn " role="button">返回上页</a>
						<a href="#" class="btn" role="button">添加</a>							                      
                    </form>
</div>
<%@include file="frame/footer_A.jsp"%>
<script type="text/javascript">
	function checkname(){
		var name= document.getElementById('staffname').value;
		var regName =/^[\u4e00-\u9fa5]{2,4}$/; 
		if(!regName.test(name)){  
			document.getElementById("demo1").innerHTML="请输入正确的姓名！"; 
		     return false;  
		 } 
		else{
			document.getElementById("demo1").innerHTML=" "; 
		     return true;  
		}
	}
	function checkcard(){
		var card= document.getElementById('card').value;
		var regIdNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
		if(!regIdNo.test(card)){  
			document.getElementById("demo2").innerHTML="请输入正确的身份证！"; 
		    return false;  
		}  
		else{
			document.getElementById("demo2").innerHTML=" "; 
		     return true;  
		}
	}
	function checktel()
	{
	   var tel= document.getElementById('tel').value;
	   var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
	    var isMob= /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
	    if(isMob.test(tel)||isPhone.test(tel)){
	    	document.getElementById("demo3").innerHTML=" ";
	        return true;
	    }
	    else{
	    	document.getElementById("demo3").innerHTML="请输入正确的电话 ";
	        return false;
	    }
	   }
	function validate() {
	    var pwd1 = document.getElementById("pwd").value;
	    var pwd2 = document.getElementById("pwd2").value;
	 
	    if(pwd1 == pwd2)
	     {
	        document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
	        document.getElementById("button").disabled = false;
	     }
	else {
	        document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
	        document.getElementById("button").disabled = true;
	     }
	}
	/* 验证整个表单 */
	function checkall(){
		var name=checkname();
		var tel=checktel();
		var card=checkcard();
		if(name&&tel&&card){
			 alert("添加成功"); 
			 return true;
		}else{  
	 			alert("添加失败");
			    return false;
		 			
			}  
	}
</script>
<%@include file="frame/footer_A.jsp"%>
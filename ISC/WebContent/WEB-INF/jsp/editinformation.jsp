<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
    <div class="right_col" role="main"> 
	<form class="form-horizontal form-label-left" method="post" onsubmit="return checkall()">
    <div class="top">
    <div class="top_content">
      <div class="header">修改个人信息</div>
    </div>
    </div>
    <div class="form">
                      <div>
                        <label>员工id<span >*</span>
                        </label>
                        <div>
                          <input id="staffid" name="staffid" value="${staff.staffid}"  type="text"  >
                        </div>
                      </div>
                      <div>
                        <label >姓名<span >*</span>
                        </label>
                        <div >
                          <input id="staffname" name="staffname" value="${staff.staffname}"  type="text" onblur="checkname()" ><span id="demo1" style="color: red;"></span>
                        </div>
                      </div>
                      <div >
                        <label >身份证 <span >*</span>
                        </label>
                        <div >
                          <input id="card" name="card" value="${staff.card}"  type="text" onblur="checkcard()" ><span id="demo2" style="color: red;"></span>
                        </div>
                      </div>
                      <div >
                        <label >性别 <span >*</span>
                        </label>
                        <div >
                          <input id="sex" name="sex" value="${staff.sex}"  type="text"  >                        
                      </div>
                      	</div>
                      <div >
                        <label >电话<span >*</span>
                        </label>
                        <div >
                          <input id="tel" name="tel" value="${staff.tel}" type="text" onblur="checktel()" >   <span id="demo3" style="color: red;"></span>                     
                          </div>
                      </div>
                      <div >
                        <label >身份类型<span >*</span>
                        </label>
                        <div >
                          <input id="stafftype" name="stafftype" value="${staff.stafftype}" type="text"  >
                        </div>
                      </div>
                       <div >
                        <label >密码<span >*</span>
                        </label>
                        <div >
                          <input id="pwd" name="pwd"  value="${staff.pwd}"  type="password" placeholder="请填写密码"  >
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
						<button type="submit" class="btn" >修改</button>								                      
                    </form>
	</div>
<script>
function checknum()
{
	var num = document.getElementById('num').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo4").innerHTML=" ";
		return true;
		}else{
			document.getElementById("demo4").innerHTML="请输入正确的商品数量！";
			document.getElementById('num').value="";
			document.getElementById('num').focus();
			return false;
			}
		}
else{
		document.getElementById("demo4").innerHTML="请输入商品数量！";
	document.getElementById('num').focus();
	return false;
	}
}
/* 校验整个表单 */
function checkall(){
	         var num=checknum(); 
	         
	         if(num){  
				 alert("提交成功，请等待审核"); 
	             return true;
	         }else{  
		 			alert("提交失败，请重新填写数据");
	             return false;
	 			
	         }  
}
</script>
<%@include file="frame/footer_B.jsp"%>
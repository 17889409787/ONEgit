<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
    <div class="right_col" role="main"> 
	<form class="form-horizontal form-label-left" method="post" action="update_A" onsubmit="return checkall()">
    <div class="top">
    <div class="top_content">
      <div class="header">修改商品信息</div>
    </div>
    </div>
    <div class="form">
   						 <div>
                        <label>商品id<span >*</span>
                        </label>
                        </div>
                        <div>
                          <input id="proid" name="proid"  value="${product.proid}"  type="text" onblur="checkid()"><span id="demo4" style="color: red;"></span>
                        </div>
                      <div>
                        <label>名称<span >*</span>
                        </label>
                        </div>
                        <div>
                          <input id="pname" name="pname" value="${product.pname}"  type="text" onblur="check()"><span id="demo1" style="color: red;"></span>
                        </div>                   
                      <div>
                        <label>售价 <span >*</span>
                        </label>
                        <div>
                          <input id="price" name="price" value="${product.price}"  type="text" onblur="ischeckNum()"><span id="demo2" style="color: red;"></span>
                        </div>
                      </div>
                      <div>
                        <label >进价 <span >*</span>
                        </label>
                        <div >
                          <input id="inprice"  name="inprice" value="${product.inprice}"  type="text" onblur="ischeckinprice()">  <span id="demo3" style="color: red;"></span>                      
                      </div>
                      	</div>
                     <div>
                        <label >生产日期<span >*</span>
                        </label>
                        <div >
                          <input id="prodate"  name="prodate" value="${product.prodate}" type="date"/>                        
                          </div>
                      </div>
                      <div >
                        <label >过期时间<span >*</span>
                        </label>
                        <div>
                          <input id="reledate" name="reledate"  value="${product.reledate}" type="date"/>
                        </div>
                      </div> 
                       <div>
                        <label >供应商名称<span >*</span>
                        </label>
                        <div>
                          <input id="supname" name="supname" value="${product.supname}"  type="text">
                        </div>
                      </div>                      
                      <div>
                        <label >商品类型<span >*</span>
                        </label>
                        <div>
                          <input id="protype"  name="protype"value="${product.protype}" type="text" >
                        </div>
                      </div>                      
                        <div>
                        <label>计件方式<span >*</span>
                        </label>
                        <div>
                          <input id="unit"  name="unit" value="${product.unit}"  type="text" >
                        </div>
                        </div> 
                        <div >
                        <label >备注<span >*</span>
                        </label>
                        <div>
                        </div>
                          <input id="marks" name="marks"value="${product.marks}"  type="text" >
                          <a onclick="javascript:history.back(-1);" class="btn"  role="button">返回上页</a>
						<button type="submit" class="btn" >修改</button>			
                        </div>
                        </div>  					                      
                    </form>
                    </div>
<script>
/*判断输入id是不是数字  */
function checkid()
{
	var num = document.getElementById('proid').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo4").innerHTML=" ";
		return true;
		}else{
			document.getElementById("demo4").innerHTML="请输入正确的id！";
			document.getElementById('proid').value="";
			document.getElementById('proid').focus();
			return false;
			}
		}
else{
		document.getElementById("demo4").innerHTML="请输入正确的id！";
	document.getElementById('proid').focus();
	return false;
	}
}
/*  校验商品名称*/
function check(){
	var name=document.getElementById('pname').value;
   	if(name){
	document.getElementById("demo1").innerHTML=" ";
	return true;
}else{
	document.getElementById("demo1").innerHTML="请输入商品名称！";
	document.getElementById('pname').focus();
	return false;
}
}


/*判断输入的价格是不是数字  */
function ischeckNum()
{
	var num = document.getElementById('price').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo2").innerHTML=" ";
				return true;
		}else{
			document.getElementById("demo2").innerHTML="你输入的数据不是数字！";
			document.getElementById('price').value="";
			document.getElementById('price').focus();
			return false;
			}
		}
else{
		document.getElementById("demo2").innerHTML="请输入商品售价！";
	document.getElementById('price').focus();
	return false;
	}
}
function ischeckinprice()
{
	var num = document.getElementById('inprice').value;
	if( num )
		{
		if( !isNaN( num ) )
			{
				document.getElementById("demo3").innerHTML=" ";
				return true;
		}else{
			document.getElementById("demo3").innerHTML="你输入的数据不是数字！";
			document.getElementById('inprice').value="";
			document.getElementById('inprice').focus();
			return false;
			}
		}
else{
		document.getElementById("demo3").innerHTML="请输入商品售价！";
	document.getElementById('inprice').focus();
	return false;
	}
}
/* 校验整个表单 */
function checkall(){
			 var id=checkid();
	         var name = check();  
	         var price = ischeckNum();  
	         var inprice = ischeckinprice();  
	         
	         if(price&&name&&inprice){  
				 alert("修改成功"); 
	             return true;
	         }else{  
		 			alert("修改失败，请重新填写数据");
	             return false;
	 			
	         }  
}
</script>
<script src="${pageContext.request.contextPath}/statics/localjs/addpro.js"></script>
<%@include file="frame/footer_A.jsp"%>

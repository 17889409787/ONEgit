<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
    <div class="right_col" role="main"> 
	<form method="post" action="insert_atn" onsubmit="return checkall()">
    <div class="top">
    <div class="top_content">
      <div class="header">提醒进货</div>
    </div>
    </div>
    <div class="form">
                      <div >
                        <label >商品id<span >*</span>
                        </label>
                        <div >
                          <input id="proid" name="proid" value="${kcxx.proid}"  type="text" onblur="checkproid()"><span id="demo3" style="color: red;"></span>
                        </div>
                      </div>
                      <div>
                        <label  >名称<span >*</span>
                        </label>
                        <div >
                          <input id="pname" name="pname" value="${kcxx.pname}" onblur="checkname()" type="text" ><span id="demo2" style="color: red;"></span>
                        </div>
                      </div>
                      <div >
                        <label >数量 <span >*</span>
                        </label>
                        <div >
                          <input id="num" name="num" value="${kcxx.num}"  type="text" onblur="checknum()"><span id="demo4" style="color: red;"></span>
                        </div>
                      </div> 
                        <div >
                        <label >备注<span ></span>
                        </label>
                        <div >
                          <input id="marks" name="marks" value=""  type="text" >
                        </div>
                        </div>
                        </div>
                        <pre></pre>
                        <pre></pre>
						<a onclick="javascript:history.back(-1);"  class=" btn" role="button">返回上页</a>
						<button type="submit" class="btn" >提醒</button>							                      
                    </form>
                    </div>
                    
<script>
window.location.href="${pageContext.request.contextPath}//kcxx/getkcxx_warn";
</script>
<%@include file="frame/footer_B.jsp"%>
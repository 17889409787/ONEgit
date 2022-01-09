<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
  <div class="top">
    <div class="top_content">
      <div class="header">通告</div>
    </div>
  </div>

  <div class="middle-content">
  <div><hr /></div>
    <div class="out">
    <form method="post" action="insert_msg" onsubmit="return checktext()">
    <div><input id="sendname" name="sendname" type="hidden" value="${sessionScope.managername}"></div>
     <div><textarea rows="3" id="text" name="text" ></textarea></div>
      <button type="submit" class="btn">发布</button>
      </form>
      </div>
        <div><hr /></div>
 <table class="table-inline">
	<c:forEach items="${requestScope.sendname}" var="message">
		<thead>
			<tr>
				<td class="tti">${message.sendname}</td>
			</tr>
		</thead>
		<tbody>
			<tr >
				<td class="form-line">${message.text}</td>	
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;</td></tr>
		</tbody>
	</c:forEach>
</table>
</div>
<script>
/*检验消息*/
 function checktext(){
	var text = document.getElementById('text').value;
		if(text == null  || text == ""){
			alert("内容为空，发布失败！");
			rerurn false;
		}else{
			alert("发布成功！");
			return true;
		}
}
</script>
<%@include file="frame/footer_A.jsp"%>


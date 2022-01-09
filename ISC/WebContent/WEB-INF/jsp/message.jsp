<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
  <div class="top">
    <div class="top_content">
      <div class="header">消息</div>
    </div>
  </div>
  <div class="middle-content">
  <div><hr /></div>
 <table class="table-inline">
	<c:forEach items="${requestScope.sendname }" var="message">
		<thead>
			<tr class="tti">
				<td>${message.sendname}</td>
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
<%@include file="frame/footer_B.jsp"%>


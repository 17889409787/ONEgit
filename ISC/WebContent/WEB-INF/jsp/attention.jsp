<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
  <div class="top">
    <div class="top_content">
      <div class="header">提醒</div>
    </div>
  </div>
    <div><hr /></div>
<div class="bottom">
<table class="table-inline">
<thead>
<tr class="tti">
<th>商品id</th>
<th>名称</th>
<th>库存数量</th>
<th>备注</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.proid}" var="attention">
<tr >
<td class="form-line">${attention.proid}</td>
<td class="form-line">${attention.pname}</td>
<td class="form-line">${attention.num}</td>
<td class="form-line">${attention.marks}</td>
<td class="form-line">
<a href="${pageContext.request.contextPath }/ckin/toadd" class="btn">进货</a>
<a onclick="del(${attention.proid})"  class="btn" >删除</a>
</td>
</tr>
</c:forEach>
</tbody>
</table></div>
<script type="text/javascript">
	function del(id) {
		var message=confirm("是否确认要删除?");
		if (message==true) {
			// 确认时做的操作 var 
			window.location.href="${pageContext.request.contextPath }/message/delete?proid="+id;
			alert("删除成功");
	} else {
		// 取消时做的操作
		alert("删除失败");
	}
}
</script>
<%@include file="frame/footer_A.jsp"%>


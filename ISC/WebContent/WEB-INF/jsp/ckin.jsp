<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
<div class="content" id="content">
  <div class="top">
    <div class="top_content">
      <div class="header">进货信息</div>
    </div>
  </div>
  <div class="middle">
    <div class="middle_content">
      <table class="form-inline">
        <tr>
          <td class="form-group">订单id：</td>
          <td><input type="text" class="form-cotrol" id="oid" value="" name="inid" /></td>
          <td class="form-group">商品id：</td>
          <td><input type="text" class="form-cotrol" id="proid" value="" name="proid" /></td>
          <td class="form-group">名称：</td>
          <td><input type="text" class="form-cotrol" id="pname" value="" name="pname" /></td>
          <td class="form-group">进货日期：</td>
          <td><input type="text" class="form-cotrol" id="indate" value="" name="indate" /></td>
          <td class="form-group"><button type="submit" class="btn btn-primary">查询</button></td>
        </tr>
      </table>
    </div>
  </div>
  <div class="exceed"><a href="${pageContext.request.contextPath }/ckin/toadd" class="btn">新增</a></div>
  <div class="bottom">
  <table class="table-inline">
<thead>
<tr class="tti">
<th>订单id</th>
<th>商品id</th>
<th>名称</th>
<th>数量</th>
<th>进货日期</th>
<th>备注</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.inid}" var="ckin">
<tr >
<td class="form-line">${ckin.inid}</td>
<td class="form-line">${ckin.proid}</td>
<td class="form-line">${ckin.pname}</td>
<td class="form-line">${ckin.num}</td>
<td class="form-line">${ckin.indate}</td>
<td class="form-line">${ckin.marks}</td>
<td class="form-line">
<a href="${pageContext.request.contextPath }/ckin/edit?inid=${ckin.inid}" class="btn">修改</a> 
<a onclick="del(${ckin.inid})"  class="btn" aria-label="Left Align" role="button">删除</a></td></tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
<script type="text/javascript">
	function del(id) {
		var message=confirm("是否确认要删除?");
		if (message==true) {
			// 确认时做的操作 var 
			window.location.href="${pageContext.request.contextPath }/ckin/delete?inid="+id;
			alert("删除成功");
	} else {
		// 取消时做的操作
		alert("删除失败");
	}
}
</script>	                
<%@include file="frame/footer_A.jsp"%>

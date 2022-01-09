<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
<div class="content" id="content">
  <div class="top">
    <div class="top_content">
      <div class="header">库存预警</div>
    </div>
  </div>
  <div class="middle">
    <div class="middle_content">
      <table class="form-inline">
        <tr>
          <td class="form-group">商品id：</td>
          <td><input type="text" class="form-cotrol" id="proid" value="" name="proid" /></td>
          <td class="form-group">名称：</td>
          <td><input type="text" class="form-cotrol" id="pname" value="" name="pname" /></td>
          <td class="form-group"><button type="submit" class="btn">查询</button></td>
          <td class="form-group"></td>
          <td class="form-group"></td>
          <td class="form-group"></td>
          <td class="form-group"></td>
        </tr>
      </table>
    </div>
  </div>
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
<c:forEach items="${requestScope.proid}" var="kcxx">
	<tr >
		<td class="form-line">${kcxx.proid}</td>
		<td class="form-line">${kcxx.pname}</td>
		<td class="form-line">${kcxx.num}</td>
		<td class="form-line">${kcxx.marks}</td>
		<td class="form-line">
	<a onclick="atten(${product.proid})"  class="btn" role="button">提醒进货</a>
	</td></tr>
</c:forEach>
</tbody>
</table></div>
</div>
<script type="text/javascript">
	function atten(id) {
		var message=confirm("是否提醒进货?");
		if (message==true) {
			// 确认时做的操作 var 
			window.location.href="#";
			alert("提醒成功");
	} else {
		// 取消时做的操作
		alert("提醒失败");
	}
}
</script>
<%@include file="frame/footer_B.jsp"%>

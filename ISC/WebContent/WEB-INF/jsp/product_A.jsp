<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
<div class="content" id="content">
  <div class="top">
    <div class="top_content">
      <div class="header">商品信息</div>
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
          <td class="form-group">商品类型：</td>
          <td><input type="text" class="form-cotrol" id="protype" value="" name="protype" /></td>
          <td class="form-group"><button type="submit" class="btn">查询</button></td>
          <td class="form-group"></td>
          <td class="form-group"></td>
        </tr>
      </table>
    </div>
  </div>
  <div class="exceed"><a href="${pageContext.request.contextPath }/product/toaddpro_A" class="btn" role="button">新增</a></div>
  <div class="bottom">
  <table class="table-inline">
<thead>
<tr class="tti">
<th>商品id</th>
<th>名称</th>
<th>销售价格</th>
<th>进货价格</th>
<th>生产时间</th>
<th>过期时间</th>
<th>供应商</th>
<th>商品类型</th>
<th>计件方式</th>
<th>备注</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.proid}" var="product">
<tr >
<td class="form-line">${product.proid}</td>
<td class="form-line">${product.pname}</td>
<td class="form-line">${product.price}</td>
<td class="form-line">${product.inprice}</td>
<td class="form-line">${product.prodate}</td>
<td class="form-line">${product.reledate}</td>
<td class="form-line">${product.supname}</td>
<td class="form-line">${product.protype}</td>
<td class="form-line">${product.unit}</td>
<td class="form-line">${product.marks}</td>
<td class="form-line">
<a href="${pageContext.request.contextPath }/product/editpro_A?proid=${product.proid}" class="btn">修改</a> 
<a onclick="del(${product.proid})"  class="btn" >删除</a>
</td>
</tr>
</c:forEach>
</tbody>
</table></div>
</div>
<script type="text/javascript">
	function del(id) {
		var message=confirm("是否确认要删除?");
		if (message==true) {
			// 确认时做的操作 var 
			window.location.href="${pageContext.request.contextPath }/product/delete_A?proid="+id;
			alert("删除成功");
	} else {
		// 取消时做的操作
		alert("删除失败");
	}
}
</script>
<%@include file="frame/footer_A.jsp"%>

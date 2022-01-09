<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
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
</tr>
</c:forEach>
</tbody>
</table></div>
</div>
<%@include file="frame/footer_B.jsp"%>

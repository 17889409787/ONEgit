<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_A.jsp"%>
<div class="content" id="content">
  <div class="top">
    <div class="top_content">
      <div class="header">员工信息</div>
    </div>
  </div>
  <div class="middle">
    <div class="middle_content">
      <table class="form-inline">
        <tr>
          <td class="form-group">员工id：</td>
          <td><input type="text" class="form-cotrol" id="staffid" value="" name="staffid" /></td>
          <td class="form-group">姓名：</td>
          <td><input type="text" class="form-cotrol" id="staffname" value="" name="staffname" /></td>
          <td class="form-group"><a href="${pageContext.request.contextPath }/staff/getbyparams?staffid=${staff.staffid}?staffname=${staff.staffname}" class="btn">查询</a></td>
          <td class="form-group"></td>
          <td class="form-group"></td>
           <td class="form-group"></td>
          <td class="form-group"></td>
        </tr>
      </table>
    </div>
  </div>
  <div class="exceed"><a href="${pageContext.request.contextPath }/staff/toadd?staffid=${staff.staffid}" class="btn">新增</a>
  <div class="bottom">
  <table class="table-inline">
<thead>
<tr class="tti">
<th>员工id</th>
<th>姓名</th>
<th>身份证号</th>
<th>性别</th>
<th>手机号</th>
<th>身份类型</th>
<th>密码</th>
<th>操作</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.staffid}" var="staff">
<tr >
<td class="form-line">${staff.staffid}</td>
<td class="form-line">${staff.staffname}</td>
<td class="form-line">${staff.card}</td>
<td class="form-line">${staff.sex}</td>
<td class="form-line">${staff.tel}</td>
<td class="form-line">${staff.stafftype}</td>
<td class="form-line">${staff.pwd}</td>
<td class="form-line">
<a href="${pageContext.request.contextPath }/staff/toupdate?staffid=${staff.staffid}" class="btn">修改</a> 
<a onclick="del(${staff.staffid})"  class="btn" aria-label="Left Align" role="button">删除</a></td>
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
			window.location.href="${pageContext.request.contextPath }/staff/delete?staffid="+id;
			alert("删除成功");
	} else {
		// 取消时做的操作
		alert("删除失败");
	}
}
</script>
<%@include file="frame/footer_A.jsp"%>

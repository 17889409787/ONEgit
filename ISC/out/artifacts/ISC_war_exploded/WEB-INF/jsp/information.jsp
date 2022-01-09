<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="frame/head_B.jsp"%>
  <div class="top1">
    <div class="top_content1">
      <div class="header">个人信息</div>
    </div>
  </div>
    <div><hr /></div>
<table class="tabel1">
  <tr>
    <td class="t1">员工id：</td>
    <td class="t2">${sessionScope.staffid}</td>
  </tr>
  <tr>
    <td class="t1">姓名：</td>
    <td class="t2">${sessionScope.staffname}</td>
  </tr>
  <tr>
    <td class="t1"> 身份证号：</td>
    <td class="t2">${sessionScope.card}</td>
  </tr>
  <tr>
    <td class="t1">性别：</td>
    <td class="t2">${sessionScope.sex}</td>
  </tr>
  <tr>
    <td class="t1">手机号：</td>
    <td class="t2">${sessionScope.tel}</td>
  </tr>
  <tr>
    <td class="t1">身份类型：</td>
    <td class="t2">${sessionScope.stafftype}</td>
  </tr>
  <tr>
    <td class="t1">密码：</td>
    <td class="t2">${sessionScope.pwd}</td>
  </tr>
</table>
<pre></pre>
<div class="bottom1">
<div class="btn1"><a href="${pageContext.request.contextPath }/staff/editinformation?staffid=${sessionScope.staffid}" class="btn">修改</a> </div>
</div>
<%@include file="frame/footer_B.jsp"%>


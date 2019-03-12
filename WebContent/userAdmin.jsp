<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pm.dao.UserDao"%>
<%@page import="com.pm.dao.impl.UserDaoImpl"%>
<%@page import="com.pm.bean.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="islogin.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
  //用户权限 
      // String role = (String)session.getAttribute("role");
      String role = (String)session.getAttribute("role");
      pageContext.setAttribute("role",role);
 %>
<!-- 屏蔽管理者权限显示 -->
<%-- <c:out value="${role}"></c:out> --%> 
<body>
<div class="menu">
<table>
<tbody>
<tr><td>
<form method="post" action="servlet/EmpServlet">
<input name="do" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查    询" type="submit">
</form>
</td></tr>
</tbody>
</table>
</div>
<div class="main">
	<div class="optitle clearfix">
	<em>
	<c:if test="${role=='1'}">
	<input value="添加用户" class="input-button" onclick="window.location.href='/WebServicePos/userAdd.jsp'" type="button">
	</c:if>
	</em>
		<div class="title">用户管理&gt;&gt;</div>
	 </div>
	<div class="content">
	<table class="list">
  	<tbody>
  	<tr bgcolor="#906137" style="font-size: 15px;color: #fff">
	    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
	    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
	    <td width="100"><div class="STYLE1" align="center">性别</div></td>
	    <td width="100"><div class="STYLE1" align="center">年龄</div></td>
	
	    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
	    <td width="150"><div class="STYLE1" align="center">工作状态 </div></td>
	    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
	    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
   </tr>
   <c:forEach var="user" items="${userList}" >
   <tr>
     
	    <td height="23"><span class="STYLE1">${user.user_id}</span></td>
	    <td><span class="STYLE1">
	    
	    <c:if test="${role=='1'}">
	    	<a href="servlet/EmpServlet?do=doedit&uid=${user.user_id}">${user.username}</a>
	    </c:if>

	    <c:if test="${role=='2'}">${user.username} </c:if>
	    
	    </span></td>
	    <td><span class="STYLE1">${user.sex}</span></td>
	    <td><span class="STYLE1">${user.age}</span></td>
	    <td><span class="STYLE1">${user.contact_phone}</span></td>
	    
	    <c:if test="${user.status==1}">
	    <td><span class="STYLE1">上班</span></td>
	    </c:if>
	    
	    <c:if test="${user.status==2}">
	    <td><span class="STYLE1">事假</span></td>
	    </c:if>
	    
	     <c:if test="${user.status==3}">
	    <td><span class="STYLE1">病假</span></td>
	    </c:if>
	   
	    <c:if test="${user.status==4}">
	    <td><span class="STYLE1">婚假</span></td>
	    </c:if>
	
	    <c:if test="${user.status==5}">
	    <td><span class="STYLE1">离职</span></td>
	    </c:if>
	    
	  
	 
	    <td><span class="STYLE1">${user.addr_line1}</span></td>
	    <c:if test="${user.role==1}">
	    	<td><span class="STYLE1">管理员</span></td>
	    </c:if>
	    <c:if test="${user.role==2}">
	    	<td><span class="STYLE1">普通员工</span></td>
	    </c:if>
	    
  </tr>
  
  </c:forEach>
  
</tbody></table>
</div>
</div>
</body></html>
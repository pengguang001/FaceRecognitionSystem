<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pm.dao.impl.UserDaoImpl"%>
<%@page import="com.pm.dao.UserDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="islogin.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<%
    //用户权限 
   /*    String username = (String) session.getAttribute("username");
      pageContext.setAttribute("username",username);  */
      
      String role = (String)session.getAttribute("role");
      pageContext.setAttribute("role",role);
%>
<!-- 屏蔽管理者权限显示 -->
<%-- <c:out value="${role}"></c:out> --%> 

<body class="frame-bd">
<ul class="left-menu">
	<!-- 判断用户权限，根据根限显示菜单 -->
	<li><a href="servlet/MemServlet" target="mainFrame"><img src="images/btn_users.gif" /></a></li>
    <c:if test="${role =='1'}">
	<li><a href="servlet/EmpServlet" target="mainFrame"><img src="images/btn_bill.gif" /></a></li>
	<li><a href="servlet/PerformanceServlet" target="mainFrame"><img src="images/btn_suppliers.gif" /></a></li>
	<li><a href="servlet/UpdateDishesServlet" target="mainFrame"><img src="images/btn_uploadimg.gif" /></a></li>
	</c:if>
	<li><a href="exitSys.jsp" ><img src="images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>

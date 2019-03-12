<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="islogin.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<%
   //获得当前登录用户名
   String uname = (String)session.getAttribute("username");
   pageContext.setAttribute("uname",uname);
 %>
<body>
<div id="header">
	<div class="title"></div>
	<div class="welcome"><br />欢迎您：${pageScope.uname }</div>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="islogin.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<frameset rows="100,*" cols="*" frameborder="1" border="1" framespacing="0">
	<frame src="admin_top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder ="1" border="1" framespacing="0">
		<frame src="admin_left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" />
		<frame src="servlet/MemServlet" name="mainFrame" id="mainFrame" />
		<frame src="footer.html" name="bottom" id="bottomFrame" />
  </frameset>
</frameset>
</html>

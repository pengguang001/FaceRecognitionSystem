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

<%
    //用户权限 
    String role = (String)session.getAttribute("role" );
    pageContext.setAttribute("role",role);
 %>
 
<html xmlns ="http://www.w3.org/1999/xhtml"/>  
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改删除用户</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">职员管理&gt;&gt;</div>
	</div>
	<form id="form" name="form" method="post" action="/WebServicePos/servlet/EmpServlet?uid=${user.user_id}" onsubmit="return checkform();">
    <input type="hidden" name="do" value="update">
		<div class="content">
			<table class="box">
			<tr>
				<td class="field">编          号：</td>
				<td><input type="text" name="uid" id="uid" class="text" onblur="return checkuid();" value="${user.user_id}" disabled="disabled"/>
				<span id="suid" style="color:red ;font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">名          称：</td>
				<td><input type="text" name="username" id="username" class="text" onblur="return checkusername();" value="${user.username}"/>
				<span id="susername" style="color: red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">密          码：</td>
				<td><input type="text" name="password" id="password" class="text" onblur="return checkpassword();" value="${user.password}"/>
                <span id="spassword" style="color:red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">确认密码：</td>
				<td><input type="text" name="repassword" id="repassword" class="text" onblur="return checkrepassword();" value="${user.password}"/>
			    <span id="srepassword" style="color:red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">性          别：</td>
				<td>
				    <select name="gender" id="gender" onblur="return checkgender();">
				        <c:choose>
				        <c:when test="${user.sex=='男'}">
                    	  <option value="女">女</option>
                    	  <option value="${user.sex}" selected="selected">${user.sex}</option>
				        </c:when>
				          <c:when test="${user.sex=='女'}">
                    	  <option value="男">男</option>
                    	  <option value="${user.sex}" selected="selected">${user.sex}</option>
				        </c:when>
				        </c:choose>
                    </select>
                </td>
			</tr> 
			<tr>
				<td class="field">年          龄：</td> 
				<td><input type="text" name="age" class="text" id="age" onblur="return checkage();" value="${user.age}"/>
				<span id="sage" style="color: red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">电         话：</td>
				<td><input type="text" name="phone" class="text" id="phone" onblur="return checkphone();" value="${user.contact_phone}"/>
				<span id="sphone" style="color: red;font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">工作状态：</td>
				<td>
				 <select name="status" id="status" onblur="return checkStatus()">
						<c:choose>  
						    <c:when test="${user.status==1}"> 
		                    	<option value="2">事假</option>
		                    	<option value="3">病假</option>
		                    	<option value="4">婚假</option>
		                    	<option value="5">离职</option>
                    	  		<option value="${user.status}" selected="selected">上班</option>
						   </c:when>  
						   <c:when test="${user.status==2}">
						   		<option value="1">上班</option>
		                    	<option value="3">病假</option>
		                    	<option value="4">婚假</option>
		                    	<option value="5">离职</option>
                    	  		<option value="${user.status}" selected="selected">事假</option> 
						   </c:when> 
						   <c:when test="${user.status==3}"> 
						      	<option value="1">上班</option>
		                    	<option value="2">事假</option>
		                    	<option value="4">婚假</option>
		                    	<option value="5">离职</option>
                    	  		<option value="${user.status}" selected="selected">病假</option> 
						   </c:when>  
						   <c:when test="${user.status==4}"> 
						      	<option value="1">上班</option>
		                    	<option value="2">事假</option>
		                    	<option value="3">病假</option>
		                    	<option value="5">离职</option>
                    	  		<option value="${user.status}" selected="selected">婚假</option> 
						   </c:when>  
						   <c:when test="${user.status==5}"> 
						      	<option value="1">上班</option>
		                    	<option value="2">事假</option>
		                    	<option value="3">病假</option>
		                    	<option value="4">婚假</option>
                    	  		<option value="${user.status}" selected="selected">离职</option>
						   </c:when>  
						   
						</c:choose>  
				 </select> 
				<span id="sstatus" style="color:red;font-size:12px "></span></td>
			</tr>
			
			<tr>
				<td class="field">地         址：</td>
				<td><textarea name="address" id="address" class="text" cols="45" rows="5">${user.addr_line1}</textarea>
				<span id="saddress" style="color: red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">权          限：</td>
				<td>
				<c:if test="${user.role=='1'}">
				<input type="radio" name="role" id="role1" value="2" />普通员工
				<input type="radio" name="role" id="role2" value="1" checked="checked"/>管理员
				</c:if>
				<c:if test="${user.role!='1'}">
				<input type="radio" name="role" id="role1" value="2" checked="checked"/>普通员工
				<input type="radio" name="role" id="role2" value="1" />管理员
				</c:if>
				</td>
			</tr>
			</table>
		</div>
		<div class="buttons">
			   <input type="button" name="button" id="button" onclick="history.back();" value="返回" class="input-button"/>
			<c:if test="${role=='1'}">
			   <input type="submit" name="ubutton" value="修改" class="input-button" /> 
			   <input type="button" name="dbutton" value="删除" class="input-button" onclick="return delUser()"/>   
			</c:if> 
		</div>
		
		
	</form>
</div>
	<script type="text/javascript">
		function checkusername() {
			var username = document.getElementById("username").value;
			var susername = document.getElementById("susername");
			if (username == null || username == "") {
				susername.innerHTML = "用户名不能为空！ ";
				return false;
			} else {
				susername.innerHTML = "";
				return true;
			}
		}
		function checkpassword() {
			var password = document.getElementById("password").value;
			var spassword = document.getElementById("spassword");
			var reg = /^[a-zA-Z0-9]{5,20}$/;//定义正则表达式格式
			if (password == null || password == "") {
				spassword.innerHTML = "密码不能为空！";
				return false;
			} else if (reg.test(password) == false) {
				spassword.innerHTML = "输入的字符不合法，密码至少为5位，字母或数字，或两者组合均可！";
				return false;
			} else {
				spassword.innerHTML = "";
				return true;
			}
		}
		function checkrepassword() {
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("repassword").value;
			var srepassword = document.getElementById("srepassword");
			var reg = /^[a-zA-Z0-9]{5,20}$/;//定义正则表达式格式
			if (password != repassword) {
				srepassword.innerHTML = "两次密码不一样！";
				return false;
			} else {
				srepassword.innerHTML = "";
				return true;
			}
		}

		function checkage() {
			var age = document.getElementById("age").value;
			var sage = document.getElementById("sage");
			//var reg = /^([1-9]|[1-9][0-9]|1[01][0-9])$/;//年纪的正则表达式
			var reg = /^(1[6-9]|[2-9][0-9])$/; //限制16-99之间,其他格式[/^[17-119]$/]
			if (age == null || age == "") {
				sage.innerHTML = "年龄不能为空";
				return false;
			} else if (reg.test(age) == false) {
				sage.innerHTML = "年龄不合法,要求16-99岁（包括16和99）！";
				return false;
			} else {
				sage.innerHTML = "";
				return true;
			}
		}

		function checkphone() {
			var phone = document.getElementById("phone").value;
			var sphone = document.getElementById("sphone");
			var reg = /^0?(13[0-9]|15[012356789]|18[01236789]|14[57])[0-9]{8}$/;
			if (phone == null || phone == "") {
				sphone.innerHTML = "联系方式不能为空";
				return false;
			} else if (reg.test(phone) == false) {
				sphone.innerHTML = "手机号码不合法，共11位（1开头)";
				return false;
			} else {
				sphone.innerHTML = "";
				return true;
			}
		}
		function checkStatus() {
			var status = document.getElementById("status").value;
			var sstatus = document.getElementById("sstatus");
			if (status == null || status == "") {
				status.innerHTML = "请选择员工当前工作状态！";
				return false;
			} else {
				sstatus.innerHTML = "";
				return true;
			}
		}
		function checkAddress() {
			var address = document.getElementById("address").value;
			var saddress = document.getElementById("saddress");
			var reg = /^(?=.*?[\u4E00-\u9FA5])[\dA-Za-z\u4E00-\u9FA5]+$/;
			if (address == null || address == "") {
				saddress.innerHTML = "地址不能为空";
				return false;
			} else if (reg.test(address) == false) {
				saddress.innerHTML = "输入信息不合法，地址由汉字、数字、字母构成！";
				return false;
			} else {
				saddress.innerHTML = "";
				return true;
			}
		}
		
		function checkform() {
			if (checkusername() && checkrepassword() && checkpassword()
					&& checkgender() && checkage() && checkphone()
					&& checkStatus() && checkAddress()) {
				return true;
			}
			return false;
		}
		
		function delUser() {
			if (window.confirm("确认删除吗？")) {
				location = "/WebServicePos/servlet/EmpServlet?do=deluser&uid=${user.users_id}";
			} else {
				return false;
			}
		}
	</script>
</body>
</html>

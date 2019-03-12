<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="islogin.jsp" %>
<%
    //用户权限 
      String role = (String)session.getAttribute("role" );
      pageContext.setAttribute("role",role);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns ="http://www.w3.org/1999/xhtml"> 
<head>
<base href="<%=basePath%>"> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加用户操作</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
	<div class="title">用户管理&gt;&gt;</div>
	</div>
	<form id="form1" name="form1" method="post" action="servlet/EmpServlet" onsubmit="return checkform();">
		<div class="content">
		<font color="red"></font>
		 <input type="hidden" name="do" value="doAdd">
			<table class="box">
			<tbody><tr>
				<td class="field">用户编号：</td>
				<td><input type="text" name="uid" id="uid" class="text" value="系统自动生成..." disabled="disabled" /></td>
			</tr>
			<tr>
				<td class="field">用户名称：</td>
				<td><input type="text" name="username" id="username" class="text" onblur="return checkusername()"/>
				<span id="susername" style="color: red;font-size: 12px"></span></td>
			</tr>
			<tr>
				<td class="field">用户密码：</td>
				<td><input type="password" name="password" id="password" class="text" onblur="return checkpassword()"/>
                <span id="spassword" style="color:red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">确认密码：</td>
				<td><input type="password" name="repassword" id="repassword" class="text" onblur="return checkrepassword()"/>
			    <span id="srepassword" style="color:red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">用户性别：</td>
				<td>
				    <select name="gender" id="gender" onblur="return checkgender()">
				        <option value="" selected="selected">请选择</option>
                    	<option value="女">女</option>
                    	<option value="男">男</option>
                    </select>
                    <span id="sgender" style="color: red; font-size: 12px "></span>
                </td>
			</tr> 
			<tr>
				<td class="field">用户年龄：</td> 
				<td><input type="text" name="age" class="text" id="age" onblur="return checkage()"/>
				<span id="sage" style="color: red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">用户电话：</td>
				<td><input type="text" name="phone" class="text" id="phone" onblur="return checkphone()"/>
				<span id="sphone" style="color:red;font-size:12px "></span></td>
			</tr>
			
			
			<tr>
				<td class="field">工作状态：</td>
				<td>
				    <select name="status" id="status" onblur="return checkStatus()">
				        <option value="" selected="selected">请选择</option>
                    	<option value="1">上班</option>
                    	<option value="2">休假</option>
                    	<option value="3">病假</option>
                    	<option value="4">婚假</option>
                    	<option value="4">离职</option>
                    </select>
				<span id="sstatus" style="color:red;font-size:12px "></span></td>
			</tr>
			<tr>
				<td class="field">用户地址：</td>
				<td><textarea name="address" id="address" class="text" cols="45" rows="5" onblur="return checkAddress()"></textarea>
				<span id="saddress" style="color: red; font-size: 12px "></span></td>
			</tr>
			<tr>
				<td class="field">用户权限：</td>
				<td>
				<input type="radio" name="role" id="role1" value="2" />普通员工
				<input type="radio" name="role" id="role2" value="1" checked="checked"/>管理员
				</td>
			</tr>
			   <!-- <input type="hidden" name="role" id="role1" value="2"/>普通用户   -->
			</tbody>
			</table> 
		</div>
		<div class="buttons">
		  
			   <input type="button" name="button" id="button" onclick="history.back();" value="返回" class="input-button"/>
			   <input type="submit" name="ubutton" value="增加用户" class="input-button"/> 
		</div>
		
		
	</form>
</div>
<script type="text/javascript">
	function checkusername() {
		var username = document.getElementById("username").value;
		var susername = document.getElementById("susername");
		if (username == null || username == "") {
			susername.innerHTML = "用户名不能为空！";
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
			srepassword.innerHTML = "两次密码不一样!";
			return false;
		} else {
			srepassword.innerHTML = "";
			return true;
		}
	}
	function checkgender() {
		var gender = document.getElementById("gender").value;
		var sgender = document.getElementById("sgender");
		if (gender == null || gender == "") {
			sgender.innerHTML = "不能为空，请选择性别!";
			return false;
		} else {
			sgender.innerHTML = "";
			return true;
		}
	}
	function checkage() {
		var age = document.getElementById("age").value;
		var sage = document.getElementById("sage");
		//var reg = /^[1-9]\d{0,2}$/;
		var reg = /^(1[6-9]|[2-9][0-9])$/; //限制16-99之间,其他格式[/^[17-119]$/]
		if (age == null || age == "") {
			sage.innerHTML = "年龄不能为空！";
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
			sphone.innerHTML = "联系方式不能为空！";
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
				&& checkgender() && checkage() && checkphone() && checkStatus()&&checkAddress()) {
			return true;
		}
		return false;
	}
</script>
</body>
</html>

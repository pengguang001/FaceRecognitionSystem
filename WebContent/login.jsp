<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pm.bean.User"%>
<%@page import="com.pm.dao.impl.UserDaoImpl"%>
<%@page import="com.pm.service.UserService"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<% 
   String info = request.getParameter("info");
   if(info!=null&&!"".equals(info)){
      request.setAttribute("info",info);
   }
	
 %>  

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 人脸识别管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form method="post" action="LoginUserServlet" onsubmit="return checklogin();">
			<dl>
				<dt>用户编号：</dt>
				<dd><input id="userid" type="text" name="userId" onblur="return checkUserId();" class="input-text"/>
				<span id="id" style="color:red"></span></dd>
				<dt>密　码：</dt>
				<dd><input id="password" type="password" name="passWord" onblur="return checkPassword();" class="input-text" />
				<span id="pass" style="color:red"></span></dd>
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登       录" class="input-button" />
				<!-- <input type="reset" name="reset" value="退　　出" class="input-button" /> -->
				<span id="show" style="color:red" >${requestScope.info}</span>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function checkUserId(){
           var userid = document.getElementById("userid").value;
           var span1 = document.getElementById("id");
           if(userid==null||userid==""){
                    span1.innerHTML="用户编号不能为空";
                    return false;
            }else{
                    span1.innerHTML="";
                    return true;            
            }
     }
     function checkName(){
           var username = document.getElementById("username").value;
           var span1 = document.getElementById("name");
           if(username==null||username==""){
                    span1.innerHTML="用户名不能为空";
                    return false;
            }else{
                    span1.innerHTML="";
                    return true;            
            }
     }
     function checkPassword(){
           var password = document.getElementById( "password" ).value;
           var span1 = document.getElementById("pass");
           var reg=/^[a-zA-Z0-9]{5,20}$/;
           if(password==null || password==""){
                  span1.innerHTML="密码不能为空";
                  return false;
           }else if(reg.test(password)==false){
                  span1.innerHTML="密码至少为5位";
                  return false;
           }else{
                  span1.innerHTML="";
                  return true;
           }
     }
     
     function checklogin(){
          if(checkPassword()&& checkUserId()){
               return true;
          }else{
               return false;
          }
     }
</script>
</body>
</html>

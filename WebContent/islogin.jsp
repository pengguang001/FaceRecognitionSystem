<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  //判断是否登陆
   String user_id = (String)session.getAttribute("user_id");
        if(user_id ==null ||user_id.equals("")){
            out.print("<script>alert('您还没有登录！请登陆 '); window.open('login.jsp','_parent')</script>");
        }
   /* String user_name = (String)session.getAttribute("username");
        if(users_id ==null ||users_id.equals("")){
            out.print("<script>alert('您还没有登录！请登陆 '); window.open('login.jsp','_parent')</script>");
        } */
%>
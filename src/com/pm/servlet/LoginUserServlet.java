package com.pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pm.bean.User;
import com.pm.dao.UserDao;
import com.pm.dao.impl.UserDaoImpl;
import com.pm.service.UserService;
/**
 * 这个类是Servlet类, 作用：Web服务端用户登录操作相关；
 * @ClassName LoginUserServlet
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class LoginUserServlet extends HttpServlet {
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	   
	   resp.setContentType("text/html;charset=utf-8");
	   
	   req.setCharacterEncoding("UTF-8");
	   resp.setCharacterEncoding("UTF-8");
	   
//	   String username = req.getParameter("username");
	   String users_id = req.getParameter("userId"); // 获取输入框用户编号users_id
	   String password = req.getParameter("passWord");                // 获取输入框用户密码passWord
	   
	   System.out.println("登陆用户编号："+ users_id);
	   System.out.println("登陆密码："+ password);
	   
	   
	   HttpSession session = req.getSession();
	   
	   UserService userSer =new UserService();
	   //IuserDao iuserDao = new UserDaoImp();
	   userSer.createTables();
	   User user= userSer.getUserById(users_id); //　通过用户编号获取对象
	   System.out.println("数据库用户编号:"+user.getUser_id());
	   System.out.println("数据库登陆密码:"+user.getPassword());
	   System.out.println("数据库用户权限:"+user.getRole());
	   
	   PrintWriter out = resp.getWriter();
	   boolean isLogin=true;
	   if(user!=null){
			   if(password.equals(user.getPassword())){
				   session.setAttribute("username", user.getUsername());  //保存会话对象
				   session.setAttribute("user_id", String.valueOf(user.getUser_id()));  //将对象的用户编号Id属性值保存到会话
				   session.setAttribute("role",String.valueOf(user.getRole())); //将对象的角色属性值保存到会话
				   resp.sendRedirect("admin_index.jsp");
//				   out.println("<script>alert('登陆成功!');</script>");
//				   out.println("<script type=\'text/javascript\'>");
//				   out.println("alert(\'登陆成功\')");
//				   out.println("</script>");
				   
//				   resp.sendRedirect("userAdmin.jsp");
//				   resp.sendRedirect("admin_left.jsp");
				   
				   out.flush();
				   out.close();
			   }else{
				   isLogin=false;
			   }
	   }else{
		   isLogin=false;
	   }
	   //若密码或用户名错误，则登陆失
	   if(isLogin==false){
		   req.getRequestDispatcher("login.jsp?info=用户或密码错误，请重新登录！").forward(req, resp);
	   }
	}
}


   

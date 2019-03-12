package com.pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pm.dao.UserDao;
import com.pm.dao.impl.UserDaoImpl;
import com.pm.bean.User;
import com.pm.jsonTools.JsonUtil;
import com.pm.service.UserService;
import com.pm.utils.JsonTools;
/**
 * 这个类是Servlet类, 作用：安卓端（android）登录相关操作；
 * @ClassName UserServlet
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;//序列化
	
	private List<User> ulist = null;    // 初始化集合
	private User user = null;              // 初始化对象
	private UserService userService;    // 用户服务类
	UserDao userDao = new UserDaoImpl();// 创建UserDaoImpl()
	
	//无参构造方法
	public UserServlet() {
		super();
	}
	/** 
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
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
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求和响应编码标准格式
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String jsonStr = "";
		String action_flag = request.getParameter("action_flag");//请求标示
		//操作标示判断
		if (action_flag.equals("login")) {      // 登录操作
			// 获取客户端输入的登录编号、登录密码
			
			String user_id = request.getParameter("user_id").toString().trim();
			String user_pass = request.getParameter("password").toString().trim();
			// 通过输入用户编号获取用户对象user
			user = userService.getUserById(user_id);
			// 获取用户编号、密码、角色权限
			String useid = user.getUser_id();
			String pass= user.getPassword();
			byte role = user.getRole();
			if(role==1 && user_pass.equalsIgnoreCase(pass)){
				System.out.println("管理员，登录成功！");
				out.print(role);	
			}else if(role==2 && user_pass.equalsIgnoreCase(pass)){
				System.out.println("用户，登录成功！");
				out.print(role);
			}else if(role==3 && user_pass.equalsIgnoreCase(pass)){
				System.out.println("住户，登录成功！");
				out.print(role);
			}else{
				System.out.println("登录失败，请重试!");
				out.print("登录失败，请重试!");
			}
		}else if(action_flag.equals("select")) { // 查询
			jsonStr = JsonTools.createJsonString2(userDao.getAllUser());
			System.out.println("---- 获取字符串  ----：" + jsonStr);
			out.println(jsonStr);
		}else {
			System.out.println("获取标示失败！");
			out.println("Failed");
		} 
		out.flush();// 清空缓冲区
		out.close();// 关闭流
	}
	/**
	 * 销毁
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
	/**
	 * 初始化
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	

}

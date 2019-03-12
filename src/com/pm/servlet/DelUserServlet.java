package com.pm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pm.dao.UserDao;
import com.pm.dao.impl.UserDaoImpl;
import com.pm.bean.User;
import com.pm.service.UserService;
import com.pm.utils.JsonTools;
/**
 * 这个类是Servlet类, 作用：删除用户；
 * @ClassName DelUserServlet
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 * --androd端暂不使用此类--
 */
@SuppressWarnings("serial")
public class DelUserServlet extends HttpServlet  {
	UserDao userDao = new UserDaoImpl();
	private User user = null;              // 初始化对象
	UserService userService;
	public DelUserServlet() {
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
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			// 设置请求和响应编码标准格式
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			PrintWriter out = response.getWriter();
			String action_flag = request.getParameter("action_flag");//请求标示
			// 判断删除标示
			if (action_flag.equals("delete")) {
				String uid = request.getParameter("user_id").toString();
				System.out.println("获取需要删除的Id" + uid);
				int flag = userDao.delUserById(uid);
				//int flag = userService.delUserById(uid);
				if(flag > 0){
					System.out.println("删除成功！");
					out.println("成功");
				}else{
					System.out.println("删除失败！");
					out.println("失败");
				}
			}
			out.flush();
			out.close();
	}
	public void init() throws ServletException {
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
}

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
 * 这个类是Servlet类, 作用：添加用户；
 * @ClassName AddUserServlet
 * @author sz-agatha-henry
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AddUserServlet extends HttpServlet  {
	UserDao userDao = new UserDaoImpl();
	private User user = null;              // 初始化对象
	UserService userService;
	public AddUserServlet() {
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
			//判断登录标示
			if (action_flag.equals("add")) {
				String user_name = request.getParameter("username").toString().trim();                    // 姓名
				String user_pass = request.getParameter("password").toString().trim();                    // 密码
				int age = Integer.parseInt(request.getParameter("age").toString().trim());                // 年龄
				String sex = request.getParameter("sex").toString().trim();                               // 性别
				int status = Integer.parseInt(request.getParameter("status").toString().trim());          // 工作状态
				String date_birth = request.getParameter("date_of_birth").toString().trim();              // 出生日期
				String enteredDate= request.getParameter("date_entered").toString().trim();               // 入职日期
				String email= request.getParameter("email").toString().trim();                            // 邮箱地址
				String addr1= request.getParameter("addr_line1").toString().trim();                       // 地址1
				String addr2= request.getParameter("addr_line2").toString().trim();                       // 地址2
				String qq_no= request.getParameter("qq_no").toString().trim();                            // QQ号码
				String updateDate= request.getParameter("updated_date").toString().trim();                // 更新日期
				int created_by = Integer.parseInt(request.getParameter("created_by").toString().trim());  // 建档记录
				byte role = Byte.parseByte(request.getParameter("role").toString().trim());               // 权限角色
				String phone = request.getParameter("contact_phone").toString().trim();                   // 手机号码
				user = new User(); // 创建用户实例
				// 设置属性
				user.setUsername(user_name);
				user.setPassword(user_pass);
				user.setAge(age);
				user.setSex(sex);
				user.setStatus(status);
				user.setFace_id(date_birth);
				///user.setCard_id(date_birth);
				user.setDate_entered(enteredDate);
				user.setEmail(email);
				user.setAddr_line1(addr1);
				user.setAddr_line2(addr2);
				user.setQq_no(qq_no);
				user.setUpdated_date(updateDate);
				user.setCreated_by(created_by);
				user.setRole(role);
				user.setContact_phone(phone);
				//int i =userDao.addUsers(user);// 调用增加职员方法
				int i =userService.addUser(user);// 调用增加职员方法
				if(i > 0){
					System.out.print("插入数据成功!");
					out.print("Add succeeded!");
				}else{
					out.print("Add failed!");
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

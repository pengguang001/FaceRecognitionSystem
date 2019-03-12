package com.pm.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pm.dao.BaseDao;
import com.pm.dao.UserDao;
import com.pm.bean.User;
/**
 * 这个UserDaoImpl类继承BaseDao和实现用户Dao接口
 * @ClassName UserDaoImpl
 * @Description: 用户实现类
 * @author sz-agatha-wang 
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	//====================实现用户接口后的相关查询方法=====================
	@Override
	public void createTables(String user_sql, String table_sql){
		super.createTables(user_sql, table_sql);
	}
	/**
	 * 查询所有用户集合
	 * @retrun List<User>
	 * @see com.agatha.pos.dao.UserDao#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		String sql = "SELECT * FROM users";            //sql查询语句
		ResultSet resultList = this.executeQuery(sql); //查询所有用户集合
		List<User> ulist = readResultSet(resultList);  //readResultSet()读取数据
		return ulist;
	}
	
	/**
	 * 根据用户Id查询用户
	 * @param users_id
	 * @return User
	 * @see com.agatha.pos.dao.UserDao#getUserById(int)
	 */
	@Override
	public User getUserById(String user_id) {
		String sql="SELECT * FROM users WHERE user_id=?";
		Object[] params ={user_id};
		ResultSet res = this.executeQuery(sql, params);
		List<User> list =readResultSet(res);
		return list.size() > 0 ? list.get(0) : null ;
	}
	
	/**
	 * ---改方法暂时不使用---
	 * 判断登陆用户是否存在
	 * @param username
	 * @return boolean
	 * @see com.agatha.pos.dao.UserDao#isLoginIdExists(java.lang.String)
	 */
	@Override
	public boolean isLoginIdExists(String username) {
		String sql = "SELECT * FROM users WHERE username=?";
		//创建数组接收
		Object[] params={username};
		int i = executeUpdate(sql, params);
		return i > 0 ? true : false;
	}
	
	/**
	 * 读取数据的工具类
	 * @param rs
	 * @return List<User>
	 * @exception SQLException
	 */
	public List<User> readResultSet(ResultSet rs){
		List<User> list = new ArrayList<User>();
		User u = null;
		try {
			while(rs.next()){
				u = new User();
				//s = u.getSex();
				//设置对象属性
				u.setUser_id(rs.getString("user_id"));                   //设置Id
				u.setUsername(rs.getString("username"));                //设置用户名
				u.setFirstname(rs.getString("firstname"));              //设置姓
				u.setLastname(rs.getString("lastname"));                //设置名字
				u.setEmail(rs.getString("email"));                      //设置邮箱
				u.setPassword(rs.getString("password"));
				u.setRole(rs.getByte("role"));
				u.setDate_entered(rs.getString("date_entered"));
				u.setStatus(rs.getInt("status"));
				u.setContact_phone(rs.getString("contact_phone"));
				//性别：枚举类型u.setSex(Sex.valueOf(Sex.class,rs.getString("sex")))
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setAddr_line1(rs.getString("addr_line1"));
				u.setAddr_line2(rs.getString("addr_line2"));
				u.setWechat(rs.getString("wechat"));
				u.setQq_no(rs.getString("qq_no"));
				u.setNo_of_retry(rs.getByte("no_of_retry"));
				u.setFace_id(rs.getString("face_id"));
				u.setCard_id(rs.getString("card_id"));
				u.setPhoto_url(rs.getString("photo_url"));
				u.setUpdated_date(rs.getString("updated_date"));
				u.setCreated_by(rs.getInt("created_by"));
				u.setUpdated_by(rs.getInt("updated_by"));
				list.add(u);
			}
			System.out.println("得到集合数量："+list.size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return list;
	}
	
	//==============登录、密码修改、用户增、删、改方法实现=================
	
	/**
	 * 用户登陆
	 * @param users_id
	 * @param password
	 * @return User
	 * @see com.agatha.pos.dao.UserDao#Login(int, java.lang.String)
	 */
	@Override
	public boolean Login(String user_id, String password) {
		String sql = "SELECT * FROM users WHERE user_id=? AND password=?";
		//创建数组接收
		Object[] params={user_id,password};
		ResultSet res = this.executeQuery(sql, params);
		List<User> ulist = readResultSet(res);
		return ulist.size() > 0 ? true : false;
	}
	
	/**
	 * 新增用户（注册新用户）
	 * @param user
	 * @return int(受影响行数)
	 * @see com.agatha.pos.dao.UserDao#addUsers(com.agatha.pos.entity.employ.User)
	 */
	@Override
	public int addUsers(User user) {
		int flag = 0;
		String sql = "INSERT INTO " +
				"users(username,email,password,role,date_entered,status,contact_phone,sex,age," +
				"face_id,card_id,addr_line1,addr_line2,qq_no,updated_date,created_by)" +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println("---开始插入职员数据----");
		//创建数组接收
		Object[] params={
				//user.getUsers_id(),
				user.getUsername(),      // 用户姓名
				user.getEmail(),         // 邮箱
				user.getPassword(),      // 用户密码
				user.getRole(),          // 角色权限
				user.getDate_entered(),  // 入住日期
				user.getStatus(),        // 工作状态
				user.getContact_phone(), // 联系电话
				user.getSex(),           // 性别
				user.getAge(),           // 年龄
				user.getFace_id(), // 识别码
				user.getCard_id(), // 识别码
				user.getAddr_line1(),    // 地址1
				user.getAddr_line2(),    // 地址2
				user.getQq_no(),         // qq号码
				user.getUpdated_date(),  // 更新日期
				user.getCreated_by()     // 创建记录
		};
		flag = executeUpdate_a(sql, params);
		return flag;
	}
	
	/**
	 * 删除用户
	 * @param users_id
	 * @return int
	 * @see com.agatha.pos.dao.UserDao#delUserById(int)
	 */
	@Override
	public int delUserById(String user_id) {
		String sql = "DELETE FROM users where user_id=?";
		Object[] params={user_id};
		int i =  executeUpdate_a(sql, params);
		return i;
	}

	/**
	 * 修改用户
	 * @param user
	 * @return int
	 * @see com.agatha.pos.dao.UserDao#modifyUserByUserId(com.agatha.pos.entity.employ.User)
	 */
	@Override
	public int modifyUserByUserId(User user) {
		String sql = "UPDATE users " +
				"SET username=?,password=?,sex=?,age=?,contact_phone=?,addr_line1=?,status=?,role=? WHERE user_id=?";
		Object[] params = {
				user.getUsername(),
				user.getPassword(),
				user.getSex(),
				user.getAge(),
				user.getContact_phone(),
				user.getAddr_line1(),
				user.getStatus(),
				user.getRole(),
				user.getUser_id()
		};
		int i = executeUpdate_a(sql, params);
		return i > 0 ? i : 0;
	}
	
	/**
	 * 判断原密码是否错误
	 * @param users_id
	 * @param oldpwd
	 * @return boolean
	 * @see com.agatha.pos.dao.UserDao#isOldPasswordError(int, java.lang.String)
	 */
	@Override
	public boolean isOldPasswordError(String user_id, String oldpwd) {
		String sql = "SElECT count(*) count FROM users WHERE user_id=? AND password=?";
		Object[] params={user_id,oldpwd};
		ResultSet resultList = this.executeQuery(sql,params);//查询所有用户集合
		List<User> ulist = readResultSet(resultList);//readResultSet()读取数据
		int flag = ulist.size();
		return flag > 0 ? true : false;
	}
	
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param users_id
	 * @param newPwd
	 * @return int
	 * @see com.agatha.pos.dao.UserDao#modifyUserPassword(java.lang.String, int, java.lang.String)
	 */
	@Override
	public int modifyUserPassword(String oldPwd,String user_id,String newPwd) {
		String sql = "UPDATE users SET password=? WHERE users_id=? AND password=?";
		Object[] params={newPwd,user_id,oldPwd};
		int flag = executeUpdate(sql, params);
		return flag;
		
	}
	
	
	
	
	
	/*start----------------------暂不使用---------------------------*/
	
	/**
	 * 判断邮箱是否存在
	 * @param user
	 * @return boolean
	 * @see com.agatha.pos.dao.UserDao#isEmailExists(com.agatha.pos.entity.employ.User)
	 */
	@Override
	public boolean isEmailExists(User user) {
		String sql = "SELECT * FROM users WHERE email=?";
		//创建数组接收
		Object[] params={user.getEmail()};
		int i = executeUpdate(sql, params);
		return i > 0 ? true : false;
	}
	/**
	 * 根据用户名模糊查询用户集合
	 * @param username
	 * @return List<User>
	 * @see com.agatha.pos.dao.UserDao#getLikeName(java.lang.String)
	 */
	@Override
	public List<User> getLikeName(String username) {
		String sql="SELECT * FROM users WHERE username LIKE ?"; // 根据用户名或编号查询
		ResultSet rs = this.executeQuery(sql,"%"+username+"%");
		return readResultSet(rs);
	}
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return User
	 * @see com.agatha.pos.dao.UserDao#getUserByName(java.lang.String)
	 */
	@Override
	public User getUserByName(String username) {
		String sql="SELECT * FROM users WHERE username=?";
		List<User> list=readResultSet(executeQuery(sql, username));
		return list.size()>0 ? list.get(0) : null ;
	}
	
	/*----------------------end---------------------------*/
	

}

package com.pm.dao;

import java.util.List;

import com.pm.bean.User;
/**
 * 这是一个Dao接口
 * UserDao，这个是用户接口类,提供用户的增加、删除、修改、查看接口，在对应Dao实现类中去实现相关方法
 * @Description: 用户Dao接口
 * @author sz-agatha-wang
 * @date 2014年11月5日 下午15:00:47 
 * @version 1.0
 */
public interface UserDao {
	// =========================职员（用户）查询接口========================
	void createTables(String user_sql, String table_sql);
	/**
	 * 查询所有用户集合
	 * @return List<User>
	 */
	List<User> getAllUser();
	
	/**
	 * 根据Id查询用户
	 * @param users_id
	 * @return User
	 */
	User getUserById(String users_id);

   	/**
   	 * 通过用户名模糊查询用户
   	 * @param username
   	 * @return List<User>
   	 */
	List<User> getLikeName(String username);
	
   	/**
   	 * 通过用户名查询用户
   	 * @param username
   	 * @return User
   	 */
	User getUserByName(String username);
   	
	/*
	 * --此方法没有使用到--
	 * 判断登陆用户是否存在
	 * @param username
	 * @return boolean
	 */
	boolean isLoginIdExists(String username);
	
	// =========================职员（用户）登录、增加、删除、修改（包括密码修改）接口========================
	
	/**
	 * 
	 * @param users_id
	 * @param password
	 * @return 用户登陆
	 */
	boolean Login(String users_id, String password);
	
	/**
	 * 增加用户（注册）
	 * @param user
	 * @return int
	 */
	int addUsers(User user);
	
	/**
	 * 删除用户
	 * @param users_id
	 * @return int
	 */
	int delUserById(String users_id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return int
	 */
	int modifyUserByUserId(User user);
	
	/**
	 * 判断原密码是否错误
	 * @param users_id
	 * @param oldpwd
	 * @return
	 */
	boolean isOldPasswordError(String users_id, String oldpwd);
	
	/**
	 * 修改密码
	 * @param oldPwd
	 * @param users_id
	 * @param newPwd
	 * @return int
	 */
	int modifyUserPassword(String oldPwd, String users_id, String newPwd);

	/*
	 * --此方法未使用到--
	 * 判断邮箱是否存在
	 * @param user
	 * @return boolean
	 */
	boolean isEmailExists(User user);
}

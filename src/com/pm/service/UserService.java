package com.pm.service;

import java.util.List;

import com.pm.consta.Constant;
import com.pm.dao.UserDao;
import com.pm.dao.impl.UserDaoImpl;
import com.pm.bean.User;
/**
 * 这个类是用户操作服务类，继承订单实现类UserDaoImpl
 * @ClassName UserService
 * @Description: 用户服务类
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
public class UserService extends UserDaoImpl{
	
	UserDao userDao = new UserDaoImpl();
	public void createTables(){
		userDao.createTables(Constant.CREATE_TABLE_USER, Constant.CREATE_TABLE_DEVICE);
	}
	/**
	 * 得到所有职员对象集合方法
	 * @return List<User>
	 */
	
	public List<User> getListUser(){
		List<User> uList = userDao.getAllUser();
		return uList;
	}
	/**
	 * 根据Id获取用户对象
	 * @param userid
	 * @return User
	 * @see com.agatha.pos.dao.Impl.UserDaoImpl#getUserById(int)
	 */
	public User getUserById(String userid){
		return userDao.getUserById(userid);
	}
	
	/**
	 * 用户登录业务方法 
	 * @param userId
	 * @param password
	 * @return boolean
	 */
	public boolean login(String userId,String password){
		boolean b = userDao.Login(userId, password);
		return b;
	}
	/**
	 * 添加用户方法
	 * @param user
	 * @return int
	 */
	public int addUser(User user){
		return userDao.addUsers(user);
		
	}
	/**
	 * 通过id删除用户对象方法
	 * @param userid
	 * @return int
	 */
	public int delUserById(String userid){
		return userDao.delUserById(userid);
	}
	/**
	 * 根据id修改用户对象属性
	 * @param user
	 * @return int（受影响个数）
	 */
	public int modifyUserById(User user){
		int flag = userDao.modifyUserByUserId(user);
		return flag;
	}
	
}

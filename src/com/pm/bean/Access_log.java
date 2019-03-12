package com.pm.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 职员访问日志实体类
 * @author sz-agatha-wang
 * --此类暂时不使用--
 */
public class Access_log implements Serializable {
	//对象实现序列化
	private static final long serialVersionUID = 1L;
	//定义属性变量名
	private int log_id;            //操作日志编号
	private int user;              //用户id
	private Timestamp access_time; //访问日期时间
	private int access_module;     //访问模块
	private int updated_by;        //更新类型
	
	/*
	 * 构造方法（无参与有参）
	 */
	public Access_log() {
		super();
	}
	
	public Access_log(int log_id, int user, Timestamp access_time,
			int access_module, int updated_by) {
		super();
		this.log_id = log_id;
		this.user = user;
		this.access_time = access_time;
		this.access_module = access_module;
		this.updated_by = updated_by;
	}

	/*
	 * toString()方法
	 * 返回字符串(Json格式)
	 */
	@Override
	public String toString() {
		return "Access_log [log_id=" + log_id + ", user=" + user
				+ ", access_time=" + access_time + ", access_module="
				+ access_module + ", updated_by=" + updated_by + "]";
	}
	
	/*
	 * 封装getter与setter方法
	 */

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Timestamp getAccess_time() {
		return access_time;
	}

	public void setAccess_time(Timestamp access_time) {
		this.access_time = access_time;
	}

	public int getAccess_module() {
		return access_module;
	}

	public void setAccess_module(int access_module) {
		this.access_module = access_module;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	
	
}

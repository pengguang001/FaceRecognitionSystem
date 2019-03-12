package com.pm.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 职员当前工作状态实体类
 * @author sz-agatha-wang
 * --暂时未使用--
 */
public class Working_status implements Serializable {
	//对象实现序列化
	private static final long serialVersionUID = 1L;
	//定义属性变量名
	private int w_status_id;        //状态编号
	private String desc;            //状态描述
	private int updated_by;         //更新类型
	private Timestamp updated_date; //更新日期
	
	
	/**
	 * 构造方法（无参与有参）
	 */
	public Working_status() {
		super();
	}
	public Working_status(int w_status_id, String desc, int updated_by,
			Timestamp updated_date) {
		super();
		this.w_status_id = w_status_id;
		this.desc = desc;
		this.updated_by = updated_by;
		this.updated_date = updated_date;
	}
	/**
	 * toString()方法
	 * @return String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Working_status [w_status_id=" + w_status_id + ", desc=" + desc
				+ ", updated_by=" + updated_by + ", updated_date="
				+ updated_date + "]";
	}
	/*
	 * 封装getter与setter方法
	 */
	public int getW_status_id() {
		return w_status_id;
	}
	public void setW_status_id(int w_status_id) {
		this.w_status_id = w_status_id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	public Timestamp getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}
	
	
}

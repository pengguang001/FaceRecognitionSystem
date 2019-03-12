package com.pm.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 职员角色实体类
 * @author sz-agatha-wang
 *  --此类暂时不使用--
 */
public class Role implements Serializable {
	//对象实现序列化
    private static final long serialVersionUID = 1L;
	//定义属性变量名
	private byte role_id;           //角色编号
	private String desc;            //角色描述
	private Timestamp updated_date; //更新日期
	private int updated_by;         //更新类型
	private int created_by;         //新建类型
	
	/*
	 * 构造方法（无参与有参）
	 */
	public Role() {
		super();
	}
	
	public Role(byte role_id, String desc, Timestamp updated_date, int updated_by,
			int created_by) {
		super();
		this.role_id = role_id;
		this.desc = desc;
		this.updated_date = updated_date;
		this.updated_by = updated_by;
		this.created_by = created_by;
	}
	/*
	 * toString()方法
	 * 返回字符串(Json格式)
	 */
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", desc=" + desc
				+ ", updated_date=" + updated_date + ", updated_by="
				+ updated_by + ", created_by=" + created_by + "]";
	}
	/*
	 * 封装getter与setter方法
	 */
	public byte getRole_id() {
		return role_id;
	}
	public void setRole_id(byte role_id) {
		this.role_id = role_id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Timestamp getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
	
	
}	

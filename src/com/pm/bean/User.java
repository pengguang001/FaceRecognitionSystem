package com.pm.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 这是一个实体类
 * @ClassName User
 * @Description: 职员实体类
 * @author sz-agatha-wang 
 * @date 2014年11月2日 下午15:00:47 
 * @version 1.0
 */
public class User implements Serializable {
	// 对象实现序列化
	private static final long serialVersionUID = 1L;
	// 定义对象属性变量名
	private String users_id; // 用户编号
	private String username; // 登录用户名
	private String firstname; // 姓
	private String lastname; // 名
	private String email; // 邮箱地址
	private String password; // 登录密码
	private byte role; // 角色权限(1:管理员,2:用户)
	private String date_entered; // 入住日期
	private int status; // 职员当前状态：(1休假、2病假、3上班、4婚假)
	private String contact_phone; // 联系方式
	private String sex; // 性别暂为：String类型；如果用枚举类型(F,M)单独建立一个枚举类
	private int age;    // 年龄
	private String addr_line1; // 地址1
	private String addr_line2; // 地址2
	private String wechat; // 微信号码
	private String qq_no; // QQ号码
	private byte no_of_retry; // 用户登录操作重试次数
	private String face_id;
	private String card_id; // 身份证号码
	private String photo_url; // 用户相片
	private String updated_date; // 更新日期
	private int created_by; // 新建类型
	private int updated_by; // 更新类型

	/**
	 * 构造方法（无参）
	 */
	public User() {
		super();
	}
	/**
	 * 构造方法（有参）
	 * @param users_id
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param role
	 * @param date_entered
	 * @param status
	 * @param contact_phone
	 * @param sex
	 * @param date_of_birth
	 * @param addr_line1
	 * @param addr_line2
	 * @param wechat
	 * @param qq_no
	 * @param no_of_retry
	 * @param card_id
	 * @param photo_url
	 * @param updated_date
	 * @param created_by
	 * @param updated_by
	 */
	public User(String users_id, String username, String firstname,
			String lastname, String email, String password, byte role,
			String date_entered, int status, String contact_phone, String sex,
			String date_of_birth, String addr_line1, String addr_line2,
			String wechat, String qq_no, byte no_of_retry,
			String face_id,String card_id, String photo_url,
			String updated_date, int created_by, int updated_by) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.date_entered = date_entered;
		this.status = status;
		this.contact_phone = contact_phone;
		this.sex = sex;
		this.addr_line1 = addr_line1;
		this.addr_line2 = addr_line2;
		this.wechat = wechat;
		this.qq_no = qq_no;
		this.no_of_retry = no_of_retry;
		this.face_id = face_id;
		this.card_id = card_id;
		this.photo_url = photo_url;
		this.updated_date = updated_date;
		this.created_by = created_by;
		this.updated_by = updated_by;
	}
	
	/**
	 * ToString方法--暂时没有使用到
	 * @return String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [users_id=" + users_id + ", username=" + username
				+ ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", role="
				+ role + ", date_entered=" + date_entered + ", status="
				+ status + ", contact_phone=" + contact_phone + ", sex=" + sex+ ", addr_line1="
				+ addr_line1 + ", addr_line2=" + addr_line2 + ", wechat="
				+ wechat + ", qq_no=" + qq_no + ", no_of_retry=" + no_of_retry
				+ ", face_id=" + face_id+", card_id=" + card_id + ", photo_url="
				+ photo_url + ", updated_date=" + updated_date
				+ ", created_by=" + created_by + ", updated_by=" + updated_by
				+ "]";
	}

	/*
	 * 封装getter与setter方法
	 */
	public String getUser_id() {
		return users_id;
	}

	public void setUser_id(String users_id) {
		this.users_id = users_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getRole() {
		return role;
	}

	public void setRole(byte role) {
		this.role = role;
	}

	public String getDate_entered() {
		return date_entered;
	}

	public void setDate_entered(String date_entered) {
		this.date_entered = date_entered;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr_line1() {
		return addr_line1;
	}

	public void setAddr_line1(String addr_line1) {
		this.addr_line1 = addr_line1;
	}

	public String getAddr_line2() {
		return addr_line2;
	}

	public void setAddr_line2(String addr_line2) {
		this.addr_line2 = addr_line2;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getQq_no() {
		return qq_no;
	}

	public void setQq_no(String qq_no) {
		this.qq_no = qq_no;
	}

	public byte getNo_of_retry() {
		return no_of_retry;
	}

	public void setNo_of_retry(byte no_of_retry) {
		this.no_of_retry = no_of_retry;
	}
	public String getFace_id() {
		return face_id;
	}

	public void setFace_id(String face_id) {
		this.face_id = face_id;
	}
	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

}

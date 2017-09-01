package com.neuq.entities;
//用户表
public class User {
	/**
	 * 用户id
	 */
	private int id;//id
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 预消费
	 */
	private double preOutMoney;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPreOutMoney() {
		return preOutMoney;
	}
	public void setPreOutMoney(double preOutMoney) {
		this.preOutMoney = preOutMoney;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String userName, String passWord, String realName, String sex, String phone) {
	
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.sex = sex;
		this.phone = phone;
	
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", realName=" + realName
				+ ", sex=" + sex + ", phone=" + phone + ", preOutMoney=" + preOutMoney + "]";
	}


	
	
	
    
	
	

}

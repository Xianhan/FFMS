package com.neuq.entities;
//支出管理表
public class Out {
	/**
	 * 记录
	 */
	private int id;
	/**
	 * 用户id
	 */
	private User user;
	/**
	 * 支出时间
	 */
	private String outDate;
	/**
	 * 支出类型id
	 */
	private IOType iotype;
	/**
	 * 支出金额
	 */
	private double outMoney;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public IOType getIotype() {
		return iotype;
	}
	public void setIotype(IOType iotype) {
		this.iotype = iotype;
	}
	public double getOutMoney() {
		return outMoney;
	}
	public void setOutMoney(double outMoney) {
		this.outMoney = outMoney;
	}
	
	
	public Out() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Out(int id, User user, String outDate, IOType iotype, double outMoney) {
		super();
		this.id = id;
		this.user = user;
		this.outDate = outDate;
		this.iotype = iotype;
		this.outMoney = outMoney;
		
	}
	@Override
	public String toString() {
		return "Cost [id=" + id + ", user=" + user + ", outDate=" + outDate + ", iotype=" + iotype + ", outMoney="
				+ outMoney +  "]";
	}

	
	
}
package com.neuq.entities;
//收入管理表
public class Income {
	/**
	 * 收入管理表id					
	 */
	private int id;
	/**
	 * 用户id
	 */
	private User user;
	/**
	 * 收入时间
	 */
	private String incomeDate;
	/**
	 * 收入类型id
	 */
	private IOType iotype;
	/**
	 * 收入金额
	 */
	private double incomeMoney;
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
	public String getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}
	public IOType getIotype() {
		return iotype;
	}
	public void setIotype(IOType iotype) {
		this.iotype = iotype;
	}
	public double getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(double incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Income(int id, User user, String incomeDate, IOType iotype, double incomeMoney) {
		super();
		this.id = id;
		this.user = user;
		this.incomeDate = incomeDate;
		this.iotype = iotype;
		this.incomeMoney = incomeMoney;
	}
	@Override
	public String toString() {
		return "Income [id=" + id + ", user=" + user + ", incomeDate=" + incomeDate + ", iotype=" + iotype
				+ ", incomeMoney=" + incomeMoney + "]";
	}

	
	
	

}

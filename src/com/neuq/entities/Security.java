package com.neuq.entities;
//证券账户表				
public class Security {
	/**
	 * 证券账户id
	 */
	private int id;
	/**
	 * 用户id
	 */
	private User user;
	/**
	 * 账户名称
	 */
	private String accountName;
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
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Security(int id, User user, String accountName) {
		super();
		this.id = id;
		this.user = user;
		this.accountName = accountName;
	}
	
	public Security() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Security [id=" + id + ", user=" + user + ", accountName=" + accountName + "]";
	}

	
	
	
}
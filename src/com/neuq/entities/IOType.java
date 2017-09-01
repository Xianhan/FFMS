package com.neuq.entities;
//收支表
public class IOType {
	/**
	 * 收支id
	 */
	private int id;
	/**
	 * 收支类型
	 */
	private String type;
	/**
	 * 状态，0支出，1收入
	 */
	private int status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public IOType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IOType(int id, String type, int status) {
		super();
		this.id = id;
		this.type = type;
		this.status = status;
	}
	@Override
	public String toString() {
		return "IOType [id=" + id + ", type=" + type + ", status=" + status + "]";
	}
	

	 
	
	
	
	
	

	

}

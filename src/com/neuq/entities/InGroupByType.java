package com.neuq.entities;

import java.io.Serializable;

public class InGroupByType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 收支类型id
	 */
	private transient int ioTypeId;
	/**
	 * 收入类型，需要id,类型名称,状态
	 */
	private String ioType;
	//状态
	private transient int status;
	/**
	 * 收入总金额,从数据库里计算
	 */
	private double allInMoney;
	public int getIoTypeId() {
		return ioTypeId;
	}
	public void setIoTypeId(int ioTypeId) {
		this.ioTypeId = ioTypeId;
	}
	public String getIoType() {
		return ioType;
	}
	public void setIoType(String ioType) {
		this.ioType = ioType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getAllInMoney() {
		return allInMoney;
	}
	public void setAllInMoney(double allInMoney) {
		this.allInMoney = allInMoney;
	}
	@Override
	public String toString() {
		return "InGroupByType [ioType=" + ioType + ", allInMoney=" + allInMoney + "]";
	}
	public InGroupByType(int ioTypeId, String ioType, int status, double allInMoney) {
		super();
		this.ioTypeId = ioTypeId;
		this.ioType = ioType;
		this.status = status;
		this.allInMoney = allInMoney;
	}
	public InGroupByType() {
		super();
	}
	
	
		
}

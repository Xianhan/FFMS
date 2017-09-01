package com.neuq.entities;

import java.io.Serializable;


/**
 * json封装实体对象
 * 某时间段内家庭各支出类型的支出金额数
 * @author Calvin
 *
 */

public class OutGroupByType  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 支出类型的id,不显示在json
	 */
	private transient int iotypeId;
	/**
	 * 支出类型
	 */
	private String ioType;
	/**
	 * 支出状态,不显示在json
	 */
	private transient int status;
	/**
	 * 支出总金额
	 */
	private double allOutMoney;
	
	public int getIotypeId() {
		return iotypeId;
	}
	public void setIotypeId(int iotypeId) {
		this.iotypeId = iotypeId;
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
	public double getAllOutMoney() {
		return allOutMoney;
	}
	public void setAllOutMoney(double allOutMoney) {
		this.allOutMoney = allOutMoney;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public OutGroupByType(int iotypeId, String ioType, int status, double allOutMoney) {
		super();
		this.iotypeId = iotypeId;
		this.ioType = ioType;
		this.status = status;
		this.allOutMoney = allOutMoney;
	}
	public OutGroupByType() {
		super();
	}
	@Override
	public String toString() {
		return "OutGroupByType [iotypeId=" + iotypeId + ", ioType=" + ioType + ", status=" + status + ", allOutMoney="
				+ allOutMoney + "]";
	}
	
	
	
	

}

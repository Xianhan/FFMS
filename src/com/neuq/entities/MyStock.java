package com.neuq.entities;
//持股信息表
public class MyStock {
	/**
	 * 持股id
	 */
	private int id;
	/**
	 * 证券账户id
	 */
	private Security security;
	/**
	 * 股票
	 */
	private Stock stock;
	/**
	 * 持股数量
	 */
	private int stockCount;
	/**
	 * 买进单价
	 */
	private double inPrice;
	/**
	 * 买进时间
	 */
	private String inDate;
	
	/**
	 * 买进数量
	 */
	private int inCount;
	/**
	 * 卖出单价
	 */
	private double outPrice;//
	/**
	 * 卖出时间
	 */
	private String outDate;
	/**
	 * 卖出数量
	 */
	private int outCount;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Security getSecurity() {
		return security;
	}
	public void setSecurity(Security security) {
		this.security = security;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public double getInPrice() {
		return inPrice;
	}
	public void setInPrice(double inPrice) {
		this.inPrice = inPrice;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public int getInCount() {
		return inCount;
	}
	public void setInCount(int inCount) {
		this.inCount = inCount;
	}
	public double getOutPrice() {
		return outPrice;
	}
	public void setOutPrice(double outPrice) {
		this.outPrice = outPrice;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public int getOutCount() {
		return outCount;
	}
	public void setOutCount(int outCount) {
		this.outCount = outCount;
	}
	public MyStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyStock [id=" + id + ", security=" + security + ", stock=" + stock + ", stockCount=" + stockCount
				+ ", inPrice=" + inPrice + ", inDate=" + inDate + ", inCount=" + inCount + ", outPrice=" + outPrice
				+ ", outDate=" + outDate + ", outCount=" + outCount + "]";
	}



}

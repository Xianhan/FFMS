package com.neuq.entities;
//股票表
public class Stock {

	/**
	 * 股票id
	 */
	private int id;
	/**
	 * 股票名称
	 */
	
	private String stockName;
	/**
	 * 股票代码
	 */
	private int stockCode;
	/**
	 * 股票单价
	 */
	private double price;
	/**
	 * 股票涨跌
	 */
	private double upDown;
	/**
	 * 交易总数
	 */
	private int sum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockCode() {
		return stockCode;
	}
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getUpDown() {
		return upDown;
	}
	public void setUpDown(double upDown) {
		this.upDown = upDown;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int id, String stockName, int stockCode, double price, double upDown, int sum) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockCode = stockCode;
		this.price = price;
		this.upDown = upDown;
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockName=" + stockName + ", stockCode=" + stockCode + ", price=" + price
				+ ", upDown=" + upDown + ", sum=" + sum + "]";
	}
	
	
	

}

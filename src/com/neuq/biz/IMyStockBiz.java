package com.neuq.biz;

import java.util.List;

import com.neuq.entities.MyStock;

public interface IMyStockBiz {
	/**
	 * 根据证券账户id查询所有持股（没卖出的）信息
	 * 
	 * @param sercurityId
	 * @return
	 */
	public List<MyStock> queryMyStock(int sercurityId);
	/**
	 * 根据持股信息id修改该股票信息
	 * @param myStockId  持股信息id
	 * @param outprice 卖出价格
	 * @param count 卖出数量
	 * @return
	 */
	public boolean updateMyStock(int myStockId,int count,double profit,int uid);
	/**
	 * 插入一条交易记录
	 */
	public boolean AddMyStock(MyStock ms);
}

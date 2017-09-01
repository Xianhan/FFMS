package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.MyStock;

public interface IMyStockDao {
	/**
	 * 根据证券账户id查询所有持股信息
	 * @param securityId
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<MyStock> MyStockQuery(int securityId,Connection con)throws SQLException;
	/**
	 * 根据持股信息id修改该股票信息（即卖出）
	 * @param myStockId  持股信息id
	 * @param count 卖出数量
	 * @return
	 */
	public boolean updateMyStock(int myStockId,int count,Connection con)throws SQLException;
	/**
	 * 插入一跳条易信息（股票代码，股票名，买进时间，持有数量，买进单价，卖出时间，卖出数量，卖出单价）
	 */
	public boolean AddMyStock(MyStock ms,Connection con)throws SQLException;
	/**
	 * 卖出股票时插入收入支出记录
	 * @param con
	 * @param profit
	 * @return
	 * @throws SQLException
	 */
	public boolean addProfit(Connection con,double profit,int uid) throws SQLException;
}

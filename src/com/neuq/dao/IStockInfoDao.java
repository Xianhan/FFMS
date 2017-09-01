package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Stock;
//股票数据dao接口
public interface IStockInfoDao {
	public List<Stock> selectStockInfo(Connection con)throws SQLException;

}

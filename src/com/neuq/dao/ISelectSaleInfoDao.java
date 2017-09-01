package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Stock;
//查询要买的股票信息
public interface ISelectSaleInfoDao {
	public Stock selectSaleInfo(Connection con,int code)throws SQLException; 

}

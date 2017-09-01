package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.neuq.entities.MyStock;

public interface IMyStockAddDao {
	public boolean myStockAdd(Connection con, MyStock ms)throws SQLException;

}

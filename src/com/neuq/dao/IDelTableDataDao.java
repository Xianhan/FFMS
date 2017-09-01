package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDelTableDataDao {
	public boolean DelTableData(Connection con, String tname)throws SQLException;

}

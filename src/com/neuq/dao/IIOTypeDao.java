package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.IOType;

public interface IIOTypeDao {
	/**
	 * 查询所有收入类型
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<IOType> queryAllInType(Connection con) throws SQLException;
	/**
	 * 查询所有支出类型
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<IOType> queryAllOutType(Connection con) throws SQLException;
}

package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.IOType;

public interface IIOTypeBiz {
	/**
	 * 查询所有收入类型
	 * @return
	 * @throws SQLException
	 */
	public List<IOType> queryAllInType();
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<IOType> queryAllOutType();
}

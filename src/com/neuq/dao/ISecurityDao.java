package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Security;

public interface ISecurityDao {
	/**
	 * 通过用户民查证券账户信息
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public List<Security> SecurityQuery(int uid,Connection con)throws SQLException;
	/**
	 * 通过id查询单个证券账户信息，用于修改名称
	 */
	public Security ASecurityQuery(int id,Connection con) throws SQLException;
	/**
	 * 修改证券账户名称
	 * @param s
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean updateSecurity(Security s,Connection con) throws SQLException;
	/**
	 * 通过证券id删除证券账户信息
	 */
	public boolean SecurityDelete(int securityid,Connection con)throws SQLException;
	/**
	 * 添加账户
	 */
	public boolean SecurityAdd(Security sec,Connection con)throws SQLException;
}

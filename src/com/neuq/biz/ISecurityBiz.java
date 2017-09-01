package com.neuq.biz;

import java.sql.Connection;
import java.util.List;

import com.neuq.entities.Security;

public interface ISecurityBiz {
	/**
	 * 根据uid查询，返回证券账户id，用户真实姓名，证券账户名称
	 * @param uid
	 * @return
	 */
	public List<Security> SecurityQuery(int uid);
	/**
	 * 修改证券账户名称
	 * @param s
	 * @return
	 */
	public boolean updateSecurity(Security s);

	/**
	 * 查询单个证券账户
	 */
	public Security ASecurityQuery(int id);
	/**
	 * 根据证券账户id，删除此账户
	 */
	public boolean SecurityDelete(int id);
	/**
	 * 插入用户id，证券账户姓名
	 * @param sec
	 * @return
	 */
	public boolean SecurityAdd(Security sec);
}

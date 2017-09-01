package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.GateCard;

public interface IGateCardDao {
	/**
	 * 签到
	 * @param gatecard
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public boolean signOn(GateCard gatecard,Connection con) throws SQLException;
	/**
	 * 查询昨天签到天数
	 * @param yesterday
	 * @return
	 * @throws SQLException
	 */
	public int queryDays(String yesterday,int userid,Connection con) throws SQLException;
	/**
	 * 查询本月签到的日期
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<String> queryAllDay(int userid, Connection con) throws SQLException;
}

package com.neuq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.InGroupByType;
import com.neuq.entities.Income;
import com.neuq.util.DBUtil;

public interface IIncomeDao {

	/**
	 * 添加收入 记录
	 * 
	 * @param income
	 * @return
	 */

	public boolean addIncome(Income income, Connection con) throws SQLException;

	/**
	 * 根据用户id查询某时间段某人所有收入记录（如果id=-1，代表查询所有人某时间段所有收入记录，管理员专用）
	 * 
	 * @return
	 */
	public List<Income> queryAllIncome(int userid, String StartDate, String endDate, Connection con)
			throws SQLException;

	/**
	 * 根据收入表的id删除记录
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteIncome(int id, Connection con) throws SQLException;

	/**
	 * 根据收入表id 修改收入信息表
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateIncome(int id, Income income, Connection con) throws SQLException;
	/**
	 * 根据id查询单条收入信息
	 */
	public Income queryByIncomeId(int id,Connection con)throws SQLException;
	/**
	 * 管理员查询所有信息
	 */
	public List<InGroupByType> adminQueryAllIncome(String startDate, String endDate,Connection con)throws SQLException;
	/**
	 * 分页查询收入信息
	 * @param userid
	 * @param StartDate
	 * @param endDate
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<Income> pagingIncome(int userid, String StartDate, String endDate, Connection con,int reqPage, int showNum)throws SQLException;
	/**
	 * 查询一段时间内总条数
	 * @param con
	 * @param userid
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SQLException
	 */
	public int sumIncome(Connection con, int userid,String startDate, String endDate) throws SQLException ;
}

package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Out;
import com.neuq.entities.OutGroupByType;

public interface IOutDao {
	/**
	 * 添加支出记录
	 * 
	 * @param cost
	 * @return
	 */
	public boolean addOut(Out cost,Connection con) throws SQLException;

	/**
	 * 根据用户id查询某时间段某人所有支出记录（如果id=-1，代表查询所有人某时间段所有支出记录，管理员专用）
	 * 
	 * @return
	 */
	public List<Out> queryAllOut(int userid, String StartDate, String endDate,Connection con)throws SQLException;

	/**
	 * 根据支出表的id删除记录
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteOut(int id,Connection con)throws SQLException;

	/**
	 * 根据支出表id 修改支出信息记录
	 * @param id支出记录id
	 * @param out 新支出记录
	 * @return
	 */
	public boolean updateOut(int id, Out out,Connection con)throws SQLException;

	/**
	 * 查询单项支出记录的内容
	 * @param id
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public Out queryByOutId(int id, Connection con) throws SQLException;
	
	/**
	 * 查询家庭某段时间支出的各类型的总金额,管理员专用
	 */
	public List<OutGroupByType> queryOutGroupByType(String StartDate, String endDate,Connection con) throws SQLException;

	/**
	 * 查询本月总支出
	 * 
	 */
	public double queryCurMonthOutMoney(int username,Connection con) throws SQLException;
    /**
     * 分页查询支出
     */
	public List<Out> queryPagingOut(int userid, String StartDate, String endDate,Connection con,int reqPage,int showNum)throws SQLException;
    /**
     * 查询一段时间内总条数
     */
	public int sumOut(int userid, String StartDate, String endDate,Connection con)throws SQLException;
}

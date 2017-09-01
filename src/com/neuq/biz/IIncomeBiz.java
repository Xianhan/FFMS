package com.neuq.biz;

import java.sql.Connection;
import java.util.List;

import com.neuq.entities.InGroupByType;
import com.neuq.entities.Income;

public interface IIncomeBiz {
	/**
	 * 添加收入记录
	 * @param income
	 * @return
	 */
	
	public boolean addIncome(Income income);
	/**
	 * 根据用户id查询某时间段某人所有收入记录（如果id=-1，代表查询所有人某时间段所有收入记录，管理员专用）
	 * @return
	 */
	public List<Income> queryAllIncome(int userid,String StartDate,String endDate);
	/**
	 * 根据收入表的id删除记录
	 * @param id
	 * @return
	 */
	public boolean deleteIncome(int id);
	/**
	 * 根据收入表id 修改收入信息表
	 * @param id
	 * @param income 新income
	 * @return
	 */
	public boolean updateIncome(int id,Income income);
	/**
	 * 根据收入表id查询单个收入信息
	 *
	 */
	public Income queryByIncomeId(int id);
	/**
	 * 查询按类型分类所有
	 */
	public List<InGroupByType> adminQueryAllIncome(String startdate,String enddate);
	/**
	 * 分页查询
	 * @param userid
	 * @param StartDate
	 * @param endDate
	 * @param reqPage
	 * @param showNum
	 * @return
	 */
	public List<Income> pagingIncome(int userid, String StartDate, String endDate,  int reqPage, int showNum);
	/**
	 * 查询总数
	 * @param userid
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int sumIncome( int userid, String startDate, String endDate);
}

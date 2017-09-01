package com.neuq.biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.Out;
import com.neuq.entities.OutGroupByType;

public interface IOutBiz {
	/**
	 * 添加支出记录
	 * @param cost
	 * @return
	 */
	public boolean addOut(Out cost);
	/**
	 * 根据用户id查询某时间段某人所有支出记录（如果id=-1，代表查询所有人某时间段所有支出记录，管理员专用）
	 * @return
	 */
	public List<Out> queryAllOut(int userid,String StartDate,String endDate);
	/**
	 * 根据支出表的id删除记录
	 * @param id
	 * @return
	 */
	public boolean deleteOut(int id);
	/**
	 * 根据支出表id 修改支出信息记录
	 * @param id 支出记录id
	 * @param out 新支出记录
	 * @return
	 */
	public boolean updateOut(int id,Out out);
	/**
	 * 根据ID查询单条支出信息
	 * @param id
	 * @return
	 */
	public Out queryByOutId(int id);
	/**
	 * 查询家庭某段时间支出的各类型的总金额,管理员专用
	 */
	public List<OutGroupByType> queryOutGroupByType(String startDate, String endDate);
	/**
	 * 查询本月总支出
	 * 
	 */
	public double queryCurMonthOutMoney(int username);
	/**
	 * 分页查询支出
	 */
	public List<Out> queryPagingOut(int userid, String StartDate, String endDate,int reqPage,int showNum);
	/**
	 * 查询总条数
	 */
	public int sunOut(int userid, String StartDate, String endDate);

}

package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IOutBiz;
import com.neuq.dao.IOutDao;
import com.neuq.dao.imp.OutDaoImp;
import com.neuq.entities.Out;
import com.neuq.entities.OutGroupByType;
import com.neuq.util.DBUtil;
/**
 * 
 * @author Calvin
 *
 */
public class OutBizImp implements IOutBiz{

	IOutDao iod = new OutDaoImp();
	/**
	 * 添加新支出
	 */
	@Override
	public boolean addOut(Out out) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iod.addOut(out, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	/**
	 * 返回支出列表
	 */
	@Override
	public List<Out> queryAllOut(int userid, String StartDate, String endDate) {
		Connection con = DBUtil.getConnection();
		List<Out> list = new ArrayList<Out>();
		try {
			list = iod.queryAllOut(userid, StartDate, endDate, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}
	
	/**
	 * 删除支出信息
	 */
	@Override
	public boolean deleteOut(int id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iod.deleteOut(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	
	/**
	 * 修改支出信息
	 */
	@Override
	public boolean updateOut(int id, Out out) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = iod.updateOut(id, out, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	
	/**
	 * 根据id查询单条支出信息记录
	 */
	@Override
	public Out queryByOutId(int id){
		Connection con = DBUtil.getConnection();
		Out out = null;
		try {
			out = iod.queryByOutId(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return out;
	}
	
	/**
	 * 查询家庭某段时间支出的各类型的总金额,管理员专用
	 */
	@Override
	public List<OutGroupByType> queryOutGroupByType(String startDate, String endDate) {
		Connection con = DBUtil.getConnection();
		List<OutGroupByType> list = new ArrayList<OutGroupByType>();
		try {
			list = iod.queryOutGroupByType(startDate, endDate, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return list;
	}
	
	/**
	 * 查询本月支出
	 */
	@Override
	public double queryCurMonthOutMoney(int username) {
		Connection con = DBUtil.getConnection();
		double curMonOutMoney = 0;
		try {
			curMonOutMoney = iod.queryCurMonthOutMoney(username,con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return curMonOutMoney;
	}

	@Override
	public List<Out> queryPagingOut(int userid, String StartDate, String endDate, int reqPage, int showNum) {
		Connection con=DBUtil.getConnection();
		List<Out> list=null;
		
		try {
			list=iod.queryPagingOut(userid, StartDate, endDate, con, reqPage, showNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return list;
	}

	@Override
	public int sunOut(int userid, String StartDate, String endDate) {
		Connection con=DBUtil.getConnection();
		int s=0;
		try {
			s=iod.sumOut(userid, StartDate, endDate, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return s;
	}
}

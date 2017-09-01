package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IIncomeBiz;
import com.neuq.dao.IIncomeDao;
import com.neuq.dao.imp.IncomeDaoImp;
import com.neuq.entities.InGroupByType;
import com.neuq.entities.Income;
import com.neuq.util.DBUtil;

public class IncomeBizImp implements IIncomeBiz {
	IIncomeDao icbz = new IncomeDaoImp();

	@Override
	public boolean addIncome(Income income) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = icbz.addIncome(income, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public List<Income> queryAllIncome(int userid, String StartDate, String endDate) {
		Connection con = DBUtil.getConnection();
		List<Income> income = new ArrayList<Income>();
		try {
			income = icbz.queryAllIncome(userid, StartDate, endDate, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return income;
	}

	@Override
	public boolean deleteIncome(int id) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = icbz.deleteIncome(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public boolean updateIncome(int id, Income income) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = icbz.updateIncome(id, income, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public Income queryByIncomeId(int id){
		Connection con = DBUtil.getConnection();
		Income income = new Income();
		try {
			income = icbz.queryByIncomeId(id, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return income;
	}

	@Override
	public List<InGroupByType> adminQueryAllIncome(String startdate, String enddate) {
		Connection con=DBUtil.getConnection();
		List<InGroupByType> inlist=new ArrayList<InGroupByType>();
		try {
			inlist=icbz.adminQueryAllIncome(startdate, enddate, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return inlist;
	}

	@Override
	public List<Income> pagingIncome(int userid, String StartDate, String endDate, int reqPage, int showNum) {
		Connection con=DBUtil.getConnection();
		List<Income> income = new ArrayList<Income>();
		try {
			income = icbz.pagingIncome(userid, StartDate, endDate, con, reqPage, showNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return income;
	
	}

	@Override
	public int sumIncome(int userid, String startDate, String endDate) {
		Connection con=DBUtil.getConnection();
		int n=0;
		try {
			n=icbz.sumIncome(con, userid, startDate, endDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return n;
	}

}

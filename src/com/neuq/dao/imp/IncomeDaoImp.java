package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IIncomeDao;
import com.neuq.entities.IOType;
import com.neuq.entities.InGroupByType;
import com.neuq.entities.Income;
import com.neuq.entities.User;
import com.neuq.util.DBUtil;

public class IncomeDaoImp implements IIncomeDao {
	//添加u
	@Override
	public boolean addIncome(Income income, Connection con) throws SQLException {
		boolean b=false;
		String sql = "insert into tab_in values(null,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,income.getUser().getId());
		pst.setString(2, income.getIncomeDate());
		IOType iotype = new IOType();
		pst.setInt(3, income.getIotype().getId());
		pst.setDouble(4, income.getIncomeMoney());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			b=true;
		}
		return b;
	}

	@Override
	public List<Income> queryAllIncome(int userid, String StartDate, String endDate, Connection con)
			throws SQLException {
		List<Income> incomelist = new ArrayList<Income>();
		PreparedStatement pst = null;
		String sql = null;
		if (userid == -1) {
			sql = "SELECT i.id,i.incomedate,i.incomemoney,u.username,ty.type,ty.id,u.realname FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+StartDate+"' AND '"+endDate+"' order by i.incomedate desc";
		} else {
			sql = "SELECT i.id,i.incomedate,i.incomemoney,u.username,ty.type,ty.id,u.realname FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+StartDate+"' AND '"+endDate+"' AND i.uid ="
					+ userid+" order by i.incomedate desc";
		}
		pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Income income = new Income();
			income.setId(rs.getInt(1));
			income.setIncomeDate(rs.getString(2));
			income.setIncomeMoney(rs.getDouble(3));
			User user = new User();
			user.setUserName(rs.getString(4));
			user.setRealName(rs.getString(7));
			income.setUser(user);
			IOType iotype = new IOType();
			iotype.setType(rs.getString(5));
			iotype.setId(rs.getInt(6));
			income.setIotype(iotype);
			incomelist.add(income);
		}
		DBUtil.closeDB(pst, rs);
		return incomelist;
	}

	@Override
	public boolean deleteIncome(int id, Connection con) throws SQLException {
		boolean b=false;
		String sql = "delete from tab_in where id=?";
		PreparedStatement pst =null;
		pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			b=true;
		}
		return b;
	}

	@Override
	public boolean updateIncome(int id, Income income, Connection con) throws SQLException {
		boolean b = false;
		String sql = "update tab_in set incomedate=?,incometype=?,incomemoney=? WHERE id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, income.getIncomeDate());
		pst.setInt(2, income.getIotype().getId());
		pst.setDouble(3, income.getIncomeMoney());
		pst.setInt(4, income.getId());
		int n = pst.executeUpdate();
		if (n > 0) {
			b = true;
		}
		DBUtil.closeDB(pst);
		return b;
	}
	
	@Override
	public Income queryByIncomeId(int id,Connection con)throws SQLException {
		Income income=new Income();
		String sql="SELECT ti.id,ti.uid,tu.realname,ti.incomedate,ti.incometype,ti.incomemoney from tab_in ti,tab_user tu where ti.id= "+id+" and ti.uid=tu.id";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		//接收用户id，用户真实姓名，收入时间，收入类型，收入金额
		rs.next();
		
		User user=new User();
		income.setId(rs.getInt(1));
		user.setId(rs.getInt(2));
		user.setRealName(rs.getString(3));
		income.setUser(user);
		income.setIncomeDate(rs.getString(4));
		IOType iotype=new IOType();
		iotype.setId(rs.getInt(5));
		income.setIotype(iotype);
		income.setIncomeMoney(rs.getDouble(6));
		
		DBUtil.closeDB(pst,rs);
		return income;
		
	}

	@Override
	public List<InGroupByType> adminQueryAllIncome(String startDate, String endDate, Connection con)
			throws SQLException {
		PreparedStatement pst=null;
		List<InGroupByType> inlist=new ArrayList<InGroupByType>();
		String sql="SELECT i.incometype,ty.type,ty.`status`,SUM(IFNULL(i.incomemoney,0)) AS inallmoney FROM tab_in i  INNER JOIN tab_user u ON i.uid = u.id  INNER JOIN tab_type ty ON i.incometype = ty.id  WHERE i.incomedate  BETWEEN ? AND ?  GROUP BY i.incometype";
		pst = con.prepareStatement(sql);
		pst.setString(1, startDate);
		pst.setString(2, endDate);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			//创建对象
			InGroupByType igb=new InGroupByType();
			igb.setIoTypeId(rs.getInt(1));
			igb.setIoType(rs.getString(2));
			igb.setStatus(rs.getInt(3));
			igb.setAllInMoney(rs.getDouble(4));
			inlist.add(igb);
		}
		DBUtil.closeDB(pst,rs);
		return inlist;
	}

	@Override
	public List<Income> pagingIncome(int userid, String StartDate, String endDate, Connection con, int reqPage, int showNum) throws SQLException {
		List<Income> incomelist = new ArrayList<Income>();
		PreparedStatement pst = null;
		String sql = null;
		if (userid == -1) {
			sql = "SELECT i.id,i.incomedate,i.incomemoney,u.username,ty.type,ty.id,u.realname FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+StartDate+"' AND '"+endDate+"' order by i.incomedate desc limit ?,? ";
		} else {
			sql = "SELECT i.id,i.incomedate,i.incomemoney,u.username,ty.type,ty.id,u.realname FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+StartDate+"' AND '"+endDate+"' AND i.uid ="
					+ userid+"   order by i.incomedate desc limit ?,?";
		}
		pst = con.prepareStatement(sql);
		pst.setInt(1, (reqPage-1)*showNum);
		pst.setInt(2, showNum);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Income income = new Income();
			income.setId(rs.getInt(1));
			income.setIncomeDate(rs.getString(2));
			income.setIncomeMoney(rs.getDouble(3));
			User user = new User();
			user.setUserName(rs.getString(4));
			user.setRealName(rs.getString(7));
			income.setUser(user);
			IOType iotype = new IOType();
			iotype.setType(rs.getString(5));
			iotype.setId(rs.getInt(6));
			income.setIotype(iotype);
			incomelist.add(income);
		}
		DBUtil.closeDB(pst, rs);
		return incomelist;
	}

	@Override
	public int sumIncome(Connection con, int userid, String startDate, String endDate) throws SQLException {
		int n=0;
		String sql = null;
		if (userid == -1) {
			sql = "SELECT count(*) FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+startDate+"' AND '"+endDate+"' ";
		} else {
			sql = "SELECT count(*) FROM tab_in i INNER JOIN tab_user u ON i.uid = u.id INNER JOIN tab_type ty ON i.incometype = ty.id WHERE incomedate BETWEEN '"+startDate+"' AND '"+endDate+"' AND i.uid ="
					+ userid+"  ";
		}
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();
		n=rs.getInt(1);
		DBUtil.closeDB(pst, rs);
		return n;
	}

}

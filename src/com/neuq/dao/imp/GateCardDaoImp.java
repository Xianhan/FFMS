package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.neuq.dao.IGateCardDao;
import com.neuq.entities.GateCard;
import com.neuq.util.DBUtil;



public class GateCardDaoImp implements IGateCardDao {

	@Override
	public boolean signOn(GateCard gatecard, Connection con) throws SQLException {
		String sql = "insert into tab_gatecard(id,userid,date,days) values(null,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, gatecard.getUser().getId());
		pst.setString(2, gatecard.getDate());
		pst.setInt(3,gatecard.getDays());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (n > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int queryDays(String yesterday,int userid,Connection con) throws SQLException {
		String sql="select days from tab_gatecard where date=? and userid=?";
		int n=0;
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, yesterday);
		pst.setInt(2, userid);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			n= rs.getInt(1);
		}
		DBUtil.closeDB(pst,rs);
		return n;
	}

	@Override
	public List<String> queryAllDay(int userid,Connection con) throws SQLException {
		String sql="select date from tab_gatecard where userid=? and date between ? and ?";
		List<String> d=new ArrayList<String>();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, userid);
		String start=new java.sql.Date(new java.util.Date().getTime()).toString().substring(0,8)+"01";
		pst.setString(2, start);
		String end=new java.sql.Date(new java.util.Date().getTime()).toString();
		pst.setString(3, end);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			String a=rs.getString(1);
			d.add(a);
		}
		DBUtil.closeDB(rs,pst);
		return d;
	}

	

}

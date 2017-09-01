package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IGateCardBiz;
import com.neuq.dao.IGateCardDao;
import com.neuq.dao.imp.GateCardDaoImp;
import com.neuq.entities.GateCard;
import com.neuq.util.DBUtil;

public class GateCardBizImp implements IGateCardBiz {
	IGateCardDao igcd = new GateCardDaoImp();

	@Override
	public boolean signOn(GateCard gatecard) {
		Connection con = DBUtil.getConnection();
		boolean b = false;
		try {
			b = igcd.signOn(gatecard, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public int queryDays(String yesterday,int userid) {
		Connection con = DBUtil.getConnection();
		int n = 0;
		try {
			n = igcd.queryDays(yesterday,userid,con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return n;
	}
	public List<String> queryAllDay(int userid){
		 List<String> d=new ArrayList<String>();
		 Connection con = DBUtil.getConnection();
		 try {
			d=igcd.queryAllDay(userid, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		 return d;
	}
	
}

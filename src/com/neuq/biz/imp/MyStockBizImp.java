package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IMyStockBiz;
import com.neuq.dao.IMyStockDao;
import com.neuq.dao.imp.MyStockDaoImp;
import com.neuq.entities.MyStock;
import com.neuq.util.DBUtil;

public class MyStockBizImp implements IMyStockBiz{
	
	IMyStockDao isd=new MyStockDaoImp();
	
	@Override
	public List<MyStock> queryMyStock(int securityId) {
		Connection con=DBUtil.getConnection();
		List<MyStock> ms=new ArrayList<MyStock>();
		try {
			ms=isd.MyStockQuery(securityId, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return ms;
	}

	@Override
	public boolean updateMyStock(int myStockId,int count,double profit,int uid) {
		boolean b=false;
		boolean c=false;
		Connection con=DBUtil.getConnection();	
		try {
			con.setAutoCommit(false);
			b=isd.updateMyStock(myStockId, count,con);
			c=isd.addProfit(con, profit, uid);
			if(b&&c==true){
				con.commit();
			}else{
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b&&c;
	}

	@Override
	public boolean AddMyStock(MyStock ms) {
		boolean b=false;
		Connection con=DBUtil.getConnection();
		try {
			b=isd.AddMyStock(ms, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	
}

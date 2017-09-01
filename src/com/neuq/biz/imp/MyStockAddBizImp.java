package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;

import com.neuq.biz.IMyStockAddBiz;
import com.neuq.dao.IMyStockAddDao;
import com.neuq.dao.imp.MyStockAddDaoImp;
import com.neuq.entities.MyStock;
import com.neuq.util.DBUtil;

public class MyStockAddBizImp implements IMyStockAddBiz{

	@Override
	public boolean addMyStock(MyStock ms) {
		IMyStockAddDao imsad=new MyStockAddDaoImp();
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=imsad.myStockAdd(con, ms);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return b;
	}
	

}

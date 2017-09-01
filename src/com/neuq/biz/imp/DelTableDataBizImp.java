package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;

import com.neuq.biz.IDelTableDataBiz;
import com.neuq.dao.IDelTableDataDao;
import com.neuq.dao.imp.DelTableDataDaoImp;
import com.neuq.util.DBUtil;

public class DelTableDataBizImp implements IDelTableDataBiz{

	@Override
	public boolean DelTableDataBizImp(String tname) {
		IDelTableDataDao itdd=new DelTableDataDaoImp();
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=itdd.DelTableData(con, tname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

}

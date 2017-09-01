package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;

import com.neuq.biz.ISelectSaleInfoBiz;
import com.neuq.dao.ISelectSaleInfoDao;
import com.neuq.dao.imp.SelectSaleInfoDaoImp;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class SelectSaleInfoBizImp implements ISelectSaleInfoBiz{

	@Override
	//查询要买的股票信息
	public Stock selectSaleInfo(int code) {
		ISelectSaleInfoDao issid=new SelectSaleInfoDaoImp();
		Stock s=null;
		Connection con=DBUtil.getConnection();
		try {
			s=issid.selectSaleInfo(con, code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		return s;
	}

}

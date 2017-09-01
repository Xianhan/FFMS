package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.biz.IStockInfoBiz;
import com.neuq.dao.IStockInfoDao;
import com.neuq.dao.imp.StockInfoDaoImp;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class StockInfoBizImp implements IStockInfoBiz{

	@Override
	//股票数据查询biz实现类
	public List<Stock> selectStockInfoBiz() {
		IStockInfoDao isid=new StockInfoDaoImp();
		Connection con=DBUtil.getConnection();
		List<Stock> list=null;
		try {
			list=isid.selectStockInfo(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return list;
	}

}

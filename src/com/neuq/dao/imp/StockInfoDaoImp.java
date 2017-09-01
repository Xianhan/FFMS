package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IStockInfoDao;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class StockInfoDaoImp implements IStockInfoDao {

	@Override
	//股票数据查询dao的实现类
	public List<Stock> selectStockInfo(Connection con) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Stock> ss= new ArrayList<Stock>();
		pst=con.prepareStatement("select stockcode,stockname,price,updown,sum from tab_stock");
		rs=pst.executeQuery();
		while(rs.next()){
			Stock stock=new Stock();
			stock.setStockCode(rs.getInt(1));
			stock.setStockName(rs.getString(2));
			stock.setPrice(rs.getDouble(3));
			stock.setUpDown(rs.getDouble(4));
			stock.setSum(rs.getInt(5));
			ss.add(stock);
		}
		DBUtil.closeDB(rs,pst,con);
		return ss;
	}
//	public static void main(String[] args) {
//		StockInfoDaoImp s=new StockInfoDaoImp();
//		Connection con=DBUtil.getConnection();
//		try {
//			System.out.println(s.selectStockInfo(con));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

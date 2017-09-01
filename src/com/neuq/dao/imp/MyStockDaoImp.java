package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuq.dao.IMyStockDao;
import com.neuq.entities.MyStock;
import com.neuq.entities.Security;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class MyStockDaoImp implements IMyStockDao {

	/**
	 * 根据证券账户id查询此账户下的持股id，证券账户ID，股票id，股票代码,股票名称,股票数量，买进金额，买进时间
	 */
	@SuppressWarnings("null")
	@Override
	public List<MyStock> MyStockQuery(int securityId, Connection con) throws SQLException {
		String sql = "SELECT tm.id,ts.id,ts.stockcode,ts.stockname,tm.stockcount,tm.inprice,tm.indate,tm.incount,tm.stockcount from tab_mystock tm,tab_stock ts where accountid= ? and  outcount=0 and stockcount >0 order by tm.indate desc";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,securityId );
		ResultSet rs = null;
		rs = pst.executeQuery();
		List<MyStock> stockarr = new ArrayList<MyStock>();
		while (rs.next()) {
			MyStock ms = new MyStock();
			ms.setId(rs.getInt(1));
			Stock stock=new Stock();
			stock.setId(rs.getInt(2));
			stock.setStockCode(rs.getInt(3));
			stock.setStockName(rs.getString(4));
			ms.setStock(stock);
			ms.setStockCount(rs.getInt(5));
			ms.setInPrice(rs.getDouble(6));
			ms.setInDate(rs.getString(7));
			ms.setInCount(rs.getInt(8));
			ms.setStockCount((rs.getInt(9)));
			stockarr.add(ms);
		}
		DBUtil.closeDB(rs,pst);
		return stockarr;
	}
	/**
	 * 通过此股票id，修改持有数量
	 */
	@SuppressWarnings({ "null", "unused" })
	@Override
	public boolean updateMyStock(int myStockId, int count,Connection con) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		String sql="update tab_mystock set stockcount=stockcount-"+count+" where id="+myStockId;
		PreparedStatement pst=con.prepareStatement(sql);
		boolean b=false;
		int c=pst.executeUpdate(sql);
		if(c>0){
			b=true;
		}
		return b;
	}
	
	@SuppressWarnings({ "unused", "null" })
	@Override
	public boolean AddMyStock(MyStock ms, Connection con) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		String sql="INSERT INTO tab_mystock VALUES(null,?,?,?,?,?,?,?,?,?)";
		boolean b=false;
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, ms.getSecurity().getId());
		
		
		
		pst.setInt(2, ms.getStock().getId());
		
		
		pst.setDouble(3, ms.getStockCount());
		
		
		
		
		
		pst.setDouble(4, ms.getInPrice());
		
		
		pst.setString(5, ms.getInDate());
		pst.setDouble(6, ms.getInCount());
		pst.setDouble(7, ms.getOutPrice());
		pst.setString(8,ms.getOutDate());
		pst.setDouble(9, ms.getOutCount());
		
	
		int c=pst.executeUpdate();
		if(c>0){
			b=true;
		}
		return b;
	}
	@Override
	public boolean addProfit(Connection con, double profit,int uid) throws SQLException {
		int n=0;
		Statement st=con.createStatement();
		ResultSet rs=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		if(profit>=0){
		rs = st.executeQuery("select id from tab_type where type='投资收入'");
		rs.next();
		int inid=rs.getInt(1);
		n=st.executeUpdate("insert into tab_in values(null,"+uid+",'"+date+"',"+inid+","+profit+")");
		}
		else{
			profit=profit*(-1);
			 rs = st.executeQuery("select id from tab_type where type='投资损失'");
			rs.next();
			int outid=rs.getInt(1);
			n=st.executeUpdate("insert into tab_out values(null,"+uid+",'"+date+"',"+outid+","+profit+")");	
		}
		DBUtil.closeDB(st,rs);
		if(n>0)
		return true;
		return false;
	}

}

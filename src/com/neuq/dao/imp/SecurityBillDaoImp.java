package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.ISecurityBillDao;
import com.neuq.entities.MyStock;
import com.neuq.entities.Security;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class SecurityBillDaoImp implements ISecurityBillDao{

	@Override
	//找到证券账户下流水账信息
	public List<MyStock> selectSecurityBill(Connection con,int accountid) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<MyStock> mss=new ArrayList<MyStock>();
		pst=con.prepareStatement("select stockcode,stockname,inprice,indate,outdate,outprice,outcount from tab_stock ts,tab_mystock tms where ts.id=tms.stockid and accountid=? and tms.outcount>0");
		pst.setInt(1, accountid);
		rs=pst.executeQuery();
		while(rs.next()){
			Stock s=new Stock();
			s.setStockCode(rs.getInt(1));
			s.setStockName(rs.getString(2));
			MyStock ms=new MyStock();
			ms.setStock(s);
			ms.setInPrice(rs.getDouble(3));
			ms.setInDate(rs.getString(4));
			ms.setOutDate(rs.getString(5));
			ms.setOutPrice(rs.getDouble(6));
			ms.setOutCount(rs.getInt(7));
			mss.add(ms);
		}
		DBUtil.closeDB(rs,pst,con);
		return mss;
	}
	public static void main(String[] args) {
		SecurityBillDaoImp s=new SecurityBillDaoImp();
		Connection con=DBUtil.getConnection();
		try {
			System.out.println(s.selectSecurityBill(con,501));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	//查找用户下证券账户
	public List<Security> selectSecurity(Connection con, int id) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Security> ss=new ArrayList<Security>();
		pst=con.prepareStatement("select id,accountname from tab_security where uid=?");
		pst.setInt(1, id);
		rs=pst.executeQuery();
		while(rs.next()){
			Security s=new Security();
			s.setId(rs.getInt(1));
			s.setAccountName(rs.getString(2));
			ss.add(s);
		}
		DBUtil.closeDB(rs,pst,con);
		return ss;
	}
	/*public static void main(String[] args) {
		SecurityBillDaoImp s=new SecurityBillDaoImp();
		Connection con=DBUtil.getConnection();
		try {
			System.out.println(s.selectSecurity(con, 1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Override
	public List<MyStock> pagingSecurityBill(Connection con, int accountid, int reqPage, int showNum) throws SQLException{
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<MyStock> mss=new ArrayList<MyStock>();
		pst=con.prepareStatement("select stockcode,stockname,inprice,indate,outdate,outprice,outcount from tab_stock ts,tab_mystock tms where ts.id=tms.stockid and accountid=? and tms.outcount>0 limit ?,?");
		pst.setInt(1, accountid);
		pst.setInt(2, (reqPage-1)*showNum);
		pst.setInt(3, showNum);
		rs=pst.executeQuery();
		while(rs.next()){
			Stock s=new Stock();
			s.setStockCode(rs.getInt(1));
			s.setStockName(rs.getString(2));
			MyStock ms=new MyStock();
			ms.setStock(s);
			ms.setInPrice(rs.getDouble(3));
			ms.setInDate(rs.getString(4));
			ms.setOutDate(rs.getString(5));
			ms.setOutPrice(rs.getDouble(6));
			ms.setOutCount(rs.getInt(7));
			mss.add(ms);
		}
		DBUtil.closeDB(rs,pst,con);
		return mss;
	}
	@Override
	public int SumSecurityBill(Connection con, int accountid) throws SQLException {
		String sql="select count(*) from tab_mystock where outcount>0 and accountid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, accountid);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int n=rs.getInt(1);
		DBUtil.closeDB(rs,pst);
		return n;
	}

	

}

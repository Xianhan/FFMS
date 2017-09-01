package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neuq.dao.IMyStockAddDao;
import com.neuq.entities.MyStock;
import com.neuq.util.DBUtil;

public class MyStockAddDaoImp implements IMyStockAddDao{

	@Override
	public boolean myStockAdd(Connection con, MyStock ms) throws SQLException {
		PreparedStatement pst=null;
		boolean b=false;
		pst=con.prepareStatement("insert into tab_mystock (id,accountid,stockid,stockcount,inprice,indate,incount) values(null,?,?,?,?,?,?)");
		
		pst.setInt(1, ms.getSecurity().getId());
		pst.setInt(2, ms.getStock().getId());
		pst.setDouble(3, ms.getStockCount());
		pst.setDouble(4, ms.getInPrice());
		pst.setString(5, ms.getInDate());
		pst.setDouble(6, ms.getInCount());
		int n=pst.executeUpdate();
		DBUtil.closeDB(con);
		if(n>0)
			b=true;
		return b;
	}
	/*public static void main(String[] args) {
		MyStockAddDaoImp m=new MyStockAddDaoImp();
		Connection con=DBUtil.getConnection();
		MyStock ms=new MyStock();
		try {
			System.out.println(m.myStockAdd(con,ms ));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}

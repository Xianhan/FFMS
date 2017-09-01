package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.NewsAddress;

import com.neuq.dao.ISelectSaleInfoDao;
import com.neuq.entities.Stock;
import com.neuq.util.DBUtil;

public class SelectSaleInfoDaoImp implements ISelectSaleInfoDao{

	@Override
    //查询要买的股票信息
	public Stock selectSaleInfo(Connection con, int code) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		Stock s=new Stock();
		pst=con.prepareStatement("select id,price from tab_stock where stockcode=?");
		pst.setInt(1, code);
		rs=pst.executeQuery();
		rs.next();
		s.setId(rs.getInt(1));
		s.setPrice(rs.getDouble(2));
		DBUtil.closeDB(rs,pst,con);
		return s;
	}
	/*public static void main(String[] args) {
		SelectSaleInfoDaoImp s=new SelectSaleInfoDaoImp();
		Connection con=DBUtil.getConnection();
		try {
			System.out.println(s.selectSaleInfo(con, 101));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}

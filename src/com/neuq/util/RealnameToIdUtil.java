package com.neuq.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RealnameToIdUtil {
	/**
	 * 这是一个用真实姓名查id的方法
	 * @throws SQLException 
	 */
	public int ToIdUtil(String realname) throws SQLException{
		String sql="SELECT ID FROM tab_worker WHERE realname='"+realname+"'";
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int id=0;
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		if(rs.next()){
			id=rs.getInt(1);
		}
		return id;
		
	}
	//测试以上方法
//	public static void main(String[] args) {
//		RealnameToIdUtil rti=new RealnameToIdUtil();
//		try {
//			int id=rti.ToIdUtil("员工1号");
//			System.out.println(id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	//测试成功
}

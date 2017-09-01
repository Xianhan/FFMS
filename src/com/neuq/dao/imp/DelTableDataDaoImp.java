package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.neuq.dao.IDelTableDataDao;
import com.neuq.util.DBUtil;

public class DelTableDataDaoImp implements IDelTableDataDao{

	@Override
	public boolean DelTableData(Connection con,String tname) throws SQLException {
		PreparedStatement pst=null;
		String sql="delete from "+tname;
		if(tname=="tab_user"){
		sql="delete from tab_user where username<>'admin'";}
		
		pst=con.prepareStatement(sql);
		int s=pst.executeUpdate();
	
		if(s>0)
		return true;
		else
			return false;
	}

}

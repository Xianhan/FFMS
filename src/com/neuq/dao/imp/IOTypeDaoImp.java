package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IIOTypeDao;
import com.neuq.entities.IOType;
import com.neuq.util.DBUtil;

public class IOTypeDaoImp implements IIOTypeDao{

	@Override
	public List<IOType> queryAllInType(Connection con) throws SQLException {
		List<IOType> list=new ArrayList<IOType>();
		String sql="select * from tab_type where status=1";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			IOType in=new IOType();
			in.setId(rs.getInt(1));
			in.setType(rs.getString(2));
			in.setStatus(0);
			list.add(in);
		}
		DBUtil.closeDB(rs,pst);

		return list;
	}

	@Override
	public List<IOType> queryAllOutType(Connection con) throws SQLException {
		List<IOType> list=new ArrayList<IOType>();
		String sql="select * from tab_type where status=0";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			IOType out=new IOType();
			out.setId(rs.getInt(1));
			out.setType(rs.getString(2));
			out.setStatus(0);
			list.add(out);
		}
		DBUtil.closeDB(rs,pst);
		return list;
	
	}
	
}

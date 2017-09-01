package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.IIOTypeBiz;
import com.neuq.dao.IIOTypeDao;
import com.neuq.dao.imp.IOTypeDaoImp;
import com.neuq.entities.IOType;
import com.neuq.util.DBUtil;

public class IOTypeBizImp implements IIOTypeBiz{
	IIOTypeDao iod=new IOTypeDaoImp();
	@Override
	public List<IOType> queryAllInType() {
		List<IOType> list=new ArrayList<IOType>();
		Connection con =DBUtil.getConnection();
		try {
			list=iod.queryAllInType(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		return list;
	}

	@Override
	public List<IOType> queryAllOutType() {
		List<IOType> list=new ArrayList<IOType>();
		Connection con =DBUtil.getConnection();
		try {
			list=iod.queryAllOutType(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		return list;
	}
	
}

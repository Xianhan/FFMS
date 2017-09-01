package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.biz.ISecurityBiz;
import com.neuq.dao.ISecurityDao;
import com.neuq.dao.imp.SecurityDaoImp;
import com.neuq.entities.Security;
import com.neuq.util.DBUtil;

public class SecurityBizImp implements ISecurityBiz{
	ISecurityDao isd=new SecurityDaoImp();
	
	@Override
	public List<Security> SecurityQuery(int uid) {
		Connection con=DBUtil.getConnection();
		List<Security> secarr=new ArrayList<Security>();
		try {
			secarr=isd.SecurityQuery(uid, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return secarr;
	}
	
	@Override
	public boolean SecurityDelete(int securityid) {
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=isd.SecurityDelete(securityid, con);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}
	
	@Override
	public boolean SecurityAdd(Security sec) {
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=isd.SecurityAdd(sec, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public Security ASecurityQuery(int id) {
		Connection con=DBUtil.getConnection();
		Security sec=new Security();
		try {
			sec=isd.ASecurityQuery(id, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sec;
	}

	@Override
	public boolean updateSecurity(Security s) {
		Connection con=DBUtil.getConnection();
		boolean b=false;
		try {
			b=isd.updateSecurity(s, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeDB(con);
		}
		return b;
	}

}

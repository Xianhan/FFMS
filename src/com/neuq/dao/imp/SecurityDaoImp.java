package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.ISecurityDao;
import com.neuq.entities.Security;
import com.neuq.entities.User;
import com.neuq.util.DBUtil;

public class SecurityDaoImp implements ISecurityDao{
	
	/**
	 * 通过uid查询、真实姓名和证券所有账户
	 */
	@Override
	public List<Security> SecurityQuery(int uid,Connection con) throws SQLException {
		
		List<Security> secarr=new ArrayList<Security>();
		String sql="SELECT ts.id,tu.realname,ts.accountname from tab_security ts,tab_user tu where ts.uid="+uid+" and ts.uid=tu.id";
		PreparedStatement pst=null;
		ResultSet rs=null;
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery(sql);
		while(rs.next()){
			Security sec=new Security();
			sec.setId(rs.getInt(1));
			User user=new User();
			user.setRealName(rs.getString(2));
			sec.setUser(user);
			sec.setAccountName(rs.getString(3));
			secarr.add(sec);
		}
		DBUtil.closeDB(pst,rs);
		return secarr;
	}
	/**
	 * 通过证券id删除证券账户信息
	 */
	@SuppressWarnings("null")
	@Override
	public boolean SecurityDelete(int securityid, Connection con) throws SQLException {
		boolean b=false;
		String sql="delete  from tab_security where id="+securityid;
		PreparedStatement pst=con.prepareStatement(sql);
		int c=pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(c>0){
			b=true;
		}
		return b;
	}
	@SuppressWarnings("null")
	@Override
	public boolean SecurityAdd(Security sec, Connection con) throws SQLException {
		boolean b=false;
		String sql="INSERT into tab_security values(null,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, sec.getUser().getId());
		pst.setString(2, sec.getAccountName());
		int c = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(c>0){
			b=true;
		}
		return b;
	}
	@SuppressWarnings("null")
	@Override
	public Security ASecurityQuery(int id, Connection con) throws SQLException {
		Security sec=new Security();
		String sql="select accountname,id from tab_security where id="+id;
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=null;
		rs=pst.executeQuery();
		rs.next();
		sec.setAccountName(rs.getString(1));
		sec.setId(rs.getInt(2));
		DBUtil.closeDB(pst,rs);
		return sec;
	}
	@Override
	public boolean updateSecurity(Security s, Connection con) throws SQLException {
		String sql="update tab_security set accountname=? where id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,s.getAccountName());
		pst.setInt(2, s.getId());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(n>0){
			return true;
		}
		return false;
	}

}

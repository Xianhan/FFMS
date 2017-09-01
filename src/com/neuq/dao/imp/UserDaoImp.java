package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IUserDao;
import com.neuq.entities.User;
import com.neuq.util.DBUtil;

public class UserDaoImp implements IUserDao {

	@Override
	public boolean checkLogin(Connection con, String username, String password) throws SQLException {
		boolean b=false;
		String sql="select * from tab_user where username=? and password=?";
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=null;
		pst.setString(1, username);
		pst.setString(2, password);
		
		rs=pst.executeQuery();
		if(rs.next()){
			b=true;
		}
		DBUtil.closeDB(rs,pst);
		return b;
	}

	@Override
	public User queryUser(Connection con, int id) throws SQLException {
		String sql="select * from tab_user where id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		User u=new User();
		if(rs.next()){
			u.setId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setPassWord(rs.getString(3));
			u.setRealName(rs.getString(4));
			u.setSex(rs.getString(5));
			u.setPhone(rs.getString(6));
			u.setPreOutMoney(rs.getDouble(7));
		}
		DBUtil.closeDB(rs,pst);
		return u;
	}

	@Override
	public User queryUser(Connection con, String username) throws SQLException {
		String sql="select * from tab_user where username=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, username);
		ResultSet rs = pst.executeQuery();
		User u=new User();
		if(rs.next()){
			u.setId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setPassWord(rs.getString(3));
			u.setRealName(rs.getString(4));
			u.setSex(rs.getString(5));
			u.setPhone(rs.getString(6));
			u.setPreOutMoney(rs.getDouble(7));
		}
		DBUtil.closeDB(rs,pst);
		return u;
	}

	@Override
	public boolean updatePwd(Connection con, String username,String password) throws SQLException {
		String sql="update tab_user set password=? where username=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, password);
		pst.setString(2, username);
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(n>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean addUser(Connection con, User u) throws SQLException {
		String sql="insert into tab_user values(null,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, u.getUserName());
		pst.setString(2, u.getPassWord());
		pst.setString(3, u.getRealName());
		pst.setString(4, u.getSex());
		pst.setString(5, u.getPhone());
		pst.setNull(6, 0);
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(n>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(Connection con, User u) throws SQLException {
		String sql="update tab_user set username=?,realname=?,sex=?,phone=?,preoutmoney=? where id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1, u.getUserName());
		pst.setString(2, u.getRealName());
		pst.setString(3, u.getSex());
		pst.setString(4, u.getPhone());
		pst.setDouble(5, u.getPreOutMoney());
		pst.setInt(6, u.getId());
		int n = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if(n>0){
			return true;
		}
		return false;
	}

@Override
	public List<User> selectUser(Connection con) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<User> us=new ArrayList<User>();
		pst=con.prepareStatement("select id,username,realname from tab_user where username<>'admin'");
		rs=pst.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt(1));
			u.setUserName(rs.getString(2));
			u.setRealName(rs.getString(3));
			us.add(u);
		}
		DBUtil.closeDB(rs,pst,con);
		return us;
	}

@Override
public boolean delUserDao(Connection con, int id) throws SQLException {
	PreparedStatement pst=null;
	pst=con.prepareStatement("delete from tab_user where id=?");
	pst.setInt(1, id);
	int a=pst.executeUpdate();
	DBUtil.closeDB(pst,con);
	if(a>0)
	    return true;
	else
		return false;
}
}

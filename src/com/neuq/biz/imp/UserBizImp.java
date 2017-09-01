package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.biz.IUserBiz;
import com.neuq.dao.IUserDao;
import com.neuq.dao.imp.UserDaoImp;
import com.neuq.entities.User;
import com.neuq.util.DBUtil;

public class UserBizImp implements IUserBiz{
	IUserDao iud=new UserDaoImp();
	
	boolean b=false;
	@Override
	public boolean checkLogin(String username, String password) {
		Connection con=DBUtil.getConnection();
		try {
			b=iud.checkLogin(con, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public User queryUser(int id) {
		Connection con=DBUtil.getConnection();
		User u=new User();
		try {
			u=iud.queryUser(con, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(con);
		}
		return u;
	}

	@Override
	public User queryUser(String username) {
		Connection con=DBUtil.getConnection();
		User u=new User();
		try {
			u=iud.queryUser(con, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(con);
		}
		return u;
	}

	@Override
	public boolean updatePwd(String username, String newpassword) {
		Connection con=DBUtil.getConnection();
		try {
			b=iud.updatePwd(con, username, newpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public boolean addUser(User u) {
		Connection con=DBUtil.getConnection();
		try {
			b=iud.addUser(con, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(con);
		}
		return b;
	}

	@Override
	public boolean updateUser(User u) {
		Connection con=DBUtil.getConnection();
		try {
			b=iud.updateUser(con, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtil.closeDB(con);
		}
		return b ;
	}
	@Override
	public List<User> selectUser() {
		IUserDao iud=new UserDaoImp();
		Connection con=DBUtil.getConnection();
		List<User> list=null;
		try {
			list=iud.selectUser(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return list;
	}

	@Override
	public boolean delUser(int id) {
		Connection con=DBUtil.getConnection();
		IUserDao iud=new UserDaoImp();
		boolean b=false;
		try {
			b=iud.delUserDao(con, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return b;
	}

}

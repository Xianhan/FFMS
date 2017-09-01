package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.User;

public interface IUserDao {
	/**
	 * 根据用户名和密码进行登陆检查
	 * @param con
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean checkLogin(Connection con,String username,String password) throws SQLException;
	/**
	 * 根据id查询用户详情
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User queryUser(Connection con,int id) throws SQLException;
	/**
	 * 根据用户名（用户名唯一）查询详细信息
	 * @param con
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public User queryUser(Connection con,String username) throws SQLException;
	/**
	 * 根据用户名修改密码
	 * @param con
	 * @param username
	 * @param newpassword
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePwd(Connection con,String username,String newpassword) throws SQLException;
	/**
	 * 管理员添加成员
	 * @param con
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	public boolean addUser(Connection con,User u)  throws SQLException;
	/**
	 * 根据用户id修改用户信息
	 * @param con
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	public boolean updateUser(Connection con,User u) throws SQLException;
	 /**
     * 查找所有用户
     * @param con
     * @return
     * @throws SQLException
     */
    public List<User> selectUser(Connection con) throws SQLException;

     /**
      * 管理员根据用户id删除用户
      * @param con
      * @param id
      * @return
      * @throws SQLException
      */
	public boolean delUserDao(Connection con,int id) throws SQLException;

}

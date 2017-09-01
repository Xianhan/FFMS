package com.neuq.biz;

import java.util.List;

import com.neuq.entities.User;

public interface IUserBiz {
	/**
	 * 根据用户名和密码进行登陆检查
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String username,String password);
	/**
	 * 根据id查询详细信息
	 * @param id
	 * @return
	 */
	public User queryUser(int id);
	/**
	 * 根据用户名（用户名唯一）查询详细信息
	 * @param realname
	 * @return
	 */
	public User queryUser(String username);
	/**
	 * 根据用户名修改密码
	 * @param username
	 * @param newpassword
	 * @return
	 */
	public boolean updatePwd(String username,String newpassword);
	/**
	 * 管理员添加成员
	 * @param u
	 * @return
	 */
	public boolean addUser(User u);
	/**
	 * 根据用户id修改用户信息
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u);
	/**
	 * 查找所有用户账户名和真实姓名
	 */
	public List<User> selectUser();
	/**
	 * 根据id删除用户
	 */
	public boolean delUser(int id);
}

package com.neuq.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuq.dao.IOutDao;
import com.neuq.entities.IOType;
import com.neuq.entities.Out;
import com.neuq.entities.OutGroupByType;
import com.neuq.entities.User;
import com.neuq.util.DBUtil;

public class OutDaoImp implements IOutDao {

	/**
	 * 添加支出记录
	 * 
	 * @param cost
	 * @return
	 */
	@Override
	public boolean addOut(Out cost, Connection con) throws SQLException {
		PreparedStatement pst = null;
		String addSql = "INSERT into tab_out VALUES(null,?,?,?,?)";// id已经设置为自增
		pst = con.prepareStatement(addSql);
		pst.setInt(1, cost.getUser().getId());
		pst.setString(2, cost.getOutDate());
		pst.setInt(3, cost.getIotype().getId());
		pst.setDouble(4, cost.getOutMoney());
		int count = pst.executeUpdate();
		DBUtil.closeDB(pst);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据用户id查询某时间段某人所有支出记录（如果id=-1，代表查询所有人某时间段所有支出记录，管理员专用，另外的方法）
	 * 
	 * @return
	 */
	@Override
	public List<Out> queryAllOut(int userid, String StartDate, String endDate, Connection con) throws SQLException {
		List<Out> list = new ArrayList<Out>();
		ResultSet rs = null;
		Statement st = null;
		Out out = null;
		String sql = "SELECT o.*,u.*,ty.* FROM tab_out o " + "INNER JOIN tab_user u ON o.uid = u.id "
				+ " INNER JOIN tab_type ty ON o.outtype = ty.id " + "WHERE outdate BETWEEN \'" + StartDate + "\' AND \'"
				+ endDate + "\' AND o.uid =" + userid + " ORDER BY  o.outdate desc ";

		st = con.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			// 创建三个实体对象，分别存放Out outtype,user
			// 创建User对象
			User user = new User();
			user.setId(rs.getInt(6));
			user.setUserName(rs.getString(7));
			user.setPassWord(rs.getString(8));
			user.setRealName(rs.getString(9));
			user.setSex(rs.getString(10));
			user.setPhone(rs.getString(11));
			user.setPreOutMoney(rs.getDouble(12));
			// 创建outtype对象
			IOType outType = new IOType();
			outType.setId(rs.getInt(13));
			outType.setType(rs.getString(14));
			outType.setStatus(rs.getInt(15));
			// 创建out对象
			out = new Out();
			out.setId(rs.getInt(1));
			out.setUser(user);
			out.setOutDate(rs.getString(3));
			out.setIotype(outType);
			out.setOutMoney(rs.getDouble(5));
			// 添加入列表
			list.add(out);
		}
		DBUtil.closeDB(rs, st);
		return list;
	}
	/**
	 * 查询本月总支出
	 * @throws SQLException 
	 */
	@Override
	public double queryCurMonthOutMoney(int username,Connection con) throws SQLException {
		double curMonthOutMoney = 0;
		String querySql = "SELECT SUM(outmoney) AS curMonthOutMoney FROM tab_out WHERE outdate BETWEEN "
				+ "(date_add(curdate(), interval - day(CURDATE()) + 1 day)) AND (CURDATE()) and uid='"+username+"'";
		ResultSet rs = null;
		Statement st = null;
		st = con.createStatement();
		rs = st.executeQuery(querySql);
		rs.next();
		curMonthOutMoney = rs.getDouble(1);
		DBUtil.closeDB(rs,st);
		return curMonthOutMoney;
	}

	/**
	 * 根据id查询条支出信息的内容
	 */
	@Override
	public Out queryByOutId(int id, Connection con) throws SQLException {
		Out out = new Out();
		String querySql = "SELECT o.*,u.*,ty.* FROM tab_out o " + "INNER JOIN tab_user u ON o.uid = u.id "
				+ " INNER JOIN tab_type ty ON o.outtype = ty.id " + "WHERE o.id=" + id;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(querySql);
		rs.next();
		User user = new User();
		user.setId(rs.getInt(6));
		user.setUserName(rs.getString(7));
		user.setPassWord(rs.getString(8));
		user.setRealName(rs.getString(9));
		user.setSex(rs.getString(10));
		user.setPhone(rs.getString(11));
		user.setPreOutMoney(rs.getDouble(12));
		// 创建outtype对象
		IOType outType = new IOType();
		outType.setId(rs.getInt(13));
		outType.setType(rs.getString(14));
		outType.setStatus(rs.getInt(15));
		// 创建out对象
		out.setId(rs.getInt(1));
		out.setUser(user);
		out.setOutDate(rs.getString(3));
		out.setIotype(outType);
		out.setOutMoney(rs.getDouble(5));

		DBUtil.closeDB(st, rs);
		return out;

	}

	/**
	 * 根据支出表的id删除记录
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteOut(int id, Connection con) throws SQLException {
		String deleteSql = "DELETE FROM tab_out WHERE id = " + id;
		Statement st = con.createStatement();
		int result = st.executeUpdate(deleteSql);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 根据支出表id 修改支出信息记录
	 */
	@Override
	public boolean updateOut(int id, Out out, Connection con) throws SQLException {
		String updateSql = "UPDATE tab_out SET outdate = \'" + out.getOutDate() + "\' ,outtype =  "
				+ out.getIotype().getId() + ",outmoney=+" + out.getOutMoney() + " WHERE id =" + id;
		Statement st = con.createStatement();
		int count = st.executeUpdate(updateSql);
		DBUtil.closeDB(st);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 查询家庭某段时间支出的各类型的总金额,管理员专用
	 */
	@Override
	public List<OutGroupByType> queryOutGroupByType(String startDate, String endDate, Connection con)
			throws SQLException {
		PreparedStatement pst = null;
		List<OutGroupByType> list = new ArrayList<OutGroupByType>();
		String querySql = "SELECT o.outtype,ty.type,ty.`status`,SUM(IFNULL(o.outmoney,0)) AS outallmoney "
				+ " FROM tab_out o INNER JOIN tab_user u ON o.uid = u.id INNER JOIN tab_type ty "
				+ " ON o.outtype = ty.id WHERE o.outdate  BETWEEN ? AND ? GROUP BY o.outtype";
		pst = con.prepareStatement(querySql);
		pst.setString(1, startDate);
		pst.setString(2, endDate);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			// 创建对象
			OutGroupByType ogt = new OutGroupByType();
			ogt.setIotypeId(rs.getInt(1));
			ogt.setIoType(rs.getString(2));
			ogt.setStatus(rs.getInt(3));
			ogt.setAllOutMoney(rs.getDouble(4));
			list.add(ogt);
		}
		DBUtil.closeDB(rs, pst);
		return list;
	}

	@Override
	public List<Out> queryPagingOut(int userid, String StartDate, String endDate, Connection con,int reqPage,int showNum) throws SQLException {
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<Out> list=new ArrayList<Out>();
		pst=con.prepareStatement("SELECT o.*,u.*,ty.* FROM tab_out o " + "INNER JOIN tab_user u ON o.uid = u.id "
				+ " INNER JOIN tab_type ty ON o.outtype = ty.id " + "WHERE outdate BETWEEN \'" + StartDate + "\' AND \'"
				+ endDate + "\' AND o.uid =" + userid + " ORDER BY  o.outdate desc limit ?,?");
		pst.setInt(1, (reqPage-1)*10);
		pst.setInt(2, showNum);
		rs=pst.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt(6));
			user.setUserName(rs.getString(7));
			user.setPassWord(rs.getString(8));
			user.setRealName(rs.getString(9));
			user.setSex(rs.getString(10));
			user.setPhone(rs.getString(11));
			user.setPreOutMoney(rs.getDouble(12));
			// 创建outtype对象
			IOType outType = new IOType();
			outType.setId(rs.getInt(13));
			outType.setType(rs.getString(14));
			outType.setStatus(rs.getInt(15));
			// 创建out对象
			Out out = new Out();
			out.setId(rs.getInt(1));
			out.setUser(user);
			out.setOutDate(rs.getString(3));
			out.setIotype(outType);
			out.setOutMoney(rs.getDouble(5));
			// 添加入列表
			list.add(out);
		}
		DBUtil.closeDB(rs,pst);
		return list;
	}

	@Override
	public int sumOut(int userid, String StartDate, String endDate, Connection con)
			throws SQLException {
		int n=0;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		
		 sql="SELECT count(*) FROM tab_out o " + "INNER JOIN tab_user u ON o.uid = u.id "
				+ " INNER JOIN tab_type ty ON o.outtype = ty.id " + "WHERE outdate BETWEEN \'" + StartDate + "\' AND \'"
				+ endDate + "\' AND o.uid =" + userid + " ORDER BY  o.outdate desc ";
		
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		rs.next();
		n=rs.getInt(1);
		return n;
	}

}

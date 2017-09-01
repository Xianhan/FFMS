package com.neuq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.entities.MyStock;
import com.neuq.entities.Security;

public interface ISecurityBillDao {
    //证券流水账Dao接口
	public List<MyStock> selectSecurityBill(Connection con,int accountid) throws SQLException;
    //根据用户id查找证券id	
	public List<Security>  selectSecurity(Connection con,int id)throws SQLException;
	//分页查询
	public List<MyStock> pagingSecurityBill(Connection con,int accountid,int reqPage,int showNum) throws SQLException;
	//查询总交易条数
	public int SumSecurityBill(Connection con,int accountid) throws SQLException; 
}

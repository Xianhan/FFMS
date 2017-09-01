package com.neuq.biz;

import java.sql.Connection;
import java.util.List;

import com.neuq.entities.MyStock;
import com.neuq.entities.Security;

public interface ISecurityBillBiz {
	//查询证券流水账biz接口
	public List<MyStock> selectSecurityBillBiz(int accountid);
	//查询用户下证券账户
	public List<Security> selectSecurityBiz(int id);
	//分页查询证券流水账
	public List<MyStock> pagingSecurityBillBiz(int account,int reqPage,int showNum);
	//查询总交易条数
	public int SumSecurityBill( int accountid);
}

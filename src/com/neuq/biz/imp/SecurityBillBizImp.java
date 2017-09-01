package com.neuq.biz.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neuq.biz.ISecurityBillBiz;
import com.neuq.dao.ISecurityBillDao;
import com.neuq.dao.imp.SecurityBillDaoImp;
import com.neuq.entities.MyStock;
import com.neuq.entities.Security;
import com.neuq.util.DBUtil;

public class SecurityBillBizImp implements ISecurityBillBiz{

	@Override
	//查询证券流水账biz实现
	public List<MyStock> selectSecurityBillBiz(int accountid) {
		ISecurityBillDao isbd=new SecurityBillDaoImp();
		Connection con=DBUtil.getConnection();
		List<MyStock> list=null;
		try {
			list=isbd.selectSecurityBill(con, accountid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return list;
	}
	/*public static void main(String[] args) {
		SecurityBillBizImp s=new SecurityBillBizImp();
		System.out.println(s.selectSecurityBillBiz(501));
	}*/

	@Override
	//查询用户下证券账户
	public List<Security> selectSecurityBiz(int id) {
		
			ISecurityBillDao isbd=new SecurityBillDaoImp();
			Connection con=DBUtil.getConnection();
			List<Security> list=null;
			try {
				list=isbd.selectSecurity(con, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeDB(con);
			}
		return list;
	}

	@Override
	public List<MyStock> pagingSecurityBillBiz(int account, int reqPage, int showNum) {
		ISecurityBillDao isbd=new SecurityBillDaoImp();
		Connection con=DBUtil.getConnection();
		List<MyStock> list=null;
		try {
			list=isbd.pagingSecurityBill(con, account, reqPage, showNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return list;
	}

	@Override
	public int SumSecurityBill(int accountid) {
		ISecurityBillDao isbd=new SecurityBillDaoImp();
		Connection con=DBUtil.getConnection();
		int n=0;
		try {
			n=isbd.SumSecurityBill(con, accountid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeDB(con);
		}
		
		return n;
	}

	
}

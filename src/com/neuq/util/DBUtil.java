package com.neuq.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {

	public static Connection getConnection() {
//		Connection con = null;
//		String url = "jdbc:mysql://localhost:3306/db_neuq";
//		String user = "root";
//		String password = "123456";
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		} 
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
//	}
		Context context;
		Connection conn=null;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)
			context.lookup("java:comp/env/jdbc/FFMS");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	
	}
	/**
	 *关闭PrepareStatement，Connection，Statement，Resultset对象
	 * @param args
	 */
	public static void closeDB(Object... args) {
		if (args == null) {
			return;
		}
		try {
			for (int i = 0; i < args.length; i++) {
				if (args[i] != null && args[i] instanceof PreparedStatement) {
					((PreparedStatement) args[i]).close();
				}
				if (args[i] != null && args[i] instanceof Connection) {
					((Connection) args[i]).close();
				}
				if (args[i] != null && args[i] instanceof ResultSet) {
					((ResultSet) args[i]).close();
				}
				if (args[i] != null && args[i] instanceof Statement) {
					((Statement) args[i]).close();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int update(String sql,Object...args){
		int row=0;
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		try{
		if(sql==null||sql==""){
			return row;
		}else{
			pst=con.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				pst.setObject(i+1, args[i]);
			}
			row = pst.executeUpdate();
		}
		}catch (Exception e) {
			System.out.println(row);
		}
		return row;
		}
	public static <T>ArrayList<T> query(Class<T> cls,String sql,Object...args){
		ArrayList<T> list=new ArrayList<T>();
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
		if(sql==null||sql==""){
			return null;
		}
		pst=con.prepareStatement(sql);
		if(args!=null){
			for(int i=0;i<args.length;i++){
				pst.setObject(i+1, args[i]);
			}
			rs=pst.executeQuery();//获得结果集
			ResultSetMetaData metaData = rs.getMetaData();//获得结果集结构
			int cols=metaData.getColumnCount();
			while(rs.next()){
			
				T t=(T)cls.newInstance();
				for(int j=0;j<cols;j++){
					Object val=rs.getObject(j+1);
					String name=metaData.getColumnClassName(j+1);
					Field filed = cls.getDeclaredField(name);
					if(!Modifier.isPublic(filed.getModifiers())){
						filed.setAccessible(true);
						filed.set(t, val);
					}
			}
				list.add(t);
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		}
	public static void main(String[] args) {
		String sql="insert into tab_user(username,password,realname,sex,phone,allmoney) values "+
	"(?,?,?,?,?,?)";
		Object param[]={"mql","123456","慕全利","男","18716031056",1000};
		System.out.println(DBUtil.update(sql, param));
	}
}

package com.neuq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * java.util.Dateתsql.Date
	 * @param d
	 * @return
	 */
	public static java.sql.Date utilDateToSqlDate(java.util.Date d) {
		java.sql.Date sqlDate=new java.sql.Date(d.getTime());
		return sqlDate;
	}
	
	/**
	 * java.sql.Dateתutil.Date
	 * @param d
	 * @return
	 */
	public static java.util.Date sqlDateToUtilDate(java.sql.Date d) {
		java.util.Date utildate=new java.util.Date (d.getTime());
		return utildate;
	}
	
	/**
	* ����ת�����ַ���
	* @param date 
	* @return str
	*/
	public static String DateToStr(java.util.Date date) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
	   String str = format.format(date);
	   return str;
	} 

	/**
	* �ַ���ת��������
	* @param str
	* @return date
	*/
	public  Date StrToDate(String str) {
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   java.util.Date date = null;
	   try {
	    date = format.parse(str);
	   } catch (ParseException e) {
	    e.printStackTrace();
	   }
	   return date;
	}
	public static void main(String[] args) {
		DateUtil d=new DateUtil();
		//d.StrToDate("2000-10-20 14:20:00");
		System.out.println(d.StrToDate("2000-10-20 14:20:00"));
	}
	
	
}

package com.neuq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthUtil {
	public static String QueryCurrentMonth(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String month = sdf.format(new Date());
		
		return month;
	}
	//	测试
//	public static void main(String[] args) {
//		String month1=MonthUtil.QueryCurrentMonth();
//		System.out.println(month1);
//	}
}

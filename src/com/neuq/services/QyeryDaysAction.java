package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IGateCardBiz;
import com.neuq.biz.imp.GateCardBizImp;

public class QyeryDaysAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int days = 0;
		Date date = new Date();

		Calendar calendar = new GregorianCalendar();

		calendar.setTime(date);

		calendar.add(calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动

		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		IGateCardBiz igcb = new GateCardBizImp();
		List<String> allDay = igcb.queryAllDay((int)session.getAttribute("userid"));
		if ((days=igcb.queryDays(new java.sql.Date(new Date().getTime()).toString(), (int) session.getAttribute("userid"))) == 0)
			days = igcb.queryDays(new java.sql.Date(date.getTime()).toString(), (int) session.getAttribute("userid"));
		String s=f(allDay);
		session.setAttribute("allday", s);
		session.setAttribute("days", days);
		response.sendRedirect("user/GateCard.jsp");
	}
	public String f(List<String> a ){
		String s="";
		for(int i=0;i<a.size();i++){
			s+=a.get(i).substring(8)+",";
		}
		s=s.substring(0,s.length()-1);
		return s;
	}
}

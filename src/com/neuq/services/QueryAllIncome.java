package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IIncomeBiz;
import com.neuq.biz.imp.IncomeBizImp;
import com.neuq.entities.Income;
import com.neuq.entities.Paging;
import com.neuq.util.MonthUtil;

public class QueryAllIncome extends HttpServlet {

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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		IIncomeBiz iib = new IncomeBizImp();
		String month = MonthUtil.QueryCurrentMonth();
		String StartDate = null;
		String endDate = null;
		// 判断是否提交了分段时间的表单
		if (request.getParameter("startDate") == null || request.getParameter("endDate") == null
				|| request.getParameter("startDate") == "" || request.getParameter("endDate") == "") {
			StartDate = month.substring(0, 7) + "-01";
			endDate = month;
		} else {
			StartDate = (String) request.getParameter("startDate");
			endDate = (String) request.getParameter("endDate");
		}
		List<Income> inarr = new ArrayList<Income>();
		String reqPage = request.getParameter("reqPage");

		if (reqPage != null) {
			int n = iib.sumIncome(userid, StartDate, endDate);
			Paging page = new Paging(n, 10);
			page.doPaging(Integer.parseInt(reqPage));
			inarr = iib.pagingIncome(userid, StartDate, endDate, Integer.parseInt(reqPage), 10);
			session.setAttribute("page", page);
			
		}else{
			inarr=iib.queryAllIncome(userid, StartDate, endDate);
		}
	
		session.setAttribute("inarr", inarr);
		session.setAttribute("startDate", StartDate);
		session.setAttribute("endDate", endDate);
		response.sendRedirect("user/user_in_query.jsp");
	}

}

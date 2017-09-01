package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IIncomeBiz;
import com.neuq.biz.imp.IncomeBizImp;
import com.neuq.entities.Income;
import com.neuq.entities.Paging;
import com.neuq.util.MonthUtil;

@WebServlet(name = "QueryAUserIncome",urlPatterns="/QueryAUserIncome")
public class QueryAUserIncome extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		//设置编码utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int auserincomeid = Integer.parseInt(request.getParameter("auserincomeid"));
		session.setAttribute("auserincomeid", auserincomeid);
		IIncomeBiz iib = new IncomeBizImp();
		//查询当前系统日期
		String month = MonthUtil.QueryCurrentMonth();
		String StartDate = null;
		String endDate = null;
		// 判断是否提交了分段时间的表单
		//如果没填开始时间和结束时间，将默认查询本月1日-当前日
		if (request.getParameter("startDate") == null || request.getParameter("endDate") == null
				|| request.getParameter("startDate") == "" || request.getParameter("endDate") == "") {
			StartDate = month.substring(0, 7) + "-01";
			endDate = month;
		} else {
		//
			StartDate = (String) request.getParameter("startDate");
			endDate = (String) request.getParameter("endDate");
		}
		List<Income> inarr = new ArrayList<Income>();
		
		String reqPage = request.getParameter("reqPage");
		System.out.println(reqPage);
		System.out.println(auserincomeid);
		if (reqPage != null) {
			int n = iib.sumIncome(auserincomeid, StartDate, endDate);
			System.out.println(n);
			Paging page = new Paging(n, 10);
			page.doPaging(Integer.parseInt(reqPage));
			inarr = iib.pagingIncome(auserincomeid, StartDate, endDate, Integer.parseInt(reqPage), 10);
			session.setAttribute("page", page);	
		}else{
			inarr=iib.queryAllIncome(auserincomeid, StartDate, endDate);
		}
		System.out.println(inarr.size());
		session.setAttribute("inarr", inarr);
		session.setAttribute("startDate", StartDate);
		session.setAttribute("endDate", endDate);
		response.sendRedirect("admin/admin_in_a_query.jsp");
	}

}

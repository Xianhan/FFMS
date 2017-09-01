package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IIncomeBiz;
import com.neuq.biz.imp.IncomeBizImp;
import com.neuq.entities.IOType;
import com.neuq.entities.Income;

public class UpdateIncome extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		//获取页面修改的值
		int incomeid=Integer.parseInt(request.getParameter("incomeid"));
		String incomeDate = request.getParameter("incomeDate");
		int intype = Integer.parseInt((String)request.getParameter("intype"));
		double incomeMoney = Double.parseDouble((String)request.getParameter("incomeMoney"));
		//创建income对象
		Income income=new Income();
		IOType iotype=new IOType();
		income.setId(incomeid);
		income.setIncomeDate(incomeDate);
		iotype.setId(intype);
		income.setIotype(iotype);
		income.setIncomeMoney(incomeMoney);
		IIncomeBiz iib=new IncomeBizImp();
		iib.updateIncome(incomeid, income);
		response.sendRedirect("QueryAllIncome");
		
		
	}

}

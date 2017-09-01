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
import com.neuq.entities.Income;

public class QueryIncome extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		int incomeid=Integer.parseInt(request.getParameter("incomeid"));
		
		Income income=new Income();
		IIncomeBiz iib=new IncomeBizImp();
		income=iib.queryByIncomeId(incomeid);
		session.setAttribute("income", income);
		response.sendRedirect("user/user_in_update.jsp?incomeid="+incomeid);
		
	}

}

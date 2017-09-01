package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IGateCardBiz;
import com.neuq.biz.imp.GateCardBizImp;
import com.neuq.entities.GateCard;
import com.neuq.entities.User;

public class GateCardAction extends HttpServlet {

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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String date = new java.sql.Date(new java.util.Date().getTime()).toString();
		int days = (int) session.getAttribute("days") + 1;
		int userid = (int) session.getAttribute("userid");
		GateCard gatecard = new GateCard();
		gatecard.setDate(date);
		User user = new User();
		user.setId(userid);
		gatecard.setUser(user);
		gatecard.setDays(days);
		IGateCardBiz igcb = new GateCardBizImp();
		boolean b = igcb.signOn(gatecard);

		response.sendRedirect("QyeryDaysAction");

	}

}

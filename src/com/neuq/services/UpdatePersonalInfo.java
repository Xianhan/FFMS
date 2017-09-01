package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IUserBiz;
import com.neuq.biz.imp.UserBizImp;
import com.neuq.entities.User;

public class UpdatePersonalInfo extends HttpServlet {

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
		IUserBiz iub = new UserBizImp();
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String preoutmoney=request.getParameter("preoutmoney");
		User u = new User();
		int id=(int) session.getAttribute("userid");
		u.setId(id);
		u.setPhone(phone);
		u.setUserName(username);
		u.setRealName(realname);
		u.setSex(sex);
		u.setPreOutMoney(Double.parseDouble(preoutmoney));
		if (iub.updateUser(u)) {
			response.sendRedirect("index.html?taget=_top");
		}
	}
}

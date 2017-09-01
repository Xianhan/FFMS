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

public class UpdatePwdAction extends HttpServlet {

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

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			IUserBiz iub=new UserBizImp();
			PrintWriter out = response.getWriter();
			String oldpassword=request.getParameter("password");
			String newpassword=request.getParameter("newpassword");
			String username=(String) session.getAttribute("username");
			if(iub.checkLogin(username, oldpassword)){
				iub.updatePwd((String) session.getAttribute("username"), newpassword);
				response.sendRedirect("login.html");
			}
			else{
				out.print("操作失败");
			}
			out.flush();
			out.close();
	}

}

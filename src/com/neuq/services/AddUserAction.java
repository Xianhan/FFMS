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

public class AddUserAction extends HttpServlet {

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
	 * 
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("action"));
		IUserBiz iub = new UserBizImp();
		HttpSession session = request.getSession();
		if (request.getParameter("add") != null) {
			String username = request.getParameter("uname");
			String password = request.getParameter("password");
			String realname = request.getParameter("realname");
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			User u = new User(username, password, realname, sex, phone);
			if (iub.addUser(u)) {
				response.sendRedirect("admin/admin_create_user.html");
			}
		}
		
		if(request.getParameter("show")!=null){
			String username=(String) session.getAttribute("username");
			User u=iub.queryUser(username);
			session.setAttribute("user", u);
			response.sendRedirect("user/user_personalInfo_update.jsp");
		}
		
//		if(request.getParameter("action").equals("pwd")){
//			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
//		}
	}
}

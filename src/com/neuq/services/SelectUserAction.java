package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.UserBizImp;
import com.neuq.dao.imp.UserDaoImp;
import com.neuq.entities.User;


@WebServlet("/SelectUserAction")
public class SelectUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserBizImp ubi=new UserBizImp();
		List<User> us=ubi.selectUser();
		session.setAttribute("Users", us);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		response.sendRedirect("CheckLogin?username="+username+"&password="+password);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

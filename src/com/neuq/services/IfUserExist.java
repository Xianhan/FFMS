package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.biz.IUserBiz;
import com.neuq.biz.imp.UserBizImp;


@WebServlet("/IfUserExist")
public class IfUserExist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		IUserBiz iub=new UserBizImp();
	
		if(iub.queryUser(username).getUserName()==null){
			out.print("true");
		}
		else
		out.print("false");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

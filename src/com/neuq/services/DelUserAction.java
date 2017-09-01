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


@WebServlet("/DelUserAction")
public class DelUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 String uid=(String) request.getParameter("id");
         int id=Integer.parseInt(uid);
		 IUserBiz iub=new UserBizImp();
		 boolean b=iub.delUser(id);
		 if(b==true)
			 response.sendRedirect("DelSelectUserAction");
		 else
			 out.print("删除失败");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

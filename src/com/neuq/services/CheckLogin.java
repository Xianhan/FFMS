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

public class CheckLogin extends HttpServlet {

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

		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		IUserBiz iub=new UserBizImp();
		if(iub.checkLogin(username, password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			User u=new User();
			u=iub.queryUser(username);
			session.setAttribute("userid", u.getId());
			session.setAttribute("realname", u.getRealName());
			if(username.equals("admin")){
			out.print("admin");
			}else{
				out.print("user");
			}
			
		}else{
			out.print("false");
			
		}
		out.flush();
		out.close();
		
	}

}

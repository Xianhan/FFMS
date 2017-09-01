package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.ISecurityBiz;
import com.neuq.biz.imp.SecurityBizImp;
import com.neuq.entities.Security;
import com.neuq.entities.User;

public class UpdateAccountAction extends HttpServlet {

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
		ISecurityBiz isb=new SecurityBizImp();
		PrintWriter out = response.getWriter();
		if(request.getParameter("update")!=null){
			int id=Integer.parseInt(request.getParameter("accountid"));
			String accountname=request.getParameter("accountname");
			Security s=new Security();
			s.setId(id);
			s.setAccountName(accountname);
			if(isb.updateSecurity(s)){
				response.sendRedirect("QuerySecurity");
			}
		}
		
		else if(request.getParameter("add")!=null){
			String accountname=request.getParameter("accountname");
			int userid=(int)(session.getAttribute("userid"));
			Security s=new Security();
			s.setAccountName(accountname);
			User user=new User();
			user.setId(userid);
			s.setUser(user);
			if(isb.SecurityAdd(s)){
				response.sendRedirect("QuerySecurity");
			}else{
				out.print("操作失败");
				out.flush();
				out.close();
			}
		}
		else{
		String id=request.getParameter("accountid");
		System.out.println(id);
		Security sec = isb.ASecurityQuery(Integer.parseInt(id));
		System.out.println(sec);
		session.setAttribute("sec", sec);
		response.sendRedirect("user/user_security_update.jsp");
	}
	}
}

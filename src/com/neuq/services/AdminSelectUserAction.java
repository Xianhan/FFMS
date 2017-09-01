package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.SecurityBillBizImp;
import com.neuq.entities.Security;


@WebServlet("/AdminSelectUserAction")
public class AdminSelectUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminSelectUserAction() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
         String uid=(String) request.getParameter("id");
         int id=Integer.parseInt(uid);
         //System.out.println(id);
		 SecurityBillBizImp sbbi=new SecurityBillBizImp();
		 List<Security> ss=sbbi.selectSecurityBiz(id);
		 session.setAttribute("SelectSecurity", ss);
		
		 response.sendRedirect("user/user_security_list.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

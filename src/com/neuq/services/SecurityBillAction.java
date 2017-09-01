package com.neuq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.SecurityBillBizImp;
import com.neuq.entities.MyStock;
import com.neuq.entities.Paging;



@WebServlet("/SecurityBillAction")
public class SecurityBillAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         HttpSession session=request.getSession();
         String aid=(String) request.getParameter("accountid");
         int accountid=Integer.parseInt(aid);
         session.setAttribute("aid", accountid);
		 SecurityBillBizImp sbbi=new SecurityBillBizImp();
		 String reqPage=request.getParameter("reqPage");
		 
		 List<MyStock> mss=new ArrayList<MyStock>();
		 if(reqPage!=null){
			 int totalRow=sbbi.SumSecurityBill(accountid);
			 Paging page=new Paging(totalRow, 10);
			 page.doPaging(Integer.parseInt(reqPage));
			
			 mss=sbbi.pagingSecurityBillBiz(accountid, page.getReqPage(), page.getShowNum());
			 session.setAttribute("page", page);
		 }
		 else{
		 mss=sbbi.selectSecurityBillBiz(accountid);
		 }
		 session.setAttribute("SecurityBill", mss);
		
		 //System.out.println(mss.get(0).getStock().getStockName());
		 response.sendRedirect("user/user_security_bill.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

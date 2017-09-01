package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IOutBiz;
import com.neuq.biz.IUserBiz;
import com.neuq.biz.imp.OutBizImp;
import com.neuq.biz.imp.UserBizImp;


@WebServlet("/PreOutCompareAction")
public class PreOutCompareAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		IOutBiz ibz =new OutBizImp();
		IUserBiz iub =new UserBizImp();
		double outSum=ibz.queryCurMonthOutMoney((int)session.getAttribute("userid"));
		
		double preOut=iub.queryUser((String)session.getAttribute("username")).getPreOutMoney();
	
		if(outSum>=(preOut*0.8))
			out.print("true");
		else
			out.print("false");
		out.flush();
		out.close();
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

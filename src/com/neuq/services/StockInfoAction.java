package com.neuq.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.StockInfoBizImp;
import com.neuq.entities.Stock;


@WebServlet("/StockInfoAction")
public class StockInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		StockInfoBizImp sibi=new StockInfoBizImp();
		List<Stock> ss=sibi.selectStockInfoBiz();
		session.setAttribute("Stock", ss);
		System.out.println(ss);
		response.sendRedirect("StockInfo.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

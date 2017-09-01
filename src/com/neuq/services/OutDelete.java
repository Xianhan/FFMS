package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.biz.IOutBiz;
import com.neuq.biz.imp.OutBizImp;

/**
 * 删除指定支出信息
 * @author Calvin
 *
 */
@WebServlet(name = "OutDelete",urlPatterns="/OutDelete")
public class OutDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest reqsuest, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行啦");
		response.setContentType("text/html");
		reqsuest.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		IOutBiz iobz = new OutBizImp();
		int outid = Integer.parseInt(reqsuest.getParameter("outid"));
		
		iobz.deleteOut(outid);
		response.sendRedirect("OutList");
		
	}
}

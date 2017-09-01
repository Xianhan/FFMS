package com.neuq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IIOTypeBiz;
import com.neuq.biz.imp.IOTypeBizImp;
import com.neuq.entities.IOType;

public class QueryAllIOTypeAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IIOTypeBiz iotd = new IOTypeBizImp();
		List<IOType> inlist = new ArrayList<IOType>();
		inlist = iotd.queryAllInType();
		List<IOType> outlist = new ArrayList<IOType>();
		outlist = iotd.queryAllOutType();
		HttpSession session = request.getSession();
		session.setAttribute("inlist", inlist);
		session.setAttribute("outlist", outlist);
		// 判断需要跳转到哪个页面
		int iopages = Integer.parseInt((String) request.getParameter("iopages"));// 获取到要跳转到哪个页面的数字
		// System.out.println(iopages);
		if (iopages == 5) {// 如果为5转到用户修改支出信息页面
			int outid = Integer.parseInt((String) request.getParameter("outid"));
			response.sendRedirect("OutUpdateContent?outid=" + outid);
		} else if (iopages == 6) {// 为6跳转到用户支出信息添加页面
			response.sendRedirect("user/user_out_add.jsp");
		} else if (iopages == 1) {// 为1跳转到用户添加收入信息页面
			response.sendRedirect("user/user_in_add.jsp");
		} else if (iopages == 2) {// 为2跳转到用户修改servlet
			int incomeid = Integer.parseInt(request.getParameter("incomeid"));
			response.sendRedirect("QueryIncome?incomeid=" + incomeid);
		} else {
			
		}

	}

}

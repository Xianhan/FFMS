package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IDelTableDataBiz;
import com.neuq.biz.imp.DelTableDataBizImp;

@WebServlet("/TablesAction")
public class TablesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		List<String> ts = new ArrayList<String>();
		ts.add("tab_in");
		ts.add("tab_out");
		ts.add("tab_mystock");
		ts.add("tab_security");
		ts.add("tab_user");
		IDelTableDataBiz idtdb = new DelTableDataBizImp();
		for (int i = 0; i < ts.size(); i++) {
			boolean b = idtdb.DelTableDataBizImp(ts.get(i));
			if (b == false) {
				out.print(false);
				return;
			}
		}
		out.print("ok");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

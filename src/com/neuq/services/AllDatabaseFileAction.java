package com.neuq.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 此servlet用于获得可下载的文件名称
 * 
 * @author MQL
 *
 */

@WebServlet("/WatchAction")
public class AllDatabaseFileAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllDatabaseFileAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		File fi = new File("d:\\database");
		if (!(fi.exists())) {
			fi.mkdir();
		}
		File[] ls = fi.listFiles();
		String[] files = new String[ls.length];
		for (int i = 0; i < ls.length; i++) {
			files[i] = ls[i].getName();
		}
		System.out.println(files[0]);
		session.setAttribute("files", files);
		response.sendRedirect("admin/RecoverDatabase.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

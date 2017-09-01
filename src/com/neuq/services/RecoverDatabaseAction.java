package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuq.util.MysqlDatabaseImportUtil;

public class RecoverDatabaseAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String sqlFileName = request.getParameter("filename");
		if (MysqlDatabaseImportUtil.importDatabase("127.0.0.1", "root", "123456", "d:/database", sqlFileName,
				"db_neuq")) {
			out.print("ok");
		} else {
			out.print("false");
		}
		out.flush();
		out.close();
	}

}

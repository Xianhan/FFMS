package com.neuq.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IOutBiz;
import com.neuq.biz.imp.OutBizImp;
import com.neuq.entities.Out;

/**
 * 更新指定支出信息的详细内容
 * @author Calvin
 *
 */
@WebServlet(name = "OutUpdateContent",urlPatterns="/OutUpdateContent")
public class OutUpdateContent extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int outid = Integer.parseInt(request.getParameter("outid"));
		
		IOutBiz iobz = new OutBizImp();
		
		Out outContent = iobz.queryByOutId(outid);
		session.setAttribute("outContent",outContent);
		response.sendRedirect("user/user_out_update.jsp");
	}

}

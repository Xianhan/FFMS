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
import com.neuq.entities.IOType;
import com.neuq.entities.Out;
import com.neuq.entities.User;

/**
 * 添加新的支出信息
 * @author Calvin
 *
 */
@WebServlet(name="OutAdd",urlPatterns="/OutAdd")
public class OutAdd extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int id = (int)session.getAttribute("userid");//用户id
		double outMoney = Double.parseDouble(request.getParameter("outmoney"));
		int iotypeid = Integer.parseInt(request.getParameter("outtype"));
		String outDate = request.getParameter("outdate");
		
		
		User u = new User();
		u.setId(id);
		IOType ioType = new IOType();
		ioType.setId(iotypeid);
		Out out = new Out();
		out.setIotype(ioType);
		out.setUser(u);
		out.setOutMoney(outMoney);
		out.setOutDate(outDate);
		
		IOutBiz iobz = new OutBizImp();
		iobz.addOut(out);
		response.sendRedirect("OutList?reqPage=1");
	}

}

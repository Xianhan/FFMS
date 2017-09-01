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

/**
 * 修改指定支出信息
 * @author Calvin
 *
 */
@WebServlet(name = "OutUpdate",urlPatterns = "/OutUpdate")
public class OutUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		//获取页面输入修改值
		int outid = Integer.parseInt(request.getParameter("outid"));
		String outdate = request.getParameter("outdate");
		int outtype = Integer.parseInt((String)request.getParameter("outtype"));
		double outmoney = Double.parseDouble((String)request.getParameter("outmoney"));
		//创建Out对象
		Out out = new Out();
		out.setOutDate(outdate);
		out.setOutMoney(outmoney);
		IOType iot = new IOType();
		iot.setId(outtype);
		out.setIotype(iot);
		//修改数据库
		IOutBiz iob = new OutBizImp();
		iob.updateOut(outid, out);
		
		response.sendRedirect("OutList");

	}

}

package com.neuq.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMyStockBiz;
import com.neuq.biz.imp.MyStockBizImp;
import com.neuq.entities.MyStock;

public class OwnStockAction extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sercurityId=Integer.parseInt(request.getParameter("accountid"));
		
		IMyStockBiz imsb =new MyStockBizImp();
		List<MyStock> mystocklist= imsb.queryMyStock(sercurityId);
		HttpSession session = request.getSession();
		session.setAttribute("accountid", sercurityId);
		HashMap<String, MyStock> map=new HashMap<String, MyStock>();
		for(int i=0;i<mystocklist.size();i++){
			double updown=(0.9+Math.random()*0.2)*mystocklist.get(i).getInPrice();
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.00");  
			  String num=df.format(updown);
			map.put(num, mystocklist.get(i));
		}
		session.setAttribute("map", map);
		response.sendRedirect("user/user_stock_manage.jsp");
	}

}

package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMyStockBiz;
import com.neuq.biz.imp.MyStockBizImp;
import com.neuq.entities.MyStock;
import com.neuq.entities.Security;
import com.neuq.entities.Stock;

public class UpdateMyStockAction extends HttpServlet {


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
		MyStock mystock=new MyStock();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int stockid=Integer.parseInt(request.getParameter("stockid"));
		mystock.setId(stockid);
		int accountid=(int)session.getAttribute("accountid");
		Security s=new Security();
		s.setId(accountid);
		mystock.setSecurity(s);
		Stock stock=new Stock();
		
		stock.setId(Integer.parseInt(request.getParameter("stocksid")));
		mystock.setStock(stock);
		int num=Integer.parseInt(request.getParameter("num"));
		mystock.setStockCount(Integer.parseInt(request.getParameter("stockcount"))-num);
		mystock.setInPrice(Double.parseDouble(request.getParameter("inprice")));
		mystock.setInDate(request.getParameter("indate"));
		mystock.setInCount(Integer.parseInt(request.getParameter("incount")));
		mystock.setOutPrice(Double.parseDouble(request.getParameter("outprice")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		mystock.setOutDate(date);
		mystock.setOutCount(num);
		double outprice=Double.parseDouble(request.getParameter("outprice"));
		double inprice=Double.parseDouble(request.getParameter("inprice"));
		double profit=outprice-inprice;
		IMyStockBiz imsb=new MyStockBizImp();
		if(imsb.updateMyStock(stockid, num,profit*num,(int)session.getAttribute("userid"))){
			if(!imsb.AddMyStock(mystock)){
				out.println("操作失败");	
			}else{
				response.sendRedirect("OwnStockAction?accountid="+accountid);
			}
		}
		else{
			out.println("操作失败");	
		}
		
		out.flush();
		out.close();
	}

}

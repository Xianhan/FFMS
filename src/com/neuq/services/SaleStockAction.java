package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.imp.MyStockAddBizImp;
import com.neuq.biz.imp.SelectSaleInfoBizImp;
import com.neuq.entities.MyStock;
import com.neuq.entities.Security;
import com.neuq.entities.Stock;


@WebServlet("/SaleStockAction")
public class SaleStockAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		//获得accountid
		int accountid=(int) session.getAttribute("accountid");
		
		Security security=new Security();
		security.setId(accountid);
		//System.out.println(accountid);
		//获得买的股票代码
		String scode= request.getParameter("stocknum");
		int stockcode=Integer.parseInt(scode);
		//获得买的股票数量
		String scount= request.getParameter("count");
		int count=Integer.parseInt(scount);
		//获得买股时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		
		SelectSaleInfoBizImp ssibi=new SelectSaleInfoBizImp();
		Stock s=ssibi.selectSaleInfo(stockcode);
		if(s==null){
			out.print("该股票不存在");
			return;
		}
		//System.out.println(s);
		
		MyStock ms=new MyStock();
		ms.setId(stockcode);
		ms.setStock(s);
		ms.setInPrice(s.getPrice());
		ms.setSecurity(security);
		ms.setInCount(count);
		ms.setInDate(date);
		ms.setStockCount(count);
		System.out.println(ms);
		MyStockAddBizImp msabi=new MyStockAddBizImp();
		boolean b=msabi.addMyStock(ms);
		if(b)
			response.sendRedirect("OwnStockAction?accountid="+accountid);
		else
			out.print("购买失败");
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

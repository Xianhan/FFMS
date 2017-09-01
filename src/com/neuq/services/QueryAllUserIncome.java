package com.neuq.services;

import java.io.IOException;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuq.biz.IIncomeBiz;
import com.neuq.biz.imp.IncomeBizImp;
import com.neuq.entities.InGroupByType;
import com.neuq.util.MonthUtil;

@WebServlet(name="QueryAllUserIncome",urlPatterns="/QueryAllUserIncome")
public class QueryAllUserIncome extends HttpServlet {

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

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String month=MonthUtil.QueryCurrentMonth();
		String StartDate=request.getParameter("startDate");
		String endDate=request.getParameter("startDate");
		System.out.println(StartDate);
		System.out.println(endDate);
		//判断是否提交了分段时间的表单
				if(request.getParameter("startDate")==null||request.getParameter("endDate")==null||request.getParameter("startDate")==""||request.getParameter("endDate")==""){
					StartDate=month.substring(0,7)+"-01";
					endDate=month;
				}else{
					StartDate=(String)request.getParameter("startDate");
					endDate=(String)request.getParameter("endDate");
				}
				session.setAttribute("startdate",StartDate );
				session.setAttribute("enddate",endDate );
				
		//创建分类收入集合
		List<InGroupByType>	inGroup=new ArrayList<InGroupByType>();
		//查询数据
		IIncomeBiz iib=new IncomeBizImp();
		inGroup=iib.adminQueryAllIncome(StartDate, endDate);
		//测试inGroup
		session.setAttribute("inGroup", inGroup);
		
		//封装json
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {

			@Override
			public String translateName(Field f) {
				if(f.getName().equals("ioType")){
					return "name";
				}
				else if (f.getName().equals("allInMoney")) {
					return "value";
				}
				return f.getName();
			}
		});
		Gson gson = gsonBuilder.create();
		String injsonMsg = gson.toJson(inGroup);
		//向前台传json对象
		session.setAttribute("json", injsonMsg);
		//重定向到显示界面
		response.sendRedirect("admin/admin_in_all_query.jsp");
		
		
	}

}

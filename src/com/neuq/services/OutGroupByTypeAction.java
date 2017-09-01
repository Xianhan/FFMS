package com.neuq.services;



import java.io 

.IOException;
import java.io 

.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neuq.biz 

.IOutBiz;
import com.neuq.biz 

.imp.OutBizImp;
import com.neuq.entities.*;


/**
 * 查询指定时间段家庭各类型支出信息，并提供json数据
 * @author Calvin
 *
 */
@WebServlet(name="OutGroupByTypeAction",urlPatterns="/OutGroupByType")
public class OutGroupByTypeAction extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//System.out.println("执行啦");
				response.setContentType("text/javascript");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();

				IOutBiz iobz = new OutBizImp();
				HttpSession session = request.getSession();

				// 获取页面输入日期元素
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				if(startDate==null||startDate==""||startDate==null||startDate==""){
					startDate=(new java.sql.Date(new Date().getTime()).toString()).substring(0, 8)+"01";
					endDate=new java.sql.Date(new Date().getTime()).toString();
				}
				session.setAttribute("startdate",startDate );
				session.setAttribute("enddate",endDate );
				
				//获取查询家庭总收入的信息
				List<OutGroupByType> outGroupByList = new ArrayList<OutGroupByType>();
				outGroupByList = iobz.queryOutGroupByType(startDate, endDate);
				//存入session
				session.setAttribute("outGroupByList", outGroupByList);
				//封装Json
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {

					@Override
					public String translateName(Field f) {
						if(f.getName().equals("ioType")){
							return "name";
						}
						else if (f.getName().equals("allOutMoney")) {
							return "value";
						}
						return f.getName();
					}
				});
				Gson gson = gsonBuilder.create();
				String outJsonMsg = gson.toJson(outGroupByList);
				//向前台传Json
				session.setAttribute("json", outJsonMsg);
				response.sendRedirect("admin/admin_out_all_query.jsp");
	}

}

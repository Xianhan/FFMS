package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IOutBiz;
import com.neuq.biz.IUserBiz;
import com.neuq.biz.imp.OutBizImp;
import com.neuq.biz.imp.UserBizImp;
import com.neuq.entities.Out;
import com.neuq.entities.Paging;
import com.neuq.entities.User;

/**
 * 获得支出信息列表，单个人的
 * @author Calvin
 *
 */
@WebServlet(name = "OutList", urlPatterns = "/OutList")
public class OutList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("执行啦");
		response.setContentType("text/html");
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
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);

		// 判断当前用户是否为管理员，管理员跳转管理界面，且可以任意查询任何人
		// 普通用户只能看自己
		int currentid = (int) session.getAttribute("userid");// 获取当前用户登录id
		IUserBiz iubz = new UserBizImp();
		User user = iubz.queryUser(currentid);// 当前用户
		// System.out.println(user.toString());
		boolean isAdmin = false;// 判断用户是否管理员
		String reqPage = request.getParameter("reqPage");
		if (user.getUserName().equals("admin")||currentid==-1) {// 如果用户名为admin为管理员
			isAdmin = true;
		}
		if (!isAdmin) {// 普通用户只可查看查询自己的信息
			List<Out> outAllList=new ArrayList<Out>();
			if (reqPage != null) {
				
				int n = iobz.sunOut(currentid, startDate, endDate);
				Paging page = new Paging(n, 10);
				page.doPaging(Integer.parseInt(reqPage));
				outAllList = iobz.queryPagingOut(currentid, startDate, endDate, Integer.parseInt(reqPage), 10);
				session.setAttribute("page", page);
				
			}else{
				outAllList=iobz.queryAllOut(currentid, startDate, endDate);
			}
			System.out.println(reqPage);
			
			
		//	outAllList = iobz.queryAllOut(currentid, startDate, endDate);
			
			session.setAttribute("outAllList", outAllList);
			
			response.sendRedirect("user/user_out_list.jsp");
		} else {// 管理员的查询单个人操作
			
			int aUserOutid = Integer.parseInt(request.getParameter("aUserOutid"));//获取要查询的用户的Id
			
			session.setAttribute("aUserOutid", aUserOutid);
			
			
			List<Out> outAllList = iobz.queryAllOut(aUserOutid, startDate, endDate);
			session.setAttribute("outAllList", outAllList);
			response.sendRedirect("admin/admin_out_a_query.jsp?aUserOutid="+aUserOutid);
		}

	}
	

}

package com.neuq.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IIncomeBiz;
import com.neuq.biz.imp.IncomeBizImp;
import com.neuq.entities.IOType;
import com.neuq.entities.Income;
import com.neuq.entities.User;

/**
 * 添加收入信息
 */
@WebServlet("/AddIncome")
public class AddIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String date;
 
    public AddIncome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		String incomedate = request.getParameter("incomedate");
		String incometype = request.getParameter("incometype");
		String incomemoney = request.getParameter("incomemoney");

		
		Income income = new Income();
		User user= new User();
		user.setId(userid);
		income.setUser(user);
		income.setIncomeDate(incomedate);
		IOType iotype = new IOType();
		iotype.setId(Integer.parseInt(incometype));
		income.setIotype(iotype);
		income.setIncomeMoney(Double.parseDouble(incomemoney));
		IIncomeBiz iib=new IncomeBizImp();
		boolean b=iib.addIncome(income);
		if(!b){
			out.print("添加失败");
			out.flush();
			out.close();
		}else{
			response.sendRedirect("QueryAllIncome?reqPage=1");
		}
	}

}

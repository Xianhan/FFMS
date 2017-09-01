package com.neuq.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.entities.Income;
import com.neuq.entities.OutGroupByType;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteFamilyOutAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		   String fname = "家庭支出记录";
		    OutputStream os = response.getOutputStream();//取得输出流
		    response.reset();//清空输出流
		    
		    //下面是对中文文件名的处理
		    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
		    fname = java.net.URLEncoder.encode(fname,"UTF-8");
		    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xlsx");
		    response.setContentType("application/msexcel");//定义输出类型
		    
		    try {
				createExcel(os,request);
				
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	
	public void createExcel(OutputStream os, HttpServletRequest request) throws WriteException, IOException {
		HttpSession session = request.getSession();
//		int userid = (int)session.getAttribute("userid");
//		IOutBiz iobz = new OutBizImp();
//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
		//System.out.println(startDate);
		//System.out.println("++++++++++");
		//System.out.println(endDate);
//		if(startDate==null||startDate==""||startDate==null||startDate==""){
//			startDate=(new java.sql.Date(new Date().getTime()).toString()).substring(0, 8)+"01";
//			endDate=new java.sql.Date(new Date().getTime()).toString();
//		}
		//List<Out> outAllList = iobz.queryAllOut(userid, startDate, endDate);
		//System.out.println(outAllList.size());
		List<OutGroupByType> outGroupByList  =(List<OutGroupByType>) session.getAttribute("inarr");
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		Label xuexiao = new Label(0, 0, "收入者");
		sheet.addCell(xuexiao);
		Label zhuanye = new Label(1, 0, "收入时间");
		sheet.addCell(zhuanye);
		Label jingzhengli = new Label(2, 0, "收入类型");
		sheet.addCell(jingzhengli);

		Label qinghua = new Label(3, 0, "收入金额");
		sheet.addCell(qinghua);
	
		for (int j = 1; j < outGroupByList.size() + 1; j++) {

			Label content1 = new Label(0, j, outGroupByList.get(j-1).getIoType());
			Label content2 = new Label(1, j, outGroupByList.get(j-1).getAllOutMoney()+"");
		
			sheet.addCell(content1);
			sheet.addCell(content2);
			
		
		}
		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

}

package com.neuq.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuq.biz.IMyStockBiz;
import com.neuq.biz.imp.MyStockBizImp;
import com.neuq.entities.MyStock;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcelAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String fname = "持股情况";
		    OutputStream os = response.getOutputStream();//取得输出流
		    response.reset();//清空输出流
		    
		    //下面是对中文文件名的处理
		    response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
		    fname = java.net.URLEncoder.encode(fname,"UTF-8");
		    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
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
		int sercurityId = (int)session.getAttribute("accountid");
		IMyStockBiz imsb = new MyStockBizImp();
		List<MyStock> mystocklist = imsb.queryMyStock(sercurityId);
		System.out.println(mystocklist);
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		Label xuexiao = new Label(0, 0, "股票代码");
		sheet.addCell(xuexiao);
		Label zhuanye = new Label(1, 0, "股票名");
		sheet.addCell(zhuanye);
		Label jingzhengli = new Label(2, 0, "买入时间");
		sheet.addCell(jingzhengli);

		Label qinghua = new Label(3, 0, "买入单价");
		sheet.addCell(qinghua);
		Label jisuanji = new Label(4, 0, "持有数量");
		sheet.addCell(jisuanji);
		Label gao = new Label(5, 0, "买进总数");
		sheet.addCell(gao);
		for (int j = 1; j < mystocklist.size() + 1; j++) {

			Label content1 = new Label(0, j, mystocklist.get(j-1).getStock().getStockCode() + "");
			Label content2 = new Label(1, j, mystocklist.get(j-1).getStock().getStockName() + "");
			Label content3 = new Label(2, j, mystocklist.get(j-1).getInDate() + "");
			Label content4 = new Label(3, j, mystocklist.get(j-1).getInPrice() + "");
			Label content5 = new Label(4, j, mystocklist.get(j-1).getStockCount() + "");
			Label content6 = new Label(5, j, mystocklist.get(j-1).getInCount() + "");
			sheet.addCell(content1);
			sheet.addCell(content2);
			sheet.addCell(content3);
			sheet.addCell(content4);
			sheet.addCell(content5);
			sheet.addCell(content6);
		}
		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

}

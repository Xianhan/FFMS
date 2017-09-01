<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" com.neuq.entities.Stock" %>
<!DOCTYPE html>
<html>

	<head>
		<title>股票信息</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/Form.css" />
		<script type="text/javascript">
		function check(){
	
		var b=false;
			var stockcode=document.getElementById('stockcode').value;
			var stockcount=document.getElementById('stockcount').value;
			if(stockcode==null||stockcode==""||stockcount==null||stockcount==""){
				b= false;
				}
				else{
				b= true;
				}
		
				return b;
				}
		</script>
	</head>

	<body>
		<div id="box">
			<div id="pos">
				<table class="tab">
					<form action="SaleStockAction?accountid=${session.getattribute("accountid") } method="post" onsubmit="return check()">
						<tr>
							<td colspan="6" class="first">
							股票代码<input id="stockcode" type="number" name="stocknum">
							购买数量<input id="stockcount" type="number" name="count">
								<input type="submit" value="购买">
							</td>
					</form>
					<tr>
						<td class="first">股票代码</td>
						<td class="first">股票名称</td>
						<td class="first">买价</td>
						<td class="first">涨跌</td>
						<td class="first">总量</td>
					</tr>
					<c:forEach items="${sessionScope.Stock}" var="s">
					<tr>
						<td class="td">${s.stockCode }</td>
						<td class="td">${s.stockName }</td>
						<td class="td">${s.price }</td>
						<td class="td">${s.upDown }</td>
						<td class="td">${s.sum }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>
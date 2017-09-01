<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import=" com.neuq.entities.MyStock" %>
<%@ page import=" com.neuq.entities.Stock" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>证券流水账</title>
		<link rel="stylesheet" href="../css/Table.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">

				<table class="tab">
					<caption>证券流水账表</caption>
					<tr>
						<td class="first">股票号</td>
						<td class="first">股票名</td>
						<td class="first">买入时间</td>
						<td class="first">买入单价</td>
						<td class="first">卖出时间</td>
						<td class="first">卖出单价</td>
						<td class="first">卖出数量</td>
					</tr>
					<c:forEach items="${sessionScope.SecurityBill}" var="sb">
					<tr>
						<td class="td">${sb.stock.stockCode }</td>
						<td class="td">${sb.stock.stockName }</td>
						<td class="td">${sb.inDate }</td>
						<td class="td">${sb.inPrice }</td>
						<td class="td">${sb.outDate }</td>
						<td class="td">${sb.outPrice }</td>
						<td class="td">${sb.outCount }</td>
					</tr>
					</c:forEach>
				</table>
				<br>
				<br>
				<br>
				<div align="center">
				<span>共${sessionScope.page.totalPage}页</span> 
				<a href="../SecurityBillAction?reqPage=${sessionScope.page.previous }&accountid=${sessionScope.aid}">上一页</a>
				<c:choose>
				<c:when test="${sessionScope.page.totalPage<5}">
					<c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../SecurityBillAction?reqPage=${pnum}&accountid=${sessionScope.aid}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==1||sessionScope.page.reqPage==2}">
					<c:forEach begin="1" end="5" step="1" var="pnum">
					<a href="../SecurityBillAction?reqPage=${pnum}&accountid=${sessionScope.aid}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==sessionScope.page.totalPage||sessionScope.page.reqPage==(sessionScope.page.totalPage-1)}">
					<c:forEach begin="${sessionScope.page.totalPage-4}" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../SecurityBillAction?reqPage=${pnum}&accountid=${sessionScope.aid}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${sessionScope.page.reqPage-2}" end="${sessionScope.page.reqPage+2}" step="1" var="pnum">
					<a href="../SecurityBillAction?reqPage=${pnum}&accountid=${sessionScope.aid}">${pnum }</a>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<%-- <c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach> --%>
				<a href="../SecurityBillAction?reqPage=${sessionScope.page.next }&accountid=${sessionScope.aid}">下一页</a>
			</div>
			</div>
			
		</div>
	</body>

</html>
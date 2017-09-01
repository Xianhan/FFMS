<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8">
		<title>收入表</title>
		<link rel="stylesheet" href="../css/Table.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
			<div style="width=80%; margin:0 auto; margin-top:50px;" align="center">
			<form  action="../OutList?aUserOutid=${sessionScope.aUserOutid }" method="post">
				查询
				<input type="date" name="startDate" value="${sessionScope.startdate}">至
				<input type="date" name="endDate" value="${sessionScope.enddate}">的收入信息
				<input type="submit" value="查询">
				<a href="../WriteUserOutExcelAction">导出</a>
				</div>
			</form>
				<table class="tab" style="top:20px;">
					<tr>
						<td class="first">用户名</td>
						<td class="first">支出时间</td>
						<td class="first">支出类型</td>
						<td class="first">支出金额</td>
					</tr>
					<c:forEach items="${ sessionScope.outAllList}" var="outAllList">
					<tr>
						<td class="td">${outAllList.user.userName}</td>
						<td class="td">${outAllList.outDate }</td>
						<td class="td">${outAllList.iotype.type }</td>
						<td class="td">${outAllList.outMoney }</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>
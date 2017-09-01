<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8">

		<title>查询支出</title>
		<link rel="stylesheet" href="../css/Table.css" />
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="js/out.js"></script>
	</head>

	<body>
		<div id="box">
			<div id="pos">
			<div align="center"  style="width=80%; margin:0px auto; margin-top:50px;" >
				<form action="../OutList?reqPage=1" method="post">
					<tr>
						<td class="first">查询时间</td>
						<td class="td"><input id="start" type="date" name="startDate" value="${sessionScope.startDate}">至</td>
						<td class="td"><input id="end" type="date" name="endDate" value="${sessionScope.endDate}"></td>
						<td class="td"><input type="submit" value="查询" ></td>
						<td class="td"><a href="../WriteUserOutExcelAction">导出</a></td>
				</tr>
				</form>
				</div>
				<table class="tab" style="top:10px;">
					<tr>
						<th class="first">记录ID</th>
						<th class="first">用户名</th>
						<th class="first">支出时间</th>
						<th class="first">支出类型</th>
						<th class="first">支出金额</th>
						
						<th class="first" colspan="2">操作</th>
					</tr>
					<c:forEach items="${sessionScope.outAllList}" var="outAllList">
					<tr>
						<td class="td">${outAllList.id }</td>
						<td class="td">${outAllList.user.realName }</td>
						<td class="td">${outAllList.outDate}</td>
						<td class="td">${outAllList.iotype.type }</td>
						<td class="td">${outAllList.outMoney }</td>
						<td class="td"><a href="../QueryAllIOTypeAction?outid=${outAllList.id }&iopages=5">编辑</a></td>
						<td class="td"><a href="../OutDelete?outid=${outAllList.id }">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<br>
				<br>
				<br>
				<div align="center">
				<span>共${sessionScope.page.totalPage}页</span> 
				<a href="../OutList?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">上一页</a>
				<c:choose>
				<c:when test="${sessionScope.page.totalPage<5}">
					<c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../OutList?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==1||sessionScope.page.reqPage==2}">
					<c:forEach begin="1" end="5" step="1" var="pnum">
					<a href="../OutList?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==sessionScope.page.totalPage||sessionScope.page.reqPage==(sessionScope.page.totalPage-1)}">
					<c:forEach begin="${sessionScope.page.totalPage-4}" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../OutList?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${sessionScope.page.reqPage-2}" end="${sessionScope.page.reqPage+2}" step="1" var="pnum">
					<a href="../OutList?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<%-- <c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach> --%>
				<a href="../OutList?reqPage=${sessionScope.page.next }&&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">下一页</a>
			</div>
			</div>
		</div>
	</body>

</html>
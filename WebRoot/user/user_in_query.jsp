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
<div align="center"  style="width=80%; margin:0px auto; margin-top:50px;" >
			<form 
			 action="../QueryAllIncome?reqPage=1" method="post">
				查询
				<input type="date" name="startDate" value="${sessionScope.startDate}">至
				<input type="date" name="endDate" value="${sessionScope.endDate}">的收入信息
				<input type="submit" value="查询">
				<a href="../WriteUserInExcelAction">导出</a>
				
			</form>
			</div>
				<table class="tab" style="top: 10px;">
					<tr>
						<td class="first">收入者</td>
						<td class="first">收入时间</td>
						<td class="first">收入类型</td>
						<td class="first">收入金额</td>
						<td class="first">修改</td>
						<td class="first">删除</td>
					</tr>
					<c:forEach items="${ sessionScope.inarr}" var="ins">
					<tr>
						<td class="td">${ins.user.realName}</td>
						<td class="td">${ins.incomeDate }</td>
						<td class="td">${ins.iotype.type }</td>
						<td class="td">${ins.incomeMoney }</td>
						<td class="td">
							<a href="../QueryAllIOTypeAction?incomeid=${ins.id}&iopages=2">修改</a>
						</td>
						<td class="td">
							<a href="../DeleteIncome?incomeid=${ins.id}">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
				<br>
				<br>
				<br>
				<div align="center">
				<span>共${sessionScope.page.totalPage}页</span> 
				<a href="../QueryAllIncome?reqPage=${sessionScope.page.previous }&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">上一页</a>
				<c:choose>
				<c:when test="${sessionScope.page.totalPage<5}">
					<c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../QueryAllIncome?reqPage=${pnum}&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==1||sessionScope.page.reqPage==2}">
					<c:forEach begin="1" end="5" step="1" var="pnum">
					<a href="../QueryAllIncome?reqPage=${pnum}&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:when test="${sessionScope.page.reqPage==sessionScope.page.totalPage||sessionScope.page.reqPage==(sessionScope.page.totalPage-1)}">
					<c:forEach begin="${sessionScope.page.totalPage-4}" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../QueryAllIncome?reqPage=${pnum}&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${sessionScope.page.reqPage-2}" end="${sessionScope.page.reqPage+2}" step="1" var="pnum">
					<a href="../QueryAllIncome?reqPage=${pnum}&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">${pnum }</a>
				</c:forEach>
				</c:otherwise>
				</c:choose>
				<%-- <c:forEach begin="1" end="${sessionScope.page.totalPage}" step="1" var="pnum">
					<a href="../ShowAllWorker?reqNum=${pnum}">${pnum }</a>
				</c:forEach> --%>
				<a href="../QueryAllIncome?reqPage=${sessionScope.page.next }&&startDate=${sessionScope.startDate}&endDate=${sessionScope.endDate}">下一页</a>
			</div>
			</div>
		</div>
	</body>

</html>
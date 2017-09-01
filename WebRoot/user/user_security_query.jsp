<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/Table.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
				<table class="tab">
					<tr>
						<td class="first">账户名称</td>
						<td class="first">修改</td>
						<td class="first">删除</td>
					</tr>
					<c:forEach items="${sessionScope.secarr}" var="sec">
					<tr>
						<td class="td"><a href="../OwnStockAction?accountid=${sec.id}">${sec.accountName}</a></td>
						<td class="td">
							<a href="../UpdateAccountAction?accountid=${sec.id}">修改</a>
						</td>
						<td class="td">
							<a href="../DeleteSecurityAction?accountid=${sec.id}">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title></title>
<link rel="stylesheet" href="../css/Table.css" />
</head>

<body>
	<div id="box">
		<div id="pos">
			
			<table class="tab">
					<tr>
						<td class="first">用户名</td>
						<td class="first">真实姓名</td>
					</tr>
					<c:forEach items="${sessionScope.Users}" var="u">
					<tr>
						<td class="td"><a href="../QueryAUserIncome?auserincomeid=${u.id }&reqPage=1">${u.userName }</a></td>
						<td class="td">${u.realName }</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>

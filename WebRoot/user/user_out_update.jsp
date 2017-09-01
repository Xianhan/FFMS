<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">

<title>修改支出表</title>
<link rel="stylesheet" type="text/css" href="../css/Form.css" />
</head>

<body>
	<div id="box">
		<div id="pos">
			<form action="../OutUpdate?outid=${sessionScope.outContent.id }" method="post">
				<table class="tab">
					<tr>
						<td class="first">用户id</td>
						<td class="td">${sessionScope.outContent.user.id}</td>
					</tr>
					<tr>
						<td class="first">支出金额</td>
						<td class="td"><input class="inp" type="text" name="outmoney"
							value="${sessionScope.outContent.outMoney}" /></td>
					</tr>
					<tr>
						<td class="first">支出类型</td>
						<td class="td"><select name="outtype">
								<c:forEach items="${sessionScope.outlist}" var="out">
									<c:choose>
										<c:when test="${out.id==sessionScope.outContent.iotype.id }">
											<option selected="selected" value="${out.id }">${out.type}</option>
										</c:when>
										<c:otherwise>
											<option value="${out.id}">${out.type}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="first">支出日期</td>
						<td class="td"><input class="inp" type="date" name="outdate"
							value="${sessionScope.outContent.outDate}" /></td>
					</tr>

				</table>
				<br>
				<br>
				<br>
				<div id="subbox">
					<input id="sub" type="submit" value="提交" />
				</div>
			</form>
		</div>
	</div>
</body>

</html>
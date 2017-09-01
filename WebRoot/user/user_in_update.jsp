<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8">
		<title>编辑收入</title>
		<link rel="stylesheet" href="../css/Form.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
				<form action="../UpdateIncome?incomeid=${sessionScope.income.id }" method="post">
					<table class="tab">
						<tr>
							<td class="first">用户id</td>
							<td class="td"><input class="inp" type="text" name="uid" value="${sessionScope.income.user.id }" readonly="readonly" /></td>
						</tr>
						<tr>
							<td class="first">收入类型</td>
							<td class="td"><select name="intype">
							<c:forEach items="${sessionScope.inlist}" var="in">
								<c:choose>
									<c:when test="${in.id==sessionScope.income.iotype.id }">
										<option selected="selected" value="${in.id }">${in.type}</option>
									</c:when>
									<c:otherwise>
										<option value="${in.id }">${in.type}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td class="first">收入时间</td>
							<td class="td"><input class="inp" type="date" name="incomeDate" value="${sessionScope.income.incomeDate }" /></td>
						</tr>
						<tr>
							<td class="first">收入金额</td>
							<td class="td"><input class="inp" type="text" name="incomeMoney" value="${sessionScope.income.incomeMoney }" /></td>
						</tr>
					</table><br> <br> <br>
					<div id="subbox"><input type="submit" id="sub" value="修改" /></div>
				</form>
			</div>
		</div>
	</body>

</html>
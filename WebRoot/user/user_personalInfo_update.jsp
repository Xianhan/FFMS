<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<title>个人信息</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="../css/Form.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
			<form action="../UpdatePersonalInfo" target="_top" method="post">
				<table class="tab">
					
						<tr>
							<td class="first">用户名</td>
							<td class="td"><input class="inp" type="text" name="username" value="${sessionScope.user.userName}"></td>
						</tr>
					
						<tr>
							<td class="first">姓名</td>
							<td class="td"><input class="inp" type="text" name="realname" value="${sessionScope.user.realName}"></td>
						</tr>
						<tr>
							<td class="first">性别</td>
							<td class="td">
							<c:choose>
								<c:when test="${sessionScope.user.sex==\"男\"}">
								<input type="radio" name="sex" value="男" checked="checked">男
								<input type="radio" name="sex" value="女">女</td>
								</c:when>
								<c:otherwise>
								<input type="radio" name="sex" value="男" >男
								<input type="radio" name="sex" value="女" checked="checked">女</td>
								</c:otherwise>
							</c:choose>
							<tr>
							<td class="first">预消费</td>
							<td class="td"><input class="inp" type="number" name="preoutmoney" value="${sessionScope.user.preOutMoney}"></td>
							</tr>
							<tr>
								<td class="first">手机号</td>
								<td class="td"><input class="inp" type="number" name="phone" value="${sessionScope.user.phone}"></td>
							</tr>
			
							
							
							
				
				</table>
				<br>
				<br>
				<br>
				<div id="subbox">
								<input type="submit" id="sub" value="确认">
								</div>
									</form>
			</div>
		</div>
	</body>

</html>
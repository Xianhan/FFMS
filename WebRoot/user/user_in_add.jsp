<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8">
		<title>添加收入</title>
		<link rel="stylesheet" href="../css/Form.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
				<form action="../AddIncome" method="post">
					<table class="tab">
						<tr>
							<td class="first">收入类型</td>
							<td class="td"><select name="incometype">
								<c:forEach items="${sessionScope.inlist}" var="in">
									<option value ="${in.id}">${in.type}</option>
								</c:forEach>
								</select></td>
						</tr>
						<tr>
							<td class="first">收入时间</td>
							<td class="td"><input class="inp" type="date"  name="incomedate"></td>
						</tr>
						<tr>
							<td class="first">收入金额</td>
							<td class="td"><input class="inp" type="text" name="incomemoney"></td>
						</tr>
					</table><br><br><br>
					<div id="subbox"><input type="submit" id="sub" value="提交"/></div>
				</form>
			</div>
		</div>
	</body>

</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<title>添加支出信息</title>
<link rel="stylesheet" href="../css/Form.css" />
</head>

<body>
	<div id="box">
		<div id="pos">
			<form action="../OutAdd?reqPage=1" method="post">
				<table class="tab">
					<tr>
						<td class="first">用户id</td>
						<td class="td" name="userid">${sessionScope.userid }</td>
					</tr>
					<tr>
						<td class="first">支出金额</td>
						<td class="td"><input class="inp" type="text" name="outmoney" /></td>
					</tr>
					<tr>
						<td class="first">支出类型</td>
						<td class="td"><select name="outtype">
								<c:forEach items="${sessionScope.outlist}" var="out">
									<option value ="${out.id}">${out.type}</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
						<td class="first">支出日期</td>
						<td class="td"><input class="inp" type="date" name="outdate" /></td>
					</tr>

				</table>
				<br>
				<br>
				<br>
				<div id="subbox">
					<input type="submit" id="sub" value="提交"/>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
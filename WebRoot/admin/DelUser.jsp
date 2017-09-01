<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SelectUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="css/Table.css" />
  </head>
  
  <body>
    <div id="box">
			<div id="pos">
				<table class="tab">
					
						<b align="center">选择要删除的用户</b>
					<tr>	
						<td class="first">用户名</td>
						<td class="first">真实姓名</td>
                                                <td class="first">删除</td>
						
					</tr>
					<c:forEach items="${sessionScope.Users}" var="u">
					<tr>
						<td class="td">${u.userName }</td>
						<td class="td">${u.realName }</td>
                                                <td class="td"><a href="DelUserAction?id=${u.id }">删除</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
  </body>
</html>

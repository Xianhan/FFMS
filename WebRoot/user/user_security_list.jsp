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
    
    <title>My JSP 'user_security_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" href="css/Table.css" />
  </head>
  
  <body>
  <div id="box">
      <div id="pos">
    <table class="tab">
    <caption>证券账户表</caption>
    <tr>
    <td class="first">证券id</td>
    <td class="first">账户名</td>
    
    </tr>
    <c:forEach items="${sessionScope.SelectSecurity}" var="ss">
					<tr>
						<td class="td">${ss.id }</td>
						<td class="td"><a href="SecurityBillAction?accountid=${ss.id }&reqPage=1">${ss.accountName }</a></td>
						
					</tr>
					</c:forEach>
    </table>
    </div>
    </div>
  </body>
</html>

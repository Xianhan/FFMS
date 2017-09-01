<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数据恢复</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../css/Table.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function r(e){
		var btn=e.target.value;
	
		var b=false;
		//btn.onclick = function() {
			$.ajax({
				url : 'RecoverDatabaseAction?filename='+btn,
				type : 'POST', //GET
				async : false, //或false,是否异步
				timeout : 10000000, //超时时间
				dataType : 'text', //返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data) {
					b=true;
				},
			})
			if(b){
			
			alert('还原成功');}
			else{
			alert('还原失败');
			}
		}
		//alert(b);
	//}
</script>
</head>

<body>
	<table class="tab">
		<c:forEach items="${sessionScope.files}" var="file">
			<tr>
				<td class="td">${file}</td><td><button value="${file}" onclick="r(event)">确定</button></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

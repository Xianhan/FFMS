<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>简易聊天室</title>
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" style="text/css" href="../css/Chat.css">
<script type="text/javascript">
	var ws;
	var wsUri = "ws://localhost:8888/FFMS/echo";
	ws = new WebSocket(wsUri);

	ws.onopen = function() {
		ws.send(document.getElementById('realname').innerText); //在服务端必须由OnMessage接收此消息
	};

	//处理连接后的信息处理
	ws.onmessage = function(message) {
		writeToScreen(message.data);
	};

	//对发送按钮进行监听，获取发送的信息和发送对象
	function button() {
		message = document.getElementById('in').value;
		towho = document.getElementById('towho').value + "@";
		ws.send(towho + message);
	}

	//发生错误时，处理错误
	ws.onerror = function(evt) {
		writeToScreen('<span style="color:red;">ERROR:</span>' + evt.data);
		ws.close();
	};

	//把信息显示到当前屏幕
	function writeToScreen(message) {
		var pre = document.createElement("p");
		pre.style.wordWrap = "break-word";
		pre.innerHTML = message;
		output.appendChild(pre);
	}

	//当关闭页面时执行ws.close
	window.onbeforeunload = function() {
		ws.close();
	};
</script>
</head>

<body>

	<div id="box">
		<div id="pos">
			<div id="pos_op">
				<div id="title"><h2>家庭聊天室</h2></div>
				<div style="width:400px;height:260px; overflow:scroll; border:3px solid blue; " id="output"></div>
				<br>
				<div style="text-align:left;">
					<form action="">
						<input id="in" name="message" value="" type="text"
							style="width:400px;height:60px;  border:3px solid green; "> <br>
						<br> <input onclick="button()" value="发送" type="button" />
						发送对象： <select id="towho" name="towho">
							<option>all</option>
							<c:forEach items="${sessionScope.Users}" var="user">
								<option>${user.realName}</option>
							</c:forEach>
						</select> <br>
					</form>
				</div>
				<span id="realname" hidden="hidden">${sessionScope.realname}</span>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>签到</title>
<link rel="stylesheet" type="text/css" href="../css/calendar.mx.1.1.css">
<link rel="stylesheet" type="text/css" href="../css/Table.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/calendar.mx.1.1.js"></script>

<script type="text/javascript">
	window.onload = function() {

		//var allday="[22]";
		var allday = document.getElementById('allday').innerText.split(',');
		var days = document.getElementById('days');
		var status = document.getElementById('status');
		if (days.innerText < 5) {
			status.innerText = '潜水';
		} else if (days.innerText < 15) {
			status.innerText = '冒泡';
		} else {
			status.innerText = '辛勤工作者';
		}

		$(function() {

			$("#calendar").html(Calendar.getCalendar(allday));
		});
	}
</script>
</head>
<body>
	<div id="box">
		<div id="pos">
			<div id="co">
				
				<div id="calendar"></div>
				你已连续签到 <span id="days">${sessionScope.days}</span>天 <br> 状态： <span
					id="status"></span> <span id="allday" hidden="hidden">${sessionScope.allday}</span>
				<form action="../GateCardAction">
					<div style="position:relative;left:300px;"><button id="gatecard" style="width:80px;height:50px;">签到</button></div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
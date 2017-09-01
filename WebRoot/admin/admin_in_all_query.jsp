<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../css/AllIOinfo.css" />
<script src="js/echarts.min.js"></script>
<script type="text/javascript">
	function strToJson(str) {
		var json = eval('(' + str + ')');
		return json;
	}
	window.onload = function() {
		var s=document.getElementById('json').innerText;
		var ss= strToJson(s);
		var a =ss;
	
		var myChart = echarts.init(document.getElementById('circle'));
		var option = {
			title : {
				text : '家庭收入'
			},
			tooltip : {},
		
			// xAxis: {
			//     data: ["安迪","樊胜美","关关","曲筱筱","邱莹莹"]
			// },
			// yAxis: {},
			series : [ {
				name : '家庭收入',
				type : 'pie',
				radius : '65%',
				center : [ '50%', '60%' ],
				label : {
					normal : {
						formatter : '{b}:{c}: ({d}%)',
						textStyle : {
							fontWeight : 'normal',
							fontSize : 15
						}
					}
				},
				data : a, //----------------------------------------------------------这里是重点
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ],
		};
		myChart.setOption(option);
	}
</script>
</head>

<body>
	<div id="box">
		<div id="pos">
			<!--
                	上部分查询
                -->
			<div id="top">
			<form action="../QueryAllUserIncome" method="post">
				查询<input type="date" name="startDate"
					value="${sessionScope.startdate}">至<input type="date"
					name="endDate" value="${sessionScope.enddate}">的收入信息<input
					type="submit" value="查询" />
					<a href="../WriteFamilyIncomeAction">导出</a>
					</form>
			</div>
			<!--
                	下部分显示
                -->
			<div id="down">
				<!--
                    	左部分显示表格
                    -->
				<div id="left">
					<table class="tab">
						<tr>
							<td class="first">收入类型</td>
							<td class="first">收入金额</td>
						</tr>
						<c:forEach items="${sessionScope.inGroup}" var="ig">
							<tr>
								<td class="td">${ig.ioType }</td>
								<td class="td">${ig.allInMoney }</td>
							</tr>
						</c:forEach>
					</table>
					<br> <br> <br> <br> <span id="json" hidden="hidden">${sessionScope.json}</span>
				</div>
				<!--
                    	右部分显示圆形图
                    -->
				<div id="circle">
					
				</div>
			</div>
		</div>
	</div>
</body>

</html>
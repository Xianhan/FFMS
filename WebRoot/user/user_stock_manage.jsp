<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>持股管理</title>
<link rel="stylesheet" href="../css/Form.css" />

<script type="text/javascript">
	function check(event) {
		var stockcount = parseInt(event.target.stockcount.value);
		var outcount = parseInt(event.target.outcount.value);


		if (stockcount < outcount || outcount <= 0) {
			alert('请输入正确的卖出数量');
			return false;
		} else {
			return true;
		}
	}
</script>
<style type="text/css">
.inp {
	width: 90px;
}

.first, .td {
	width: 200px;
}
</style>
</head>

<body>
	<div id="box">
		<a href="../StockInfoAction"><b>买股票</b></a>
		
		<div id="pos" style="width:80%">
			<table class="tab" style="width:100%;left:0;">
				<caption>持股管理表</caption>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="../WriteExcelAction"><b>导出</b></a>
				<tr>
					<td class="first">股票代码</td>
					<td class="first">股票名</td>
					<td class="first">买入时间</td>
					<td class="first">买价</td>
					<td class="first">持有数量</td>

					<td class="first">卖价</td>
					<td class="first">卖出数量</td>
					<td class="first">卖出</td>
				</tr>
				<c:forEach items="${sessionScope.map}" var="stock">

					<tr>
						<form
							action="../UpdateMyStockAction?stockid=${stock.value.id}&stocksid=${stock.value.stock.id}&incount=${stock.value.inCount}"
							method="post" onsubmit="return check(event)">
							<td class="td">${stock.value.stock.stockCode }</td>
							<td class="td">${stock.value.stock.stockName }</td>

							<td class="td"><input class="inp" name="indate" type="text"
								value="${stock.value.inDate}" readonly="readonly"></td>

							<td class="td"><input class="inp" name="inprice" type="text"
								value="${stock.value.inPrice}" readonly="readonly"></td>

							<td class="td"><input class="inp" id="stockcount"
								name="stockcount" type="text" value="${stock.value.stockCount}"
								readonly="readonly"></td>


							<td class="td"><input class="inp" name="outprice"
								type="text" value="${stock.key}" readonly="readonly"></td>
							<td class="td"><input class="inp" id="outcount"
								type="number" name="num" value="0"></td>
							<td class="td"><input   type="submit" value="卖出"></td>
						</form>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>
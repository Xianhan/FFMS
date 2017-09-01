<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>新建证券账户</title>
		<link rel="stylesheet" href="../css/Form.css" />
	</head>

	<body>
		<div id="box">
			<div id="pos">
				<form action="../UpdateAccountAction?add=true" method="post">
					<table class="tab">
						<tr>
							<td class="first">账户名称</td>
							<td class="td"><input class="inp" type="text" name="accountname" autofocus="autofocus"></td>
						</tr>
					</table>
					<br>
					<br>
					<br>
					<div id="subbox">
					<input id="sub" type="submit" value="提交" >
					</div>
					
				</form>
			</div>
		</div>
	</body>

</html>
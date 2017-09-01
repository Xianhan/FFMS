<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	<link rel="stylesheet" type="text/css" href="../css/Form.css">

  </head>
  
  <body>
    <div id="box">
			<div id="pos">
			
			<form action="../UpdateAccountAction?update=true&accountid=${sessionScope.sec.id}" method="post">
				<table class="tab">
					<tr>
						<td class="first">账户名称</td>
						<td class="first">修改</td>
					</tr>
					<tr>
						<td class="td"><input value="${sessionScope.sec.accountName}" name="accountname"></td>
						<td class="td">
							<input type="submit" value="确认修改">
						</td>
					</tr>
					
				</table>
				</form>
			</div>
		</div>
  </body>
</html>

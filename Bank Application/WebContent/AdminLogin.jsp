<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#F0FFF0;">
	
	<div style="padding-top: 170px;" style="text-decoration: underline;">
		<h2 align="center"><font color="#CD5C5C" size="7">Welcome Admin </font></h2>
	</div>
	
	<div align="center" style="padding-top: 10px;">
		<form action="admin_Login" method="post">
			<table style="with:80%">
				<tr>
					<td>Enter Your Id : </td>
					<td><input type="text" name="id" required="required"> </td>
				</tr>
				<tr>
					<td>Enter Your Password : </td>
					<td><input type="password" name="password" required="required"> </td>
				</tr>
			</table>	<br>
			<input type="submit" name="btn" value="login">
		</form>
	</div>

</body>
</html>
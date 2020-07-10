<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#F0FFF0;">
	
	<div style="padding-top: 170px;">
		<h2 align="center" style="text-decoration: underline;"><font color="#FF0000" size="7">
			Welcome Customer
			</font>
		</h2>
	</div>
	
	<div align="center" style="padding-top: 10px;">
		<form action="customer" method="post">
			<table style="with:80%">
				<tr>
					<td>Enter Your Account Number  : </td>
					<td><input type="text" name="cid" required="required"></td>
				</tr>
				<tr>
					<td>Enter your Account Password : </td>
					<td> <input type="password" name="cname" required="required"> </td>
				</tr>
			</table> <br>
			<input type="submit" name="btn" value="login">
		</form>
	</div>
</body>
</html>
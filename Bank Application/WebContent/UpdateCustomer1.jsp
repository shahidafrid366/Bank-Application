<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#FFFFE0"> 
	<div style="padding-top: 170px;">
		<h1 align="center" style="text-decoration: underline;"><font color="#CD5C5C">
			Update Customer Records
			</font>
		</h1>
	</div>
	
	<div align="center" style="padding-top: 100;">
		<fieldset style="width: 450px; height: 120px; text-align: center; padding:15px">
			<form action="admin_Login" method="post">
				<table> 
					<tr>
						<td><b>Enter Updated Customer name :</b></td>
						<td> <input type="text" name="name" required="required"></td>
					</tr>
					<tr>	
						<td><b>Enter Updated Customer Balance :</b></td>
						<td> <input type="text" name="balance" required="required"></td>
					</tr>	
					<tr>
						<td><b>Enter Updated Customer Password :</b></td>
						<td> <input type="text" name="password" required="required"></td>
					</tr>
				</table>	<br>
		<input type="submit" name="btn" value="Update Customer">
	</form>
	</fieldset>
	</div>
</body>
</html>
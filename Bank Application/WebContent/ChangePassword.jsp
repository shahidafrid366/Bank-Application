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
			Change Your Password
			</font>
		</h1>
	</div>
	
	<div align="center" style="padding-top: 100;">
		<fieldset style="width: 480px; height: 80px; text-align:center; padding:30px; background-color:#F0F8FF">
			<form action="customer" method="post">
				<table> 
					<tr>
						<td><b>Enter Your Old Password :</b></td>
						<td><input type="password" name="oldpassword" required="required"></td>
					</tr>
					<tr>	
						<td><b>Enter Your New Password : </b></td>
						<td><input type="text" name="newpassword" required="required"></td>
					</tr>	
				</table>	<br>
				<input type="submit" name="btn" value="Change">
			</form>
		</fieldset>
	</div>
</body>
</html>
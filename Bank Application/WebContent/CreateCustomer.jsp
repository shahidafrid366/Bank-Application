<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body style="background-color:#FFFFE0"> 
	<div style="padding-top: 100px;">
		<h3 align="center" style="text-decoration: underline;"><font color="#CD5C5C" size="7">
			Create Customer
			</font>
		</h3>
	</div>

	<div align="center" style="padding-top: 10;">
		<fieldset style="width: 450px; height: 200px;">
			<p>Fields marked with * are mandatory to fill</p>

				<form action="admin_Login" method="post">
					<table> 
						<tr>
							<td><b>Enter New Account Holder Number* :</b> </td>
							<td><input type="text" name="accNum" required="required"></td>
						</tr> 
						<tr>
							<td><b>Enter New Account Holder Name* :</b></td>
							<td> <input type="text" name="accName" required="required"></td>
						</tr>
						<tr>
							<td><b>Enter The Balance For Account* :</b> </td>
							<td><input type="text" name="balance" required="required"></td>
						</tr>
						<tr>
							<td><b>Enter The Password For Account* :</b></td>
							<td> <input type="text" name="password" required="required"></td>
						</tr>
					</table><br>
					<input type="submit" name="btn" value="create customer">  
			 	</form>
		</fieldset>
	 </div>
</body>
</html>
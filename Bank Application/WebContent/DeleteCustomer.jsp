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
			Delete Customer 
			</font>
		</h1>
	</div>
	
	<div align="center" style="padding-top: 100;">
		<fieldset style="width: 500px; height: 80px; text-align: center; padding:30px">
			<form action="admin_Login" method="post">
				<table> 
					<tr>
						<td><b>Enter the Customer Id You Want To Delete :</b></td>
						<td> <input type="text" name="delcust" required="required"></td>
					</tr>
					</table>	<br>
		<input type="submit" name="btn" value="Delete Customer">
	</form>
	</fieldset>
	</div>
</body>
</html>
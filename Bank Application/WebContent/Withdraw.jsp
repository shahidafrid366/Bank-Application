<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #ADD8E6"> 
	<div style="padding-top: 170px;">
		<h1 align="center" style="text-decoration: underline;"><font color="#CD5C5C">
			Transfer Amount
			</font>
		</h1>
	</div>
	
	<div align="center" style="padding-top: 100;">
		<fieldset style="width: 490px; height: 70px; text-align:center; padding:30px; background-color: #F0FFF0">
			<form action="customer" method="post">
				<table> 
						<tr>
							<td><b>Enter The Amount You Want To Withdraw :</b></td>
							<td> <input type="text" name="amount" required="required"></td>
						</tr>	
				</table><br>
				<input type="submit" name="btn" value="Withdraw Amount"> 
			</form>
		</fieldset>
	</div>
</body>
</html>
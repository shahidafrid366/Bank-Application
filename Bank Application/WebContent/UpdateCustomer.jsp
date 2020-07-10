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
			Search For Customer To Update Records
			</font>
		</h1>
	</div>
	
	<div align="center" style="padding-top: 100;">
		<fieldset style="width: 450px; height: 80px; text-align: center; padding:30px">
			<form action="admin_Login" method="post">
				<table> 
					<tr>
						<td><b>Enter the Customer Id :</b></td>
						<td> <input type="text" name="cid" required="required"></td>
					</tr>
					</table>	<br>
	 	<input type="submit" name="btn" value="Search Customer">
	 </form>
	 </fieldset>
	 </div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, tr, th, td {
	border: 1px solid black;
	width: 40%;
	text-align: center;
	cellpadding="5";
	cellspacing="5";
}
</style>
</head>
<body style="padding-top: 130px;" bgcolor="#FFFACD">
<h2 align="center"><font><strong>Balance Amount After Withdraw</strong></font></h2>
	<c:forEach var="s" items="${list}">
		<table align="center">
			<tr bgcolor="#E6E6FA">			
				<th>Account Number</th>
				<th>Customer Name</th>
				<th>Balance</th>
				<th>Password</th>
			</tr>
		
			<tr bgcolor="#F0FFF0">
				<td>
					<h5>
						<c:out value="${s.getAccountNumber()}"></c:out>
					</h5>
				</td>
				<td>
					<h5>
						<c:out value="${s.getAccountName()}"></c:out>
					</h5>
				</td>
				<td>
					<h5>
						<c:out value="${s.getBalance()}"></c:out>
					</h5>
				</td>
				<td>
					<h5>
						<c:out value="${s.getPassword()}"></c:out>
					</h5>
				</td>
			</tr>
		</table>
	</c:forEach>

</body>	


</html>
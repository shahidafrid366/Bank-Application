<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, tr, th, td {
	border: 1px solid black;
	width: 40%;
	text-align: center;
}
</style>
</head>
<body>
	<c:forEach var="s" items="${list}">
		<table>
	<tr>			
		<!-- <th>Account Number</th>
		<th>Name</th>
		<th>Balance</th>
		<th>Password</th> -->
	</tr>
			<tr> 
				<td> <th>Account Number</th>
					<h5>
						<c:out value="${s.getAccountNumber()}"></c:out>
					</h5>
				</td>
				<td> <th>Name</th>
					<h5>
						<c:out value="${s.getAccountName()}"></c:out>
					</h5>
				</td>
				<td> <th>Balance</th>
					<h5>
						<c:out value="${s.getBalance()}"></c:out>
					</h5>
				</td>
				<td> <th>Password</th>
					<h5>
						<c:out value="${s.getPassword()}"></c:out>
					</h5>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
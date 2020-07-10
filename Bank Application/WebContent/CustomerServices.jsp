<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DXC Bank</title>
</head>
<STYLE>a {text-decoration: none;} </STYLE>
<body style="background-color:#F0FFF0;">

	<h1 style="padding-top: 100px;" align="center">Hello Customer...</h1>
	
	<div align="center" style="padding-top: 5px;">
		<fieldset style= width:30%>
			<h4> 
				<button>	<a href="DepositMoney.jsp">Deposit Money</a></button> <br><br>
				
				<button>	<a href="TransferMoney.jsp">Transfer Money to Other Account</a></button> <br><br>
				
				<button>	<a href="Withdraw.jsp">Withdraw Money</a>  </button><br><br>
				
				
				<button>	<a href="ChangePassword.jsp"> Change Your Password</a> </button> <br><br>
					
					<form action="customer">
						<input type="submit" name="btn" value="Check Balance">   <br><br>
					
						<input type="submit" name="btn" value="Mini Statement">   <br><br>
					
					</form>
				
				<button>	<a href="customer">Log Out</a></button> <br><br>
			</h4>
		</fieldset>
	</div>	
</body>
</html>
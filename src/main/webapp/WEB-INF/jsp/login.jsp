<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="/css/style.css" rel="stylesheet">
</head>
<body>
	<div id="form">
		<form action="/login" method="post">
			<div>
				<label for="loginLbl" class="label">Login :</label>
			</div>

			<label for="labelUsername" class="label">User name : </label><input
				type="text" name="username" /> <br> <label for="labelPassword"
				class="label"> Password : </label><input type="text" name="password" />
			<br>

			<div id="btnSubmit">
				<button type="submit" value="Login">Login</button>
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <br> <a href="/register">New
				User!</a>
		</form>
	</div>
</body>
</html>
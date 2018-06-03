<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Currency Converter Application :</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
#errorMsg {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

#msg {
	color: blue;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>


	<div class="card text-center">
		<div class="card-header">
			<ul class="nav nav-tabs card-header-tabs">
				<li class="nav-item"><a class="nav-link active" href="#">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/register">Register</a>
				</li>
			</ul>
		</div>
		<div class="card-body">
			<h3 class="card-title">Currency Converter Application</h3>
			<form action="/login" method="post" class="form-signin">
				<div>
					<h2 class="h4 mb-3 font-weight-normal">
						<label for="loginLbl" class="label">Login :</label>
					</h2>
				</div>

				<div class="form-group ${error != null ? 'has-error' : ''}">
					<br>
					<div>
						<input type="text" name="username" id="inputUsername"
							placeholder="User name" />
					</div>

					<br>
					<div>
						<input type="password" name="password" id="inputPassword"
							placeholder="Password" />
					</div>
					<br>
					<div>
						<span id="errorMsg">${errorMsg}</span>
					</div>

					<div id="btnSubmit">
						<button type="submit" value="Login"
							class="btn btn-outline-primary">Login</button>
					</div>

					<br>
					<div>
						<span id="msg">${msg}</span>
					</div>
					<div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<br>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
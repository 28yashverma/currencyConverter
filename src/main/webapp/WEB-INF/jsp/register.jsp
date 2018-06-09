<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Registration page</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

#resultCheckUser {
	color: blue;
	font-style: italic;
	font-weight: bold;
}

#resultCheckUserFailed, #checkPassword {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

.nLables {
	background-color: pink;
	font-family: sans-serif;
	border-radius: 5px;
	color: darkblue;
	font-weight: bold;
}
</style>
<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link href="css/toastr.min.css" rel="stylesheet">
<script type="text/javascript" src="js/toastr.min.js"></script>
</head>
<body>
	<div class="card text-center">
		<div class="card-header">
			<ul class="nav nav-tabs card-header-tabs">
				<li class="nav-item"><a class="nav-link" href="/login">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="/register">Register</a></li>
			</ul>
		</div>
		<div class="card-body" style="text-align: left">
			<h3 class="card-title">Currency Converter Application</h3>
			<div>
				<h2 class="h4 mb-3 font-weight-normal">
					<label for="loginLbl" class="label">Registration Form :</label>
				</h2>
			</div>
			<div class="text-center">
				<div id="formLogin">
					<form:form method="post" action="/register"
						modelAttribute="registrationForm">
						<div class="error" style="text-align: right;">${userSaveStatus}</div>

						<div class="form-row">
							<div class="form-group col-md-2">
								<form:input path="username" onchange="checkUser(username)"
									placeholder="Username" class="form-control" />
								<form:errors path="username" cssClass="error" />
								<div id="resultCheckUser"></div>
							</div>
							<div class="form-group col-md-2">
								<form:input path="password" type="password"
									placeholder="Password" class="form-control"
									onchange="checkPassword(confirmPassword, password)" />
								<form:errors path="password" cssClass="error" />
								<form:label path="password" cssClass="nLables">Format : aB6@name</form:label>
							</div>
							<div class="form-group col-md-2">
								<form:input path="confirmPassword" type="password"
									onchange="checkPassword(confirmPassword, password)"
									class="form-control" placeholder="Confirm Password" />
								<form:errors path="confirmPassword" cssClass="error" />
								<div id="checkPassword"></div>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-2">
								<form:input path="email" type="email" placeholder="Email"
									class="form-control" onchange="checkEmail(email)" />
								<form:errors path="email" cssClass="error" />
								<form:label path="email" cssClass="nLables">Format: abc@mail.com</form:label>
							</div>

						</div>
						<hr>
						<div class="form-row">
							<div class="form-group col-md-2">
								<label>Date of Birth :</label>
								<form:input path="dateOfBirth" type="date" id="dateOfBirth"
									min="1960-03-31" max="2000-03-31" class="form-control" />
								<form:errors path="dateOfBirth" cssClass="error" />
								<form:label path="dateOfBirth" cssClass="nLables">Format : dd-MM-yyyy</form:label>
							</div>
							<div class="form-group col-md-2">
								<form:label path="country">Country : </form:label>
								<form:select path="country" items="${countryList}"
									class="form-control" />
								<form:errors path="country" cssClass="error" />
							</div>
						</div>
						<hr>
						<div class="form-row">
							<div class="form-group col-md-2">
								<form:input path="postalAddress" class="form-control"
									placeholder="Postal Address" />
								<form:errors path="postalAddress" cssClass="error" />
							</div>
							<div class="form-group col-md-2">
								<form:input path="street" class="form-control"
									placeholder="Street" />
								<form:errors path="street" cssClass="error" />
							</div>
							<div class="form-group col-md-2">
								<form:input path="city" class="form-control" placeholder="City" />
								<form:errors path="city" cssClass="error" />
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-2">
								<form:input path="zipCode" class="form-control"
									placeholder="Zipcode" type="number" />
								<form:errors path="zipCode" cssClass="error" />
								<form:label path="zipCode" cssClass="nLables">Only numbers</form:label>
							</div>
						</div>

						<div style="text-align: left">
							<button type="submit" value="Register"
								class="btn btn-outline-primary" id="btn-submit">Register</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
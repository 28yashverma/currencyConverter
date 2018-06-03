<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div class="card-body">
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
						<div class="error">${userSaveStatus}</div>

						<div>
							<div id="labels">
								<form:label path="username">User name : </form:label>
							</div>
							<form:input path="username" onblur="checkUser(username)" />
							<form:errors path="username" cssClass="error" />
							<div id="resultCheckUser"></div>
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="password">Password : </form:label>
							</div>
							<form:input path="password" type="password" />
							<form:errors path="password" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="confirmPassword">Confirm Password : </form:label>
							</div>
							<form:input path="confirmPassword" type="password"
								onblur="checkPassword(confirmPassword, password)" />
							<div id="checkPassword"></div>
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="email">Email : </form:label>
							</div>
							<form:input path="email" type="email" />
							<form:errors path="email" cssClass="error" />
						</div>
						<br />

						<div>
							<div id="labels">
								<form:label path="dateOfBirth">Date Of Birth(dd-MM-yyyy) : </form:label>
							</div>
							<form:input path="dateOfBirth" type="date" id="dateOfBirth"
								min="1960-03-31" max="2000-03-31" />
							<form:errors path="dateOfBirth" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="country">Country : </form:label>
							</div>
							<form:select path="country" items="${countryList}" />
							<form:errors path="country" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="postalAddress">Postal Address : </form:label>
							</div>
							<form:input path="postalAddress" />
							<form:errors path="postalAddress" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="street">Street : </form:label>
							</div>
							<form:input path="street" />
							<form:errors path="street" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="city">City : </form:label>
							</div>
							<form:input path="city" />
							<form:errors path="city" cssClass="error" />
						</div>
						<br />
						<div>
							<div id="labels">
								<form:label path="zipCode">Zipcode : </form:label>
							</div>
							<form:input path="zipCode" />
							<form:errors path="zipCode" cssClass="error" />
						</div>
						<div>
							<button type="submit" value="Register"
								class="btn btn-outline-primary">Register</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration page</title>
<style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1 id="heading"
		style="color: blue; text-decoration: blink; text-align: center;">Registration
		form :</h1>
	<div id="formLogin">
		<form:form method="post" action="/register"
			modelAttribute="registrationForm">
			<div id="labels">
				<form:label path="username">User name : </form:label>
			</div>
			<form:input path="username" />
			<form:errors path="username" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="password">Pass word : </form:label>
			</div>
			<form:input path="password" />
			<form:errors path="password" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="confirmPassword">Confirm Password : </form:label>
			</div>
			<form:input path="confirmPassword" />

			<br />
			<div id="labels">
				<form:label path="email">Email : </form:label>
			</div>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="dateOfBirth">Date Of Birth(mm/dd/yyyy) : </form:label>
			</div>
			<form:input path="dateOfBirth" />
			<form:errors path="dateOfBirth" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="country">Country : </form:label>
			</div>
			<form:select path="country" items="${countryList}" />
			<form:errors path="country" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="postalAddress">Postal Address : </form:label>
			</div>
			<form:input path="postalAddress" />
			<form:errors path="postalAddress" cssClass="error" />


			<br />
			<div id="labels">
				<form:label path="street">Street : </form:label>
			</div>
			<form:input path="street" />
			<form:errors path="street" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="city">City : </form:label>
			</div>
			<form:input path="city" />
			<form:errors path="city" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="zipCode">Zipcode : </form:label>
			</div>
			<form:input path="zipCode" />
			<form:errors path="zipCode" cssClass="error" />

			<br />
			<div id="labels">
				<form:label path="roles">Roles : </form:label>
			</div>
			<form:checkboxes path="roles" items="${rolesList}" />
			<form:errors path="roles" cssClass="error" />

			<br />
			<button type="submit">Register</button>

			<br />
			<a href="/">Back to login!</a>
		</form:form>
	</div>
</body>
</html>
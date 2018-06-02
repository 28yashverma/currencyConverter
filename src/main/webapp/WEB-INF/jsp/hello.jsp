<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body onload="loadStaticData()">
	<h1>Welcome :</h1>
	<c:if test="${not empty username}">
		${username}
	</c:if>


	<form action="/logout" method="post">
		<button type="submit">Logout</button>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<br>
	<div id="latestRates">
		<button type="submit" onclick="getData('latest')">Latest :</button>
		<div id="textLatestRates">
			<textarea rows="10" cols="16" id="latestRates"></textarea>
		</div>
	</div>

	<h3>Convert :</h3>
	<div id="convert">
		<div>
			<label>Amount : </label>
			<div>
				<input type="text" name="amount">
			</div>
			<label>From : </label>
			<div>
				<select name="groupid" class="select-group" id="selectCountries">
					<option value="0" selected>(Please select an option)</option>
				</select>
			</div>
			<label>To : </label>
			<div>
				<input type="text" name="to">
			</div>
		</div>
	</div>
</body>
</html>
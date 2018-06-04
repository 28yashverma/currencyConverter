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
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="loadStaticData()">
	<div class="container">
		<div>
			<h1>Welcome :</h1>
			<c:if test="${not empty username}">
				${username}
			</c:if>
		</div>


		<div>
			<form action="/logout" method="post">
				<button type="submit">Logout</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>

		<br>
		<div id="latestRates">
			<div>
				<button type="submit" onclick="getData('latest')" id="btnLatest">Latest
					:</button>
			</div>
			<div id="textLatestRates">
				<textarea rows="10" cols="16" id="latestRates" readonly="readonly"></textarea>
			</div>
		</div>

		<form action="/convert" method="get">
			<h3>Convert :</h3>
			<div id="convert">
				<div>
					<label>Amount : </label>
					<div>
						<input type="text" name="amount" id="amount"
							onchange="convert(false)">
					</div>
					<label>From : </label>
					<div>
						<select name="groupid" class="select-group" id="selectCountries1"
							onchange="convert(false)">
							<option value="0" selected>(Please select an option)</option>
						</select>
					</div>
					<label>To : </label>
					<div>
						<select name="groupid" class="select-group" id="selectCountries2"
							onchange="convert(false)">
							<option value="0" selected>(Please select an option)</option>
						</select>
					</div>
				</div>
				<div>
					<button type="submit" id="convertAmount" onclick="convert(true)">Convert</button>
				</div>
				<div>
					<label for="Result">Result : </label>
					<div>
						<h2 id="resultAmountConverted"></h2>
					</div>
				</div>
			</div>
		</form>

		<h3>History of queries :</h3>
		<textarea rows="10" cols="100"></textarea>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome</title>
<script type="text/javascript"
	src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/toastr.min.js"></script>
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body onload="loadStaticData()">
	<div class="jumbotron jumbotron-fluid" style="background: silver;">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h1 class="display-6">Welcome</h1>
					<p class="lead">
						<c:if test="${not empty username}">
						${username}
					</c:if>
					</p>
					<p class="lead">
					<form action="/logout" method="post">
						<button class="btn btn-outline-danger" type="submit">Logout</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					</p>

				</div>
				<div class="col-md-8">
					<img alt="Curency Converter Logo" src="CurrencyConverterLogo.png"
				class="img-fluid" height="200" width="200">
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<div id="latestRates" class="form-row">
						<div class="col-md-4">
							<button type="submit" onclick="getData('latest')" id="btnLatest"
								class="btn btn-outline-primary">Latest</button>
						</div>
						&nbsp;
						<div class="col-md-6" id="textLatestRates">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Currency code</th>
										<th>Currency rate</th>
									</tr>
								</thead>
								<tbody id="tbodyCurrency">
								</tbody>
							</table>
							<!-- <textarea rows="6" cols="15" id="latestRates"
								class="form-control" style="border: none;"></textarea> -->
						</div>
					</div>
					<hr>
					<div class="form-row">
						<form>
							<h3>Convert :</h3>
							<div id="convert">
								<div class="form-group">
									<label>Amount : </label> <input type="text" name="amount"
										id="amount" onchange="convert(false)" class="form-control">
									<label>From : </label> <select name="groupid"
										class="select-group form-control" id="selectCountries1"
										onchange="convert(false)">
										<option value="0" selected>(Please select an option)</option>
									</select> <label>To : </label> <select name="groupid"
										class="select-group form-control" id="selectCountries2"
										onchange="convert(false)">
										<option value="0" selected>(Please select an option)</option>
									</select>
								</div>
								<div class="form-group">
									<button type="button" id="convertAmount"
										onclick="convert(true)" class="btn btn-outline-primary">Convert</button>
								</div>
								<div>
									<label for="Result">Result : </label>
									<div>
										<h3 id="resultAmountConverted"></h3>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="form-group col-md-4">
					<h3>History of queries :</h3>
					<div class="form-control" id="showHistories"
						style="border: none; width: 400px; height: 500px; overflow: auto;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

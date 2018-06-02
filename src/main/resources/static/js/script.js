function checkUser(user) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkUser/" + user.value,
		dataType : 'json',
		success : function(response) {
			display(response);
		},
		error : function(e) {
			display(e.responseText);
		}
	});

}
function display(data) {
	if (data === "user name is available") {
		$('#resultCheckUser').html(data);
		$('#btn-submit').prop("disabled", false);
	} else {
		document.getElementById("resultCheckUser").setAttribute("id",
				"resultCheckUserFailed");
		$('#resultCheckUserFailed').html(data);
		$('#btn-submit').prop("disabled", true);
	}

}

function checkPassword(confirmPassword, password) {
	var data = {};
	data["password"] = password.value;
	data["confirmPassword"] = confirmPassword.value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/passwordValidate",
		data : JSON.stringify(data),
		dataType : 'json',
		timeout : 600000,
		success : function(data) {
			$('#checkPassword').html(data);
			$('#btn-submit').prop("disabled", true);

			if (data.length === 0) {
				$('#btn-submit').prop("disabled", false);
			}

		},
		error : function(e) {
		}
	});

}

function getData(passedVal) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/" + passedVal + "/",
		dataType : 'json',
		success : function(response) {
			var rates = response.rates;
			showData(rates);
		},
		error : function(e) {
			console.log(e.responseText);
		}
	});
}

function showData(dataToDisplay) {
	$('textarea#latestRates').val(JSON.stringify(dataToDisplay));
}

function loadStaticData() {
	var currenciesList = [];
	var selectField = $('.select-group');
	var options = '';
	selectField.empty();

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/currencies",
		dataType : 'json',
		success : function(response) {
			console.log(response);
			currenciesList = response;
			for (var i = 0; i < currenciesList.length; i++) {
				options += '<option value="' + currenciesList[i] + '">'
						+ currenciesList[i] + '</option>';
			}
			selectField.append(options);
		},
		error : function(e) {
			console.log(e.responseText);
		}
	});
}

function convert(istrue) {
	var amount = $('#amount').val();
	var selectCountry_1 = $('#selectCountries1').val();
	var selectCountry_2 = $('#selectCountries2').val();
	var buttonId = $('#convertAmount');
	var status = istrue;

	if (selectCountry_1 === selectCountry_2 || isNaN(amount)) {
		buttonId.prop("disabled", true);
	} else {
		buttonId.prop("disabled", false);
	}

	if (status) {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/convert/" + amount + "/" + selectCountry_1 + "/"
					+ selectCountry_2,
			dataType : 'json',
			success : function(response) {
				console.log(response);
			},
			error : function(e) {
				console.log(e.responseText);
			}
		});
	}

}
function checkUser(user) {
	if (!isNaN(user.value)) {
		display('User cannot be a number')
		return;
	}

	if (user.value.length < 6) {
		display('User name cannot be of less than 6 characters');
		return;
	}
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkUser/" + user.value,
		dataType : 'text',
		success : function(response) {
			display(response);
		},
		error : function(e) {
			display(e.responseText);
		}
	});

}

function checkEmail(email) {
	var emailVal = email.value;
	var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

	if (emailVal.length <= 12) {
		showToaster(StatusEnum._ERROR, 'Email cannot be of less that 12 characters')
		return;
	}

	if (emailVal.indexOf("@") === -1) {
		showToaster(StatusEnum._ERROR, 'Email should have @ sign')
		return;
	}

	if (emailVal.indexOf(".") === -1) {
		showToaster(StatusEnum._ERROR, 'Email should have .')
		return;
	}

	if (emailVal.indexOf("com") === -1) {
		showToaster(StatusEnum._ERROR, 'Email should end with com')
		return;
	}

	if (!re.test(emailVal)) {
		showToaster(StatusEnum._ERROR, 'Email should be of abc@mail.com pattern')
		return;
	}

	$('#btn-submit').prop("disabled", false);
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkEmail/" + emailVal,
		dataType : 'text',
		success : function(response) {
			if (response === "") {

			} else {
				showToaster(StatusEnum._INFO, response)
				$('#btn-submit').prop("disabled", true);
			}
		},
		error : function(e) {
			showToaster(StatusEnum._ERROR, e.responseText);
		}
	});
}

function display(data) {
	if (data === "user name is available") {
		showToaster(StatusEnum._SUCCESS, data);
		$('#btn-submit').prop("disabled", false);
	} else {
		document.getElementById("resultCheckUser").setAttribute("id",
			"resultCheckUserFailed");
		showToaster(StatusEnum._ERROR, data);
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
			if (data.length > 0) {
				toastr.info(data);
			}
			$('#btn-submit').prop("disabled", true);

			if (data.length === 0) {
				$('#btn-submit').prop("disabled", false);
			}

		},
		error : function(e) {
			toastr.error(e.responseText);
		}
	});

}

function getData(passedVal) {
	var btnLatest = $('#btnLatest');
	btnLatest.prop("disabled", true);
	var lis = '';

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/" + passedVal + "/",
		dataType : 'json',
		success : function(response) {
			latestRatesList = response;
			for (var i = 0; i < latestRatesList.length; i++) {
				lis += latestRatesList[i].currencyName + ":" + latestRatesList[i].rate + "\n";
			}
			console.log(lis);

			showData(lis);
			btnLatest.prop("disabled", false);

		},
		error : function(e) {
			btnLatest.prop("disabled", false);
		}
	});
}

function showData(dataToDisplay) {
	$('textarea#latestRates').val(dataToDisplay);
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
		buttonId.prop("disabled", true);
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/convert/" + amount + "/" + selectCountry_1 + "/"
				+ selectCountry_2,
			dataType : 'json',
			success : function(response) {
				console.log(response);
				buttonId.prop("disabled", false);
			},
			error : function(e) {
				console.log(e.responseJSON);
				if (e.responseJSON.code === "500") {
					alert(e.responseJSON.message)
				}
				buttonId.prop("disabled", false);
			}
		});
	}

}

function checkLoginUser(user) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkLoginUser/" + user.value,
		dataType : 'text',
		success : function(response) {
			showToaster(StatusEnum._INFO, response)
		},
		error : function(e) {
			showToaster(StatusEnum._ERROR, e.responseText);
		}
	});
}

var StatusEnum = {
	_INFO : 'info',
	_ERROR : 'error',
	_WARN : 'warn',
	_SUCCESS : 'success'
}

function showToaster(status, msg) {
	switch (status) {
	case StatusEnum._INFO:
		toastr.info(msg);
		break;
	case StatusEnum._ERROR:
		toastr.error(msg);
		break;
	case StatusEnum._WARN:
		toastr.warn(msg);
		break;
	case StatusEnum._SUCCESS:
		toastr.success(msg);
	}

}
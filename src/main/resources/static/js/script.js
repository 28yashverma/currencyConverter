function checkUser(user) {
	if (!isNaN(user.value)) {
		toastr.error("User cannot be a number")
		return;
	}
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

function checkEmail(email) {
	var emailVal = email.value;
	var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

	if (email.length == 0) {
		toastr.error("Email field cannot be left blank")
		return;
	}

	if (emailVal.indexOf("@") === -1) {
		toastr.error("Email should contain @ sign")
		return;
	}

	if (emailVal.indexOf(".") === -1) {
		toastr.error("Email should contain .")
		return;
	}

	if (emailVal.indexOf("com") === -1) {
		toastr.error("Email should end with com")
		return;
	}

	if (!re.test(emailVal)) {
		toastr.error("Email should be in the form of abc@mail.com")
		return;
	}

	$('#btn-submit').prop("disabled", false);
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkEmail/" + emailVal,
		dataType : 'json',
		success : function(response) {
			if (response === "") {

			} else {
				toastr.info(response)
			}
		},
		error : function(e) {
			if (e.responseText === "") {

			} else {
				toastr.info(e.responseText)
				$('#btn-submit').prop("disabled", true);
			}
		}
	});
}

function display(data) {
	if (data === "user name is available") {
		toastr.success(data);
		$('#btn-submit').prop("disabled", false);
	} else {
		document.getElementById("resultCheckUser").setAttribute("id",
				"resultCheckUserFailed");
		toastr.error(data);
		$('#btn-submit').prop("disabled", true);
	}

}

function checkPassword(confirmPassword, password) {
	debugger;
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

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/" + passedVal + "/",
		dataType : 'json',
		success : function(response) {
			var rates = response.rates;
			showData(rates);
			btnLatest.prop("disabled", false);
		},
		error : function(e) {
			console.log(e.responseText);
			btnLatest.prop("disabled", false);
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
		dataType : 'json',
		success : function(response) {
			if (response === "success") {
				toastr.info(response);
			} else {
				toastr.info(response);
			}
		},
		error : function(e) {
			toastr.info(e.responseText);
		}
	});

}
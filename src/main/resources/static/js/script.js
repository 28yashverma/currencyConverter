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
		error : function(e) {}
	});

}
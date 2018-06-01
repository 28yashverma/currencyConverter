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
	} else {
		document.getElementById("resultCheckUser").setAttribute("id",
				"resultCheckUserFailed");
		$('#resultCheckUserFailed').html(data);
	}

}

function checkPassword(confirmPassword, password) {
	if (confirmPassword.value != password.value) {
		document.getElementById("checkPassword").style.color = "red";
		$('#checkPassword').html(
				"Password mismatched, please input correct password");
	} else {
		document.getElementById("checkPassword").style.color = "blue";
		$('#checkPassword').html("Password matched");
	}

}
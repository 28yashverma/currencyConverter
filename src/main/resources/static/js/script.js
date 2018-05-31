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

function checkUser(user) {

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/checkUser/" + user.value,
		dataType : 'json',
		success : function(response) {
			console.log(response);
			display(response);
		},
		error : function(e) {
			console.log(e.responseText)
			display(e.responseText);
		}
	});

}
function display(data) {
	if (data === "user name is available") {
		console.log("equal");
		$('#resultCheckUser').html(data);
	} else {
		document.getElementById("resultCheckUser").setAttribute("id",
				"resultCheckUserFailed");
		$('#resultCheckUserFailed').html(data);
	}

}
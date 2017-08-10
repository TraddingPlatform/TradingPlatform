function GetJsonData() {
	var json = {
		"username" : $("#username").val(),
		"inputPassword" : $("#inputPassword").val(),

	};
	return json;
}

function login() {
	var username = $("#username").val();
	var j = {
		"username" : username
		
	};
	var data = '{"username": "4"}';
	console.log(JSON.stringify(j));
	/* alert(JSON.stringify(j)); */
	$.ajax({
		data : JSON.stringify(GetJsonData()),
		contentType : "text/html;charset=utf-8",
		type : "POST",
		dataType : "json",
		url : "login.spring",
		error : function(data) {
			console.error("error:" + JSON.stringify(data));
		},
		success : function(map) {
			console.log(JSON.stringify(map));
			sessionStorage.setItem("traderId",map.traderId); 
			location.href = "newSubmit.jsp";
		}
	});
}
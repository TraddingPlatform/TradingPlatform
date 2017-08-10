function checkField(val) {
	if (val != "No Strategy") {
		$("#append").show();
	} else {
		$("#append").hide();
	}
}

/*
 * $(document).ready(function() { $("#submit-btn").click(function() { var
 * equitySymbol = $("#equitySymbol").val(); alert(equitySymbol); var jsonUser = {
 * equitySymbol : equitySymbol };
 * 
 * var strUser = JSON.stringify(jsonUser); var j = GetJsonData();
 * $.post("submit.spring", { json : JSON.stringify(strUser) }, function(data,
 * status) { alert("数据: \n" + data + "\n状态: " + status); });
 * 
 * }); });
 */
function GetJsonData() {
	var json = {
		"equitySymbol" : $("#equitySymbol").val(),
		"quantity" : $("#quantity").val(),
		"price" : $("#price").val(),
		"isBuy" : $("#isBuy").val(),
		"tradeType" : $("#tradeType").val(),
		"profit" : $("#profit").val(),
		"loss" : $("#loss").val(),
		"traderId": sessionStorage.getItem("traderId")

	};
	return json;
}

function func() {
	console.log("11");
	var equitySymbol = $("#equitySymbol").val();
	var j = {
		"equitySymbol" : equitySymbol
	};
	var data = '{"managerid": "4"}';
	console.log(JSON.stringify(j));
	/* alert(JSON.stringify(j)); */
	$.ajax({
		data : JSON.stringify(GetJsonData()),
		contentType : "text/html;charset=utf-8",
		type : "POST",
		dataType : "json",
		url : "submit.spring",
		error : function(data) {
			console.error("error:" + JSON.stringify(data));
		},
		success : function(map) {
			console.log(JSON.stringify(map));
			alert(map.message);
		}
	});
}
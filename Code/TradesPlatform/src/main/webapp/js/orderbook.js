function GetJsonData() {
	var json = {
		"symbol" : $("#symbol").val(),
	};
	return json;
}

function autoRefresh() {
	// 只有在用户输入了Symbol的情况下才会实时刷新
	var username = sessionStorage.getItem("traderId");
	var symbol = $("#symbol").val();
	console.log("Symbol value: " + symbol);
	if (symbol != null) {
		console.log("Update Symbol Data");
		get_symbol_data();
	}
}

function get_symbol_data() {
	$.ajax({
		data : JSON.stringify(GetJsonData()),
		contentType : "text/html;charset=utf-8",
		type : "POST",
		dataType : "json",
		url : "orderBook.spring",
		success : function(data) {
			if (data.exists === true) {
				var symbolData = data.orderlist;
				process_data(symbolData);

			} else {
				alert("No such sumbol. Retry.");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert("error");
//			alert(XMLHttpRequest.status);
//			alert(XMLHttpRequest.readyState);
//			alert(textStatus);
		}
		
	});
	

}

function process_data(data) {
	delete_table_rows();
	var bidData = data.bid;
	var askData = data.ask;
	var bidLength = bidData.length;
	var askLength = askData.length;
	if (bidLength >= askLength) {
		for (let i = 0; i < askLength; i++) {
			var bidItem = bidData[i];
			var askItem = askData[i];
			insert_row(bidItem.equitySymbol, bidItem.quantity, bidItem.price,
					askItem.price, askItem.quantity);
		}

		for (let i = askLength; i < bidLength; i++) {
			var bidItem = bidData[i];
			insert_row(bidItem.equitySymbol, bidItem.quantity, bidItem.price, "", "");
		}
	} else {
		for (let i = 0; i < bidLength; i++) {
			var bidItem = bidData[i];
			var askItem = askData[i];
			insert_row(bidItem.symbol, bidItem.quanlity, bidItem.price,
					askItem.price, askItem.quanlity);
		}

		for (let i = bidLength; i < askLength; i++) {
			var askItem = askData[i];
			insert_row(askItem.symbol, "", "", askItem.price, askItem.quanlity);
		}
	}
}

function insert_row(symbol, bidQty, bidPrice, askPrice, askQty) {
	$("#mytable>tbody").append(
			"<tr><th scope='row' abbr='Model' class='spec'>" + symbol + "</th>"
					+ "<td>" + bidQty + "</td>" + "<td>" + bidPrice + "</td>"
					+ "<td>" + askPrice + "</td>" + "<td>" + askQty + "</td>"
					+ "</tr>");
}

function delete_table_rows() {
	var tb = document.getElementById('mytable');
	var rowNum = tb.rows.length;
	for (i = 1; i < rowNum; i++) {
		tb.deleteRow(i);
		rowNum = rowNum - 1;
		i = i - 1;
	}
}

$(document).ready(function() {
	var username = sessionStorage.getItem("traderId");
	if (username != null) {
		//		alert("Trader Logined!");
		$("#link_usename").html(username);
	} else {
		// alert("Trader not logined");
		location.href = "newLogin.jsp";
	}
	
	// 每隔1秒请求数据刷新
	setInterval("autoRefresh()", 1000);
});

function logout() {
	sessionStorage.removeItem("traderId");
	location.href = "newLogin.jsp";
}

function click_type(e) {
	var text = e.target.text;
	$("#choose_order_type").text(text);
	if (text === "GTC" || text === "FOK") {
		add_price_input();
	} else {
		remove_price_input();
	}
}

function b_o_type(e) {
	$("#choose_b_o_type").text(e.target.text);
}

function add_price_input() {
	if (!($("#trader_price_label").length > 0)) {
		var price_label = "<label id='trader_price_label'>Price</label>";
		// var price_input = "<input id='trader_price_input' class='form-control' type='text' name='symbol' placeholder='Price' onkeypress='if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value' onkeyup='if(!this.value.match(/^[\+\-]?\d*?\.?\d*?$/))this.value=this.t_value;else this.t_value=this.value;if(this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?)?$/))this.o_value=this.value' onblur='if(!this.value.match(/^(?:[\+\-]?\d+(?:\.\d+)?|\.\d*?)?$/))this.value=this.o_value;else{if(this.value.match(/^\.\d+$/))this.value=0+this.value;if(this.value.match(/^\.$/))this.value=0;this.o_value=this.value}' data-reactid='.0.1.0.0.2:0.0.1.0.0.$signin.1.2'>";
		var price_input = "<input type='number' step='1' id='trader_price_input' class='form-control' placeholder='Price' data-reactid='.0.1.0.0.2:0.0.1.0.0.$signin.1.2'/>";
		$("#buy_offer_quantity").after(price_label, price_input);
	}
}

function remove_price_input() {
	if ($("#trader_price_label").length > 0) {
		$("#trader_price_label").remove();
		$("#trader_price_input").remove();
	}
}

function submit_order() {
	// alert("Submit order");

	var isValid = true;

	var price = 0;
	if ($("#trader_price_input").length > 0) {
		price = $("#trader_price_input").val();
		if (price) {
			isValid = true;
		}
	}
	var symbol = $("#order-symbol").val();
	var order_type = $("#choose_order_type").text().replace(/(^\s*)|(\s*$)/g,
			"");
	var order_type_int;
	if(order_type == "Market Orders") {
		order_type_int = 1;
	} else if (order_type == "IOC") {
		order_type_int = 2;
	} else if (order_type == "FOK") {
		order_type_int = 3;
	} else {
		order_type_int = 4;
	}
	var buy_or_sale = $("#choose_b_o_type").text()
			.replace(/(^\s*)|(\s*$)/g, "");
	var quantity = $("#buy_offer_quantity").val();
	if (symbol == "" || order_type == "Choose Order Type"
			|| buy_or_sale == "Buy / Offer" || quantity == "") {
		isValid = false;
	}
	if (isValid == false) {
		alert("Form not completed!");
		return false;
	}
	var buy_or_sale_int;
	if(buy_or_sale == "Buy") {
		buy_or_sale_int = 1;
	} else {
		buy_or_sale_int = 0;
	}
	var orderJson = {
		"symbol" : symbol,
		"order_type" : order_type_int,
		"buy_or_sale" : buy_or_sale_int,
		"quantity" : quantity,
		"price" : price,
		"traderId" : sessionStorage.getItem("traderId"),
	};
	$.ajax({
		type : "get",
		url : "/TradingPlatformWeb/MakeTradeServlet",
		data : orderJson,
		async : true,
		dataType : "JSON",
		success : function(data) {
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("error");
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
		}
	});
}

function alertObj(obj) {
	var output = "";
	for ( var i in obj) {
		var property = obj[i];
		output += i + " = " + property + "\n";
	}
	alert(output);
}

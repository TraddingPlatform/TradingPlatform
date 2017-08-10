<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Trading Platform</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<meta name="robots" content="index, follow">

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">
<link type="text/css" rel="stylesheet" href="css/styles.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" async="" defer=""
	src="https://piwik.teamemo.com/piwik.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<!-- <script type="text/javascript">
    $(function(){

        $("#submit-btn").click(function(){
            var equitySymbol = $("#equitySymbol").val();    
                  
            var jsonUser = {equitySymbol:equitySymbol};    
            
            var strUser = JSON.stringify(jsonUser);    
            
            $.post("submit.spring", {json: strUser}, callback, "json");
        });

        function callback(json){
            alert(json.msg);    //æ¾ç¤ºåé¦ä¿¡æ¯
            if(json.suc == 1){    //å¦æè¿å"ç»å½æå"
                window.location.href = "index.jsp";    //è·³è½¬å°åå°ä¸»é¡µ
            }
        }
        
    });
</script>
 -->
<script type="text/javascript">
	function checkField(val) {
		if (val != "No Strategy") {
			$("#append").show();
		} else {
			$("#append").hide();
		}
	}

	/* $(document).ready(function() {
		$("#submit-btn").click(function() {
			var equitySymbol = $("#equitySymbol").val();
			alert(equitySymbol);
			var jsonUser = {
				equitySymbol : equitySymbol
			};

			var strUser = JSON.stringify(jsonUser);
			var j = GetJsonData();
			$.post("submit.spring", {
				json : JSON.stringify(strUser)
			}, function(data, status) {
				alert("数据: \n" + data + "\n状态: " + status);
			});

		});
	});
	 */
	function GetJsonData() {
		var json = {
			"equitySymbol" : $("#equitySymbol").val(),
			"quantity" : $("#quantity").val(),
			"price" : $("#price").val(),
			"isBuy" : $("#isBuy").val(),
			"tradeType" : $("#tradeType").val(),
			"profit" : $("#profit").val(),
			"loss" : $("#loss").val()

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
</script>

<!-- End Piwik Code -->

<style type="text/css">
body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 450px;
	padding: 0;
	margin: 0;
	MARGIN-LEFT: 52.5px
}

caption {
	padding: 0 0 5px 0;
	width: 700px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 11px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}

html>body td {
	font-size: 11px;
}
</style>
</head>
<body class="">
	<div class="with-newsletter sticked-navbar" data-reactid=".0">
		<nav class="navbar navbar-default navbar-fixed-top sticky"
			data-reactid=".0.0">
		<div class="container" data-reactid=".0.0.0">
			<div class="navbar-header" data-reactid=".0.0.0.0">
				<a class="navbar-brand crawler-logo" href="/"><b
					class="app-name">Trading Platform</b></a>
				<button class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navcol-1" data-reactid=".0.0.0.0.1">
					<span class="sr-only" data-reactid=".0.0.0.0.1.0">Toggle
						Navigation</span><span class="icon-bar" data-reactid=".0.0.0.0.1.1"></span><span
						class="icon-bar" data-reactid=".0.0.0.0.1.2"></span><span
						class="icon-bar" data-reactid=".0.0.0.0.1.3"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="navcol-1"
				data-reactid=".0.0.0.1">
				<ul class="nav navbar-nav navbar-right" data-reactid=".0.0.0.1.0">
					<li role="presentation" data-reactid=".0.0.0.1.0.0:0"><a
						id="link_signup" href="https://teamemo.com/#signup"
						data-reactid=".0.0.0.1.0.0:0.0">Market Graph</a></li>
					<li role="presentation" data-reactid=".0.0.0.1.0.0:1"><a
						href="https://teamemo.com/features"
						data-reactid=".0.0.0.1.0.0:1.0"><span
							data-reactid=".0.0.0.1.0.0:1.0.0"> </span><span
							data-reactid=".0.0.0.1.0.0:1.0.1">Trades Display</span><span
							data-reactid=".0.0.0.1.0.0:1.0.2"> </span></a></li>
					<li role="presentation" data-reactid=".0.0.0.1.0.0:2"
						class="active"><a href="submit.jsp"
						data-reactid=".0.0.0.1.0.0:2.0" class="active"><span
							data-reactid=".0.0.0.1.0.0:2.0.0">Make Trades</span><span
							data-reactid=".0.0.0.1.0.0:2.0.1"> </span></a></li>
					<li role="presentation" data-reactid=".0.0.0.1.0.0:3" class=""><a
						id="link_signin" href="index.jsp" data-reactid=".0.0.0.1.0.0:3.0">Sign
							in</a></li>
					<li class="dropdown" data-reactid=".0.0.0.1.0.1"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"
						data-track-category="lang"
						data-track-action="toggle-lang-dropdown"
						data-reactid=".0.0.0.1.0.1.0"><span class="lang-icon"
							title="Strategies" data-reactid=".0.0.0.1.0.1.0.0">Strategies</span><span
							data-reactid=".0.0.0.1.0.1.0.1"> </span><span class="caret"
							data-reactid=".0.0.0.1.0.1.0.2"></span></a>
						<ul class="dropdown-menu language-dropdown"
							data-reactid=".0.0.0.1.0.1.1">
							<li data-reactid=".0.0.0.1.0.1.1.$en"><a title="Strategie1"
								data-track-category="lang" data-track-action="choose-lang"
								data-track-name="en" href="/?L=en"
								data-reactid=".0.0.0.1.0.1.1.$en.0"><span class="lang-icon"
									title="Strategie1" data-reactid=".0.0.0.1.0.1.1.$en.0.0">Strategie1</span></a></li>
							<li data-reactid=".0.0.0.1.0.1.1.$de"><a title="Strategie2"
								data-track-category="lang" data-track-action="choose-lang"
								data-track-name="de" href="/de?L=de"
								data-reactid=".0.0.0.1.0.1.1.$de.0"><span class="lang-icon"
									title="Strategie2" data-reactid=".0.0.0.1.0.1.1.$de.0.0">Strategie2</span></a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		</nav>

	</div>
	<div class="container" data-reactid=".0.1.0.0.2:0.0.1">
		<div class="row" data-reactid=".0.1.0.0.2:0.0.1.0">
			<div class="col-md-6 phone-preview"
				data-reactid=".0.1.0.0.2:0.0.1.0.0">
				<div class="sign-card" id="symbol_form"
					data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin">
					<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0">Input Equity
						Symbol</h3>
					<form class="form-sign" id="symbolForm" onsubmit="return false;"
						data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1">
						<input id="symbol" class="form-control submit-input" type="text"
							required="" name="symbol" placeholder="Symbol"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.2"> <input
							id="symbol-btn" onclick="get_symbol_data()"
							class="btn btn-primary btn-block btn-lg btn-signin" type="submit"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4" value="Show"></input>
					</form>
				</div>

				<div class="symbol-table">
					<table id="mytable" cellspacing="0">
						<tr>
							<th scope="col" abbr="Configurations">Symbol</th>
							<th scope="col" abbr="Dual 1.8">Qty</th>
							<th scope="col" abbr="Dual 2">Bid</th>
							<th scope="col" abbr="Dual 2">Ask</th>
							<th scope="col" abbr="Dual 2">Qty</th>
						</tr>

					</table>
				</div>


			</div>
			<div class="col-md-6 phone-preview"
				data-reactid=".0.1.0.0.2:0.0.1.0.0">
				<div class="sign-card submit-card " id="submit_form"
					data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin">
					<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0">Make Trades</h3>
					<form class="form-sign" method="post"
						data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1" id="form-submit">
						<input type="hidden" name="_form" value="login"><input
							type="hidden" name="organizationSlug" value=""
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.1"><input
							class="form-control submit-input" type="text" required=""
							name="equitySymbol" placeholder="equitySymbol" id="equitySymbol"
							name="equitySymbol"><input
							class="form-control submit-input" type="text" name="quantity"
							required="" placeholder="quantity" id="quantity"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3"><input
							class="form-control submit-input" type="text" name="price"
							required="" placeholder="price" id="price"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3"><select
							class="form-control submit-input" id="isBuy" name="isBuy">
							<option value="BUY">BUY</option>
							<option value="SALE">SALE</option>
						</select> <select class="form-control submit-input" id="tradeType"
							name="isBuy">
							<option value="BUY">MRKT</option>
							<option value="IOC">IOC</option>
							<option value="FOK">FOK</option>
							<option value="GCT">GCT</option>

						</select> <select class="form-control submit-input" name="Strategy"
							id="StrategySelect" onchange="checkField(this.value)">
							<option value="No Strategy">No Strategy</option>
							<option value="Strategy1">Strategy1</option>
							<option value="Strategy2">Strategy2</option>
						</select>
						<div id="append" style="display: none">
							<input class="form-control submit-input" type="text hidden"
								name="profot" required="" placeholder="profit" id="profit"
								data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3"> <input
								class="form-control submit-input" type="text hidden" name="loss"
								required="" placeholder="loss" id="loss"
								data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3">
						</div>
						<!-- <button id="submit-btn"
							class="btn btn-primary btn-block btn-lg btn-signin" type="button"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4" onclick="func()">Submit</button> -->

						<button id="submit-btn2"
							class="btn btn-primary btn-block btn-lg btn-signin" type="button"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4" onclick="func()">Submit</button>

					</form>
				</div>
			</div>


		</div>











	</div>
	<footer style="margin-top: 5px;" data-reactid=".0.3">
	<div class="row" data-reactid=".0.3.0">
		<div class="col-md-6 col-sm-6 footer-navigation"
			data-reactid=".0.3.0.0">
			<h3 data-reactid=".0.3.0.0.0">
				<a class="navbar-brand crawler-logo" href="/"><b
					class="app-name">Trading Platform</b></a>

			</h3>
			<p class="company-name" data-reactid=".0.3.0.0.2">
				<span data-reactid=".0.3.0.0.2.0">TeamName Â© </span><span
					data-reactid=".0.3.0.0.2.1">2017</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
		<div class="col-md-6 footer-about" data-reactid=".0.3.0.3">
			<h4 data-reactid=".0.3.0.3.0">About Trade Platform</h4>
			<p data-reactid=".0.3.0.3.1">Functions..............</p>
		</div>
	</div>
	</footer>
</body>
</html>
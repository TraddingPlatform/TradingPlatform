<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>SnowBall Trading Platform</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/build-20170702.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/css.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="css/styles.css">
<link type="text/css" rel="stylesheet" href="css/myStyles.css">

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">

<link href="css/bootstrap.min.css" rel="stylesheet" />


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/submit.js"></script>
<script type="text/javascript" src="js/orderbook.js"></script>

<!-- pretty print code-->
<script type="text/javascript">
	
</script>

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

.symbol-table-container {
	margin-top:150px;
}
.slides {
	padding:0;margin:0;
}
</style>
</head>
<body>
	<div class="nav-container">
		<nav class="nav-1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a href="/" class="home-link"><img alt="Logo"
						src="imgs/citi.png" class="logo logostyle"></a>
					<ul class="menu">

						<li><a href="newPortfolio.jsp">Portfolio</a></li>
						<li><a href="newSubmit.jsp">Order Book</a></li>
						<li><a href="newTradehistory.jsp">Trades Display</a></li>
						<li><a href="newGtcOrder.jsp">GTC Order</a></li>
					</ul>
					<div class="text-right">
						<ul class="social-links">
							<!-- <li><a href="https://app.eventn.com/signup" target="_blank">Sign
									Up</a></li> -->
							<li><a href="javascript:void(0)" target="_blank" id = "login-out" onclick = "logout(); return false;">Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="mobile-toggle">
			<div class="bar-1"></div>
			<div class="bar-2"></div>
		</div>
		</nav>
	</div>
	<div class="main-container">
		<section class="hero-slider large-image">
		<ul class="slides">
			<li class="flex-active-slide"
				style="width: 100%; float: left; margin-right: -100%; position: relative; opacity: 1; display: block; z-index: 2;"><div
					class="background-image-holder overlay fadeIn"
					style="background: url(&quot;imgs/background.jpg&quot;) 50% 50%;">
					<img alt="Analytics Microservice" src="imgs/background.jpg"
						class="background-image" draggable="false" style="display: none;">
				</div>
				<div class="container vertical-align">
					<div class="row">
						<div class="col-sm-12 text-center symbol-table-container">


							<div class="col-md-6 phone-preview"
								data-reactid=".0.1.0.0.2:0.0.1.0.0">
								<div class="sign-card submit-card" id="symbol_form"
									data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin">
									<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0">Search
										Equity Symbol</h3>
									<form class="form-sign" id="symbolForm"
										onsubmit="return false;"
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1">
										<input id="symbol" class="form-control submit-input"
											type="text" required="" name="symbol" placeholder="Symbol"
											data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.2"> <input
											id="symbol-btn" onclick="get_symbol_data()"
											class="btn btn-primary btn-block btn-lg btn-signin symbol-btn"
											type="submit" data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4"
											value="Show"></input>
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
									<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0">Make
										Trades</h3>
									<form class="form-sign" method="post"
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1" id="form-submit">
										<input type="hidden" name="_form" value="login"><input
											type="hidden" name="organizationSlug" value=""
											data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.1"><input
											class="form-control submit-input" type="text" required=""
											name="equitySymbol" placeholder="equitySymbol"
											id="equitySymbol" name="equitySymbol"><input
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
											<option value="Mrkt">MRKT</option>
											<option value="Ioc">IOC</option>
											<option value="Fok">FOK</option>
											<option value="Gtc">GTC</option></select>
											<button id="submit-btn2"
											class="btn btn-primary btn-block btn-lg btn-signin"
											type="button" data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4"
											onclick="func();">Submit</button>

										

									</form>
								</div>
							</div>


						</div>
					</div>
				</div></li>
		</ul>
		<ol class="flex-control-nav flex-control-paging"></ol>
		</section>
	</div>
	<footer style="margin-top: 0px; background-color: #0F1A2C;"
		data-reactid=".0.3">
	<div class="row" data-reactid=".0.3.0">
		<div class="col-md-6 col-sm-6 footer-navigation"
			data-reactid=".0.3.0.0">

			<p class="company-name" data-reactid=".0.3.0.0.2">
				<span data-reactid=".0.3.0.0.2.0">Two Hours Â© </span><span
					data-reactid=".0.3.0.0.2.1">2017 </span><span
					data-reactid=".0.3.0.0.2.1">ShangHai</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
		<div class="col-md-6 footer-about" data-reactid=".0.3.0.3"></div>
	</div>
	</footer>
	<!-- prettyPrint-->
	<div id="lightboxOverlay" class="lightboxOverlay"
		style="display: none;"></div>
	<div id="lightbox" class="lightbox" style="display: none;">
		<div class="lb-outerContainer">
			<div class="lb-container">
				<img class="lb-image" src="">
				<div class="lb-nav">
					<a class="lb-prev" href=""></a><a class="lb-next" href=""></a>
				</div>
				<div class="lb-loader">
					<a class="lb-cancel"></a>
				</div>
			</div>
		</div>
		<div class="lb-dataContainer">
			<div class="lb-data">
				<div class="lb-details">
					<span class="lb-caption"></span><span class="lb-number"></span>
				</div>
				<div class="lb-closeContainer">
					<a class="lb-close"></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
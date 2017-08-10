<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Eventn | Node.js HTTP Microservices for ETL, Analytics
	&amp; Data Processing</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/build-20170702.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/css.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="css/myStyles.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="css/myStyles.css">
<link href="css/orderhistory.css" rel="stylesheet" />
<script type="text/javascript" async="" defer=""
	src="https://piwik.teamemo.com/piwik.js"></script>

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="bootstrap-table-master/src/bootstrap-table.js"></script>
<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet" />
<script src="js/orderhistory.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="bootstrap-table-master/src/bootstrap-table.js"></script>
<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet" />
<script src="js/gtcorder.js"></script>
<script type="text/javascript" src="js/gtcorder.js"></script>

<!-- pretty print code-->
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
						<li class="active"><a href="newGtcOrder.jsp" >GTC Order</a></li>

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
				style="width: 100%; float: left; margin-right: -100%; position: relative; opacity: 1; display: block; z-index: 2;">
				<div class="background-image-holder overlay fadeIn"
					style="background: url(&quot;imgs/background.jpg&quot;) 50% 50%;">
					<img alt="Analytics Microservice" src="imgs/background.jpg"
						class="background-image" draggable="false" style="display: none;">
				</div>
				
				<div class="container vertical-align">
					<div class="row">
						<div class="col-sm-12 text-center" class = "sign-card">
						

							<div class="trade-history-card" id="signin_form"
								data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin">
								<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0"></h3>
								<form id="formSearch" class="form-horizontal">
								<div class="col-md-8" style="margin-top: 0px">
									<label class="control-label col-md-2"
										for="txt_search_departmentname">SYMBOL</label>
									<div class="control-label col-md-4">
										<input type="text"  class="form-control" id="txt_search_symbol">
									</div>


									<div class="control-label col-md-2" style="text-align: left;">
										<button type="button"  style="margin-left: 50px; margin-top: 0px" id="btn_query"
											class="btn btn-primary" onclick="search();">Search</button>
									</div>
								</div>
							</form>
							
							<div id="toolbar" class="btn-group">
						<button id="btn_edit" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit Order
						</button>
						<button id="btn_delete" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Cancle Order
						</button>
					</div>
					<table id="tb_departments"  border="0"></table>
									
							</div>


						</div>
					</div>
				</div>
				
			
			</li>
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
				<span data-reactid=".0.3.0.0.2.0">Two Hours © </span><span
					data-reactid=".0.3.0.0.2.1">2017 </span><span
					data-reactid=".0.3.0.0.2.1">ShangHai</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
		<div class="col-md-6 footer-about" data-reactid=".0.3.0.3"></div>
	</div>
	</footer>
	<script async="" src="https://www.google-analytics.com/analytics.js"></script>
	<script src="/js/build-20170730.min.js"></script>
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
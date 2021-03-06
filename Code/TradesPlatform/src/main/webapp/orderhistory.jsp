<%@ page language="java" contentType="text/html"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Trading Platform</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/build-20170702.min.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/css.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/orderhistory.css" rel="stylesheet" />


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="bootstrap-table-master/src/bootstrap-table.js"></script>
<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet" />
<script src="js/orderhistory.js"></script>

</head>
<body>
	<div class="nav-container">
		<nav class="nav-default nav-1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a href="/" class="home-link"><img alt="Logo"
						src="imgs/citi.png" class="logo logostyle"></a>
					<ul class="menu">
						<li><a href="newPortfolio.jsp">Portfolio</a></li>
						<li><a href="newSubmit.jsp">Order Book</a></li>
						<li><a href="orderhistory.jsp">Trades Display</a></li>
						<li><a href="gtcorder.jsp">GTC Order</a></li>
					</ul>
					<div class="text-right">
						<ul class="social-links">
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
		<div class="order-table-bg">
					<div class="panel-body">
					<div class="panel panel-default">
						<div class="panel-heading">Query</div>
						<div class="panel-body">
							<form id="formSearch" class="form-horizontal">
								<div class="form-group" style="margin-top: 15px">
									<label class="control-label col-sm-1"
										for="txt_search_departmentname">Symbol</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" id="txt_search_symbol">
									</div>

									<div class="col-sm-4" style="text-align: left;">
										<button type="button" style="margin-left: 50px" id="btn_query"
											class="btn btn-primary" onclick="search();">Search</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<!-- <div id="toolbar" class="btn-group">
						<button id="btn_edit" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Update
						</button>
						<button id="btn_delete" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Cancle
						</button>
					</div> -->
					<table id="tb_departments"></table>
				</div>
				</div>
	</div>
	<footer style="margin-top: 0px; background-color: #0F1A2C;"
		data-reactid=".0.3">
	<div class="row" data-reactid=".0.3.0">
		<div class="col-md-6 col-sm-6 footer-navigation"
			data-reactid=".0.3.0.0">

			<p class="company-name" data-reactid=".0.3.0.0.2">
				<span data-reactid=".0.3.0.0.2.0">TeamName Â© </span><span
					data-reactid=".0.3.0.0.2.1">2017</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
		<div class="col-md-6 footer-about" data-reactid=".0.3.0.3"></div>
	</div>
	</footer>
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
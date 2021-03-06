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
<link href="css/gtcorder.css" rel="stylesheet" />


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="bootstrap-table-master/src/bootstrap-table.js"></script>
<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet" />
<script src="js/gtcorder.js"></script>

</head>
<body>
	<div class="nav-container">
		<nav class="nav-default nav-1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a href="/" class="home-link"><img alt="Logo"
						src="imgs/header-icon.png" class="logo"></a>
					<ul class="menu">
						<li><a href="newSubmit.jsp">Order Book</a></li>
						<li><a href="orderhistory.jsp">Trades Display</a></li>
						<li><a href="gtcorder.jsp">GTC Order</a></li>

					</ul>
					<div class="text-right">
						<ul class="social-links">
							<li><a href="newLogin.jsp" target="_blank">Login</a></li>
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

					<div id="toolbar" class="btn-group">
						<button id="btn_edit" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Edit Order
						</button>
						<button id="btn_delete" type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Cancle Order
						</button>
					</div>
					<table id="tb_departments"></table>
				</div>
		</div>
		
		
	</div>
	<form class="edit_form">
		    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		        <div class="modal-dialog" role="document">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                    <h4 class="modal-title" id="myModalLabel">Update Order</h4>
		                </div>
		                <div class="modal-body">
		
		                    <div class="form-group">
		                        <label for="txt_price">Price</label>
		                        <input type="text" name="txt_price" class="form-control" id="txt_price" placeholder="Price">
		                    </div>
		                    <div class="form-group">
		                        <label for="txt_quantity">Quantity）</label>
		                        <input type="text" name="txt_quantity" class="form-control" id="txt_quantity" placeholder="Quantity">
		                    </div>
		                </div>
		                <div class="modal-footer">
		                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Close</button>
		                    <button type="button" id="btn_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Save</button>
		                </div>
		            </div>
		        </div>
		    </div>
		</form>
	<footer style="margin-bottom: 5px;" data-reactid=".0.3">
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
	<script async="" src="https://www.google-analytics.com/analytics.js"></script>
	<script src="/js/build-20170730.min.js"></script>
	<!-- prettyPrint-->
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'https://www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-80562000-1', 'auto');
		ga('send', 'pageview');
	</script>
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
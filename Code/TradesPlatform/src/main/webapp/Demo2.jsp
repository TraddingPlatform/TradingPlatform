<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Eventn | Node.js HTTP Microservices for ETL, Analytics
	&amp; Data Processing</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="demo/build-20170702.min.css" rel="stylesheet"
	type="text/css" media="all">
<link href="demo/css.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!-- pretty print code-->
</head>
<body>
	<div class="nav-container">
		<nav class="nav-1">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<a href="/" class="home-link"><img alt="Logo"
						src="/img/header-icon.png" class="logo"></a>
					<ul class="menu">
						<!-- 						<li><a href="/recipes">Service Recipes</a></li>
 -->
						<!-- <li class="has-dropdown"><a href="#">Docs</a>
							<ul class="subnav">
								<li><a href="/docs/getting-started-guide">Getting
										Started Guide</a></li>
								<li><a href="/docs/user-guide">User Guide</a></li>
								<li><a href="/docs/api-reference">REST API</a></li>
							</ul></li> -->
						<li><a href="submit.jsp">OrderBook</a></li>
						<li><a href="/blog">TradesDisplay</a></li>
						
					</ul>
					<div class="text-right">
						<ul class="social-links">
							<!-- <li><a href="https://app.eventn.com/signup" target="_blank">Sign
									Up</a></li> -->
							<li><a href="https://app.eventn.com/login" target="_blank">Login</a></li>
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
						<div class="col-sm-12 text-center">
							<h1 class="text-white">
								Welcom Trading Platform
								<p class="text-white super-lead"></p>
								<!-- <a href="/docs/getting-started-guide" class="btn btn-white">Learn
									More</a><a href="https://app.eventn.com/signup" target="_blank"
									class="btn btn-filled">Get Started</a> -->
							</h1>

							<div class="sign-card" id="signin_form"
								data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin">
								<h3 data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.0">Sign in</h3>
								<form class="form-sign" action="login.spring" method="post"
									data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1">
									<input type="hidden" name="_form" value="login"
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.0"><input
										type="hidden" name="organizationSlug" value=""
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.1"><input
										class="form-control" type="text" required="" name="username"
										placeholder="UserName"
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.2"><input
										class="form-control" type="password" name="password"
										required="" placeholder="Password" id="inputPassword"
										data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3">
									<button id="signin-btn"
										class="btn btn-primary btn-block btn-lg btn-signin"
										type="submit" data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4">Sign
										in</button>
									<!-- <a class="forgot-password-link" href="/resetPassword"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.5">Forgot
							password?</a> -->
								</form>
							</div>


						</div>
					</div>
				</div></li>
		</ul>
		<ol class="flex-control-nav flex-control-paging"></ol>
		</section>
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
				<span data-reactid=".0.3.0.0.2.0">TeamName © </span><span
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
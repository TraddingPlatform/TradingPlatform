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

<script type="text/javascript" async="" defer=""
	src="https://piwik.teamemo.com/piwik.js"></script>

<link type="text/css" rel="stylesheet" 
	href="<%=request.getContextPath()%>/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="css/landingpage-232d6d805d.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="css/portfolio.css" rel="stylesheet" /> 
<script src="js/login.js"></script>
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
						<!-- 						<li><a href="/recipes">Service Recipes</a></li>
 -->
						<!-- <li class="has-dropdown"><a href="#">Docs</a>
							<ul class="subnav">
								<li><a href="/docs/getting-started-guide">Getting
										Started Guide</a></li>
								<li><a href="/docs/user-guide">User Guide</a></li>
								<li><a href="/docs/api-reference">REST API</a></li>
							</ul></li> -->
						<li><a href="newSubmit.jsp">OrderBook</a></li>
						<li><a href="/blog">TradesDisplay</a></li>

					</ul>
					<div class="text-right">
						<ul class="social-links">
							<!-- <li><a href="https://app.eventn.com/signup" target="_blank">Sign
									Up</a></li> -->
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


<!-- 
							<div class="sign-card portfolio-card">
							
							
							</div> -->
							<div class="table_bg">
								<div id="container" class="myPie" style="height: 500px">
									<script type="text/javascript" src="js/echarts-all-3.js"></script>
									<script type="text/javascript" src="js/portfolio.js"></script>
	
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
				<span data-reactid=".0.3.0.0.2.0">TeamName © </span><span
					data-reactid=".0.3.0.0.2.1">2017</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
		<div class="col-md-6 footer-about" data-reactid=".0.3.0.3"></div>
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
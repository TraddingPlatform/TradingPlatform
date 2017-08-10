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
<link rel="canonical">
<link rel="alternate" hreflang="en">
<link rel="alternate" hreflang="de">
<link rel="icon">

<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/landingpage-232d6d805d.css">
<link href="css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/echarts-all-3.js"></script>
<script type="text/javascript" src="js/portfolio.js"></script>
<script type="text/javascript" async="" defer=""
	src="https://piwik.teamemo.com/piwik.js"></script>

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
	width: 400px;
	padding: 0;
	margin: 0;
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
<body style="height: 90%; margin: 0">

	<div id="container" style="height: 90%">
		<script type="text/javascript" src="js/echarts-all-3.js"></script>
		<script type="text/javascript" src="js/portfolio.js"></script>

	</div>
	<div class="with-newsletter sticked-navbar" data-reactid=".0">
		<nav class="navbar navbar-default navbar-fixed-top sticky"
			data-reactid=".0.0">
		<div class="container" data-reactid=".0.0.0">
			<div class="navbar-header" data-reactid=".0.0.0.0">
				<a class="navbar-brand crawler-logo" href="/"><b
					class="app-name">Trading Platform</b></a>
				<button class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navcol-1" data-reactid=".0;.0.0.0.1">
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
						data-reactid=".0.0.0.1.0.0:0.0">Order Book</a></li>
					<li role="presentation" data-reactid=".0.0.0.1.0.0:1"
						class="active"><a data-reactid=".0.0.0.1.0.0:1.0"
						id="link_signup"><span data-reactid=".0.0.0.1.0.0:1.0.0">
						</span><span data-reactid=".0.0.0.1.0.0:1.0.1">Trades Display</span><span
							data-reactid=".0.0.0.1.0.0:1.0.2"> </span></a></li>

					<li role="presentation" data-reactid=".0.0.0.1.0.0:2"><a
						data-reactid=".0.0.0.1.0.0:2.0"><span
							data-reactid=".0.0.0.1.0.0:2.0.0">Maket Trades</span><span
							data-reactid=".0.0.0.1.0.0:2.0.1"> </span></a></li>
					<li role="presentation" data-reactid=".0.0.0.1.0.0:3"><a
						id="link_signin" data-reactid=".0.0.0.1.0.0:3.0">Sign in</a></li>
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



	<footer style="margin-top: 10px;margin-right:20px;" data-reactid=".0.3">
	<div class="row" data-reactid=".0.3.0">
		<div class="col-md-6 col-sm-6 footer-navigation"
			data-reactid=".0.3.0.0">
			<p class="company-name" data-reactid=".0.3.0.0.2">
				<span data-reactid=".0.3.0.0.2.0">Two Hours © </span><span
					data-reactid=".0.3.0.0.2.1">2017</span>
			</p>
		</div>
		<div class="clearfix visible-sm-block" data-reactid=".0.3.0.2"></div>
	</div>
	</footer>
</body>
</html>
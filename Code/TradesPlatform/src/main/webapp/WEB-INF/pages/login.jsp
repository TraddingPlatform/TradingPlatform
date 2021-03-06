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

<link type="text/css" rel="stylesheet" href="../css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="../css/landingpage-232d6d805d.css">
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" async="" defer=""
	src="https://piwik.teamemo.com/piwik.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<!-- <script type="text/javascript">
    $(function(){

        $("#submit").click(function(){
            var userName = $("input[name='username']").val();    //获取账号
            var password1 = $("input[name='password']").val();        //获取密码

            var jsonUser = {userName:userName, password:password1};    //JSON对象
            
            var strUser = JSON.stringify(jsonUser);    //将JSON对象转变成JSON格式的字符串,
            
            $.post("/TradesPlatform/login/logindata", {json: strUser}, callback, "json");
        });

        function callback(json){
            alert(json.msg);    //显示反馈信息
            if(json.suc == 1){    //如果返回"登录成功"
                window.location.href = "index.jsp";    //跳转到后台主页
            }
        }
        
    });
</script> -->


<!-- End Piwik Code -->

<style></style>
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
						<li role="presentation" data-reactid=".0.0.0.1.0.0:2"><a
							href="https://teamemo.com/pricing"
							data-reactid=".0.0.0.1.0.0:2.0"><span
								data-reactid=".0.0.0.1.0.0:2.0.0">Make Trades</span><span
								data-reactid=".0.0.0.1.0.0:2.0.1"> </span></a></li>
						<li role="presentation" data-reactid=".0.0.0.1.0.0:3"
							class="active"><a id="link_signin"
							href="https://teamemo.com/#signin"
							data-reactid=".0.0.0.1.0.0:3.0">Sign in</a></li>
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
			<div class="col-md-12 phone-preview"
				data-reactid=".0.1.0.0.2:0.0.1.0.0">
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
							class="form-control" type="password" name="password" required=""
							placeholder="Password" id="inputPassword"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.3">
						<button id="signin-btn"
							class="btn btn-primary btn-block btn-lg btn-signin" type="submit"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.4">Sign in</button>
						<!-- <a class="forgot-password-link" href="/resetPassword"
							data-reactid=".0.1.0.0.2:0.0.1.0.0.$signin.1.5">Forgot
							password?</a> -->
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
</body>
</html>
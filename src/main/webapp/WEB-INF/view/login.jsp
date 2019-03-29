<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sdn水下传感器网络初始化最大权值路由系统</title>
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
	<h1>
		sdn水下传感器网络初始化最大权值路由系统
	</h1>
	<div class="login" style="margin-top: 70px;">

		<div class="header">
			<div class="loginheader">登&nbsp;&nbsp;&nbsp;&nbsp;录</div>
		</div>

		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="${rootPath}login" name="loginform" accept-charset="utf-8"
							id="login_form" class="loginForm" method="post">
							<input type="hidden" name="did" value="0" /> <input type="hidden"
								name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="u" name="username" maxlength="30"
										class="inputstyle" placeholder="用户名" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="password" maxlength="15"
										class="inputstyle" placeholder="密码" />
								</div>
							</div>

							<div style="padding-left: 50px; margin-top: 20px;">
								<input type="submit" value="登 录" style="width: 150px;margin-left:15px"
									class="button_blue" />
							</div>
						</form>
					</div>
					 
				</div>
				
			</div>
			
			<!--登录end-->
		</div>
		<h3 style="color: red;text-align: center;">${msg }</h3>
		
	</div>
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
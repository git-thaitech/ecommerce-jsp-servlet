<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.frontend.LoginServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Admin Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/styleLoginPage.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar"
				src="${pageContext.request.contextPath }/images/loginImage.jpg">
			<h1>Login Admin Account</h1>
			<form action="/Assignment3/admin/login" method="post">

				<p>Username</p>
				<input type="text" placeholder="Email" name="user_mail" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="password"
					required> <input type="submit" value="Login"> <a
					href="#">Forgot password?</a>
				<h5 style="color: red; text-align: center; margin: 10px;">${errorLogin}
				</h5>
			</form>
		</div>
	</div>
</body>
</html>

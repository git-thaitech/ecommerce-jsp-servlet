<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.frontend.LoginServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<link href="css/styleLoginPage.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar" src="images/loginImage.jpg">
			<h1>Login</h1>
			<form action="/Assignment3/login" method="post">

				<p>Username</p>
				<input type="text" placeholder="Email" name="user_mail" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="password"
					required> <input type="submit" value="Login"> <a
					href="#">Forgot password?</a>
					<a
					href="${pageContext.request.contextPath }/frontend/register.jsp">Register a new account?</a>
				<h5 style="color: green; text-align: center"><span>${registerSuccessful} </span></h5>
				<h5 style="color: red; text-align: center">${loginFirst} <span>${errorLogin}</span></h5>
			</form>
		</div>
	</div>
</body>
</html>

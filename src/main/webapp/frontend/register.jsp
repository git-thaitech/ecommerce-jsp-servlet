<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Account</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
	
	
<link href="css/registerForm.css" rel="stylesheet" type="text/css"/>
<!-- <link href="frontend/css/registerForm.css" rel="stylesheet" />
 -->
</head>
<body>
	<div class="container">
		<div class="regbox box">
			<img class="avatar" src="images/loginImage.jpg">
			<h1>Register Form</h1>
			<form action="http://localhost:8080/Assignment3/register"
				method="post">

				<p>Email</p>
				<input type="text" placeholder="email" name="user_mail" required>
				<p>Password</p>
				<input type="password" placeholder="password" name="password"
					required>
				<p>Your name</p>
				<input type="text" placeholder="name" name="full_name" required>
				<p>Your address</p>
				<input type="text" placeholder="address" name="user_address"
					required>
				<p>Phone number</p>
				<input type="text" placeholder="phone" name="user_phone" required>

				<input type="submit" value="Submit"> 
				<h5 style="color: red; text-align: center;">${sessionScope.existedAccount}</h5>
				<a href="${pageContext.request.contextPath }/frontend/login.jsp">You
					have an account already!</a>
				

			</form>
		</div>
	</div>
</body>
</html>
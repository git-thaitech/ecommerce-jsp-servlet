<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Orders Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/style.css"
	rel="stylesheet" type="text/css">

</head>

<body style="font-family: 'Open Sans', sans-serif">
	<%@ include file="header.jsp"%>





	
	


	<div class="table-responsive" style="padding: 50px 100px;">
	<h4><a href="${pageContext.request.contextPath }/admin/users?action=createuser"><button>Create a new user</button></a></h4>
		<table class="table">
			<tr>
				<th>User mail</th>
				<th>Password</th>
				<th>Full name</th>
				<th>User address</th>
				<th>User phone</th>
				<th>Account role</th>
			</tr>
			<c:forEach var="users" items="${userList}">
				<tr>
					<td>${users.user_mail}</td>
					<td>${users.password }</td>
					<td>${users.full_name }</td>
					<td>${users.user_address }</td>
					<td>${users.user_phone }</td>
					<td>${users.account_role}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
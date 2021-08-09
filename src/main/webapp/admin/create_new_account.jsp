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
	<div>
		<form action="register" method="post">
			Email: <input type="email"> <input> <input> <input> <input>
			<input>
		</form>

	</div>
</body>
</html>
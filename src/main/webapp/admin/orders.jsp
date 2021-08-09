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
		<table class="table">
			<tr>
				<th>Remove</th>
				<th>See Detail</th>
				<th>Order ID</th>
				<th>User mail</th>
				<th>Order Status</th>
				<th>Order Date</th>
				<th>Order Address</th>
				<th>Total</th>
			</tr>
			<c:forEach var="orders" items="${orders}">
				<tr>
					<td><a
						href="${pageContext.request.contextPath }/admin/orders?action=remove&id=${orders.order_id }"
						onclick="return confirm('Are you sure?')">Remove</a></td>
					<td><a
						href="${pageContext.request.contextPath }/admin/orders_detail?id=${orders.order_id }"
						onclick="return confirm('See detail now?')">Order detail</a></td>
					<td>${orders.order_id}</td>
					<td>${orders.user_mail }</td>
					<td>${orders.order_status }</td>
					<td>${orders.order_date }</td>
					<td>${orders.order_address }</td>
					<td>${orders.total}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Check out</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="font-family: 'Open Sans', sans-serif">
	<%@ include file="header.jsp"%>
	<div
		style="display: flex; width: 90%; margin: 0 auto; margin: 20px 0px;">
		<div style="width: 80%; margin: 0 auto; padding: 40px 70px;" class="table-responsive">
			<table class="table">
				<tr>
					<th>Option</th>
					<th>Id</th>
					<th>Name</th>
					<th>Photo</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Sub Total</th>
				</tr>
				<c:set var="total" value="0"></c:set>
				<c:forEach var="item" items="${sessionScope.cart}">
					<c:set var="total"
						value="${total + item.product.product_price * item.quantity }"></c:set>
					<tr>
						<td align="center"><a
							href="${pageContext.request.contextPath }/checkout?action=remove&id=${item.product.product_id }"
							onclick="return confirm('Are you sure?')">Remove</a></td>
						<td>${item.product.product_id }</td>
						<td>${item.product.product_name }</td>
						<td><img src="${item.product.product_img_source }"
							width="120"></td>
						<td>${item.product.product_price }</td>
						<td>${item.quantity }</td>
						<td>${item.product.product_price * item.quantity }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6" align="right">Total</td>
					<td>${total }</td>
				</tr>
			</table>
		</div>
		<br>

		<div style="width: 20%; margin: 0 auto; padding: 40px 0px; text-align: center;">
			<form action="/Assignment3/checkout" method="get">
				<!-- Address: <input type="text" name="orderadress" class="form-control"/> -->
				<br>
				<input type="hidden" name="total" value="${total }"/> <br> <input
					type="submit" value="Place order now!" class="btn-warning">

			</form>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
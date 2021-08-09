<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<title>Cart Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body style="font-family: 'Open Sans', sans-serif">
	<%@ include file="header.jsp"%>
	<h4 style="color:red; text-align: center">${cartIsEmpty }</h4>
	<div class="table-responsive" style="padding: 50px 100px;">
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
					<td><a
						href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.product_id }"
						onclick="return confirm('Are you sure?')">Remove</a></td>
					<td>${item.product.product_id }</td>
					<td>${item.product.product_name }</td>
					<td><img src="${item.product.product_img_source }" width="120">
					</td>
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
	<DIV style="text-align: center; padding: 0px 0px 50px;">
		<a href="${pageContext.request.contextPath }/products"><button class="btn-primary">Continue
				Shopping</button></a> <a
			href="${pageContext.request.contextPath }/checkout?action=buy"><button class="btn-warning">BUY</button></a>
	</DIV>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
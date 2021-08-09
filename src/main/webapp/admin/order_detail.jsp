<%@ page language="Java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Orders ${order.order_id}</title>
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
	
	<div style="color: green; text-align: center;">
	<h3>ORDER ID: ${order.order_id }</h3>
	<h3>CUSTOMER: ${order.user_mail }</h3>
	</div>
	<div class="table-responsive" style="padding: 50px 100px;">
		<table class="table">
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Describe</th>
				<th>Photo</th>
				<th>Quantity</th>
				<th>Brand</th>
			</tr>
			<c:forEach var="items" items="${itemList}">
				<tr>
					<td>${items.product.product_id }</td>
					<td>${items.product.product_name }</td>
					<td>${items.product.product_des }</td>
					<td><img src="${items.product.product_img_source }" width="100px"/></td>
					<td>${items.quantity }</td>
					<td>${items.product.product_brand }</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Products Page</title>
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
		<h4>
			<a href="${pageContext.request.contextPath }/admin/users?action=addproduct"><button>Add a new product</button></a>
		</h4>
		<table class="table">
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Photo</th>
				<th>Type</th>
				<th>Brand</th>
				<th>Quantity</th>
			</tr>
			<c:forEach var="products" items="${proList}">
				<tr>

					<td>${products.product_id}</td>
					<td>${products.product_name }</td>
					<td>${products.product_des }</td>
					<td>${products.product_price }</td>
					<td><img src="${products.product_img_source }" width=100px /></td>
					<td>${products.product_type}</td>
					<td>${products.product_brand }</td>
					<td>${products.product_quantity}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>



<!-- private String ;
	private String ;
	private Float ;
	private String ;
	private String ;
	private String ;
	private Integer ; -->
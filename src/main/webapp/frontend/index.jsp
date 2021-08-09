<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <meta http-equiv="refresh" content="1;URL=/Assignment3/ProductsServlet">
 -->
<html>
<head>
<meta charset="utf-8">
<title>HOME</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="font-family: 'Open Sans', sans-serif">
	<%@ include file="header.jsp"%>


	<div class="row">

		<div class="leftcolumn">
			<c:forEach var="products" items="${productsList}">

				<div class="box">


					<div class="img-box">
						<img src="${products.product_img_source }" alt="" />
					</div>

					<div class="detail-box">
						<h6>${products.product_name }</h6>
						<h4>
							Price: $ <span> ${products.product_price } </span>
						</h4>
						<p>

							<a
								href="${pageContext.request.contextPath}/cart?&action=addtocart&id=${products.product_id }">
								<button class="btn">Add to Cart</button>
							</a>


						</p>
					</div>

					<div class="new">
						<span> New </span>
					</div>

				</div>
			</c:forEach>
		</div>



		<div class="rightcolumn">

			<c:forEach var="item" items="${sessionScope.cart }">
				<c:set var="totalQuantityInCart"
					value="${totalQuantityInCart + item.quantity }" />
			</c:forEach>
			
			<h3>Items in Cart: ${totalQuantityInCart}</h3>
			
			<a href="cart">
				<button>Go to Cart</button>
			</a> <i class="fa fa-shopping-cart"></i>
			<p style="color: green">${placeOrderSuccessFully }</p>
			<p style="color: red">${overStock }</p>
		</div>
	</div>
</body>
</html>
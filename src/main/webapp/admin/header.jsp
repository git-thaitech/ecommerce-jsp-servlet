<div>
	<div class="header">
		<h1>eCommerce Website</h1>
		<p>Admin Page</p>
	</div>
	
	<div class="topnav">
		<a href="${pageContext.request.contextPath }/admin/orders">Orders</a>
		<a href="${pageContext.request.contextPath }/admin/users">Users</a>
		<a href="${pageContext.request.contextPath }/admin/products">Products</a>
		<span href="#" style="float: right; color: white">
		
		
		<c:if test="${sessionScope.adminSession.user_mail != null }">  
   			<a><c:out value="${sessionScope.adminSession.full_name }"/></a>
   			<a href="${pageContext.request.contextPath }/admin/logout">LOG OUT</a>
		</c:if>
		
		</span>
	</div>
</div>
<div>
	<div class="header">
		<h1>eCommerce Website</h1>
		<p>logo</p>
	</div>
	
	<div class="topnav">
		<a href="/Assignment3/index.jsp">Home</a>
		<a href="#">Products</a>
		<span href="#" style="float: right; color: white">
		
		
		<c:if test="${sessionScope.userSession.user_mail != null }">  
   			<a><c:out value="${sessionScope.userSession.full_name }"/></a>
   			<a href="${pageContext.request.contextPath }/logout"><c:out value="LOG OUT"/></a>
		</c:if>  
		<c:if test="${sessionScope.userSession.user_mail == null }">  
   			<a href="${pageContext.request.contextPath }/frontend/login.jsp"><c:out value="LOGIN"/></a>
		</c:if> 
		
		</span>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="dao.*"%>
<%@ page import="model.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Success</title>
</head>
<body>

 <jsp:useBean id="user"
  class="model.Users" scope="session" />
	<%user.setAccount_role(2);%>
 <jsp:setProperty property="*" name="user" />

 <%
  UsersDAO userDao = new UsersDAO();
  int status = userDao.create(user);
  if (status > 0) {
   out.print("You are successfully registered");
  }
 %>
</body>
</html>
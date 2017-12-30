<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Log Out</title>
      <link rel="stylesheet" href="style.css" />
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include> 
 	
 	  Are you sure you want to log out?
      <form method="POST" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value= "Submit" />
      </form>
   </body>
</html>
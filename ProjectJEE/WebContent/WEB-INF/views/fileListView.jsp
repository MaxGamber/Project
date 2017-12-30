<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Files List</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<table border="1" cellpadding="5" cellspacing="1">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Composer</th>
			<th>Type</th>
			<th>Price</th>
			<%
				if (null != session.getAttribute("loginedUser")) {
			%>
			<th>Edit</th>
			<th>Delete</th>
			<%
				}
			%>
		</tr>
		<c:forEach items="${fileList}" var="file">
			<tr>
				<td>${file.id}</td>
				<td>${file.name}</td>
				<td>${file.composer}</td>
				<td>${file.type}</td>
				<td>${file.price}</td>
				<%
					if (null != session.getAttribute("loginedUser")) {
				%>
				<td><a href="editFile?id=${file.id}">Edit</a></td>
				<td><a href="deleteFile?id=${file.id}">Delete</a></td>
				<%
					}
				%>
			</tr>
		</c:forEach>
	</table>
	<%
		if (null != session.getAttribute("loginedUser")) {
	%>
	<a href="createFile">Create File</a>
	<%
		}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create File</title>
      <link rel="stylesheet" href="style.css" />
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
      
      <form method="POST" action="${pageContext.request.contextPath}/createFile">
         <table border="0">
            <tr>
               <td>ID</td>
               <td><input type="text" name="id" value="${file.id}" /></td>
            </tr>
            <tr>
               <td>Name</td>
               <td><input type="text" name="name" value="${file.name}" /></td>
            </tr>
            <tr>
               <td>Composer</td>
               <td><input type="text" name="composer" value="${file.composer}" /></td>
            </tr>
            <tr>
               <td>Type</td>
               <td><input type="text" name="type" value="${file.type}" /></td>
            </tr>
            <tr>
               <td>Price</td>
               <td><input type="text" name="price" value="${file.price}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="filesList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>  
   </body>
</html>
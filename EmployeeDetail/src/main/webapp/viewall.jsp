<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employee List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>ID </th><th>Name</th><th>Role</th><th>Contact</th><th>Email</th></tr>  
   <c:forEach var="dto" items="${list}">   
   <tr>  
   <td>${dto.getId()}</td>  
   <td>${dto.getName()}</td>  
   <td>${dto.getRole()}</td>  
   <td>${dto.getContact()}</td>
   <td>${dto.getEmail()}</td>    
   </tr>  
   </c:forEach>  
</table>  
   <br/>   

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" width="50%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Designation</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
	<c:forEach var="emp" items="${list}">	
		<tr>
			<td>${emp.id}</td>
			<td>${emp.fname}</td>
			<td>${emp.lname}</td>
			<td>${emp.designation}</td>
			<td>${emp.salary}</td>
			<td><a href="editEmp/${emp.id}">Edit</a></td>
			<td><a href="deleteEmp/${emp.id}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</br>
	   <a href="addEmployee">Add New Employee</a>  
	
</body>
</html>
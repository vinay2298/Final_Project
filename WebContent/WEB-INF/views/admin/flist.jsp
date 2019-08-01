<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty List</title>
<style>
table, th, td {
  border: 1px solid black;  
  text-align:center;
}
td , th{
width:150px;
}
button {
  background-color: #14fc03;
  border: none;
  color: white;
  padding: 5px 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius:4px;
}

</style>
</head>
<body>
<h1><a href="home"><button>Home</button></a></h1>
	<h3 align="left">${requestScope.msg}</h3>
	<div align="center">
	<h3 align="center">Faculty List</h3>
	<table>
		<th><b>Faculty ID</b></th>
		<th><b>Faculty Name</b></th>
		<th><b>Faculty Phone</b></th>
		<th><b>Faculty Email</b></th>
		<th><b>Assigned Modules</b></th>
	</table>
	<c:forEach var="faculty" items="${requestScope.faculty_list}">
		<table>
			<tr>
				<td>${faculty.facultyId}</td>
				<td>${faculty.facultyName}</td>
				<td>${faculty.facultyPhone}</td>
				<td>${faculty.facultyEmail}</td>
				<td><a href="<spring:url value='/admin/assignModule?id=${faculty.facultyId}'/>"><button>Assigned Modules</button></a></td>
				<%-- <td><a href="admin/update?id=${cust.courseId}">update</a></td> --%>
			</tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
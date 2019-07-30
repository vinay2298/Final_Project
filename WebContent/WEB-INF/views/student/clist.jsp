<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;  
  text-align:center;
}
td , th{
width:100px;
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
	<h3 align="left">${msg}</h3>
	<div align="center">
	<h3 align="center">Course List</h3>
	<table>
	<th><b>Course ID</b></th>
		<th><b>Course Name</b></th>
		<th><b>Course Strength</b></th>
		<th><b>Course Duration</b></th>
		<th><b>Modules</b></th>		
	</table>
	<c:forEach var="cust" items="${requestScope.course_list}">
		<table>
			<tr>
				<td>${cust.courseId}</td>
				<td>${cust.courseName}</td>
				<td>${cust.courseStrength}</td>
				<td>${cust.duration}</td>
				<td><a href="<spring:url value='/student/module?id=${cust.courseId}'/>"><button>Module List</button></a></td>
				<%-- <td><a href="<spring:url value='/student/faculty?id=${cust.courseId}'/>">Faculty List</a></td> --%>
				<%-- <td><a href="<spring:url value='/a/student?id=${cust.courseId}'/>">Student List</a></td> --%>
				<%-- <td><a href="admin/update?id=${cust.courseId}">update</a></td> --%>
			</tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
<style>
table, th, td {
  border: 1px solid black;  
  text-align:center;
}
td , th{
width:200px;
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
	<h3 align="center">Student List</h3>
	<div align="center">
	<table>
		<th><b>Student PRN</b></th>
		<th><b>Student Name</b></th>
		<th><b>Student Email</b></th>
		<th><b>Student DOB</b></th>
		<th><b>Student Mobile</b></th>
		
	</table>
	<c:forEach var="student" items="${requestScope.student_list}">
		<table>
			<tr>
				<td>${student.studentPrn}</td>
				<td>${student.studentName}</td>
				<td>${student.studentEmail}</td>
				<td>${student.dob}</td>
				<td>${student.studentMobile}</td>
				<%-- <td><a href="admin/update?id=${cust.courseId}">update</a></td> --%>
			</tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
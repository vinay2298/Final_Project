<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Module List</title>
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
	<h3 align="left">${msg}</h3>
	<div align="center">
	<h3 align="center">Module List</h3>
	<table>
		<th><b>Module ID</b></th>
		<th><b>Module Name</b></th>
		<th><b>Start Date</b></th>
		<th><b>End Date</b></th>
		<th><b>Status</b></th>
		<th><b>Add Topic</b></th>
	</table>
	<c:forEach var="module" items="${requestScope.module_list}">
		<table>
			<tr>
				<td>${module.moduleId}</td>
				<td>${module.moduleName}</td>
				<td>${module.startDate}</td>
				<td>${module.endDate}</td>
				<td>${module.status}</td>
				<td><a href="<spring:url value='/admin/topic?id=${module.moduleId}'/>"><button>Add Topic</button></a></td>
				<%-- <td><a href="admin/update?id=${cust.courseId}">update</a></td> --%>
			</tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
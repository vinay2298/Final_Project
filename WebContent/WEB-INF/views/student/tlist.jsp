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
	<div align="center">
	<h3 align="center">Topic List</h3>
	<table>
		<th><b>Topic ID</b></th>
		<th><b>Topic Name</b></th>
		<th><b>Content List</b></th>
	</table>
	<c:forEach var="topic" items="${requestScope.topic_list}">
		<table>
			<tr>
				<td>${topic.topicId}</td>
				<td>${topic.topicName}</td>
				<td><a href="<spring:url value='/student/content?id=${topic.topicId}'/>"><button>Content List</button></a></td>
				<%-- <td><a
					href="<c:url value='/student/download?id=${topic.topicId}'/>">DownLoad Data</a></td>
				<td><a href="<spring:url value='/faculty/remove?id=${module.moduleId}'/>">Remove</a></td>
			
				<td><a href="admin/update?id=${cust.courseId}">update</a></td>
			 --%></tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
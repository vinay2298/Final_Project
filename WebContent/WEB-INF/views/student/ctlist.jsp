<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Content List</title>
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
	<h3 align="center">Content List</h3>
	<table>
		<th><b>Content Id</b></th>
		<th><b>Content Name</b></th>
		<th><b>DownLoad</b></th>
	</table>
	<c:forEach var="content" items="${requestScope.content_list}">
		<table>
			<tr>
				<td>${content.contentId}</td>
				<td>${content.contentName}</td>
				<td><a href="<c:url value='/student/download?id=${content.contentId}'/>"><button>DownLoad Data</button></a></td>
				</tr>
		</table>		
	</c:forEach>
	</div>
</body>
</html>
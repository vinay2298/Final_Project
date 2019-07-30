<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
form{
	align:center;
	background-color:#34a8eb;
	border-radius:3px;
	margin-left:510px;
	margin-right:510px;
	margin-top:100px;
}
table{
	border-radius:3px;
	color:white;
	font-weight:bold;
}
input[type=submit]{
  background-color: Grey;
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
input[type=text]{
	border-radius:3px;
}

</style>

</head>
<body>
	<h3 align="center">${mesg}</h3>
	<form:form method="post" modelAttribute="topic">
		<h1 align="center">ADD TOPIC</h1>
		<table>
			<tr>
				<td>Enter Topic Name</td>
				<td><form:input path="topicName" /></td>
			</tr>
			<tr>
				<td>Enter Topic Path</td>
				<td><form:input path="path" /></td>
			</tr>
			<tr>	
			<td>Module Id</td>
				<td><input type="number" name="id" value="${requestScope.module_dtls.moduleId}"></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="ADD TOPIC" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
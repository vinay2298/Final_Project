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
	margin-left:480px;
	margin-right:480px;
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
	<form:form method="post" modelAttribute="faculty">
		<h1 align="center">ADD FACULTY</h1>
		<table>
			<tr>
				<td>Enter Faculty Name</td>
				<td><form:input path="facultyName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Faculty Email</td>
				<td><form:input type="email" path="facultyEmail" required="required"/></td>
			</tr>
			
			<tr>
				<td>Enter Faculty Phone</td>
				<td><form:input path="facultyPhone" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Faculty Password</td>
				<td><form:input path="facultyPassword" value="pass123" required="required"/></td>
			</tr>
			<tr>
				<td>Enter the Course Id</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td></td><td align="center"><input type="submit" value="ADD Faculty" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
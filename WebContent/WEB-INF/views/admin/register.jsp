<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
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
input[type=text],[type=email],[type=password]{
	border-radius:3px;
}
</style>

</head>
<body>
	<h3 align="center">${mesg}</h3>
	<div align="center">
	
	<form:form method="post" modelAttribute="coordinator">
		<h3>Coordinator Registration</h3>
		<table>
			<tr>
				<td>Enter Coordinator Name</td>
				<td><form:input path="coordinatorName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Coordinator Email</td>
				<td><form:input type="email" path="coordinatorEmail" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Mobile</td>
				<td><form:input path="coordinatorMobile" required="required" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:input type="password" path="password" required="required"/></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="REGISTER" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>
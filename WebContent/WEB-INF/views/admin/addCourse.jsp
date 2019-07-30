<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD COURSE</title>
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

/* div{
	background-color:#34a8eb;
	margin-top:5px;
	margin-left:2px;
	margin-right:2px;
	border-radius:8px;
	height:100px;
	text-align:center;
	text-color:white;
} */
</style>
</head>
<body>
	<h3 align="center">${mesg}</h3>
	<div>
	<form:form method="post" modelAttribute="course">
		<h1 align="center">ADD COURSE</h1>
		<table >
			<tr>
				<td>Enter Course Name</td>
				<td><form:input path="courseName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Course Duration</td>
				<td><form:input path="duration" required="required"/></td>
			</tr>
			
			<tr>
				<td>Enter course Strength</td>
				<td><form:input path="courseStrength" required="required"/></td>
			</tr>
			<tr>
				<td>Enter the Coordinator Id</td>
				<td><input type="number" name="id" value="${sessionScope.admin_dtls.coordinatorid}" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="ADD COURSE" name="submit"/></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>
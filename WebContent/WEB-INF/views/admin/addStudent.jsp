<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD STUDENT</title>
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
input[type=date]{
	border-radius:3px;
	width:170px;
}
</style>
</head>
<body>
	<h3 align="center">${mesg}</h3>
	<form:form method="post" modelAttribute="student">
		<h1 align="center">ADD STUDENT</h1>
		<table>
			<tr>
				<td>Enter Student PRN</td>
				<td><form:input path="studentPrn" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student Name</td>
				<td><form:input path="studentName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student Email</td>
				<td><form:input type="email" path="studentEmail" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student DOB</td>
				<td><form:input type="date" path="dob" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student Mobile</td>
				<td><form:input path="studentMobile" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student Address</td>
				<td><form:input path="studentAddress" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Student Password</td>
				<td><form:input path="password" value="pass123" required="required"/></td>
			</tr>
			<tr>
				<td>Enter the Course Id</td>
				<td><input type="number" name="id" value="${requestScope.course_dtls.courseId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="ADD STUDENT" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
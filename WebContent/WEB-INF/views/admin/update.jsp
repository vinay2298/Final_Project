<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Course Details</title>
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
input[type=text],[type=password]{
	border-radius:3px;
}
</style>
</head>
<body>
	<div align="center">
	<form:form method="post" modelAttribute="course">
	<h3>Update Course Details</h3>
		<table >
			<tr>
				<td>Course ID</td>
				<td><form:input path="courseId" value="${sessionScope.course_dtls.courseId}" readonly="true"/></td>
			</tr>
			<tr>
				<td>Course Name</td>
				<td><form:input path="courseName" value="${sessionScope.course_dtls.courseName}" readonly="true"/></td>
			</tr>
			<tr>
				<td>Course Duration</td>
				<td><form:input path="duration" value="${sessionScope.course_dtls.duration}" required="required"/></td>
			</tr>
			
			<tr>
				<td>Course Strength</td>
				<td><form:input path="courseStrength" value="${sessionScope.course_dtls.courseStrength}" required="required"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE COURSE" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>
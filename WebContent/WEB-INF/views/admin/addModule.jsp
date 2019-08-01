<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD MODULE</title>
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
	width:170px;
}
input[type=date]{
	border-radius:3px;
	width:170px;
}
input[type=number]{
	border-radius:3px;
	width:170px;
}

</style>

</head>
<body>
	<h3 align="center">${requestScope.mesg}</h3>
	<form:form method="post" modelAttribute="modules">
		<h1 align="center">ADD MODULE</h1>
		<table>
			<tr>
				<td>Enter Module Name</td>
				<td><form:input path="moduleName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Start Date</td>
				<td><form:input type="date" path="startDate" required="required"/></td>
			</tr>
			
			<tr>
				<td>Enter End Date</td>
				<td><form:input type="date" path="endDate" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Status</td>
				<td><form:input path="status" required="required"/></td>
			</tr>
			<tr>
				<td>Enter Faculty ID </td>
				<td><input type="number" name="fid" required="required"></td>
				<td>
			</tr>
			<tr>
				<td>Enter the Course Id</td>
				<td><input type="number" name="id" required="required"></td>
			</tr>
			<tr>
				<td></td><td align="center"><input type="submit" value="ADD MODULE" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
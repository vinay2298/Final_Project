<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
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
	<div align="center">
	<form method="post">
	<h1 align="center">Change Password</h1>
		<table>
			<tr>
				<td>Enter the Old Password</td>
				<td><input type="password" name="oldpassword" required="required"/></td>
			</tr>
			<tr>
				<td>Enter the New Password</td>
				<td><input type="password" name="newpassword" required="required"/></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" name="UPDATE"/></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
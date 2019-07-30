<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login</title>
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
}
div{
	background-color:#34a8eb;
	margin-top:5px;
	margin-left:2px;
	margin-right:2px;
	border-radius:8px;
	height:100px;
	text-align:center;
	color:white;
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
	<div>
		<h1 align="center">CDAC MANAGEMENT SYSTEM</h1>
	</div>
	<form method="post">
		<h1 align="center">Student Login</h1>
		<table>
			<tr>
				<td><b>Enter the PRN</b></td>
				<td><input type="text" name="prn" required="required"/></td>
			</tr>
			<tr>
				<td><b>Enter the Password</b></td>
				<td><input type="password" name="password" required="required"/></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
</body>
</html>
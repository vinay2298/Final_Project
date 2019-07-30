<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<style type="text/css">
form{
	align:center;
	background-color:#34a8eb;
	border-radius:3px;
	margin-left:520px;
	margin-right:520px;
	margin-top:100px;
}
table{
	border-radius:3px;
}
div{
	background-color:#34a8eb;
	margin-top:5px;
	margin-left:2px;
	margin-right:2px;
	border-radius:8px;
	height:100px;
	text-align:center;
	text-color:white;
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
		<h1 align="center"><b><font color="white">CDAC MANAGEMENT SYSTEM</font></b></h1>
	</div>
	<h3 align="left">${status}</h3>
	<form method="post">
		<h1 align="center">ADMIN LOGIN</h1>	
		<table>
			<tr>
				<td><b>Enter Email</b></td>
				<td><input type="text" name="email" required="required"/></td>
			</tr>
			<tr>
				<td><b>Enter Password</b></td>
				<td><input type="password" name="password" required="required"/></td>
			</tr>
			<tr>
				<td></td><td align="left"><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
</body>
</html>
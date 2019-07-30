<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<style>
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
div#login{
		width:300px;
		height:170px;
		margin-top:100px;
		margin-left:550px;
		margin-righth:550px;
		background-color:#34a8eb;
		text-align:center;
		}
button {
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
  width:170px;
}
button#reg{
  background-color: #34a8eb;
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
  width:170px;
}

</style>
</head>
<body>
<div>
<h1 align="center">CDAC MANAGEMENT SYSTEM</h1>
<h3 align="right"><a href="admin/register" ><button id="reg">Register</button></a></h3>
</div>
<div id="login" align="center">
<a href="student/login"><button>Student Login</button></a><br><br>
<a href="faculty/login"><button>Faculty Login</button></a><br><br>
<a href="admin/login"><button>Admin Login</button></a><br><br>

</div>
</body>
</html>
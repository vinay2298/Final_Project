<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty HOME</title>
<style type="text/css">
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
	button#det{
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
}
div#fct{
		width:300px;
		height:80px;
		margin-top:100px;
		margin-left:550px;
		margin-righth:550px;
		background-color:#34a8eb;
		text-align:center;
		}
	
</style>

</head>
<body>
<div>
	<h1>CDAC MANAGEMENT SYSTEM</h1>
	<h4 align="right">Welcome ${sessionScope.faculty_dtls.facultyName}|<a href="update"><button id="det">Change Password</button></a>| <a href="logout"><button id="det">LOGOUT</button></a></h4>
</div>
<h3>${msg}</h3>
<h3>${status}</h3>
<div id="fct">
<h3>Welcome</h3>
<a href="moduleList"><button>My Modules</button></a>
</div>
</body>
</html>
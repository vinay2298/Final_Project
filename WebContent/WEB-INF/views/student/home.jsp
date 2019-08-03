<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Home</title>
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
div#std{
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
<h1 align="center">CDAC MANAGEMENT SYSTEM</h1>
<h4 align="right">Welcome ${sessionScope.student_dtls.studentName} |<a href="update"><button id="det"><b>Change Password</b></button></a> | <a href="logout"><button id="det"><b>LOGOUT</b></button></a></h4>
</div>	
<h3>${status}</h3>
<div id="std" align="center">
<h3 align="center">Welcome to Student Home Page</h3>
<a href="course"><button>My Course</button></a>
</div> 
 </body>
</html>
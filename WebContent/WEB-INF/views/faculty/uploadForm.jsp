<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div{
		width:500px;
		height:200px;
		margin-top:100px;
		margin-left:550px;
		margin-righth:550px;
		background-color:#34a8eb;
		text-align:center;
		color:white;
		}	
input[type=submit],[type=file]{
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
button {
  background-color: #14fc03;
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
</style>
</head>
<body>
<h1><a href="home"><button>Home</button></a></h1>
<div id="center">
<h1 align="center">File Upload</h1>
<form method="post" enctype="multipart/form-data">
		<b>Choose File to Upload</b> :    <input type="file" name="contents" /><br><br>
		<input type="submit" value="Upload File" />
	</form>
</div>
</body>
</html>
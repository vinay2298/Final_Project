<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
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
div#add{
		width:300px;
		height:270px;
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

</style>
</head>

<body >
<div>
<h1 align="center">CDAC MANAGEMENT SYSTEM</h1>
<h4 align="right">Welcome ${sessionScope.admin_dtls.coordinatorName} | <a href="updatePassword"><button id="det"><b>Change Password</b></button></a>|<a href="logout"><button id="det"><b>LOGOUT</b></button></a></h4>
</div>	
<h1 align="center">Welcome to Admin Home Page</h1>
<h3 align="left">${requestScope.status}</h3>
<h3 align="left">${requestScope.msg}</h3>
<h3 align="left">${requestScope.passmsg}</h3>
<div id="add">
	<b><a href ="addCourse"><button>Add Course</button></a><br><br>
	<a href ="addStudent"><button>Add Student</button></a><br><br>
	<a href ="addModule"><button>Add Module</button></a><br><br>
	<a href ="addFaculty"><button>Add Faculty</button></a><br><br>
	<a href = "clist"><button>Course List</button></a><br></b><br>
</div>
</body>
</html>
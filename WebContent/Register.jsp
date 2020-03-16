<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div style="text-align:center">
 <a href="Login.jsp">Login</a>
</div>
	<form action="Register" method="post">
		<label>First Name :<input type="text" name="fname" placeholder="first name"></label><br>
		<label>Last Name :<input type="text" name="lname" placeholder="last name"></label><br>
		<label>Email :<input type="email" name="email" placeholder="email"></label><br>
		<label>Password :<input type="password" name="password" placeholder="password"></label><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../CSS/style.css">
<title>Insert title here</title>
</head>
<body>
<form action="Home" method="post">

<div class="header">
<h1>WELCOME "USER"</h1>
</div>
<br>
    <div style="float:right">
    <a style= "margin-right:10px" href="url">Profile</a>
    <a href="url">Logout</a>
    </div>
    <br>
    <br>
    <br>
   
    <tag:forEach var="post" items="${posts}">
    
    <div style="width:210px; height:210px ;border-width:2px ;border-style:solid">
		<div>
			<label for="name">${post.getUser_id()} <br></label>
			<label for="date" style="margin-left:50px">${post.getDate()} <br></label>
		</div>
		<br>
		<div>
			 <textarea class="form-control" rows="8" id="comment">${post.getText()} </textarea>
		</div>
		<br>
		<div>
			<label style= "margin-right:50px"><a href="url" >Like</a></label>
			<label><a href="url">Save</a></label>
		</div>
	</div>
   
    
    </tag:forEach>
    
    
    
 </form>


</body>
</html>